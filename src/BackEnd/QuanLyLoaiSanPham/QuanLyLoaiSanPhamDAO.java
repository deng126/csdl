/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd.QuanLyLoaiSanPham;

import BackEnd.Connection.ConnectionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class QuanLyLoaiSanPhamDAO {

    ConnectionDB qllspConnection;

    public QuanLyLoaiSanPhamDAO() {

    }

    public ArrayList<LoaiSanPham> readDB() {
        qllspConnection = new ConnectionDB();
        ArrayList<LoaiSanPham> dslsp = new ArrayList<>();

        try {
            String qry = "SELECT * FROM LoaiSanPham";
            ResultSet r = qllspConnection.sqlQuery(qry);
            if (r != null) {
                while (r.next()) {
                    String malsp = r.getString("MaLSP");
                    String tenlsp = r.getString("TenLSP");
                    String mota = r.getString("Mota");

                    dslsp.add(new LoaiSanPham(malsp, tenlsp, mota));
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi đọc dữ liệu bảng loại sản phẩm");
        } finally {
            qllspConnection.closeConnect();
        }
        
        return dslsp;
    }

    public ArrayList<LoaiSanPham> search(String value) {
        qllspConnection = new ConnectionDB();
        ArrayList<LoaiSanPham> dslsp = new ArrayList<>();

        try {
            String qry = "SELECT * FROM LoaiSanPham WHERE MaLSP LIKE '%" + value + "%' OR TenLSP LIKE '%" + value + "%';";
            ResultSet r = qllspConnection.sqlQuery(qry);
            if (r != null) {
                while (r.next()) {
                    String malsp = r.getString("MaLSP");
                    String tenlsp = r.getString("TenLSP");
                    String mota = r.getString("Mota");

                    dslsp.add(new LoaiSanPham(malsp, tenlsp, mota));
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi tìm dữ liệu = " + value + " bảng loại sản phẩm");
        } finally {
            qllspConnection.closeConnect();
        }
        
        return dslsp;
    }

    public Boolean add(LoaiSanPham lsp) {
        qllspConnection = new ConnectionDB();
        Boolean ok = qllspConnection.sqlUpdate("INSERT INTO LoaiSanPham (MaLSP, TenLSP, MoTa) VALUES ('"
                + lsp.getMaLSP() + "', '" + lsp.getTenLSP() + "', '" + lsp.getMoTa() + "');");
        qllspConnection.closeConnect();
        return ok;
    }

    public Boolean delete(String malsp) {
        qllspConnection = new ConnectionDB();
        Boolean ok = qllspConnection.sqlUpdate("DELETE FROM LoaiSanPham WHERE LoaiSanPham.MaLSP = '" + malsp + "'");
        qllspConnection.closeConnect();
        return ok;
    }

    public Boolean update(String MaLSP, String TenLSP, String Mota) {
        qllspConnection = new ConnectionDB();
        Boolean ok = qllspConnection.sqlUpdate("UPDATE LoaiSanPham SET TenLSP = '" + TenLSP + "', MoTa = '" + Mota + "' WHERE MaLSP = '" + MaLSP + "'");
        qllspConnection.closeConnect();
        return ok;
    }

    public void close() {
        qllspConnection.closeConnect();
    }

}
