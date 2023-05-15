/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.alanaruquipa.security.repository;

import org.springframework.stereotype.Repository;
import com.miportfolio.alanaruquipa.security.entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author Usuario
 */
@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Integer> {
    Optional<Usuario>findByNombreUsuario(String nombre);
    
    boolean existsByNombreUsuario(String nombre);
    boolean existsByMail(String mail);
}
