/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
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

    Connection con;

    public ProductModel(){
      ConexionBD conex = new ConexionBD();
      con = conex.getConexion();
    }

    /*
    * Obtiene los productos de la base de datos
    **/
    public ArrayList getProducts(){
      ArrayList<ArrayList> products = new ArrayList<ArrayList>();
      try{
        Statement query = con.createStatement();
        ResultSet result = query.executeQuery("SELECT * FROM producto");
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
    }

    /*
    *Guarda un producto en la base de datos;
    **/
    public boolean save(String code, String brand, String name, String priceBuy, String priceSell, String amoung, String provider){
      boolean saved = false;
      try{
        Statement query = con.createStatement();
        ResultSet result = query.executeQuery("INSERT INTO producto VALUES ()");

        return true;
      }
      catch(SQLException ex){
          Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
          return false;
      }
    }


}
