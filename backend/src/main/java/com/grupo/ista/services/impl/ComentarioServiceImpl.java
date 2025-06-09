package com.grupo.ista.services.impl;

import com.grupo.ista.models.TComentario;
import com.grupo.ista.repositories.ComentarioRepository;
import com.grupo.ista.services.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioServiceImpl implements ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Override
    public TComentario guardarComentario(TComentario comentario) {
        return comentarioRepository.save(comentario);
    }

    @Override
    public List<TComentario> listarPorUsuario(Long idUsuario) {
        return comentarioRepository.findByIdUsuario(idUsuario);
    }

    @Override
    public List<TComentario> listarPorEntrenador(Long idEntrenador) {
        return comentarioRepository.findByIdEntrenador(idEntrenador);
    }
}
