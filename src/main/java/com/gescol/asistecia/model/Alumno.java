package com.gescol.asistecia.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "alumnos")
@Data
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Código único del estudiante
    @Column(name = "codigo_estudiantil", nullable = false, unique = true)
    private String codigoEstudiantil;

    // Información básica
    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @ManyToOne
    @JoinColumn(name = "grado_id")
    private Grado grado;

    /*
     * ============================
     * TRAYECTO CASA → COLEGIO
     * ============================
     * Si usa ruta:
     *     rutaIngreso != null
     *
     * Si llega con acudiente:
     *     ingresoConAcudiente = true
     */

    @ManyToOne
    @JoinColumn(name = "ruta_ingreso_id")
    private Ruta rutaIngreso;

    @Column(name = "ingreso_con_acudiente")
    private Boolean ingresoConAcudiente = false;

    /*
     * ============================
     * TRAYECTO COLEGIO → CASA
     * ============================
     * Si usa ruta:
     *     rutaSalida != null
     *
     * Si sale con acudiente:
     *     salidaConAcudiente = true
     */

    @ManyToOne
    @JoinColumn(name = "ruta_salida_id")
    private Ruta rutaSalida;

    @Column(name = "salida_con_acudiente")
    private Boolean salidaConAcudiente = false;

    /*
     * Fecha de creación del registro
     */

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;
}