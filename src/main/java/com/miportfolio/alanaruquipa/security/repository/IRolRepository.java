/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.alanaruquipa.security.repository;

import com.miportfolio.alanaruquipa.security.entity.Rol;
import com.miportfolio.alanaruquipa.security.enums.RolEnum;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Usuario
 */
@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol>findByRolNombre(RolEnum rolNombre);
}
