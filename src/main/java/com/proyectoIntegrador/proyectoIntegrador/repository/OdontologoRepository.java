package com.proyectoIntegrador.proyectoIntegrador.repository;

import com.proyectoIntegrador.proyectoIntegrador.entities.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface OdontologoRepository extends JpaRepository<Odontologo, Integer> {
}
