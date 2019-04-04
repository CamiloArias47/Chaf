/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author camilo
 */
public class ProductModel {

    private int producto_id;
    private String descripcion;
    private int costo;
    private int precio_venta;

    public ProductModel(){
    }

    public ProductModel(String id){
      System.out.println("[DEBUG] contrustor con parametro");
      Connection conexion = null;
      try{
        ConexionBD conexionPool = new ConexionBD();
        conexion = conexionPool.getBasicDataSource().getConnection();
        Statement query = conexion.createStatement();
        ResultSet result = query.executeQuery("SELECT * FROM producto WHERE producto_id = '"+id+"'");
        if(result.next()){
          this.producto_id = result.getInt(1);
          this.descripcion = result.getString(2);
          this.costo = result.getInt(3);
          this.precio_venta = result.getInt(4);
          System.out.println("[DEBUG] "+producto_id+", "+descripcion+", "+costo+", "+precio_venta);
        }
        else{
          System.out.println("[DEBUG] result.next() vacio");
        }
      }
      catch(SQLException ex){
          Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
      }
      finally{
          try{ if(conexion != null) conexion.close(); }catch(Exception e){ System.out.println("[ProductModel] Erro: no fue posible liberar la conexión");}
      }
    }

    /*
    *Obtiene el ultimo id de producto
    **/
    public int getLastId(){
      Connection conexion = null;
      try{
        ConexionBD conexionPoll = new ConexionBD();
        conexion = conexionPoll.getBasicDataSource().getConnection();
        Statement query = conexion.createStatement();
        ResultSet result = query.executeQuery("SELECT MAX(producto_id) FROM producto");
        if(result.next()){
          return result.getInt(1);
        }else{
            return 0;
        }
      }
      catch(SQLException ex){
        Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        return 0;
      }
      finally{
        try{ if(conexion != null) conexion.close(); }catch(Exception e){ System.out.println("[ProductModel] Error: no se pudo liberar la conexion: "+e); }
      }
    }


    /*
    * Obtiene los productos de la base de datos
    **/
    public ArrayList getProducts(){
      ArrayList<ArrayList> products = new ArrayList<ArrayList>();
      Connection conexion = null;
      try{
        ConexionBD conexionPoll = new ConexionBD();
        conexion = conexionPoll.getBasicDataSource().getConnection();
        Statement query = conexion.createStatement();
        ResultSet result = query.executeQuery("SELECT * FROM producto ORDER BY producto_id ASC");
        while (result.next()) {
          ArrayList<String> product = new ArrayList<String>();
          for (int i = 1; i<=4 ;i++ ) {
            product.add(result.getString(i));
          }
          products.add(product);
        }

        return products;
      }
      catch(SQLException ex){
        Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        return products;
      }
      finally{
        try{ if(conexion != null) conexion.close(); }catch(Exception e){ System.out.println("[ProductModel] Error: no fue posible liberar la conexión "+e); }
      }
    }

    /*
    *Guarda un producto en la base de datos;
    **/
    public boolean save(String code, String brand, String name, String priceBuy, String priceSell, String amoung, String provider){
      boolean saved = false;
      Connection conexion = null;
      try{
        ConexionBD conexionPoll = new ConexionBD();
        conexion = conexionPoll.getBasicDataSource().getConnection();
        PreparedStatement query = conexion.prepareStatement("INSERT INTO producto (descripcion, costo, precio_venta) VALUES (?,?,?)");
        query.setString(1,name);
        query.setInt(2,Integer.parseInt(priceBuy));
        query.setInt(3,Integer.parseInt(priceSell));
        int result = query.executeUpdate();
        if( result > 0){
          return true;
        }
        else{
          return false;
        }

      }
      catch(SQLException ex){
          Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
          return false;
      }
      finally{
        try{ if(conexion != null) conexion.close(); }catch(Exception e){ System.out.println("[ProductModel] Error: no se pudo liberar la conexión:"+e); }
      }
    }


    /*
    *Actualiza un producto en la base de datos;
    **/
    public boolean update(String id, String code, String brand, String name, String priceBuy, String priceSell, String amoung, String provider){
      boolean saved = false;
      Connection conexion = null;
      try{
        ConexionBD conexionPoll = new ConexionBD();
        conexion = conexionPoll.getBasicDataSource().getConnection();
        PreparedStatement query = conexion.prepareStatement("UPDATE producto SET descripcion = ?, costo = ?, precio_venta = ? WHERE producto_id = ?");
        query.setString(1,name);
        query.setInt(2,Integer.parseInt(priceBuy));
        query.setInt(3,Integer.parseInt(priceSell));
        query.setInt(4,Integer.parseInt(id));
        int result = query.executeUpdate();
        if( result > 0){
          return true;
        }
        else{
          return false;
        }

      }
      catch(SQLException ex){
          Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
          return false;
      }
      finally{
        try{ if(conexion != null) conexion.close(); }catch(Exception e){ System.out.println("[ProductModel] Error: no se pudo liberar la conexión:"+e); }
      }
    }

    /*
    *Elimina un producto
    **/
    public boolean delete(String id){
      boolean deleted = false;
      Connection conexion = null;
      try{
        ConexionBD conexionPoll = new ConexionBD();
        conexion = conexionPoll.getBasicDataSource().getConnection();
        Statement query = conexion.createStatement();
        int result = query.executeUpdate("UPDATE producto SET eliminado = 'si'");
        if(result > 0){
          deleted = true;
        }
        return deleted;
      }
      catch(SQLException ex){
        Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        return deleted;
      }
      finally{
        try{ if(conexion != null) conexion.close(); }catch(Exception e){ System.out.println("[ProductModel] Error: no se pudo liberar la conexion:"+e); }
      }
    }

    /*
    * Reactiva un producto
    **/
    public boolean restore(String id){
      boolean restored = false;
      Connection conexion = null;
      try{
        ConexionBD conexionPoll = new ConexionBD();
        conexion = conexionPoll.getBasicDataSource().getConnection();
        Statement query = conexion.createStatement();
        int result = query.executeUpdate("UPDATE producto SET eliminado = 'no'");
        if(result > 0){
          restored = true;
        }
        return restored;
      }
      catch(SQLException ex){
        Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        return restored;
      }
      finally(){
        try{ if(conexion != null) conexion.close(); }catch(Exception e){ System.out.println("[ProductModel] Error: no se pudo liberar la conexion:"+e); }
      }
    }


    //:::::::Getters:::::::::::::::::::

    public int getProducto_id() {
        return producto_id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCosto() {
        return costo;
    }

    public int getPrecio_venta() {
        return precio_venta;
    }



}
