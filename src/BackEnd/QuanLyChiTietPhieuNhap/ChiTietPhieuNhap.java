/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd.QuanLyChiTietPhieuNhap;

/**
 *
 * @author ACER
 */
public class ChiTietPhieuNhap {
    
    String MaPN, MaSP;
    int SoLuong;
    double DonGia;

    public ChiTietPhieuNhap(String MaPN, String MaSP, int SoLuong, double DonGia) {
        this.MaPN = MaPN;
        this.MaSP = MaSP;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
    }

    public String getMaPN() {
        return MaPN;
    }

    public void setMaPN(String MaPN) {
        this.MaPN = MaPN;
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
    
    public Object[] toArray(){
        return new Object[]{MaPN, MaSP, SoLuong, DonGia};
    }
    
}
