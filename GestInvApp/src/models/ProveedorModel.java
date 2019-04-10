/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import models.ConexionBD;
import java.sql.Connection;
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
public class ProveedorModel {

    private int tercero_id;
    private boolean estado;

    public ProveedorModel(){

    }

    public ProveedorModel(String name){
      Connection conexion = null;
      try{
        ConexionBD conexionPoll = new ConexionBD();
        conexion = conexionPoll.getBasicDataSource().getConnection();
        Statement query = conexion.createStatement();
        ResultSet response = query.executeQuery("SELECT t.tercero_id, p.estado FROM tercero as t INNER JOIN proveedor as p ON p.tercero_id = t.tercero_id WHERE t.nombre_tercero = '"+name+"'");
        while(response.next()){
          tercero_id = response.getInt(1);
          estado = response.getBoolean(2);
        }
      }
      catch(SQLException ex){
          Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
      }
      finally{
        try{ if(conexion != null) conexion.close();}catch(Exception e){ System.out.println("[ProveedorModel] Error: no fue posible liberar la conexión");}
      }
    }

    public ArrayList getProveedores(){
      ArrayList<ArrayList> proveedores = new ArrayList<ArrayList>();
      Connection conexion = null;
      try{
        ConexionBD conexionPoll = new ConexionBD();
        conexion = conexionPoll.getBasicDataSource().getConnection();
        Statement query = conexion.createStatement();
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
      finally{
        try{ if(conexion != null) conexion.close();}catch(Exception e){ System.out.println("[ProveedorModel] Error: no fue posible liberar la conexión");}
      }
    }


    //:::::::::::::::GETERS:::::::::::::::::::::::::::::

    public int getTercero_id(){
      return tercero_id;
    }

    public boolean getEstado(){
      return estado;
    }
}
