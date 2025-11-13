package com.clinica.ClinicaOdontologica.controller;
import com.clinica.ClinicaOdontologica.entity.Paciente;
import com.clinica.ClinicaOdontologica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<List<Paciente>> findAll() {
        return ResponseEntity.ok(pacienteService.findAll());
    }

    @PostMapping(consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<String> save(@RequestBody MultiValueMap<String, String> formData) {
        try {
            Paciente paciente = new Paciente();
            paciente.setNombre(formData.get("nombre-paciente").get(0));
            paciente.setApellido(formData.get("apellido-paciente").get(0));
            paciente.setEmail(formData.get("correo-paciente").get(0));
            paciente.setCedula(Integer.parseInt(formData.get("cedula-paciente").get(0)));
            paciente.setNumeroContacto(Integer.parseInt(formData.get("telefono-paciente").get(0)));
            pacienteService.saveOne(paciente);
            return ResponseEntity.ok("Paciente creado exitosamente");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestBody MultiValueMap<String, String> formData) {
        try {
            Long id = Long.parseLong(formData.get("id-paciente").get(0));
            pacienteService.deleteOne(id);
            return ResponseEntity.ok("Paciente eliminado exitosamente");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody MultiValueMap<String, String> formData) {
        try {
            Optional<Paciente> pacienteEncontrado = pacienteService.findById(Long.parseLong(formData.get("id-paciente").get(0)));
            if(pacienteEncontrado.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente no encontrado");
            }
            Paciente paciente = pacienteEncontrado.get();
            paciente.setNombre(formData.get("nombre-paciente").get(0));
            paciente.setApellido(formData.get("apellido-paciente").get(0));
            paciente.setEmail(formData.get("correo-paciente").get(0));
            paciente.setCedula(Integer.parseInt(formData.get("cedula-paciente").get(0)));
            paciente.setNumeroContacto(Integer.parseInt(formData.get("telefono-paciente").get(0)));
            pacienteService.saveOne(paciente);
            return ResponseEntity.ok("Paciente creado exitosamente");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
