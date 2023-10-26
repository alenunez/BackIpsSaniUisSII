package com.proyecto.saniUis.mappers;

import com.proyecto.saniUis.dto.MedicamentoDTO;
import com.proyecto.saniUis.model.MarcaMedicamento;
import com.proyecto.saniUis.model.Medicamento;
import com.proyecto.saniUis.model.TipoMedicamento;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-26T08:05:48-0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.2 (Amazon.com Inc.)"
)
public class MedicamentoMapperImpl implements MedicamentoMapper {

    @Override
    public MedicamentoDTO toDto(Medicamento medicamento) {
        if ( medicamento == null ) {
            return null;
        }

        MedicamentoDTO medicamentoDTO = new MedicamentoDTO();

        medicamentoDTO.setDescripcionMarcaMedicamento( medicamentoMarcaMedicamentoDescripcion( medicamento ) );
        medicamentoDTO.setDescripcionTipoMedicamento( medicamentoTipoMedicamentoDescripcion( medicamento ) );
        medicamentoDTO.setIdMedicamento( medicamento.getIdMedicamento() );
        medicamentoDTO.setDescripcion( medicamento.getDescripcion() );
        medicamentoDTO.setIdMarcaMedicamento( medicamento.getIdMarcaMedicamento() );
        medicamentoDTO.setIdTipoMedicamento( medicamento.getIdTipoMedicamento() );
        medicamentoDTO.setFechaCreacion( medicamento.getFechaCreacion() );

        return medicamentoDTO;
    }

    @Override
    public Medicamento toEntity(MedicamentoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Medicamento medicamento = new Medicamento();

        medicamento.setFechaCreacion( dto.getFechaCreacion() );
        medicamento.setIdMedicamento( dto.getIdMedicamento() );
        medicamento.setDescripcion( dto.getDescripcion() );
        medicamento.setIdMarcaMedicamento( dto.getIdMarcaMedicamento() );
        medicamento.setIdTipoMedicamento( dto.getIdTipoMedicamento() );

        return medicamento;
    }

    private String medicamentoMarcaMedicamentoDescripcion(Medicamento medicamento) {
        if ( medicamento == null ) {
            return null;
        }
        MarcaMedicamento marcaMedicamento = medicamento.getMarcaMedicamento();
        if ( marcaMedicamento == null ) {
            return null;
        }
        String descripcion = marcaMedicamento.getDescripcion();
        if ( descripcion == null ) {
            return null;
        }
        return descripcion;
    }

    private String medicamentoTipoMedicamentoDescripcion(Medicamento medicamento) {
        if ( medicamento == null ) {
            return null;
        }
        TipoMedicamento tipoMedicamento = medicamento.getTipoMedicamento();
        if ( tipoMedicamento == null ) {
            return null;
        }
        String descripcion = tipoMedicamento.getDescripcion();
        if ( descripcion == null ) {
            return null;
        }
        return descripcion;
    }
}
