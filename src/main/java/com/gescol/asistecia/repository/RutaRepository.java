package com.gescol.asistecia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gescol.asistecia.model.Ruta;

import java.util.Optional;

@Repository
public interface RutaRepository extends JpaRepository<Ruta, Long> {

    /*
     * Buscar por número de ruta
     * Ejemplo:
     * RUTA 01
     * RUTA 02
     */
    Optional<Ruta> findByNumeroRuta(String numeroRuta);

    /*
     * Buscar por placa del vehículo
     * Ejemplo:
     * ABC123
     */
    Optional<Ruta> findByPlacaVehiculo(String placaVehiculo);
}