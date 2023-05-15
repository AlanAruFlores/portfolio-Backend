/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.alanaruquipa.controllers;

import com.miportfolio.alanaruquipa.dto.DtoExperiencia;
import com.miportfolio.alanaruquipa.entity.Experiencia;
import com.miportfolio.alanaruquipa.interfaces.IExperienciaService;
import com.miportfolio.alanaruquipa.security.controller.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.apache.logging.log4j.util.Strings;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Usuario
 */
@RestController
@RequestMapping("/experiencia")
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienciaController {    

    @Autowired
    IExperienciaService serviceExperiencia;

    @GetMapping("/all")
    public ResponseEntity<List<Experiencia>> getAll() {
        return new ResponseEntity(this.serviceExperiencia.getAll(), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<?> saveExperiencia(@RequestBody DtoExperiencia experiencia) {
        if (Strings.isBlank(experiencia.getNombre())) 
            return new ResponseEntity(new Message("EL NOMBRE NO PUEDE ESTAR VACIO"), HttpStatus.BAD_REQUEST);
        if (serviceExperiencia.existsByNombre(experiencia.getNombre())) 
            return new ResponseEntity(new Message("NO PUEDE HABER 2 EXPERIENCIAS IGUALES"), HttpStatus.BAD_REQUEST);
        
        Experiencia expNueva = new Experiencia(experiencia.getNombre(),experiencia.getDescripcion(),experiencia.getFechaInicio(), experiencia.getFechaFinalizacion());
        this.serviceExperiencia.saveExperiencia(expNueva);
        return new ResponseEntity(new Message("SE REGISTRO CON EXITO LA EXPERIENCIA"), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateExperiencia(@RequestParam("id") int id, @RequestBody DtoExperiencia experiencia) {
        if(!(this.serviceExperiencia.existsById(id)))
            return new ResponseEntity(new Message("NO EXISTE LA EXPERIENCIA"),HttpStatus.BAD_REQUEST);
        if(this.serviceExperiencia.existsByNombre(experiencia.getNombre()) && this.serviceExperiencia.getByNombre(experiencia.getNombre())
                .get().getId() != id)
            return new ResponseEntity(new Message("YA EXISTE ESA EXPERIENCIA"), HttpStatus.BAD_REQUEST);
        if (Strings.isBlank(experiencia.getNombre()))
            return new ResponseEntity(new Message("EL NOMBRE NO PUEDE ESTAR VACIO"), HttpStatus.BAD_REQUEST);
     
        Experiencia expActualizada = this.serviceExperiencia.getById(id).get();
        expActualizada.setNombre(experiencia.getNombre());
        expActualizada.setDescripcion(experiencia.getDescripcion());
        expActualizada.setFechaInicio(experiencia.getFechaInicio());
        expActualizada.setFechaFinalizacion(experiencia.getFechaFinalizacion());
        this.serviceExperiencia.saveExperiencia(expActualizada);
        
        return new ResponseEntity(new Message("SE ACTUALIZO CON EXITO"), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteExperiencia(@RequestParam("id") int id){
        if(!this.serviceExperiencia.existsById(id))
            return new ResponseEntity(new Message("NO EXISTE LA EXPERIENCIA"),HttpStatus.BAD_REQUEST);
        this.serviceExperiencia.deleteExperiencia(id);
        return new ResponseEntity(new Message("ELIMINADO CON EXITO"), HttpStatus.OK);
    }
}
