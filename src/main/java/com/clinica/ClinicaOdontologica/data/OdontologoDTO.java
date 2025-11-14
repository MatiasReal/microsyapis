package com.clinica.ClinicaOdontologica.data;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OdontologoDTO {


    private String nombre;
    private String apellido;
    private int matricula;


}
