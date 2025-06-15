package com.grupo.ista.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {

    // Clave de al menos 64 caracteres para HS512 (512 bits = 64 bytes)
    private final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(
        "zZ8#Kf7r9TbH2vLxYcEoQwRaSuDhGm1NjXpBoIlUzWtCvMaRKeLgTxVnSzBuEj6F".getBytes()
    );

    private final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hora

    public String generarToken(String correo) {
        return Jwts.builder()
                .setSubject(correo)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SECRET_KEY, SignatureAlgorithm.HS512)
                .compact();
    }

    public String obtenerCorreoDesdeToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validarToken(String token) {
        try {
            Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
