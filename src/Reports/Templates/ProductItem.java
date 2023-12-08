/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Reports.Templates;
import Reports.CancelService;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 *
 * @author Umindu
 */
public class ProductItem extends javax.swing.JPanel {

    /**
     * Creates new form ProductItem
     */
    
    ArrayList<String> editProduct =  new ArrayList<String>();
  
    public ProductItem(String id, String name, float price, float qnt, float total) {
        initComponents();
        
        proName.setText(name);
        proQnt.setText(String.valueOf(qnt));
        proPrice.setText(String.valueOf("x  "+price));
        proTotal.setText(String.valueOf(total));
        
        editProduct.add(id);
        editProduct.add(name);
        editProduct.add(String.valueOf(price));
        editProduct.add(String.valueOf(qnt));
        editProduct.add(String.valueOf(total));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        proName = new javax.swing.JLabel();
        proQnt = new fosalgo.FTextField();
        proTotal = new javax.swing.JLabel();
        proPrice = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        proName.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        proName.setText("Name");

        proQnt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        proQnt.setFocusTraversalPolicyProvider(true);
        proQnt.setFocusable(false);
        proQnt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        proQnt.setRadius(10);

        proTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        proTotal.setText("0.00");

        proPrice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        proPrice.setText("x  0.00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(proQnt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addComponent(proPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(proTotal))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(proName)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(proName, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(proQnt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(proTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(proPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel proName;
    private javax.swing.JLabel proPrice;
    private fosalgo.FTextField proQnt;
    private javax.swing.JLabel proTotal;
    // End of variables declaration//GEN-END:variables
}
