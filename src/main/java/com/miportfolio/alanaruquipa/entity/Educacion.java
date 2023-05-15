/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.alanaruquipa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Usuario
 */
@Entity
@Getter @Setter
public class Educacion {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String descripcion;
    
    
    private String fechaInicio;
    
    private String fechaFinalizacion;

    public Educacion() {
    }

    public Educacion(String nombre, String descripcion, String fechaInicio, String fechaFinalizacion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
    }
    
    public Educacion(int id, String nombre, String descripcion, String fechaInicio, String fechaFinalizacion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
    }
    

    
}
