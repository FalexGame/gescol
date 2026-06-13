package com.gescol.asistecia.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gescol.asistecia.model.*;
import com.gescol.asistecia.repository.*;
import com.gescol.asistecia.service.AsistenciaService;

@Service
public class AsistenciaServiceImpl implements AsistenciaService {

    @Autowired
    private AsistenciaRepository asistenciaRepository;

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private TitularRepository titularRepository;

    @Override
    public Asistencia registrarPorQR(String codigoEstudiantil) {
        Alumno alumno = alumnoRepository.findByCodigoEstudiantil(codigoEstudiantil)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con código: " + codigoEstudiantil));

        LocalDate hoy = LocalDate.now();

        if (asistenciaRepository.existsByAlumnoIdAndFecha(alumno.getId(), hoy)) {
            throw new RuntimeException("Ya existe asistencia registrada para este alumno en la fecha de hoy");
        }

        Asistencia asistencia = new Asistencia();
        asistencia.setAlumno(alumno);
        asistencia.setFecha(hoy);
        asistencia.setEstado(EstadoAsistencia.ASISTIO);
        asistencia.setSalidaAnticipada(false);
        asistencia.setFechaRegistro(LocalDateTime.now());

        return asistenciaRepository.save(asistencia);
    }

    @Override
    public Asistencia registrar(Asistencia asistencia) {

        //  Validar alumno
        Alumno alumno = alumnoRepository.findById(asistencia.getAlumno().getId())
                .orElseThrow(() -> new RuntimeException("Alumno no existe"));

        //  Validar duplicado por día
        if (asistenciaRepository.existsByAlumnoIdAndFecha(alumno.getId(), asistencia.getFecha())) {
            throw new RuntimeException("Ya existe asistencia registrada para este alumno en esta fecha");
        }

        //  Validación salida anticipada
        if (Boolean.TRUE.equals(asistencia.getSalidaAnticipada())) {

            if (asistencia.getHoraSalida() == null) {
                throw new RuntimeException("Debe registrar la hora de salida");
            }

            if (asistencia.getMotivoSalida() == null || asistencia.getMotivoSalida().isEmpty()) {
                throw new RuntimeException("Debe indicar motivo de salida");
            }

            if (asistencia.getCoordinador() == null) {
                throw new RuntimeException("Debe asignar un coordinador");
            }

            // Validar coordinador
            Titular coord = titularRepository.findById(asistencia.getCoordinador().getId())
                    .orElseThrow(() -> new RuntimeException("Coordinador no existe"));

            if (!coord.getTipo().equals("COORDINADOR")) {
            throw new RuntimeException("El titular debe ser COORDINADOR");
            }

            asistencia.setCoordinador(coord);
        }

        asistencia.setAlumno(alumno);
        asistencia.setFechaRegistro(LocalDateTime.now());

        return asistenciaRepository.save(asistencia);
    }

    @Override
    public List<Asistencia> listar() {
        return asistenciaRepository.findAll();
    }

    @Override
    public List<Asistencia> porAlumno(Long alumnoId) {
        return asistenciaRepository.findByAlumnoId(alumnoId);
    }

    @Override
    public List<Asistencia> porFecha(LocalDate fecha) {
        return asistenciaRepository.findByFecha(fecha);
    }

    @Override
    public Asistencia actualizar(Long id, Asistencia asistencia) {
        Asistencia existente = asistenciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asistencia no encontrada con id: " + id));

        if (asistencia.getEstado() != null) {
            existente.setEstado(asistencia.getEstado());
        }
        if (asistencia.getObservaciones() != null) {
            existente.setObservaciones(asistencia.getObservaciones());
        }

        // Actualizar datos de salida anticipada
        if (asistencia.getSalidaAnticipada() != null) {
            existente.setSalidaAnticipada(asistencia.getSalidaAnticipada());
        }
        if (asistencia.getHoraSalida() != null) {
            existente.setHoraSalida(asistencia.getHoraSalida());
        }
        if (asistencia.getMotivoSalida() != null) {
            existente.setMotivoSalida(asistencia.getMotivoSalida());
        }
        if (asistencia.getCoordinador() != null && asistencia.getCoordinador().getId() != null) {
            Titular coord = titularRepository.findById(asistencia.getCoordinador().getId())
                    .orElseThrow(() -> new RuntimeException("Coordinador no existe"));
            if (!coord.getTipo().equals("COORDINADOR")) {
                throw new RuntimeException("El titular debe ser COORDINADOR");
            }
            existente.setCoordinador(coord);
        }

        return asistenciaRepository.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        asistenciaRepository.deleteById(id);
    }
}
