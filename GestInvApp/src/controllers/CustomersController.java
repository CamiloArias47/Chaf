/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.CustomersModel;
import java.util.ArrayList;


/**
 *
 * @author CArlos Andres Cordoba
 */
public class CustomersController {
    
    private CustomersModel modeloCustomer = new CustomersModel();
    private ArrayList clientes;
    
    public String getClientsForTable(int tipoDato,int iterador){
        //tipo dato:
        // 0 = tipo documento cliente
        // 1 = numero de documento del cliente
        // 2 = nombre del cliente
        clientes = this.modeloCustomer.getUsersExist();
        ArrayList datos = (ArrayList) clientes.get(iterador);
        return (String) datos.get(tipoDato);
    }
    public int getUsersOnTable(){
        return this.modeloCustomer.getCantidadClientes();
    }
      public void insertUser(String tipoDoc,int numDoc,String dir,String name,String tel){
          this.modeloCustomer.insertCliente(tipoDoc, numDoc, dir, name, tel);
      }
}
