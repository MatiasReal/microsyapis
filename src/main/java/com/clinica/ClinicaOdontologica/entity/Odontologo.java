package com.clinica.ClinicaOdontologica.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "odontologos")
public class Odontologo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private int matricula;

    public Odontologo(String nombre, String apellido, int matricula) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }
}
