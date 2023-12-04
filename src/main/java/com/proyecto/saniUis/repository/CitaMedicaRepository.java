package com.Proyecto.BackIpsSaniUis.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Proyecto.BackIpsSaniUis.model.CitaMedica;

public interface CitaMedicaRepository extends JpaRepository<CitaMedica, Long> {


    @Query("SELECT c FROM CitaMedica c WHERE c.medico.idMedico = :idMedico AND c.fechaCita = :fechaCita AND c.horaCita = :horaCita")
    List<CitaMedica> findByMedicoAndFechaAndHoraCita(@Param("idMedico") Long idMedico, @Param("fechaCita") Date date, @Param("horaCita") LocalTime horaCita);

    @Query("SELECT c FROM CitaMedica c WHERE c.usuario.idUsuario = :idUsuario AND c.fechaCita = :fechaCita AND c.horaCita = :horaCita")
    List<CitaMedica> findByUsuarioAndFechaAndHoraCita(@Param("idUsuario") Long idUsuario, @Param("fechaCita") Date fechaCita, @Param("horaCita") LocalTime horaCita);

    @Query("SELECT c FROM CitaMedica c WHERE c.usuario.idUsuario = :idUsuario AND c.estadoCita = 1")
    List<CitaMedica> findByUsuario(@Param("idUsuario") Long idUsuario);

    @Query("SELECT c FROM CitaMedica c WHERE c.usuario.idUsuario = :idUsuario AND c.estadoCita = 2")
    List<CitaMedica> findByUsuarioFinalizada(@Param("idUsuario") Long idUsuario);

    @Query("SELECT c FROM CitaMedica c WHERE c.medico.usuario.idUsuario = :idMedico AND c.estadoCita = 1")
    List<CitaMedica> findByMedico(@Param("idMedico") Long idMedico);
    

    @Query("SELECT c FROM CitaMedica c WHERE c.medico.usuario.idUsuario = :idMedico AND c.estadoCita = 2")
    List<CitaMedica> findByMedicoFinalizada(@Param("idMedico") Long idMedico);

    @Query("SELECT c FROM CitaMedica c WHERE c.medico.usuario.idUsuario = :idMedico AND c.estadoCita = 3")
    List<CitaMedica> findByMedicoCancelada(@Param("idMedico") Long idMedico);
    
}
