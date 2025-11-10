package com.clinica.ClinicaOdontologica.service;

import com.clinica.ClinicaOdontologica.entity.Paciente;
import com.clinica.ClinicaOdontologica.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService implements IService<Paciente> {
    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }

    @Override
    public void saveOne(Paciente paciente) {
        pacienteRepository.save(paciente);
    }
}
