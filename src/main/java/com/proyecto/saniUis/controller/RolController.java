package com.proyecto.saniUis.controller;
import java.util.List;

import java.util.stream.Collectors;

import com.proyecto.saniUis.dto.RolDTO;
import com.proyecto.saniUis.mappers.RolMapper;
import com.proyecto.saniUis.model.Rol;
import com.proyecto.saniUis.service.interfaces.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/rol")
public class RolController {

    IRolService iRolService;

    @GetMapping("/all")
    public ResponseEntity<List<RolDTO>> getRoles(){
        List<Rol> listaRoles = iRolService.getAllRol();
        if(listaRoles.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listaRoles.stream().map(RolMapper.INSTANCE
                ::rolToRolDTO).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<RolDTO> getById(@PathVariable(value = "id", required = true) Long aId){
        Rol rol = iRolService.findById(aId);
        if(rol ==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(RolMapper.INSTANCE.rolToRolDTO(rol), HttpStatus.OK);
    }



    @Autowired
    public RolController(@Qualifier("rolServiceImpl") IRolService iRolService) {
        this.iRolService = iRolService;
    }
}
