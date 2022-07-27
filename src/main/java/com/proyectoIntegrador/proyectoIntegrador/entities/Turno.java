package com.proyectoIntegrador.proyectoIntegrador.entities;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="turno")
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "horaYFecha")
    private LocalDateTime horaYFecha;


    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false, referencedColumnName = "id")
    private Paciente paciente;

    // Turnos a odontólogos → varios turnos a un mismo odontólogo
    @ManyToOne // Por defecto es eager
    @JoinColumn(name = "odontologo_id", referencedColumnName = "id")
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
