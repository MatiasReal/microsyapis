package com.clinica.ClinicaOdontologica.data;

import com.clinica.ClinicaOdontologica.entity.Odontologo;
import com.clinica.ClinicaOdontologica.entity.Paciente;
import com.clinica.ClinicaOdontologica.entity.Turno;
import com.clinica.ClinicaOdontologica.repository.OdontologoRepository;
import com.clinica.ClinicaOdontologica.repository.PacienteRepository;
import com.clinica.ClinicaOdontologica.repository.TurnoRepository;
import com.clinica.ClinicaOdontologica.service.OdontologoService;
import com.clinica.ClinicaOdontologica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent; // Importar el evento
import org.springframework.context.event.EventListener; // Importar la anotación
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class Seeder {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private OdontologoRepository odontologoRepository;

    @Autowired
    private TurnoRepository turnoRepository;


    @EventListener(ContextRefreshedEvent.class) // Listener de contexto de Spring esté listo
    public void init() {
        populatePacientes();
        populateOdontologos();
        populateTurnos();
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

    public void populateTurnos() {
        if (turnoRepository.count()==0)
        {
            LocalDateTime fechaActual = LocalDateTime.now();
            Optional<Paciente> paciente=pacienteRepository.findById(1L);
            Optional<Odontologo> odontologo=odontologoRepository.findById(1L);
            if(paciente.isEmpty() || odontologo.isEmpty()) {
                throw new RuntimeException("No se puede guardar el turno");
            }
            Paciente p = paciente.get();
            Odontologo o = odontologo.get();

            List<Turno> datosTurnos = List.of(
              new Turno(p, o, fechaActual)
            );
            for (Turno t: datosTurnos){
                turnoRepository.save(t);
                System.out.println("Turno guardado con exito!");
            }
        }


    }
}