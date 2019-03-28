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

    protected Connection conexion = null; //esta protegida para que las clases hijas (modelos) puedann acceder a la conexion
    private ResultSet response  = null;
    private Statement s         = null;
    protected String currentUser;
    protected String pwd;

    public ConexionBD(){
        if( conexion != null){
            System.out.println("[ConexionDB] Conectado");
            return;
        }

        System.out.println("[ConexionDB] Iniciar conexion...");

        String url = "jdbc:postgresql://chaf-pruebas.cjbpeuvptazq.us-east-2.rds.amazonaws.com:5432/CHAF_PRUEBA";
        String user = "chaf";
        String pwd = "Cali20*Q";

        try{
          Class.forName("org.postgresql.Driver");
          System.out.println("[ConexionDB] Driver cargado");
        }catch(ClassNotFoundException e){
                System.out.println(e);
        }

        try{
          conexion = DriverManager.getConnection(url,"chaf",pwd);
           if( conexion != null){
            System.out.println("[ConexionBD] Conectado a la BD en AWS");
           }
        }
        catch(SQLException ex){
          System.out.println("[ConexionDB]Error: No se pudo conectar a la base de datos, "+ex);
          ex.printStackTrace();
        }
    }

    public Connection getConexion(){
      return this.conexion;
    }

    /*
    * CIerra la conexion
    **/
    public void closeConection(){
        try{
            this.conexion.close();
            System.out.println("[ConexionBD] Conexión cerrada");
        }
        catch(SQLException ex){
            System.out.println("Error al cerrar la conexion con la Base de datos. \n"+ex);
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
                while(i<4){
                    string += response.getString(i) + ",";
                    i++;
                }
                System.out.println(string);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
