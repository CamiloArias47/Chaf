/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.ProveedorModel;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author camilo
 */
public class ProductsController {

  public ProductsController(){

  }

  public DefaultComboBoxModel getComboBoxProveedores(){
    DefaultComboBoxModel model = new DefaultComboBoxModel();
    ProveedorModel proveedor = new ProveedorModel();
    ArrayList<ArrayList> proveedores = proveedor.getProveedores();
    for (int i = 0;i < proveedores.size() ;i++ ) {
        model.addElement(proveedores.get(i).get(4));
    }
    return model;
  }

}
