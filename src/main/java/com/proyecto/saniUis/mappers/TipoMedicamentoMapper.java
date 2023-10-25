package com.proyecto.saniUis.mappers;

import com.proyecto.saniUis.dto.TipoMedicamentoDTO;
import com.proyecto.saniUis.model.TipoMedicamento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper()
public interface TipoMedicamentoMapper {


    TipoMedicamentoMapper INSTANCE = Mappers.getMapper(TipoMedicamentoMapper.class);

    @Mapping(source = "idTipoMedicamento", target = "idTipoMedicamento")
    TipoMedicamentoDTO toDto(TipoMedicamento tipoMedicamento);

    @Mapping(source = "idTipoMedicamento", target = "idTipoMedicamento")
    TipoMedicamento toEntity(TipoMedicamentoDTO tipoMedicamentoDTO);
}
