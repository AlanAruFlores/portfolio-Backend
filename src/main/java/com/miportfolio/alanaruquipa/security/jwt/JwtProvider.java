/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.alanaruquipa.security.jwt;

import com.miportfolio.alanaruquipa.security.entity.UsuarioPrincipal;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 *
 * @author Usuario
 */
/*Esta clase provee o crea el token*/
@Component
public class JwtProvider {
    private Logger logger =  LoggerFactory.getLogger(JwtProvider.class);
    
    
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private int expiration;
    
    public String generateToken(Authentication authentication){
        
        UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal)authentication.getPrincipal();
        
        //Retorna un string, retorna el token creado por su nombre de usuario
        return Jwts.builder().setSubject(usuarioPrincipal.getUsername())
                .setIssuedAt(new Date())//Fecha que fue emitido el token
                .setExpiration(new Date(new Date().getTime()+expiration*1000)) //Establecemos la expiracion desde la fecha de hoy
                .signWith(SignatureAlgorithm.HS512,secret)//el algoritmo y la contrasenia de ingreso 
                .compact();
        
    }
    
    public String getNombreUsuarioByToken(String token){
        //obtenemos nombre de usuario por su token, ingresamos el "secret" que es la contrasania para acceder a sus metodos
        //si esta mal entonces no podra realizar la operacion
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }
    
    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        }catch(MalformedJwtException ex){
            logger.error("Token mal estructurado");
        }catch(UnsupportedJwtException ex){
            logger.error("Token no compatible");
        }catch(ExpiredJwtException ex){
            logger.error("Token expirado");
        }catch(IllegalArgumentException ex){
            logger.error("Token vacio");
        }catch(SignatureException ex){
            logger.error("Firma no valida");
        }
        return false;
    }
}
