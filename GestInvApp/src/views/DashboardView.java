
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
import views.ProductsView;
import controllers.CurrentSesionController;
import javax.swing.JFrame;
import controllers.ProductsController;
import javax.swing.JOptionPane;



public class DashboardView extends javax.swing.JFrame {

    /**
     * Creates new form DashboardView
     */
    private Date date = Calendar.getInstance().getTime();
    private DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
    private String fechaActual = dateFormat.format(date);
    private CHAFDependenciesViews dp = new CHAFDependenciesViews();
    private String mensajeModulos = "Los desarrolladores de CHAF estamos construyendo este modulo, gracias por comprender";            
    private int userIdLogged; //id del usuario logueado, se lo pasamos a otros modulos

    public DashboardView() {

        initComponents();

    }
    
    public void setCurrentUser(String user){
        this.sesionActual.setText(user);
    }

    public void setRol(String rol){
        this.rolSesionActual.setText(rol);
    }
    public void setUserIdLogged(int id){
        this.userIdLogged = id;
    }

    public int getUserIdLogged(){
      return this.userIdLogged;
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
        BtnProduct = new libraries.MaterialButton();
        materialButton4 = new libraries.MaterialButton();
        materialButton5 = new libraries.MaterialButton();
        materialButton6 = new libraries.MaterialButton();
        materialButton7 = new libraries.MaterialButton();
        materialButton8 = new libraries.MaterialButton();
        sesionActual = new javax.swing.JLabel();
        rolSesionActual = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(96, 440));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        materialButton1.setBackground(new java.awt.Color(102, 153, 255));
        materialButton1.setText("VENTAS");
        materialButton1.setPreferredSize(new java.awt.Dimension(96, 25));
        materialButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materialButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(materialButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 259, 50));

        materialButton2.setBackground(new java.awt.Color(102, 153, 255));
        materialButton2.setText("COTIZACIONES");
        materialButton2.setPreferredSize(new java.awt.Dimension(96, 25));
        materialButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materialButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(materialButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 259, 50));

        BtnProduct.setBackground(new java.awt.Color(102, 153, 255));
        BtnProduct.setText("PRODUCTOS");
        BtnProduct.setPreferredSize(new java.awt.Dimension(96, 25));
        BtnProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnProductActionPerformed(evt);
            }
        });
        jPanel1.add(BtnProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 259, 50));

        materialButton4.setBackground(new java.awt.Color(102, 153, 255));
        materialButton4.setText("PROVEEDORES");
        materialButton4.setMaximumSize(new java.awt.Dimension(96, 25));
        materialButton4.setMinimumSize(new java.awt.Dimension(96, 25));
        materialButton4.setPreferredSize(new java.awt.Dimension(96, 25));
        materialButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materialButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(materialButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, 259, 51));

        materialButton5.setBackground(new java.awt.Color(102, 153, 255));
        materialButton5.setText("CLIENTES");
        materialButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materialButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(materialButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, 259, 57));

        materialButton6.setBackground(new java.awt.Color(102, 153, 255));
        materialButton6.setText("USUARIOS");
        materialButton6.setPreferredSize(new java.awt.Dimension(96, 25));
        materialButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materialButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(materialButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, 259, 54));

        materialButton7.setBackground(new java.awt.Color(102, 153, 255));
        materialButton7.setText("REPORTE");
        materialButton7.setMaximumSize(new java.awt.Dimension(96, 25));
        materialButton7.setMinimumSize(new java.awt.Dimension(96, 25));
        materialButton7.setPreferredSize(new java.awt.Dimension(96, 25));
        materialButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materialButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(materialButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 360, 259, 50));

        materialButton8.setBackground(new java.awt.Color(102, 153, 255));
        materialButton8.setText("Salir");
        materialButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materialButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(materialButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(548, 11, 85, 46));

        sesionActual.setFont(new java.awt.Font("Roboto Condensed", 0, 14)); // NOI18N
        sesionActual.setText("Fecha: " + fechaActual);
        jPanel1.add(sesionActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 20));

        rolSesionActual.setFont(new java.awt.Font("Roboto Condensed", 0, 14)); // NOI18N
        rolSesionActual.setText("aqui va el rol");
        jPanel1.add(rolSesionActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/chaf.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, -1, -1));

        jLabel3.setFont(new java.awt.Font("Roboto Condensed", 0, 14)); // NOI18N
        jLabel3.setText("Fecha: " + fechaActual);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseClicked

    private void materialButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materialButton8ActionPerformed
        // TODO add your handling code here:
           this.dispose();
           Login login = new Login();
           login.setVisible(true);  
           login.setLayout(null);
           login.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
    }//GEN-LAST:event_materialButton8ActionPerformed

    private void materialButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materialButton7ActionPerformed
        // TODO add your handling code here:
       JOptionPane.showMessageDialog(
                        this,
                        this.mensajeModulos,
                        "Advertencia", JOptionPane.INFORMATION_MESSAGE,
                        dp.getChafLogo());
    }//GEN-LAST:event_materialButton7ActionPerformed

    private void materialButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materialButton6ActionPerformed
        // TODO add your handling code here:
        System.out.println("[DashboardView]: entrando a modulo de Usuarios");
        UserView userView = new UserView();
        userView.setUserIdLogged(this.userIdLogged);
        userView.setInfoUser();
        userView.setVisible(true);
        userView.setLayout(null);
        userView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_materialButton6ActionPerformed

    private void materialButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materialButton5ActionPerformed
        // TODO add your handling code here:
        System.out.println("[DashboardView]: entrando a modulo de Clientes");
        CustomersView customersView = new CustomersView();
        customersView.setUserIdLogged(this.userIdLogged);
        customersView.setInfoUser();
        customersView.setVisible(true);
        customersView.setLayout(null);
        customersView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_materialButton5ActionPerformed

    private void materialButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materialButton4ActionPerformed
        // TODO add your handling code here:
        System.out.println("[DashboardView]: entrando a modulo de Proveedores");
        ProvidersView  providerView = new ProvidersView();
        providerView.setUserIdLogged(this.userIdLogged);
        providerView.setInfoUser();
        providerView.setVisible(true);
        providerView.setLayout(null);
        providerView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_materialButton4ActionPerformed

    private void BtnProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnProductActionPerformed
        // TODO add your handling code here:
        ProductsController controlProducts = new ProductsController();
        controlProducts.setUserIdLogged(this.userIdLogged);
        controlProducts.showView();
    }//GEN-LAST:event_BtnProductActionPerformed

    private void materialButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materialButton2ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(
                        this,
                        this.mensajeModulos,
                        "Advertencia", JOptionPane.INFORMATION_MESSAGE,
                        dp.getChafLogo());
    }//GEN-LAST:event_materialButton2ActionPerformed

    private void materialButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materialButton1ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(
                        this,
                        this.mensajeModulos,
                        "Advertencia", JOptionPane.INFORMATION_MESSAGE,
                        dp.getChafLogo());
    }//GEN-LAST:event_materialButton1ActionPerformed

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
    private libraries.MaterialButton BtnProduct;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private libraries.MaterialButton materialButton1;
    private libraries.MaterialButton materialButton2;
    private libraries.MaterialButton materialButton4;
    private libraries.MaterialButton materialButton5;
    private libraries.MaterialButton materialButton6;
    private libraries.MaterialButton materialButton7;
    private libraries.MaterialButton materialButton8;
    private javax.swing.JLabel rolSesionActual;
    private javax.swing.JLabel sesionActual;
    // End of variables declaration//GEN-END:variables
}
