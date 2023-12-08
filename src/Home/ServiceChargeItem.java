/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Home;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Umindu
 */
public class ServiceChargeItem extends javax.swing.JPanel {

    /**
     * Creates new form ProductItem
     */
  
    public ServiceChargeItem(Home home, String name, String charge) {
        initComponents();
        serName.setText(name);
        serCharge.setText(charge);
        
        removeButton.addMouseListener(new MouseAdapter() { 
            public void mousePressed(MouseEvent e) { 
                home.RemoveService(name);
            } 
        }); 
        
        serCharge.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                home.UpdateService(name,serCharge.getText());
           }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        serName = new javax.swing.JLabel();
        removeButton = new button.MyButton();
        serCharge = new fosalgo.FTextField();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        serName.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        serName.setText("Name");

        removeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/cross.png"))); // NOI18N
        removeButton.setBorderColor(new java.awt.Color(255, 255, 255));
        removeButton.setBorderPainted(false);
        removeButton.setColorClick(new java.awt.Color(204, 204, 204));
        removeButton.setColorOver(new java.awt.Color(204, 204, 204));
        removeButton.setFocusable(false);
        removeButton.setRadius(50);

        serCharge.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        serCharge.setFocusTraversalPolicyProvider(true);
        serCharge.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        serCharge.setRadius(10);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Service charge (Rs.) :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(serName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(9, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(serCharge, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(removeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(serName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serCharge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private button.MyButton removeButton;
    private fosalgo.FTextField serCharge;
    private javax.swing.JLabel serName;
    // End of variables declaration//GEN-END:variables
}
