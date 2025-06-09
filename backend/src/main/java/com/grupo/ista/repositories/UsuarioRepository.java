package com.grupo.ista.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.grupo.ista.models.TUsuario;

public interface UsuarioRepository extends JpaRepository<TUsuario, Long> {
    TUsuario findByCorreo(String correo);
}
