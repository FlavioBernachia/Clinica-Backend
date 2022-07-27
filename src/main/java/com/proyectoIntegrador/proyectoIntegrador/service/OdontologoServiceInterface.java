package com.proyectoIntegrador.proyectoIntegrador.service;

import com.proyectoIntegrador.proyectoIntegrador.entities.Odontologo;

import java.util.List;
import java.util.Optional;

public interface OdontologoServiceInterface {

    // guardar
    Odontologo save(Odontologo odontologo);

    // buscar todos
    List<Odontologo> findAll();

    // buscar por id
    Optional<Odontologo> findById(Integer id);

    // borrar por id
    void deleteById(Integer id);

    // modificar
    void update(Odontologo odontologo);
}
