package com.Proyecto.BackIpsSaniUis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Proyecto.BackIpsSaniUis.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Aquí puedes agregar métodos personalizados de consulta si los necesitas

    Optional<Usuario> findByCorreoElectronico(String correoElectronico);

}

