/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd.QuanLyChiTietHoaDon;

/**
 *
 * @author ACER
 */
public class ChiTietHoaDon {
    
    String MaHD, MaSP;
    int SoLuong;
    double DonGia;

    public ChiTietHoaDon(String MaHD, String MaSP, int SoLuong, double DonGia) {
        this.MaHD = MaHD;
        this.MaSP = MaSP;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
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

    public Object[] toArray() {
        return new Object[]{MaHD, MaSP, SoLuong, DonGia};
    }
    
}
