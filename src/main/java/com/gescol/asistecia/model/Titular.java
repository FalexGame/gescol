package com.gescol.asistecia.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "titulares")
@Data
public class Titular {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     * Número de cédula único
     */
    @Column(name = "numero_cedula", nullable = false, unique = true)
    private String numeroCedula;

    /*
     * Información personal
     */
    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    /*
     * Tipo de titular:
     * DOCENTE
     * COORDINADOR
     */
    @Column(nullable = false)
    private String tipo;

    /*
     * Área de trabajo
     * Ejemplo:
     * Matemáticas
     * Convivencia
     * Coordinación Académica
     */
    private String area;

    /*
     * Contraseña de acceso al sistema
     * (Luego se recomienda encriptarla)
     */
    @Column(nullable = false)
    private String password;

    /*
     * Fecha de creación del registro
     */
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;
}