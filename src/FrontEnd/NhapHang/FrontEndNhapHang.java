/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd.NhapHang;

import BackEnd.QuanLyChiTietPhieuNhap.QuanLyChiTietPhieuNhapBUS;
import BackEnd.QuanLyNhaCungCap.NhaCungCap;
import BackEnd.QuanLyNhaCungCap.QuanLyNhaCungCapBUS;
import BackEnd.QuanLyNhanVien.NhanVien;
import BackEnd.QuanLyNhanVien.QuanLyNhanVienBUS;
import BackEnd.QuanLyPhieuNhap.QuanLyPhieuNhapBUS;
import BackEnd.QuanLySanPham.QuanLySanPhamBUS;
import BackEnd.QuanLySanPham.SanPham;
import java.awt.Color;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TheAnhVu
 */
public class FrontEndNhapHang extends javax.swing.JPanel {

    /**
     * Creates new form BanHangtblShow
     */
    QuanLyNhanVienBUS nvCtrl = new QuanLyNhanVienBUS();
    QuanLyNhaCungCapBUS nccCtrl = new QuanLyNhaCungCapBUS();
    QuanLySanPhamBUS spCtrl = new QuanLySanPhamBUS();
    QuanLyPhieuNhapBUS pnCtrl = new QuanLyPhieuNhapBUS();
    QuanLyChiTietPhieuNhapBUS ctpnCtrl = new QuanLyChiTietPhieuNhapBUS();
    DefaultTableModel model;
    private ArrayList<Integer> listChon = new ArrayList<>();//Lưu vị trí sản phẩm được chọn
    private ArrayList<SanPham> list = new ArrayList<>();// Lưu những sản phẩm được chọn
    private String MaNCC = "";//Lấy ra MÃ NCC
    private int soLuongConLai = 0;

    public FrontEndNhapHang() {
        initComponents();
        getDataNcc();
        getDataSP();
        getDataNV();
        enableX();
        tbHDSanPham.setRowHeight(20);
        tbNcc.setRowHeight(20);
        tbSanPham.setRowHeight(20);
    }
//Không cho thay đổi TextField

    private void enableX() {
        tfTenNCC.setEditable(false);
        tfDiaChi.setEditable(false);
        tfSDT.setEditable(false);
        tfMaSp.setEditable(false);
        tfTenSP.setEditable(false);
        tfDonGia.setEditable(false);
    }
//---------------------GetDataKH---------------------

    private void getDataNcc() {
        model = (DefaultTableModel) tbNcc.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        for (NhaCungCap ncc : nccCtrl.readDB()) {
            model.addRow(ncc.toArray());
        }
    }
//-------------------END-------------------
//---------------------GetDataSP---------------------

    private void getDataSP() {
        model = (DefaultTableModel) tbSanPham.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        for (SanPham lsp : spCtrl.readDB()) {
            model.addRow(lsp.toNhapHang());
        }
    }
//-------------------END-------------------
//--------------GetDataNV--------------------------

    private void getDataNV() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) jComboBoxNV.getModel();
        for (NhanVien nv : nvCtrl.readDB()) {
            model.addElement(nv.getMaNV());
        }
    }
