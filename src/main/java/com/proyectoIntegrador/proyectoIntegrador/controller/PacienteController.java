package com.proyectoIntegrador.proyectoIntegrador.controller;


import com.proyectoIntegrador.proyectoIntegrador.controller.exceptions.ResourceNotFoundExceptions;
import com.proyectoIntegrador.proyectoIntegrador.entities.Paciente;
import com.proyectoIntegrador.proyectoIntegrador.service.impl.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
@CrossOrigin(origins = "http://localhost:8080")
public class PacienteController {
    @Autowired
    private PacienteService service;

    //Crear post Guardar paciente
    @PostMapping
    public ResponseEntity<String> postPaciente(@RequestBody Paciente paciente) {
        if (bodyValidation(paciente)) {
            service.save(paciente);
            return ResponseEntity.ok("Paciente guardado");
        }
        return ResponseEntity.badRequest().body("Error al guardar paciente");
    }

    //Traer todos
    @GetMapping
    public List<Paciente> getAll() {
        return service.findAll();
    }

    //Traer por id
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getById(@PathVariable Integer id) {
        Paciente pacienteResponse = service.findById(id);
        if (pacienteResponse != null) {
            return ResponseEntity.ok(pacienteResponse);
        }
        return ResponseEntity.notFound().build();
    }

    //Borrar por id (Usamos Exception)
    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id) throws ResourceNotFoundExceptions {
        ResponseEntity responseEntity = null;
        service.deleteById(id);
        return ResponseEntity.ok("Paciente eliminado");
    }

    // modificar por id
    @PutMapping(path = "/{id}")
    public void putById(@PathVariable Integer id, @RequestBody Paciente paciente) throws ResourceNotFoundExceptions {
        paciente.setId(id);
        service.update(paciente);
    }

    //Validaciones
    private boolean bodyValidation(Paciente paciente) {
        return paciente.getNombre() != null && paciente.getApellido() != null && paciente.getDni() != null && paciente.getTelefono() != null && paciente.getDireccion() != null && paciente.getEmail() != null;
    }
    @ExceptionHandler
    public ResponseEntity<String> handleException(ResourceNotFoundExceptions e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

}
