package com.grupo.ista.repositories;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.grupo.ista.models.TComentario;

public interface ComentarioRepository extends MongoRepository<TComentario, String> {
    List<TComentario> findByIdUsuario(Long idUsuario);
    List<TComentario> findByIdEntrenador(Long idEntrenador);
}
