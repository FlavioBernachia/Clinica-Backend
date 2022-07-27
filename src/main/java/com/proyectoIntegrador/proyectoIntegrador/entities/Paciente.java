package com.proyectoIntegrador.proyectoIntegrador.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Pacientes")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "dni")
    private String dni;
    @Column(name = "fechaNacimiento")
    private String fechaNacimiento;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "obraSocial")
    private String obraSocial;
    @Column(name = "numeroAfiliado")
    private String numeroAfiliado;
    @Column(name = "numeroSeguro")
    private String numeroSeguro;
    @Column(name = "email")
    private String email;
    @Column(name = "fechaDeIngreso")
    private LocalDate fechaDeIngreso;

    @OneToOne(cascade = {CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.PERSIST})
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Domicilio domicilio;

    @OneToMany(mappedBy = "paciente")
    @JsonIgnore
    private Set<Turno> listadoTurnos = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getObraSocial() {
        return obraSocial;
    }

    public String getNumeroAfiliado() {
        return numeroAfiliado;
    }

    public String getNumeroSeguro() {
        return numeroSeguro;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getFechaDeIngreso() {
        return fechaDeIngreso;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFechaDeIngreso(LocalDate fechaDeIngreso) {
        this.fechaDeIngreso = fechaDeIngreso;
    }
}
