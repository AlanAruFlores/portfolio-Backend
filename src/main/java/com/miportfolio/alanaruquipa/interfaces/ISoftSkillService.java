/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.alanaruquipa.interfaces;

import com.miportfolio.alanaruquipa.entity.SoftSkill;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Usuario
 */
public interface ISoftSkillService {
    public List<SoftSkill> getAll();
    public Optional<SoftSkill> getById(int id);
    public Optional<SoftSkill> getByNombre(String nombre);
    public void save(SoftSkill softSkill);
    public void delete(int id);
    public boolean existsById(int id);
    public boolean existsByNombre(String nombre);
}
