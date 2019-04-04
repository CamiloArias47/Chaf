package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.ConexionBD;
import models.UserModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Carlos Andres Cordoba Ramos
 */
public class CustomersModel {
    
    private Connection con;
    private int cantidadClientes;
    private ArrayList<ArrayList> clientes = new ArrayList<ArrayList>();
    private  ConexionBD conex = new ConexionBD();
    
    public  CustomersModel (){
        this.setCantidadClientes();
        con = conex.getConexion();
    }
    
    
    public void insertarCliente(String tipoDoc,int numDoc,String dir,String name,String tel){
        try {
            ConexionBD con = new ConexionBD();
            Connection conex = con.getConexion();
            Statement query = conex.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                  ResultSet.CONCUR_UPDATABLE);
           // ResultSet response = query.executeQuery("INSERT INTO tercero VALUES ('"+tipoDoc+"',"+numDoc+",'"+dir+"','"+name+"','"+tel+"';");
            ResultSet response = query.executeQuery("SELECT * FROM tercero");
            response.moveToInsertRow();
            response.updateString("tipo_id",tipoDoc);
            response.updateInt("numero_id", numDoc);
            response.updateString("direccion",dir);
            response.updateString("nombre_tercero",name);
            response.updateString("telefono",tel);
            response.insertRow();
            response.moveToCurrentRow();
      
            System.out.println("[CustomersModel]: se inserto el tercero: " + name);
        } catch (SQLException ex) {
            Logger.getLogger(CustomersModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*
    @author Carlos Andres Cordoba
    Metodo que devuelve los clientes existentes
    tabla Usuario
    */
    
    public ArrayList getUsersExist(){
      try{
        ConexionBD con = new ConexionBD();
        Connection conex = con.getConexion();
        Statement query = conex.createStatement();
        ResultSet response = query.executeQuery("SELECT t.tipo_id,t.numero_id,t.nombre_tercero AS nombre FROM tercero AS t \n" +
                    "NATURAL JOIN cliente AS u");
        while(response.next()){
            int i= 1;
            ArrayList<String> cliente = new ArrayList<String>();
            while(i<4){
                cliente.add(response.getString(i));
                i++;
            }
            this.clientes.add(cliente);
        }
        System.out.print(cantidadClientes);
        return clientes;
      }
      catch(SQLException ex){
          Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
          return clientes;
      }
    }
    
    public int getCantidadClientes(){
       return this.cantidadClientes; 
    }

    private void setCantidadClientes() {
        try {
            ConexionBD con = new ConexionBD();
            Connection conex = con.getConexion();
            Statement query = conex.createStatement();
            ResultSet response = query.executeQuery("SELECT t.tipo_id,t.numero_id, t.direccion,t.nombre_tercero,t.telefono AS nombre FROM tercero AS t \n" +
                    "NATURAL JOIN cliente AS u");
            while(response.next()){
                this.cantidadClientes++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    public void insertCliente(String tipoDoc,int numDoc,String dir,String name,String tel){
      UserModel user = new UserModel();
      user.insertarUsuario(tipoDoc,numDoc,dir,name,tel);
      int tercero_id;
       try {
            ConexionBD con = new ConexionBD();
            Connection conex = con.getConexion();
            Statement query = conex.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                  ResultSet.CONCUR_UPDATABLE);
           // ResultSet response = query.executeQuery("INSERT INTO tercero VALUES ('"+tipoDoc+"',"+numDoc+",'"+dir+"','"+name+"','"+tel+"';");
            ResultSet response = query.executeQuery("SELECT * FROM tercero WHERE tercero_id ="+numDoc);
            /* aqui esta el error*/
            tercero_id = (int) response.getInt(1);
            while(!response.next()){
            response = query.executeQuery("SELECT * FROM cliente");
            response.moveToInsertRow();
            response.updateInt("tercero_id",tercero_id);
            response.updateBoolean("estado", true);
            response.insertRow();
            response.moveToCurrentRow();
      
            }
            
            System.out.println("[CustomersModel]: se inserto el cliente: " + name);
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
