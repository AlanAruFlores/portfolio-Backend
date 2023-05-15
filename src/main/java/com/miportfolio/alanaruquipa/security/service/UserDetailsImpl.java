/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.alanaruquipa.security.service;

import com.miportfolio.alanaruquipa.security.entity.Usuario;
import com.miportfolio.alanaruquipa.security.entity.UsuarioPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class UserDetailsImpl  implements UserDetailsService{
    @Autowired
    UsuarioService usuarioService ;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = this.usuarioService.getByNombreUsuario(username).get();
        return UsuarioPrincipal.build(usuario);
    }
    
}
