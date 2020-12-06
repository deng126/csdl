/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd.QuanLyNhaCungCap;

import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class QuanLyNhaCungCapBUS {

    private ArrayList<NhaCungCap> dsncc = new ArrayList<>();
    private QuanLyNhaCungCapDAO qlnccDAO = new QuanLyNhaCungCapDAO();
    
    public QuanLyNhaCungCapBUS() {
        dsncc = qlnccDAO.readDB();
    }

    public ArrayList<NhaCungCap> readDB() {
        dsncc = qlnccDAO.readDB();
        return dsncc;
    }

    public ArrayList<NhaCungCap> search(String value) {
        ArrayList<NhaCungCap> result = qlnccDAO.search(value);
        return result;
    }

    private Boolean add(NhaCungCap ncc) {
        Boolean ok = qlnccDAO.add(ncc);

        if (ok) {
            dsncc.add(ncc);
        }
        return ok;
    }

    public Boolean add(String ma, String ten, String diachi, String sdt) {
        NhaCungCap ncc = new NhaCungCap(ma, ten, diachi, sdt);
        return add(ncc);
    }

    public Boolean delete(String mancc) {
        Boolean ok = qlnccDAO.delete(mancc);

        if (ok) {
            for (int i = (dsncc.size() - 1); i >= 0; i--) {
                if (dsncc.get(i).getMaNCC().equals(mancc)) {
                    dsncc.remove(i);
                }
            }
        }
        return ok;
    }

    public Boolean update(String mancc, String tenncc, String diachi, String sdt) {
        Boolean ok = qlnccDAO.update(mancc, tenncc, diachi, sdt);

        if (ok) {
            dsncc.forEach((ncc) -> {
                if (ncc.getMaNCC().equals(mancc)) {
                    ncc.setTenNCC(tenncc);
                    ncc.setDiaChi(diachi);
                    ncc.setSDT(sdt);
                }
            });
        }
        return ok;
    }
   
}
