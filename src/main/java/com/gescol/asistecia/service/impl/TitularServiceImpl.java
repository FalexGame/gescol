package com.gescol.asistecia.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gescol.asistecia.model.Titular;
import com.gescol.asistecia.repository.TitularRepository;
import com.gescol.asistecia.service.TitularService;

@Service
public class TitularServiceImpl implements TitularService {

    @Autowired
    private TitularRepository titularRepository;

    @Override
    public List<Titular> listar() {
        return titularRepository.findAll();
    }

    @Override
    public Optional<Titular> buscarPorId(Long id) {
        return titularRepository.findById(id);
    }

    @Override
    public Optional<Titular> buscarPorCedula(String cedula) {
        return titularRepository.findByNumeroCedula(cedula);
    }

    @Override
    public Titular guardar(Titular titular) {

        if (titularRepository.findByNumeroCedula(titular.getNumeroCedula()).isPresent()) {
            throw new RuntimeException("Ya existe un titular con esa cédula");
        }

        return titularRepository.save(titular);
    }

    @Override
    public Titular actualizar(Long id, Titular titular) {

        Optional<Titular> existente = titularRepository.findById(id);

        if (existente.isPresent()) {
            Titular t = existente.get();

            t.setNumeroCedula(titular.getNumeroCedula());
            t.setNombre(titular.getNombre());
            t.setApellido(titular.getApellido());
            t.setTipo(titular.getTipo());
            t.setArea(titular.getArea());
            t.setPassword(titular.getPassword());

            return titularRepository.save(t);
        } else {
            throw new RuntimeException("Titular no encontrado");
        }
    }

    @Override
    public void eliminar(Long id) {
        if (!titularRepository.existsById(id)) {
            throw new RuntimeException("Titular no existe");
        }
        titularRepository.deleteById(id);
    }
}
