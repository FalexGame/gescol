package com.gescol.asistecia.service;

import java.util.List;
import java.util.Optional;

import com.gescol.asistecia.model.Ruta;

public interface RutaService {

    List<Ruta> listar();

    Optional<Ruta> buscarPorId(Long id);

    Ruta guardar(Ruta ruta);

    Ruta actualizar(Long id, Ruta ruta);

    void eliminar(Long id);
}
