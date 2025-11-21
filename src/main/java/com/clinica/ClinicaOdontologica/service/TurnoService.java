package com.clinica.ClinicaOdontologica.service;

import com.clinica.ClinicaOdontologica.data.PacienteDTO;
import com.clinica.ClinicaOdontologica.data.TurnoDTO;
import com.clinica.ClinicaOdontologica.entity.Odontologo;
import com.clinica.ClinicaOdontologica.entity.Paciente;
import com.clinica.ClinicaOdontologica.entity.Turno;
import com.clinica.ClinicaOdontologica.repository.PacienteRepository;
import com.clinica.ClinicaOdontologica.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoService implements IService<Turno, Long> {
    @Autowired
    private TurnoRepository turnoRepository;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private OdontologoService dontologoService;
    @Autowired
    private OdontologoService odontologoService;


    public TurnoDTO convertEntityToDTO(Turno turno) {
        TurnoDTO turnoDTO = new TurnoDTO();
        Optional<Paciente> paciente = pacienteService.findById(turno.getPaciente().getId());
        Optional<Odontologo> odontologo = dontologoService.findById(turno.getOdontologo().getId());
        if(paciente.isEmpty() || odontologo.isEmpty()) {
            throw new EmptyResultDataAccessException(1);
        }
        turnoDTO.setFechaHora(turno.getFechaHora());
        turnoDTO.setPaciente(pacienteService.convertEntityToDTO(paciente.get()));
        turnoDTO.setOdontologo(odontologoService.convertEntityToDTO(odontologo.get()));
        return turnoDTO;
    }

    @Override
    public List<Turno> findAll() {
        return turnoRepository.findAll();
    }

    @Override
    public Optional<Turno> findById(Long id) {
        return turnoRepository.findById(id);
    }

    @Override
    public void saveOne(Turno turno) {
        turnoRepository.save(turno);
        System.out.println("Turno persistido en la base de datos.");
    }

    @Override
    public void updateOne(Turno turno) {
        turnoRepository.save(turno);
        System.out.println("Turno actualizado en la base de datos.");
    }

    @Override
    public void deleteOne(Long id) {
        turnoRepository.deleteById(id);
    }


    public Turno convertDTOToEntity(TurnoDTO turnoDTO) {
        Turno turno = new Turno();
        Optional<Paciente> paciente = pacienteService.findById(turnoDTO.getPaciente().getId());
        Optional<Odontologo> odontologo = dontologoService.findById(turnoDTO.getOdontologo().getId());
        if(paciente.isEmpty() || odontologo.isEmpty()) {
            throw new EmptyResultDataAccessException(1);
        }
        turno.setPaciente(paciente.get());
        turno.setOdontologo(odontologo.get());
        turno.setFechaHora(turnoDTO.getFechaHora());
        return turno;
    }
}
