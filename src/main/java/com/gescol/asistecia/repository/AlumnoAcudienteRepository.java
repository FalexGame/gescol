package com.gescol.asistecia.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gescol.asistecia.model.AlumnoAcudiente;

@Repository
public interface AlumnoAcudienteRepository extends JpaRepository<AlumnoAcudiente, Long> {

    List<AlumnoAcudiente> findByAlumnoId(Long alumnoId);

    List<AlumnoAcudiente> findByAcudienteId(Long acudienteId);
}