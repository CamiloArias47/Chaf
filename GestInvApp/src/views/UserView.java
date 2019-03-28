/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.CurrentSesionController;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ContainerEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Carlos Andres
 */
public class UserView extends javax.swing.JFrame {
    /* botones */
    private JButton editar,eliminar,activar;
    private ImageIcon editarIcon,eliminarIcon,activarIcon;
    private Icon edImg,elimImg,actImg;
    /* array de jlabel donde se alojaran las opciones del modulo*/
//    private JButton[] opciones = new JButton[3];
    /* tamaño de las columnas de editar y activar*/
    private int sizeColumn = 40;
    /*renderizador encargado de "convertir" los datos del jlabel para que se vean las imgns en el jtable  */
    private LabelRenderer renderizador = new LabelRenderer();
    private UserRegisterView form;
    private int userIdLogged; //id del usuario logueado
    private Object[][] rows;
    
     /**
     * Creates new form UsuariosView
     */
    public UserView() {
        
        /**
         Creacion de boton editar
         */
        editar          = new JButton(); 
        editar.setBackground(Color.white);
        editarIcon      = new ImageIcon(getClass().getResource("/img/editar.png"));
        edImg           = new ImageIcon(editarIcon.getImage().getScaledInstance(20, 20, 0));
        editar.setIcon(edImg);
        
        /**
         Creacion de boton eliminar
         */             
        
        eliminar        = new JButton();
        eliminar.setBackground(Color.white);
        eliminarIcon    = new ImageIcon(getClass().getResource("/img/desactivar.png"));
        elimImg         = new ImageIcon(eliminarIcon.getImage().getScaledInstance(20, 20, 0));
        eliminar.setIcon(elimImg);
        
        /**
         Creacion de boton activar
         */
        
        activar         = new JButton();
        activar.setBackground(Color.white);
        activarIcon     = new ImageIcon(getClass().getResource("/img/activar.png"));
        actImg          = new ImageIcon(activarIcon.getImage().getScaledInstance(20, 20, 0));
        activar.setIcon(actImg);

        this.setResizable(false);
        initComponents();
        
    }
    
    public void setUserIdLogged(int id){
      this.userIdLogged = id;
    }
    
    public void setInfoUser(){
      CurrentSesionController sesion = new CurrentSesionController(this.userIdLogged);
      this.nameUser.setText(sesion.getName());
      this.rolUser.setText(sesion.getRol());
    }
    
    public Object[][] initRows(int filas){
     this.rows = new Object[filas][5];
     for(int i = 0;i < filas;i++){
         for(int j = 1;j< 5 ;j++){
            switch(j){
                    case 2: rows[i][j] = this.editar;
                    break;
                    case 3: rows[i][j] = this.eliminar;
                    break;
                    case 4: rows[i][j] = this.activar;
                    break;
                    default: rows[i][j] = null;
            }
         }
     }
     return rows;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        materialButton1 = new libraries.MaterialButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        nameUser = new javax.swing.JLabel();
        rolUser = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        materialButton1.setBackground(new java.awt.Color(119, 177, 236));
        materialButton1.setText("Registrar Usuario");
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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            initRows(200)
            ,
            new String [] {
                "Usuario", "Nombre", "Editar","Desactivar","Activar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false,false,false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }

        });
        this.jTable1.getColumn("Editar").setCellRenderer(renderizador);
        this.jTable1.getColumn("Editar").setMaxWidth(sizeColumn);
        this.jTable1.getColumn("Desactivar").setCellRenderer(renderizador);
        this.jTable1.getColumn("Desactivar").setMaxWidth(sizeColumn + 20);
        this.jTable1.getColumn("Activar").setCellRenderer(renderizador);
        this.jTable1.getColumn("Activar").setMaxWidth(sizeColumn);
        this.jTable1.setRowHeight(30);
        jScrollPane1.setViewportView(jTable1);

        nameUser.setText("jLabel1");

        rolUser.setText("jLabel2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(materialButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rolUser)
                            .addComponent(nameUser))))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(nameUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rolUser)
                .addGap(18, 18, 18)
                .addComponent(materialButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void materialButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materialButton1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_materialButton1ActionPerformed

    private void materialButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_materialButton1MouseClicked
        // TODO add your handling code here:
 
    }//GEN-LAST:event_materialButton1MouseClicked

    public class LabelRenderer extends DefaultTableCellRenderer implements TableCellRenderer{
     public Component getTableCellRendererComponent(JTable table,Object value, boolean isSelected, boolean hasFocus,int row,int column){
      return (Component)value;   
     }
     
     
 }
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
            java.util.logging.Logger.getLogger(UserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private libraries.MaterialButton materialButton1;
    private javax.swing.JLabel nameUser;
    private javax.swing.JLabel rolUser;
    // End of variables declaration//GEN-END:variables
}