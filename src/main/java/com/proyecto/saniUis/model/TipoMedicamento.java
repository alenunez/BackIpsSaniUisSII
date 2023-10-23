package com.proyecto.saniUis.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "GENERAL", name = "TIPO_MEDICAMENTO")
public class TipoMedicamento {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TIPO_MEDICAMENTO")
    private Long idTipoMedicamento;

    @Column(name = "DESCRIPCION", nullable = false)
    private String descripcion;

    @Column(name = "FECHA_CREACION")
    private LocalDateTime fechaCreacion;




}