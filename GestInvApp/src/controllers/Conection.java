/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
/**
 *
 * @author camilo
 */
public class Conection {
    
    Connection con; //Cargar el driver JDBC postgres 
    Statement sta; //Conectarse con el motor
    ResultSet res; //Procesar las consltas
    
    public Conection(){
       
        try{
            Class.forName("org.postgresql.Driver"); //cargar el driver JDBC
            System.out.println("Driver cargado");
        }
        catch(ClassNotFoundException ex){
            System.out.println("Error al cargar el driver");
        }
           
        try{
           con = DriverManager.getConnection("jdbc:postgresql://chaf-pruebas.cjbpeuvptazq.us-east-2.rds.amazonaws.com:5432/chaf", "CHAF", "Cali20*Q");
        }
        catch(SQLException ex){
           System.out.println("No se pudo conectar a la base de datos, "+ex);
           ex.printStackTrace();
        }
    }
}
