package com.clinica.ClinicaOdontologica.controller;

import com.clinica.ClinicaOdontologica.data.PacienteDTO;
import com.clinica.ClinicaOdontologica.data.TurnoDTO;
import com.clinica.ClinicaOdontologica.entity.Paciente;
import com.clinica.ClinicaOdontologica.entity.Turno;
import com.clinica.ClinicaOdontologica.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    @Autowired
    private TurnoService turnoService;

    @GetMapping
    public ResponseEntity<List<TurnoDTO>> findAll() {

        List<Turno> turnoEntidad = turnoService.findAll();
        List<TurnoDTO> turnosDTO = new ArrayList<>();
        for (Turno turno : turnoEntidad) {
            turnosDTO.add(turnoService.convertEntityToDTO(turno));
        }
        return ResponseEntity.ok(turnosDTO);
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody TurnoDTO turnoDTO) {
        try {
            Turno turno = turnoService.convertDTOToEntity(turnoDTO);
            turnoService.saveOne(turno);
            return ResponseEntity.ok("Turno creado exitosamente");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping("/{idParam}")
    public ResponseEntity<String> delete(@PathVariable String idParam) {
        try {
            Long id = Long.parseLong(idParam);
            turnoService.deleteOne(id);
            return ResponseEntity.ok("Paciente eliminado exitosamente");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping(path = "/{idParam}", consumes = "multipart/form-data")
    public ResponseEntity<String> update(@PathVariable String idParam, @RequestBody TurnoDTO turnoDTO) {
        try {
            Optional<Turno> turnoViejo = turnoService.findById(Long.parseLong(idParam));
            if (turnoViejo.isPresent()) {
                Turno turno = turnoService.convertDTOToEntity(turnoDTO);
                turno.setId(turnoViejo.get().getId());
                turnoService.updateOne(turno);
                return ResponseEntity.ok("Turno creado exitosamente");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
