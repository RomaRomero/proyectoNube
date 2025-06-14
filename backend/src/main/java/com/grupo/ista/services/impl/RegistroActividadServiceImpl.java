package com.grupo.ista.services.impl;

import com.grupo.ista.models.TRegistroActividad;
import com.grupo.ista.repositories.RegistroActividadRepository;
import com.grupo.ista.services.RegistroActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroActividadServiceImpl implements RegistroActividadService {

    @Autowired
    private RegistroActividadRepository registroActividadRepository;

    @Override
    public TRegistroActividad registrarActividad(TRegistroActividad actividad) {
        return registroActividadRepository.save(actividad);
    }

    @Override
    public List<TRegistroActividad> listarPorUsuario(Long usuarioId) {
        return registroActividadRepository.findByUsuarioId(usuarioId);
    }
}
