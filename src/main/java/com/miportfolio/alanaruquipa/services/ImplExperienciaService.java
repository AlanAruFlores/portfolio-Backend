/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.alanaruquipa.services;

import com.miportfolio.alanaruquipa.entity.Experiencia;
import com.miportfolio.alanaruquipa.interfaces.IExperienciaService;
import com.miportfolio.alanaruquipa.repository.IExperienciaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
@Transactional
public class ImplExperienciaService implements IExperienciaService {
    @Autowired
    IExperienciaRepository repoExperiencia;
    
    
    @Override
    public List<Experiencia> getAll() {
        return this.repoExperiencia.findAll();
    }

    @Override
    public Optional<Experiencia> getById(int id) {
        return this.repoExperiencia.findById(id);
    }

    @Override
    public Optional<Experiencia> getByNombre(String nombre) {
        return this.repoExperiencia.findByNombre(nombre);
    }

    @Override
    public void saveExperiencia(Experiencia nuevaExperiencia) {
        this.repoExperiencia.save(nuevaExperiencia);
    }

    @Override
    public void deleteExperiencia(int id) {
        this.repoExperiencia.deleteById(id);
    }

    @Override
    public boolean existsById(int id) {
        return this.repoExperiencia.existsById(id);
    }

    @Override
    public boolean existsByNombre(String nombre) {
        return this.repoExperiencia.existsByNombre(nombre);
    }
    
}
