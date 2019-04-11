
package models;

import models.ConexionBD;
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
public class UserModel {

    private String tipo_id, direccion, nombre, telefono;
    private int tercero_id, numero_id;
    private int cantidadUsers;
    private ArrayList<ArrayList> usuarios = new ArrayList<ArrayList>();
    private ConexionBD con;
    private Connection conex;

    public UserModel(){
        this.setCantidadUsers();
    }

    //Getters

    public String getTipo_id() {
        return tipo_id;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getTercero_id() {
        return tercero_id;
    }

    public int getNumero_id() {
        return numero_id;
    }

    public UserModel(String tipo_id, String direccion, String nombre, String telefono, int tercero_id, int numero_id) {
        this.tipo_id = tipo_id;
        this.direccion = direccion;
        this.nombre = nombre;
        this.telefono = telefono;
        this.tercero_id = tercero_id;
        this.numero_id = numero_id;
    }

    /*
    *Obtine un usuario segun su id en la tabla tercero
    *@param {int} id id de el usuario.
    **/
    public void setUser(int id){
      ConexionBD conexionPoll = new ConexionBD();
      Connection conexion = null;

        try {
            conexion = conexionPoll.getBasicDataSource().getConnection();
            Statement query = conexion.createStatement();
            ResultSet response = query.executeQuery("SELECT * FROM tercero WHERE tercero_id = '"+id+"'");

            if(response.next()){
              this.tercero_id = response.getInt(1);
              this.tipo_id = response.getString(2);
              this.numero_id = response.getInt(3);
              this.direccion = response.getString(4);
              this.nombre = response.getString(5);
              this.telefono = response.getString(6);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
          try{ if(conexion != null) conexion.close(); }catch(Exception e){ System.out.println("[UserModel] Error: no se pudo liberar la conexión");}
        }
    }

    /*
    * Busca un usuario en la base de datos segun el campo y el valor que se le pase
    **/
    public void where(String field, String value){

      Connection conexion = null;
      try {
          ConexionBD conexionPoll = new ConexionBD();
          conexion = conexionPoll.getBasicDataSource().getConnection();
          Statement query = conexion.createStatement();
          ResultSet response = query.executeQuery("SELECT * FROM tercero WHERE "+field+" = '"+value+"'");

          if(response.next()){
            this.tercero_id = response.getInt(1);
            this.tipo_id = response.getString(2);
            this.numero_id = response.getInt(3);
            this.direccion = response.getString(4);
            this.nombre = response.getString(5);
            this.telefono = response.getString(6);
          }

      } catch (SQLException ex) {
          Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
      }
      finally{
        try{ if(conexion != null) conexion.close();}catch(Exception e){ System.out.println("[UserModel] Error: no fue posible liberar la conexión");}
      }
    }

    /*
    * Busca un usuario en la base de datos segun el campo y el valor que se le pase
    **/
    public void whereUserName(String value){

      ConexionBD conexionPoll = new ConexionBD();
      Connection conexion = null;
      try {
          conexion = conexionPoll.getBasicDataSource().getConnection();
          Statement query = conexion.createStatement();
          ResultSet response = query.executeQuery("SELECT t.tercero_id, t.tipo_id, t.numero_id, t.direccion, t.nombre_tercero, t.telefono, u.login_usuario FROM tercero as t INNER JOIN usuario as u ON u.tercero_id = t.tercero_id WHERE u.login_usuario = '"+value+"'");
          if(response.next()){
            this.tercero_id = response.getInt(1);
            this.tipo_id = response.getString(2);
            this.numero_id = response.getInt(3);
            this.direccion = response.getString(4);
            this.nombre = response.getString(5);
            this.telefono = response.getString(6);
          }

      } catch (SQLException ex) {
          Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
      }
      finally{
        try{ if (conexion != null) conexion.close();}catch(Exception e) { System.out.println("[UserModel] Error: error liberando conexión");}
      }
    }

    /**
     * @author: Carlos Andres Cordoba Ramos
     * Descripcion: Inserta un usuario en la tabla usuario y en la tabla tercero
     * utilizando una funcion definida en la BD.
     */
    public void insertUser(String tipoDoc,int numDoc,String dir,String name,String tel,String login,String pwd){

        Connection conex = null;
        try {
            ConexionBD con = new ConexionBD();
            conex = con.getBasicDataSource().getConnection();
            PreparedStatement query = conex.prepareStatement("SELECT insertarUsuario(?,?,?,?,?,?,?)");
            query.setString(1, tipoDoc);
            query.setInt(2,(int) numDoc);
            query.setString(3, dir);
            query.setString(4,name);
            query.setString(5, tel);
            query.setString(6, login);
            query.setString(7, pwd);
            query.execute();
            System.out.println("[UserModel]: se inserto el tercero: " + name);
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
          try{ if (conex != null) conex.close();}catch(Exception e) { System.out.println("[UserModel] Error: error liberando conexión");}
        }
    }

    /*
    @author Carlos Andres Cordoba
    Metodo que devuelve login y nombre de un usuario que existe en la
    tabla Usuario
    */
    public ArrayList getUsersExist(){
      Connection conexion = null;
      try{
        ConexionBD conexionPoll = new ConexionBD();
        conexion = conexionPoll.getBasicDataSource().getConnection();
        Statement query = conexion.createStatement();
        ResultSet response = query.executeQuery("SELECT u.login_usuario,t.nombre_tercero AS nombre FROM tercero AS t \n" +
                                                "NATURAL JOIN usuario AS u");
        while(response.next()){
            int i= 1;
            ArrayList<String> usuario = new ArrayList<String>();
            while(i<3){
                usuario.add(response.getString(i));
                i++;
            }
            this.usuarios.add(usuario);
        }
        conexion.close();
        return usuarios;
      }
      catch(SQLException ex){
          Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
          return usuarios;
      }finally{
        try{ if(conexion != null) conexion.close(); }catch(Exception e){ System.out.println("[ProductModel] Error: no fue posible liberar la conexión "+e); }
      }
    }

    public int getCantidadUsers(){
       return this.cantidadUsers;
    }

    private void setCantidadUsers() {
      Connection conexion = null;
        try {
          ConexionBD con = new ConexionBD();
          conex = con.getBasicDataSource().getConnection();
          Statement query = conex.createStatement();
          ResultSet response = query.executeQuery("SELECT u.login_usuario,t.nombre_tercero AS nombre FROM tercero AS t \n" +
                  "NATURAL JOIN usuario AS u");
          while(response.next()){
              this.cantidadUsers++;
          }
      } catch (SQLException ex) {
          Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
      }
      finally{
        try{ if(conex != null) conex.close(); }catch(Exception e){ System.out.println("[UserModel] Error: no fue posible liberar la conexión "+e); }
      }
    }

    /**
     * @author: Carlos Andres Cordoba Ramos
     * @param tipoDoc
     * @param numDoc
     * @param dir
     * @param name
     * @param tel
     *
     */
    public void insertarUsuario(String tipoDoc,int numDoc,String dir,String name,String tel){
        Connection conexion = null;
        try {
            ConexionBD conectionPoll = new ConexionBD();
            conexion = conectionPoll.getBasicDataSource().getConnection();
            Statement query = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
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

            System.out.println("inserto");
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
          try{ if(conexion != null) conexion.close(); }catch(Exception e){ System.out.println("[UserModel] Error: no se pudo liberar la conexión"); }
        }
    }
}
