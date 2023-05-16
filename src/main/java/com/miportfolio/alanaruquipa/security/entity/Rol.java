/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.alanaruquipa.security.entity;

import com.miportfolio.alanaruquipa.security.enums.RolEnum;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Usuario
 */
@Entity
@Getter @Setter
public class Rol {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Enumerated(EnumType.STRING) //Sirve para definir los valores a ingresar, en este caso string, luego tenemos ordinal para numeros.
    private RolEnum rolNombre;
    
    public Rol(){}
    public Rol(RolEnum nombre){
        this.rolNombre = nombre;
    }
}
