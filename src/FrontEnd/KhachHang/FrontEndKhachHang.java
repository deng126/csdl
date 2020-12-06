/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd.KhachHang;

import BackEnd.QuanLyKhachHang.KhachHang;
import BackEnd.QuanLyKhachHang.QuanLyKhachHangBUS;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TheAnhVu
 */
public class FrontEndKhachHang extends javax.swing.JPanel {

    QuanLyKhachHangBUS lspCtrl = new QuanLyKhachHangBUS();

    public FrontEndKhachHang() {
        initComponents();
        getData();
        tbKhachHang.setRowHeight(20);
    }
//---------------------GetData---------------------

    private void getData() {
        DefaultTableModel model = (DefaultTableModel) tbKhachHang.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        for (KhachHang lsp : lspCtrl.readDB()) {
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
        sc = new javax.swing.JScrollPane();
        tbKhachHang = new javax.swing.JTable();
        tfSDT = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        tfDiaChi = new javax.swing.JTextField();
        tfTenKH = new javax.swing.JTextField();
        tfMaKH = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        pnTimKiem.setBackground(null
        );
        pnTimKiem.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "Tìm kiếm khách hàng", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 13), new java.awt.Color(102, 102, 102))); // NOI18N
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
        pnTimKiem.setBounds(620, 10, 180, 45);

        tbKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khách hàng", "Tên khách hàng", "Địa chỉ", "SĐT"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbKhachHang.setFocusable(false);
        tbKhachHang.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tbKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbKhachHangMouseClicked(evt);
            }
        });
        sc.setViewportView(tbKhachHang);
        if (tbKhachHang.getColumnModel().getColumnCount() > 0) {
            tbKhachHang.getColumnModel().getColumn(0).setPreferredWidth(25);
            tbKhachHang.getColumnModel().getColumn(1).setPreferredWidth(100);
            tbKhachHang.getColumnModel().getColumn(2).setPreferredWidth(185);
            tbKhachHang.getColumnModel().getColumn(3).setPreferredWidth(25);
        }

        add(sc);
        sc.setBounds(20, 70, 780, 330);

        tfSDT.setBackground(null);
        tfSDT.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "SĐT", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
        add(tfSDT);
        tfSDT.setBounds(380, 480, 150, 40);

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
        btnThem.setBounds(630, 420, 90, 30);

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
        btnSua.setBounds(630, 460, 90, 30);

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
        btnXoa.setBounds(630, 500, 90, 30);

        tfDiaChi.setBackground(null);
        tfDiaChi.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "Địa chỉ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
        add(tfDiaChi);
        tfDiaChi.setBounds(140, 480, 230, 40);

        tfTenKH.setBackground(null);
        tfTenKH.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "Tên khách hàng", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
        add(tfTenKH);
        tfTenKH.setBounds(280, 430, 250, 40);

        tfMaKH.setBackground(null);
        tfMaKH.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "Mã khách hàng", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
        add(tfMaKH);
        tfMaKH.setBounds(140, 430, 130, 40);
    }// </editor-fold>//GEN-END:initComponents

//------------------Table----------------------------
    private void tbKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbKhachHangMouseClicked
        DefaultTableModel model = (DefaultTableModel) tbKhachHang.getModel();
        tfMaKH.setText(model.getValueAt(tbKhachHang.getSelectedRow(), 0).toString());
        tfTenKH.setText(model.getValueAt(tbKhachHang.getSelectedRow(), 1).toString());
        tfDiaChi.setText(model.getValueAt(tbKhachHang.getSelectedRow(), 2).toString());
        tfSDT.setText(model.getValueAt(tbKhachHang.getSelectedRow(), 3).toString());
    }//GEN-LAST:event_tbKhachHangMouseClicked
//--------------------End  Table----------------------
//--------------------SEARCH--------------------------
    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        DefaultTableModel model = (DefaultTableModel) tbKhachHang.getModel();
        model.setRowCount(0);
        ArrayList<KhachHang> dssp = lspCtrl.search(tfTimKiem.getText().trim());
        if (dssp.size() == 0) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy " + tfTimKiem.getText().trim());
            tfTimKiem.requestFocus();
        } else {
            for (KhachHang sp : dssp) {
                model.addRow(sp.toArray());
            }
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void tfTimKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTimKiemKeyPressed
        DefaultTableModel model = (DefaultTableModel) tbKhachHang.getModel();
        ArrayList<KhachHang> dslsp = lspCtrl.search(tfTimKiem.getText().trim());

        if (evt.getKeyCode() == evt.VK_ENTER && dslsp.size() > 0) {
            while (model.getRowCount() > 0) {
                model.removeRow(0);
            }
            if (dslsp.size() == 0) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy " + tfTimKiem.getText().trim());
            } else {
                for (KhachHang sp : dslsp) {
                    model.addRow(sp.toArray());
                }
            }
        }
    }//GEN-LAST:event_tfTimKiemKeyPressed
//----------------------------------END SEARCH----------
//----------------------------------ADD-----------------
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        JTextField[] tfTT = {tfMaKH, tfTenKH, tfDiaChi, tfSDT};
        for (int i = 0; i < tfTT.length; i++) {
            if (tfTT[i].getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Sai thông tin!");
                return;
            }
        }
        lspCtrl.add(tfMaKH.getText(), tfTenKH.getText(), tfDiaChi.getText(), tfSDT.getText());

        JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
        getData();
    }//GEN-LAST:event_btnThemActionPerformed
//----------------------------------END ADD---------------------------------
//----------------------------------UPDATE---------------------------------  
    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (tbKhachHang.getSelectedRow() != -1) {
            lspCtrl.update(tfMaKH.getText(), tfTenKH.getText(), tfDiaChi.getText(), tfSDT.getText());
            JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
            getData();
        } else {
            JOptionPane.showMessageDialog(this, "Chọn Nhân viên!");
        }
    }//GEN-LAST:event_btnSuaActionPerformed
//---------------------------------END  UPDATE--------------------------------
//---------------------------------REMOVE--------------------------------
    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (tbKhachHang.getSelectedRow() != -1) {
            lspCtrl.delete(tfMaKH.getText());
            JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
            getData();
        } else {
            JOptionPane.showMessageDialog(this, "Chọn Nhân viên!");
        }
    }//GEN-LAST:event_btnXoaActionPerformed
//---------------------------------END REMOVE--------------------------------

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JPanel pnTimKiem;
    private javax.swing.JScrollPane sc;
    private javax.swing.JTable tbKhachHang;
    private javax.swing.JTextField tfDiaChi;
    private javax.swing.JTextField tfMaKH;
    private javax.swing.JTextField tfSDT;
    private javax.swing.JTextField tfTenKH;
    private javax.swing.JTextField tfTimKiem;
    // End of variables declaration//GEN-END:variables
}
