package com.proyecto.saniUis.service.interfaces;
import java.util.List;

import com.proyecto.saniUis.dto.TipoMedicamentoDTO;
import com.proyecto.saniUis.model.TipoMedicamento;
import org.springframework.stereotype.Service;
@Service
public interface ITipoMedicamentoService {

    public TipoMedicamento createTipoMedicamento(TipoMedicamentoDTO tipoMedicamentoDTO);

    public List<TipoMedicamento> getAllTipoMedicamentos();

    public TipoMedicamento findById(Long id);

    public TipoMedicamento updateTipoMedicamento(TipoMedicamentoDTO tipoMedicamentoDTO);

    public TipoMedicamento deleteTipoMedicamento(Long id);
}
