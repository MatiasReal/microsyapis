package com.clinica.ClinicaOdontologica.service;

import com.clinica.ClinicaOdontologica.entity.Odontologo;
import com.clinica.ClinicaOdontologica.entity.Paciente;
import com.clinica.ClinicaOdontologica.repository.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService implements IService<Odontologo, Long>{
    @Autowired
    OdontologoRepository odontologoRepository;

    @Override
    public List<Odontologo> findAll() {
        return odontologoRepository.findAll();
    }

    @Override
    public Optional<Odontologo> findById(Long id) {
        return odontologoRepository.findById(id);
    }

    @Override
    public void saveOne(Odontologo odontologo) {
        Odontologo o = odontologoRepository.save(odontologo);
        System.out.println("Odontologo (" + o.getNombre() + ") persistido en la base de datos.");
    }

    @Override
    public void updateOne(Odontologo odontologo) {
        Odontologo o = odontologoRepository.save(odontologo);
        System.out.println("Odontologo (" + o.getNombre() + ") actualizado.");
    }

    @Override
    public void deleteOne(Long id) {
        odontologoRepository.deleteById(id);
    }
}
