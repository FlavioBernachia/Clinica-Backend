package com.proyectoIntegrador.proyectoIntegrador.controller;

import com.proyectoIntegrador.proyectoIntegrador.dto.TurnDTO;
import com.proyectoIntegrador.proyectoIntegrador.service.impl.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/turnos")
@CrossOrigin(origins = "http://localhost:8080")
public class TurnoController {
    @Autowired
    private TurnoService service;

    // Guardar turno
    @PostMapping
    public void postTurno(@RequestBody TurnDTO turnoDto) {
        service.save(turnoDto);
    }

    // buscar todo
    @GetMapping
    public List<TurnDTO> getAll() {
        return service.findAll();
    }

    // buscar por id
    @GetMapping(path = "/{id}")
    public ResponseEntity<TurnDTO> getById(@PathVariable Integer id) {
        TurnDTO turnoResponse = service.findById(id);
        return ResponseEntity.ok(turnoResponse);
    }

    // borrar por id
    @DeleteMapping(path = "/{id}")
    public void deleteById(@PathVariable Integer id)  {
        service.deleteById(id);
    }

    // modificar por id
    @PutMapping(path = "/{id}")
    public void update(@PathVariable Integer id, @RequestBody TurnDTO turnoDto) {
        turnoDto.setId(id);
        service.update(turnoDto);
    }
}