//-------------END-----------------------

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbHDSanPham = new javax.swing.JTable();
        TTSP = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tfMaSp = new javax.swing.JTextField();
        tfDonGia = new javax.swing.JTextField();
        tfTenSP = new javax.swing.JTextField();
        tfSoLuong = new javax.swing.JTextField();
        btnOK = new javax.swing.JButton();
        tfTenNCC = new javax.swing.JTextField();
        tfDiaChi = new javax.swing.JTextField();
        tfSDT = new javax.swing.JTextField();
        jComboBoxNV = new javax.swing.JComboBox<>();
        btnThanhToan = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jlbTongTien = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        tfMaPN = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbSanPham = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbNcc = new javax.swing.JTable();
        pnTimKiem = new javax.swing.JPanel();
        btnTimKiemKH = new javax.swing.JButton();
        tfTimKiemKH = new javax.swing.JTextField();
        pnTimKiem1 = new javax.swing.JPanel();
        btnTimKiemSP = new javax.swing.JButton();
        tfTimKiemSP = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 4));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 77, 97));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PHIẾU NHẬP");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 150, -1));

        tbHDSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Số lượng", "Đơn giá"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tbHDSanPham);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 320, 140));

        TTSP.setBackground(new java.awt.Color(255, 255, 255));
        TTSP.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin sản phẩm"));
        TTSP.setLayout(null);

        jLabel9.setText("Mã SP");
        TTSP.add(jLabel9);
        jLabel9.setBounds(11, 28, 36, 16);

        jLabel10.setText("Đơn giá/1");
        TTSP.add(jLabel10);
        jLabel10.setBounds(11, 70, 56, 16);

        jLabel11.setText("Tên SP");
        TTSP.add(jLabel11);
        jLabel11.setBounds(150, 28, 41, 16);

        jLabel12.setText("Số Lượng");
        TTSP.add(jLabel12);
        jLabel12.setBounds(150, 70, 54, 16);
        TTSP.add(tfMaSp);
        tfMaSp.setBounds(71, 24, 73, 22);
        TTSP.add(tfDonGia);
        tfDonGia.setBounds(71, 66, 73, 22);

        tfTenSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTenSPActionPerformed(evt);
            }
        });
        TTSP.add(tfTenSP);
        tfTenSP.setBounds(196, 24, 113, 22);

        tfSoLuong.setText("0");
        tfSoLuong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfSoLuongMouseClicked(evt);
            }
        });
        tfSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSoLuongActionPerformed(evt);
            }
        });
        TTSP.add(tfSoLuong);
        tfSoLuong.setBounds(213, 66, 40, 22);

        btnOK.setBackground(new java.awt.Color(0, 77, 97));
        btnOK.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        btnOK.setForeground(new java.awt.Color(255, 255, 255));
        btnOK.setText("CHỌN ");
        btnOK.setBorder(null);
        btnOK.setBorderPainted(false);
        btnOK.setContentAreaFilled(false);
        btnOK.setOpaque(true);
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });
        TTSP.add(btnOK);
        btnOK.setBounds(260, 65, 50, 25);

        jPanel1.add(TTSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 320, 100));

        tfTenNCC.setBorder(javax.swing.BorderFactory.createTitledBorder("Tên NCC"));
        jPanel1.add(tfTenNCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 160, -1));

        tfDiaChi.setBorder(javax.swing.BorderFactory.createTitledBorder("Địa chỉ"));
        jPanel1.add(tfDiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 140, -1));

        tfSDT.setBorder(javax.swing.BorderFactory.createTitledBorder("SĐT"));
        tfSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSDTActionPerformed(evt);
            }
        });
        jPanel1.add(tfSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 130, -1));

        jComboBoxNV.setBorder(javax.swing.BorderFactory.createTitledBorder("Nhân viên"));
        jComboBoxNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxNVActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 110, 40));

        btnThanhToan.setBackground(new java.awt.Color(0, 77, 97));
        btnThanhToan.setFont(new java.awt.Font("Meiryo", 1, 14)); // NOI18N
        btnThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        btnThanhToan.setText("NHẬP HÀNG");
        btnThanhToan.setBorder(null);
        btnThanhToan.setBorderPainted(false);
        btnThanhToan.setContentAreaFilled(false);
        btnThanhToan.setOpaque(true);
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });
        jPanel1.add(btnThanhToan, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 510, 250, 30));

        jLabel7.setText("Tổng tiền : ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 486, -1, 20));
        jPanel1.add(jlbTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 480, 230, 30));

        btnReset.setBackground(new java.awt.Color(0, 153, 153));
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setText("Làm mới");
        btnReset.setBorder(null);
        btnReset.setBorderPainted(false);
        btnReset.setContentAreaFilled(false);
        btnReset.setOpaque(true);
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        jPanel1.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 80, 30));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 158, 230, -1));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 230, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 77, 97));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Sản phẩm chọn");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 230, 40));

        tfMaPN.setForeground(new java.awt.Color(217, 217, 217));
        tfMaPN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfMaPN.setText("PNxx");
        tfMaPN.setBorder(javax.swing.BorderFactory.createTitledBorder("Mã PN"));
        tfMaPN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfMaPNMouseClicked(evt);
            }
        });
        jPanel1.add(tfMaPN, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, 70, 40));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 350, 550));

        tbSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Số lượng còn", "Đơn giá"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSanPhamMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbSanPham);
        if (tbSanPham.getColumnModel().getColumnCount() > 0) {
            tbSanPham.getColumnModel().getColumn(0).setPreferredWidth(40);
            tbSanPham.getColumnModel().getColumn(1).setPreferredWidth(140);
            tbSanPham.getColumnModel().getColumn(2).setPreferredWidth(60);
            tbSanPham.getColumnModel().getColumn(3).setPreferredWidth(60);
        }

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 450, 210));

        tbNcc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã NCC", "Tên NCC", "Địa chỉ", "SĐT"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbNcc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbNccMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbNcc);
        if (tbNcc.getColumnModel().getColumnCount() > 0) {
            tbNcc.getColumnModel().getColumn(0).setPreferredWidth(40);
            tbNcc.getColumnModel().getColumn(1).setPreferredWidth(140);
            tbNcc.getColumnModel().getColumn(2).setPreferredWidth(60);
            tbNcc.getColumnModel().getColumn(3).setPreferredWidth(60);
        }

        add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 450, 210));

        pnTimKiem.setBackground(null
        );
        pnTimKiem.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "Nhà cung cấp(Mã/Tên)", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 13), new java.awt.Color(102, 102, 102))); // NOI18N
        pnTimKiem.setPreferredSize(new java.awt.Dimension(180, 50));

        btnTimKiemKH.setBackground(null);
        btnTimKiemKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconImage/timkiem.png"))); // NOI18N
        btnTimKiemKH.setText(null);
        btnTimKiemKH.setBorder(null);
        btnTimKiemKH.setBorderPainted(false);
        btnTimKiemKH.setContentAreaFilled(false);
        btnTimKiemKH.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTimKiemKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemKHActionPerformed(evt);
            }
        });

        tfTimKiemKH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfTimKiemKHKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout pnTimKiemLayout = new javax.swing.GroupLayout(pnTimKiem);
        pnTimKiem.setLayout(pnTimKiemLayout);
        pnTimKiemLayout.setHorizontalGroup(
            pnTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTimKiemLayout.createSequentialGroup()
                .addComponent(tfTimKiemKH, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTimKiemKH, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnTimKiemLayout.setVerticalGroup(
            pnTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTimKiemLayout.createSequentialGroup()
                .addGroup(pnTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(tfTimKiemKH, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTimKiemKH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(pnTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 8, -1, 45));

        pnTimKiem1.setBackground(null
        );
        pnTimKiem1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "Sản phẩm(Mã/Tên)", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 13), new java.awt.Color(102, 102, 102))); // NOI18N
        pnTimKiem1.setPreferredSize(new java.awt.Dimension(180, 50));

        btnTimKiemSP.setBackground(null);
        btnTimKiemSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconImage/timkiem.png"))); // NOI18N
        btnTimKiemSP.setText(null);
        btnTimKiemSP.setBorder(null);
        btnTimKiemSP.setBorderPainted(false);
        btnTimKiemSP.setContentAreaFilled(false);
        btnTimKiemSP.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTimKiemSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemSPActionPerformed(evt);
            }
        });

        tfTimKiemSP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfTimKiemSPKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout pnTimKiem1Layout = new javax.swing.GroupLayout(pnTimKiem1);
        pnTimKiem1.setLayout(pnTimKiem1Layout);
        pnTimKiem1Layout.setHorizontalGroup(
            pnTimKiem1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTimKiem1Layout.createSequentialGroup()
                .addComponent(tfTimKiemSP, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTimKiemSP, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnTimKiem1Layout.setVerticalGroup(
            pnTimKiem1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTimKiem1Layout.createSequentialGroup()
                .addGroup(pnTimKiem1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(tfTimKiemSP, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTimKiemSP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(pnTimKiem1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 278, -1, 45));
    }// </editor-fold>//GEN-END:initComponents
//------------------------Tìm kiếm------------------------------
    private void btnTimKiemKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemKHActionPerformed
        model = (DefaultTableModel) tbNcc.getModel();
        model.setRowCount(0);
        ArrayList<NhaCungCap> dsncc = nccCtrl.search(tfTimKiemKH.getText().trim());
        if (dsncc.size() == 0) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy " + tfTimKiemKH.getText().trim());
            tfTimKiemKH.requestFocus();
        } else {
            for (NhaCungCap ncc : dsncc) {
                model.addRow(ncc.toArray());
            }
        }
    }//GEN-LAST:event_btnTimKiemKHActionPerformed

    private void tfTimKiemKHKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTimKiemKHKeyPressed
        model = (DefaultTableModel) tbNcc.getModel();
        ArrayList<NhaCungCap> dsncc = nccCtrl.search(tfTimKiemKH.getText().trim());

        if (evt.getKeyCode() == evt.VK_ENTER) {
            while (model.getRowCount() > 0) {
                model.removeRow(0);
            }
            if (dsncc.size() == 0) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy " + tfTimKiemKH.getText().trim());
            } else {
                for (NhaCungCap ncc : dsncc) {
                    model.addRow(ncc.toArray());
                }
            }
        }
    }//GEN-LAST:event_tfTimKiemKHKeyPressed

    private void btnTimKiemSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemSPActionPerformed
        model = (DefaultTableModel) tbSanPham.getModel();
        model.setRowCount(0);
        ArrayList<SanPham> dssp = spCtrl.search(tfTimKiemSP.getText().trim());
        if (dssp.size() == 0) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy " + tfTimKiemSP.getText().trim());
            tfTimKiemSP.requestFocus();
        } else {
            for (SanPham sp : dssp) {
                model.addRow(sp.toNhapHang());
            }
        }
    }//GEN-LAST:event_btnTimKiemSPActionPerformed

    private void tfTimKiemSPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTimKiemSPKeyPressed
        model = (DefaultTableModel) tbSanPham.getModel();
        ArrayList<SanPham> dslsp = spCtrl.search(tfTimKiemSP.getText().trim());

        if (evt.getKeyCode() == evt.VK_ENTER) {
            while (model.getRowCount() > 0) {
                model.removeRow(0);
            }
            if (dslsp.size() == 0) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy " + tfTimKiemSP.getText().trim());
            } else {
                for (SanPham sp : dslsp) {
                    model.addRow(sp.toArray());
                }
            }
        }
    }//GEN-LAST:event_tfTimKiemSPKeyPressed
