package com.grupo.ista.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "comentarios")
public class TComentario {

    @Id
    private String id;

    private Long idUsuario;
    private Long idEntrenador;

    private String mensaje;
    private LocalDateTime fecha;
}
