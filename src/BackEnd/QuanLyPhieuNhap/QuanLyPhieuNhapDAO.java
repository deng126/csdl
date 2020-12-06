/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd.QuanLyPhieuNhap;

import BackEnd.Connection.ConnectionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class QuanLyPhieuNhapDAO {

    ConnectionDB qlpnConnection;

    public QuanLyPhieuNhapDAO() {
        
    }

    public ArrayList<PhieuNhap> readDB() {
        qlpnConnection = new ConnectionDB();
        ArrayList<PhieuNhap> dspn = new ArrayList<>();
        
        try {
            String qry = "SELECT * FROM PhieuNhap";
            ResultSet r = qlpnConnection.sqlQuery(qry);
            if (r != null) {
                while (r.next()) {
                    String mapn = r.getString("MaPN");
                    String mancc = r.getString("MaNCC");
                    String manv = r.getString("MaNV");
                    LocalDateTime ngaygionhap = r.getTimestamp("NgayGioNhap").toLocalDateTime();
                    double tongtien = r.getDouble("TongTien");

                    dspn.add(new PhieuNhap(mapn, mancc, manv, ngaygionhap, tongtien));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi đọc dữ liệu bảng phiếu nhập");
        } finally {
            qlpnConnection.closeConnect();
        }
        
        return dspn;
    }
    
    public ArrayList<PhieuNhap> search(String value1, String value2) {
        qlpnConnection = new ConnectionDB();
        ArrayList<PhieuNhap> dspn = new ArrayList<>();

        try {
            String qry = "SELECT * FROM PhieuNhap WHERE MONTH(NgayGioNhap) = '" + value1 + "' AND YEAR(NgayGioNhap) = '" + value2 + "';";
            //String qry = "SELECT * FROM PhieuNhap WHERE MONTH(NgayGioNhap) = '09';";

            ResultSet r = qlpnConnection.sqlQuery(qry);
            if (r != null) {
                while (r.next()) {
                    String mapn = r.getString("MaPN");
                    String mancc = r.getString("MaNCC");
                    String manv = r.getString("MaNV");
                    LocalDateTime ngaygionhap = r.getTimestamp("NgayGioNhap").toLocalDateTime();
                    double tongtien = r.getDouble("TongTien");

                    dspn.add(new PhieuNhap(mapn, mancc, manv, ngaygionhap, tongtien));
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi tìm dữ liệu tháng = " + value1 + ", năm = " + value2 + " bảng phiếu nhập");
        } finally {
            qlpnConnection.closeConnect();
        }

        return dspn;
    }
    
    public Boolean add(PhieuNhap pn) {
        qlpnConnection = new ConnectionDB();
        Boolean ok = qlpnConnection.sqlUpdate("INSERT INTO PhieuNhap (MaPN, MaNCC, MaNV, NgayGioNhap, TongTien) VALUES ('"
                + pn.getMaPN() + "', '"
                + pn.getMaNCC() + "', '"
                + pn.getMaNV() + "', '"
                + pn.getNgayGioNhap() + "', '"
                + pn.getTongTien() + "')");
        qlpnConnection.closeConnect();
        return ok;
    }

    public Boolean delete(String mapn) {
        qlpnConnection = new ConnectionDB();
        if (!qlpnConnection.sqlUpdate("DELETE FROM PhieuNhap WHERE MaPN = '" + mapn + "'")) {
            JOptionPane.showMessageDialog(null, "Vui long xoa het chi tiet cua phiếu nhập truoc !!!");
            qlpnConnection.closeConnect();
            return false;
        }
        qlpnConnection.closeConnect();
        return false;
    }

    public Boolean update(String MaPN, String MaNCC, String MaNV, LocalDateTime NgayGioNhap, double TongTien) {
        qlpnConnection = new ConnectionDB();
        Boolean ok = qlpnConnection.sqlUpdate("UPDATE PhieuNhap SET "
                + "MaNCC = '" + MaPN
                + "', MaNV = '" + MaNV
                + "', NgayGioNhap = '" + NgayGioNhap
                + "', TongTien = '" + TongTien
                + "' WHERE MaPN = '" + MaPN + "'");
        qlpnConnection.closeConnect();
        return ok;
    }

    public Boolean updateTongTien(String MaPN, double TongTien) {
        qlpnConnection = new ConnectionDB();
        Boolean ok = qlpnConnection.sqlUpdate("UPDATE PhieuNhap SET TongTien = '" + TongTien
                + "' WHERE MaPN = '" + MaPN + "'");
        qlpnConnection.closeConnect();
        return ok;
    }
    
    public void close() {
        qlpnConnection.closeConnect();
    }
    
}
