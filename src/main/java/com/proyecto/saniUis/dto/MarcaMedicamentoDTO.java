package com.proyecto.saniUis.dto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class MarcaMedicamentoDTO {

    private Long idMarcaMedicamento;
    private String descripcion;
    private LocalDateTime fechaCreacion;

}
