package com.gescol.asistecia.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gescol.asistecia.model.Asistencia;

@Repository
public interface AsistenciaRepository extends JpaRepository<Asistencia, Long> {

    List<Asistencia> findByAlumnoId(Long alumnoId);

    List<Asistencia> findByFecha(LocalDate fecha);

    boolean existsByAlumnoIdAndFecha(Long alumnoId, LocalDate fecha);

    Optional<Asistencia> findByAlumnoIdAndFecha(Long alumnoId, LocalDate fecha);
}