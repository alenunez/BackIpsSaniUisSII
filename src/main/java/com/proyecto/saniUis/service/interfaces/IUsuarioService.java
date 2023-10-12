package com.proyecto.saniUis.service.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyecto.saniUis.dto.UsuarioDTO;
import com.proyecto.saniUis.model.Usuario;


@Service
public interface IUsuarioService {

    public Usuario createUsuario(UsuarioDTO usuarioDTO);

    public List<Usuario> getAllUsuarios();

    public Usuario findById(Long id);

    public Usuario login(UsuarioDTO usuarioDTO);

    public Usuario updateUsuario(UsuarioDTO usuarioDTO);

    public Usuario deleteUsuario(Long id);

}