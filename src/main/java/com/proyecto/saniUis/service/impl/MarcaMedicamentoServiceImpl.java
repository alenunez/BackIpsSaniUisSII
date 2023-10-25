package com.proyecto.saniUis.service.impl;


import com.proyecto.saniUis.dto.MarcaMedicamentoDTO;
import com.proyecto.saniUis.mappers.MarcaMedicamentoMapper;
import com.proyecto.saniUis.model.MarcaMedicamento;
import com.proyecto.saniUis.repository.MarcaMedicamentoRepository;
import com.proyecto.saniUis.service.interfaces.IMarcaMedicamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MarcaMedicamentoServiceImpl implements IMarcaMedicamentoService {

    MarcaMedicamentoRepository marcaMedicamentoRepository;

    LocalDateTime today = LocalDateTime.now();

    @Override
    public MarcaMedicamento createMarcaMedicamento(MarcaMedicamentoDTO marcaMedicamentoDTO) {
        MarcaMedicamento marcaMedicamentoToCreated = MarcaMedicamentoMapper.INSTANCE.toEntity(marcaMedicamentoDTO);
        marcaMedicamentoToCreated.setFechaCreacion(today);
        return marcaMedicamentoRepository.save(marcaMedicamentoToCreated);
    }

    @Override
    public List<MarcaMedicamento> getAllMarcaMedicamentos() {
        return marcaMedicamentoRepository.findAll();
    }

    @Override
    public MarcaMedicamento findById(Long id) {
        return marcaMedicamentoRepository.findById(id).orElse(null);
    }



    public MarcaMedicamento updateMarcaMedicamento(MarcaMedicamentoDTO marcaMedicamentoDTO) {
        Optional<MarcaMedicamento> optionalMarcaMedicamento = marcaMedicamentoRepository.findById(marcaMedicamentoDTO.getIdMarcaMedicamento());
        if (optionalMarcaMedicamento.isPresent()) {
            MarcaMedicamento marcaMedicamento = optionalMarcaMedicamento.get();
            // Actualizar los campos necesarios del usuario

            marcaMedicamento.setDescripcion(marcaMedicamentoDTO.getDescripcion());
            // Guardar los cambios en la base de datos
            return marcaMedicamentoRepository.save(marcaMedicamento);

        } else {
            return null;
        }
    }

    @Override
    public MarcaMedicamento deleteMarcaMedicamento(Long id){
        MarcaMedicamento marcaMedicamento = marcaMedicamentoRepository.findById(id).orElseThrow(null);
        if(marcaMedicamento != null){
            marcaMedicamentoRepository.delete(marcaMedicamento);
            return marcaMedicamento;
        }
        return null;
    }

    @Autowired
    public MarcaMedicamentoServiceImpl(MarcaMedicamentoRepository marcaMedicamentoRepository) {
        this.marcaMedicamentoRepository = marcaMedicamentoRepository;
    }
}
