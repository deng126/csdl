package Login;

import GiaoDienChinh.Home;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        banner = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        content = new javax.swing.JPanel();
        btnDangNhap = new javax.swing.JButton();
        tfPassword = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfTenDN = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setLocationByPlatform(true);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(400, 400));
        getContentPane().setLayout(null);

        banner.setBackground(new java.awt.Color(0, 77, 97));
        banner.setLayout(null);

        jLabel3.setBackground(null
        );
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconImage/phoneBanner.png"))); // NOI18N
        banner.add(jLabel3);
        jLabel3.setBounds(170, 30, 50, 40);

        getContentPane().add(banner);
        banner.setBounds(0, 0, 400, 90);

        content.setBackground(new java.awt.Color(255, 255, 255));
        content.setLayout(null);

        btnDangNhap.setBackground(new java.awt.Color(0, 77, 97));
        btnDangNhap.setFont(new java.awt.Font("Myriad Pro", 1, 14)); // NOI18N
        btnDangNhap.setForeground(new java.awt.Color(255, 255, 255));
        btnDangNhap.setText("Đăng nhập");
        btnDangNhap.setBorderPainted(false);
        btnDangNhap.setContentAreaFilled(false);
        btnDangNhap.setOpaque(true);
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });
        content.add(btnDangNhap);
        btnDangNhap.setBounds(77, 124, 240, 35);
        content.add(tfPassword);
        tfPassword.setBounds(155, 70, 185, 27);

        jLabel1.setText("Tên đăng nhập");
        content.add(jLabel1);
        jLabel1.setBounds(60, 30, 90, 20);

        jLabel2.setText("Mật khẩu");
        content.add(jLabel2);
        jLabel2.setBounds(60, 70, 60, 16);
        content.add(tfTenDN);
        tfTenDN.setBounds(155, 29, 185, 30);

        jButton1.setText("Thoát");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        content.add(jButton1);
        jButton1.setBounds(143, 180, 100, 17);

        getContentPane().add(content);
        content.setBounds(0, 90, 400, 210);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        System.out.println("RUN");
        String pw = new String(tfPassword.getPassword());
        if (tfTenDN.getText().equals("admin") && pw.equals("conguoiyeuroi")) {
            new Home().setVisible(true);
            setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Lêu lêu chưa có người yêu à?");
        }
    }//GEN-LAST:event_btnDangNhapActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel banner;
    private javax.swing.JButton btnDangNhap;
    private javax.swing.JPanel content;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField tfPassword;
    private javax.swing.JTextField tfTenDN;
    // End of variables declaration//GEN-END:variables
}
