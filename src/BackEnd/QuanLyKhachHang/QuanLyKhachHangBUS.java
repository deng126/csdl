/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd.QuanLyKhachHang;

import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class QuanLyKhachHangBUS {

    private ArrayList<KhachHang> dskh = new ArrayList<>();
    private QuanLyKhachHangDAO qlkhDAO = new QuanLyKhachHangDAO();

    public QuanLyKhachHangBUS() {
        dskh = qlkhDAO.readDB();
    }
    
    public String getNextID() {
        return "KH" + String.valueOf(this.dskh.size() + 1);
    }
    
    public ArrayList<KhachHang> readDB() {
        dskh = qlkhDAO.readDB();
        return dskh;
    }
    
    public ArrayList<KhachHang> search(String value) {
        ArrayList<KhachHang> result = qlkhDAO.search(value);
        return result;
    }

    private Boolean add(KhachHang kh) {
        Boolean ok = qlkhDAO.add(kh);

        if (ok) {
            dskh.add(kh);
        }
        return ok;
    }

    public Boolean add(String makh, String tenkh, String diachi, String sdt) {
        KhachHang kh = new KhachHang(makh, tenkh, diachi, sdt);
        return add(kh);
    }

    public Boolean delete(String makh) {
        Boolean ok = qlkhDAO.delete(makh);

        if (ok) {
            for (int i = (dskh.size() - 1); i >= 0; i--) {
                if (dskh.get(i).getMaKH().equals(makh)) {
                    dskh.remove(i);
                }
            }
        }
        return ok;
    }

    public Boolean update(String makh, String tenkh, String diachi, String sdt) {
        Boolean ok = qlkhDAO.update(makh, tenkh, diachi, sdt);

        if (ok) {
            dskh.forEach((kh) -> {
                if (kh.getMaKH().equals(makh)) {
                    kh.setTenKH(tenkh);
                    kh.setDiaChi(diachi);
                    kh.setSDT(sdt);
                }
            });
        }

        return ok;
    }
 
}
