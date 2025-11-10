package com.clinica.ClinicaOdontologica;

import com.clinica.ClinicaOdontologica.dao.BD;
import com.clinica.ClinicaOdontologica.dao.OdontologoDAOH2;
import com.clinica.ClinicaOdontologica.model.Odontologo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class OdontologoDAOH2Test {

    private OdontologoDAOH2 odontologoDao = new OdontologoDAOH2();

    // ID del odontólogo precargado en BD.java: Artur Wolfe (ID 1)
    private final int ID_EXISTENTE = 1;

    //-------------------------------------------------------------------------
    // 1. GUARDAR (Debe insertar un nuevo registro)
    //-------------------------------------------------------------------------

    @Test
    public void testGuardar() {
        //dado
        BD.crearTablas(); // Limpia y carga los datos iniciales
        Odontologo nuevoOdontologo = new Odontologo(0, "Laura", "Gomez", 9876);

        //cuando
        odontologoDao.guardar(nuevoOdontologo);
        // Si guardar funciona correctamente, el nuevo ID debería ser 2 (después de Artur Wolfe, ID 1)
        Odontologo odontologoGuardado = odontologoDao.buscar(2);

        //entonces
        // Verifica que el objeto retornado no sea nulo y que el nombre sea correcto
        Assertions.assertNotNull(odontologoGuardado);
        Assertions.assertEquals("Laura", odontologoGuardado.getNombre());
    }

    //-------------------------------------------------------------------------
    // 2. BUSCAR POR ID
    //-------------------------------------------------------------------------

    @Test
    public void testBuscarPorId() {
        //dado
        BD.crearTablas();

        //cuando
        // Busca al odontólogo precargado (Artur Wolfe, ID 1)
        Odontologo odontologoEncontrado = odontologoDao.buscar(ID_EXISTENTE);

        //entonces
        Assertions.assertNotNull(odontologoEncontrado);
        Assertions.assertEquals("Artur", odontologoEncontrado.getNombre());
    }

    //-------------------------------------------------------------------------
    // 3. ACTUALIZAR
    //-------------------------------------------------------------------------

    @Test
    public void testActualizar() {
        //dado
        BD.crearTablas();
        // Buscamos el objeto existente para actualizarlo
        Odontologo odontologoOriginal = odontologoDao.buscar(ID_EXISTENTE);
        odontologoOriginal.setNombre("Arthur");
        odontologoOriginal.setMatricula(111222);

        //cuando
        odontologoDao.actualizar(odontologoOriginal);
        Odontologo odontologoActualizado = odontologoDao.buscar(ID_EXISTENTE);

        //entonces
        Assertions.assertNotNull(odontologoActualizado);
        Assertions.assertEquals("Arthur", odontologoActualizado.getNombre());
        Assertions.assertEquals(111222, odontologoActualizado.getMatricula().intValue());
    }

    //-------------------------------------------------------------------------
    // 4. ELIMINAR
    //-------------------------------------------------------------------------

    @Test
    public void testEliminar() {
        //dado
        BD.crearTablas();

        //cuando
        odontologoDao.eliminar(ID_EXISTENTE);
        Odontologo odontologoEliminado = odontologoDao.buscar(ID_EXISTENTE);

        //entonces
        // Verifica que el odontólogo ya no exista en la BD
        Assertions.assertNull(odontologoEliminado);
    }

    //-------------------------------------------------------------------------
    // 5. BUSCAR POR COLUMNA
    //-------------------------------------------------------------------------

    @Test
    public void testBuscarColumna() {
        //dado
        BD.crearTablas();

        //cuando
        // Buscamos por el campo APELLIDO y el valor Wolfe
        Odontologo odontologoPorColumna = odontologoDao.buscarColumna("APELLIDO", "Wolfe");

        //entonces
        Assertions.assertNotNull(odontologoPorColumna);
        Assertions.assertEquals("Artur", odontologoPorColumna.getNombre());
        Assertions.assertEquals(125678, odontologoPorColumna.getMatricula().intValue());
    }

    //-------------------------------------------------------------------------
    // 6. BUSCAR TODOS
    //-------------------------------------------------------------------------

    @Test
    public void testBuscarTodos() {
        //dado
        BD.crearTablas();

        //cuando
        List<Odontologo> listaOdontologos = odontologoDao.buscarTodos();

        //entonces
        // Verifica que se haya encontrado al menos 1 (Artur Wolfe)
        Assertions.assertNotNull(listaOdontologos);
        Assertions.assertTrue(listaOdontologos.size() >= 1);
        Assertions.assertEquals("Artur", listaOdontologos.get(0).getNombre());
    }
}