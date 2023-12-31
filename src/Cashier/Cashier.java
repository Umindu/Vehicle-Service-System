/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Cashier;

import DBConnect.DBconnect;
import Manage.Manage;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.JTableHeader;
import net.proteanit.sql.DbUtils;

public class Cashier extends javax.swing.JInternalFrame {

    String formattedDate;
    
    String employeeID;
    
    public Cashier() {
        initComponents();
    }
    
    public Cashier(String employeeID) {
        initComponents();
        
        this.employeeID = employeeID;
        
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);
        
        SummryDataLoad();
        GetLastLoginTime();
        
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        formattedDate = dateFormat.format(currentDate);
        
        CashierSummuryTableLoad();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        openingDrawer = new fosalgo.FTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        expectedDrawer = new fosalgo.FTextField();
        jLabel6 = new javax.swing.JLabel();
        cashPayment = new javax.swing.JLabel();
        otherPayment = new javax.swing.JLabel();
        credit = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        remark = new CustomComponents.MyTextArea();
        addServiceUnitButton = new button.MyButton();
        jPanel2 = new javax.swing.JPanel();
        difference = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lastLogin = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        cashierSummuryTable = new javax.swing.JTable();

        setBorder(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(242, 242, 242), 10));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Drawer Amount  Summary");

        openingDrawer.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        openingDrawer.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        openingDrawer.setRadius(20);
        openingDrawer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                openingDrawerKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Opening Drawer Amount");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Cash Payments Amount");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Other Payments Amount");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Credit Amount");

        expectedDrawer.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        expectedDrawer.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        expectedDrawer.setRadius(20);
        expectedDrawer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expectedDrawerActionPerformed(evt);
            }
        });
        expectedDrawer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                expectedDrawerKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Expected Drawer Amount");

        cashPayment.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cashPayment.setText("Rs. 0.00");

        otherPayment.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        otherPayment.setText("Rs. 0.00");

        credit.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        credit.setText("Rs. 0.00");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("Remark");

        jScrollPane1.setBorder(null);

        remark.setColumns(20);
        remark.setRows(5);
        remark.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        remark.setRadius(20);
        jScrollPane1.setViewportView(remark);

        addServiceUnitButton.setForeground(new java.awt.Color(255, 255, 255));
        addServiceUnitButton.setText("Close Drawer");
        addServiceUnitButton.setBorderColor(new java.awt.Color(13, 180, 185));
        addServiceUnitButton.setBorderPainted(false);
        addServiceUnitButton.setColor(new java.awt.Color(13, 180, 185));
        addServiceUnitButton.setColorClick(new java.awt.Color(11, 140, 144));
        addServiceUnitButton.setColorOver(new java.awt.Color(11, 140, 144));
        addServiceUnitButton.setFocusPainted(false);
        addServiceUnitButton.setFocusable(false);
        addServiceUnitButton.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        addServiceUnitButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        addServiceUnitButton.setIconTextGap(30);
        addServiceUnitButton.setRadius(20);
        addServiceUnitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addServiceUnitButtonActionPerformed(evt);
            }
        });

        difference.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        difference.setText("Rs. 0.00");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("Difference");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(difference)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(difference, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        lastLogin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lastLogin.setText("Last login time : 08:30 AM");

        cashierSummuryTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cashierSummuryTable.setModel(new javax.swing.table.DefaultTableModel(
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
        cashierSummuryTable.setRowHeight(25);
        jScrollPane2.setViewportView(cashierSummuryTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(addServiceUnitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addGap(95, 95, 95)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(credit, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(otherPayment, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(cashPayment, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(openingDrawer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jScrollPane1)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(expectedDrawer, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(20, 20, 20)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lastLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(openingDrawer, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cashPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(otherPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(credit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(expectedDrawer, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addServiceUnitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lastLogin)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)))
                .addContainerGap())
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
    
    private void GetLastLoginTime(){
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd   hh:mm:ss a");
        try {
            Statement statement = DBconnect.connectToDB().createStatement();
            statement.execute("SELECT TOP 1 LoginTime FROM UserActive Where EmployeeID = '"+employeeID+"' ORDER BY ID DESC ");
            ResultSet resultSet = statement.getResultSet();
            if(resultSet.next()){
                    String dateInString = resultSet.getString("LoginTime");
                    try {
                        Date date = inputFormat.parse(dateInString);
                        String Date = outputFormat.format(date);
                        lastLogin.setText("Last login time : "+Date);
                    } catch (ParseException ex) {
                        Logger.getLogger(Cashier.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cashier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void CashierSummuryTableLoad(){
        //        cashierSummuryTable
        JTableHeader header = cashierSummuryTable.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD , 14));
        try {
            Statement statement = DBconnect.connectToDB().createStatement();
            statement.execute("SELECT InvoiceID, PaymentDetails.Date, VehicleDetails.VehicleNo, PayableAmount FROM PaymentDetails INNER JOIN VehicleDetails ON PaymentDetails.InvoiceID = VehicleDetails.InvoiceNo WHERE CashierID = '"+employeeID+"' AND PaymentDetails.Date <= '"+formattedDate+" 23:59:59.000' AND PaymentDetails.Date > '"+formattedDate+" 00:00:00.000' ");
            ResultSet resultSet = statement.getResultSet();
            
            cashierSummuryTable.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (SQLException ex) {
            Logger.getLogger(Cashier.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    private void SummryDataLoad(){
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        formattedDate = dateFormat.format(currentDate);
        
        try {
            Statement statement = DBconnect.connectToDB().createStatement();
            statement.execute("SELECT OpeningDrawerAmount, ExpectedDrawerAmount, Remark FROM DailySummary WHERE Date = '"+formattedDate+"'");
            ResultSet resultSet = statement.getResultSet();
            if(resultSet.next()){
                openingDrawer.setText(resultSet.getString("OpeningDrawerAmount"));
                expectedDrawer.setText(resultSet.getString("ExpectedDrawerAmount"));
                remark.setText(resultSet.getString("Remark"));
            }
            
            statement.execute("SELECT SUM(CashPayAmount) AS CashPaymentsAmount, SUM(CardPayAmount)+ SUM(QRPayAmount) AS OtherPaymentsAmount, SUM(CASE WHEN Balance < 0 THEN Balance ELSE 0 END) AS Credit FROM PaymentDetails WHERE Date <= '"+formattedDate+" 23:59:59.000' AND Date > '"+formattedDate+" 00:00:00.000'");
            ResultSet resultSet2 = statement.getResultSet();
            if(resultSet2.next()){
                cashPayment.setText(resultSet2.getString("CashPaymentsAmount")==null ? "Rs. 0.0" : "Rs. "+resultSet2.getString("CashPaymentsAmount"));
                otherPayment.setText(resultSet2.getString("OtherPaymentsAmount")==null ? "Rs. 0.0" : "Rs. "+resultSet2.getString("OtherPaymentsAmount"));
                credit.setText(resultSet2.getString("Credit")==null ? "Rs. 0.0" : "Rs. "+resultSet2.getString("Credit"));
            }else{
                cashPayment.setText("Rs. 0.00");
                otherPayment.setText("Rs. 0.00");
                credit.setText("Rs. 0.00");
            }
           calculateDifference(); 
        } catch (SQLException ex) {
            Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void calculateDifference(){
        difference.setText("Rs. "+String.valueOf(Float.parseFloat(expectedDrawer.getText().isEmpty() ? "0" : expectedDrawer.getText()) - (Float.parseFloat(cashPayment.getText().substring(4).isEmpty() ? "0" : cashPayment.getText().substring(4)) + Float.parseFloat(openingDrawer.getText().isEmpty() ? "0" : openingDrawer.getText()))));
    }
    
    private void addServiceUnitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addServiceUnitButtonActionPerformed
        try {
            // TODO add your handling code here:
            Statement statement = DBconnect.connectToDB().createStatement();
            statement.execute("UPDATE DailySummary SET ExpectedDrawerAmount = '"+expectedDrawer.getText()+"', CashPaymentAmount = '"+cashPayment.getText().substring(4)+"', OtherPaymentsAmount = '"+otherPayment.getText().substring(4)+"', CreditAmount = '"+credit.getText().substring(4)+"', Difference = '"+difference.getText().substring(4)+"', Remark = '"+remark.getText()+"' WHERE Date = '"+formattedDate+"'");
            JOptionPane.showMessageDialog(this,"Successful add daily summary !","Successful",JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Cashier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addServiceUnitButtonActionPerformed

    private void openingDrawerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_openingDrawerKeyReleased
        
        try {
            Statement statement = DBconnect.connectToDB().createStatement();
            statement.execute("SELECT * FROM DailySummary WHERE Date = '"+formattedDate+"'");
            ResultSet resultSet = statement.getResultSet();
            if(resultSet.next()){
                statement.execute("UPDATE DailySummary SET OpeningDrawerAmount = '"+openingDrawer.getText()+"' WHERE Date = '"+formattedDate+"'");
            }else{
                statement.execute("INSERT INTO DailySummary (OpeningDrawerAmount, Date) VALUES ('"+openingDrawer.getText()+"', '"+formattedDate+"')");
            }
            calculateDifference(); 
        } catch (SQLException ex) {
            Logger.getLogger(Cashier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_openingDrawerKeyReleased

    private void expectedDrawerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_expectedDrawerKeyReleased
        // TODO add your handling code here:
        calculateDifference();
    }//GEN-LAST:event_expectedDrawerKeyReleased

    private void expectedDrawerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expectedDrawerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_expectedDrawerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private button.MyButton addServiceUnitButton;
    private javax.swing.JLabel cashPayment;
    private javax.swing.JTable cashierSummuryTable;
    private javax.swing.JLabel credit;
    private javax.swing.JLabel difference;
    private fosalgo.FTextField expectedDrawer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lastLogin;
    private fosalgo.FTextField openingDrawer;
    private javax.swing.JLabel otherPayment;
    private CustomComponents.MyTextArea remark;
    // End of variables declaration//GEN-END:variables
}
