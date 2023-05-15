/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.alanaruquipa.security.controller;



/**
 *
 * @author Usuario
 */
public class Message {
    private String mensaje;
    
    public Message(){}
    
    public Message(String mensaje){
        this.mensaje = mensaje;
    }
   
    public String getMensaje(){
        return this.mensaje;
    }
    public void setMensaje(String mensaje){
        this.mensaje = mensaje;
    }
}
