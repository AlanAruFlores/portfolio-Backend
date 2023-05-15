/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.alanaruquipa.interfaces;

import com.miportfolio.alanaruquipa.entity.Experiencia;
import java.util.List;
import java.util.Optional;


/**
 *
 * @author Usuario
 */

public interface IExperienciaService {
    public List<Experiencia>  getAll();
    public Optional<Experiencia> getById(int id);
    public Optional<Experiencia> getByNombre(String nombre);
    public void saveExperiencia(Experiencia nuevaExperiencia);
    public void deleteExperiencia(int id);
    public boolean existsById(int id);
    public boolean existsByNombre(String nombre);
}
