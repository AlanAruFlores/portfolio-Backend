/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.alanaruquipa.controllers;

import com.miportfolio.alanaruquipa.entity.SoftSkill;
import com.miportfolio.alanaruquipa.interfaces.ISoftSkillService;
import com.miportfolio.alanaruquipa.security.controller.Message;
import java.util.List;
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
@RequestMapping("/ss")
@CrossOrigin(origins="https://frontend-6ad62.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class SoftSkillController {
    @Autowired
    ISoftSkillService service;
    
    @GetMapping("/all")
    public ResponseEntity<List<SoftSkill>> getAll(){
        return new ResponseEntity(this.service.getAll(), HttpStatus.OK);
    }
    
    @GetMapping("/get")
    public ResponseEntity<?> getById(@RequestParam("id") int id){
        if(!this.service.existsById(id))
            return new ResponseEntity(new Message("NO EXISTE EL ID"), HttpStatus.BAD_REQUEST);
        return new ResponseEntity(this.service.getById(id), HttpStatus.OK);
    }
    
    @PostMapping("/post")
    public ResponseEntity<?> saveSkill(@RequestBody SoftSkill skill){
        if(this.service.existsByNombre(skill.getNombre()))
            return new ResponseEntity(new Message("YA EXISTE EL NOMBRE"), HttpStatus.BAD_REQUEST);
        
        this.service.save(skill);
        return new ResponseEntity(new Message("SE CREO CON EXITO"), HttpStatus.CREATED);
    }
    
    @PostMapping("/update")
    public ResponseEntity<?> updateSkill(@RequestParam("id") int id, @RequestBody SoftSkill skill){
        if(!this.service.existsById(id))
            return new ResponseEntity(new Message("NO EXISTE EL ID A ACTUALIZAR"), HttpStatus.BAD_REQUEST);
        if(this.service.existsByNombre(skill.getNombre()) && this.service.getByNombre(skill.getNombre()).get().getId() != id)
            return new ResponseEntity(new Message("YA EXISTE EL NOMBRE "), HttpStatus.BAD_REQUEST);
        
        skill.setId(id);
        this.service.save(skill);
        return new ResponseEntity(new Message("SE CREO CON EXITO"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteSkill(@RequestParam("id")int id){
        if(!this.service.existsById(id))
            return new ResponseEntity(new Message("NO EXISTE EL ID A ELIMINAR"), HttpStatus.BAD_REQUEST);    
        this.service.delete(id);
        return new ResponseEntity(new Message("SE ELIMINO CON EXITO"), HttpStatus.OK);
    }
    
}
