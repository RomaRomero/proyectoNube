package com.grupo.ista.controllers;

import com.grupo.ista.models.TUsuario;
import com.grupo.ista.services.UsuarioService;
import com.grupo.ista.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
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
public ResponseEntity<?> login(@RequestBody TUsuario request) {
    try {
        authManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getCorreo(), request.getClave())
        );
        String token = jwtUtil.generarToken(request.getCorreo());
        return ResponseEntity.ok(token);
    } catch (BadCredentialsException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
    } catch (Exception ex) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Error: " + ex.getMessage());
    }
}



    @PostMapping("/register")
    public ResponseEntity<?> registrar(@RequestBody TUsuario usuario) {
        usuario.setClave(passwordEncoder.encode(usuario.getClave()));
        TUsuario registrado = usuarioService.registrarUsuario(usuario);
        return ResponseEntity.status(201).body(registrado);
    }
}