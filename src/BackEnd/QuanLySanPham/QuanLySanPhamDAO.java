/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd.QuanLySanPham;

import BackEnd.Connection.ConnectionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class QuanLySanPhamDAO {
    
    ConnectionDB qlspConnection;

    public QuanLySanPhamDAO() {

    }

    public ArrayList<SanPham> readDB() {
        qlspConnection = new ConnectionDB();
        ArrayList<SanPham> dssp = new ArrayList<>();
        
        try {
            String qry = "SELECT * FROM SanPham";
            ResultSet r = qlspConnection.sqlQuery(qry);
            if (r != null) {
                while (r.next()) {
                    String masp = r.getString("MaSP");
                    String loaisp = r.getString("MaLSP");
                    String tensp = r.getString("TenSP");
                    int soluong = r.getInt("SoLuong");
                    double dongia = r.getDouble("DonGia");
                    String url = r.getString("HinhAnh");
                    
                    dssp.add(new SanPham(masp, loaisp, tensp, soluong, dongia, url));
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi đọc dữ liệu bảng sản phẩm");
        } finally {
            qlspConnection.closeConnect();
        }
        
        return dssp;
    }

    public ArrayList<SanPham> search(String value) {
        qlspConnection = new ConnectionDB();
        ArrayList<SanPham> dssp = new ArrayList<>();

        try {
            String qry = "SELECT * FROM SanPham WHERE MaSP LIKE '%" + value + "%' OR TenSP LIKE '%" + value + "%';";
            ResultSet r = qlspConnection.sqlQuery(qry);
            if (r != null) {
                while (r.next()) {
                    String masp = r.getString("MaSP");
                    String loaisp = r.getString("MaLSP");
                    String tensp = r.getString("TenSP");
                    int soluong = r.getInt("SoLuong");
                    double dongia = r.getFloat("DonGia");
                    String url = r.getString("HinhAnh");
                    
                    dssp.add(new SanPham(masp, loaisp, tensp, soluong, dongia, url));
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi tìm dữ liệu = " + value + " bảng sản phẩm");
        } finally {
            qlspConnection.closeConnect();
        }

        return dssp;
    }

    public Boolean add(SanPham sp) {
        qlspConnection = new ConnectionDB();
        Boolean ok = qlspConnection.sqlUpdate("INSERT INTO SanPham (MaSP, MaLSP, TenSP, SoLuong, DonGia, HinhAnh) VALUES ('"
                + sp.getMaSP() + "', '"
                + sp.getMaLSP() + "', '"
                + sp.getTenSP() + "', '"
                + sp.getSoLuong() + "', '"
                + sp.getDonGia() + "', '"
                + sp.getFileTenHinhAnh() + "');");
        qlspConnection.closeConnect();
        return ok;
    }

    public Boolean delete(String masp) {
        qlspConnection = new ConnectionDB();
        Boolean ok = qlspConnection.sqlUpdate("DELETE FROM SanPham WHERE SanPham.MaSP = '" + masp + "'");
        qlspConnection.closeConnect();
        return ok;
    }

    public Boolean update(String MaSP, String MaLSP, String TenSP, int SoLuong, double DonGia, String filename) {
        qlspConnection = new ConnectionDB();
        Boolean ok = qlspConnection.sqlUpdate("UPDATE SanPham SET "
                + "MaLSP = '" + MaLSP
                + "', TenSP = '" + TenSP
                + "', SoLuong = '" + SoLuong
                + "', DonGia = '" + DonGia
                + "', HinhAnh = '" + filename
                + "' WHERE MaSP = '" + MaSP + "'");
        qlspConnection.closeConnect();
        return ok;
    }

    public Boolean updateSoLuong(String MaSP, int SoLuong) {
        qlspConnection = new ConnectionDB();
        Boolean ok = qlspConnection.sqlUpdate("UPDATE SanPham SET SoLuong = '" + SoLuong
                + "' WHERE MaSP = '" + MaSP + "'");
        qlspConnection.closeConnect();
        return ok;
    }

    public Boolean updateDonGia(String MaSP, double DonGia) {
        qlspConnection = new ConnectionDB();
        Boolean ok = qlspConnection.sqlUpdate("UPDATE SanPham SET DonGia = '" + DonGia
                + "' WHERE MaSP = '" + MaSP + "'");
        qlspConnection.closeConnect();
        return ok;
    }
    
    public void close() {
        qlspConnection.closeConnect();
    }
    
}
