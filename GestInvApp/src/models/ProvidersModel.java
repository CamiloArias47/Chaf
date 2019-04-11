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

    private int cantidadProveedores;
    private ArrayList<ArrayList> proveedores = new ArrayList<ArrayList>();

    public ProvidersModel(){
        this.setCantidadProveedores();
    }

    public int getCantProveedores(){
        return this.cantidadProveedores;
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

        conexion.close();
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

    public void insertarProveedor(String tipoDoc,int numDoc,String dir,String name,String tel){
        Connection conex = null;
        try {
            ConexionBD con = new ConexionBD();
            conex = con.getBasicDataSource().getConnection();
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
        finally{
          try{ if(conex != null) conex.close();}catch(Exception e){ System.out.println("[ProvidersModel] Error: no fue posible liberar la conexión");}
        }
    }
//    /*
//    @author Carlos Andres Cordoba
//    Metodo que devuelve los proveedores existentes
//    tabla Usuario
//    */
//
//    public ArrayList getProvidersExist(){
//      con = new ConexionBD();
//
//      try{
//        conex = con.getBasicDataSource().getConnection();
//        Statement query = conex.createStatement();
//        ResultSet response = query.executeQuery("SELECT t.tipo_id,t.numero_id,t.nombre_tercero AS nombre FROM tercero AS t \n" +
//                    "NATURAL JOIN proveedor AS u");
//        while(response.next()){
//            int i= 1;
//            ArrayList<String> proveedor = new ArrayList<String>();
//            while(i<4){
//                proveedor.add(response.getString(i));
//                i++;
//            }
//            this.proveedores.add(proveedor);
//        }
//        System.out.print(this.cantidadProveedores);
//        return proveedores;
//      }
//      catch(SQLException ex){
//          Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
//          return proveedores;
//      }
//    }

    private void setCantidadProveedores() {
        ConexionBD con = new ConexionBD();
        Connection conex = null;
        try {
            conex = con.getBasicDataSource().getConnection();
            Statement query = conex.createStatement();
            ResultSet response = query.executeQuery("SELECT t.tipo_id,t.numero_id, t.direccion,t.nombre_tercero,t.telefono AS nombre FROM tercero AS t \n" +
                    "NATURAL JOIN proveedor AS u");
            while(response.next()){
                this.cantidadProveedores++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
       }
       finally{
         try{ if(conex != null) conex.close();}catch(Exception e){ System.out.println("[ProvidersModel] Error: no fue posible liberar la conexión");}
       }
    }

}
