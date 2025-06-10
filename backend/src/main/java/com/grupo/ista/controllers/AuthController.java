package com.grupo.ista.controllers;

import com.grupo.ista.models.TUsuario;
import com.grupo.ista.services.UsuarioService;

import com.grupo.ista.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public String login(@RequestBody TUsuario request) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getCorreo(), request.getClave())
        );
        return jwtUtil.generarToken(request.getCorreo());
    }

    @PostMapping("/register")
    public TUsuario registrar(@RequestBody TUsuario usuario) {
        usuario.setClave(passwordEncoder.encode(usuario.getClave()));
        return usuarioService.registrarUsuario(usuario);
    }
}
