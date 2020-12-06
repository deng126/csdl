
package FrontEnd.NhanVien;

import BackEnd.QuanLyNhanVien.NhanVien;
import BackEnd.QuanLyNhanVien.QuanLyNhanVienBUS;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class FrontEndNhanVien extends javax.swing.JPanel {

    /**
     * Creates new form KhachHangShow
     */
    QuanLyNhanVienBUS lspCtrl = new QuanLyNhanVienBUS();

    public FrontEndNhanVien() {
        initComponents();
        getData();
        tbNhanVien.setRowHeight(20);
    }

    //---------------------GetData---------------------
    private void getData() {
        DefaultTableModel model = (DefaultTableModel) tbNhanVien.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        for (NhanVien lsp : lspCtrl.readDB()) {
            model.addRow(lsp.toArray());
        }
    }

    //-------------------End GetData-------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnTimKiem = new javax.swing.JPanel();
        btnTimKiem = new javax.swing.JButton();
        tfTimKiem = new javax.swing.JTextField();
        btnSua = new javax.swing.JButton();
        tfDiaChi = new javax.swing.JTextField();
        btnXoa = new javax.swing.JButton();
        tfSDT = new javax.swing.JTextField();
        sc = new javax.swing.JScrollPane();
        tbNhanVien = new javax.swing.JTable();
        tfMaNV = new javax.swing.JTextField();
        tfNgaySinh = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        tfTenNV = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(820, 550));
        setLayout(null);

        pnTimKiem.setBackground(null
        );
        pnTimKiem.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "Tìm tên nhân viên", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(102, 102, 102))); // NOI18N
        pnTimKiem.setPreferredSize(new java.awt.Dimension(180, 50));

        btnTimKiem.setBackground(null);
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconImage/timkiem.png"))); // NOI18N
        btnTimKiem.setText(null);
        btnTimKiem.setBorder(null);
        btnTimKiem.setBorderPainted(false);
        btnTimKiem.setContentAreaFilled(false);
        btnTimKiem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        tfTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfTimKiemKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout pnTimKiemLayout = new javax.swing.GroupLayout(pnTimKiem);
        pnTimKiem.setLayout(pnTimKiemLayout);
        pnTimKiemLayout.setHorizontalGroup(
            pnTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTimKiemLayout.createSequentialGroup()
                .addComponent(tfTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnTimKiemLayout.setVerticalGroup(
            pnTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTimKiemLayout.createSequentialGroup()
                .addGroup(pnTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(tfTimKiem, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(pnTimKiem);
        pnTimKiem.setBounds(620, 10, 180, 50);

        btnSua.setBackground(new java.awt.Color(0, 77, 97));
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconImage/sua.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.setBorder(null);
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        add(btnSua);
        btnSua.setBounds(620, 460, 90, 30);

        tfDiaChi.setBackground(null);
        tfDiaChi.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "Địa chỉ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
        add(tfDiaChi);
        tfDiaChi.setBounds(100, 470, 320, 35);

        btnXoa.setBackground(new java.awt.Color(0, 77, 97));
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconImage/xoa.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.setBorder(null);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        add(btnXoa);
        btnXoa.setBounds(620, 500, 90, 30);

        tfSDT.setBackground(null);
        tfSDT.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "SDT", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
        add(tfSDT);
        tfSDT.setBounds(430, 470, 170, 35);

        tbNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhân viên", "Tên nhân viên", "Ngày sinh", "Địa chỉ", "SĐT"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbNhanVien.setFocusable(false);
        tbNhanVien.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tbNhanVien.getTableHeader().setResizingAllowed(false);
        tbNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbNhanVienMouseClicked(evt);
            }
        });
        sc.setViewportView(tbNhanVien);
        if (tbNhanVien.getColumnModel().getColumnCount() > 0) {
            tbNhanVien.getColumnModel().getColumn(0).setPreferredWidth(25);
            tbNhanVien.getColumnModel().getColumn(1).setPreferredWidth(100);
            tbNhanVien.getColumnModel().getColumn(2).setPreferredWidth(25);
            tbNhanVien.getColumnModel().getColumn(3).setPreferredWidth(185);
            tbNhanVien.getColumnModel().getColumn(4).setPreferredWidth(25);
        }

        add(sc);
        sc.setBounds(20, 70, 780, 330);

        tfMaNV.setBackground(null);
        tfMaNV.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "Mã nhân viên", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
        add(tfMaNV);
        tfMaNV.setBounds(100, 420, 130, 35);
        tfMaNV.getAccessibleContext().setAccessibleName("ID");

        tfNgaySinh.setBackground(null);
        tfNgaySinh.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "Ngày sinh", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
        add(tfNgaySinh);
        tfNgaySinh.setBounds(470, 420, 130, 35);

        btnThem.setBackground(new java.awt.Color(0, 77, 97));
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconImage/them.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setBorder(null);
        btnThem.setBorderPainted(false);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        add(btnThem);
        btnThem.setBounds(620, 420, 90, 30);

        tfTenNV.setBackground(null);
        tfTenNV.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "Tên khách hàng", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
        add(tfTenNV);
        tfTenNV.setBounds(240, 420, 220, 35);
    }// </editor-fold>//GEN-END:initComponents

//------------------Table----------------------------
    private void tbNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbNhanVienMouseClicked
        DefaultTableModel model = (DefaultTableModel) tbNhanVien.getModel();
        tfMaNV.setText(model.getValueAt(tbNhanVien.getSelectedRow(), 0).toString());
        tfTenNV.setText(model.getValueAt(tbNhanVien.getSelectedRow(), 1).toString());
        tfNgaySinh.setText(model.getValueAt(tbNhanVien.getSelectedRow(), 2).toString());
        tfDiaChi.setText(model.getValueAt(tbNhanVien.getSelectedRow(), 3).toString());
        tfSDT.setText(model.getValueAt(tbNhanVien.getSelectedRow(), 4).toString());

    }//GEN-LAST:event_tbNhanVienMouseClicked
