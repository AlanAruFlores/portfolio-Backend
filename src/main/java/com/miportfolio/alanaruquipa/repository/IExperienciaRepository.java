/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.alanaruquipa.repository;

import com.miportfolio.alanaruquipa.entity.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
/**
 *
 * @author Usuario
 */
@Repository
public interface IExperienciaRepository extends JpaRepository<Experiencia, Integer>{
    public Optional<Experiencia> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
