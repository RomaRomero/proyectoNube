package com.grupo.ista.models;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "actividades")
public class TRegistroActividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;
    private int duracionMinutos;
    private int caloriasQuemadas;
    private int repeticiones;
    private double peso;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private TUsuario usuario;
}
