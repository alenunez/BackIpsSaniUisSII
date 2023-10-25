package com.proyecto.saniUis.service.interfaces;

import com.proyecto.saniUis.dto.MarcaMedicamentoDTO;
import com.proyecto.saniUis.model.MarcaMedicamento;

import java.util.List;

public interface IMarcaMedicamentoService {

    public MarcaMedicamento createMarcaMedicamento(MarcaMedicamentoDTO marcaMedicamentoDTO);

    public List<MarcaMedicamento> getAllMarcaMedicamentos();

    public MarcaMedicamento findById(Long id);

    public MarcaMedicamento updateMarcaMedicamento(MarcaMedicamentoDTO marcaMedicamentoDTO);

    public MarcaMedicamento deleteMarcaMedicamento(Long id);

}
