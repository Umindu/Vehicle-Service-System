/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vehicles;

import DBConnect.DBconnect;
import Manage.Manage;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.Timer;
import javax.swing.border.MatteBorder;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import net.miginfocom.swing.MigLayout;

public class Vehicles extends javax.swing.JInternalFrame implements Runnable, ThreadFactory {

    private DefaultListModel ListModel;
    private Vehicles vehicles;

    private WebcamPanel campanel = null;
    private Webcam webcam = null;
    private Executor executor = Executors.newSingleThreadExecutor(this);

    ArrayList<ArrayList<String>> cartProductList = new ArrayList<>();
    ArrayList<String> alreadyAddProducts = new ArrayList<>();

    public Vehicles(String jobroleLable) {
        initComponents();

        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);

        sidePanel.setBorder(new MatteBorder(0, 10, 0, 0, new Color(242, 242, 242)));

        //select Service Unit Combobox data set
        try {
            selectServiceUnitCombobox.removeAllItems();
            Statement statement = DBconnect.connectToDB().createStatement();
            statement.execute("Select Name From ServiceUnits");
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                selectServiceUnitCombobox.addItem(resultSet.getString("Name"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Manage.class.getName()).log(Level.SEVERE, null, ex);
        }

        //search menu
        searchMenu.add(searchPanel);
        ListModel = new DefaultListModel();
        searchPanelList.setModel(ListModel);

        productListPanel.setLayout(new MigLayout("inset 0, fillx, wrap", "[fill]"));

        showDate();
        showTime();

        initWebcam();
        
        //tip text set 
//        searchPanelList.addMouseMotionListener(new MouseMotionListener() {
//            @Override
//            public void mouseMoved(MouseEvent e) {
//                JList l = (JList) e.getSource();
//                ListModel m = l.getModel();
//                int index = l.locationToIndex(e.getPoint());
//                if (index > -1) {
//                    l.setToolTipText(m.getElementAt(index).toString());
//                }
//            }
//
//            @Override
//            public void mouseDragged(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//            }
//        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        searchPanelList = new javax.swing.JList<>();
        searchMenu = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        dateLable = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        sidePanel = new javax.swing.JPanel();
        searchProduct = new fosalgo.FTextField();
        progressButton1 = new button.MyButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        productListPanel = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        serviceChargeTextField = new fosalgo.FTextField();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        ownerPhone = new fosalgo.FTextField();
        invoiceSearch = new fosalgo.FTextField();
        ownerName = new fosalgo.FTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        description = new CustomComponents.MyTextArea();
        VehicleRegNo = new fosalgo.FTextField();
        selectServiceUnitCombobox = new CustomComponents.Combobox();
        timeLabel = new javax.swing.JLabel();
        cancelButton = new button.MyButton();
        VehicleType = new fosalgo.FTextField();
        webCamOpenWindow = new javax.swing.JPanel();

        searchPanelList.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        searchPanelList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchPanelListMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(searchPanelList);

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );

        searchMenu.setFocusable(false);

