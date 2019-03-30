/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.ProveedorModel;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import views.ProductsView;
import views.ProductsRegisterView;
import models.ProductModel;

/**
 *
 * @author camilo
 */
public class ProductsController {

  private int userIdLogged; //id del usuario logueado
  private ProductModel product;
  private JLabel editar,eliminar,activar;
  private ImageIcon editarIcon,eliminarIcon,activarIcon;
  private Icon edImg,elimImg,actImg;
  private JLabel[] opciones = new JLabel[3];

  public ProductsController(){
     product = new ProductModel();
  }

  public void setUserIdLogged(int id){
    this.userIdLogged = id;
  }

  /*
  *Muestra el modulo de productos
  **/
  public void showView(){
    System.out.println("[DashboardView]: productos cliked");
    ProductsView productView = new ProductsView();
    productView.setUserIdLogged(this.userIdLogged);
    productView.setInfoUser();
    productView.setVisible(true);
    productView.setLayout(null);
    this.setButons(); //establecemos los botones de la tabla
    productView.setProductsTable(this.getModelProducts());
    productView.renderTable(); //renderiza los botones en las columnas
    productView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  }

  /*
  *Muestra el formulario de registro
  **/
  public void showFormRegister(){
    ProductsRegisterView formRegister = new ProductsRegisterView();
    formRegister.setInfoUser();
    formRegister.setComboBoxProveedores(this.getComboBoxProveedores());
    formRegister.setVisible(true);
    formRegister.setLayout(null);
    formRegister.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  }


  /*
  * obtiene un ArrayList con los proveedores y los convierte en un modelo para mostrar en el combobox
  **/
  public DefaultComboBoxModel getComboBoxProveedores(){
    DefaultComboBoxModel model = new DefaultComboBoxModel();
    ProveedorModel proveedor = new ProveedorModel();
    ArrayList<ArrayList> proveedores = proveedor.getProveedores();
    for (int i = 0;i < proveedores.size() ;i++ ) {
        model.addElement(proveedores.get(i).get(4));
    }
    return model;
  }

  private void setButons(){
    editar = new JLabel();
    editarIcon = new ImageIcon(getClass().getResource("/img/editar.png"));
    edImg = new ImageIcon(editarIcon.getImage().getScaledInstance(20, 20, 0));
    editar.setIcon(edImg);

    eliminar = new JLabel();
    eliminarIcon = new ImageIcon(getClass().getResource("/img/desactivar.png"));
    elimImg = new ImageIcon(eliminarIcon.getImage().getScaledInstance(20, 20, 0));
    eliminar.setIcon(elimImg);

    activar = new JLabel();
    activarIcon = new ImageIcon(getClass().getResource("/img/activar.png"));
    actImg = new ImageIcon(activarIcon.getImage().getScaledInstance(20, 20, 0));
    activar.setIcon(actImg);

    opciones[0]= editar;
    opciones[1]= eliminar;
    opciones[2]= activar;
  }


  /*
  *
  **/
  public DefaultTableModel getModelProducts(){
    ArrayList<ArrayList> productos = product.getProducts();
    Object tabla[][] = new Object[productos.size()][7];
    int j = 0;
    for (int i = 0; i < productos.size() ; i++ ) {
      tabla[j][0] = productos.get(i).get(0).toString();
      tabla[j][1] = productos.get(i).get(1).toString();
      tabla[j][2] = productos.get(i).get(2).toString();
      tabla[j][3] = productos.get(i).get(3).toString();
      tabla[j][4] = this.opciones[0];
      tabla[j][5] = this.opciones[1];
      tabla[j][6] = this.opciones[2];
      j++;
    }

    DefaultTableModel model = new DefaultTableModel(
      tabla,
      new String[]{
        "Id","Nombre","Precio Compra","Precio Venta","Editar","Desactivar","Activar"
      }
    ){
          Class[] types = new Class [] {
              java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
          };
          boolean[] canEdit = new boolean [] {
              false, false, false, false, false, false, false
          };

          public Class getColumnClass(int columnIndex) {
              return types [columnIndex];
          }

          public boolean isCellEditable(int rowIndex, int columnIndex) {
              return canEdit [columnIndex];
          }
      };

    return model;
  }

  /*
  *valida wue los campos del registro e producto esten completos
  **/
  public boolean validate(String code, String brand, String name, String priceBuy, String priceSell, String amoung, String provider){
    if(code.equals("") || brand.equals("") || name.equals("") || priceBuy.equals("") || priceSell.equals("") || amoung.equals("") ){
      return false;
    }

    return true;
  }


  //::::::::::::::::::::::::::::::::::::::::::::::::::CRUD:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

  /*
  *guarda un producto nuevo
  **/
  public ArrayList<String> save(String code, String brand, String name, String priceBuy, String priceSell, String amoung, String provider){
    ArrayList<String> result = new ArrayList<String>();
    String saved = "false";

    if(!validate(code,brand,name,priceBuy,priceSell,amoung,provider)){
      result.add(saved);
      result.add("Completa los campos");
    }

    return result;
  }

}