//---------------------------------Add---------------------------------
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        JTextField[] tfTT = {tfMaNV, tfTenNV, tfNgaySinh, tfDiaChi, tfSDT};
        for (int i = 0; i < tfTT.length; i++) {
            if (tfTT[i].getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Sai thông tin!");
                return;
            }
        }
        try {
            LocalDate date = LocalDate.parse(tfNgaySinh.getText());
            lspCtrl.add(
                    tfMaNV.getText(),
                    tfTenNV.getText(),
                    date,
                    tfDiaChi.getText(),
                     tfSDT.getText());
        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(this, "Sai ngày sinh");
        }

        JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
        getData();

    }//GEN-LAST:event_btnThemActionPerformed
//-------------------------------End Add-------------------------------
//---------------------------Search------------------------------------
    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        DefaultTableModel model = (DefaultTableModel) tbNhanVien.getModel();
        model.setRowCount(0);
        ArrayList<NhanVien> dssp = lspCtrl.search(tfTimKiem.getText().trim());
        if (dssp.size() == 0) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy " + tfTimKiem.getText().trim());
            tfTimKiem.requestFocus();
        } else {
            for (NhanVien sp : dssp) {
                model.addRow(sp.toArray());
            }
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void tfTimKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTimKiemKeyPressed
        DefaultTableModel model = (DefaultTableModel) tbNhanVien.getModel();
        ArrayList<NhanVien> dslsp = lspCtrl.search(tfTimKiem.getText().trim());

        if (evt.getKeyCode() == evt.VK_ENTER && dslsp.size() > 0) {
            while (model.getRowCount() > 0) {
                model.removeRow(0);
            }
            if (dslsp.size() == 0) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy " + tfTimKiem.getText().trim());
            } else {
                for (NhanVien sp : dslsp) {
                    model.addRow(sp.toArray());
                }
            }
        }
    }//GEN-LAST:event_tfTimKiemKeyPressed
//--------------------------------End Search---------------------------
//----------------------------------update-----------------------------
    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (tbNhanVien.getSelectedRow() != -1) {
            try {
                LocalDate date = LocalDate.parse(tfNgaySinh.getText());
                lspCtrl.update(tfMaNV.getText(),tfTenNV.getText(),date,tfDiaChi.getText(),tfSDT.getText());
            } catch (Exception ex) {
                JOptionPane.showConfirmDialog(this, "Sai ngày sinh");
            }
            JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
            getData();

        } else {
            JOptionPane.showMessageDialog(this, "Chọn Nhân viên!");
        }
    }//GEN-LAST:event_btnSuaActionPerformed
//--------------------------------End Update---------------------------
//--------------------------------Remove-------------------------------
    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (tbNhanVien.getSelectedRow() != -1) {
            lspCtrl.delete(tfMaNV.getText());
            JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
            getData();
        } else {
            JOptionPane.showMessageDialog(this, "Chọn Nhân viên!");
        }
    }//GEN-LAST:event_btnXoaActionPerformed
//---------------------------------End Remove-------------------------

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JPanel pnTimKiem;
    private javax.swing.JScrollPane sc;
    private javax.swing.JTable tbNhanVien;
    private javax.swing.JTextField tfDiaChi;
    private javax.swing.JTextField tfMaNV;
    private javax.swing.JTextField tfNgaySinh;
    private javax.swing.JTextField tfSDT;
    private javax.swing.JTextField tfTenNV;
    private javax.swing.JTextField tfTimKiem;
    // End of variables declaration//GEN-END:variables
}