        setBorder(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(242, 242, 242), 10));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Invoice No : ");

        dateLable.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        dateLable.setText("Date : 2023-04-03  ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Vehicle Registration No :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Owner Name :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("Description :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("Vehicle Type :");

        sidePanel.setBackground(new java.awt.Color(255, 255, 255));

        searchProduct.setToolTipText("");
        searchProduct.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        searchProduct.setRadius(20);
        searchProduct.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchProductKeyReleased(evt);
            }
        });

        progressButton1.setForeground(new java.awt.Color(255, 255, 255));
        progressButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/angle-right.png"))); // NOI18N
        progressButton1.setText("Continue");
        progressButton1.setBorderColor(new java.awt.Color(13, 180, 185));
        progressButton1.setBorderPainted(false);
        progressButton1.setColor(new java.awt.Color(13, 180, 185));
        progressButton1.setColorClick(new java.awt.Color(11, 140, 144));
        progressButton1.setColorOver(new java.awt.Color(11, 140, 144));
        progressButton1.setFocusPainted(false);
        progressButton1.setFocusable(false);
        progressButton1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        progressButton1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        progressButton1.setIconTextGap(30);
        progressButton1.setRadius(20);
        progressButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                progressButton1ActionPerformed(evt);
            }
        });

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        productListPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        productListPanel.setMinimumSize(new java.awt.Dimension(100, 100));

        javax.swing.GroupLayout productListPanelLayout = new javax.swing.GroupLayout(productListPanel);
        productListPanel.setLayout(productListPanelLayout);
        productListPanelLayout.setHorizontalGroup(
            productListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 418, Short.MAX_VALUE)
        );
        productListPanelLayout.setVerticalGroup(
            productListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 458, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(productListPanel);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("Service Charge : (Rs.)");

        serviceChargeTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        serviceChargeTextField.setRadius(15);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel8.setText("Search Product ");

        javax.swing.GroupLayout sidePanelLayout = new javax.swing.GroupLayout(sidePanel);
        sidePanel.setLayout(sidePanelLayout);
        sidePanelLayout.setHorizontalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(progressButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, sidePanelLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 48, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, sidePanelLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(serviceChargeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        sidePanelLayout.setVerticalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serviceChargeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(progressButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setText("Phone No: ");

        ownerPhone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ownerPhone.setRadius(20);

        invoiceSearch.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        invoiceSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        invoiceSearch.setRadius(20);
        invoiceSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                invoiceSearchKeyReleased(evt);
            }
        });

        ownerName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ownerName.setRadius(20);

        jScrollPane1.setBorder(null);

        description.setColumns(20);
        description.setRows(5);
        description.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        description.setRadius(20);
        jScrollPane1.setViewportView(description);

        VehicleRegNo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        VehicleRegNo.setRadius(20);

        selectServiceUnitCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectServiceUnitComboboxActionPerformed(evt);
            }
        });

        timeLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        timeLabel.setText("Time : 12:45");

        cancelButton.setText("Cancel");
        cancelButton.setBorderColor(new java.awt.Color(13, 180, 185));
        cancelButton.setBorderPainted(false);
        cancelButton.setColorClick(new java.awt.Color(126, 240, 244));
        cancelButton.setColorOver(new java.awt.Color(126, 240, 244));
        cancelButton.setFocusPainted(false);
        cancelButton.setFocusable(false);
        cancelButton.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cancelButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        cancelButton.setRadius(20);
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        VehicleType.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        VehicleType.setRadius(20);

        webCamOpenWindow.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(VehicleRegNo, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(ownerName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ownerPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(VehicleType, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(webCamOpenWindow, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(invoiceSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 415, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(selectServiceUnitCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(dateLable)
                                        .addGap(21, 21, 21)
                                        .addComponent(timeLabel)))
                                .addGap(6, 6, 6))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(sidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(selectServiceUnitCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dateLable)
                        .addComponent(timeLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(invoiceSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(VehicleRegNo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ownerName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ownerPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(VehicleType, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(webCamOpenWindow, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(sidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setObject(Vehicles vehicles) {
        this.vehicles = vehicles;
    }

    //Read QR ................
    public void CloseWebCam() {
        webcam.close();
    }

    private void initWebcam() {
        Dimension size = WebcamResolution.QVGA.getSize();
        webcam = Webcam.getWebcams().get(0);
        webcam.setViewSize(size);

        campanel = new WebcamPanel(webcam);
        campanel.setPreferredSize(size);
        campanel.setFPSDisplayed(true);
        campanel.setMirrored(true);

        webCamOpenWindow.add(campanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 0, 330, 250));

        executor.execute(this);
    }

    @Override
    public void run() {
        do {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Result result = null;
            BufferedImage image = null;

            if (webcam.isOpen()) {
                if ((image = webcam.getImage()) == null) {
                    continue;
                }

                LuminanceSource source = new BufferedImageLuminanceSource(image);
                BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

                try {
                    result = new MultiFormatReader().decode(bitmap);
                } catch (NotFoundException ex) {
//                    Logger.getLogger(Vehicles.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (result != null) {
                String[] invoiceno = result.getText().split(",");
                if ((invoiceSearch.getText().isEmpty()) || (!invoiceno[0].equals(invoiceSearch.getText()))) {
                    cancelButtonActionPerformed(null);
                    try {
                        Statement statement = DBconnect.connectToDB().createStatement();
                        statement.execute("SELECT * FROM VehicleDetails WHERE InvoiceNo = '" + invoiceno[0] + "'");
                        ResultSet resultSet = statement.getResultSet();
                        if (resultSet.next()) {
                            invoiceSearch.setText(invoiceno[0]);
                            VehicleRegNo.setText(resultSet.getString("VehicleNo"));
                            ownerName.setText(resultSet.getString("OwnerName"));
                            ownerPhone.setText(resultSet.getString("Phone"));
                            VehicleType.setText(resultSet.getString("VehicleType"));
                            description.setText(resultSet.getString("Description"));

                            Toolkit.getDefaultToolkit().beep();

                            statement.execute("SELECT ID FROM SoldProducts WHERE InvoiceID = '" + invoiceno[0] + "'");
                            ResultSet resultSet2 = statement.getResultSet();
                            if (resultSet2.next()) {
                                AlreadyProductLoad(invoiceno[0]);
                            }
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Vehicles.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } while (true);
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "My Thread");
        t.setDaemon(true);
        return t;
    }

    //Read QR ................
    public void showDate() {
        SimpleDateFormat fdate = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        dateLable.setText("Date - " + fdate.format(date));
    }

    public void showTime() {
        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat ftime = new SimpleDateFormat("hh:mm:ss a");
                Date time = new Date();
                timeLabel.setText(ftime.format(time));
            }
        }).start();
    }

    public void RefrashProductListPanel() {
        productListPanel.removeAll();
        for (int i = 0; i < cartProductList.size(); i++) {
            String id = cartProductList.get(i).get(0);
            String name = cartProductList.get(i).get(1);
            float price = Float.parseFloat(cartProductList.get(i).get(2));
            float qnt = Float.parseFloat(cartProductList.get(i).get(3));
            productListPanel.add(new ProductItem(vehicles, id, name, price, qnt));
        }

        //productListPanel refresh
        productListPanel.invalidate();
        productListPanel.validate();
        productListPanel.repaint();
    }

    public void RemoveProductListPanel(String id) {
        productListPanel.removeAll();
        for (int i = 0; i < cartProductList.size(); i++) {
            if (cartProductList.get(i).get(0) == id) {
                cartProductList.remove(i);
            }
        }
        RefrashProductListPanel();
    }

    public void ChangeProductQnt(String id, float qnt, float total) {
        for (int i = 0; i < cartProductList.size(); i++) {
            if (cartProductList.get(i).get(0) == id) {
                cartProductList.get(i).set(3, String.valueOf(qnt));
                cartProductList.get(i).set(4, String.valueOf(total));
            }
        }
    }

    private void selectServiceUnitComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectServiceUnitComboboxActionPerformed
        if(!invoiceSearch.getText().isEmpty()){
            cartProductList.clear();
            alreadyAddProducts.clear();
            productListPanel.removeAll();

            //productListPanel refresh
            productListPanel.invalidate();
            productListPanel.validate();
            productListPanel.repaint();
            AlreadyProductLoad(invoiceSearch.getText());
        }
    }//GEN-LAST:event_selectServiceUnitComboboxActionPerformed

    private void invoiceSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_invoiceSearchKeyReleased
        // TODO add your handling code here:
        String search = invoiceSearch.getText().trim();
        if (!search.equals("")) {
            ListModel.removeAllElements();
            try {
                Statement statement = DBconnect.connectToDB().createStatement();
                statement.execute("SELECT InvoiceNo FROM VehicleDetails WHERE InvoiceNo LIKE '%" + search + "%' AND States = 'Processing'");
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()) {
                    searchMenu.show(invoiceSearch, 0, invoiceSearch.getHeight());
                    searchMenu.setPopupSize(170, 170);
                    ListModel.addElement(resultSet.getString("InvoiceNo"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Vehicles.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            searchMenu.setVisible(false);
        }
    }//GEN-LAST:event_invoiceSearchKeyReleased

    private void searchProductKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchProductKeyReleased
        // TODO add your handling code here:            
        String search = searchProduct.getText().trim();
        if (!search.equals("")) {
            ListModel.removeAllElements();
            searchMenu.show(searchProduct, 0, searchProduct.getHeight());
            searchMenu.setPopupSize(240, 240);

            try {
                Statement statement = DBconnect.connectToDB().createStatement();
                statement.execute("SELECT ID, Name FROM Products WHERE (ID LIKE '%" + search + "%' OR Name LIKE '%" + search + "%') AND (ServiceUnit = '" + selectServiceUnitCombobox.getSelectedItem() + "' OR ServiceUnit = 'Both')");
                ResultSet resultSet = statement.getResultSet();
                while(resultSet.next()){
                    searchMenu.show(searchProduct, 0, searchProduct.getHeight());
                    ListModel.addElement(resultSet.getString("ID")+"  "+resultSet.getString("Name"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Vehicles.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            searchMenu.setVisible(false);
        }
    }//GEN-LAST:event_searchProductKeyReleased

    private void AlreadyProductLoad(String invoiceID) {
        try {
            Statement statement = DBconnect.connectToDB().createStatement();
            statement.execute("SELECT * FROM SoldProducts WHERE InvoiceID = '" + invoiceID + "' AND ServiceUnit = '" + selectServiceUnitCombobox.getSelectedItem() + "'");
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                ArrayList<String> product = new ArrayList<>();
                product.add(resultSet.getString("ProductID"));
                product.add(resultSet.getString("Name"));
                product.add(resultSet.getString("Price"));
                product.add(resultSet.getString("Qnt"));
                product.add(resultSet.getString("Total"));

                cartProductList.add(product);
                alreadyAddProducts.add(resultSet.getString("ProductID"));
            }
            RefrashProductListPanel();
            statement.execute("SELECT ServiceCharge FROM ServiceCharges WHERE InvoiceID = '" + invoiceID + "' AND ServiceUnit = '" + selectServiceUnitCombobox.getSelectedItem() + "'");
            ResultSet resultSet2 = statement.getResultSet();
            if (resultSet2.next()) {
                serviceChargeTextField.setText(resultSet2.getString("ServiceCharge"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Vehicles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void searchPanelListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchPanelListMouseClicked
        // TODO add your handling code here:
        if (searchMenu.getWidth() == 170) {
            cancelButtonActionPerformed(null);
            invoiceSearch.setText(searchPanelList.getSelectedValue());
            try {
                Statement statement = DBconnect.connectToDB().createStatement();
                statement.execute("SELECT * FROM VehicleDetails WHERE InvoiceNo = '" + searchPanelList.getSelectedValue() + "'");
                ResultSet resultSet = statement.getResultSet();
                if (resultSet.next()) {
                    VehicleRegNo.setText(resultSet.getString("VehicleNo"));
                    ownerName.setText(resultSet.getString("OwnerName"));
                    ownerPhone.setText(resultSet.getString("Phone"));
                    VehicleType.setText(resultSet.getString("VehicleType"));
                    description.setText(resultSet.getString("Description"));
                }
                statement.execute("SELECT ID FROM SoldProducts WHERE InvoiceID = '" + searchPanelList.getSelectedValue() + "'");
                ResultSet resultSet2 = statement.getResultSet();
                if (resultSet2.next()) {
                    AlreadyProductLoad(searchPanelList.getSelectedValue());
                }
            } catch (SQLException ex) {
                Logger.getLogger(Vehicles.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (!VehicleRegNo.getText().isEmpty()) {
                try {
                    Statement statement = DBconnect.connectToDB().createStatement();
                    statement.execute("SELECT * FROM Products WHERE name = '" + searchPanelList.getSelectedValue() + "'");
                    ResultSet resultSet = statement.getResultSet();
                    if (resultSet.next()) {
                        ArrayList<String> product = new ArrayList<>();
                        product.add(resultSet.getString("ID"));
                        product.add(resultSet.getString("Name"));
                        product.add(resultSet.getString("Price"));
                        product.add("1");
                        product.add(resultSet.getString("Price"));

                        if (cartProductList.isEmpty()) {
                            cartProductList.add(product);
                        } else {
                            for (int i = 0; i <= cartProductList.size(); i++) {
                                if (cartProductList.get(i).get(0).equals(resultSet.getString("ID"))) {
                                    cartProductList.get(i).set(3, String.valueOf(Float.parseFloat(cartProductList.get(i).get(3)) + 1));
                                    break;
                                }
                                if (cartProductList.size() - 1 == i) {
                                    cartProductList.add(product);
                                    break;
                                }
                            }
                        }
                        RefrashProductListPanel();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Vehicles.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No invoice number selected !", "Empty", JOptionPane.WARNING_MESSAGE);
            }
        }
        searchMenu.setVisible(false);
        searchProduct.setText("");
    }//GEN-LAST:event_searchPanelListMouseClicked
    
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:                
        invoiceSearch.setText("");
        VehicleRegNo.setText("");
        ownerName.setText("");
        ownerPhone.setText("");
        VehicleType.setText("");
        description.setText("");

        serviceChargeTextField.setText("");
        cartProductList.clear();
        alreadyAddProducts.clear();
        productListPanel.removeAll();

        //productListPanel refresh
        productListPanel.invalidate();
        productListPanel.validate();
        productListPanel.repaint();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void progressButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_progressButton1ActionPerformed
        try {
            Statement statement = DBconnect.connectToDB().createStatement();
            if (alreadyAddProducts.isEmpty()) {
                statement.execute("INSERT INTO ServiceCharges (InvoiceID, ServiceUnit , ServiceCharge) "
                        + "VALUES('" + invoiceSearch.getText() + "', '" + selectServiceUnitCombobox.getSelectedItem() + "', '" + serviceChargeTextField.getText() + "')");
            } else {
                statement.execute("UPDATE ServiceCharges SET ServiceCharge = '" + serviceChargeTextField.getText() + "' WHERE InvoiceID = '" + invoiceSearch.getText() + "' AND ServiceUnit = '" + selectServiceUnitCombobox.getSelectedItem() + "'");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Vehicles.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (int i = 0; i < cartProductList.size(); i++) {
            try {
                Statement statement = DBconnect.connectToDB().createStatement();
                if (!alreadyAddProducts.contains(cartProductList.get(i).get(0))) {
                    statement.execute("INSERT INTO SoldProducts (InvoiceID, ProductID, Name, Price, Qnt, Total, ServiceUnit) "
                            + "VALUES('" + invoiceSearch.getText() + "', '" + cartProductList.get(i).get(0) + "','" + cartProductList.get(i).get(1) + "','" + cartProductList.get(i).get(2) + "','" + cartProductList.get(i).get(3) + "','" + cartProductList.get(i).get(4) + "','" + selectServiceUnitCombobox.getSelectedItem() + "')");
                } else {
                    statement.execute("UPDATE SoldProducts SET Qnt = '" + cartProductList.get(i).get(3) + "', Total = '" + cartProductList.get(i).get(4) + "' WHERE InvoiceID = '" + invoiceSearch.getText() + "' AND ProductID = '" + cartProductList.get(i).get(0) + "' AND ServiceUnit = '" + selectServiceUnitCombobox.getSelectedItem() + "'");
                    alreadyAddProducts.remove(cartProductList.get(i).get(0));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Vehicles.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (!alreadyAddProducts.isEmpty()) {
            try {
                Statement statement = DBconnect.connectToDB().createStatement();
                for (int i = 0; i < alreadyAddProducts.size(); i++) {
                    statement.execute("DELETE FROM SoldProducts WHERE ProductID = '" + alreadyAddProducts.get(i) + "' AND InvoiceID = '" + invoiceSearch.getText() + "' AND ServiceUnit = '" + selectServiceUnitCombobox.getSelectedItem() + "'");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Vehicles.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        cancelButtonActionPerformed(null);
    }//GEN-LAST:event_progressButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private fosalgo.FTextField VehicleRegNo;
    private fosalgo.FTextField VehicleType;
    private button.MyButton cancelButton;
    private javax.swing.JLabel dateLable;
    private CustomComponents.MyTextArea description;
    private fosalgo.FTextField invoiceSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private fosalgo.FTextField ownerName;
    private fosalgo.FTextField ownerPhone;
    private javax.swing.JPanel productListPanel;
    private button.MyButton progressButton1;
    private javax.swing.JPopupMenu searchMenu;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JList<String> searchPanelList;
    private fosalgo.FTextField searchProduct;
    private CustomComponents.Combobox selectServiceUnitCombobox;
    private fosalgo.FTextField serviceChargeTextField;
    private javax.swing.JPanel sidePanel;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JPanel webCamOpenWindow;
    // End of variables declaration//GEN-END:variables
}
