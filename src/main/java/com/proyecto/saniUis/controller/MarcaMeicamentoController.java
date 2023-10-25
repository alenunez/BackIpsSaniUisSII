package com.proyecto.saniUis.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto.saniUis.dto.MarcaMedicamentoDTO;
import com.proyecto.saniUis.mappers.MarcaMedicamentoMapper;
import com.proyecto.saniUis.model.MarcaMedicamento;
import com.proyecto.saniUis.service.interfaces.IMarcaMedicamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/marcaMedicamento")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class MarcaMeicamentoController {

    IMarcaMedicamentoService iMarcaMedicamentoService;

    @PostMapping("/insert")
    public ResponseEntity<MarcaMedicamentoDTO> createMarcaMedicamento(@RequestBody MarcaMedicamentoDTO marcaMedicamentoDTO) {

        MarcaMedicamentoDTO marcaMedicamentoDTOCreated = MarcaMedicamentoMapper.INSTANCE.toDto(iMarcaMedicamentoService.createMarcaMedicamento(marcaMedicamentoDTO));

        return new ResponseEntity<>(marcaMedicamentoDTOCreated, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<MarcaMedicamentoDTO> updateMarcaMedicamento(@RequestBody MarcaMedicamentoDTO marcaMedicamentoDTO) {

        MarcaMedicamentoDTO marcaMedicamentoDTOUpdate= MarcaMedicamentoMapper.INSTANCE.toDto(iMarcaMedicamentoService.updateMarcaMedicamento(marcaMedicamentoDTO));

        if(marcaMedicamentoDTOUpdate != null){
            return new ResponseEntity<>(marcaMedicamentoDTOUpdate, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



    @GetMapping("/all")
    public ResponseEntity<List<MarcaMedicamentoDTO>> getMarcaMedicamentos(){
        List<MarcaMedicamento> listaMarcaMedicamentos = iMarcaMedicamentoService.getAllMarcaMedicamentos();
        if(listaMarcaMedicamentos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listaMarcaMedicamentos.stream().map(MarcaMedicamentoMapper.INSTANCE
                ::toDto).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<MarcaMedicamentoDTO> getById(@PathVariable(value = "id", required = true) Long aId){
        MarcaMedicamento marcaMedicamento = iMarcaMedicamentoService.findById(aId);
        if(marcaMedicamento ==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(MarcaMedicamentoMapper.INSTANCE.toDto(marcaMedicamento), HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Object> deleteMarcaMedicamento(@PathVariable(value = "id", required = true) Long aId) {
        MarcaMedicamento marcaMedicamento = iMarcaMedicamentoService.deleteMarcaMedicamento(aId);
        if (marcaMedicamento == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body("{\"message\": \"No existe la marca medicamento con el id ingresado\"}");
        }

        // Crear un objeto JSON para devolver como respuesta
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> jsonResponse = new HashMap<>();
        jsonResponse.put("message", "Se ha eliminado el registro");

        return ResponseEntity.status(HttpStatus.OK).body(jsonResponse);
    }

    @Autowired
    public void MarcaMedicamentoController(IMarcaMedicamentoService iMarcaMedicamentoService) {
        this.iMarcaMedicamentoService = iMarcaMedicamentoService;
    }
}
