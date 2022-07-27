package com.proyectoIntegrador.proyectoIntegrador.service;

import com.proyectoIntegrador.proyectoIntegrador.entities.Paciente;

import java.util.List;

public interface PacienteServiceInterface {

    //Realizar el crud de paciente

    // guardar
    Paciente save(Paciente paciente);

    // modificar
    void update(Paciente paciente);

    // borrar por id
    void deleteById(Integer id);

    // traer todos
    List<Paciente> findAll();

    // buscar por id
    Paciente findById(Integer id);


}