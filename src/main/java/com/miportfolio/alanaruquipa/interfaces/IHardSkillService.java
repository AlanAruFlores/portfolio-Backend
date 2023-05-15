/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.alanaruquipa.interfaces;

import com.miportfolio.alanaruquipa.entity.HardSkill;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Usuario
 */
public interface IHardSkillService {
    public List<HardSkill> getAll();
    public Optional<HardSkill> getById(int id);
    public Optional<HardSkill> getByNombre(String nombre);
    public void save(HardSkill hardskill);
    public void delete(int id);
    public boolean existsById(int id);
    public boolean existsByNombre(String nombre);
}
