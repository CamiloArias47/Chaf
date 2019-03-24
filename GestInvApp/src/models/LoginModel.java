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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Camilo Arias
 */
public class LoginModel extends ConexionBD{

    private String user;
    private String pass;
    public LoginModel(){
      super();
    }

    public boolean validate(){
      Connection con = this.conexion;
      try {
          Statement query = con.createStatement();
          ResultSet response = query.executeQuery("SELECT * FROM usuario WHERE login_usuario = '"+user+"' and contraseña = '"+pass+"'");
          if(response.next()){
            return true;
          }
          else{
            return false;
          }
      } catch (SQLException ex) {
          Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
          return false;
      }
    }

    public void setUser(String user){
      this.user = user;
    }

    public void setPass(String pass){
      this.pass = pass;
    }

    public String getUser(){
      return this.user;
    }

    public String getPass(){
      return this.pass;
    }    
    
}
