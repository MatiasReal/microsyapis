package com.clinica.ClinicaOdontologica.entity;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "pacientes")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private int cedula;
    private String email;
    private int numeroContacto;

    public Paciente(String nombre, String apellido, int cedula, String email, int numeroContacto) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.email = email;
        this.numeroContacto = numeroContacto;
    }
}
