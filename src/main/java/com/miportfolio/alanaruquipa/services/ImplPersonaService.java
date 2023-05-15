/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.alanaruquipa.services;

import com.miportfolio.alanaruquipa.entity.Persona;
import com.miportfolio.alanaruquipa.interfaces.IPersonaService;
import com.miportfolio.alanaruquipa.repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class ImplPersonaService implements IPersonaService {
    @Autowired
    IPersonaRepository personaRepository;
    
    
    @Override
    public void savePersona(Persona persona) {
        personaRepository.save(persona);
    }

    @Override
    public Persona getPersonaId(Long id) {
        return personaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Persona> getPersonas() {
        return personaRepository.findAll();
    }

    @Override
    public void deletePersona(Long id) {
        personaRepository.deleteById(id);
    }
    
}
