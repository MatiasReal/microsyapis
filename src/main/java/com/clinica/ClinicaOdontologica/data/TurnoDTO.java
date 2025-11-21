package com.clinica.ClinicaOdontologica.data;
import lombok.*;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TurnoDTO {
    private Long pacienteId;

    private Long odontologoId;
    private LocalDateTime fechaHora;
}
