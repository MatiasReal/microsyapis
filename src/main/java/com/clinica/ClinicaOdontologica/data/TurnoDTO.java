package com.clinica.ClinicaOdontologica.data;
import lombok.*;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TurnoDTO {
    private PacienteDTO paciente;
    private OdontologoDTO odontologo;
    private LocalDateTime fechaHora;
}
