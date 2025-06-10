package com.grupo.ista.services.impl;

import com.grupo.ista.models.TUsuario;
import com.grupo.ista.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        TUsuario usuario = usuarioRepository.findByCorreo(correo);
        if (usuario == null) throw new UsernameNotFoundException("Usuario no encontrado");

        return new User(
                usuario.getCorreo(),
                usuario.getClave(),
                usuario.getRoles().stream()
                        .map(r -> new SimpleGrantedAuthority("ROLE_" + r.getNombre()))
                        .collect(Collectors.toList())
        );
    }
}