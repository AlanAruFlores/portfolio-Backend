/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.alanaruquipa.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Usuario
 */
public class DtoEducacion {
    @NotBlank
    private String nombre;
    @NotBlank
    private String descripcion;
    @NotNull
    private String fechaInicio;
    @NotNull
    private String fechaFinalizacion;

    public DtoEducacion() {
    }

    public DtoEducacion(String nombre, String descripcion, String fechaInicio, String fechaFinalizacion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
    }

    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(String fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }
    
    
}
