package com.proyectoIntegrador.proyectoIntegrador.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyectoIntegrador.proyectoIntegrador.dto.TurnDTO;
import com.proyectoIntegrador.proyectoIntegrador.entities.Turno;
import com.proyectoIntegrador.proyectoIntegrador.repository.TurnoRepository;
import com.proyectoIntegrador.proyectoIntegrador.service.TurnoServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Service
public class TurnoService implements TurnoServiceInterface {
    @Autowired
    TurnoRepository turnoRepository;
    @Autowired
    ObjectMapper mapper;


    // Crear metodos crud turno DTO

    // GUARDAR
    public void save(TurnDTO turnoDto) {
        Turno turnoAGuardar = mapper.convertValue(turnoDto, Turno.class);
        turnoRepository.save(turnoAGuardar);
    }
    /* ----------------------------------------------------------------------------- */

    // BUSCAR TODOS
    public List<TurnDTO> findAll() {
        List<TurnDTO> listaTurnosDto = new ArrayList<>();
        List<Turno> listaTurnos = turnoRepository.findAll(); // findAll del JPA
        for (Turno turno : listaTurnos) {
            listaTurnosDto.add(mapper.convertValue(turno, TurnDTO.class));
        }
        return listaTurnosDto;
    }
    /* ----------------------------------------------------------------------------- */

    // BUSCAR POR ID
    public TurnDTO findById(Integer id) {
        TurnDTO encontrado = mapper.convertValue(turnoRepository.findById(id), TurnDTO.class);
        return encontrado;
    }
    /* ----------------------------------------------------------------------------- */

    // ELIMINAR POR ID
    public void deleteById(Integer id) {
        turnoRepository.deleteById(id);
    }
    /* ----------------------------------------------------------------------------- */

    // MODIFICAR POR ID
    public void update(TurnDTO turnoDto) {
        Turno turnoModificar = mapper.convertValue(turnoDto, Turno.class);
        turnoRepository.save(turnoModificar);
    }
}
