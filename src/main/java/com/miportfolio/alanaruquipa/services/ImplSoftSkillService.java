/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.alanaruquipa.services;

import com.miportfolio.alanaruquipa.entity.HardSkill;
import com.miportfolio.alanaruquipa.entity.SoftSkill;
import com.miportfolio.alanaruquipa.interfaces.ISoftSkillService;
import com.miportfolio.alanaruquipa.repository.ISoftSkillRepository;
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
public class ImplSoftSkillService implements ISoftSkillService{
    @Autowired
    ISoftSkillRepository repository;
    
    @Override
    public List<SoftSkill> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Optional<SoftSkill> getById(int id) {
        return this.repository.findById(id);
    }

    @Override
    public Optional<SoftSkill> getByNombre(String nombre) {
        return this.repository.findByNombre(nombre);
    }

    @Override
    public void save(SoftSkill hardskill) {
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
