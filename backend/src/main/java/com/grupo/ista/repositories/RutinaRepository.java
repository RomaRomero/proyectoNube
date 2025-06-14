package com.grupo.ista.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.grupo.ista.models.TRutina;

public interface RutinaRepository extends JpaRepository<TRutina, Long> {
    List<TRutina> findByUsuarioId(Long usuarioId);
}