//------------------------END-----------------------------------------
//------------------------Sự Kiện Chọn-----------------------------------------
    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        //Thên vào bảng trong hóa đơn
        listChon.add(tbSanPham.getRowCount());// ADD những cột được chọn trong Bảng SP vào listChon
        if (tbSanPham.getSelectedRow() != -1) {
            try {
                double donGia = Double.parseDouble(tfDonGia.getText());
                int soLuong = Integer.parseInt(tfSoLuong.getText());
                SanPham sp = new SanPham(
                        tfMaSp.getText(),
                        tfTenSP.getText(),
                        soLuong,
                        donGia);
                list.add(sp);//Thêm sản phẩm vào List
                UpdateTblSp();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Nhập sai số lượng!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Chọn sản phẩm!");
        }
    }//GEN-LAST:event_btnOKActionPerformed
//--------------------------END -----------------------------------------------
//--------------------------Update (Bảng/Tổng tiền) khi ấn CHỌN----------------

    private void UpdateTblSp() {
        model = (DefaultTableModel) tbHDSanPham.getModel();
        model.setRowCount(0);
        for (SanPham i : list) {
            model.addRow(i.toArray());
        }
        model = (DefaultTableModel) tbHDSanPham.getModel();
        //Tính tổng tiền
        double TongTien = 0;
        for (int i = 0; i < model.getRowCount(); i++) {
            TongTien += Integer.parseInt(model.getValueAt(i, 2).toString())
                    * Double.parseDouble(model.getValueAt(i, 3).toString());
        }
        jlbTongTien.setText(TongTien + "");
    }
