/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.alanaruquipa.repository;

import com.miportfolio.alanaruquipa.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Usuario
 */
@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Long> {
    
}
