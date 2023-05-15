/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.alanaruquipa.services;

import com.miportfolio.alanaruquipa.entity.HardSkill;
import com.miportfolio.alanaruquipa.interfaces.IHardSkillService;
import com.miportfolio.alanaruquipa.repository.IHardSkillRepository;
import java.util.List;
import java.util.Optional;
import javax.persistence.Entity;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
@Transactional
public class ImplHardSkillService implements IHardSkillService{  
    
    @Autowired
    IHardSkillRepository repository;

    @Override
    public List<HardSkill> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Optional<HardSkill> getById(int id) {
        return this.repository.findById(id);
    }

    @Override
    public Optional<HardSkill> getByNombre(String nombre) {
        return this.repository.findByNombre(nombre);
    }

    @Override
    public void save(HardSkill hardskill) {
        this.repository.save(hardskill);
    }

    @Override
    public void delete(int id) {
        this.repository.deleteById(id);
    }

    @Override
    public boolean existsById(int id) {
        return this.repository.existsById(id);
    }

    @Override
    public boolean existsByNombre(String nombre) {
        return this.repository.existsByNombre(nombre);
    }
   
}
