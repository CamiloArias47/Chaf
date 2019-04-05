/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.ArrayList;
import models.UserModel;

/**
 *
 * @author Carlos Andres
 */
public class UserController {
    private UserModel modeloUser = new UserModel();
    private ArrayList usuarios;
    
    public void insertUser(String tipoDoc,int numDoc,String dir,String name,String tel,String login,String pwd){

        //faltan validaciones
        this.modeloUser.insertarUsuario(tipoDoc, numDoc, dir, name, tel,login,pwd);
        
    }
    
    public String getUserForTable(int tipoDato,int iterador){
       //tipo dato:
       // 0 = login del usuario
       // 1 = nombre del usuario 
       usuarios = this.modeloUser.getUsersExist();
       ArrayList datos = (ArrayList) usuarios.get(iterador);
       return (String) datos.get(tipoDato);
    }
    
    public int getUsersOnTable(){
        return modeloUser.getCantidadUsers();
    }
}
