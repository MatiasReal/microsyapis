package com.clinica.ClinicaOdontologica.repository;

import com.clinica.ClinicaOdontologica.entity.Odontologo;
import com.clinica.ClinicaOdontologica.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OdontologoRepository extends JpaRepository<Odontologo, Long> {
}
