package com.proyecto.saniUis.mappers;

import com.proyecto.saniUis.dto.RolDTO;
import com.proyecto.saniUis.model.Rol;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RolMapper {

    RolMapper INSTANCE = Mappers.getMapper(RolMapper.class);

    @Mapping(source = "idRol", target = "idRol")
    RolDTO rolToRolDTO(Rol rol);

    @Mapping(source = "idRol", target = "idRol")
    Rol rolDTOToRol(RolDTO rolDTO);
}
