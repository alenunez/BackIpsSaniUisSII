package com.proyecto.saniUis.service.impl;

import com.proyecto.saniUis.dto.RolDTO;
import com.proyecto.saniUis.mappers.RolMapper;
import com.proyecto.saniUis.model.Rol;
import com.proyecto.saniUis.repository.RolRepository;
import com.proyecto.saniUis.service.interfaces.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RolServiceImpl implements IRolService {

    RolRepository rolRepository;

    LocalDateTime today = LocalDateTime.now();

    @Override
    public Rol createRol(RolDTO rolDTO) {
        Rol rolToCreated = RolMapper.INSTANCE.rolDTOToRol(rolDTO);
        rolToCreated.setFechaCreacion(today);
        return rolRepository.save(rolToCreated);
    }

    @Override
    public List<Rol> getAllRol() {
        return rolRepository.findAll();
    }

    @Override
    public Rol findById(Long id) {
        return rolRepository.findById(id).orElse(null);
    }

    @Autowired
    public RolServiceImpl(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }
    public void save(Rol rol){
        rol.setFechaCreacion(today);
        rolRepository.save(rol);
    }
}
