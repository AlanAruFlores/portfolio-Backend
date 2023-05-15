/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.alanaruquipa.repository;

import com.miportfolio.alanaruquipa.entity.HardSkill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Usuario
 */
@Repository
public interface IHardSkillRepository  extends JpaRepository<HardSkill, Integer>{
    public Optional<HardSkill> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
