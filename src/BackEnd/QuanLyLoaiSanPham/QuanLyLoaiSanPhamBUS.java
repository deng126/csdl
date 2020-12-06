/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd.QuanLyLoaiSanPham;

import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class QuanLyLoaiSanPhamBUS {

    private ArrayList<LoaiSanPham> dslsp = new ArrayList<>();
    private QuanLyLoaiSanPhamDAO qllspDAO = new QuanLyLoaiSanPhamDAO();

    public QuanLyLoaiSanPhamBUS() {
        dslsp = qllspDAO.readDB();
    }

    public String getNextID() {
        return "LSP" + String.valueOf(this.dslsp.size() + 1);
    }

    public ArrayList<LoaiSanPham> readDB() {
        dslsp = qllspDAO.readDB();
        return dslsp;
    }

    public ArrayList<LoaiSanPham> search(String value) {
        ArrayList<LoaiSanPham> result = qllspDAO.search(value);
        return result;
    }

    private Boolean add(LoaiSanPham lsp) {
        Boolean ok = qllspDAO.add(lsp);

        if (ok) {
            dslsp.add(lsp);
        }
        return ok;
    }

    public Boolean add(String malsp, String tenlsp, String mota) {
        LoaiSanPham lsp = new LoaiSanPham(malsp, tenlsp, mota);
        return add(lsp);
    }

    public Boolean delete(String malsp) {
        Boolean ok = qllspDAO.delete(malsp);

        if (ok) {
            for (int i = (dslsp.size() - 1); i >= 0; i--) {
                if (dslsp.get(i).getMaLSP().equals(malsp)) {
                    dslsp.remove(i);
                }
            }
        }
        return ok;
    }

    public Boolean update(String malsp, String tenlsp, String mota) {
        Boolean ok = qllspDAO.update(malsp, tenlsp, mota);

        if (ok) {
            dslsp.forEach((lsp) -> {
                if (lsp.getMaLSP().equals(malsp)) {
                    lsp.setTenLSP(tenlsp);
                    lsp.setMoTa(mota);
                }
            });
        }

        return ok;
    }

}
