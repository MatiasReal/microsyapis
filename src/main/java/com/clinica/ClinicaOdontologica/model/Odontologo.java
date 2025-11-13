package com.clinica.ClinicaOdontologica.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Odontologo {
    private Integer id, matricula;
    private String nombre, apellido;

    public Odontologo(Integer id, String nombre, String apellido, Integer matricula) {
        this(nombre, apellido, matricula);
        this.id = id;
    }

    public Odontologo(String nombre, String apellido, Integer matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }


}
