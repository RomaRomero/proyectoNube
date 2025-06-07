package com.grupo.ista.models;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rol")
public class TRol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre; // "USUARIO", "ENTRENADOR", "ADMIN"

    @ManyToMany(mappedBy = "roles")
    private List<TUsuario> usuarios;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime fechaCreacion;

    public TRol(String nombre) {
        this.nombre = nombre;
        this.fechaCreacion = LocalDateTime.now();
    }

    

}
