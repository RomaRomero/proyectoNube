package com.grupo.ista.services;

import com.grupo.ista.models.TComentario;
import java.util.List;

public interface ComentarioService {
    TComentario guardarComentario(TComentario comentario);
    List<TComentario> listarPorUsuario(Long idUsuario);
    List<TComentario> listarPorEntrenador(Long idEntrenador);
}
