/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Reports;

import DBConnect.DBconnect;
import Manage.Manage;
import java.awt.CardLayout;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.JTableHeader;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Umindu
 */
public class Reports extends javax.swing.JInternalFrame {

    /**
     * Creates new form Reports
     */
    CardLayout cardLayout;
    
    public Reports() {
        initComponents();
        
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        
        cardLayout = (CardLayout) panelCards.getLayout();
        
        LoadEnterdVehiclesTable();
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
        jPanel2 = new javax.swing.JPanel();
        showEnterdVehiclePaneButton = new button.MyButton();
        showDepartedVehiclePaneButton = new button.MyButton();
        VehicleTypesButton = new button.MyButton();
        productButton = new button.MyButton();
        panelCards = new javax.swing.JPanel();
        enterdVehiclesCard = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        enterdVehiclesTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        departedVehiclesCard = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        departedVehiclesTable = new javax.swing.JTable();
        DepSerCancelButton = new button.MyButton();
        DepSerEditButton = new button.MyButton();

        setBorder(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(242, 242, 242), 10));

        showEnterdVehiclePaneButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));
        showEnterdVehiclePaneButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/angle-small-down.png"))); // NOI18N
        showEnterdVehiclePaneButton.setText("Enterd Vehicles");
        showEnterdVehiclePaneButton.setBorderColor(new java.awt.Color(255, 255, 255));
        showEnterdVehiclePaneButton.setBorderPainted(false);
        showEnterdVehiclePaneButton.setColorClick(new java.awt.Color(126, 240, 244));
        showEnterdVehiclePaneButton.setColorOver(new java.awt.Color(126, 240, 244));
        showEnterdVehiclePaneButton.setFocusPainted(false);
        showEnterdVehiclePaneButton.setFocusable(false);
        showEnterdVehiclePaneButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        showEnterdVehiclePaneButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        showEnterdVehiclePaneButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        showEnterdVehiclePaneButton.setIconTextGap(10);
        showEnterdVehiclePaneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showEnterdVehiclePaneButtonActionPerformed(evt);
            }
        });

        showDepartedVehiclePaneButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));
        showDepartedVehiclePaneButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/angle-small-down.png"))); // NOI18N
        showDepartedVehiclePaneButton.setText("Departed Vehicles");
        showDepartedVehiclePaneButton.setBorderColor(new java.awt.Color(255, 255, 255));
        showDepartedVehiclePaneButton.setBorderPainted(false);
        showDepartedVehiclePaneButton.setColorClick(new java.awt.Color(126, 240, 244));
        showDepartedVehiclePaneButton.setColorOver(new java.awt.Color(126, 240, 244));
        showDepartedVehiclePaneButton.setFocusPainted(false);
        showDepartedVehiclePaneButton.setFocusable(false);
        showDepartedVehiclePaneButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        showDepartedVehiclePaneButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        showDepartedVehiclePaneButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        showDepartedVehiclePaneButton.setIconTextGap(10);
        showDepartedVehiclePaneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showDepartedVehiclePaneButtonActionPerformed(evt);
            }
        });

        VehicleTypesButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));
        VehicleTypesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/angle-small-down.png"))); // NOI18N
        VehicleTypesButton.setText("Vehicle Types");
        VehicleTypesButton.setBorderColor(new java.awt.Color(255, 255, 255));
        VehicleTypesButton.setBorderPainted(false);
        VehicleTypesButton.setColorClick(new java.awt.Color(126, 240, 244));
        VehicleTypesButton.setColorOver(new java.awt.Color(126, 240, 244));
        VehicleTypesButton.setFocusPainted(false);
        VehicleTypesButton.setFocusable(false);
        VehicleTypesButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        VehicleTypesButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        VehicleTypesButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        VehicleTypesButton.setIconTextGap(10);

        productButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));
        productButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/angle-small-down.png"))); // NOI18N
        productButton.setText("Products");
        productButton.setBorderColor(new java.awt.Color(255, 255, 255));
        productButton.setBorderPainted(false);
        productButton.setColorClick(new java.awt.Color(126, 240, 244));
        productButton.setColorOver(new java.awt.Color(126, 240, 244));
        productButton.setFocusPainted(false);
        productButton.setFocusable(false);
        productButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        productButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        productButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        productButton.setIconTextGap(10);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(showEnterdVehiclePaneButton, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addComponent(showDepartedVehiclePaneButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(VehicleTypesButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(productButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(showEnterdVehiclePaneButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(showDepartedVehiclePaneButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(VehicleTypesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(productButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelCards.setBackground(new java.awt.Color(255, 255, 255));
        panelCards.setLayout(new java.awt.CardLayout());

        enterdVehiclesCard.setBackground(new java.awt.Color(255, 255, 255));

        enterdVehiclesTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        enterdVehiclesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        enterdVehiclesTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        enterdVehiclesTable.setGridColor(new java.awt.Color(204, 204, 204));
        enterdVehiclesTable.setName(""); // NOI18N
        enterdVehiclesTable.setRowHeight(25);
        jScrollPane1.setViewportView(enterdVehiclesTable);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Enterd Vehicles List");

        javax.swing.GroupLayout enterdVehiclesCardLayout = new javax.swing.GroupLayout(enterdVehiclesCard);
        enterdVehiclesCard.setLayout(enterdVehiclesCardLayout);
        enterdVehiclesCardLayout.setHorizontalGroup(
            enterdVehiclesCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(enterdVehiclesCardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(enterdVehiclesCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1020, Short.MAX_VALUE)
                    .addGroup(enterdVehiclesCardLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        enterdVehiclesCardLayout.setVerticalGroup(
            enterdVehiclesCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(enterdVehiclesCardLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelCards.add(enterdVehiclesCard, "enterdVehiclesCard");

        departedVehiclesCard.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Departed Vehicles List");

        departedVehiclesTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        departedVehiclesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        departedVehiclesTable.setGridColor(new java.awt.Color(204, 204, 204));
        departedVehiclesTable.setRowHeight(25);
        departedVehiclesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                departedVehiclesTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(departedVehiclesTable);

        DepSerCancelButton.setText("Service Cancel");
        DepSerCancelButton.setBorderColor(new java.awt.Color(13, 180, 185));
        DepSerCancelButton.setBorderPainted(false);
        DepSerCancelButton.setColorClick(new java.awt.Color(184, 248, 250));
        DepSerCancelButton.setColorOver(new java.awt.Color(184, 248, 250));
        DepSerCancelButton.setFocusPainted(false);
        DepSerCancelButton.setFocusable(false);
        DepSerCancelButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DepSerCancelButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        DepSerCancelButton.setRadius(20);
        DepSerCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DepSerCancelButtonActionPerformed(evt);
            }
        });

        DepSerEditButton.setText("Service Edit");
        DepSerEditButton.setBorderColor(new java.awt.Color(13, 180, 185));
        DepSerEditButton.setBorderPainted(false);
        DepSerEditButton.setColorClick(new java.awt.Color(184, 248, 250));
        DepSerEditButton.setColorOver(new java.awt.Color(184, 248, 250));
        DepSerEditButton.setFocusPainted(false);
        DepSerEditButton.setFocusable(false);
        DepSerEditButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DepSerEditButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        DepSerEditButton.setRadius(20);
        DepSerEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DepSerEditButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout departedVehiclesCardLayout = new javax.swing.GroupLayout(departedVehiclesCard);
        departedVehiclesCard.setLayout(departedVehiclesCardLayout);
        departedVehiclesCardLayout.setHorizontalGroup(
            departedVehiclesCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(departedVehiclesCardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(departedVehiclesCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1020, Short.MAX_VALUE)
                    .addGroup(departedVehiclesCardLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DepSerEditButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DepSerCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        departedVehiclesCardLayout.setVerticalGroup(
            departedVehiclesCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(departedVehiclesCardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(departedVehiclesCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addGroup(departedVehiclesCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(DepSerCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DepSerEditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelCards.add(departedVehiclesCard, "departedVehiclesCard");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelCards, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelCards, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    }// </editor-fold>//GEN-END:initComponents

    private void showEnterdVehiclePaneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showEnterdVehiclePaneButtonActionPerformed
        // TODO add your handling code here:
        cardLayout.show(panelCards, "enterdVehiclesCard");
        
        LoadEnterdVehiclesTable();
    }//GEN-LAST:event_showEnterdVehiclePaneButtonActionPerformed

    private void showDepartedVehiclePaneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showDepartedVehiclePaneButtonActionPerformed
        // TODO add your handling code here:
        cardLayout.show(panelCards, "departedVehiclesCard");
        
        LoadDepartedVehiclesTable();
    }//GEN-LAST:event_showDepartedVehiclePaneButtonActionPerformed

    private void DepSerCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DepSerCancelButtonActionPerformed
       
    }//GEN-LAST:event_DepSerCancelButtonActionPerformed

    private void DepSerEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DepSerEditButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DepSerEditButtonActionPerformed

    private void departedVehiclesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_departedVehiclesTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_departedVehiclesTableMouseClicked

    private void LoadEnterdVehiclesTable(){
        //serviceUnitTable data load
        JTableHeader header = enterdVehiclesTable.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD , 14));
        try {
            Statement statement = DBconnect.connectToDB().createStatement();
            statement.execute("Select InvoiceNo, Date, VehicleNo, OwnerName, Phone, VehicleType, Description From VehicleDetails Where States = 'Processing'");
            ResultSet resultSet = statement.getResultSet(); 
            
            enterdVehiclesTable.setModel(DbUtils.resultSetToTableModel(resultSet));
 
        } catch (SQLException ex) {
            Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void LoadDepartedVehiclesTable(){
        //serviceUnitTable data load
        JTableHeader header = departedVehiclesTable.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD , 14));
        try {
            Statement statement = DBconnect.connectToDB().createStatement();
            statement.execute("Select InvoiceNo, Date, VehicleNo, OwnerName, Phone, VehicleType, Description From VehicleDetails Where States = 'Done'");
            ResultSet resultSet = statement.getResultSet(); 
            
            departedVehiclesTable.setModel(DbUtils.resultSetToTableModel(resultSet));
 
        } catch (SQLException ex) {
            Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private button.MyButton DepSerCancelButton;
    private button.MyButton DepSerEditButton;
    private button.MyButton VehicleTypesButton;
    private javax.swing.JPanel departedVehiclesCard;
    private javax.swing.JTable departedVehiclesTable;
    private javax.swing.JPanel enterdVehiclesCard;
    private javax.swing.JTable enterdVehiclesTable;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelCards;
    private button.MyButton productButton;
    private button.MyButton showDepartedVehiclePaneButton;
    private button.MyButton showEnterdVehiclePaneButton;
    // End of variables declaration//GEN-END:variables
}
