package com.grupo.ista.controllers;

import com.grupo.ista.models.LoginRequest;
import com.grupo.ista.models.LoginResponse;
import com.grupo.ista.models.RegistroDTO;
import com.grupo.ista.models.TRol;
import com.grupo.ista.models.TUsuario;
<<<<<<< HEAD
import com.grupo.ista.services.UsuarioService;
=======
import com.grupo.ista.repositories.UsuarioRepository;
>>>>>>> 0c42804e2ffd44638b7cb65015cc5ab9d2b6d034
import com.grupo.ista.util.JwtUtil;
import com.grupo.ista.repositories.RolRepository;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
import org.springframework.security.authentication.*;
=======
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
>>>>>>> 0c42804e2ffd44638b7cb65015cc5ab9d2b6d034
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/auth")
<<<<<<< HEAD
@CrossOrigin(origins = "http://localhost:4200")
=======
>>>>>>> 0c42804e2ffd44638b7cb65015cc5ab9d2b6d034
public class AuthController {

        @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

@PostMapping("/login")
<<<<<<< HEAD
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
=======
public ResponseEntity<?> login(@RequestBody LoginRequest request) {
    try {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getCorreo(),
                request.getClave()
            )
        );

        System.out.println(" Autenticado correctamente: " + request.getCorreo());

        String token = jwtUtil.generarToken(request.getCorreo());
        System.out.println(" Token generado: " + token);

        return ResponseEntity.ok(new LoginResponse(token));
    } catch (Exception e) {
        e.printStackTrace();  
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
>>>>>>> 0c42804e2ffd44638b7cb65015cc5ab9d2b6d034
    }
}



<<<<<<< HEAD
    @PostMapping("/register")
    public ResponseEntity<?> registrar(@RequestBody TUsuario usuario) {
        usuario.setClave(passwordEncoder.encode(usuario.getClave()));
        TUsuario registrado = usuarioService.registrarUsuario(usuario);
        return ResponseEntity.status(201).body(registrado);
    }
}
=======
@PostMapping("/register")
public ResponseEntity<?> register(@RequestBody RegistroDTO request) {
    if (usuarioRepository.existsByCorreo(request.getCorreo())) {
        return ResponseEntity
            .status(HttpStatus.CONFLICT)
            .body(Map.of("error", "Correo ya registrado"));
    }

    TUsuario nuevo = new TUsuario();
    nuevo.setNombre(request.getNombre());
    nuevo.setCorreo(request.getCorreo());
    nuevo.setClave(passwordEncoder.encode(request.getClave()));

    
    TRol rol = rolRepository.findByNombre("USUARIO")
        .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
    nuevo.setRol(rol);

    usuarioRepository.save(nuevo);

    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(Map.of("message", "Usuario registrado exitosamente"));
}


}
>>>>>>> 0c42804e2ffd44638b7cb65015cc5ab9d2b6d034
