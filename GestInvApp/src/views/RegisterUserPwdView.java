/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import libraries.TextPrompt;

/**
 *
 * @author Carlos Andres Cordoba
 */
public class RegisterUserPwdView extends javax.swing.JFrame {

    private TextPrompt usuarioPH,passwordPH,repitaPasswordPH;
    private String user;
    private char[] pwd;
    private TercerosRegisterView mainClass;
    /**
     * Creates new form RegisterUserPwdView
     */
    public RegisterUserPwdView(TercerosRegisterView padre) {
        mainClass = padre;
        initComponents();
    }

    public String getUser() {
        return user;
    }

    public char[] getPwd() {
        return pwd;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        numDoc = new views.Input();
        inputPassword = new javax.swing.JPasswordField();
        materialButton1 = new libraries.MaterialButton();
        materialButton2 = new libraries.MaterialButton();
        numDoc2 = new views.Input();
        inputUser = new javax.swing.JTextField();
        numDoc4 = new views.Input();
        inputPassword1 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        inputPassword.setToolTipText("");
        inputPassword.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout numDocLayout = new javax.swing.GroupLayout(numDoc);
        numDoc.setLayout(numDocLayout);
        numDocLayout.setHorizontalGroup(
            numDocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(numDocLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                .addContainerGap())
        );
        numDocLayout.setVerticalGroup(
            numDocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(numDocLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        materialButton1.setBackground(new java.awt.Color(119, 177, 236));
        materialButton1.setText("SALIR");
        materialButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                materialButton1MouseClicked(evt);
            }
        });
        materialButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materialButton1ActionPerformed(evt);
            }
        });

        materialButton2.setBackground(new java.awt.Color(119, 177, 236));
        materialButton2.setText("CREAR");
        materialButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                materialButton2MouseClicked(evt);
            }
        });
        materialButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materialButton2ActionPerformed(evt);
            }
        });

        inputUser.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        inputUser.setForeground(new java.awt.Color(134, 134, 134));
        inputUser.setToolTipText("");
        this.usuarioPH = new TextPrompt("Nombre de usuario",this.inputUser);
        inputUser.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        inputUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout numDoc2Layout = new javax.swing.GroupLayout(numDoc2);
        numDoc2.setLayout(numDoc2Layout);
        numDoc2Layout.setHorizontalGroup(
            numDoc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(numDoc2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputUser, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                .addContainerGap())
        );
        numDoc2Layout.setVerticalGroup(
            numDoc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(numDoc2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputUser)
                .addContainerGap())
        );

        inputPassword1.setToolTipText("");
        inputPassword1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout numDoc4Layout = new javax.swing.GroupLayout(numDoc4);
        numDoc4.setLayout(numDoc4Layout);
        numDoc4Layout.setHorizontalGroup(
            numDoc4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(numDoc4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputPassword1, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                .addContainerGap())
        );
        numDoc4Layout.setVerticalGroup(
            numDoc4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(numDoc4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/chaf.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(numDoc2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numDoc4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(materialButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(materialButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jLabel1)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(numDoc2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numDoc4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(materialButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(materialButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void materialButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_materialButton1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_materialButton1MouseClicked

    private void materialButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materialButton1ActionPerformed
        // TODO add your handling code here:
//        System.out.println("[RegisterUserPwdView]: Creando Usuario");
//        UserController creacionTercero = new UserController();
//        creacionTercero.insertUser((String) this.jComboBox1.getSelectedItem(),Integer.parseInt(this.inputPwd.getText()), this.inputUserDir.getText(), this.inputUserNomUser.getText(), this.inputUserTel.getText());
//        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_materialButton1ActionPerformed

    private void materialButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_materialButton2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_materialButton2MouseClicked

    private void materialButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materialButton2ActionPerformed
        // TODO add your handling code here:
        if(!(this.inputPassword.getPassword().length == 0) && !(this.inputPassword1.getPassword().length == 0) && (this.inputUser.getText() != null)){
            this.user = this.inputUser.getText();
            this.pwd = this.inputPassword1.getPassword();
             System.out.println("Se insertaron los siguientes datos: " +mainClass.getTipoDocUser()+"::"+mainClass.getNumeroIdentificacion()+"::"+mainClass.getUserDir()+"::"+mainClass.getNombreUser()+
                    "::"+ mainClass.getTelUser()+"::"+ this.user+"::"+String.valueOf(pwd));
            this.mainClass.getUserController().insertUser(mainClass.getTipoDocUser(),
                                                          mainClass.getNumeroIdentificacion(),
                                                          mainClass.getUserDir(),
                                                          mainClass.getNombreUser(),
                                                          mainClass.getTelUser(), 
                                                          this.user,
                                                          String.valueOf(pwd));
            
            System.out.println(mainClass.getTipoDocUser()+"::"+mainClass.getNumeroIdentificacion()+"::"+mainClass.getUserDir()+"::"+mainClass.getNombreUser()+
                    "::"+ mainClass.getTelUser()+"::"+ this.user+"::"+String.valueOf(pwd));
            JOptionPane.showMessageDialog(this,"Usuario creado");
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }else {
            JOptionPane.showMessageDialog(this, "Llene todos los datos por favor");
        }
        
        // compara las contraseñas:: !(Arrays.equals(createPassword.getPassword(), confirmPassword.getPassword()))
    }//GEN-LAST:event_materialButton2ActionPerformed

    private void inputUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputUserActionPerformed

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
            java.util.logging.Logger.getLogger(RegisterUserPwdView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterUserPwdView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterUserPwdView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterUserPwdView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new RegisterUserPwdView().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField inputPassword;
    private javax.swing.JPasswordField inputPassword1;
    private javax.swing.JTextField inputUser;
    private javax.swing.JLabel jLabel1;
    private libraries.MaterialButton materialButton1;
    private libraries.MaterialButton materialButton2;
    private views.Input numDoc;
    private views.Input numDoc1;
    private views.Input numDoc2;
    private views.Input numDoc3;
    private views.Input numDoc4;
    // End of variables declaration//GEN-END:variables
}
