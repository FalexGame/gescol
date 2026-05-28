package com.gescol.asistecia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gescol.asistecia.model.Alumno;
import com.gescol.asistecia.model.Ruta;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

    Optional<Alumno> findByCodigoEstudiantil(String codigoEstudiantil);

    Optional<Alumno> findTopByOrderByCodigoEstudiantilDesc();

    List<Alumno> findByGradoId(Long gradoId);

    boolean existsByGradoId(Long gradoId);

    /*
     * Buscar alumnos que salen con acudiente
     */
    List<Alumno> findBySalidaConAcudiente(Boolean salidaConAcudiente);

    /*
     * Buscar alumnos que ingresan con acudiente
     */
    List<Alumno> findByIngresoConAcudiente(Boolean ingresoConAcudiente);

    List<Alumno> findByRutaSalida(Ruta ruta);

    List<Alumno> findByRutaIngreso(Ruta ruta);
}
