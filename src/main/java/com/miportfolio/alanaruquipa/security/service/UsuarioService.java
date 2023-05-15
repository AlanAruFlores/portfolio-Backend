/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.alanaruquipa.security.service;

import com.miportfolio.alanaruquipa.security.entity.Usuario;
import com.miportfolio.alanaruquipa.security.repository.IUsuarioRepository;
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
public class UsuarioService {
    @Autowired
    IUsuarioRepository repository;
    
    public void saveUsuario(Usuario usuario){
        this.repository.save(usuario);
    }
    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return this.repository.findByNombreUsuario(nombreUsuario);
    }
    public boolean existsByNombreUsuario(String nombreUsuario){
        return this.repository.existsByNombreUsuario(nombreUsuario);
    }
    public boolean existsByMail(String mail){
        return this.repository.existsByMail(mail);
    }
}
