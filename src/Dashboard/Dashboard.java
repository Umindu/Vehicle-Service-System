/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Dashboard;

import Home.Home;
import Login.Login;
import Manage.Manage;
import Reports.Reports;
import Vehicles.Vehicles;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Umindu
 */
public class Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        initComponents();
        
        homeButton.setBorderColor(new Color(13,180,185));
        homeButton.setColor(new Color(184,248,250));
        
        Home home = new Home();
        mainWindowPanel.removeAll();
        mainWindowPanel.add(home).setVisible(true);
        try {
            home.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void SetUserDetails(String jobRole, String name, String imgUrl){
        jobroleLable.setText(jobRole);
        usernameLable.setText(name);
         System.out.println(imgUrl);
        
        
        ImageIcon icon = new ImageIcon(imgUrl);
        Image in = icon.getImage();
        Image modified = in.getScaledInstance(46, 46, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(modified);
        myButton1.setIcon(icon);
        
        
        
        
        
        
        
        
        
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        usernameLable = new javax.swing.JLabel();
        jobroleLable = new javax.swing.JLabel();
        myButton1 = new button.MyButton();
        jPanel4 = new javax.swing.JPanel();
        homeButton = new button.MyButton();
        VehicleButton = new button.MyButton();
        reportButton = new button.MyButton();
        settingButton = new button.MyButton();
        logoutButton = new button.MyButton();
        manageButton = new button.MyButton();
        mainWindowPanel = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Auto Service");
        setPreferredSize(new java.awt.Dimension(1024, 678));

        jPanel3.setBackground(new java.awt.Color(13, 180, 185));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Auto Service");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        usernameLable.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        usernameLable.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        usernameLable.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        usernameLable.setVerifyInputWhenFocusTarget(false);
        usernameLable.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jobroleLable.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jobroleLable.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jobroleLable.setToolTipText("");
        jobroleLable.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jobroleLable.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        myButton1.setBackground(new java.awt.Color(13, 180, 185));
        myButton1.setBorderColor(new java.awt.Color(13, 180, 185));
        myButton1.setColor(new java.awt.Color(13, 180, 185));
        myButton1.setColorClick(new java.awt.Color(13, 180, 185));
        myButton1.setColorOver(new java.awt.Color(13, 180, 185));
        myButton1.setFocusable(false);
        myButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 354, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jobroleLable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameLable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jobroleLable, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(usernameLable, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setFocusable(false);

        homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/home (1).png"))); // NOI18N
        homeButton.setText("Home");
        homeButton.setBorderColor(new java.awt.Color(255, 255, 255));
        homeButton.setBorderPainted(false);
        homeButton.setColorClick(new java.awt.Color(184, 248, 250));
        homeButton.setColorOver(new java.awt.Color(184, 248, 250));
        homeButton.setFocusPainted(false);
        homeButton.setFocusable(false);
        homeButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        homeButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        homeButton.setIconTextGap(10);
        homeButton.setRadius(20);
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        VehicleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/car.png"))); // NOI18N
        VehicleButton.setText("Vehicles");
        VehicleButton.setBorderColor(new java.awt.Color(255, 255, 255));
        VehicleButton.setBorderPainted(false);
        VehicleButton.setColorClick(new java.awt.Color(184, 248, 250));
        VehicleButton.setColorOver(new java.awt.Color(184, 248, 250));
        VehicleButton.setFocusPainted(false);
        VehicleButton.setFocusable(false);
        VehicleButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        VehicleButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        VehicleButton.setIconTextGap(10);
        VehicleButton.setRadius(20);
        VehicleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VehicleButtonActionPerformed(evt);
            }
        });

        reportButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/chart-histogram.png"))); // NOI18N
        reportButton.setText("Report");
        reportButton.setBorderColor(new java.awt.Color(255, 255, 255));
        reportButton.setBorderPainted(false);
        reportButton.setColorClick(new java.awt.Color(184, 248, 250));
        reportButton.setColorOver(new java.awt.Color(184, 248, 250));
        reportButton.setFocusPainted(false);
        reportButton.setFocusable(false);
        reportButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        reportButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        reportButton.setIconTextGap(10);
        reportButton.setRadius(20);
        reportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportButtonActionPerformed(evt);
            }
        });

        settingButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/settings.png"))); // NOI18N
        settingButton.setText("Setting");
        settingButton.setBorderColor(new java.awt.Color(255, 255, 255));
        settingButton.setBorderPainted(false);
        settingButton.setColorClick(new java.awt.Color(184, 248, 250));
        settingButton.setColorOver(new java.awt.Color(184, 248, 250));
        settingButton.setFocusPainted(false);
        settingButton.setFocusable(false);
        settingButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        settingButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        settingButton.setIconTextGap(10);
        settingButton.setRadius(20);
        settingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingButtonActionPerformed(evt);
            }
        });

        logoutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/arrow-small-left.png"))); // NOI18N
        logoutButton.setText("Logout");
        logoutButton.setBorderColor(new java.awt.Color(255, 255, 255));
        logoutButton.setBorderPainted(false);
        logoutButton.setColorClick(new java.awt.Color(184, 248, 250));
        logoutButton.setColorOver(new java.awt.Color(184, 248, 250));
        logoutButton.setFocusPainted(false);
        logoutButton.setFocusable(false);
        logoutButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        logoutButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        logoutButton.setIconTextGap(10);
        logoutButton.setRadius(20);
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        manageButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/apps.png"))); // NOI18N
        manageButton.setText("Manage");
        manageButton.setBorderColor(new java.awt.Color(255, 255, 255));
        manageButton.setBorderPainted(false);
        manageButton.setColorClick(new java.awt.Color(184, 248, 250));
        manageButton.setColorOver(new java.awt.Color(184, 248, 250));
        manageButton.setFocusPainted(false);
        manageButton.setFocusable(false);
        manageButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        manageButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        manageButton.setIconTextGap(10);
        manageButton.setRadius(20);
        manageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(homeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logoutButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(VehicleButton, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                    .addComponent(reportButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(settingButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(manageButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(VehicleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(manageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(reportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(settingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 287, Short.MAX_VALUE)
                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout mainWindowPanelLayout = new javax.swing.GroupLayout(mainWindowPanel);
        mainWindowPanel.setLayout(mainWindowPanelLayout);
        mainWindowPanelLayout.setHorizontalGroup(
            mainWindowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        mainWindowPanelLayout.setVerticalGroup(
            mainWindowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mainWindowPanel)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mainWindowPanel)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void resetButonStyles(){
        homeButton.setBorderColor(Color.WHITE);
        homeButton.setColor(Color.WHITE);
        VehicleButton.setBorderColor(Color.WHITE);
        VehicleButton.setColor(Color.WHITE);
        manageButton.setBorderColor(Color.WHITE);
        manageButton.setColor(Color.WHITE);
        reportButton.setBorderColor(Color.WHITE);
        reportButton.setColor(Color.WHITE);
        settingButton.setBorderColor(Color.WHITE);
        settingButton.setColor(Color.WHITE);
        logoutButton.setBorderColor(Color.WHITE);
        logoutButton.setColor(Color.WHITE);
    }
    
//    private void OpenWebCame(){
//        Webcam webcam = Webcam.getDefault();   //Generate Webcam Object
//        webcam.setViewSize(new Dimension(320,240));
//        WebcamPanel webcamPanel = new WebcamPanel(webcam);
//        webcamPanel.setMirrored(false);
//        JFrame jFrame = new JFrame();
//        jFrame.add(webcamPanel);
//        jFrame.pack();
//        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        jFrame.setLocationRelativeTo(null);
//        jFrame.setVisible(true);
//        
//        do{
//            try {
//                BufferedImage image = webcam.getImage();
//                LuminanceSource source = new BufferedImageLuminanceSource(image);
//                BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
//                Result result = new MultiFormatReader().decode(bitmap);
//                if(result.getText() != null){
//                    JOptionPane.showMessageDialog(null, result.getText(), "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
//                    jFrame.setVisible(false);
//                    jFrame.dispose();
//                    webcam.close();
//                    break;
//                }
//                
//            } catch (Exception e) {
//            }
//        }while(true);
//    }
    
    
    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        // TODO add your handling code here:
        resetButonStyles();
        homeButton.setBorderColor(new Color(13,180,185));
        homeButton.setColor(new Color(184,248,250));
        
        Home home = new Home();
        mainWindowPanel.removeAll();
        mainWindowPanel.add(home).setVisible(true);
        try {
            home.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        home.setObject(home);
    }//GEN-LAST:event_homeButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(null,"Sure? You want to logout?", "Logout", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.YES_OPTION){
                Login login = new Login();
                login.setLocationRelativeTo(null); 
                login.setVisible(true);
                this.dispose();
            }
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void VehicleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VehicleButtonActionPerformed
        // TODO add your handling code here:
        resetButonStyles();
        VehicleButton.setBorderColor(new Color(13,180,185));
        VehicleButton.setColor(new Color(184,248,250));
        
        Vehicles vehicles = new Vehicles();
        mainWindowPanel.removeAll();
        mainWindowPanel.add(vehicles).setVisible(true);
        vehicles.setObject(vehicles);
        try {
            vehicles.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_VehicleButtonActionPerformed

    private void reportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportButtonActionPerformed
        // TODO add your handling code here:
        resetButonStyles();
        reportButton.setBorderColor(new Color(13,180,185));
        reportButton.setColor(new Color(184,248,250));
        
        Reports reports = new Reports();
        mainWindowPanel.removeAll();
        mainWindowPanel.add(reports).setVisible(true);
        try {
            reports.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_reportButtonActionPerformed

    private void settingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingButtonActionPerformed
        // TODO add your handling code here:
        resetButonStyles();
        settingButton.setBorderColor(new Color(13,180,185));
        settingButton.setColor(new Color(184,248,250));
    }//GEN-LAST:event_settingButtonActionPerformed

    private void manageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageButtonActionPerformed
        // TODO add your handling code here:
        resetButonStyles();
        manageButton.setBorderColor(new Color(13,180,185));
        manageButton.setColor(new Color(184,248,250));
        
        Manage manage = new Manage();
        mainWindowPanel.removeAll();
        mainWindowPanel.add(manage).setVisible(true);
        try {
            manage.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_manageButtonActionPerformed

    private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_myButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    //0DB4B9  B8F8FA
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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private button.MyButton VehicleButton;
    private button.MyButton homeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel jobroleLable;
    private button.MyButton logoutButton;
    private javax.swing.JDesktopPane mainWindowPanel;
    private button.MyButton manageButton;
    private button.MyButton myButton1;
    private button.MyButton reportButton;
    private button.MyButton settingButton;
    private javax.swing.JLabel usernameLable;
    // End of variables declaration//GEN-END:variables
}
