package com.grupo.ista.services;

import com.grupo.ista.models.TRutina;
import java.util.List;

public interface RutinaService {
    TRutina crearRutina(TRutina rutina);
    List<TRutina> obtenerRutinasPorUsuario(Long usuarioId);
}
