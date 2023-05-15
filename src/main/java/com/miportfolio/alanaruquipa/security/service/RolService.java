/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.alanaruquipa.security.service;

import com.miportfolio.alanaruquipa.security.entity.Rol;
import com.miportfolio.alanaruquipa.security.enums.RolEnum;
import com.miportfolio.alanaruquipa.security.repository.IRolRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

/**
 *
 * @author Usuario
 */
@Service
@Transactional // Mantinene la persistencia en la base de datos, dar la seguridad de que los datos esten en la bd en caso de un fallo en el sistema
public class RolService {
    @Autowired
    IRolRepository repository;
    
    public Optional<Rol> getRolNombre(RolEnum rol){
        return this.repository.findByRolNombre(rol);
    }     
    
    public void saveRol(Rol rol){
        this.repository.save(rol);
    }
            
}
