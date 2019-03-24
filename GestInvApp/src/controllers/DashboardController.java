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


public class DashboardController {

    private int userIdLogged; //id del usuario logueado, se lo pasamos a otros modulos

    public DashboardController(){

    }

    public void setUserIdLogged(int id){
      this.userIdLogged = id;
    }
}
