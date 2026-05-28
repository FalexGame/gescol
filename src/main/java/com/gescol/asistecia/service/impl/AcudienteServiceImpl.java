package com.gescol.asistecia.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gescol.asistecia.model.Acudiente;
import com.gescol.asistecia.repository.AcudienteRepository;
import com.gescol.asistecia.service.AcudienteService;

@Service
public class AcudienteServiceImpl implements AcudienteService {

    @Autowired
    private AcudienteRepository acudienteRepository;

    @Override
    public List<Acudiente> listar() {
        return acudienteRepository.findAll();
    }

    @Override
    public Optional<Acudiente> buscarPorId(Long id) {
        return acudienteRepository.findById(id);
    }

    @Override
    public Optional<Acudiente> buscarPorCedula(String cedula) {
        return acudienteRepository.findByNumeroCedula(cedula);
    }

    @Override
    public Acudiente guardar(Acudiente acudiente) {

        // Validar cédula única
        if (acudienteRepository.findByNumeroCedula(acudiente.getNumeroCedula()).isPresent()) {
            throw new RuntimeException("Ya existe un acudiente con esa cédula");
        }

        return acudienteRepository.save(acudiente);
    }

    @Override
    public Acudiente actualizar(Long id, Acudiente acudiente) {

        Optional<Acudiente> existente = acudienteRepository.findById(id);

        if (existente.isPresent()) {
            Acudiente a = existente.get();

            a.setNumeroCedula(acudiente.getNumeroCedula());
            a.setNombre(acudiente.getNombre());
            a.setApellido(acudiente.getApellido());
            a.setTelefono(acudiente.getTelefono());
            a.setFoto(acudiente.getFoto());

            return acudienteRepository.save(a);
        } else {
            throw new RuntimeException("Acudiente no encontrado");
        }
    }

    @Override
    public void eliminar(Long id) {
        if (!acudienteRepository.existsById(id)) {
            throw new RuntimeException("Acudiente no existe");
        }
        acudienteRepository.deleteById(id);
    }
}
