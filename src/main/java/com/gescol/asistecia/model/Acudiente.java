package com.gescol.asistecia.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "acudientes")
@Data
public class Acudiente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     * Número de cédula único del acudiente
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
     * Información de contacto
     */
    private String telefono;

    /*
     * Ruta o nombre de la foto
     * Ejemplo:
     * maria.jpg
     * uploads/fotos/acudiente1.png
     */
    private String foto;

    /*
     * Fecha de creación del registro
     */
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;
}