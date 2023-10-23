package com.proyecto.saniUis.service.interfaces;
import java.util.List;

import com.proyecto.saniUis.dto.MedicamentoDTO;
import com.proyecto.saniUis.model.Medicamento;
import org.springframework.stereotype.Service;

@Service
public interface IMedicamentoService {

    public Medicamento createMedicamento(MedicamentoDTO medicamentoDTO);

    public List<Medicamento> getAllMedicamentos();

    public Medicamento findById(Long id);

    public Medicamento updateMedicamento(MedicamentoDTO medicamentoDTO);

    public Medicamento deleteMedicamento(Long id);

}