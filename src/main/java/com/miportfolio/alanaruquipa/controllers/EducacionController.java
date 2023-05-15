/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.alanaruquipa.controllers;

import com.miportfolio.alanaruquipa.dto.DtoEducacion;
import com.miportfolio.alanaruquipa.entity.Educacion;
import com.miportfolio.alanaruquipa.interfaces.IEducacionService;
import com.miportfolio.alanaruquipa.security.controller.Message;
import com.oracle.webservices.internal.api.databinding.Databinding;
import java.util.List;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Usuario
 */
@RestController
@RequestMapping("/educacion")
@CrossOrigin(origins = "http://localhost:4200")
public class EducacionController {
    @Autowired 
    IEducacionService serviceEducacion;
    
    @GetMapping("/all")
    public ResponseEntity<List<Educacion>> getList(){
        return new ResponseEntity(this.serviceEducacion.getAll(), HttpStatus.OK);
    }
    
    @PostMapping("/post")
    public ResponseEntity<?> saveEducacionNueva(@RequestBody DtoEducacion educacionDTO){
        if(Strings.isBlank(educacionDTO.getNombre()))
            return new ResponseEntity(new Message("ERROR: NO PUEDE ESTAR EL NOMBRE VACIO"),HttpStatus.BAD_REQUEST);
        if(this.serviceEducacion.existsByNombre(educacionDTO.getNombre()))
            return new ResponseEntity(new Message("ERROR: YA EXISTE DICHO TITULO"), HttpStatus.BAD_GATEWAY);
        Educacion educacionNueva = new Educacion(educacionDTO.getNombre(), educacionDTO.getDescripcion(), educacionDTO.getFechaInicio(),
        educacionDTO.getFechaFinalizacion());
        
        this.serviceEducacion.saveEducacion(educacionNueva);
        return new ResponseEntity(new Message("SE REGISTRO LA EDUCACION NUEVA"),HttpStatus.OK);
    }
    
    @PostMapping("/update")
    public ResponseEntity<?> updateEducacion(@RequestParam("id") int id, @RequestBody DtoEducacion educacionDTO){
        if(!this.serviceEducacion.existsById(id))
            return new ResponseEntity(new Message("ERROR: NO EXISTE EL ID DE LA EDUCACION A ACTUALIZAR"),HttpStatus.BAD_REQUEST);
        if(this.serviceEducacion.existsByNombre(educacionDTO.getNombre()) && this.serviceEducacion.getByNombre(educacionDTO.getNombre()).get().getId() != id)
            return new ResponseEntity(new Message("ERROR: NO SE PUEDE PORQUE YA EXISTE UNA EDUCACION CON EL MISMO NOMBRE"), HttpStatus.BAD_REQUEST);
        if(Strings.isBlank(educacionDTO.getNombre()))
            return new ResponseEntity(new Message("ERROR: NO PUEDE ESTAR VACIO EL NOMBRE"), HttpStatus.BAD_REQUEST);
        
        Educacion educacionActualizada = new Educacion(id, educacionDTO.getNombre(), educacionDTO.getDescripcion(), educacionDTO.getFechaInicio(), educacionDTO.getFechaFinalizacion());
        this.serviceEducacion.saveEducacion(educacionActualizada);
        return new ResponseEntity(new Message("SE ACEPTO LOS CAMBIOS"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteEducacion(@RequestParam("id") int id){
        if(!this.serviceEducacion.existsById(id))
            return new ResponseEntity(new Message("ERROR: NO EXISTE LA EDUCACION A ELIMINAR"), HttpStatus.BAD_REQUEST);
        this.serviceEducacion.deleteById(id);
        return new ResponseEntity(new Message("SE ELIMINO CON EXITO"), HttpStatus.OK);
    }
    
}
