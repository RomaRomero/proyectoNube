package com.grupo.ista.services.impl;

import com.grupo.ista.models.TRutina;
import com.grupo.ista.repositories.RutinaRepository;
import com.grupo.ista.services.RutinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RutinaServiceImpl implements RutinaService {

    @Autowired
    private RutinaRepository rutinaRepository;

    @Override
    public TRutina crearRutina(TRutina rutina) {
        return rutinaRepository.save(rutina);
    }

    @Override
    public List<TRutina> obtenerRutinasPorUsuario(Long usuarioId) {
        return rutinaRepository.findByUsuarioId(usuarioId);
    }
}
