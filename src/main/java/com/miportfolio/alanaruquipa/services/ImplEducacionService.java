/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.alanaruquipa.services;

import com.miportfolio.alanaruquipa.entity.Educacion;
import com.miportfolio.alanaruquipa.interfaces.IEducacionService;
import com.miportfolio.alanaruquipa.repository.IEducacionRepository;
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
public class ImplEducacionService implements IEducacionService{
    @Autowired
    IEducacionRepository repository;
    
    @Override
    public List<Educacion> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Optional<Educacion> getById(int id) {
        return this.repository.findById(id);
    }

    @Override
    public Optional<Educacion> getByNombre(String nombre) {
        return this.repository.findByNombre(nombre);
    }

    @Override
    public void saveEducacion(Educacion exp) {
        this.repository.save(exp);
    }

    @Override
    public boolean existsById(int id) {
        return this.repository.existsById(id);
    }

    @Override
    public boolean existsByNombre(String nombre) {
        return this.repository.existsByNombre(nombre);
    }

    @Override
    public void deleteById(int id) {
        this.repository.deleteById(id);
    }
    
}
