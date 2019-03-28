
package models;

import models.ConexionBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author camilo
 */
public class UserModel {

    String tipo_id, direccion, nombre, telefono;
    int tercero_id, numero_id;

    public UserModel(){

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
        ConexionBD con = new ConexionBD();
        Connection conex = con.getConexion();
        try {
            Statement query = conex.createStatement();
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
    }

    /*
    * Busca un usuario en la base de datos segun el campo y el valor que se le pase
    **/
    public void where(String field, String value){
      ConexionBD con = new ConexionBD();
      Connection conex = con.getConexion();
      try {
          Statement query = conex.createStatement();
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
    }

    /*
    * Busca un usuario en la base de datos segun el campo y el valor que se le pase
    **/
    public void whereUserName(String value){
      ConexionBD con = new ConexionBD();
      Connection conex = con.getConexion();
      try {
          Statement query = conex.createStatement();
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



}
