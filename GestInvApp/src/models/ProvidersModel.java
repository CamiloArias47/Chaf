/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import models.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

/**
 *
 * @author camilo
 */
public class ProvidersModel {

    private ConexionBD con;
    private Connection conex;
    private int cantidadProveedores;
    private ArrayList<ArrayList> proveedores = new ArrayList<ArrayList>();

    public ProvidersModel(){
        con = new ConexionBD();
        conex = con.getConexion();
        this.setCantidadProveedores();
    }
    
    public int getCantProveedores(){
        return this.cantidadProveedores;
    }

    public ArrayList getProveedores(){
      ArrayList<ArrayList> proveedores = new ArrayList<ArrayList>();
      try{
        Statement query = conex.createStatement();
        ResultSet response = query.executeQuery("SELECT t.tercero_id, t.tipo_id, t.numero_id, t.direccion, t.nombre_tercero, t.telefono, p.estado FROM tercero as t INNER JOIN proveedor as p ON p.tercero_id = t.tercero_id");
        while(response.next()){
            int i= 1;
            ArrayList<String> proveedor = new ArrayList<String>();
            while(i<7){
                proveedor.add(response.getString(i));
                i++;
            }
            proveedores.add(proveedor);
        }
        return proveedores;
      }
      catch(SQLException ex){
          Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
          return proveedores;
      }
    }  
    
    public void insertarProveedor(String tipoDoc,int numDoc,String dir,String name,String tel){
        con = new ConexionBD();
        conex = con.getConexion();
        try {
            PreparedStatement query = conex.prepareStatement(" SELECT insertar_proveedor(?,?,?,?,?)");
            query.setString(1, tipoDoc);
            query.setInt(2,(int) numDoc);
            query.setString(3, dir);
            query.setString(4,name);
            query.setString(5, tel);   
            query.execute();
            System.out.println("[ProvidersModel]: se inserto el tercero: " + name);
        } catch (SQLException ex) {
            Logger.getLogger(CustomersModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*
    @author Carlos Andres Cordoba
    Metodo que devuelve los clientes existentes
    tabla Usuario
    */
    
    public ArrayList getProvidersExist(){
      con = new ConexionBD();
      conex = con.getConexion();
      try{
        Statement query = conex.createStatement();
        ResultSet response = query.executeQuery("SELECT t.tipo_id,t.numero_id,t.nombre_tercero AS nombre FROM tercero AS t \n" +
                    "NATURAL JOIN proveedor AS u");
        while(response.next()){
            int i= 1;
            ArrayList<String> proveedor = new ArrayList<String>();
            while(i<4){
                proveedor.add(response.getString(i));
                i++;
            }
            this.proveedores.add(proveedor);
        }
        System.out.print(this.cantidadProveedores);
        return proveedores;
      }
      catch(SQLException ex){
          Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
          return proveedores;
      }
    }  
    
    private void setCantidadProveedores() {
        con = new ConexionBD();
        conex = con.getConexion();
        try {      
            Statement query = conex.createStatement();
            ResultSet response = query.executeQuery("SELECT t.tipo_id,t.numero_id, t.direccion,t.nombre_tercero,t.telefono AS nombre FROM tercero AS t \n" +
                    "NATURAL JOIN proveedor AS u");
            while(response.next()){
                this.cantidadProveedores++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
}
