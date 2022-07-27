package com.proyectoIntegrador.proyectoIntegrador.service;

import com.proyectoIntegrador.proyectoIntegrador.dto.TurnDTO;

import java.util.List;

public interface TurnoServiceInterface {

    void save(TurnDTO turnoDTO);

    List<TurnDTO> findAll();

    TurnDTO findById(Integer id);

    void deleteById(Integer id);

    void update(TurnDTO turnoDto);

}