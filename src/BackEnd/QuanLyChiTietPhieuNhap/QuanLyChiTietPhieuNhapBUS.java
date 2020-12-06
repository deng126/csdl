/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd.QuanLyChiTietPhieuNhap;

import BackEnd.QuanLyPhieuNhap.QuanLyPhieuNhapBUS;
import BackEnd.QuanLySanPham.QuanLySanPhamBUS;
import BackEnd.QuanLySanPham.SanPham;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class QuanLyChiTietPhieuNhapBUS {

    private ArrayList<ChiTietPhieuNhap> dsctpn = new ArrayList<>();
    private QuanLyChiTietPhieuNhapDAO qlctpnDAO = new QuanLyChiTietPhieuNhapDAO();
    private QuanLyPhieuNhapBUS qlpnBUS = new QuanLyPhieuNhapBUS();
    private QuanLySanPhamBUS qlspBUS = new QuanLySanPhamBUS();

    public QuanLyChiTietPhieuNhapBUS() {
        dsctpn = qlctpnDAO.readDB();
    }

    public ArrayList<ChiTietPhieuNhap> readDB() {
        dsctpn = qlctpnDAO.readDB();
        return dsctpn;
    }

    public ArrayList<ChiTietPhieuNhap> search(String value) {
        ArrayList<ChiTietPhieuNhap> result = qlctpnDAO.search(value);
        return result;
    }
    
    public Boolean add(ChiTietPhieuNhap ctpn) {
        int soLuongChiTietMoi = ctpn.getSoLuong();

        // tìm các chi tiết cùng mã, và tính tổng số lượng
        ArrayList<ChiTietPhieuNhap> toRemove = new ArrayList<>();
        int tongSoLuong = ctpn.getSoLuong();

        for (ChiTietPhieuNhap ct : dsctpn) {
            if (ct.getMaPN().equals(ctpn.getMaPN()) && ct.getMaSP().equals(ctpn.getMaSP())) {
                tongSoLuong += ct.getSoLuong();
                toRemove.add(ct);
            }
        }

        // xóa chi tiết cũ cùng mã
        dsctpn.removeAll(toRemove);
        qlctpnDAO.delete(ctpn.getMaPN(), ctpn.getMaSP());

        // thêm chi tiết mới có số lượng = tổng số lượng tìm ở trên
        ctpn.setSoLuong(tongSoLuong);
        
        // thêm và thay đổi nội dung các bảng liên kết
        Boolean ok = qlctpnDAO.add(ctpn);
        if (ok) {
            dsctpn.add(ctpn);
            // update số lượng bên bảng sản phẩm
            updateSoLuongSanPham(ctpn.getMaSP(), soLuongChiTietMoi);
            // update tổng tiền hóa đơn
            updateTongTien(ctpn.getMaPN());
        }
        return ok;
    }

    public Boolean add(String mapn, String masp, int soluong, double dongia) {
        ChiTietPhieuNhap pn = new ChiTietPhieuNhap(mapn, masp, soluong, dongia);
        return add(pn);
    }

    public Boolean delete(String mapn, String masp) {
        Boolean ok = qlctpnDAO.delete(mapn, masp);

        if (ok) {
            for (int i = (dsctpn.size() - 1); i >= 0; i--) {
                if (dsctpn.get(i).getMaPN().equals(mapn) && dsctpn.get(i).getMaSP().equals(masp)) {
                    dsctpn.remove(i);
                    updateSoLuongSanPham(masp, dsctpn.get(i).getSoLuong());
                    updateTongTien(mapn);
                }
            }

        }
        return ok;
    }

    public Boolean update(String mapn, String masp, int soluong, double dongia) {
        Boolean ok = qlctpnDAO.update(mapn, masp, soluong, dongia);
        
        if (ok) {
            dsctpn.forEach((ctpn) -> {
                if (ctpn.getMaPN().equals(mapn) && ctpn.getMaSP().equals(masp)) {
                    ctpn.setSoLuong(soluong);
                    ctpn.setDonGia(dongia);
                }
            });
            updateTongTien(mapn);
        }
        return ok;
    }

    private Boolean updateTongTien(String mapn) {
        double tong = 0;
        for (ChiTietPhieuNhap ctpn : dsctpn) {
            if (ctpn.getMaPN().equals(mapn)) {
                tong += ctpn.getSoLuong() * ctpn.getDonGia();
            }
        }
        
        Boolean ok = qlpnBUS.updateTongTien(mapn, tong);
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
