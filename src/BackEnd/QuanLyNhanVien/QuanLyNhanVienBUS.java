/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd.QuanLyNhanVien;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class QuanLyNhanVienBUS {

    private ArrayList<NhanVien> dsnv = new ArrayList<>();
    private QuanLyNhanVienDAO qlnvDAO = new QuanLyNhanVienDAO();

    public QuanLyNhanVienBUS() {
        dsnv = qlnvDAO.readDB();
    }

    public String getNextID() {
        return "NV" + String.valueOf(this.dsnv.size() + 1);
    }

    public ArrayList<NhanVien> readDB() {
        dsnv = qlnvDAO.readDB();
        return dsnv;
    }

    public ArrayList<NhanVien> search(String value) {
        ArrayList<NhanVien> result = qlnvDAO.search(value);
        return result;
    }

    private Boolean add(NhanVien nv) {
        Boolean ok = qlnvDAO.add(nv);

        if (ok) {
            dsnv.add(nv);
        }
        return ok;
    }

    public Boolean add(String manv, String tennv, LocalDate ngaysinh, String diachi, String sdt) {
        NhanVien nv = new NhanVien(manv, tennv, ngaysinh, diachi, sdt);
        return add(nv);
    }

    public Boolean delete(String manv) {
        Boolean ok = qlnvDAO.delete(manv);

        if (ok) {
            for (int i = (dsnv.size() - 1); i >= 0; i--) {
                if (dsnv.get(i).getMaNV().equals(manv)) {
                    dsnv.remove(i);
                }
            }
        }
        return ok;
    }

    public Boolean update(String manv, String tennv, LocalDate ngaysinh, String diachi, String sdt) {
        Boolean ok = qlnvDAO.update(manv, tennv, ngaysinh, diachi, sdt);

        if (ok) {
            dsnv.forEach((nv) -> {
                if (nv.getMaNV().equals(manv)) {
                    nv.setTenNV(tennv);
                    nv.setNgaySinh(ngaysinh);
                    nv.setDiaChi(diachi);
                    nv.setSDT(sdt);
                }
            });
        }

        return ok;
    }

}
