package com.proyecto.saniUis.mappers;
import com.proyecto.saniUis.dto.MarcaMedicamentoDTO;
import com.proyecto.saniUis.model.MarcaMedicamento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;



@Mapper
public interface MarcaMedicamentoMapper {

    MarcaMedicamentoMapper INSTANCE = Mappers.getMapper(MarcaMedicamentoMapper.class);

    @Mapping(source = "idMarcaMedicamento", target = "idMarcaMedicamento")
    MarcaMedicamentoDTO toDto(MarcaMedicamento entidad);

    @Mapping(source = "idMarcaMedicamento", target = "idMarcaMedicamento")
    MarcaMedicamento toEntity(MarcaMedicamentoDTO dto);

}
