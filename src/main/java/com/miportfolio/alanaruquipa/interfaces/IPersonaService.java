/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.alanaruquipa.interfaces;

import com.miportfolio.alanaruquipa.entity.Persona;
import java.util.List;
/**
 *
 * @author Usuario
 */
public interface IPersonaService {
    public void savePersona(Persona persona);
    public Persona getPersonaId(Long id);
    public List<Persona> getPersonas();
    public void deletePersona(Long id);
}
