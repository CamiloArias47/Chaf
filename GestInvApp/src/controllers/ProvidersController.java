/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.ArrayList;
import models.CustomersModel;
import models.ProvidersModel;

/**
 *
 * @author Carlos Andres Cordoba
 */
public class ProvidersController {
   private ProvidersModel modeloProvider = new ProvidersModel();
    private ArrayList clientes;
    
    public String getProvidersForTable(int tipoDato,int iterador){
        //tipo dato:
        // 1 = tipo documento proveedor
        // 2 = numero de documento del proveedor
        // 4 = nombre del proveedor
        clientes = this.modeloProvider.getProveedores();
        ArrayList datos = (ArrayList) clientes.get(iterador);
        return (String) datos.get(tipoDato);
    }
    public int getUsersOnTable(){
        return this.modeloProvider.getCantProveedores();
    }
      public void insertUser(String tipoDoc,int numDoc,String dir,String name,String tel){
          this.modeloProvider.insertarProveedor(tipoDoc, numDoc, dir, name, tel);
      } 
}
