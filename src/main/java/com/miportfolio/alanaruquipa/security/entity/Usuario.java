/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.alanaruquipa.security.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Usuario
 */
@Entity
@Getter
@Setter
public class Usuario {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    private String nombre;
    @NotNull
    @Column(unique=true)
    private String nombreUsuario;
    @NotNull
    private String mail;
    @NotNull
    private String contrasenia;
    
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="usuario_rol", joinColumns=@JoinColumn(name="usuario_id"),inverseJoinColumns = @JoinColumn(name="rol_id"))
    private Set<Rol> setRoles = new HashSet<Rol>();
    
    public Usuario(){};

    public Usuario(String nombre, String nombreUsuario, String mail, String contrasenia) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.mail = mail;
        this.contrasenia = contrasenia;
    }

    public Usuario(int id, String nombre, String nombreUsuario, String mail, String contrasenia) {
        this.id = id;
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.mail = mail;
        this.contrasenia = contrasenia;
    }
     
    
    
}
