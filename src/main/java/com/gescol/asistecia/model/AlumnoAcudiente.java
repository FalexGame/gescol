package com.gescol.asistecia.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "alumno_acudiente")
@Data
public class AlumnoAcudiente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     * Relación con el alumno
     * Un alumno puede tener varios acudientes
     */
    @ManyToOne
    @JoinColumn(name = "alumno_id", nullable = false)
    private Alumno alumno;

    /*
     * Relación con el acudiente
     * Un acudiente puede estar asociado
     * a varios alumnos
     */
    @ManyToOne
    @JoinColumn(name = "acudiente_id", nullable = false)
    private Acudiente acudiente;

    /*
     * Tipo de parentesco
     * Ejemplo:
     * Madre
     * Padre
     * Abuelo
     * Tía
     * Hermano mayor
     */
    private String parentesco;
}