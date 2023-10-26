package com.proyecto.saniUis.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;
@Getter
@Setter
public class UsuarioDTO {

    private UUID idUsuario;
    private String primerNombre;
    private String contrasena;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private Integer documentoIdentidad;
    private LocalDateTime fechaCreacion;
    private String correoElectronico;
    private Long idRol;
    private String descripcionRol;

  
    
}
