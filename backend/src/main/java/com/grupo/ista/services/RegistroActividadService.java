package com.grupo.ista.services;

import com.grupo.ista.models.TRegistroActividad;
import java.util.List;

public interface RegistroActividadService {
    TRegistroActividad registrarActividad(TRegistroActividad actividad);
    List<TRegistroActividad> listarPorUsuario(Long usuarioId);
}
