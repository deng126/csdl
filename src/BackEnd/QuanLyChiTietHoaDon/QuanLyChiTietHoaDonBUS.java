/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd.QuanLyChiTietHoaDon;


import BackEnd.QuanLyHoaDon.QuanLyHoaDonBUS;
import BackEnd.QuanLySanPham.QuanLySanPhamBUS;
import BackEnd.QuanLySanPham.SanPham;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class QuanLyChiTietHoaDonBUS {

    private ArrayList<ChiTietHoaDon> dscthd = new ArrayList<>();
    private QuanLyChiTietHoaDonDAO qlcthdDAO = new QuanLyChiTietHoaDonDAO();
    private QuanLyHoaDonBUS qlhdBUS = new QuanLyHoaDonBUS();
    private QuanLySanPhamBUS qlspBUS = new QuanLySanPhamBUS();

    public QuanLyChiTietHoaDonBUS() {
        dscthd = qlcthdDAO.readDB();
    }

    public ArrayList<ChiTietHoaDon> readDB() {
        dscthd = qlcthdDAO.readDB();
        return dscthd;
    }
    
    public ArrayList<ChiTietHoaDon> search(String value) {
        ArrayList<ChiTietHoaDon> result = qlcthdDAO.search(value);
        return result;
    }
    
    public Boolean add(ChiTietHoaDon cthd) {
        int soLuongChiTietMoi = cthd.getSoLuong();

        // tìm các chi tiết cùng mã, và tính tổng số lượng
        ArrayList<ChiTietHoaDon> toRemove = new ArrayList<>();
        int tongSoLuong = cthd.getSoLuong();

        for (ChiTietHoaDon ct : dscthd) {
            if (ct.getMaHD().equals(cthd.getMaHD()) && ct.getMaSP().equals(cthd.getMaSP())) {
                tongSoLuong += ct.getSoLuong();
                toRemove.add(ct);
            }
        }

        // xóa chi tiết cũ cùng mã
        dscthd.removeAll(toRemove);
        qlcthdDAO.delete(cthd.getMaHD(), cthd.getMaSP());

        // thêm chi tiết mới có số lượng = tổng số lượng tìm ở trên
        cthd.setSoLuong(tongSoLuong);
        
        // thêm và thay đổi nội dung các bảng liên kết
        Boolean ok = qlcthdDAO.add(cthd);
        if (ok) {
            dscthd.add(cthd);
            // update số lượng bên bảng sản phẩm
            updateSoLuongSanPham(cthd.getMaSP(), -soLuongChiTietMoi);
            // update tổng tiền hóa đơn
            updateTongTien(cthd.getMaHD());
        }
        return ok;
    }

    public Boolean add(String mahd, String masp, int soluong, double dongia) {
        ChiTietHoaDon hd = new ChiTietHoaDon(mahd, masp, soluong, dongia);
        return add(hd);
    }

    public Boolean delete(String mahd, String masp) {
        Boolean ok = qlcthdDAO.delete(mahd, masp);

        if (ok) {
            for (int i = (dscthd.size() - 1); i >= 0; i--) {
                if (dscthd.get(i).getMaHD().equals(mahd) && dscthd.get(i).getMaSP().equals(masp)) {
                    dscthd.remove(i);
                    updateSoLuongSanPham(masp, dscthd.get(i).getSoLuong());
                    updateTongTien(mahd);
                }
            }

        }
        return ok;
    }

    public Boolean update(String mahd, String masp, int soluong, double dongia) {
        Boolean ok = qlcthdDAO.update(mahd, masp, soluong, dongia);
        
        if (ok) {
            dscthd.forEach((cthd) -> {
                if (cthd.getMaHD().equals(mahd) && cthd.getMaSP().equals(masp)) {
                    cthd.setSoLuong(soluong);
                    cthd.setDonGia(dongia);
                }
            });
            updateTongTien(mahd);
        }
        return ok;
    }

    private Boolean updateTongTien(String mahd) {
        double tong = 0;
        for (ChiTietHoaDon cthd : dscthd) {
            if (cthd.getMaHD().equals(mahd)) {
                tong += cthd.getSoLuong() * cthd.getDonGia();
            }
        }
        
        Boolean ok = qlhdBUS.updateTongTien(mahd, tong);
        return ok;
    }

    private Boolean updateSoLuongSanPham(String masp, int soluongThaydoi) {
        int soluong = 0;
        for (SanPham sp : qlspBUS.readDB()) {
            if (sp.getMaSP().equals(masp)) {
                soluong = sp.getSoLuong() + soluongThaydoi;
            }
        }
        
        Boolean ok = qlspBUS.updateSoLuong(masp, soluong);
        return ok;
    }

}
