package com.grupo.ista.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.grupo.ista.models.TRol;

public interface RolRepository extends JpaRepository<TRol, Long> {
    TRol findByNombre(String nombre);
}
