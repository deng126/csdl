/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd.QuanLyKhachHang;

import BackEnd.Connection.ConnectionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class QuanLyKhachHangDAO {
    
    ConnectionDB qlkhConnection;

    public QuanLyKhachHangDAO() {

    }

    public ArrayList<KhachHang> readDB() {
        qlkhConnection = new ConnectionDB();
        ArrayList<KhachHang> dskh = new ArrayList<>();
        
        try {
            String qry = "SELECT * FROM KhachHang";
            ResultSet r = qlkhConnection.sqlQuery(qry);
            if (r != null) {
                while (r.next()) {
                    String makh = r.getString("MaKH");
                    String tenkh = r.getString("TenKH");
                    String diachi = r.getString("DiaChi");
                    String sdt = r.getString("SDT");
                    
                    dskh.add(new KhachHang(makh, tenkh, diachi, sdt));
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi đọc dữ liệu bảng khách hàng");
        } finally {
            qlkhConnection.closeConnect();
        }
        
        return dskh;
    }

    public ArrayList<KhachHang> search(String value) {
        qlkhConnection = new ConnectionDB();
        ArrayList<KhachHang> dskh = new ArrayList<>();

        try {
            String qry = "SELECT * FROM KhachHang WHERE MaKH LIKE '%" + value + "%' OR TenKH LIKE '%" + value + "%';";
            ResultSet r = qlkhConnection.sqlQuery(qry);
            if (r != null) {
                while (r.next()) {
                    String makh = r.getString("MaKH");
                    String tenkh = r.getString("TenKH");
                    String diachi = r.getString("DiaChi");
                    String sdt = r.getString("SDT");
                    
                    dskh.add(new KhachHang(makh, tenkh, diachi, sdt));
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi tìm dữ liệu = " + value + " bảng khách hàng");
        } finally {
            qlkhConnection.closeConnect();
        }

        return dskh;
    }

    public Boolean add(KhachHang kh) {
        qlkhConnection = new ConnectionDB();
        Boolean ok = qlkhConnection.sqlUpdate("INSERT INTO KhachHang (MaKH, TenKH, DiaChi, SDT) VALUES ('"
                + kh.getMaKH() + "', '"
                + kh.getTenKH() + "', '"
                + kh.getDiaChi() + "', '"
                + kh.getSDT() + "');");
        qlkhConnection.closeConnect();
        return ok;
    }

    public Boolean delete(String makh) {
        qlkhConnection = new ConnectionDB();
        Boolean ok = qlkhConnection.sqlUpdate("DELETE FROM KhachHang WHERE KhachHang.MaKH = '" + makh + "'");
        qlkhConnection.closeConnect();
        return ok;
    }

    public Boolean update(String MaKH, String TenKH, String DiaChi, String SDT) {
        qlkhConnection = new ConnectionDB();
        Boolean ok = qlkhConnection.sqlUpdate("UPDATE KhachHang SET "
                + "TenKH = '" + TenKH
                + "', DiaChi = '" + DiaChi 
                + "', SDT = '" + SDT
                + "' WHERE MaKH = '" + MaKH + "'");
        qlkhConnection.closeConnect();
        return ok;
    }

    public void close() {
        qlkhConnection.closeConnect();
    }
    
}
