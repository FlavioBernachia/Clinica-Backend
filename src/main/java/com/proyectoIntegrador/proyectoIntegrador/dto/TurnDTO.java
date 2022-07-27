package com.proyectoIntegrador.proyectoIntegrador.dto;

import com.proyectoIntegrador.proyectoIntegrador.entities.Odontologo;
import com.proyectoIntegrador.proyectoIntegrador.entities.Paciente;

import java.time.LocalDateTime;

public class TurnDTO {
    private Integer id;
    private LocalDateTime horaYFecha;
    private Paciente paciente;
    private Odontologo odontologo;

    public Integer getId() {
        return id;
    }

    public LocalDateTime getHoraYFecha() {
        return horaYFecha;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
