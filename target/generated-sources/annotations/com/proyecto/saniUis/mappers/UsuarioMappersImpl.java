package com.proyecto.saniUis.mappers;

import com.proyecto.saniUis.dto.UsuarioDTO;
import com.proyecto.saniUis.model.Rol;
import com.proyecto.saniUis.model.Usuario;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-11T22:14:32-0500",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 3.33.0.v20230213-1046, environment: Java 17.0.6 (Eclipse Adoptium)"
)
public class UsuarioMappersImpl implements UsuarioMappers {

    @Override
    public UsuarioDTO usuarioToUsuarioDTO(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setDescripcionRol( usuarioRolDescripcion( usuario ) );
        usuarioDTO.setContrasena( usuario.getContrasena() );
        usuarioDTO.setCorreoElectronico( usuario.getCorreoElectronico() );
        usuarioDTO.setDocumentoIdentidad( usuario.getDocumentoIdentidad() );
        usuarioDTO.setFechaCreacion( usuario.getFechaCreacion() );
        usuarioDTO.setIdRol( usuario.getIdRol() );
        usuarioDTO.setIdUsuario( usuario.getIdUsuario() );
        usuarioDTO.setPrimerApellido( usuario.getPrimerApellido() );
        usuarioDTO.setPrimerNombre( usuario.getPrimerNombre() );
        usuarioDTO.setSegundoApellido( usuario.getSegundoApellido() );
        usuarioDTO.setSegundoNombre( usuario.getSegundoNombre() );

        return usuarioDTO;
    }

    @Override
    public Usuario usuarioDTOToUsuario(UsuarioDTO usuarioDTO) {
        if ( usuarioDTO == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setContrasena( usuarioDTO.getContrasena() );
        usuario.setCorreoElectronico( usuarioDTO.getCorreoElectronico() );
        usuario.setDocumentoIdentidad( usuarioDTO.getDocumentoIdentidad() );
        usuario.setFechaCreacion( usuarioDTO.getFechaCreacion() );
        usuario.setIdRol( usuarioDTO.getIdRol() );
        usuario.setIdUsuario( usuarioDTO.getIdUsuario() );
        usuario.setPrimerApellido( usuarioDTO.getPrimerApellido() );
        usuario.setPrimerNombre( usuarioDTO.getPrimerNombre() );
        usuario.setSegundoApellido( usuarioDTO.getSegundoApellido() );
        usuario.setSegundoNombre( usuarioDTO.getSegundoNombre() );

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
