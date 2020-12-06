/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd.QuanLyHoaDon;

import java.time.LocalDateTime;

/**
 *
 * @author ACER
 */
public class HoaDon {
    
    String MaHD, MaNV, MaKH;
    LocalDateTime NgayGioLap;
    double TongTien;

    public HoaDon(LocalDateTime NgayGioLap) {
        this.NgayGioLap = NgayGioLap;
    }

    public HoaDon(String MaHD, String MaNV, String MaKH, LocalDateTime NgayGioLap, double TongTien) {
        this.MaHD = MaHD;
        this.MaNV = MaNV;
        this.MaKH = MaKH;
        this.NgayGioLap = NgayGioLap;
        this.TongTien = TongTien;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public LocalDateTime getNgayGioLap() {
        return NgayGioLap;
    }

    public void setNgayGioLap(LocalDateTime NgayGioLap) {
        this.NgayGioLap = NgayGioLap;
    }

    public double getTongTien() {
        return TongTien;
    }

    public void setTongTien(double TongTien) {
        this.TongTien = TongTien;
    }
    
    public Object[] toArray(){
        return new Object[]{MaHD, MaNV, MaKH, NgayGioLap, TongTien};
    }
    
}
