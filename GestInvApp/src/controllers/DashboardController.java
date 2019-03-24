/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 *
 * @author Carlos Andres Cordoba Ramos
 */

import models.DashboardModel;

public class DashboardController {
    private DashboardModel dashboard;
    
    public DashboardController(){
        dashboard = new DashboardModel();
    }
    
    public void setSesionActual(String sesion){
        dashboard.setCurrentUser(sesion);
    }
    public String getSesionActual(){
        return dashboard.getCurrentUser();
    }
    
    public String getNombreUsuario(String user){
        String resultado = this.dashboard.getNameUser(user);
        return resultado;
    }
}
