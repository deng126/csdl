/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd.QuanLySanPham;

import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class QuanLySanPhamBUS {
    
    private ArrayList<SanPham> dssp = new ArrayList<>();
    QuanLySanPhamDAO qlspDAO = new QuanLySanPhamDAO();

    public QuanLySanPhamBUS() {
        dssp = qlspDAO.readDB();
    }

    public ArrayList<SanPham> readDB() {
        dssp = qlspDAO.readDB();
        return dssp;
    }

    public ArrayList<SanPham> search(String value) {
        ArrayList<SanPham> result = qlspDAO.search(value);
        return result;
    }

    private Boolean add(SanPham sp) {
        Boolean ok = qlspDAO.add(sp);

        if (ok) {
            dssp.add(sp);
        }
        return ok;
    }

    public Boolean add(String masp, String malsp, String tensp,  int soluong, double dongia ,String filename) {
        SanPham sp = new SanPham(masp, malsp, tensp, soluong, dongia, filename);
        return add(sp);
    }

    public Boolean delete(String masp) {
        Boolean ok = qlspDAO.delete(masp);

        if (ok) {
            for (int i = (dssp.size() - 1); i >= 0; i--) {
                if (dssp.get(i).getMaSP().equals(masp)) {
                    dssp.remove(i);
                }
            }
        }
        return ok;
    }

    public Boolean update(String masp, String malsp, String tensp, int soluong, double dongia, String filename) {
        Boolean ok = qlspDAO.update(masp, malsp, tensp, soluong, dongia, filename);

        if (ok) {
            dssp.forEach((sp) -> {
                if (sp.getMaSP().equals(masp)) {
                    sp.setMaLSP(malsp);
                    sp.setTenSP(tensp);
                    sp.setDonGia(dongia);
                    sp.setSoLuong(soluong);
                    sp.setFileTenHinhAnh(filename);
                }
            });
        }

        return ok;
    }

    public Boolean updateSoLuong(String masp, int soluong) {
        Boolean ok = qlspDAO.updateSoLuong(masp, soluong);

        if (ok) {
            dssp.forEach((sp) -> {
                if (sp.getMaSP().equals(masp)) {
                    sp.setSoLuong(soluong);
                }
            });
        }

        return ok;
    }

    public Boolean updateDonGia(String masp, float dongia) {
        Boolean ok = qlspDAO.updateDonGia(masp, dongia);

        if (ok) {
            dssp.forEach((sp) -> {
                if (sp.getMaSP().equals(masp)) {
                    sp.setDonGia(dongia);
                }
            });
        }

        return ok;
    }
    
}
