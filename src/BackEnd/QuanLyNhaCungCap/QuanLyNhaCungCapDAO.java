/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd.QuanLyNhaCungCap;

import BackEnd.Connection.ConnectionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class QuanLyNhaCungCapDAO {
    
    ConnectionDB qlnccConnection;

    public ArrayList<NhaCungCap> readDB() {
        ArrayList<NhaCungCap> dsncc = new ArrayList<>();
        qlnccConnection = new ConnectionDB();
        
        try {
            String qry = "SELECT * FROM NhaCungCap";
            ResultSet r = qlnccConnection.sqlQuery(qry);
            if (r != null) {
                while (r.next()) {
                    String mancc = r.getString("MaNCC");
                    String tenncc = r.getString("TenNCC");
                    String diachi = r.getString("DiaChi");
                    String sdt = r.getString("SDT");

                    dsncc.add(new NhaCungCap(mancc, tenncc, diachi, sdt));
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi đọc dữ liệu bảng nhà cung cấp");
        } finally {
            qlnccConnection.closeConnect();
        }
        
        return dsncc;
    }

    public ArrayList<NhaCungCap> search(String value) {
        qlnccConnection = new ConnectionDB();
        ArrayList<NhaCungCap> dsncc = new ArrayList<>();

        try {
            String qry = "SELECT * FROM NhaCungCap WHERE MaNCC LIKE '%" + value + "%' OR TenNCC LIKE '%" + value + "%';";
            ResultSet r = qlnccConnection.sqlQuery(qry);
            if (r != null) {
                while (r.next()) {
                    String mancc = r.getString("MaNCC");
                    String tenncc = r.getString("TenNCC");
                    String diachi = r.getString("DiaChi");
                    String sdt = r.getString("SDT");
                    
                    dsncc.add(new NhaCungCap(mancc, tenncc, diachi, sdt));
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi tìm dữ liệu = " + value + " bảng nhà cung cấp");
        } finally {
            qlnccConnection.closeConnect();
        }

        return dsncc;
    }

    public Boolean add(NhaCungCap ncc) {
        qlnccConnection = new ConnectionDB();
        Boolean ok = qlnccConnection.sqlUpdate("INSERT INTO NhaCungCap (MaNCC, TenNCC, DiaChi, SDT) VALUES ('"
                + ncc.getMaNCC() + "', '" 
                + ncc.getTenNCC() + "', '" 
                + ncc.getDiaChi() + "', '" 
                + ncc.getSDT() + "');");
        qlnccConnection.closeConnect();
        return ok;
    }

    public Boolean delete(String mancc) {
        qlnccConnection = new ConnectionDB();
        Boolean ok = qlnccConnection.sqlUpdate("DELETE FROM NhaCungCap WHERE NhaCungCap.MaNCC = '" + mancc + "'");
        qlnccConnection.closeConnect();
        return ok;
    }

    public Boolean update(String MaNCC, String TenNCC, String DiaChi, String SDT) {
        qlnccConnection = new ConnectionDB();
        Boolean ok = qlnccConnection.sqlUpdate("UPDATE NhaCungCap SET "
                + "TenNCC = '" + TenNCC
                + "', DiaChi = '" + DiaChi
                + "', SDT = '" + SDT
                + "' WHERE MaNCC = '" + MaNCC + "'");
        qlnccConnection.closeConnect();
        return ok;
    }

    public void close() {
        qlnccConnection.closeConnect();
    }

}
