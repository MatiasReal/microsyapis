package com.clinica.ClinicaOdontologica.controller;

import com.clinica.ClinicaOdontologica.entity.Odontologo;
import com.clinica.ClinicaOdontologica.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    private OdontologoService odontologoService;

    @GetMapping
    public ResponseEntity<List<Odontologo>> findAll() {
        return ResponseEntity.ok(odontologoService.findAll());
    }

    @PostMapping(consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<String> save(@RequestBody MultiValueMap<String, String> formData) {
        try {
            Odontologo odontologo = new Odontologo();
            odontologo.setNombre(formData.get("nombre-odontologo").get(0));
            odontologo.setApellido(formData.get("apellido-odontologo").get(0));
            String matricula;
            if(!(matricula = formData.get("matricula-odontologo").get(0)).isEmpty()){
                odontologo.setMatricula(Integer.parseInt(matricula));
            }
            odontologoService.saveOne(odontologo);
            return ResponseEntity.ok("Odontólogo creado exitosamente");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping("/{idParam}")
    public ResponseEntity<String> delete(@PathVariable String idParam,@RequestBody MultiValueMap<String, String> formData) {
        try {
            Long id = Long.parseLong(idParam);
            odontologoService.deleteOne(id);
            return ResponseEntity.ok("Odontólogo eliminado exitosamente");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping(path = "/{idParam}", consumes = "multipart/form-data")
    public ResponseEntity<String> update(@PathVariable String idParam, @RequestParam MultiValueMap<String, String> formData) {
        try {
            Optional<Odontologo> odontologoEncontrado = odontologoService.findById(Long.parseLong(idParam));

            if(odontologoEncontrado.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Odontólogo no encontrado");
            }
            Odontologo odontologo = odontologoEncontrado.get();
            odontologo.setNombre(formData.get("nombre-odontologo").get(0));
            odontologo.setApellido(formData.get("apellido-odontologo").get(0));
            String matricula;
            if(!(matricula = formData.get("matricula-odontologo").get(0)).isEmpty()){
                odontologo.setMatricula(Integer.parseInt(matricula));
            }
            odontologoService.updateOne(odontologo);

            return ResponseEntity.ok("Odontólogo actualizado exitosamente");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}