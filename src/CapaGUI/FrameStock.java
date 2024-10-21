/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package CapaGUI;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lab305
 */
public class FrameStock extends javax.swing.JFrame {

    /**
     * Creates new form FrameStock
     */
    public FrameStock() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ProductID = new javax.swing.JTextField();
        ProductName = new javax.swing.JTextField();
        Quantity = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jButtonVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("producto ID");

        jLabel2.setText("nombre");

        jLabel3.setText("cantidad");

        ProductID.setText("IDT");
        ProductID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductIDActionPerformed(evt);
            }
        });

        ProductName.setText("NOMBRET");
        ProductName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductNameActionPerformed(evt);
            }
        });

        Quantity.setText("CANTIDADT");

        jButton1.setText("añadir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("actualizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "NOMBRE", "CANTIDAD"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel4.setText("control stock");

        jButtonVolver.setText("Volver");
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(35, 35, 35)
                                    .addComponent(Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButton1)
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButtonVolver)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jButton2)
                                            .addGap(18, 18, 18)
                                            .addComponent(jButton3)))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ProductID, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(62, 62, 62)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ProductID, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(36, 36, 36)
                .addComponent(jButtonVolver)
                .addContainerGap(92, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         // Obtiene la fila seleccionada
    int selectedRow = jTable1.getSelectedRow();
    
    if (selectedRow >= 0) {
        // Obtiene los valores actualizados de los campos de texto
        String id = ProductID.getText();
        String name = ProductName.getText();
        String quantity = Quantity.getText();
        
        // Actualiza la fila seleccionada con los nuevos valores
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setValueAt(id, selectedRow, 0);
        model.setValueAt(name, selectedRow, 1);
        model.setValueAt(quantity, selectedRow, 2);
        
        // Limpia los campos de texto
        ProductID.setText("");
        ProductName.setText("");
        Quantity.setText("");
    } else {
        // Si no hay fila seleccionada, muestra un mensaje de error
        javax.swing.JOptionPane.showMessageDialog(this, "Selecciona un producto para actualizar.");
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
            // Obtiene la fila seleccionada
    int selectedRow = jTable1.getSelectedRow();
    
    if (selectedRow >= 0) {
        // Elimina la fila seleccionada de la tabla
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.removeRow(selectedRow);
        
        // Limpia los campos de texto
        ProductID.setText("");
        ProductName.setText("");
        Quantity.setText("");
    } else {
        // Si no hay fila seleccionada, muestra un mensaje de error
        javax.swing.JOptionPane.showMessageDialog(this, "Selecciona un producto para eliminar.");
    }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void ProductIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProductIDActionPerformed

    private void ProductNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProductNameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
            // Obtiene los valores de los campos de texto
    String id = ProductID.getText();
    String name = ProductName.getText();
    String quantity = Quantity.getText();
    
    // Agrega los datos a la tabla
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.addRow(new Object[]{id, name, quantity});
    
    // Limpia los campos de texto para nuevas entradas
    ProductID.setText("");
    ProductName.setText("");
    Quantity.setText("");

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here
                int selectedRow = jTable1.getSelectedRow();
        
        // Pone los valores de la fila seleccionada en los campos de texto
        ProductID.setText(jTable1.getValueAt(selectedRow, 0).toString());
        ProductName.setText(jTable1.getValueAt(selectedRow, 1).toString());
        Quantity.setText(jTable1.getValueAt(selectedRow, 2).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed
        // TODO add your handling code here:
        new FramePrincipal().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonVolverActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ProductID;
    private javax.swing.JTextField ProductName;
    private javax.swing.JTextField Quantity;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
