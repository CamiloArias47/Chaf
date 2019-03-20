package controllers;

import models.LoginModel;
/**
* @fileoverview Controlador del login
* @version 1.0
*
* @author Camilo Arias <CamiloArias47>
* @copyright
* History
* v1.0 La primera versión de aprMenu fue escrita por Camilo Arias
*/
public class LoginController {

    private boolean logged = false; //indica si el logueo fue satisfactorio

    public LoginController(){

    }

    public void clickLogin(String user, String pass){
        LoginModel login = new LoginModel();
        login.setUser(user);
        login.setPass(pass);
        if(login.validate()){
          System.out.println("[LoginController] Access allow");
          logged = true;
        }
        else{
          System.out.println("[LoginController] Access deny");
          logged = false;
        }
    }

    public boolean getLogged(){
      return logged;
    }
}
