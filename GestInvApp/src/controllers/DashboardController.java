/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.swing.JFrame;
import views.DashboardView;
import java.sql.Connection;
/**
 *
 * @author Carlos Andres Cordoba Ramos
 */


public class DashboardController {

    private DashboardView dashboard;
    private int userIdLogged;

    public DashboardController(){

    }

    /*
    *Muestra el dashboard
    **/
    public void showView(){
      CurrentSesionController sesion = new CurrentSesionController(userIdLogged);
      dashboard = new DashboardView();
      dashboard.setUserIdLogged(userIdLogged); //le pasamos el id del usuario al dashboard, para que lo pueda pasar a los otros modulos
      dashboard.setVisible(true);
      dashboard.setLayout(null);
      dashboard.setCurrentUser(sesion.getName());
      dashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setIdUserLogged(int id){
      this.userIdLogged = id;
    }
}
