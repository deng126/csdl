/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd.QuanLyNhanVien;

import BackEnd.Connection.ConnectionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class QuanLyNhanVienDAO {

    ConnectionDB qlnvConnection;

    public QuanLyNhanVienDAO() {

    }

    public ArrayList<NhanVien> readDB() {
        ArrayList<NhanVien> dsnv = new ArrayList<>();
        qlnvConnection = new ConnectionDB();
        
        try {
            String qry = "SELECT * FROM NhanVien";
            ResultSet r = qlnvConnection.sqlQuery(qry);
            if (r != null) {
                while (r.next()) {
                    String manv = r.getString("MaNV");
                    String tennv = r.getString("TenNV");
                    LocalDate ngaysinh = r.getDate("NgaySinh").toLocalDate();
                    String diachi = r.getString("DiaChi");
                    String sdt = r.getString("SDT");
                    
                    dsnv.add(new NhanVien(manv, tennv, ngaysinh, diachi, sdt));
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi đọc dữ liệu bảng nhân viên");
        } finally {
            qlnvConnection.closeConnect();
        }
        
        return dsnv;
    }

    public ArrayList<NhanVien> search(String value) {
        qlnvConnection = new ConnectionDB();
        ArrayList<NhanVien> dsnv = new ArrayList<>();

        try {
            String qry = "SELECT * FROM NhanVien WHERE MaNV LIKE '%" + value + "%' OR TenNV LIKE '%" + value + "%';";
            ResultSet r = qlnvConnection.sqlQuery(qry);
            if (r != null) {
                while (r.next()) {
                    String manv = r.getString("MaNV");
                    String tennv = r.getString("TenNV");
                    LocalDate ngaysinh = r.getDate("NgaySinh").toLocalDate();
                    String diachi = r.getString("DiaChi");
                    String sdt = r.getString("SDT");
                    
                    dsnv.add(new NhanVien(manv, tennv, ngaysinh, diachi, sdt));
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi tìm dữ liệu = " + value + " bảng nhân viên");
        } finally {
            qlnvConnection.closeConnect();
        }

        return dsnv;
    }

    public Boolean add(NhanVien nv) {
        qlnvConnection = new ConnectionDB();
        Boolean ok = qlnvConnection.sqlUpdate("INSERT INTO NhanVien (MaNV, TenNV, NgaySinh, DiaChi, SDT) VALUES ('"
                + nv.getMaNV() + "', '"
                + nv.getTenNV() + "', '" 
                + nv.getNgaySinh() + "', '" 
                + nv.getDiaChi() + "', '" 
                + nv.getSDT() + "');");
        qlnvConnection.closeConnect();
        return ok;
    }

    public Boolean delete(String manv) {
        qlnvConnection = new ConnectionDB();
        Boolean ok = qlnvConnection.sqlUpdate("DELETE FROM NhanVien WHERE NhanVien.MaNV = '" + manv + "'");
        qlnvConnection.closeConnect();
        return ok;
    }

    public Boolean update(String MaNV, String TenNV, LocalDate NgaySinh, String DiaChi, String SDT) {
        qlnvConnection = new ConnectionDB();
        Boolean ok = qlnvConnection.sqlUpdate("UPDATE NhanVien SET "
                + "TenNV = '" + TenNV
                + "', NgaySinh = '" + NgaySinh 
                + "', DiaChi = '" + DiaChi 
                + "', SDT= '" + SDT 
                + "' WHERE MaNV = '" + MaNV + "'");
        qlnvConnection.closeConnect();
        return ok;
    }
    
    public void close() {
        qlnvConnection.closeConnect();
    }
    
}
