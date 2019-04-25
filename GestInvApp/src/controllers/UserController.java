/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.ArrayList;
import models.UserModel;
import org.bouncycastle.jcajce.provider.digest.SHA3;
import org.bouncycastle.util.encoders.Hex;
import java.security.SecureRandom;

/**
 *
 * @author Carlos Andres
 */
public class UserController {
    private UserModel modeloUser = new UserModel();
    private ArrayList usuarios;

    public void insertUser(String tipoDoc,int numDoc,String dir,String name,String tel,String login,String pwd, String rollString){

        //faltan validaciones
        int rol = rollString.equals("Vendedor") ? 1 : 2;
        this.modeloUser.insertUser(tipoDoc, numDoc, dir, name,tel,login,hashSHA3(pwd),rol);

    }

    public String hashSHA3(String word){
      SecureRandom random = new SecureRandom();
      byte[] salt = new byte[16];
      random.nextBytes(salt);
      System.out.println(salt);

      String input = "Hello world !"+salt;
      SHA3.DigestSHA3 digestSHA3 = new SHA3.Digest512();
      byte[] digest = digestSHA3.digest(word.getBytes());

      System.out.println("[UserController] SHA3-512 = " + Hex.toHexString(digest));
      return Hex.toHexString(digest);
    }

    public String getRol(String login){
        return this.modeloUser.getRoleUser(login);
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
    public int getTerceroIdUser(){
        return this.modeloUser.getTercero_id();
    }
    public String getNameUser(String login){
        this.modeloUser.whereUserName(login);
        return this.modeloUser.getNombre();
    }
    public void actualizarDatos(String tipoDoc,int numDoc,String dir,String name,String tel,String login,String pwd){
      this.modeloUser.updateUser(tipoDoc, numDoc, dir, name, tel, login, pwd);
    }

    public ArrayList<String> showRegisterUser(String login){
     ArrayList <String> dataProvider = new ArrayList<String>();
        this.modeloUser.whereUserName(login);
        //tercero id
        dataProvider.add(String.valueOf(this.modeloUser.getTercero_id()));
        // numero documento
        dataProvider.add(String.valueOf(this.modeloUser.getNumero_id()));
        // direccion
        dataProvider.add(this.modeloUser.getDireccion());
        // nombre
        dataProvider.add(this.modeloUser.getNombre());
        //telefono
        dataProvider.add(this.modeloUser.getTelefono());
        return dataProvider;
    }
    public boolean getEstadoUser(String login){
        return this.modeloUser.getStatusUser(login);
    }
    public boolean cambiarEstado(String login,boolean nuevoEstado){
        if(this.modeloUser.getStatusUser(login) != nuevoEstado){
            this.modeloUser.setStatusUser(login, nuevoEstado);
            return true;
        }else{
            return false;
        }
    }

}
