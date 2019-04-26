/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.ArrayList;
import models.CustomersModel;
import models.ProductModel;
import models.VentasModel;
import views.VentasView;

/**
 *
 * @author camilo
 */
public class VentasController {

    private CustomersModel cliente = null;
    private ProductModel producto = null;
    private int ClientId;
    private VentasModel modeloVentas = new VentasModel();
    private ProductModel modeloProducto = new ProductModel();
    

    public void showVentasView(int userLogged){
        VentasView ventasView = new VentasView();
        ventasView.setUserLogged(userLogged);
        ventasView.setVisible(true);
    }

    public ArrayList<ArrayList> getClientesWhereName(String name){
      if(cliente == null) cliente = new CustomersModel();
      return cliente.getClientWhere(name);
    }
    
    public void setClientId(int newVal){
        this.ClientId = newVal;
    }
    
    
    public ArrayList<ArrayList> getProductWhereName(String name){
      if(producto == null) producto = new ProductModel();
      return producto.getProductWhere(name);
    }
    
    public boolean validateStock(int idProducto,int cantidad){
        if(this.producto.getStockProductById(idProducto) < cantidad){
            return false;
        }else{
            return true;
        }
    }
    
    public void makeVentaCabecera(int clientId,int usuario,int totalVenta){
        this.modeloVentas.insertVentaCabecera(clientId, usuario, totalVenta);
    }
    public void makeVentaDetalle(int producto,int cantidad,int valorUnitario){
        this.modeloVentas.insertVentaDetalle(producto, cantidad, valorUnitario);
    }
    public void descontarCantidad(int producto,int cantidad){
        this.modeloProducto.descontarCantidad(producto,cantidad);
    }
}