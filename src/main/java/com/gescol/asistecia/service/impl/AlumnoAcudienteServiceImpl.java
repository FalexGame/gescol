package com.gescol.asistecia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gescol.asistecia.model.*;
import com.gescol.asistecia.repository.*;
import com.gescol.asistecia.service.AlumnoAcudienteService;

@Service
public class AlumnoAcudienteServiceImpl implements AlumnoAcudienteService {

    @Autowired
    private AlumnoAcudienteRepository repo;

    @Autowired
    private AlumnoRepository alumnoRepo;

    @Autowired
    private AcudienteRepository acudienteRepo;

    @Override
    public AlumnoAcudiente asignar(Long alumnoId, Long acudienteId, String parentesco) {

        Alumno alumno = alumnoRepo.findById(alumnoId)
                .orElseThrow(() -> new RuntimeException("Alumno no existe"));

        Acudiente acudiente = acudienteRepo.findById(acudienteId)
                .orElseThrow(() -> new RuntimeException("Acudiente no existe"));

        AlumnoAcudiente relacion = new AlumnoAcudiente();
        relacion.setAlumno(alumno);
        relacion.setAcudiente(acudiente);
        relacion.setParentesco(parentesco);

        return repo.save(relacion);
    }

    @Override
    public List<AlumnoAcudiente> obtenerPorAlumno(Long alumnoId) {
        return repo.findByAlumnoId(alumnoId);
    }

    @Override
    public List<AlumnoAcudiente> obtenerPorAcudiente(Long acudienteId) {
        return repo.findByAcudienteId(acudienteId);
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
