/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd.QuanLyHoaDon;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class QuanLyHoaDonBUS {

    private ArrayList<HoaDon> dshd = new ArrayList<>();
    private QuanLyHoaDonDAO qlhdDAO = new QuanLyHoaDonDAO();

    public QuanLyHoaDonBUS() {
        dshd = qlhdDAO.readDB();
    }

    public ArrayList<HoaDon> readDB() {
        dshd = qlhdDAO.readDB();
        return dshd;
    }

    public ArrayList<HoaDon> search(String value1, String value2) {
        ArrayList<HoaDon> result = qlhdDAO.search(value1, value2);
        return result;
    }
    
    private Boolean add(HoaDon hd) {
        Boolean ok = qlhdDAO.add(hd);
        
        if (ok) {
            dshd.add(hd);
        }
        return ok;
    }

    public Boolean add(String mahd, String manv, String makh, LocalDateTime ngaygiolap, double tongtien) {
        HoaDon hd = new HoaDon(mahd, manv, makh, ngaygiolap, tongtien);
        return add(hd);
    }

    public Boolean delete(String mahd) {
        Boolean ok = qlhdDAO.delete(mahd);
        
        if (ok) {
            for (int i = (dshd.size() - 1); i >= 0; i--) {
                if (dshd.get(i).getMaHD().equals(mahd)) {
                    dshd.remove(i);
                }
            }
        }
        return ok;
    }

    public Boolean update(String mahd, String manv, String makh, LocalDateTime ngaygiolap, double tongtien) {
        Boolean ok = qlhdDAO.update(mahd, manv, makh, ngaygiolap, tongtien);
        
        if (ok) {
            dshd.forEach((hd) -> {
                if (hd.getMaHD().equals(mahd)) {
                    hd.setMaNV(manv);
                    hd.setMaKH(makh);
                    hd.setNgayGioLap(ngaygiolap);
                    hd.setTongTien(tongtien);
                }
            });
        }    
        return ok;
    }

    public Boolean updateTongTien(String mahd, double tongtien) {
        Boolean ok = qlhdDAO.updateTongTien(mahd, tongtien);
        
        if (ok) {
            dshd.forEach((hd) -> {
                if (hd.getMaHD().equals(mahd)) {
                    hd.setTongTien(tongtien);
                }
            });
        }
        return ok;
    }

}
