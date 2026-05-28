package com.gescol.asistecia.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "rutas")
public class Ruta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_ruta", nullable = false, unique = true)
    private String numeroRuta;

    @Column(name = "placa_vehiculo", nullable = false, unique = true)
    private String placaVehiculo;

    @Column(name = "nombre_conductor", nullable = false)
    private String nombreConductor;

    private String telefonoConductor;

    private String nombreMonitor;

    private String telefonoMonitor;

    private LocalDateTime fechaCreacion;

    // ===== GETTERS & SETTERS =====

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNumeroRuta() { return numeroRuta; }
    public void setNumeroRuta(String numeroRuta) { this.numeroRuta = numeroRuta; }

    public String getPlacaVehiculo() { return placaVehiculo; }
    public void setPlacaVehiculo(String placaVehiculo) { this.placaVehiculo = placaVehiculo; }

    public String getNombreConductor() { return nombreConductor; }
    public void setNombreConductor(String nombreConductor) { this.nombreConductor = nombreConductor; }

    public String getTelefonoConductor() { return telefonoConductor; }
    public void setTelefonoConductor(String telefonoConductor) { this.telefonoConductor = telefonoConductor; }

    public String getNombreMonitor() { return nombreMonitor; }
    public void setNombreMonitor(String nombreMonitor) { this.nombreMonitor = nombreMonitor; }

    public String getTelefonoMonitor() { return telefonoMonitor; }
    public void setTelefonoMonitor(String telefonoMonitor) { this.telefonoMonitor = telefonoMonitor; }

    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }
}