//--------------------------END------------------------------------------------
//--------------------------Click Bảng NCC-------------------------------------
    private void tbNccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbNccMouseClicked
        model = (DefaultTableModel) tbNcc.getModel();
        tfTenNCC.setText(model.getValueAt(tbNcc.getSelectedRow(), 1).toString());
        tfDiaChi.setText(model.getValueAt(tbNcc.getSelectedRow(), 2).toString());
        tfSDT.setText(model.getValueAt(tbNcc.getSelectedRow(), 3).toString());
        MaNCC = model.getValueAt(tbNcc.getSelectedRow(), 0).toString();
    }//GEN-LAST:event_tbNccMouseClicked
//--------------------------END------------------------------------------------
//--------------------------Click Bảng SP-------------------------------------
    private void tbSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSanPhamMouseClicked
        model = (DefaultTableModel) tbSanPham.getModel();
        tfMaSp.setText(model.getValueAt(tbSanPham.getSelectedRow(), 0).toString());
        tfTenSP.setText(model.getValueAt(tbSanPham.getSelectedRow(), 1).toString());
        tfDonGia.setText(model.getValueAt(tbSanPham.getSelectedRow(), 3).toString());
        tfSoLuong.setText("0");
    }//GEN-LAST:event_tbSanPhamMouseClicked
