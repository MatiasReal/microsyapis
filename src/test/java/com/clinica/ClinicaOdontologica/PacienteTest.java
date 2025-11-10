package com.clinica.ClinicaOdontologica;

import com.clinica.ClinicaOdontologica.dao.BD;
import com.clinica.ClinicaOdontologica.dao.PacienteDAOH2;
import com.clinica.ClinicaOdontologica.model.Domicilio;
import com.clinica.ClinicaOdontologica.model.Paciente;
import com.clinica.ClinicaOdontologica.service.PacienteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class PacienteTest {

//    public interface IDao<T> {
//
//        Void guardar (T t);
//
//        Void eliminar(int id);
//
//        Void actualizar(T t);
            @Test
            public void actualizar(){
                BD.crearTablas();
                PacienteService pacienteService = new PacienteService(new PacienteDAOH2());
                Domicilio domicilio = new Domicilio(1, "", 12, "", "");
                LocalDate date = LocalDate.now();
                Paciente pacienteAntes = new Paciente(1, "Mamamam", "asasas", 232323,date, domicilio, "amsmas@gmail.com", 1212212121);
                pacienteService.actualizar(pacienteAntes);
                Paciente pacienteDespues = pacienteService.buscar(pacienteAntes.getId());
                Assertions.assertEquals(pacienteAntes.getNombre(), pacienteDespues.getNombre());
            }
//
//        T buscar(int id);
            @Test
            public void buscarPaciente(){
                //dado
                BD.crearTablas();
                PacienteService pacienteService = new PacienteService(new PacienteDAOH2());
                //cuando

                Paciente paciente = pacienteService.buscar(2);

                //entonces

                Assertions.assertTrue(paciente!=null);

            }
//
//        T buscarColumna(String columna, String valor);
//
//        List<T> buscarTodos();
//    }





}
