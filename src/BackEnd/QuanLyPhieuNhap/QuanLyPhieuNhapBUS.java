/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd.QuanLyPhieuNhap;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class QuanLyPhieuNhapBUS {

    private ArrayList<PhieuNhap> dspn = new ArrayList<>();
    private QuanLyPhieuNhapDAO qlpnDAO = new QuanLyPhieuNhapDAO();

    public QuanLyPhieuNhapBUS() {
        dspn = qlpnDAO.readDB();
    }

    public ArrayList<PhieuNhap> readDB() {
        dspn = qlpnDAO.readDB();
        return dspn;
    }

    public ArrayList<PhieuNhap> search(String value1, String value2) {
        ArrayList<PhieuNhap> result = qlpnDAO.search(value1, value2);
        return result;
    }

    public Boolean add(PhieuNhap pn) {
        Boolean ok = qlpnDAO.add(pn);

        if (ok) {
            dspn.add(pn);
        }
        return ok;
    }

    public Boolean add(String mapn, String mancc, String manv, LocalDateTime ngaygionhap, double tongtien) {
        PhieuNhap pn = new PhieuNhap(mapn, mancc, manv, ngaygionhap, tongtien);
        return add(pn);
    }
    
    public Boolean delete(String mapn) {
        Boolean ok = qlpnDAO.delete(mapn);
        
        if (ok) {
            for (int i = (dspn.size() - 1); i >= 0; i--) {
                if (dspn.get(i).getMaPN().equals(mapn)) {
                    dspn.remove(i);
                }
            }
        }
        return ok;
    }
    
    public Boolean update(String mapn, String mancc, String manv, LocalDateTime ngaygionhap, double tongtien) {
        Boolean ok = qlpnDAO.update(mapn, mancc, manv, ngaygionhap, tongtien);
        
        if (ok) {
            dspn.forEach((pn) -> {
                if (pn.getMaPN().equals(mapn)) {
                    pn.setMaNCC(mancc);
                    pn.setMaNV(manv);
                    pn.setNgayGioNhap(ngaygionhap);
                    pn.setTongTien(tongtien);
                }
            });
        }
        return ok;
    }

    public Boolean updateTongTien(String mapn, double tongtien) {
        Boolean ok = qlpnDAO.updateTongTien(mapn, tongtien);
        
        if (ok) {
            dspn.forEach((pn) -> {
                if (pn.getMaPN().equals(mapn)) {
                    pn.setTongTien(tongtien);
                }
            });
        }
        return ok;
    }

}
