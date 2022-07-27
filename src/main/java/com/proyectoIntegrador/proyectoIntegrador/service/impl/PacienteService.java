package com.proyectoIntegrador.proyectoIntegrador.service.impl;


import com.proyectoIntegrador.proyectoIntegrador.controller.exceptions.ResourceNotFoundExceptions;
import com.proyectoIntegrador.proyectoIntegrador.entities.Paciente;
import com.proyectoIntegrador.proyectoIntegrador.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {
    @Autowired
    PacienteRepository pacienteRepository;

    // Create method crud
    //guardar
    public Paciente save(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }
    //Buscar por id
    public Paciente findById(Integer id) {
        return pacienteRepository.findById(id).orElse(null);
    }
    //borrar por id
    public void deleteById(Integer id) throws  ResourceNotFoundExceptions {
        if (findById(id) == null){
            throw new ResourceNotFoundExceptions("No se encontro el  paciente con id: " + id);
        }
        pacienteRepository.deleteById(id);
    }
    //modificar por id
    public void update(Paciente paciente) throws ResourceNotFoundExceptions {
       if (findById(paciente.getId()) == null){
           throw new ResourceNotFoundExceptions("No se encontro el  paciente con id: " + paciente.getId());
       }
        pacienteRepository.save(paciente);
    }
    //buscar todos
    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }
}