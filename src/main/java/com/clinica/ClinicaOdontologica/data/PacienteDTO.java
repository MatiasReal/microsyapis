package com.clinica.ClinicaOdontologica.data;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PacienteDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private int cedula;
    private String email;
    private int numeroContacto;
}
