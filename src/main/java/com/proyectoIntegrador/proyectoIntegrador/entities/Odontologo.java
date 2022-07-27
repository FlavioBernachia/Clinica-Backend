package com.proyectoIntegrador.proyectoIntegrador.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="odontologos")
public class Odontologo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="apellido")
    private String apellido;
    @Column(name="matricula")
    private String matricula;
@OneToMany(mappedBy="odontologo")

@JsonIgnore
private Set<Turno> ListadoTurnos = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
