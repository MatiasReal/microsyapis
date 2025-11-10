package com.clinica.ClinicaOdontologica.repository;

import com.clinica.ClinicaOdontologica.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


// TODO: Como buscar con metodos custom
@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}
