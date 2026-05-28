package com.gescol.asistecia.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gescol.asistecia.model.ControlRuta;

@Repository
public interface ControlRutaRepository extends JpaRepository<ControlRuta, Long> {

    List<ControlRuta> findByRutaIdAndFechaAndTipo(Long rutaId, LocalDate fecha, String tipo);

    Optional<ControlRuta> findByAlumnoIdAndRutaIdAndFechaAndTipo(Long alumnoId, Long rutaId, LocalDate fecha, String tipo);
}