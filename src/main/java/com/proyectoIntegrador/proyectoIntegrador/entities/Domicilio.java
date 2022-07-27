package com.proyectoIntegrador.proyectoIntegrador.entities;

import javax.persistence.*;

@Entity
@Table(name = "domicilio")
public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "calle")
    private String calle;
    @Column(name = "numero")
    private Integer numero;
    @Column(name = "piso")
    private Integer piso;
    @Column(name = "departamento")
    private String depto;
    @Column(name ="localidad")
    private String localidad;
    @Column(name = "provincia")
    private String provincia;
    @Column(name = "pais")
    private String pais;
    @Column(name = "codigoPostal")
    private String codigoPostal;

    public Integer getId() {
        return id;
    }

    public String getCalle() {
        return calle;
    }

    public Integer getNumero() {
        return numero;
    }

    public Integer getPiso() {
        return piso;
    }

    public String getDepto() {
        return depto;
    }

    public String getLocalidad() {
        return localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getPais() {
        return pais;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
