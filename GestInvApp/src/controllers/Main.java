/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.UnsupportedEncodingException;
import javax.swing.JFrame;
import views.Login;
import views.ProvidersView;
import views.UserView;
import java.security.*;
/**
 *
 * @author camilo
 */
public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
          Login login = new Login();
          login.setVisible(true);
          login.setLayout(null);
          login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    }         
}