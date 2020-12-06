/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd.QuanLyChiTietPhieuNhap;

import BackEnd.Connection.ConnectionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class QuanLyChiTietPhieuNhapDAO {

    ConnectionDB qlctpnConnection;

    public QuanLyChiTietPhieuNhapDAO() {

    }

    public ArrayList<ChiTietPhieuNhap> readDB() {
        qlctpnConnection = new ConnectionDB();
        ArrayList<ChiTietPhieuNhap> dsctpn = new ArrayList<>();

        try {
            String query = "SELECT * FROM ChiTietPhieuNhap";
            ResultSet r = qlctpnConnection.sqlQuery(query);
            if (r != null) {
                while (r.next()) {
                    String mapn = r.getString("MaPN");
                    String masp = r.getString("MaSP");
                    int soluong = r.getInt("SoLuong");
                    double dongia = r.getDouble("DonGia");

                    dsctpn.add(new ChiTietPhieuNhap(mapn, masp, soluong, dongia));
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi đọc dữ liệu bảng chi tiết phiếu nhập");
        } finally {
            qlctpnConnection.closeConnect();
        }

        return dsctpn;
    }

    public ArrayList<ChiTietPhieuNhap> search(String value) {
        qlctpnConnection = new ConnectionDB();
        ArrayList<ChiTietPhieuNhap> dsctpn = new ArrayList<>();

        try {
            String qry = "SELECT * FROM ChiTietPhieuNhap WHERE MaPN = '" + value + "';";
            ResultSet r = qlctpnConnection.sqlQuery(qry);
            if (r != null) {
                while (r.next()) {
                    String mapn = r.getString("MaPN");
                    String masp = r.getString("MaSP");
                    int soluong = r.getInt("SoLuong");
                    double dongia = r.getDouble("DonGia");

                    dsctpn.add(new ChiTietPhieuNhap(mapn, masp, soluong, dongia));
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi tìm dữ liệu = " + value + " bảng chi tiết phiếu nhập");
        } finally {
            qlctpnConnection.closeConnect();
        }

        return dsctpn;
    }

    public Boolean add(ChiTietPhieuNhap ctpn) {
        qlctpnConnection = new ConnectionDB();
        Boolean ok = qlctpnConnection.sqlUpdate("INSERT INTO ChiTietPhieuNhap (MaPN, MaSP, SoLuong, DonGia) VALUES('"
                + ctpn.getMaPN() + "', '"
                + ctpn.getMaSP() + "', '"
                + ctpn.getSoLuong() + "', '"
                + ctpn.getDonGia() + "')");
        qlctpnConnection.closeConnect();
        return ok;
    }

    public Boolean delete(String mapn, String masp) {
        qlctpnConnection = new ConnectionDB();
        Boolean ok = qlctpnConnection.sqlUpdate("DELETE FROM ChiTietPhieuNhap WHERE "
                + "ChiTietPhieuNhap.MaPN = '" + mapn
                + "' AND ChiTietPhieuNhap.MaSP = '" + masp + "'");
        qlctpnConnection.closeConnect();
        return ok;
    }

    public boolean update(String MaPN, String MaSP, int SoLuong, double DonGia) {
        qlctpnConnection = new ConnectionDB();
        Boolean ok = qlctpnConnection.sqlUpdate("UPDATE ChiTietPhieuNhap SET "
                + "'SoLuong = '" + SoLuong
                + "', DonGia = '" + DonGia
                + "' WHERE MaPN = '" + MaPN + "' AND MaSP = '" + MaSP + "'");
        qlctpnConnection.closeConnect();
        return ok;
    }

    public void close() {
        qlctpnConnection.closeConnect();
    }

}
