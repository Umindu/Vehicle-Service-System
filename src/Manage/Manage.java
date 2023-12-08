/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Manage;

import java.awt.CardLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.sql.Statement;
import java.sql.SQLException;
import DBConnect.DBconnect;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.JTableHeader;
import jnafilechooser.api.JnaFileChooser;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Umindu
 */
public class Manage extends javax.swing.JInternalFrame {
    
    CardLayout cardLayout;
    
    String imagePath = null;
    public Manage() {
        initComponents();
        
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        
        employeeButtonPane.setVisible(false);
        
        cardLayout = (CardLayout) panelCards.getLayout();
        
        serUnitButton.setColor(new Color(184,248,250));
        
        //add job roal combobox data
        jobRoleComboBox.addItem("Manager");
        jobRoleComboBox.addItem("Mechanic");
        jobRoleComboBox.addItem("Diagnostic Technician");
        jobRoleComboBox.addItem("Auto Electrician");
        jobRoleComboBox.addItem("Lube Technician");
        jobRoleComboBox.addItem("Cashier");
        
        //serviceUnitTable data load
        LoadServiceUnitTable("All");
        
        employeeDeleteButton.setVisible(false);
    }
    
    private void LoadServiceUnitTable(String search){
        //serviceUnitTable data load
        JTableHeader header = serviceUnitTable.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD , 14));
        try {
            Statement statement = DBconnect.connectToDB().createStatement();
            if(search.equals("All")){
                statement.execute("Select ID AS 'Unit ID' , Name AS 'Unit Name' From ServiceUnits");
            }else{
                statement.execute("Select ID AS 'Unit ID' , Name AS 'Unit Name' From ServiceUnits Where ID like '%"+ search +"%' OR Name like '%"+ search +"%'");
            }
            ResultSet resultSet = statement.getResultSet(); 
            
            serviceUnitTable.setModel(DbUtils.resultSetToTableModel(resultSet));
 
        } catch (SQLException ex) {
            Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void LoadServicesTable(String search){
        //serviceTable data load
        JTableHeader header = serviceTable.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD , 14));
        try {
            Statement statement = DBconnect.connectToDB().createStatement();
            if(search.equals("All")){
                statement.execute("Select ID , Name, ServiceUnit, VehicleType, ServiceCharge From Services");
            }else{
                statement.execute("Select ID , Name, ServiceUnit, VehicleType, ServiceCharge From Services Where ID like '%"+ search +"%' OR Name like '%"+ search +"%'");
            }
            ResultSet resultSet = statement.getResultSet(); 
            
            serviceTable.setModel(DbUtils.resultSetToTableModel(resultSet));
 
        } catch (SQLException ex) {
            Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void LoademployeeTable(String search){
        //serviceUnitTable data load
        JTableHeader header = employeeTable.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD , 14));
        try {
            Statement statement = DBconnect.connectToDB().createStatement();
            if(search.equals("All")){
                statement.execute("Select ID, Name, NIC, JobRole, Email, Phone From Employees");
            }else{
                statement.execute("Select ID, Name, NIC, JobRole, Email, Phone From Employees Where ID like '%"+ search +"%' OR Name like '%"+ search +"%' OR NIC like '%"+ search +"%' OR JobRole like '%"+ search +"%' OR Email like '%"+ search +"%' OR Phone like '%"+ search +"%'");
            }
            ResultSet resultSet = statement.getResultSet(); 
            
            employeeTable.setModel(DbUtils.resultSetToTableModel(resultSet));
 
        } catch (SQLException ex) {
            Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void LoadVehicalTypeTable(String search){
        //serviceUnitTable data load
        JTableHeader header = VehicleTypeTable.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD , 14));
        try {
            Statement statement = DBconnect.connectToDB().createStatement();
            if(search.equals("All")){
                statement.execute("Select ID, Name From VehicleType");
            }else{
                statement.execute("Select ID, Name From VehicleType Where ID like '%"+ search +"%' OR Name like '%"+ search +"%'");
            }
            ResultSet resultSet = statement.getResultSet(); 
            
            VehicleTypeTable.setModel(DbUtils.resultSetToTableModel(resultSet));
 
        } catch (SQLException ex) {
            Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void LoadProductTable(String search){
        //serviceTable data load
        JTableHeader header = productTable.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD , 14));
        try {
            Statement statement = DBconnect.connectToDB().createStatement();
            if(search.equals("All")){
                statement.execute("Select ID , Name, Price, Qnt, ServiceUnit From Products");
            }else{
                statement.execute("Select ID , Name, Price, Qnt, ServiceUnit From Products Where ID like '%"+ search +"%' OR Name like '%"+ search +"%'");
            }
            ResultSet resultSet = statement.getResultSet(); 
            
            productTable.setModel(DbUtils.resultSetToTableModel(resultSet));
 
        } catch (SQLException ex) {
            Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    
    private void resetButtonStyle(){
        showSerPaneButton.setColor(Color.WHITE);
        serUnitButton.setColor(Color.WHITE);
        serButton.setColor(Color.WHITE);
        showEmpPaneButton.setColor(Color.WHITE);
        allEmployeeButton.setColor(Color.WHITE);
        addEmployeeButton.setColor(Color.WHITE);
        VehicleTypesButton.setColor(Color.WHITE);
        productButton.setColor(Color.WHITE);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        serviceButtonPane = new javax.swing.JPanel();
        serButton = new button.MyButton();
        serUnitButton = new button.MyButton();
        employeeButtonPane = new javax.swing.JPanel();
        addEmployeeButton = new button.MyButton();
        allEmployeeButton = new button.MyButton();
        showSerPaneButton = new button.MyButton();
        showEmpPaneButton = new button.MyButton();
        VehicleTypesButton = new button.MyButton();
        productButton = new button.MyButton();
        panelCards = new javax.swing.JPanel();
        serviesUnitCard = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        serviceUnitTable = new javax.swing.JTable();
        serUnitTitle = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        serUnitID = new fosalgo.FTextField();
        jLabel4 = new javax.swing.JLabel();
        serUnitName = new fosalgo.FTextField();
        addServiceUnitButton = new button.MyButton();
        servicesUnitDeleteButton = new button.MyButton();
        servicesUnitClearButton = new button.MyButton();
        searchSerUnits = new fosalgo.FTextField();
        serviesCard = new javax.swing.JPanel();
        addServiceButton = new button.MyButton();
        serName = new fosalgo.FTextField();
        jLabel5 = new javax.swing.JLabel();
        serID = new fosalgo.FTextField();
        jLabel6 = new javax.swing.JLabel();
        serTitle = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        serviceTable = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        serUnitComboBox = new CustomComponents.Combobox();
        jLabel10 = new javax.swing.JLabel();
        serCharge = new fosalgo.FTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        serDescription = new CustomComponents.MyTextArea();
        jLabel21 = new javax.swing.JLabel();
        vehicalTypeComboBox = new CustomComponents.Combobox();
        servicesDeleteButton = new button.MyButton();
        servicesClearButton = new button.MyButton();
        searchService = new fosalgo.FTextField();
        allEmployeeCard = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        employeeTable = new javax.swing.JTable();
        searchEmployees = new fosalgo.FTextField();
        addEmployeeCard = new javax.swing.JPanel();
        addEmployeeTitle = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        empID = new fosalgo.FTextField();
        jLabel15 = new javax.swing.JLabel();
        empName = new fosalgo.FTextField();
        jLabel17 = new javax.swing.JLabel();
        empPhone = new fosalgo.FTextField();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        empDescription = new CustomComponents.MyTextArea();
        saveButton = new button.MyButton();
        jLabel19 = new javax.swing.JLabel();
        empEmail = new fosalgo.FTextField();
        empAddress = new fosalgo.FTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        empNIC = new fosalgo.FTextField();
        empImgLable = new javax.swing.JLabel();
        choosFileButton = new button.MyButton();
        cancelButton = new button.MyButton();
        jLabel22 = new javax.swing.JLabel();
        jobRoleComboBox = new CustomComponents.Combobox();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        empPassword = new CustomComponents.FTPasswordextField();
        empUserName = new fosalgo.FTextField();
        employeeDeleteButton = new button.MyButton();
        vehicleTypesCard = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        VehicleTypeTable = new javax.swing.JTable();
        VehicleTypeTitle = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        VehicleTypeID = new fosalgo.FTextField();
        jLabel28 = new javax.swing.JLabel();
        VehicleTypeName = new fosalgo.FTextField();
        addVehicleTypeButton = new button.MyButton();
        VehiclelTypeDeleteButton = new button.MyButton();
        vehicalTypeClearButton1 = new button.MyButton();
        searchVehicalType = new fosalgo.FTextField();
        productCard = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        productTitle = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        productID = new fosalgo.FTextField();
        jLabel31 = new javax.swing.JLabel();
        productName = new fosalgo.FTextField();
        productClearButton = new button.MyButton();
        addProductButton = new button.MyButton();
        productDeleteButton = new button.MyButton();
        jLabel32 = new javax.swing.JLabel();
        productPrice = new fosalgo.FTextField();
        jLabel33 = new javax.swing.JLabel();
        productQnt = new fosalgo.FTextField();
        jLabel34 = new javax.swing.JLabel();
        selectServiceUnitCombobox = new CustomComponents.Combobox();
        searchProducts = new fosalgo.FTextField();

        setBorder(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(242, 242, 242), 10));

        serButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));
        serButton.setText("Services");
        serButton.setBorderColor(new java.awt.Color(255, 255, 255));
        serButton.setBorderPainted(false);
        serButton.setColorClick(new java.awt.Color(126, 240, 244));
        serButton.setColorOver(new java.awt.Color(126, 240, 244));
        serButton.setFocusPainted(false);
        serButton.setFocusable(false);
        serButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        serButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        serButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        serButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serButtonActionPerformed(evt);
            }
        });

        serUnitButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));
        serUnitButton.setText("Service Units");
        serUnitButton.setBorderColor(new java.awt.Color(255, 255, 255));
        serUnitButton.setBorderPainted(false);
        serUnitButton.setColorClick(new java.awt.Color(126, 240, 244));
        serUnitButton.setColorOver(new java.awt.Color(126, 240, 244));
        serUnitButton.setFocusPainted(false);
        serUnitButton.setFocusable(false);
        serUnitButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        serUnitButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        serUnitButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        serUnitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serUnitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout serviceButtonPaneLayout = new javax.swing.GroupLayout(serviceButtonPane);
        serviceButtonPane.setLayout(serviceButtonPaneLayout);
        serviceButtonPaneLayout.setHorizontalGroup(
            serviceButtonPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(serUnitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(serButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        serviceButtonPaneLayout.setVerticalGroup(
            serviceButtonPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, serviceButtonPaneLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(serUnitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(serButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        addEmployeeButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));
        addEmployeeButton.setText("Add Employee");
        addEmployeeButton.setBorderColor(new java.awt.Color(255, 255, 255));
        addEmployeeButton.setBorderPainted(false);
        addEmployeeButton.setColorClick(new java.awt.Color(126, 240, 244));
        addEmployeeButton.setColorOver(new java.awt.Color(126, 240, 244));
        addEmployeeButton.setFocusPainted(false);
        addEmployeeButton.setFocusable(false);
        addEmployeeButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        addEmployeeButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        addEmployeeButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        addEmployeeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmployeeButtonActionPerformed(evt);
            }
        });

        allEmployeeButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));
        allEmployeeButton.setText("All Employees");
        allEmployeeButton.setBorderColor(new java.awt.Color(255, 255, 255));
        allEmployeeButton.setBorderPainted(false);
        allEmployeeButton.setColorClick(new java.awt.Color(126, 240, 244));
        allEmployeeButton.setColorOver(new java.awt.Color(126, 240, 244));
        allEmployeeButton.setFocusPainted(false);
        allEmployeeButton.setFocusable(false);
        allEmployeeButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        allEmployeeButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        allEmployeeButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        allEmployeeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allEmployeeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout employeeButtonPaneLayout = new javax.swing.GroupLayout(employeeButtonPane);
        employeeButtonPane.setLayout(employeeButtonPaneLayout);
        employeeButtonPaneLayout.setHorizontalGroup(
            employeeButtonPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(allEmployeeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(addEmployeeButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        employeeButtonPaneLayout.setVerticalGroup(
            employeeButtonPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, employeeButtonPaneLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(allEmployeeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(addEmployeeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        showSerPaneButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));
        showSerPaneButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/angle-small-down.png"))); // NOI18N
        showSerPaneButton.setText("Service");
        showSerPaneButton.setBorderColor(new java.awt.Color(255, 255, 255));
        showSerPaneButton.setBorderPainted(false);
        showSerPaneButton.setColorClick(new java.awt.Color(126, 240, 244));
        showSerPaneButton.setColorOver(new java.awt.Color(126, 240, 244));
        showSerPaneButton.setFocusPainted(false);
        showSerPaneButton.setFocusable(false);
        showSerPaneButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        showSerPaneButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        showSerPaneButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        showSerPaneButton.setIconTextGap(10);
        showSerPaneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showSerPaneButtonActionPerformed(evt);
            }
        });

        showEmpPaneButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));
        showEmpPaneButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/angle-small-down.png"))); // NOI18N
        showEmpPaneButton.setText("Employee");
        showEmpPaneButton.setBorderColor(new java.awt.Color(255, 255, 255));
        showEmpPaneButton.setBorderPainted(false);
        showEmpPaneButton.setColorClick(new java.awt.Color(126, 240, 244));
        showEmpPaneButton.setColorOver(new java.awt.Color(126, 240, 244));
        showEmpPaneButton.setFocusPainted(false);
        showEmpPaneButton.setFocusable(false);
        showEmpPaneButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        showEmpPaneButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        showEmpPaneButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        showEmpPaneButton.setIconTextGap(10);
        showEmpPaneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showEmpPaneButtonActionPerformed(evt);
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
        VehicleTypesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VehicleTypesButtonActionPerformed(evt);
            }
        });

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
        productButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(serviceButtonPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(showSerPaneButton, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addComponent(showEmpPaneButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(employeeButtonPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(VehicleTypesButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(productButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(showSerPaneButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(serviceButtonPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(showEmpPaneButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(employeeButtonPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(VehicleTypesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(productButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelCards.setBackground(new java.awt.Color(255, 255, 255));
        panelCards.setLayout(new java.awt.CardLayout());

        serviesUnitCard.setBackground(new java.awt.Color(255, 255, 255));

        serviceUnitTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        serviceUnitTable.setModel(new javax.swing.table.DefaultTableModel(
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
        serviceUnitTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        serviceUnitTable.setGridColor(new java.awt.Color(204, 204, 204));
        serviceUnitTable.setName(""); // NOI18N
        serviceUnitTable.setRowHeight(25);
        serviceUnitTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                serviceUnitTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(serviceUnitTable);

        serUnitTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        serUnitTitle.setText("Add Service Unit");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Service Unit List");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Unit ID :");

        serUnitID.setText("Auto Genarate");
        serUnitID.setEnabled(false);
        serUnitID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        serUnitID.setRadius(20);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Unit Name :");

        serUnitName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        serUnitName.setRadius(20);

        addServiceUnitButton.setForeground(new java.awt.Color(255, 255, 255));
        addServiceUnitButton.setText("Add Unit");
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

        servicesUnitDeleteButton.setBackground(new java.awt.Color(184, 248, 250));
        servicesUnitDeleteButton.setText("Delete");
        servicesUnitDeleteButton.setBorderColor(new java.awt.Color(13, 180, 185));
        servicesUnitDeleteButton.setBorderPainted(false);
        servicesUnitDeleteButton.setColor(new java.awt.Color(184, 248, 250));
        servicesUnitDeleteButton.setColorClick(new java.awt.Color(126, 240, 244));
        servicesUnitDeleteButton.setColorOver(new java.awt.Color(126, 240, 244));
        servicesUnitDeleteButton.setFocusPainted(false);
        servicesUnitDeleteButton.setFocusable(false);
        servicesUnitDeleteButton.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        servicesUnitDeleteButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        servicesUnitDeleteButton.setRadius(20);
        servicesUnitDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                servicesUnitDeleteButtonActionPerformed(evt);
            }
        });

        servicesUnitClearButton.setText("Clear");
        servicesUnitClearButton.setBorderColor(new java.awt.Color(255, 255, 255));
        servicesUnitClearButton.setBorderPainted(false);
        servicesUnitClearButton.setColorClick(new java.awt.Color(126, 240, 244));
        servicesUnitClearButton.setColorOver(new java.awt.Color(126, 240, 244));
        servicesUnitClearButton.setFocusPainted(false);
        servicesUnitClearButton.setFocusable(false);
        servicesUnitClearButton.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        servicesUnitClearButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        servicesUnitClearButton.setRadius(10);
        servicesUnitClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                servicesUnitClearButtonActionPerformed(evt);
            }
        });

        searchSerUnits.setForeground(new java.awt.Color(153, 153, 153));
        searchSerUnits.setText("Search service units");
        searchSerUnits.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        searchSerUnits.setRadius(20);
        searchSerUnits.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchSerUnitsFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchSerUnitsFocusLost(evt);
            }
        });
        searchSerUnits.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchSerUnitsKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout serviesUnitCardLayout = new javax.swing.GroupLayout(serviesUnitCard);
        serviesUnitCard.setLayout(serviesUnitCardLayout);
        serviesUnitCardLayout.setHorizontalGroup(
            serviesUnitCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(serviesUnitCardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(serviesUnitCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(serviesUnitCardLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchSerUnits, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(serviesUnitCardLayout.createSequentialGroup()
                        .addGap(0, 556, Short.MAX_VALUE)
                        .addComponent(servicesUnitDeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addGroup(serviesUnitCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(serUnitID, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(addServiceUnitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(serUnitName, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(serUnitTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(servicesUnitClearButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        serviesUnitCardLayout.setVerticalGroup(
            serviesUnitCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(serviesUnitCardLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(serviesUnitCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serUnitTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(searchSerUnits, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(serviesUnitCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(serviesUnitCardLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(serUnitID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(serUnitName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(servicesUnitClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(serviesUnitCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addServiceUnitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(servicesUnitDeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelCards.add(serviesUnitCard, "serviesUnitCard");

        serviesCard.setBackground(new java.awt.Color(255, 255, 255));

        addServiceButton.setForeground(new java.awt.Color(255, 255, 255));
        addServiceButton.setText("Add Service");
        addServiceButton.setBorderColor(new java.awt.Color(13, 180, 185));
        addServiceButton.setBorderPainted(false);
        addServiceButton.setColor(new java.awt.Color(13, 180, 185));
        addServiceButton.setColorClick(new java.awt.Color(11, 140, 144));
        addServiceButton.setColorOver(new java.awt.Color(11, 140, 144));
        addServiceButton.setFocusPainted(false);
        addServiceButton.setFocusable(false);
        addServiceButton.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        addServiceButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        addServiceButton.setIconTextGap(30);
        addServiceButton.setRadius(20);
        addServiceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addServiceButtonActionPerformed(evt);
            }
        });

        serName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        serName.setRadius(20);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("Service Name :");

        serID.setText("Auto Genarate");
        serID.setEnabled(false);
        serID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        serID.setRadius(20);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("Service ID :");

        serTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        serTitle.setText("Add Service");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Service List");

        serviceTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        serviceTable.setModel(new javax.swing.table.DefaultTableModel(
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
        serviceTable.setGridColor(new java.awt.Color(204, 204, 204));
        serviceTable.setRowHeight(25);
        serviceTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                serviceTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(serviceTable);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel9.setText("Service Unit :");

        serUnitComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel10.setText("Service Charge :");

        serCharge.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        serCharge.setRadius(20);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel11.setText("Description :");

        jScrollPane3.setBorder(null);

        serDescription.setColumns(20);
        serDescription.setRows(5);
        serDescription.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        serDescription.setRadius(20);
        jScrollPane3.setViewportView(serDescription);

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel21.setText("Vehicle Type :");

        vehicalTypeComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        vehicalTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehicalTypeComboBoxActionPerformed(evt);
            }
        });

        servicesDeleteButton.setBackground(new java.awt.Color(184, 248, 250));
        servicesDeleteButton.setText("Delete");
        servicesDeleteButton.setBorderColor(new java.awt.Color(13, 180, 185));
        servicesDeleteButton.setBorderPainted(false);
        servicesDeleteButton.setColor(new java.awt.Color(184, 248, 250));
        servicesDeleteButton.setColorClick(new java.awt.Color(126, 240, 244));
        servicesDeleteButton.setColorOver(new java.awt.Color(126, 240, 244));
        servicesDeleteButton.setFocusPainted(false);
        servicesDeleteButton.setFocusable(false);
        servicesDeleteButton.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        servicesDeleteButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        servicesDeleteButton.setRadius(20);
        servicesDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                servicesDeleteButtonActionPerformed(evt);
            }
        });

        servicesClearButton.setText("Clear");
        servicesClearButton.setBorderColor(new java.awt.Color(255, 255, 255));
        servicesClearButton.setBorderPainted(false);
        servicesClearButton.setColorClick(new java.awt.Color(126, 240, 244));
        servicesClearButton.setColorOver(new java.awt.Color(126, 240, 244));
        servicesClearButton.setFocusPainted(false);
        servicesClearButton.setFocusable(false);
        servicesClearButton.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        servicesClearButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        servicesClearButton.setRadius(10);
        servicesClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                servicesClearButtonActionPerformed(evt);
            }
        });

        searchService.setForeground(new java.awt.Color(153, 153, 153));
        searchService.setText("Search service");
        searchService.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        searchService.setRadius(20);
        searchService.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchServiceFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchServiceFocusLost(evt);
            }
        });
        searchService.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchServiceKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout serviesCardLayout = new javax.swing.GroupLayout(serviesCard);
        serviesCard.setLayout(serviesCardLayout);
        serviesCardLayout.setHorizontalGroup(
            serviesCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(serviesCardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(serviesCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(serviesCardLayout.createSequentialGroup()
                        .addGap(0, 556, Short.MAX_VALUE)
                        .addComponent(servicesDeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(serviesCardLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchService, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(serviesCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(serviesCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel6)
                        .addComponent(serID, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(serName, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addComponent(serUnitComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(serCharge, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(jScrollPane3)
                        .addComponent(serTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(addServiceButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel21)
                    .addComponent(vehicalTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(servicesClearButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        serviesCardLayout.setVerticalGroup(
            serviesCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(serviesCardLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(serviesCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(searchService, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(serviesCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(serviesCardLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(serID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(serName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(serUnitComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vehicalTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(serCharge, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(servicesClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(serviesCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addServiceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(servicesDeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelCards.add(serviesCard, "serviesCard");

        allEmployeeCard.setBackground(new java.awt.Color(255, 255, 255));
        allEmployeeCard.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("Employees List");

        employeeTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        employeeTable.setModel(new javax.swing.table.DefaultTableModel(
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
        employeeTable.setGridColor(new java.awt.Color(204, 204, 204));
        employeeTable.setRowHeight(25);
        employeeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                employeeTableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(employeeTable);

        searchEmployees.setForeground(new java.awt.Color(153, 153, 153));
        searchEmployees.setText("Search employees");
        searchEmployees.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        searchEmployees.setRadius(20);
        searchEmployees.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchEmployeesFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchEmployeesFocusLost(evt);
            }
        });
        searchEmployees.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchEmployeesKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout allEmployeeCardLayout = new javax.swing.GroupLayout(allEmployeeCard);
        allEmployeeCard.setLayout(allEmployeeCardLayout);
        allEmployeeCardLayout.setHorizontalGroup(
            allEmployeeCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(allEmployeeCardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(allEmployeeCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(allEmployeeCardLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(allEmployeeCardLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1014, Short.MAX_VALUE)))
                .addContainerGap())
        );
        allEmployeeCardLayout.setVerticalGroup(
            allEmployeeCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(allEmployeeCardLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(allEmployeeCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(searchEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelCards.add(allEmployeeCard, "allEmployeeCard");

        addEmployeeCard.setBackground(new java.awt.Color(255, 255, 255));

        addEmployeeTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        addEmployeeTitle.setText("Add Employee");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel14.setText("Employee ID :");

        empID.setText("Auto Genarate");
        empID.setEnabled(false);
        empID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        empID.setRadius(20);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel15.setText("Name :");

        empName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        empName.setRadius(20);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel17.setText("Phone :");

        empPhone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        empPhone.setRadius(20);

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel18.setText("Description :");

        jScrollPane5.setBorder(null);

        empDescription.setColumns(20);
        empDescription.setRows(5);
        empDescription.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        empDescription.setRadius(20);
        jScrollPane5.setViewportView(empDescription);

        saveButton.setForeground(new java.awt.Color(255, 255, 255));
        saveButton.setText("Add Employee");
        saveButton.setBorderColor(new java.awt.Color(13, 180, 185));
        saveButton.setBorderPainted(false);
        saveButton.setColor(new java.awt.Color(13, 180, 185));
        saveButton.setColorClick(new java.awt.Color(11, 140, 144));
        saveButton.setColorOver(new java.awt.Color(11, 140, 144));
        saveButton.setFocusPainted(false);
        saveButton.setFocusable(false);
        saveButton.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        saveButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        saveButton.setIconTextGap(30);
        saveButton.setRadius(20);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel19.setText("Email :");

        empEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        empEmail.setRadius(20);

        empAddress.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        empAddress.setRadius(20);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel16.setText("Address :");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel20.setText("NIC :");

        empNIC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        empNIC.setRadius(20);

        empImgLable.setBackground(new java.awt.Color(0, 0, 0));
        empImgLable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add (1).png"))); // NOI18N
        empImgLable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        choosFileButton.setForeground(new java.awt.Color(13, 180, 185));
        choosFileButton.setText("Select Image");
        choosFileButton.setBorderColor(new java.awt.Color(13, 180, 185));
        choosFileButton.setBorderPainted(false);
        choosFileButton.setColorClick(new java.awt.Color(184, 248, 250));
        choosFileButton.setColorOver(new java.awt.Color(184, 248, 250));
        choosFileButton.setFocusPainted(false);
        choosFileButton.setFocusable(false);
        choosFileButton.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        choosFileButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        choosFileButton.setIconTextGap(30);
        choosFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choosFileButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Clear");
        cancelButton.setBorderColor(new java.awt.Color(255, 255, 255));
        cancelButton.setBorderPainted(false);
        cancelButton.setColorClick(new java.awt.Color(184, 248, 250));
        cancelButton.setColorOver(new java.awt.Color(184, 248, 250));
        cancelButton.setFocusPainted(false);
        cancelButton.setFocusable(false);
        cancelButton.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cancelButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        cancelButton.setIconTextGap(30);
        cancelButton.setRadius(20);
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel22.setText("Job Role :");

        jobRoleComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jobRoleComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jobRoleComboBoxActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel23.setText("Username :");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel24.setText("Password :");

        empPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        empPassword.setRadius(20);

        empUserName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        empUserName.setRadius(20);

        employeeDeleteButton.setBackground(new java.awt.Color(184, 248, 250));
        employeeDeleteButton.setText("Delete");
        employeeDeleteButton.setBorderColor(new java.awt.Color(13, 180, 185));
        employeeDeleteButton.setBorderPainted(false);
        employeeDeleteButton.setColor(new java.awt.Color(184, 248, 250));
        employeeDeleteButton.setColorClick(new java.awt.Color(126, 240, 244));
        employeeDeleteButton.setColorOver(new java.awt.Color(126, 240, 244));
        employeeDeleteButton.setFocusPainted(false);
        employeeDeleteButton.setFocusable(false);
        employeeDeleteButton.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        employeeDeleteButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        employeeDeleteButton.setRadius(20);
        employeeDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeDeleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addEmployeeCardLayout = new javax.swing.GroupLayout(addEmployeeCard);
        addEmployeeCard.setLayout(addEmployeeCardLayout);
        addEmployeeCardLayout.setHorizontalGroup(
            addEmployeeCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addEmployeeCardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addEmployeeCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addEmployeeCardLayout.createSequentialGroup()
                        .addComponent(employeeDeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addEmployeeCardLayout.createSequentialGroup()
                        .addGroup(addEmployeeCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(empName, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(empID, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addGroup(addEmployeeCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(empAddress, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addEmployeeCardLayout.createSequentialGroup()
                                    .addGroup(addEmployeeCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel17)
                                        .addComponent(empPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(addEmployeeCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel19)
                                        .addComponent(empEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel24)
                                        .addComponent(empPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(addEmployeeCardLayout.createSequentialGroup()
                                .addGroup(addEmployeeCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20)
                                    .addComponent(empNIC, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(addEmployeeCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jobRoleComboBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 244, Short.MAX_VALUE)
                        .addGroup(addEmployeeCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addEmployeeCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(choosFileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(empImgLable, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cancelButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(addEmployeeCardLayout.createSequentialGroup()
                        .addGroup(addEmployeeCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addEmployeeTitle)
                            .addComponent(jLabel23)
                            .addComponent(empUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        addEmployeeCardLayout.setVerticalGroup(
            addEmployeeCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addEmployeeCardLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(addEmployeeTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(addEmployeeCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(addEmployeeCardLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(empImgLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(choosFileButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(addEmployeeCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(addEmployeeCardLayout.createSequentialGroup()
                            .addComponent(jLabel22)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jobRoleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(addEmployeeCardLayout.createSequentialGroup()
                            .addComponent(jLabel14)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(empID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel15)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(empName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel20)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(empNIC, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addEmployeeCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(addEmployeeCardLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(empPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addEmployeeCardLayout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(empEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addEmployeeCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addEmployeeCardLayout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(empUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addEmployeeCardLayout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(empPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(empAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addEmployeeCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(addEmployeeCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(employeeDeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelCards.add(addEmployeeCard, "addEmployeeCard");

        vehicleTypesCard.setBackground(new java.awt.Color(255, 255, 255));

        VehicleTypeTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        VehicleTypeTable.setModel(new javax.swing.table.DefaultTableModel(
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
        VehicleTypeTable.setGridColor(new java.awt.Color(204, 204, 204));
        VehicleTypeTable.setRowHeight(25);
        VehicleTypeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VehicleTypeTableMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(VehicleTypeTable);

        VehicleTypeTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        VehicleTypeTitle.setText("Add Vehicle Type");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel26.setText("Vehicle Types List");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel27.setText("Vehicle Type ID :");

        VehicleTypeID.setText("Auto Genarate");
        VehicleTypeID.setEnabled(false);
        VehicleTypeID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        VehicleTypeID.setRadius(20);

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel28.setText("Vehicle Type Name :");

        VehicleTypeName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        VehicleTypeName.setRadius(20);

        addVehicleTypeButton.setForeground(new java.awt.Color(255, 255, 255));
        addVehicleTypeButton.setText("Add Vehicle Type");
        addVehicleTypeButton.setBorderColor(new java.awt.Color(13, 180, 185));
        addVehicleTypeButton.setBorderPainted(false);
        addVehicleTypeButton.setColor(new java.awt.Color(13, 180, 185));
        addVehicleTypeButton.setColorClick(new java.awt.Color(11, 140, 144));
        addVehicleTypeButton.setColorOver(new java.awt.Color(11, 140, 144));
        addVehicleTypeButton.setFocusPainted(false);
        addVehicleTypeButton.setFocusable(false);
        addVehicleTypeButton.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        addVehicleTypeButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        addVehicleTypeButton.setIconTextGap(30);
        addVehicleTypeButton.setRadius(20);
        addVehicleTypeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addVehicleTypeButtonActionPerformed(evt);
            }
        });

        VehiclelTypeDeleteButton.setBackground(new java.awt.Color(184, 248, 250));
        VehiclelTypeDeleteButton.setText("Delete");
        VehiclelTypeDeleteButton.setBorderColor(new java.awt.Color(13, 180, 185));
        VehiclelTypeDeleteButton.setBorderPainted(false);
        VehiclelTypeDeleteButton.setColor(new java.awt.Color(184, 248, 250));
        VehiclelTypeDeleteButton.setColorClick(new java.awt.Color(126, 240, 244));
        VehiclelTypeDeleteButton.setColorOver(new java.awt.Color(126, 240, 244));
        VehiclelTypeDeleteButton.setFocusPainted(false);
        VehiclelTypeDeleteButton.setFocusable(false);
        VehiclelTypeDeleteButton.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        VehiclelTypeDeleteButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        VehiclelTypeDeleteButton.setRadius(20);
        VehiclelTypeDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VehiclelTypeDeleteButtonActionPerformed(evt);
            }
        });

        vehicalTypeClearButton1.setText("Clear");
        vehicalTypeClearButton1.setBorderColor(new java.awt.Color(255, 255, 255));
        vehicalTypeClearButton1.setBorderPainted(false);
        vehicalTypeClearButton1.setColorClick(new java.awt.Color(126, 240, 244));
        vehicalTypeClearButton1.setColorOver(new java.awt.Color(126, 240, 244));
        vehicalTypeClearButton1.setFocusPainted(false);
        vehicalTypeClearButton1.setFocusable(false);
        vehicalTypeClearButton1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        vehicalTypeClearButton1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        vehicalTypeClearButton1.setRadius(10);
        vehicalTypeClearButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehicalTypeClearButton1ActionPerformed(evt);
            }
        });

        searchVehicalType.setForeground(new java.awt.Color(153, 153, 153));
        searchVehicalType.setText("Search vehicle type");
        searchVehicalType.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        searchVehicalType.setRadius(20);
        searchVehicalType.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchVehicalTypeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchVehicalTypeFocusLost(evt);
            }
        });
        searchVehicalType.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchVehicalTypeKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout vehicleTypesCardLayout = new javax.swing.GroupLayout(vehicleTypesCard);
        vehicleTypesCard.setLayout(vehicleTypesCardLayout);
        vehicleTypesCardLayout.setHorizontalGroup(
            vehicleTypesCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vehicleTypesCardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(vehicleTypesCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(vehicleTypesCardLayout.createSequentialGroup()
                        .addGap(0, 556, Short.MAX_VALUE)
                        .addComponent(VehiclelTypeDeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE)
                    .addGroup(vehicleTypesCardLayout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchVehicalType, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(vehicleTypesCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addVehicleTypeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vehicleTypesCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel27)
                        .addComponent(VehicleTypeID, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel28)
                        .addComponent(VehicleTypeName, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(VehicleTypeTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vehicalTypeClearButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        vehicleTypesCardLayout.setVerticalGroup(
            vehicleTypesCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vehicleTypesCardLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(vehicleTypesCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VehicleTypeTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(searchVehicalType, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(vehicleTypesCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(vehicleTypesCardLayout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(VehicleTypeID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(VehicleTypeName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(vehicalTypeClearButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(vehicleTypesCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addVehicleTypeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(VehiclelTypeDeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelCards.add(vehicleTypesCard, "vehicleTypesCard");

        productCard.setBackground(new java.awt.Color(255, 255, 255));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel29.setText("Product List");

        productTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        productTable.setModel(new javax.swing.table.DefaultTableModel(
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
        productTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        productTable.setGridColor(new java.awt.Color(204, 204, 204));
        productTable.setRowHeight(25);
        productTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productTableMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(productTable);

        productTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        productTitle.setText("Add Product");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel30.setText("Product ID :");

        productID.setText("Auto Genarate");
        productID.setEnabled(false);
        productID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        productID.setRadius(20);

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel31.setText("Product Name :");

        productName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        productName.setRadius(20);

        productClearButton.setText("Clear");
        productClearButton.setBorderColor(new java.awt.Color(255, 255, 255));
        productClearButton.setBorderPainted(false);
        productClearButton.setColorClick(new java.awt.Color(126, 240, 244));
        productClearButton.setColorOver(new java.awt.Color(126, 240, 244));
        productClearButton.setFocusPainted(false);
        productClearButton.setFocusable(false);
        productClearButton.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        productClearButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        productClearButton.setRadius(10);
        productClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productClearButtonActionPerformed(evt);
            }
        });

        addProductButton.setForeground(new java.awt.Color(255, 255, 255));
        addProductButton.setText("Add Product");
        addProductButton.setBorderColor(new java.awt.Color(13, 180, 185));
        addProductButton.setBorderPainted(false);
        addProductButton.setColor(new java.awt.Color(13, 180, 185));
        addProductButton.setColorClick(new java.awt.Color(11, 140, 144));
        addProductButton.setColorOver(new java.awt.Color(11, 140, 144));
        addProductButton.setFocusPainted(false);
        addProductButton.setFocusable(false);
        addProductButton.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        addProductButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        addProductButton.setIconTextGap(30);
        addProductButton.setRadius(20);
        addProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductButtonActionPerformed(evt);
            }
        });

        productDeleteButton.setBackground(new java.awt.Color(184, 248, 250));
        productDeleteButton.setText("Delete");
        productDeleteButton.setBorderColor(new java.awt.Color(13, 180, 185));
        productDeleteButton.setBorderPainted(false);
        productDeleteButton.setColor(new java.awt.Color(184, 248, 250));
        productDeleteButton.setColorClick(new java.awt.Color(126, 240, 244));
        productDeleteButton.setColorOver(new java.awt.Color(126, 240, 244));
        productDeleteButton.setFocusPainted(false);
        productDeleteButton.setFocusable(false);
        productDeleteButton.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        productDeleteButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        productDeleteButton.setRadius(20);
        productDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productDeleteButtonActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel32.setText("Price :");

        productPrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        productPrice.setRadius(20);

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel33.setText("Qnt :");

        productQnt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        productQnt.setRadius(20);

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel34.setText("Service Unit :");

        selectServiceUnitCombobox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        selectServiceUnitCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectServiceUnitComboboxActionPerformed(evt);
            }
        });

        searchProducts.setForeground(new java.awt.Color(153, 153, 153));
        searchProducts.setText("Search products");
        searchProducts.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        searchProducts.setRadius(20);
        searchProducts.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchProductsFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchProductsFocusLost(evt);
            }
        });
        searchProducts.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchProductsKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout productCardLayout = new javax.swing.GroupLayout(productCard);
        productCard.setLayout(productCardLayout);
        productCardLayout.setHorizontalGroup(
            productCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, productCardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(productCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(productCardLayout.createSequentialGroup()
                        .addGap(0, 568, Short.MAX_VALUE)
                        .addComponent(productDeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane7)
                    .addGroup(productCardLayout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(productCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addProductButton, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                    .addComponent(jLabel30)
                    .addComponent(productID, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31)
                    .addComponent(productName, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                    .addComponent(productTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(productClearButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33)
                    .addComponent(productQnt, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                    .addComponent(productPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel34)
                    .addComponent(selectServiceUnitCombobox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        productCardLayout.setVerticalGroup(
            productCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productCardLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(productCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29)
                    .addComponent(searchProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(productCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(productCardLayout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(productID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(productName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(productPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(productQnt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectServiceUnitCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(productClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(productCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addProductButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(productDeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelCards.add(productCard, "productCard");

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

    private void showSerPaneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showSerPaneButtonActionPerformed
        // TODO add your handling code here:
        resetButtonStyle();
        if(serviceButtonPane.isVisible()){
            resetButtonStyle();
            serviceButtonPane.setVisible(false);
        }else{
            showSerPaneButton.setColor(new Color(184,248,250));
            serviceButtonPane.setVisible(true);
        }
    }//GEN-LAST:event_showSerPaneButtonActionPerformed

    private void serButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serButtonActionPerformed
        // TODO add your handling code here:
        cardLayout.show(panelCards, "serviesCard");
        
        resetButtonStyle();
        serButton.setColor(new Color(184,248,250));
        
        //add data service unit combobox
        try {
            serUnitComboBox.removeAllItems();
            Statement statement = DBconnect.connectToDB().createStatement();
            statement.execute("Select Name From ServiceUnits");
            ResultSet resultSet = statement.getResultSet(); 
            while(resultSet.next()){
                serUnitComboBox.addItem(resultSet.getString("Name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //add data vehical type combobox
        try {
            vehicalTypeComboBox.removeAllItems();
            Statement statement = DBconnect.connectToDB().createStatement();
            statement.execute("Select Name From VehicleType");
            ResultSet resultSet = statement.getResultSet(); 
            while(resultSet.next()){
                vehicalTypeComboBox.addItem(resultSet.getString("Name"));
            }
            vehicalTypeComboBox.addItem("Other");
        } catch (SQLException ex) {
            Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //serviceTable data load
        LoadServicesTable("All");
    }//GEN-LAST:event_serButtonActionPerformed

    private void serUnitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serUnitButtonActionPerformed
        // TODO add your handling code here:
        cardLayout.show(panelCards, "serviesUnitCard");
        resetButtonStyle();
        serUnitButton.setColor(new Color(184,248,250));
    }//GEN-LAST:event_serUnitButtonActionPerformed

    private void showEmpPaneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showEmpPaneButtonActionPerformed
        // TODO add your handling code here:
        resetButtonStyle();
        if(employeeButtonPane.isVisible()){
        resetButtonStyle();
            employeeButtonPane.setVisible(false);
        }else{
            showEmpPaneButton.setColor(new Color(184,248,250));
            employeeButtonPane.setVisible(true);
        }
    }//GEN-LAST:event_showEmpPaneButtonActionPerformed

    private void addEmployeeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmployeeButtonActionPerformed
        // TODO add your handling code here:
        cardLayout.show(panelCards, "addEmployeeCard");
        
        resetButtonStyle();
        addEmployeeButton.setColor(new Color(184,248,250));
    }//GEN-LAST:event_addEmployeeButtonActionPerformed

    private void allEmployeeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allEmployeeButtonActionPerformed
        // TODO add your handling code here:
        cardLayout.show(panelCards, "allEmployeeCard");
        
        resetButtonStyle();
        allEmployeeButton.setColor(new Color(184,248,250));
        
        LoademployeeTable("All");
    }//GEN-LAST:event_allEmployeeButtonActionPerformed

    private void addServiceUnitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addServiceUnitButtonActionPerformed
        // TODO add your handling code here:
        String id = serUnitID.getText();
        String name = serUnitName.getText();
        try {
            Statement statement = DBconnect.connectToDB().createStatement();
            if(serUnitID.getText().equals("Auto Genarate")){
                statement.execute("INSERT INTO ServiceUnits (Name) VALUES('" + name + "')");
                System.out.println("Service Unit added successfully");
            }else{
                statement.execute("UPDATE ServiceUnits SET Name = '"+name+"' WHERE ID = '"+id+"';");
                System.out.println("Service Unit updated successfully");
                
                serUnitTitle.setText("Add Service Unit");
                addServiceUnitButton.setText("Add Unit");
            }
            
            serUnitID.setText("Auto Genarate");
            serUnitName.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Service Unit add unsuccessful !, try again ");
        }
        
        LoadServiceUnitTable("All");
    }//GEN-LAST:event_addServiceUnitButtonActionPerformed

    private void addServiceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addServiceButtonActionPerformed
        // TODO add your handling code here:
        String id = serID.getText();
        String name = serName.getText();
        String charge = serCharge.getText();
        String description = serDescription.getText();
        String unit = String.valueOf(serUnitComboBox.getSelectedItem());
        String VehicleType = String.valueOf(vehicalTypeComboBox.getSelectedItem());
        
        try {
            Statement statement = DBconnect.connectToDB().createStatement();
            if(id.equals("Auto Genarate")){
                statement.execute("INSERT INTO Services (Name, ServiceUnit, VehicleType, ServiceCharge, Description) VALUES('" + name + "', '" + unit + "', '"+ VehicleType +"', '" + charge + "', '" + description + "')");
            System.out.println("Service added successfully");
            }else{
                statement.execute("UPDATE Services SET Name = '"+name+"', ServiceUnit = '"+unit+"', VehicleType = '"+VehicleType+"', ServiceCharge = '"+charge+"', Description = '"+description+"' WHERE ID = '"+id+"';");
                System.out.println("Service Unit updated successfully");
                
                serTitle.setText("Add Service");
                addServiceButton.setText("Add Service");
            }
            
            serID.setText("Auto Genarate");
            serName.setText("");
            serCharge.setText("");
            serDescription.setText("");
            serUnitComboBox.setSelectedIndex(0);
            vehicalTypeComboBox.setSelectedIndex(0);
        } catch (SQLException ex) {
            Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Service add unsuccessful !, try again ");
        }
        
        LoadServicesTable("All");
    }//GEN-LAST:event_addServiceButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
        String id = empID.getText();
        String name = empName.getText();
        String nic = empNIC.getText();
        String phone = empPhone.getText();
        String email = empEmail.getText();
        String username = empUserName.getText();
        String password = empPassword.getText();
        String address = empAddress.getText();
        String description = empDescription.getText();
        String jobRole = String.valueOf(jobRoleComboBox.getSelectedItem());
        
        try {
            
            Statement statement = DBconnect.connectToDB().createStatement();
            if(id.equals("Auto Genarate")){
                statement.execute("INSERT INTO Employees (Name, NIC, ImgUrl, JobRole, Email, Phone, Address, Username, Password, Description) VALUES('" + name + "', '" + nic + "', '" + imagePath + "', '" + jobRole + "', '" + email + "', '" + phone + "', '" + address + "', '"+ username +"', '"+ password +"', '" + description + "')");
                System.out.println("Employee added successfully");
            }else{
                statement.execute("UPDATE Employees SET Name = '"+name+"', NIC = '"+nic+"', ImgUrl = '"+imagePath+"', JobRole = '"+jobRole+"', Email = '"+email+"', Phone = '"+phone+"', Address = '"+address+"', Username = '"+username+"', Password = '"+password+"', Description = '"+description+"' WHERE ID = '"+id+"';");
                System.out.println("Employee updated successfully");
                
                addEmployeeTitle.setText("Add Employee");
                saveButton.setText("Add Employee");
                
                employeeDeleteButton.setVisible(false);
                allEmployeeButtonActionPerformed(null);
            }
            
            cancelButtonActionPerformed(null);
        } catch (SQLException ex) {
            Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Employee add unsuccessful !, try again ");
        }
        
    }//GEN-LAST:event_saveButtonActionPerformed

    private void choosFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choosFileButtonActionPerformed
        // TODO add your handling code here:
//        JFileChooser file = new JFileChooser();
//        file.setCurrentDirectory(new File(System.getProperty("user.home")));
//        FileNameExtensionFilter filter = new FileNameExtensionFilter("#.images", "*.jpg", "*.png");
//        file.addChoosableFileFilter(filter);
//        int result = file.showSaveDialog(null);
//        
//        if(result == JFileChooser.APPROVE_OPTION){
//            File selectedfile = file.getSelectedFile();
//            String path = selectedfile.getAbsolutePath();
//            
//            ImageIcon icon = new ImageIcon(path);
//            Image in = icon.getImage();
//            Image modified = in.getScaledInstance(211, 211, java.awt.Image.SCALE_SMOOTH);
//            icon = new ImageIcon(modified);
//            
//            empImgLable.setIcon(icon);
//            imagePath = path;
//            }
        JnaFileChooser ch = new JnaFileChooser();
        boolean action =ch.showOpenDialog(null);
        
        if(action){
            String extension = ch.getSelectedFile().getName().substring(ch.getSelectedFile().getName().lastIndexOf(".") + 1);
            if((extension.equals("jpg")) || (extension.equals("jpeg")) || (extension.equals("png"))){
                String path = String.valueOf(ch.getSelectedFile());
            
                ImageIcon icon = new ImageIcon(path);
                Image in = icon.getImage();
                Image modified = in.getScaledInstance(211, 211, java.awt.Image.SCALE_SMOOTH);
                icon = new ImageIcon(modified);

                empImgLable.setIcon(icon);
                imagePath = path;
            }else{
                JOptionPane.showMessageDialog(null, "This file format is not supported !");
            }
        }
    }//GEN-LAST:event_choosFileButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        addEmployeeTitle.setText("Add Employee");
        saveButton.setText("Add Employee");
        
        empID.setText("Auto Genarate");
        empName.setText("");
        empNIC.setText("");
        empPhone.setText("");
        empEmail.setText("");
        empPassword.setText("");
        empUserName.setText("");
        empAddress.setText("");
        empDescription.setText("");
        jobRoleComboBox.setSelectedIndex(1);
        
        if(empID.getText().equals("Auto Genarate")){
            employeeDeleteButton.setVisible(false);
        }
        
        ImageIcon icon = new ImageIcon("D:\\Java Project\\Vehical Service System\\src\\Image\\add (1).png");
        Image in = icon.getImage();
        Image modified = in.getScaledInstance(211, 211, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(modified);
        empImgLable.setIcon(icon);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void jobRoleComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jobRoleComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jobRoleComboBoxActionPerformed

    private void VehicleTypesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VehicleTypesButtonActionPerformed
        // TODO add your handling code here:
        cardLayout.show(panelCards, "vehicleTypesCard");
        
        resetButtonStyle();
        VehicleTypesButton.setColor(new Color(184,248,250));
        
        LoadVehicalTypeTable("All");
    }//GEN-LAST:event_VehicleTypesButtonActionPerformed

    private void addVehicleTypeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addVehicleTypeButtonActionPerformed
        // TODO add your handling code here:
        String id = VehicleTypeID.getText();
        String name = VehicleTypeName.getText();
        
        try {
            Statement statement = DBconnect.connectToDB().createStatement();
            if(id.equals("Auto Genarate")){
                statement.execute("INSERT INTO VehicleType (Name) VALUES('" + name + "')");
            System.out.println("Vehicle Type added successfully");
            }else{
                statement.execute("UPDATE VehicleType SET Name = '"+name+"' WHERE ID = '"+id+"';");
                System.out.println("Vehicle Type updated successfully");
                
                VehicleTypeTitle.setText("Add Vehicle Type");
                addVehicleTypeButton.setText("Add Vehicle Type");
            }
            
            VehicleTypeID.setText("Auto Genarate");
            VehicleTypeName.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Vehicle Type add unsuccessful !, try again ");
        }
        
        LoadVehicalTypeTable("All");
    }//GEN-LAST:event_addVehicleTypeButtonActionPerformed

    private void servicesUnitDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_servicesUnitDeleteButtonActionPerformed
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this?", "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.YES_OPTION){
            try {
                Statement statement = DBconnect.connectToDB().createStatement();
                int index = (int) serviceUnitTable.getModel().getValueAt(serviceUnitTable.getSelectedRow(),0);
                statement.execute("DELETE FROM ServiceUnits WHERE ID = '"+index+"'");
            } catch (SQLException ex) {
                Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            
        LoadServiceUnitTable("All");
        
        serUnitTitle.setText("Add Service Unit");
        addServiceUnitButton.setText("Add Unit");
        serUnitID.setText("Auto Genarate");
        serUnitName.setText("");
    }//GEN-LAST:event_servicesUnitDeleteButtonActionPerformed

    private void servicesDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_servicesDeleteButtonActionPerformed
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this?", "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.YES_OPTION){
            try {
                Statement statement = DBconnect.connectToDB().createStatement();
                int index = (int) serviceTable.getModel().getValueAt(serviceTable.getSelectedRow(),0);
                statement.execute("DELETE FROM Services WHERE ID = '"+index+"'");
            } catch (SQLException ex) {
                Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            
        LoadServicesTable("All");
        
        serTitle.setText("Add Service");
        addServiceButton.setText("Add Service");
        serID.setText("Auto Genarate");
        serName.setText("");
        serCharge.setText("");
        serDescription.setText("");
        serUnitComboBox.setSelectedIndex(0);
        vehicalTypeComboBox.setSelectedIndex(0);
    }//GEN-LAST:event_servicesDeleteButtonActionPerformed

    private void VehiclelTypeDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VehiclelTypeDeleteButtonActionPerformed
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this?", "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.YES_OPTION){
            try {
                Statement statement = DBconnect.connectToDB().createStatement();
                int index = (int) VehicleTypeTable.getModel().getValueAt(VehicleTypeTable.getSelectedRow(),0);
                statement.execute("DELETE FROM VehicleType WHERE ID = '"+index+"'");
            } catch (SQLException ex) {
                Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            
        LoadVehicalTypeTable("All");
    }//GEN-LAST:event_VehiclelTypeDeleteButtonActionPerformed

    private void serviceUnitTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_serviceUnitTableMouseClicked
        // TODO add your handling code here:
        try {
                Statement statement = DBconnect.connectToDB().createStatement();
                int index = (int) serviceUnitTable.getModel().getValueAt(serviceUnitTable.getSelectedRow(),0);
                statement.execute("Select * From ServiceUnits WHERE ID = '"+index+"'");
                ResultSet resultSet = statement.getResultSet();
                if(resultSet.next()){
                    serUnitTitle.setText("Update Service Unit");
                    serUnitID.setText(resultSet.getString("ID"));
                    serUnitName.setText(resultSet.getString("Name"));
                    addServiceUnitButton.setText("Update Unit");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_serviceUnitTableMouseClicked

    private void serviceTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_serviceTableMouseClicked
        // TODO add your handling code here:
        try {
                Statement statement = DBconnect.connectToDB().createStatement();
                int index = (int) serviceTable.getModel().getValueAt(serviceTable.getSelectedRow(),0);
                statement.execute("Select * From Services WHERE ID = '"+index+"'");
                ResultSet resultSet = statement.getResultSet();
                if(resultSet.next()){
                    serTitle.setText("Update Service");
                    serID.setText(resultSet.getString("ID"));
                    serName.setText(resultSet.getString("Name"));
                    serUnitComboBox.setSelectedItem(resultSet.getString("ServiceUnit"));
                    vehicalTypeComboBox.setSelectedItem(resultSet.getString("VehicleType"));
                    serCharge.setText(resultSet.getString("ServiceCharge"));
                    serDescription.setText(resultSet.getString("Description"));
                    addServiceButton.setText("Update Service");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_serviceTableMouseClicked

    private void VehicleTypeTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VehicleTypeTableMouseClicked
        // TODO add your handling code here:
        try {
            Statement statement = DBconnect.connectToDB().createStatement();
            int index = (int) VehicleTypeTable.getModel().getValueAt(VehicleTypeTable.getSelectedRow(),0);
            statement.execute("Select * From VehicleType WHERE ID = '"+index+"'");
            ResultSet resultSet = statement.getResultSet();
            if(resultSet.next()){
                VehicleTypeTitle.setText("Update Vehicle Type");
                VehicleTypeID.setText(resultSet.getString("ID"));
                VehicleTypeName.setText(resultSet.getString("Name"));
                addVehicleTypeButton.setText("Update Vehicle Type");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_VehicleTypeTableMouseClicked

    private void employeeTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeeTableMouseClicked
        // TODO add your handling code here:
        addEmployeeButtonActionPerformed(null);

        try {
            Statement statement = DBconnect.connectToDB().createStatement();
            int index = (int) employeeTable.getModel().getValueAt(employeeTable.getSelectedRow(),0);
            statement.execute("Select * From Employees WHERE ID = '"+index+"'");
            ResultSet resultSet = statement.getResultSet();
            if(resultSet.next()){
                addEmployeeTitle.setText("Update Employee");
                saveButton.setText("Update Employee");
                employeeDeleteButton.setVisible(true);
                
                empID.setText(resultSet.getString("ID"));
                empName.setText(resultSet.getString("Name"));
                empNIC.setText(resultSet.getString("NIC"));
                jobRoleComboBox.setSelectedItem(resultSet.getString("JobRole"));
                empPhone.setText(resultSet.getString("Phone"));
                empEmail.setText(resultSet.getString("Email"));
                empUserName.setText(resultSet.getString("Username"));
                empPassword.setText(resultSet.getString("Password"));
                empAddress.setText(resultSet.getString("Address"));
                empDescription.setText(resultSet.getString("Description"));
                
                ImageIcon icon = new ImageIcon(resultSet.getString("ImgUrl"));
                Image in = icon.getImage();
                Image modified = in.getScaledInstance(211, 211, java.awt.Image.SCALE_SMOOTH);
                icon = new ImageIcon(modified);
                empImgLable.setIcon(icon);
                imagePath = resultSet.getString("ImgUrl");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_employeeTableMouseClicked

    private void employeeDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeDeleteButtonActionPerformed
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this?", "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.YES_OPTION){
            try {
                Statement statement = DBconnect.connectToDB().createStatement();
                int index = (int) employeeTable.getModel().getValueAt(employeeTable.getSelectedRow(),0);
                statement.execute("DELETE FROM Employees WHERE ID = '"+index+"'");
            } catch (SQLException ex) {
                Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            
        LoademployeeTable("All");
        cancelButtonActionPerformed(null);
        allEmployeeButtonActionPerformed(null);
    }//GEN-LAST:event_employeeDeleteButtonActionPerformed

    private void servicesUnitClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_servicesUnitClearButtonActionPerformed
        // TODO add your handling code here:
        serUnitTitle.setText("Add Service Unit");
        addServiceUnitButton.setText("Add Unit");
        serUnitID.setText("Auto Genarate");
        serUnitName.setText("");
    }//GEN-LAST:event_servicesUnitClearButtonActionPerformed

    private void servicesClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_servicesClearButtonActionPerformed
        // TODO add your handling code here:
        serTitle.setText("Add Service");
        addServiceButton.setText("Add Service");
        serID.setText("Auto Genarate");
        serName.setText("");
        serCharge.setText("");
        serDescription.setText("");
        serUnitComboBox.setSelectedIndex(0);
        vehicalTypeComboBox.setSelectedIndex(0);
    }//GEN-LAST:event_servicesClearButtonActionPerformed

    private void vehicalTypeClearButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehicalTypeClearButton1ActionPerformed
        // TODO add your handling code here:
        VehicleTypeTitle.setText("Add Vehicle Type");
        addVehicleTypeButton.setText("Add Vehicle Type");
        VehicleTypeID.setText("Auto Genarate");
        VehicleTypeName.setText("");
    }//GEN-LAST:event_vehicalTypeClearButton1ActionPerformed

    private void vehicalTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehicalTypeComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vehicalTypeComboBoxActionPerformed

    private void productButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productButtonActionPerformed
        // TODO add your handling code here:
        cardLayout.show(panelCards, "productCard");
        
        resetButtonStyle();
        productButton.setColor(new Color(184,248,250));
        
        try {
            selectServiceUnitCombobox.removeAllItems();
            Statement statement = DBconnect.connectToDB().createStatement();
            statement.execute("Select Name From ServiceUnits");
            ResultSet resultSet = statement.getResultSet(); 
            while(resultSet.next()){
                selectServiceUnitCombobox.addItem(resultSet.getString("Name"));
            }
            selectServiceUnitCombobox.addItem("Both");
        } catch (SQLException ex) {
            Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        LoadProductTable("All");
    }//GEN-LAST:event_productButtonActionPerformed

    private void productTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productTableMouseClicked
        // TODO add your handling code here:
        try {
            Statement statement = DBconnect.connectToDB().createStatement();
            int index = (int) productTable.getModel().getValueAt(productTable.getSelectedRow(),0);
            statement.execute("Select * From Products WHERE ID = '"+index+"'");
            ResultSet resultSet = statement.getResultSet();
            if(resultSet.next()){
                productTitle.setText("Update Product");
                productID.setText(resultSet.getString("ID"));
                productName.setText(resultSet.getString("Name"));
                productPrice.setText(resultSet.getString("Price"));
                productQnt.setText(resultSet.getString("Qnt"));
                selectServiceUnitCombobox.setSelectedItem(resultSet.getString("ServiceUnit"));
                addProductButton.setText("Update Product");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_productTableMouseClicked

    private void productClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productClearButtonActionPerformed
        // TODO add your handling code here:
        productTitle.setText("Add Product");
        addProductButton.setText("Add Product");
        productID.setText("Auto Genarate");
        productName.setText("");
        productPrice.setText("");
        productQnt.setText("");
        selectServiceUnitCombobox.setSelectedIndex(0);
    }//GEN-LAST:event_productClearButtonActionPerformed

    private void addProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductButtonActionPerformed
        // TODO add your handling code here:
        String id = productID.getText();
        String name = productName.getText();
        String price = productPrice.getText();
        String qnt = productQnt.getText();
        String serviceUnit = String.valueOf(selectServiceUnitCombobox.getSelectedItem());
        
        try {
            
            Statement statement = DBconnect.connectToDB().createStatement();
            if(id.equals("Auto Genarate")){
                statement.execute("INSERT INTO Products (Name, Price, Qnt, ServiceUnit) VALUES('" + name + "', '" + price + "', '" + qnt + "', '" + serviceUnit + "')");
                System.out.println("Product added successfully");
            }else{
                statement.execute("UPDATE Products SET Name = '"+name+"', Price = '"+price+"', Qnt = '"+qnt+"', ServiceUnit = '"+serviceUnit+"' WHERE ID = '"+id+"';");
                System.out.println("Product updated successfully");
                
                productTitle.setText("Add Product");
                addProductButton.setText("Add Product");
            }
            LoadProductTable("All");
            productClearButtonActionPerformed(null);
        } catch (SQLException ex) {
            Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Product add unsuccessful !, try again ");
        }
    }//GEN-LAST:event_addProductButtonActionPerformed

    private void productDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productDeleteButtonActionPerformed
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this?", "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.YES_OPTION){
            try {
                Statement statement = DBconnect.connectToDB().createStatement();
                int index = (int) productTable.getModel().getValueAt(productTable.getSelectedRow(),0);
                statement.execute("DELETE FROM Products WHERE ID = '"+index+"'");
            } catch (SQLException ex) {
                Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            
        LoadProductTable("All");
        
        productTitle.setText("Add Product");
        addProductButton.setText("Add Product");
        productID.setText("Auto Genarate");
        productName.setText("");
        productPrice.setText("");
        productQnt.setText("");
        selectServiceUnitCombobox.setSelectedIndex(0);
    }//GEN-LAST:event_productDeleteButtonActionPerformed

    private void selectServiceUnitComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectServiceUnitComboboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectServiceUnitComboboxActionPerformed

    private void searchSerUnitsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchSerUnitsFocusGained
        // TODO add your handling code here:
        if(searchSerUnits.getText().equals("Search service units")){
            searchSerUnits.setText("");
            searchSerUnits.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_searchSerUnitsFocusGained

    private void searchSerUnitsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchSerUnitsFocusLost
        // TODO add your handling code here:
        if(searchSerUnits.getText().equals("")){
            searchSerUnits.setText("Search service units");
            searchSerUnits.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_searchSerUnitsFocusLost

    private void searchSerUnitsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchSerUnitsKeyReleased
        // TODO add your handling code here:
        LoadServiceUnitTable(searchSerUnits.getText());
    }//GEN-LAST:event_searchSerUnitsKeyReleased

    private void searchServiceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchServiceFocusGained
        // TODO add your handling code here:
        if(searchService.getText().equals("Search service")){
            searchService.setText("");
            searchService.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_searchServiceFocusGained

    private void searchServiceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchServiceFocusLost
        // TODO add your handling code here:
        if(searchService.getText().equals("")){
            searchService.setText("Search service");
            searchService.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_searchServiceFocusLost

    private void searchServiceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchServiceKeyReleased
        // TODO add your handling code here:
        LoadServicesTable(searchService.getText());
    }//GEN-LAST:event_searchServiceKeyReleased

    private void searchEmployeesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchEmployeesFocusGained
        // TODO add your handling code here:
        if(searchEmployees.getText().equals("Search employees")){
            searchEmployees.setText("");
            searchEmployees.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_searchEmployeesFocusGained

    private void searchEmployeesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchEmployeesFocusLost
        // TODO add your handling code here:
        if(searchEmployees.getText().equals("")){
            searchEmployees.setText("Search employees");
            searchEmployees.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_searchEmployeesFocusLost

    private void searchEmployeesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchEmployeesKeyReleased
        // TODO add your handling code here:
        LoademployeeTable(searchEmployees.getText());
    }//GEN-LAST:event_searchEmployeesKeyReleased

    private void searchVehicalTypeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchVehicalTypeFocusGained
        // TODO add your handling code here:
        if(searchVehicalType.getText().equals("Search vehicle type")){
            searchVehicalType.setText("");
            searchVehicalType.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_searchVehicalTypeFocusGained

    private void searchVehicalTypeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchVehicalTypeFocusLost
        // TODO add your handling code here:
        if(searchVehicalType.getText().equals("")){
            searchVehicalType.setText("Search vehicle type");
            searchVehicalType.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_searchVehicalTypeFocusLost

    private void searchVehicalTypeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchVehicalTypeKeyReleased
        // TODO add your handling code here:
        LoadVehicalTypeTable(searchVehicalType.getText());
    }//GEN-LAST:event_searchVehicalTypeKeyReleased

    private void searchProductsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchProductsFocusGained
        // TODO add your handling code here:
        if(searchProducts.getText().equals("Search products")){
            searchProducts.setText("");
            searchProducts.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_searchProductsFocusGained

    private void searchProductsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchProductsFocusLost
        // TODO add your handling code here:
        if(searchProducts.getText().equals("")){
            searchProducts.setText("Search products");
            searchProducts.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_searchProductsFocusLost

    private void searchProductsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchProductsKeyReleased
        // TODO add your handling code here:
        LoadProductTable(searchProducts.getText());
    }//GEN-LAST:event_searchProductsKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private fosalgo.FTextField VehicleTypeID;
    private fosalgo.FTextField VehicleTypeName;
    private javax.swing.JTable VehicleTypeTable;
    private javax.swing.JLabel VehicleTypeTitle;
    private button.MyButton VehicleTypesButton;
    private button.MyButton VehiclelTypeDeleteButton;
    private button.MyButton addEmployeeButton;
    private javax.swing.JPanel addEmployeeCard;
    private javax.swing.JLabel addEmployeeTitle;
    private button.MyButton addProductButton;
    private button.MyButton addServiceButton;
    private button.MyButton addServiceUnitButton;
    private button.MyButton addVehicleTypeButton;
    private button.MyButton allEmployeeButton;
    private javax.swing.JPanel allEmployeeCard;
    private button.MyButton cancelButton;
    private button.MyButton choosFileButton;
    private fosalgo.FTextField empAddress;
    private CustomComponents.MyTextArea empDescription;
    private fosalgo.FTextField empEmail;
    private fosalgo.FTextField empID;
    private javax.swing.JLabel empImgLable;
    private fosalgo.FTextField empNIC;
    private fosalgo.FTextField empName;
    private CustomComponents.FTPasswordextField empPassword;
    private fosalgo.FTextField empPhone;
    private fosalgo.FTextField empUserName;
    private javax.swing.JPanel employeeButtonPane;
    private button.MyButton employeeDeleteButton;
    private javax.swing.JTable employeeTable;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private CustomComponents.Combobox jobRoleComboBox;
    private javax.swing.JPanel panelCards;
    private button.MyButton productButton;
    private javax.swing.JPanel productCard;
    private button.MyButton productClearButton;
    private button.MyButton productDeleteButton;
    private fosalgo.FTextField productID;
    private fosalgo.FTextField productName;
    private fosalgo.FTextField productPrice;
    private fosalgo.FTextField productQnt;
    private javax.swing.JTable productTable;
    private javax.swing.JLabel productTitle;
    private button.MyButton saveButton;
    private fosalgo.FTextField searchEmployees;
    private fosalgo.FTextField searchProducts;
    private fosalgo.FTextField searchSerUnits;
    private fosalgo.FTextField searchService;
    private fosalgo.FTextField searchVehicalType;
    private CustomComponents.Combobox selectServiceUnitCombobox;
    private button.MyButton serButton;
    private fosalgo.FTextField serCharge;
    private CustomComponents.MyTextArea serDescription;
    private fosalgo.FTextField serID;
    private fosalgo.FTextField serName;
    private javax.swing.JLabel serTitle;
    private button.MyButton serUnitButton;
    private CustomComponents.Combobox serUnitComboBox;
    private fosalgo.FTextField serUnitID;
    private fosalgo.FTextField serUnitName;
    private javax.swing.JLabel serUnitTitle;
    private javax.swing.JPanel serviceButtonPane;
    private javax.swing.JTable serviceTable;
    private javax.swing.JTable serviceUnitTable;
    private button.MyButton servicesClearButton;
    private button.MyButton servicesDeleteButton;
    private button.MyButton servicesUnitClearButton;
    private button.MyButton servicesUnitDeleteButton;
    private javax.swing.JPanel serviesCard;
    private javax.swing.JPanel serviesUnitCard;
    private button.MyButton showEmpPaneButton;
    private button.MyButton showSerPaneButton;
    private button.MyButton vehicalTypeClearButton1;
    private CustomComponents.Combobox vehicalTypeComboBox;
    private javax.swing.JPanel vehicleTypesCard;
    // End of variables declaration//GEN-END:variables
}
