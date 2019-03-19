/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos Andres
 */
public class conexionBD {
    
    private Connection conexion = null;
    private ResultSet response  = null;
    private Statement s         = null;
    
    public void conectar (){
        if( conexion != null){
            return;
        }
         
    String url = "jdbc:postgresql://chaf-pruebas.cjbpeuvptazq.us-east-2.rds.amazonaws.com:5432/CHAF_PRUEBA";
    String pwd = "Cali20*Q";
    
    try{
    Class.forName("org.postgresql.Driver");
    conexion = DriverManager.getConnection(url,"chaf",pwd);
     if( conexion != null){
            System.out.println("Chee me estoy conectando a la BD, Boludo!...");
        }
    }catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
}
    }
   
    public void pruebaConexion(){
        try {
            s = conexion.createStatement();
            response = s.executeQuery("SELECT * FROM tercero");
        } catch (SQLException ex) {
            Logger.getLogger(conexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String string = "";
        
       
            
        try {
            while(response.next()){
                int i= 1;
                while(i<6){
                    string += response.getString(i) + ",";
                    i++;
                }
                System.out.println(string);
            }
        } catch (SQLException ex) {
            Logger.getLogger(conexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
