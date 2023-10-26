package com.proyecto.saniUis.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;


import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
@Table(schema = "GENERAL", name = "USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "ID_USUARIO")
    public UUID idUsuario;

    @Column(name = "PRIMER_NOMBRE", nullable = false)
    private String primerNombre;

    @Column(name = "CONTRASENA", nullable = false)
    private String contrasena;

    @Column(name = "SEGUNDO_NOMBRE")
    private String segundoNombre;

    @Column(name = "PRIMER_APELLIDO", nullable = false)
    private String primerApellido;

    @Column(name = "SEGUNDO_APELLIDO")
    private String segundoApellido;

    @Column(name = "DOCUMENTO_IDENTIDAD", unique = true, nullable = false)
    private Integer documentoIdentidad;

    @Column(name = "FECHA_CREACION")
    private LocalDateTime fechaCreacion;

    @Column(name = "CORREO_ELECTRONICO", unique = true, nullable = false)
    private String correoElectronico;

    // Columnas llaves foráneas
    @Column(name = "ID_ROL", nullable = false)
    private Long idRol;

    // Datos que se trae por la foránea
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ROL", insertable = false, updatable = false)
    private Rol rol;

}
