package com.grupo.ista.config;

import com.grupo.ista.util.JwtAuthFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
<<<<<<< HEAD
import org.springframework.security.authentication.AuthenticationManager;
=======
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
>>>>>>> 0c42804e2ffd44638b7cb65015cc5ab9d2b6d034
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
<<<<<<< HEAD
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
=======
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
>>>>>>> 0c42804e2ffd44638b7cb65015cc5ab9d2b6d034
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

<<<<<<< HEAD
import java.util.Arrays;

import static org.springframework.security.config.Customizer.withDefaults;
=======
import java.util.List;
>>>>>>> 0c42804e2ffd44638b7cb65015cc5ab9d2b6d034

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtAuthFilter jwtAuthFilter) throws Exception {
        return http
<<<<<<< HEAD
                .cors(withDefaults()) // ✅ habilita CORS usando CorsConfigurationSource
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        
                             // Login y registro públicos
                        .requestMatchers("/api/auth/**").permitAll()

                        // Protegido por roles
                        .requestMatchers("/api/usuarios/**").hasAnyRole("USUARIO", "ENTRENADOR", "ADMIN")
                        .requestMatchers("/api/rutinas/**").hasRole("ENTRENADOR")
=======
                .cors(Customizer.withDefaults())
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()

                         // Endpoints públicos
                        .requestMatchers("/api/auth/login").permitAll()
                        .requestMatchers("/api/auth/register").permitAll()

                        // Endpoints protegidos
                        .requestMatchers("/api/usuarios/**").hasAnyRole("USUARIO", "ENTRENADOR", "ADMIN")
                        .requestMatchers("/api/rutinas/**").hasRole("ENTRENADOR")

                        // Swagger permitidos sin autenticación
>>>>>>> 0c42804e2ffd44638b7cb65015cc5ab9d2b6d034
                        .requestMatchers(
                                "/swagger-ui/**",
                                "/v3/api-docs/**",
                                "/swagger-resources/**",
                                "/swagger-ui.html"
<<<<<<< HEAD
                        ).permitAll()            
                        // Cualquier otro endpoint requiere autenticación
=======
                        ).permitAll()

                        // Lo demás necesita autenticación
>>>>>>> 0c42804e2ffd44638b7cb65015cc5ab9d2b6d034
                        .anyRequest().authenticated()
                )
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
              //  .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedOrigins(Arrays.asList("http://localhost:4200")); // ✅ Angular
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowedHeaders(Arrays.asList("*")); // Puedes especificar también Authorization, Content-Type

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(List.of("http://localhost:4200"));
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowedHeaders(List.of("*"));
        config.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}
