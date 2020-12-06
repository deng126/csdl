/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd.QuanLyPhieuNhap;

import java.time.LocalDateTime;

/**
 *
 * @author ACER
 */
public class PhieuNhap {
    
    String MaPN, MaNCC, MaNV;
    LocalDateTime NgayGioNhap;
    double TongTien;

    public PhieuNhap(LocalDateTime NgayGioNhap) {
        this.NgayGioNhap = NgayGioNhap;
    }

    public PhieuNhap(String MaPN, String MaNCC, String MaNV, LocalDateTime NgayGioNhap, double TongTien) {
        this.MaPN = MaPN;
        this.MaNCC = MaNCC;
        this.MaNV = MaNV;
        this.NgayGioNhap = NgayGioNhap;
        this.TongTien = TongTien;
    }

    public String getMaPN() {
        return MaPN;
    }

    public void setMaPN(String MaPN) {
        this.MaPN = MaPN;
    }

    public String getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public LocalDateTime getNgayGioNhap() {
        return NgayGioNhap;
    }

    public void setNgayGioNhap(LocalDateTime NgayGioNhap) {
        this.NgayGioNhap = NgayGioNhap;
    }

    public double getTongTien() {
        return TongTien;
    }

    public void setTongTien(double TongTien) {
        this.TongTien = TongTien;
    }
    
    public Object[] toArray(){
        return new Object[]{MaPN, MaNCC, MaNV, NgayGioNhap, TongTien};
    }
    
}
