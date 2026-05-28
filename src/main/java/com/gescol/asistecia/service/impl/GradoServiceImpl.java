package com.gescol.asistecia.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gescol.asistecia.model.Grado;
import com.gescol.asistecia.repository.AlumnoRepository;
import com.gescol.asistecia.repository.GradoRepository;
import com.gescol.asistecia.service.GradoService;

@Service
public class GradoServiceImpl implements GradoService {

    @Autowired
    private GradoRepository gradoRepository;

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Override
    public List<Grado> listar() {
        return gradoRepository.findAll();
    }

    @Override
    public Optional<Grado> buscarPorId(Long id) {
        return gradoRepository.findById(id);
    }

    @Override
    public Grado guardar(Grado grado) {
        if (gradoRepository.findByNombre(grado.getNombre()).isPresent()) {
            throw new RuntimeException("Ya existe un grado con ese nombre");
        }
        return gradoRepository.save(grado);
    }

    @Override
    public Grado actualizar(Long id, Grado grado) {
        Optional<Grado> existente = gradoRepository.findById(id);
        if (existente.isPresent()) {
            Grado g = existente.get();
            if (!g.getNombre().equals(grado.getNombre()) &&
                gradoRepository.findByNombre(grado.getNombre()).isPresent()) {
                throw new RuntimeException("Ya existe un grado con ese nombre");
            }
            g.setNombre(grado.getNombre());
            return gradoRepository.save(g);
        } else {
            throw new RuntimeException("Grado no encontrado");
        }
    }

    @Override
    public void eliminar(Long id) {
        if (!gradoRepository.existsById(id)) {
            throw new RuntimeException("Grado no existe");
        }
        if (alumnoRepository.existsByGradoId(id)) {
            throw new RuntimeException("No se puede eliminar el grado porque tiene alumnos asignados");
        }
        gradoRepository.deleteById(id);
    }
}
