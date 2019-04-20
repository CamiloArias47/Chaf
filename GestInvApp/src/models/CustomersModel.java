package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    private int cantidadClientes;
    private ArrayList<ArrayList> clientes = new ArrayList<ArrayList>();

    public  CustomersModel (){
        this.setCantidadClientes();
    }


    public void insertarCliente(String tipoDoc,int numDoc,String dir,String name,String tel){
        Connection conex = null;

        try {
            ConexionBD con = new ConexionBD();
            conex = con.getBasicDataSource().getConnection();
            PreparedStatement query = conex.prepareStatement(" SELECT insertar_cliente(?,?,?,?,?)");
            query.setString(1, tipoDoc);
            query.setInt(2,(int) numDoc);
            query.setString(3, dir);
            query.setString(4,name);
            query.setString(5, tel);
            query.execute();
            System.out.println("[CustomersModel]: se inserto el tercero: " + name);
        } catch (SQLException ex) {
            Logger.getLogger(CustomersModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
          try{ if(conex != null) conex.close(); }catch(Exception e){ System.out.println("[CustomersModel] Error: no fue posible liberar la conexión"); }
        }
    }
    /*
    @author Carlos Andres Cordoba
    Metodo que devuelve los clientes existentes
    tabla Usuario
    */

    public ArrayList getUsersExist(){
      Connection conexion = null;
      try{
        ConexionBD conexionPoll = new ConexionBD();
        conexion = conexionPoll.getBasicDataSource().getConnection();
        Statement query = conexion.createStatement();
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
        conexion.close();
        return clientes;
      }
      catch(SQLException ex){
          Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
          return clientes;
      }
       finally{
        try{ if(conexion != null) conexion.close(); }catch(Exception e){ System.out.println("[CustomerModel] Error: no fue posible liberar la conexión "+e); }
      }
    }

    public int getCantidadClientes(){
       return this.cantidadClientes;
    }

    private void setCantidadClientes() {
        Connection conex = null;
        try {
            ConexionBD con = new ConexionBD();
            conex = con.getBasicDataSource().getConnection();
            Statement query = conex.createStatement();
            ResultSet response = query.executeQuery("SELECT t.tipo_id,t.numero_id, t.direccion,t.nombre_tercero,t.telefono AS nombre FROM tercero AS t \n" +
                    "NATURAL JOIN cliente AS u");
            while(response.next()){
                this.cantidadClientes++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
       }
       finally{
         try{ if(conex != null) conex.close(); }catch(Exception e){ System.out.println("[CustomersModel] Error: no fue posible liberar la conexión"); }
       }
    }

    /*
    *retorna los clientes con estado true
    **/
    public ArrayList<ArrayList> getClients(){
      ArrayList<ArrayList> clientes = new ArrayList<ArrayList>();
      Connection con = null;
      try{
        ConexionBD conexion = new ConexionBD();
        con = conexion.getBasicDataSource().getConnection();
        Statement query = con.createStatement();
        ResultSet result = query.executeQuery("SELECT t.* FROM tercero AS t INNER JOIN cliente ON t.tercero_id = cliente.tercero_id WHERE cliente.estado = true");
        while(result.next()){
          ArrayList<String> cliente = new ArrayList<String>();
          cliente.add(result.getString(1));
          cliente.add(result.getString(2));
          cliente.add(result.getString(3));
          cliente.add(result.getString(4));
          cliente.add(result.getString(5));
          cliente.add(result.getString(6));
          clientes.add(cliente);
        }
      }
      catch(SQLException ex){
        Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
      }
      finally{
        try{ if(con != null) con.close(); }catch(Exception e){ System.out.println("[CustomerModel] Error: no fue posible liberar la conexión "+e); }
      }
      return clientes;
    }

    public ArrayList<ArrayList> getClientWhere(String name){
      ArrayList<ArrayList> clientes = new ArrayList<ArrayList>();
      Connection con = null;
      try{
        ConexionBD conexion = new ConexionBD();
        con = conexion.getBasicDataSource().getConnection();
        PreparedStatement query = con.prepareStatement("SELECT t.* FROM tercero AS t INNER JOIN cliente ON t.tercero_id = cliente.tercero_id WHERE cliente.estado = true AND LOWER(t.nombre_tercero) LIKE LOWER(?)");
        System.out.println("[DEBUG] antes del setString, name="+name);
        query.setString(1,  "%" + name + "%");
        System.out.println("[DEBUG] despues del setString");
        ResultSet result = query.executeQuery();
        while(result.next()){
          ArrayList<String> cliente = new ArrayList<String>();
          cliente.add(result.getString(1));
          cliente.add(result.getString(2));
          cliente.add(result.getString(3));
          cliente.add(result.getString(4));
          cliente.add(result.getString(5));
          cliente.add(result.getString(6));
          clientes.add(cliente);
        }
      }
      catch(SQLException ex){
        Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
      }
      finally{
        try{ if(con != null) con.close(); }catch(Exception e){ System.out.println("[CustomerModel] Error: no fue posible liberar la conexión "+e); }
      }
      return clientes;
    }

}
