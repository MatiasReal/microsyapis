package com.clinica.ClinicaOdontologica.data;

import com.clinica.ClinicaOdontologica.entity.Odontologo;
import com.clinica.ClinicaOdontologica.entity.Paciente;
import com.clinica.ClinicaOdontologica.repository.OdontologoRepository;
import com.clinica.ClinicaOdontologica.repository.PacienteRepository;
import com.clinica.ClinicaOdontologica.service.OdontologoService;
import com.clinica.ClinicaOdontologica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent; // Importar el evento
import org.springframework.context.event.EventListener; // Importar la anotación
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Seeder {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private OdontologoRepository odontologoRepository;


    @EventListener(ContextRefreshedEvent.class) // Listener de contexto de Spring esté listo
    public void init() {
        populatePacientes();
        populateOdontologos();
    }

    public void populatePacientes() {
        if (pacienteRepository.count() == 0) {
            List<Paciente> datosPacientes = List.of(
                    new Paciente("Matias", "Real", 1234, "matias@gmail.com", 1111111111),
                    new Paciente("Pepe", "Argento", 2222, "pepeargento@gmail.com", 22222222),
                    new Paciente("Manuel", "Lechero", 3333, "manuel@gmail.com", 33333333)
            );

            for (Paciente p : datosPacientes) {
                pacienteRepository.save(p);
                System.out.println("Paciente: " + p.getNombre() + " Guardado con exito...");
            }
        }
    }

    public void populateOdontologos() {
        if (odontologoRepository.count() == 0) {
            List<Odontologo> datosOdontologos = List.of(
                    new Odontologo("Diego", "Romero", 1234567)
            );

            for (Odontologo o : datosOdontologos) {
                odontologoRepository.save(o);
                System.out.println("Odontologo: " + o.getNombre() + " Guardado con exito...");
            }
        }
    }
}