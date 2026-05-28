package com.gescol.asistecia.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.gescol.asistecia.model.Alumno;

public interface AlumnoService {

    List<Alumno> listar();

    Optional<Alumno> buscarPorId(Long id);

    Alumno guardar(Alumno alumno);

    Alumno actualizar(Long id, Alumno alumno);

    void eliminar(Long id);

    /**
     * Importa múltiples alumnos desde una lista de filas CSV.
     * Cada fila es un Map con las columnas: nombre, apellido, grado, ingreso,
     * ruta_ingreso, salida, ruta_salida, acudiente_documento, parentesco.
     * Retorna un resumen con resultados por fila.
     */
    Map<String, Object> importar(List<Map<String, String>> filas);
}