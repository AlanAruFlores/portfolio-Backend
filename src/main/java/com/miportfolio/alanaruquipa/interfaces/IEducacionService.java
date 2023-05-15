/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.alanaruquipa.interfaces;

import com.miportfolio.alanaruquipa.entity.Educacion;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Usuario
 */
public interface IEducacionService {
    public List<Educacion> getAll();
    public Optional<Educacion> getById(int id);
    public Optional<Educacion> getByNombre(String nombre);
    public void saveEducacion(Educacion exp);
    public boolean existsById(int id);
    public boolean existsByNombre(String nombre);
    public void deleteById(int id);
}
