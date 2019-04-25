/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos Andres
 */
public class VentasModel {
    
    public VentasModel(){
    
    }
    
    public void insertVentaCabecera(int cliente_id,int tercero_id,int totalventa){
      Connection con = null;
      
      try{
        ConexionBD conexion = new ConexionBD();
        con = conexion.getBasicDataSource().getConnection();
        PreparedStatement query = con.prepareStatement("INSERT INTO venta (cliente_id,tercero_id,fechaventa,totalventa)values(?,?,NOW(),?)");
        query.setInt(1,cliente_id);
        query.setInt(2,tercero_id);
        query.setInt(3,totalventa);
        query.executeQuery();
      }
      catch(SQLException ex){
        Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
      }
      finally{
        try{ if(con != null) con.close(); }catch(Exception e){ System.out.println("[VentasModel] Error: no fue posible liberar la conexión "+e); }
      }
    }
    
    public void insertVentaDetalle(int producto,int cantidad,int valor_unitario){
      Connection con = null;
      try{
        ConexionBD conexion = new ConexionBD();
        con = conexion.getBasicDataSource().getConnection();
        PreparedStatement query = con.prepareStatement("INSERT INTO venta_detalle (venta_id, producto_id,cantidad,valor_unitario)values((SELECT MAX(venta_id) FROM venta),?,?,?))");
        query.setInt(1,producto);
        query.setInt(2,cantidad);
        query.setInt(3,valor_unitario);
        query.executeQuery();
      }
      catch(SQLException ex){
        Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
      }
      finally{
        try{ if(con != null) con.close(); }catch(Exception e){ System.out.println("[VentasModel] Error: no fue posible liberar la conexión "+e); }
      }
    }
    
}
