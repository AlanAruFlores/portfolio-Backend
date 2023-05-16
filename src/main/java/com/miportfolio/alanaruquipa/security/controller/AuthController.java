/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.alanaruquipa.security.controller;

import com.miportfolio.alanaruquipa.security.dto.JwtDTO;
import com.miportfolio.alanaruquipa.security.dto.LoginUsuario;
import com.miportfolio.alanaruquipa.security.dto.NuevoUsuario;
import com.miportfolio.alanaruquipa.security.entity.Rol;
import com.miportfolio.alanaruquipa.security.entity.Usuario;
import com.miportfolio.alanaruquipa.security.enums.RolEnum;
import com.miportfolio.alanaruquipa.security.jwt.JwtProvider;
import com.miportfolio.alanaruquipa.security.service.RolService;
import com.miportfolio.alanaruquipa.security.service.UsuarioService;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Usuario
 */
@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "https://frontend-6ad62.web.app")
public class AuthController {
    
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    AuthenticationManager authenticationManager;   
 
    @Autowired
    UsuarioService usuarioService;
    
    @Autowired
    RolService rolService;
    
    @Autowired
    JwtProvider providerJwt;
    
    @PostMapping("/post")
    public  ResponseEntity<?> crearUsuario(@Valid @RequestBody NuevoUsuario usuarioNuevo, BindingResult result){
        
        if(result.hasErrors())
            return new ResponseEntity(new Message("Hubo un error en el registro del usuario"),HttpStatus.BAD_REQUEST);
        
        if(usuarioService.existsByNombreUsuario(usuarioNuevo.getNombreUsuario()))
            return new ResponseEntity(new Message("Existe el nombre de usuario "),HttpStatus.BAD_REQUEST);
        if(usuarioService.existsByMail(usuarioNuevo.getMail()))
            return new ResponseEntity(new Message("Existe el mail del usuario"),HttpStatus.BAD_REQUEST);

        Usuario usuarioCreado = new Usuario(usuarioNuevo.getNombre(), usuarioNuevo.getNombreUsuario(), usuarioNuevo.getMail(),
        passwordEncoder.encode(usuarioNuevo.getContrasenia())); 
        
        Set<Rol> roles = new HashSet<>();
        
        roles.add(rolService.getRolNombre(RolEnum.USER).get());
        
        if(usuarioNuevo.getRoles().contains("ADMIN")){
            roles.add(rolService.getRolNombre(RolEnum.ADMIN).get());
        }
        usuarioCreado.setSetRoles(roles);
        usuarioService.saveUsuario(usuarioCreado);
        return new ResponseEntity(new Message("Se registro el usuario"),HttpStatus.CREATED);
    }
    
    
    @PostMapping("/login")
    public ResponseEntity<JwtDTO> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult result){
        if(result.hasErrors())
            new ResponseEntity(new Message("Campos no validos"), HttpStatus.BAD_REQUEST);
        
        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(),
        loginUsuario.getContrasenia()));
        
        SecurityContextHolder.getContext().setAuthentication(auth);
        
        String jwt = providerJwt.generateToken(auth);
        
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        
        JwtDTO jwtdto = new JwtDTO(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        
        return new ResponseEntity(jwtdto,HttpStatus.OK);
        
    }
    
}
