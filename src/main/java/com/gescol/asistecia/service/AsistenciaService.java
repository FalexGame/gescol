package com.gescol.asistecia.service;

import java.time.LocalDate;
import java.util.List;

import com.gescol.asistecia.model.Asistencia;

public interface AsistenciaService {

    Asistencia registrar(Asistencia asistencia);

    Asistencia registrarPorQR(String codigoEstudiantil);

    Asistencia actualizar(Long id, Asistencia asistencia);

    List<Asistencia> listar();

    List<Asistencia> porAlumno(Long alumnoId);

    List<Asistencia> porFecha(LocalDate fecha);

    void eliminar(Long id);
}