package com.proyecto.saniUis.dto;

import com.proyecto.saniUis.model.RolNombre;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Setter@Getter
public class RolDTO {

    private Long idRol;
    private RolNombre rolNombre;
    private LocalDateTime fechaCreacion;

}
