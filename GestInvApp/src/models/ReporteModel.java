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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos Andres
 */
public class ReporteModel {
    
    
    public ReporteModel(){
        
    }
    
    
    public ArrayList<ArrayList> getVentaInfo(){
      Connection con = null;
      ArrayList<ArrayList> ventas = new ArrayList<ArrayList>();
      try{
        ConexionBD conexion = new ConexionBD();
        con = conexion.getBasicDataSource().getConnection();
        PreparedStatement query = con.prepareStatement("SELECT v.venta_id, c.nombre_tercero, t.nombre_tercero,v.fechaventa,v.totalventa FROM venta AS v\n" +
                                                       "INNER JOIN tercero AS t ON t.tercero_id =  v.tercero_id\n" +
                                                       "INNER JOIN (SELECT cliente.tercero_id,tercero.nombre_tercero FROM cliente\n" +
                                                       "NATURAL JOIN tercero) AS c ON c.tercero_id = v.cliente_id");
        ResultSet res = query.executeQuery();
        while(res.next()){
            ArrayList<String> venta = new ArrayList<String>();
            int i = 1;
            venta.add("0");
            while(i<6){
                venta.add(res.getString(i));
                i++;
            }
            ventas.add(venta);
        }
        
        return ventas;
      }
      catch(SQLException ex){
        Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
      }
      finally{
        try{ if(con != null) con.close(); }catch(Exception e){ System.out.println("[VentasModel] Error: no fue posible liberar la conexión "+e); }
      }
       return ventas;
    }
    
    public ArrayList<ArrayList> getUsersInfo(){
      Connection con = null;
      ArrayList<ArrayList> usuarios = new ArrayList<ArrayList>();
      try{
        ConexionBD conexion = new ConexionBD();
        con = conexion.getBasicDataSource().getConnection();
        PreparedStatement query = con.prepareStatement("SELECT tercero.tercero_id,usuario.login_usuario,tercero.nombre_tercero,tercero.tipo_id,tercero.numero_id,tercero.direccion,tercero.telefono,usuario.estado FROM usuario \n" +
                                                       "NATURAL JOIN tercero");
        ResultSet res = query.executeQuery();
        while(res.next()){
            ArrayList<String> usuario = new ArrayList<String>();
            int i = 1;
            while(i<8){
                usuario.add(res.getString(i));
                i++;
            }
            usuarios.add(usuario);
        }
        
        return usuarios;
      }
      catch(SQLException ex){
        Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
      }
      finally{
        try{ if(con != null) con.close(); }catch(Exception e){ System.out.println("[VentasModel] Error: no fue posible liberar la conexión "+e); }
      }
       return usuarios;
    }  
}
