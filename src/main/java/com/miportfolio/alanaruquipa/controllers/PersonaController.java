/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.alanaruquipa.controllers;

import com.miportfolio.alanaruquipa.entity.Persona;
import com.miportfolio.alanaruquipa.interfaces.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
/**
 *
 * @author Usuario
 */
@RestController
@CrossOrigin(origins = "https://frontend-6ad62.web.app")
//@CrossOrigin(origins = "http://localhost:4200")



@RequestMapping("/persona")

public class PersonaController {
     @Autowired
     IPersonaService personaService;
     
     @GetMapping("/all")
     public List<Persona> getPersonas(){
         return this.personaService.getPersonas();
     }
     
     @GetMapping("/get/{id}")
     public Persona getPersonaId(@PathVariable("id") Long id){
         return this.personaService.getPersonaId(id);
     }
     
    @PreAuthorize("hasAuthority('ADMIN')")
     @PostMapping("/post")
     public String saveUser(@RequestBody Persona persona){
         this.personaService.savePersona(persona);
         return "Creado con exito";
     }
     
    @PreAuthorize("hasAuthority('ADMIN')")
     @DeleteMapping("/delete/{id}")
     public String deleteUser(@PathVariable("id")Long id){
         this.personaService.deletePersona(id);
         return "Se elimino con exito";
     }
     
     
     @PostMapping("/editar/{id}")
     public String updateUser(@PathVariable("id")Long id,
             @RequestParam("nombre")String nombre,
             @RequestParam("descripcion")String descripcion){
         
         Persona persona = this.personaService.getPersonaId(id);
         persona.setId(id);
         persona.setNombre(nombre);
         persona.setDescripcion(descripcion);
         //persona.setImagen(imagen);
         
         this.personaService.savePersona(persona);
         
         return "La persona se actualizo con exito";
     }
}
