package com.proyecto.saniUis.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Setter
@Getter
public class TipoMedicamentoDTO {

    private Long idTipoMedicamento;
    private String descripcion;
    private LocalDateTime fechaCreacion;
}
