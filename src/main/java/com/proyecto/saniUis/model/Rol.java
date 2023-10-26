package com.proyecto.saniUis.model;

import java.time.LocalDateTime;

import javax.persistence.*;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "GENERAL", name = "ROL")
public class Rol {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ROL")
    private Long idRol;

    @Enumerated(EnumType.STRING)
    private RolNombre rolNombre;
    
    @Column(name = "FECHA_CREACION")
    private LocalDateTime fechaCreacion;


    public Rol(@NotNull RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }
}
