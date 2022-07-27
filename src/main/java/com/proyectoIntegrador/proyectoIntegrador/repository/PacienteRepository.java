package com.proyectoIntegrador.proyectoIntegrador.repository;


import com.proyectoIntegrador.proyectoIntegrador.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

}
