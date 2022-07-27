package com.proyectoIntegrador.proyectoIntegrador.controller;

import com.proyectoIntegrador.proyectoIntegrador.controller.exceptions.ResourceNotFoundExceptions;
import com.proyectoIntegrador.proyectoIntegrador.entities.Odontologo;
import com.proyectoIntegrador.proyectoIntegrador.service.impl.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
@CrossOrigin(origins = "http://localhost:8080")
public class OdontologoController {

    @Autowired
    private OdontologoService service;
    //Traer todos los odontologos
    @GetMapping
    public List<Odontologo> getAll() {
        return service.findAll();
    }
    //Traer un odontologo por su id
    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> getById(@PathVariable int id) {
        Odontologo odontologoResponse = service.findById(id);
        if (odontologoResponse == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(odontologoResponse);
    }
    // Borrar por ID
    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id) throws ResourceNotFoundExceptions {
        ResponseEntity response = null;
        service.deleteById(id);
        return ResponseEntity.ok("Odontologo eliminado");
    }

    //Guardar odontologo
    @PostMapping
    public void postOdontologo(@RequestBody Odontologo odontologo) {
        service.save(odontologo);
    }
    //Modificar odontólogo
    @PutMapping
    public void putOdontologo(@PathVariable Integer id,@RequestBody Odontologo odontologo) throws ResourceNotFoundExceptions {
        odontologo.setId(id);
        service.update(odontologo);
    }
    @ExceptionHandler
    public ResponseEntity<String> handleException(ResourceNotFoundExceptions e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

}

