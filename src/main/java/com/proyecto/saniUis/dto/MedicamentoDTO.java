package com.proyecto.saniUis.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MedicamentoDTO {

    private Long idMedicamento;
    private String descripcion;
    private Long idMarcaMedicamento;
    private Long idTipoMedicamento;
    private String descripcionMarcaMedicamento;
    private String descripcionTipoMedicamento;
    private LocalDateTime fechaCreacion;



}
