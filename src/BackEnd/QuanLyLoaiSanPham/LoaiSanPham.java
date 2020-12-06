/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd.QuanLyLoaiSanPham;

/**
 *
 * @author ACER
 */
public class LoaiSanPham {

    String MaLSP, TenLSP, MoTa;

    public LoaiSanPham(String MaLSP, String TenLSP, String MoTa) {
        this.MaLSP = MaLSP;
        this.TenLSP = TenLSP;
        this.MoTa = MoTa;
    }

    public String getMaLSP() {
        return MaLSP;
    }

    public void setMaLSP(String MaLSP) {
        this.MaLSP = MaLSP;
    }

    public String getTenLSP() {
        return TenLSP;
    }

    public void setTenLSP(String TenLSP) {
        this.TenLSP = TenLSP;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public Object[] toArray() {
        return new Object[]{getMaLSP(), getTenLSP(), getMoTa()};
    }

}
