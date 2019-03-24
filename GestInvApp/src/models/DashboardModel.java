/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos Andres Cordoba Ramos
 */

public class DashboardModel extends models.ConexionBD {

    private String currentUser;

    public DashboardModel(){
    }

    public String getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
    }

    public String getNameUser(String user){
        Connection con = this.conexion;
        String resultadoQuery = "";
        try {
          Statement query = con.createStatement();
          ResultSet response = query.executeQuery(
                  "SELECT tercero.nombre_tercero FROM usuario NATURAL JOIN tercero WHERE login_usuario = '" + user +"'");
          if(response.next()){
            resultadoQuery = response.getString(1);
            System.out.println("[DasboardModel] Ejecutando query: nombre usuario");
          }
      } catch (SQLException ex) {
          Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);

      }

        return resultadoQuery;
    }
}
