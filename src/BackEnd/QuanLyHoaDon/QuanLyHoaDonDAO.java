/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd.QuanLyHoaDon;

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
public class QuanLyHoaDonDAO {

    ConnectionDB qlhdConnection;

    public QuanLyHoaDonDAO() {

    }

    public ArrayList<HoaDon> readDB() {
        qlhdConnection = new ConnectionDB();
        ArrayList<HoaDon> dshd = new ArrayList<>();

        try {
            String qry = "SELECT * FROM HoaDon";
            ResultSet r = qlhdConnection.sqlQuery(qry);
            if (r != null) {
                while (r.next()) {
                    String mahd = r.getString("MaHD");
                    String manv = r.getString("MaNV");
                    String makh = r.getString("MaKH");
                    LocalDateTime ngaygiolap = r.getTimestamp("NgayGioLap").toLocalDateTime();
                    double tongtien = r.getDouble("TongTien");

                    dshd.add(new HoaDon(mahd, manv, makh, ngaygiolap, tongtien));
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi đọc dữ liệu bảng hóa đơn");
        } finally {
            qlhdConnection.closeConnect();
        }

        return dshd;
    }
    
    public ArrayList<HoaDon> search(String value1, String value2) {
        qlhdConnection = new ConnectionDB();
        ArrayList<HoaDon> dshd = new ArrayList<>();

        try {
            String qry = "SELECT * FROM HoaDon WHERE MONTH(NgayGioLap) = '" + value1 + "' AND YEAR(NgayGioLap) = '" + value2 + "'";
            ResultSet r = qlhdConnection.sqlQuery(qry);
            if (r != null) {
                while (r.next()) {
                    String mahd = r.getString("MaHD");
                    String manv = r.getString("MaNV");
                    String makh = r.getString("MaKH");
                    LocalDateTime ngaygiolap = r.getTimestamp("NgayGioLap").toLocalDateTime();
                    double tongtien = r.getDouble("TongTien");
                    
                    dshd.add(new HoaDon(mahd, manv, makh, ngaygiolap, tongtien));
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi tìm dữ liệu tháng = " + value1 + ", năm = " + value2 + " bảng hóa đơn");
        } finally {
            qlhdConnection.closeConnect();
        }

        return dshd;
    }
    
    public Boolean add(HoaDon hd) {
        qlhdConnection = new ConnectionDB();
        Boolean ok = qlhdConnection.sqlUpdate("INSERT INTO HoaDon(MaHD, MaNV, MaKH, NgayGioLap, TongTien) VALUES ('"
                + hd.getMaHD() + "', '"
                + hd.getMaNV() + "', '"
                + hd.getMaKH() + "', '"
                + hd.getNgayGioLap() + "', '"
                + hd.getTongTien() + "');");
        qlhdConnection.closeConnect();
        return ok;
    }

// cần nghiên cứu
    public Boolean delete(String mahd) {
        qlhdConnection = new ConnectionDB();
        if (!qlhdConnection.sqlUpdate("DELETE FROM HoaDon WHERE HoaDon.MaHD = '" + mahd + "'")) {
            JOptionPane.showMessageDialog(null, "Vui long xoa het chi tiet cua hoa don truoc !!!");
            qlhdConnection.closeConnect();
            return false;
        }
        qlhdConnection.closeConnect();
        return true;
    }

    public Boolean update(String MaHD, String MaNV, String MaKH, LocalDateTime NgayGioLap, double TongTien) {
        qlhdConnection = new ConnectionDB();
        Boolean ok = qlhdConnection.sqlUpdate("UPDATE HoaDon SET "
                + "MaNV = '" + MaHD
                + "', MaKH = '" + MaKH
                + "', NgayGioLap = '" + NgayGioLap
                + "', TongTien = '" + TongTien
                + "' WHERE MaHD = '" + MaHD + "'");
        qlhdConnection.closeConnect();
        return ok;
    }

    public Boolean updateTongTien(String MaHD, double TongTien) {
        qlhdConnection = new ConnectionDB();
        Boolean ok = qlhdConnection.sqlUpdate("UPDATE HoaDon SET TongTien = '" + TongTien
                + "' WHERE MaHD = '" + MaHD + "'");
        qlhdConnection.closeConnect();
        return ok;
    }

    public void close() {
        qlhdConnection.closeConnect();
    }
    
}