//--------------------------END------------------------------------------------
//--------------------------Làm mới--------------------------------------------
    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        tfDiaChi.setText("");
        tfDonGia.setText("");
        tfMaSp.setText("");
        tfSDT.setText("");
        tfSoLuong.setText("0");
        tfTenNCC.setText("");
        tfTenSP.setText("");
        tfTimKiemKH.setText("");
        tfTimKiemSP.setText("");
        getDataNcc();
        getDataNV();
        getDataSP();
        list.clear();
        UpdateTblSp();
    }//GEN-LAST:event_btnResetActionPerformed
//--------------------------AND--------------------------------------------
    private void jComboBoxNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxNVActionPerformed

    private void tfSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSDTActionPerformed

    private void tfTenSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTenSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTenSPActionPerformed

    private void tfSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSoLuongActionPerformed


    }//GEN-LAST:event_tfSoLuongActionPerformed

    private void tfSoLuongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfSoLuongMouseClicked
        // TODO add your handling code here:
        tfSoLuong.setText("");
    }//GEN-LAST:event_tfSoLuongMouseClicked

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
        if (tfTenNCC.getText().equals("") || tfMaSp.getText().equals("") || tfMaPN.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Nhập đủ thông tin phiếu nhập!");
        } else {
            // Thêm Phiếu nhập
            pnCtrl.add(
                    tfMaPN.getText(),
                    MaNCC,
                    jComboBoxNV.getSelectedItem().toString(),
                    LocalDateTime.now(),
                    Double.parseDouble(jlbTongTien.getText()));
            JOptionPane.showMessageDialog(this, "Nhập hàng thành công!");

            //---------------------------------------------------------
            model = (DefaultTableModel) tbHDSanPham.getModel();
            DefaultTableModel modelChon = (DefaultTableModel) tbSanPham.getModel();
            for (int i = 0; i < list.size(); i++) {
                //Update Số lượng Sản phẩm
                String MaSP = model.getValueAt(i, 0).toString();
                try {
                    int SoLuong = Integer.parseInt(model.getValueAt(i, 2).toString())
                            + Integer.parseInt(modelChon.getValueAt(listChon.get(i), 2).toString());
                    spCtrl.updateSoLuong(MaSP, SoLuong);
                    
                } catch (Exception e) {
                    System.out.println("Sai số lượng!");
                }
                //Thêm Chi tiết phiêu nhập
                try {
                    int SoLuong = Integer.parseInt(model.getValueAt(i, 2).toString());
                    Double DonGia = Double.parseDouble(model.getValueAt(i, 3).toString());
                    ctpnCtrl.add(
                            tfMaPN.getText(),
                            MaSP,
                            SoLuong,
                            DonGia);
                } catch (Exception e) {
                    System.out.println(e);
                }

            }
            getDataSP();
        }
        
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void tfMaPNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfMaPNMouseClicked
        tfMaPN.setForeground(Color.BLACK);
        tfMaPN.setText("");
    }//GEN-LAST:event_tfMaPNMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel TTSP;
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnTimKiemKH;
    private javax.swing.JButton btnTimKiemSP;
    private javax.swing.JComboBox<String> jComboBoxNV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel jlbTongTien;
    private javax.swing.JPanel pnTimKiem;
    private javax.swing.JPanel pnTimKiem1;
    private javax.swing.JTable tbHDSanPham;
    private javax.swing.JTable tbNcc;
    private javax.swing.JTable tbSanPham;
    private javax.swing.JTextField tfDiaChi;
    private javax.swing.JTextField tfDonGia;
    private javax.swing.JTextField tfMaPN;
    private javax.swing.JTextField tfMaSp;
    private javax.swing.JTextField tfSDT;
    private javax.swing.JTextField tfSoLuong;
    private javax.swing.JTextField tfTenNCC;
    private javax.swing.JTextField tfTenSP;
    private javax.swing.JTextField tfTimKiemKH;
    private javax.swing.JTextField tfTimKiemSP;
    // End of variables declaration//GEN-END:variables
}
