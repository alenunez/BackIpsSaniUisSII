package com.proyecto.saniUis.service.interfaces;

import com.proyecto.saniUis.dto.RolDTO;
import com.proyecto.saniUis.model.Rol;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IRolService {

    public Rol createRol(RolDTO rolDTO);

    public List<Rol> getAllRol();

    public Rol findById(Long id);
}
