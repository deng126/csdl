/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd.QuanLySanPham;

/**
 *
 * @author ACER
 */
public class SanPham {

    String MaSP, MaLSP, TenSP, FileTenHinhAnh;
    double DonGia;
    int SoLuong;

    public SanPham(String MaSP, String TenSP, int SoLuong, double DonGia) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.DonGia = DonGia;
        this.SoLuong = SoLuong;
    }

    public SanPham(String MaSP, String MaLSP, String TenSP, int SoLuong, double DonGia, String FileTenHinhAnh) {
        this.MaSP = MaSP;
        this.MaLSP = MaLSP;
        this.TenSP = TenSP;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
        this.FileTenHinhAnh = FileTenHinhAnh;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getMaLSP() {
        return MaLSP;
    }

    public void setMaLSP(String MaLSP) {
        this.MaLSP = MaLSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public double getDonGia() {
        return DonGia;
    }

    public void setDonGia(double DonGia) {
        this.DonGia = DonGia;
    }

    public String getFileTenHinhAnh() {
        return FileTenHinhAnh;
    }

    public void setFileTenHinhAnh(String FileTenHinhAnh) {
        this.FileTenHinhAnh = FileTenHinhAnh;
    }

    public Object[] toArray(){
        return new Object[]{MaSP, TenSP, SoLuong, DonGia};
    }

    public Object[] toArraySp() {
        return new Object[]{MaSP, MaLSP, TenSP, SoLuong, DonGia, FileTenHinhAnh};
    }

    public Object[] toNhapHang() {
        return new Object[]{getMaSP(), getTenSP(), getSoLuong(), getDonGia()};
    }

    public Object[] toArrayBanHang() {
        return new Object[]{MaSP, TenSP, SoLuong, DonGia * 120 / 100};
    }

}
