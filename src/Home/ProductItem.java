/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Home;
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
    ArrayList<String> editProduct =  new ArrayList<>();
    
    public ProductItem(Home home, String id, String name, float price, float qnt, float total) {
        initComponents();
        
        proName.setText(name);
        proQnt.setText(String.valueOf(qnt));
        proPrice.setText(String.valueOf(price));
        proTotal.setText(String.valueOf(total));
        
        editProduct.add(id);
        editProduct.add(name);
        editProduct.add(String.valueOf(price));
        editProduct.add(String.valueOf(qnt));
        editProduct.add(String.valueOf(total));
        
        removeButton.addMouseListener(new MouseAdapter() { 
            
            public void mousePressed(MouseEvent e) { 
                home.RemoveProduct(id, String.valueOf(price));
            } 
        }); 
        
        proQnt.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                
                if(!proQnt.getText().isEmpty() == !proQnt.getText().equals("-")){
                    if(Float.parseFloat(proQnt.getText()) < 0){
                        proQnt.setText("1");
                    }
                    float total = Float.parseFloat(proQnt.getText()) * price;
                    proTotal.setText(String.valueOf(total));
                    editProduct.set(3, proQnt.getText());
                    editProduct.set(4, proTotal.getText());
                    home.UpdateProduct(editProduct);
                }else{
                    float total = 1 * price;
                    proTotal.setText(String.valueOf(total));
                    editProduct.set(3, "1");
                    editProduct.set(4, proTotal.getText());
                    home.UpdateProduct(editProduct);
                }
           }
        });
        
        qntIncreaseButton.addMouseListener(new MouseAdapter() { 
            public void mousePressed(MouseEvent e) { 
             proQnt.setText(String.valueOf(Float.parseFloat(proQnt.getText())+1));
             float total = Float.parseFloat(proQnt.getText()) * price;
             proTotal.setText(String.valueOf(total));
             editProduct.set(3, proQnt.getText());
             editProduct.set(4, proTotal.getText());
             home.UpdateProduct(editProduct);
            } 
        });
        
        qntReduceButton.addMouseListener(new MouseAdapter() { 
            public void mousePressed(MouseEvent e) { 
             if(Float.parseFloat(proQnt.getText())-1 > 0){
                proQnt.setText(String.valueOf(Float.parseFloat(proQnt.getText())-1));
                float total = Float.parseFloat(proQnt.getText()) * price;
                proTotal.setText(String.valueOf(total));
                editProduct.set(3, proQnt.getText());
                editProduct.set(4, proTotal.getText());
                home.UpdateProduct(editProduct);
             }
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

        proName = new javax.swing.JLabel();
        removeButton = new button.MyButton();
        proQnt = new fosalgo.FTextField();
        proTotal = new javax.swing.JLabel();
        proPrice = new javax.swing.JLabel();
        qntReduceButton = new button.MyButton();
        qntIncreaseButton = new button.MyButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 15, 1, 1));

        proName.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        proName.setText("Name");

        removeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/cross.png"))); // NOI18N
        removeButton.setBorderColor(new java.awt.Color(255, 255, 255));
        removeButton.setBorderPainted(false);
        removeButton.setColorClick(new java.awt.Color(204, 204, 204));
        removeButton.setColorOver(new java.awt.Color(204, 204, 204));
        removeButton.setFocusable(false);
        removeButton.setRadius(50);

        proQnt.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        proQnt.setFocusTraversalPolicyProvider(true);
        proQnt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        proQnt.setRadius(10);

        proTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        proTotal.setText("0.00");

        proPrice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        proPrice.setText("x  0.00");

        qntReduceButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/minus-small.png"))); // NOI18N
        qntReduceButton.setBorderColor(new java.awt.Color(13, 180, 185));
        qntReduceButton.setColorClick(new java.awt.Color(204, 204, 204));
        qntReduceButton.setColorOver(new java.awt.Color(204, 204, 204));
        qntReduceButton.setRadius(10);

        qntIncreaseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/plus-small.png"))); // NOI18N
        qntIncreaseButton.setBorderColor(new java.awt.Color(13, 180, 185));
        qntIncreaseButton.setColorClick(new java.awt.Color(204, 204, 204));
        qntIncreaseButton.setColorOver(new java.awt.Color(204, 204, 204));
        qntIncreaseButton.setRadius(10);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(qntReduceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(proQnt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(qntIncreaseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(proPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(proTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(proName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(proName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(proQnt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(proTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(proPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(qntReduceButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(qntIncreaseButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(5, 5, 5))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(removeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel proName;
    private javax.swing.JLabel proPrice;
    private fosalgo.FTextField proQnt;
    private javax.swing.JLabel proTotal;
    private button.MyButton qntIncreaseButton;
    private button.MyButton qntReduceButton;
    private button.MyButton removeButton;
    // End of variables declaration//GEN-END:variables
}
