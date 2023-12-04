package com.proyecto.saniUis.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto.saniUis.dto.UsuarioDTO;
import com.proyecto.saniUis.mappers.UsuarioMappers;
import com.proyecto.saniUis.mappers.UsuarioMappersImpl;
import com.proyecto.saniUis.model.Usuario;
import com.proyecto.saniUis.service.interfaces.IUsuarioService;

@RestController
@CrossOrigin(origins = "**", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/usuario")
public class UsuarioController {

    IUsuarioService iUsuarioService;

    @PostMapping("/insert")
    public  ResponseEntity<UsuarioDTO> createUsuario(@RequestBody UsuarioDTO usuarioDTO) {

        UsuarioDTO usuarioDTOCreated = UsuarioMappersImpl.INSTANCE.usuarioToUsuarioDTO(iUsuarioService.createUsuario(usuarioDTO));

        return new ResponseEntity<>(usuarioDTOCreated, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<UsuarioDTO> updateUsuario(@RequestBody UsuarioDTO usuarioDTO) {

        UsuarioDTO usuarioDTOUpdate= UsuarioMappersImpl.INSTANCE.usuarioToUsuarioDTO(iUsuarioService.updateUsuario(usuarioDTO));

        if(usuarioDTOUpdate != null){
            return new ResponseEntity<>(usuarioDTOUpdate, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody UsuarioDTO loginRequest) {
        UsuarioDTO usuarioLogin = UsuarioMappersImpl.INSTANCE.usuarioToUsuarioDTO(iUsuarioService.login(loginRequest));
        if (usuarioLogin != null) {
            // Devolver el DTO del usuario en la respuesta con el estado OK
            return ResponseEntity.ok(usuarioLogin);
        }
    
        // Devolver un objeto JSON con el mensaje de error
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"message\": \"Credenciales inválidas\"}");
    }
    
    


    @GetMapping("/all")
    public ResponseEntity<List<UsuarioDTO>> getUsuarios(){
        List<Usuario> listaUsuarios = iUsuarioService.getAllUsuarios();
        if(listaUsuarios.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listaUsuarios.stream().map(UsuarioMappers.INSTANCE
        ::usuarioToUsuarioDTO).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<UsuarioDTO> getById(@PathVariable(value = "id", required = true) Long aId){
        Usuario usuario = iUsuarioService.findById(aId);
        if(usuario ==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(UsuarioMappers.INSTANCE.usuarioToUsuarioDTO(usuario), HttpStatus.OK);
    }
    @DeleteMapping("/id/{id}")
    public ResponseEntity<Object> deleteUsuario(@PathVariable(value = "id", required = true) Long aId) {
        Usuario usuario = iUsuarioService.deleteUsuario(aId);
        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body("{\"message\": \"No existe el usuario con el id ingresado\"}");
        }
        
        // Crear un objeto JSON para devolver como respuesta
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> jsonResponse = new HashMap<>();
        jsonResponse.put("message", "Se ha eliminado el registro");
        
        return ResponseEntity.status(HttpStatus.OK).body(jsonResponse);
    }

    @Autowired
    public UsuarioController(IUsuarioService iUsuarioService) {
        this.iUsuarioService = iUsuarioService;
    }

}
