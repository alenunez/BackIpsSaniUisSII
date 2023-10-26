package com.proyecto.saniUis.repository;

import com.proyecto.saniUis.model.Rol;
import com.proyecto.saniUis.model.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol,Long> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
