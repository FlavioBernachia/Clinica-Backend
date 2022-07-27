package com.proyectoIntegrador.proyectoIntegrador.service.impl;


import com.proyectoIntegrador.proyectoIntegrador.controller.exceptions.ResourceNotFoundExceptions;
import com.proyectoIntegrador.proyectoIntegrador.entities.Odontologo;
import com.proyectoIntegrador.proyectoIntegrador.repository.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoService {
    @Autowired
    OdontologoRepository odontologoRepository;
    //Create CRUD
    //Guardar
    public Odontologo save(Odontologo odontologo) {
        return odontologoRepository.save(odontologo);
    }
    //Buscar por id
    public Odontologo findById(Integer id) {
        return odontologoRepository.findById(id).orElse(null);
    }
    //Buscar todos
    public List<Odontologo> findAll() {
        return odontologoRepository.findAll();
    }
    //borrar por id
    public void deleteById(Integer id) throws ResourceNotFoundExceptions {
        if (findById(id) == null){
            throw new ResourceNotFoundExceptions("No se encontro el odontologo con id: " + id);
        }
        odontologoRepository.deleteById(id);
    }
    //modificar por id
    public void update(Odontologo odontologo) throws ResourceNotFoundExceptions {
        if (findById(odontologo.getId()) == null){
            throw new ResourceNotFoundExceptions("No se encontro el odontologo con id: " + odontologo.getId());
        }
        odontologoRepository.saveAndFlush(odontologo);
}

}
