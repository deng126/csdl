/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd.QuanLyChiTietHoaDon;

import BackEnd.Connection.ConnectionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class QuanLyChiTietHoaDonDAO {

    ConnectionDB qlcthdConnection;

    public QuanLyChiTietHoaDonDAO() {
        
    }

    public ArrayList<ChiTietHoaDon> readDB() {
        qlcthdConnection = new ConnectionDB();
        ArrayList<ChiTietHoaDon> dscthd = new ArrayList<>();
        
        try {
            String qry = "SELECT * FROM ChiTietHoaDon";
            ResultSet r = qlcthdConnection.sqlQuery(qry);
            if (r != null) {
                while (r.next()) {
                    String mahd = r.getString("MaHD");
                    String masp = r.getString("MaSP");
                    int soluong = r.getInt("SoLuong");
                    double dongia = r.getDouble("DonGia");

                    dscthd.add(new ChiTietHoaDon(mahd, masp, soluong, dongia));
                }
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi đọc dữ liệu bảng chi tiết hóa đơn");
        } finally {
            qlcthdConnection.closeConnect();
        }
        
        return dscthd;
    }
    
    public ArrayList<ChiTietHoaDon> search(String value) {
        qlcthdConnection = new ConnectionDB();
        ArrayList<ChiTietHoaDon> dscthd = new ArrayList<>();
        
        try {
            String qry = "SELECT * FROM ChiTietHoaDon WHERE MaHD = '" + value + "';";
            ResultSet r = qlcthdConnection.sqlQuery(qry);
            if (r != null) {
                while (r.next()) {
                    String mahd = r.getString("MaHD");
                    String masp = r.getString("MaSP");
                    int soluong = r.getInt("SoLuong");
                    double dongia = r.getDouble("DonGia");

                    dscthd.add(new ChiTietHoaDon(mahd, masp, soluong, dongia));
                }
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi tìm dữ liệu = " + value + " bảng chi tiết hóa đơn");
        } finally {
            qlcthdConnection.closeConnect();
        }
        
        return dscthd;
    }

    public Boolean add(ChiTietHoaDon cthd) {
        qlcthdConnection = new ConnectionDB();
        Boolean ok = qlcthdConnection.sqlUpdate("INSERT INTO ChiTietHoaDon (MaHD, MaSP, SoLuong, DonGia) VALUES ('" 
                + cthd.getMaHD() + "', '" 
                + cthd.getMaSP() + "', '" 
                + cthd.getSoLuong() + "', '" 
                + cthd.getDonGia() + "')");
        qlcthdConnection.closeConnect();
        return ok;
    }

    public Boolean delete(String mahd, String masp) {
        qlcthdConnection = new ConnectionDB();
        Boolean ok = qlcthdConnection.sqlUpdate("DELETE FROM ChiTietHoaDon WHERE "
                + "ChiTietHoaDon.MaHD = '" + mahd
                + "' AND ChiTietHoaDon.MaSP = '" + masp + "'");
        qlcthdConnection.closeConnect();
        return ok;
    }

    public Boolean update(String MaHD, String MaSP, int SoLuong, double DonGia) {
        qlcthdConnection = new ConnectionDB();
        Boolean ok = qlcthdConnection.sqlUpdate("UPDATE ChiTietHoaDon SET "
                + "'SoLuong = '" + SoLuong
                + "', DonGia = '" + DonGia
                + "' WHERE MaHD = '" + MaHD + "' AND MaSP = '" + MaSP + "'");
        qlcthdConnection.closeConnect();
        return ok;
    }

    public void close() {
        qlcthdConnection.closeConnect();
    }
    
}
