package com.proyecto.saniUis.mappers;

import com.proyecto.saniUis.dto.UsuarioDTO;
import com.proyecto.saniUis.model.Rol;
import com.proyecto.saniUis.model.Usuario;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-23T14:10:48-0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.2 (Amazon.com Inc.)"
)
public class UsuarioMappersImpl implements UsuarioMappers {

    @Override
    public UsuarioDTO usuarioToUsuarioDTO(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setDescripcionRol( usuarioRolDescripcion( usuario ) );
        usuarioDTO.setIdUsuario( usuario.getIdUsuario() );
        usuarioDTO.setPrimerNombre( usuario.getPrimerNombre() );
        usuarioDTO.setContrasena( usuario.getContrasena() );
        usuarioDTO.setSegundoNombre( usuario.getSegundoNombre() );
        usuarioDTO.setPrimerApellido( usuario.getPrimerApellido() );
        usuarioDTO.setSegundoApellido( usuario.getSegundoApellido() );
        usuarioDTO.setDocumentoIdentidad( usuario.getDocumentoIdentidad() );
        usuarioDTO.setFechaCreacion( usuario.getFechaCreacion() );
        usuarioDTO.setCorreoElectronico( usuario.getCorreoElectronico() );
        usuarioDTO.setIdRol( usuario.getIdRol() );

        return usuarioDTO;
    }

    @Override
    public Usuario usuarioDTOToUsuario(UsuarioDTO usuarioDTO) {
        if ( usuarioDTO == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setContrasena( usuarioDTO.getContrasena() );
        usuario.setIdUsuario( usuarioDTO.getIdUsuario() );
        usuario.setPrimerNombre( usuarioDTO.getPrimerNombre() );
        usuario.setSegundoNombre( usuarioDTO.getSegundoNombre() );
        usuario.setPrimerApellido( usuarioDTO.getPrimerApellido() );
        usuario.setSegundoApellido( usuarioDTO.getSegundoApellido() );
        usuario.setDocumentoIdentidad( usuarioDTO.getDocumentoIdentidad() );
        usuario.setFechaCreacion( usuarioDTO.getFechaCreacion() );
        usuario.setCorreoElectronico( usuarioDTO.getCorreoElectronico() );
        usuario.setIdRol( usuarioDTO.getIdRol() );

        return usuario;
    }

    private String usuarioRolDescripcion(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }
        Rol rol = usuario.getRol();
        if ( rol == null ) {
            return null;
        }
        String descripcion = rol.getDescripcion();
        if ( descripcion == null ) {
            return null;
        }
        return descripcion;
    }
}
