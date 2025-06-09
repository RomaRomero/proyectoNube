package com.grupo.ista.repositories;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.grupo.ista.models.TRegistroActividad;

public interface RegistroActividadRepository extends JpaRepository<TRegistroActividad, Long> {
    List<TRegistroActividad> findByUsuarioId(Long usuarioId);
    List<TRegistroActividad> findByUsuarioIdAndFecha(Long usuarioId, LocalDate fecha);
}
