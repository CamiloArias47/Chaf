/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

/**
 *
 * @author Carlos Andres Cordoba Ramos
 */
import controllers.DashboardController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class DashboardView extends javax.swing.JFrame {
    
    /**
     * Creates new form DashboardView
     */
    private Date date = Calendar.getInstance().getTime();  
    private DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");  
    private String fechaActual = dateFormat.format(date);  
    
    public DashboardView() {
        
        initComponents();
              
    }
    
    
    
    public void setCurrentUser(String user){
        this.sesionActual.setText(user);
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
        materialButton1 = new libraries.MaterialButton();
        materialButton2 = new libraries.MaterialButton();
        materialButton3 = new libraries.MaterialButton();
        materialButton4 = new libraries.MaterialButton();
        materialButton5 = new libraries.MaterialButton();
        materialButton6 = new libraries.MaterialButton();
        materialButton7 = new libraries.MaterialButton();
        materialButton8 = new libraries.MaterialButton();
        sesionActual = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        materialButton1.setBackground(new java.awt.Color(102, 153, 255));
        materialButton1.setText("VENTAS");
        materialButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materialButton1ActionPerformed(evt);
            }
        });

        materialButton2.setBackground(new java.awt.Color(102, 153, 255));
        materialButton2.setText("COTIZACIONES");
        materialButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materialButton2ActionPerformed(evt);
            }
        });

        materialButton3.setBackground(new java.awt.Color(102, 153, 255));
        materialButton3.setText("PRODUCTOS");
        materialButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materialButton3ActionPerformed(evt);
            }
        });

        materialButton4.setBackground(new java.awt.Color(102, 153, 255));
        materialButton4.setText("PROVEEDORES");
        materialButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materialButton4ActionPerformed(evt);
            }
        });

        materialButton5.setBackground(new java.awt.Color(102, 153, 255));
        materialButton5.setText("CLIENTES");
        materialButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materialButton5ActionPerformed(evt);
            }
        });

        materialButton6.setBackground(new java.awt.Color(102, 153, 255));
        materialButton6.setText("USUARIOS");
        materialButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materialButton6ActionPerformed(evt);
            }
        });

        materialButton7.setBackground(new java.awt.Color(102, 153, 255));
        materialButton7.setText("REPORTE");
        materialButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materialButton7ActionPerformed(evt);
            }
        });

        materialButton8.setBackground(new java.awt.Color(102, 153, 255));
        materialButton8.setText("Salir");
        materialButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materialButton8ActionPerformed(evt);
            }
        });

        sesionActual.setFont(new java.awt.Font("Roboto Condensed", 0, 14)); // NOI18N
        sesionActual.setText("jlabel1");

        jLabel2.setFont(new java.awt.Font("Roboto Condensed", 0, 14)); // NOI18N
        jLabel2.setText("Fecha: " + fechaActual);

        jLabel3.setFont(new java.awt.Font("Roboto Condensed", 0, 14)); // NOI18N
        jLabel3.setText("jLabel3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(materialButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(sesionActual)
                            .addComponent(jLabel3))
                        .addGap(135, 135, 135)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(materialButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(materialButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(materialButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(materialButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(materialButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(materialButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(materialButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 181, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(materialButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sesionActual)))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(materialButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(materialButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(materialButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(materialButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(materialButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(materialButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(materialButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(97, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void materialButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materialButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_materialButton1ActionPerformed

    private void materialButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materialButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_materialButton2ActionPerformed

    private void materialButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materialButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_materialButton3ActionPerformed

    private void materialButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materialButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_materialButton4ActionPerformed

    private void materialButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materialButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_materialButton5ActionPerformed

    private void materialButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materialButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_materialButton6ActionPerformed

    private void materialButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materialButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_materialButton7ActionPerformed

    private void materialButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materialButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_materialButton8ActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseClicked

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
            java.util.logging.Logger.getLogger(DashboardView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private libraries.MaterialButton materialButton1;
    private libraries.MaterialButton materialButton2;
    private libraries.MaterialButton materialButton3;
    private libraries.MaterialButton materialButton4;
    private libraries.MaterialButton materialButton5;
    private libraries.MaterialButton materialButton6;
    private libraries.MaterialButton materialButton7;
    private libraries.MaterialButton materialButton8;
    private javax.swing.JLabel sesionActual;
    // End of variables declaration//GEN-END:variables
}
