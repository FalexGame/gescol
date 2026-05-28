package com.gescol.asistecia.service;

import java.util.List;
import java.util.Optional;
import com.gescol.asistecia.model.Acudiente;

public interface AcudienteService {

    List<Acudiente> listar();

    Optional<Acudiente> buscarPorId(Long id);

    Optional<Acudiente> buscarPorCedula(String cedula);

    Acudiente guardar(Acudiente acudiente);

    Acudiente actualizar(Long id, Acudiente acudiente);

    void eliminar(Long id);
}
