package com.proyecto.saniUis.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto.saniUis.dto.MedicamentoDTO;
import com.proyecto.saniUis.mappers.MedicamentoMapper;
import com.proyecto.saniUis.model.Medicamento;
import com.proyecto.saniUis.service.interfaces.IMedicamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/medicamento")
public class MedicamentoController {
    IMedicamentoService iMedicamentoService;

    @PostMapping("/insert")
    public ResponseEntity<MedicamentoDTO> createMedicamento(@RequestBody MedicamentoDTO medicamentoDTO) {

        MedicamentoDTO medicamentoDTOCreated = MedicamentoMapper.INSTANCE.toDto(iMedicamentoService.createMedicamento(medicamentoDTO));

        return new ResponseEntity<>(medicamentoDTOCreated, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<MedicamentoDTO> updateMedicamento(@RequestBody MedicamentoDTO medicamentoDTO) {

        MedicamentoDTO medicamentoDTOUpdate= MedicamentoMapper.INSTANCE.toDto(iMedicamentoService.updateMedicamento(medicamentoDTO));

        if(medicamentoDTOUpdate != null){
            return new ResponseEntity<>(medicamentoDTOUpdate, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<MedicamentoDTO>> getMedicamentos(){
        List<Medicamento> listaMedicamentos = iMedicamentoService.getAllMedicamentos();
        if(listaMedicamentos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listaMedicamentos.stream().map(MedicamentoMapper.INSTANCE
                ::toDto).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<MedicamentoDTO> getById(@PathVariable(value = "id", required = true) Long aId){
        Medicamento medicamento = iMedicamentoService.findById(aId);
        if(medicamento ==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(MedicamentoMapper.INSTANCE.toDto(medicamento), HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Object> deleteMedicamento(@PathVariable(value = "id", required = true) Long aId) {
        Medicamento medicamento = iMedicamentoService.deleteMedicamento(aId);
        if (medicamento == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body("{\"message\": \"No existe el medicamento con el id ingresado\"}");
        }

        // Crear un objeto JSON para devolver como respuesta
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> jsonResponse = new HashMap<>();
        jsonResponse.put("message", "Se ha eliminado el registro");

        return ResponseEntity.status(HttpStatus.OK).body(jsonResponse);
    }

    @Autowired
    public MedicamentoController(@Qualifier("medicamentoServiceImpl") IMedicamentoService iMedicamentoService) {
        this.iMedicamentoService = iMedicamentoService;
    }

}