package com.clinica.ClinicaOdontologica;

import com.clinica.ClinicaOdontologica.dao.BD;
import com.clinica.ClinicaOdontologica.dao.PacienteDAOH2;
import com.clinica.ClinicaOdontologica.model.Domicilio;
import com.clinica.ClinicaOdontologica.model.Paciente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class PacienteDAOH2Test {

    // Instancia del DAO que vamos a probar
    private PacienteDAOH2 pacienteDao = new PacienteDAOH2();

    // Domicilio de prueba para crear nuevos pacientes (se asume que existe en la BD con ID 1 o 2)
    private Domicilio domicilioBase = new Domicilio(1, "siempre viva", 723, "Springfield", "USA");

    //-------------------------------------------------------------------------
    // 1. GUARDAR
    //-------------------------------------------------------------------------

    @Test
    public void testGuardar() {
        //dado
        BD.crearTablas();
        LocalDate fecha = LocalDate.now();
        Paciente nuevoPaciente = new Paciente(
                0, // ID 0 ya que se auto-incrementará
                "Lisa",
                "Simpson",
                1234,
                fecha,
                domicilioBase,
                "lisa@springfield.com",
                555555
        );

        //cuando
        // En la implementación real, guardar(t) debería devolver el objeto con el ID generado.
        pacienteDao.guardar(nuevoPaciente);
        // Asumimos que el ID generado es 3 (Homero 1, Marge 2)
        Paciente pacienteGuardado = pacienteDao.buscar(3);

        //entonces
        Assertions.assertNotNull(pacienteGuardado);
        Assertions.assertEquals("Lisa", pacienteGuardado.getNombre());
    }

    //-------------------------------------------------------------------------
    // 2. BUSCAR POR ID
    //-------------------------------------------------------------------------

    @Test
    public void testBuscarPorId() {
        //dado
        BD.crearTablas(); // Carga los pacientes Homero (ID 1) y Marge (ID 2)

        //cuando
        Paciente pacienteEncontrado = pacienteDao.buscar(2);

        //entonces
        // Verifica que Marge Simpson (ID 2) fue encontrada
        Assertions.assertNotNull(pacienteEncontrado);
        Assertions.assertEquals("Marge", pacienteEncontrado.getNombre());
    }

    //-------------------------------------------------------------------------
    // 3. ELIMINAR
    //-------------------------------------------------------------------------

    @Test
    public void testEliminar() {
        //dado
        BD.crearTablas(); // Carga los datos
        int idAEliminar = 1;

        //cuando
        pacienteDao.eliminar(idAEliminar);
        Paciente pacienteEliminado = pacienteDao.buscar(idAEliminar);

        //entonces
        // Verifica que el paciente con ID 1 (Homero) ya no existe
        Assertions.assertNull(pacienteEliminado);
    }

    //-------------------------------------------------------------------------
    // 4. ACTUALIZAR
    //-------------------------------------------------------------------------

    @Test
    public void testActualizar() {
        //dado
        BD.crearTablas();
        // Buscamos a Marge (ID 2) para asegurarnos de que existe
        Paciente pacienteOriginal = pacienteDao.buscar(2);

        // Creamos una nueva versión del paciente con datos modificados
        pacienteOriginal.setNombre("Marjorie");
        pacienteOriginal.setEmail("marjorie@nueva.com");

        //cuando
        pacienteDao.actualizar(pacienteOriginal);
        Paciente pacienteActualizado = pacienteDao.buscar(2);

        //entonces
        // Verifica que el nombre y el email se hayan actualizado
        Assertions.assertNotNull(pacienteActualizado);
        Assertions.assertEquals("Marjorie", pacienteActualizado.getNombre());
        Assertions.assertEquals("marjorie@nueva.com", pacienteActualizado.getEmail());
    }

    //-------------------------------------------------------------------------
    // 5. BUSCAR POR COLUMNA
    //-------------------------------------------------------------------------

    @Test
    public void testBuscarColumna() {
        //dado
        BD.crearTablas();

        //cuando
        // Buscamos a Homero por email
        Paciente pacientePorEmail = pacienteDao.buscarColumna("EMAIL", "homero@disney.com");

        // Buscamos a Marge por apellido
        Paciente pacientePorApellido = pacienteDao.buscarColumna("APELLIDO", "Simpson");


        //entonces
        // Verifica que Homero sea encontrado por su email
        Assertions.assertNotNull(pacientePorEmail);
        Assertions.assertEquals("Homero", pacientePorEmail.getNombre());

        // Verifica que Marge sea encontrada por su apellido (solo el primer resultado)
        Assertions.assertNotNull(pacientePorApellido);
        Assertions.assertEquals("Homero", pacientePorApellido.getNombre()); // Homero tiene ID 1 y se encuentra primero
    }

    //-------------------------------------------------------------------------
    // 6. BUSCAR TODOS
    //-------------------------------------------------------------------------

    @Test
    public void testBuscarTodos() {
        //dado
        BD.crearTablas(); // Carga los datos iniciales (2 pacientes)

        //cuando
        List<Paciente> listaPacientes = pacienteDao.buscarTodos();

        //entonces
        // Verifica que la lista no sea nula y contenga la cantidad esperada (2)
        Assertions.assertNotNull(listaPacientes);
        Assertions.assertEquals(2, listaPacientes.size());
    }
}