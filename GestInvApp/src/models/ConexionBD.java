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
public class ConexionBD {

    
    
    private Connection conexion = null;
    private ResultSet response  = null;
    private Statement s         = null;
    
    public void ConexionBD (){
        if( conexion != null){
            return;
        }
         
    String url = "jdbc:postgresql://chaf-pruebas.cjbpeuvptazq.us-east-2.rds.amazonaws.com:5432/CHAF_PRUEBA";
    String pwd = "Cali20*Q";
    
    try{
    Class.forName("org.postgresql.Driver");
    conexion = DriverManager.getConnection(url,"chaf",pwd);
     if( conexion != null){
            System.out.println("Conectando a la BD en AWS...");
        }
    }catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
    }
   
    public void ejecutarConsulta(String sentencia){
        
        String string = "";  
        try {
            s = conexion.createStatement();
            response = s.executeQuery(sentencia);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        /**
         * Pregunta, como se manejarian las consultas basicas. Pense en manejarlas como un arreglo
         * ejemplo : {'SELECT','UPDATE',DELETE'}
         * para  asi mismo pasara la respuesta en un condicional debajo de este comentario
         */      
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
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public void respuestaConsulta(){
       
    }
    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public ResultSet getResponse() {
        return response;
    }

    public void setResponse(ResultSet response) {
        this.response = response;
    }

    public Statement getS() {
        return s;
    }

    public void setS(Statement s) {
        this.s = s;
    }
}
