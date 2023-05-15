/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.alanaruquipa.repository;

import com.miportfolio.alanaruquipa.entity.SoftSkill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Usuario
 */
@Repository
public interface ISoftSkillRepository extends JpaRepository<SoftSkill, Integer>{
    public Optional<SoftSkill> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
