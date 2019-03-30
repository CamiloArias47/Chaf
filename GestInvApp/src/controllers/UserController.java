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
    private UserModel modeloUser;
    
    public void insertUser(String tipoDoc,int numDoc,String dir,String name,String tel){
        this.modeloUser = new UserModel();
        //faltan validaciones
        this.modeloUser.insertarUsuario(tipoDoc, numDoc, dir, name, tel);
    }
    
    public ArrayList getUserForTable(){
        return (String) usuarios.get(0);
    }
}
