package com.gescol.asistecia.service;

import java.util.List;
import com.gescol.asistecia.model.AlumnoAcudiente;

public interface AlumnoAcudienteService {

    AlumnoAcudiente asignar(Long alumnoId, Long acudienteId, String parentesco);

    List<AlumnoAcudiente> obtenerPorAlumno(Long alumnoId);

    List<AlumnoAcudiente> obtenerPorAcudiente(Long acudienteId);

    void eliminar(Long id);
}
