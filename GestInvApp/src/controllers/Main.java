/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.swing.JFrame;
import views.DashboardView;
import views.Login;

/**
 *
 * @author camilo
 */
public class Main {
    public static void main(String[] args) {
          Login login = new Login();
          login.setVisible(true);
          login.setLayout(null);
          login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      /*  DashboardView view = new DashboardView();
        view.setVisible(true);
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); */
      Conection con = new Conection();
    }
}
