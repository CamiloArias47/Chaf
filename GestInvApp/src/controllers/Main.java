/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.swing.JFrame;
import models.UserModel;
import views.Login;
import views.TercerosRegisterView;
/**
 *
 * @author camilo
 */
public class Main {
    public static void main(String[] args) {
//          Login login = new Login();
//          login.setVisible(true);
//          login.setLayout(null);
//          login.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  

        UserModel um = new UserModel();
        System.out.println(um.getUsersExist());
    }         
}