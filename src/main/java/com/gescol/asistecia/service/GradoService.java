package com.gescol.asistecia.service;

import java.util.List;
import java.util.Optional;
import com.gescol.asistecia.model.Grado;

public interface GradoService {
    List<Grado> listar();
    Optional<Grado> buscarPorId(Long id);
    Grado guardar(Grado grado);
    Grado actualizar(Long id, Grado grado);
    void eliminar(Long id);
}
