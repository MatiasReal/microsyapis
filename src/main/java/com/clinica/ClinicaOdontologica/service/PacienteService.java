package com.clinica.ClinicaOdontologica.service;

import com.clinica.ClinicaOdontologica.data.OdontologoDTO;
import com.clinica.ClinicaOdontologica.data.PacienteDTO;
import com.clinica.ClinicaOdontologica.entity.Odontologo;
import com.clinica.ClinicaOdontologica.entity.Paciente;
import com.clinica.ClinicaOdontologica.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService implements IService<Paciente, Long> {
    @Autowired
    private PacienteRepository pacienteRepository;


    public PacienteDTO convertEntityToDTO(Paciente paciente) {
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setNombre(paciente.getNombre());
        pacienteDTO.setApellido(paciente.getApellido());
        pacienteDTO.setEmail(paciente.getEmail());
        pacienteDTO.setNumeroContacto(paciente.getNumeroContacto());
        pacienteDTO.setCedula(paciente.getCedula());
        return pacienteDTO;
    }

    @Override
    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }

    @Override
    public Optional<Paciente> findById(Long id) {
        return pacienteRepository.findById(id);
    }

    @Override
    public void saveOne(Paciente paciente) {
        Paciente p = pacienteRepository.save(paciente);
        System.out.println("Paciente (" + p.getNombre() + ") persistido en la base de datos.");
    }

    @Override
    public void deleteOne(Long id) {
        pacienteRepository.deleteById(id);
    }

    @Override
    public void updateOne(Paciente paciente) {
        Paciente p = pacienteRepository.save(paciente);
        System.out.println("Paciente (" + p.getNombre() + ") actualizado.");
    }
}
