package com.grupo.ista.models;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuarios")
public class TUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String correo;
    private String contraseña;

    @ManyToMany
    @JoinTable(name = "usuario_rol",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private List<TRol> roles;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<TRutina> rutinas;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<TRegistroActividad> registros;
}
