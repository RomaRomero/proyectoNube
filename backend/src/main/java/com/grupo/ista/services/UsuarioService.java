package com.grupo.ista.services;

import com.grupo.ista.models.TUsuario;
import java.util.List;

public interface UsuarioService {
    TUsuario registrarUsuario(TUsuario usuario);
    List<TUsuario> listarUsuarios();
    TUsuario buscarPorId(Long id);
    TUsuario buscarPorCorreo(String correo);
    void eliminarUsuario(Long id);
}
