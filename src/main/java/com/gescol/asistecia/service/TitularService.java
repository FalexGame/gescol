package com.gescol.asistecia.service;

import java.util.List;
import java.util.Optional;

import com.gescol.asistecia.model.Titular;

public interface TitularService {

    List<Titular> listar();

    Optional<Titular> buscarPorId(Long id);

    Optional<Titular> buscarPorCedula(String cedula);

    Titular guardar(Titular titular);

    Titular actualizar(Long id, Titular titular);

    void eliminar(Long id);
}
