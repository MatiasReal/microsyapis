package com.clinica.ClinicaOdontologica.model;

import java.time.LocalDate;

public class Paciente
{

    private int id;

    private String nombre;
    private String apellido;

    private LocalDate fechaIngreso;

    private int cedula;


    private Domicilio domicilio;

    private String email;


    private int numeroContacto;

    public Paciente(int id, String nombre, String apellido, int numeroCalle, LocalDate fechaIngreso, Domicilio domicilio, String email, int numeroContacto) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = numeroCalle;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
        this.email = email;
        this.numeroContacto = numeroContacto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int numeroCalle) {
        this.cedula = numeroCalle;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumeroContacto() {
        return numeroContacto;
    }

    public void setNumeroContacto(int numeroContacto) {
        this.numeroContacto = numeroContacto;
    }
}
