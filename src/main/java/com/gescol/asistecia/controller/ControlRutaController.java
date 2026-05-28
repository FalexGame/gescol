package com.gescol.asistecia.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gescol.asistecia.model.*;
import com.gescol.asistecia.repository.*;

@RestController
@RequestMapping("/api/control-ruta")
@CrossOrigin(origins = "*")
public class ControlRutaController {

    @Autowired
    private ControlRutaRepository repo;

    @Autowired
    private AlumnoRepository alumnoRepo;

    @Autowired
    private RutaRepository rutaRepo;

    @Autowired
    private AsistenciaRepository asistenciaRepo;

    // Obtener registros por ruta + fecha + tipo (INGRESO)
    @GetMapping
    public ResponseEntity<?> obtener(
            @RequestParam Long rutaId,
            @RequestParam String fecha,
            @RequestParam String tipo) {

        if (!tipo.equals("INGRESO") && !tipo.equals("ENTREGA")) {
            return ResponseEntity.badRequest().body("tipo debe ser INGRESO o ENTREGA");
        }

        LocalDate date = LocalDate.parse(fecha);
        List<ControlRuta> registros = repo.findByRutaIdAndFechaAndTipo(rutaId, date, tipo);

        List<Map<String, Object>> resultado = new ArrayList<>();
        for (ControlRuta r : registros) {
            Map<String, Object> item = new HashMap<>();
            item.put("id", r.getId());
            item.put("alumnoId", r.getAlumno().getId());
            item.put("alumnoNombre", r.getAlumno().getNombre());
            item.put("alumnoApellido", r.getAlumno().getApellido());
            item.put("codigo", r.getAlumno().getCodigoEstudiantil());
            item.put("grado", r.getAlumno().getGrado() != null ? r.getAlumno().getGrado().getNombre() : "-");
            item.put("llego", r.getLlego());
            item.put("hora", r.getHora() != null ? r.getHora().toString() : null);
            resultado.add(item);
        }

        return ResponseEntity.ok(resultado);
    }

    // Listado enriquecido para ENTREGA: muestra asistencia + salida anticipada
    @GetMapping("/listado-entrega")
    public ResponseEntity<?> listadoEntrega(
            @RequestParam Long rutaId,
            @RequestParam String fecha) {

        LocalDate date = LocalDate.parse(fecha);
        Ruta ruta = rutaRepo.findById(rutaId)
                .orElseThrow(() -> new RuntimeException("Ruta no existe"));

        // Alumnos con rutaSalida asignada
        List<Alumno> alumnos = new ArrayList<>(alumnoRepo.findByRutaSalida(ruta));
        Set<Long> idsAlumnos = new HashSet<>();
        for (Alumno a : alumnos) idsAlumnos.add(a.getId());

        // Registros control-ruta existentes (ENTREGA)
        List<ControlRuta> registros = repo.findByRutaIdAndFechaAndTipo(rutaId, date, "ENTREGA");
        Map<Long, ControlRuta> registroMap = new HashMap<>();
        for (ControlRuta r : registros) {
            registroMap.put(r.getAlumno().getId(), r);
            // Incluir también alumnos que tengan ControlRuta aunque no tengan rutaSalida
            if (!idsAlumnos.contains(r.getAlumno().getId())) {
                alumnos.add(r.getAlumno());
                idsAlumnos.add(r.getAlumno().getId());
            }
        }

        // Asistencias del día
        List<Asistencia> asistencias = asistenciaRepo.findByFecha(date);
        Map<Long, Asistencia> asistenciaMap = new HashMap<>();
        for (Asistencia a : asistencias) {
            asistenciaMap.put(a.getAlumno().getId(), a);
        }

        List<Map<String, Object>> resultado = new ArrayList<>();
        for (Alumno a : alumnos) {
            Map<String, Object> item = new HashMap<>();
            item.put("alumnoId", a.getId());
            item.put("nombre", a.getNombre());
            item.put("apellido", a.getApellido());
            item.put("codigo", a.getCodigoEstudiantil());
            item.put("grado", a.getGrado() != null ? a.getGrado().getNombre() : "-");

            Asistencia asis = asistenciaMap.get(a.getId());
            boolean asistio = asis != null
                    && (asis.getEstado() == EstadoAsistencia.ASISTIO
                            || asis.getEstado() == EstadoAsistencia.TARDE);
            boolean salidaAnticipada = asis != null
                    && asis.getSalidaAnticipada() != null
                    && asis.getSalidaAnticipada();

            item.put("asistio", asistio);
            item.put("estadoAsistencia", asis != null ? asis.getEstado().name() : "SIN_REGISTRO");
            item.put("salidaAnticipada", salidaAnticipada);

            ControlRuta cr = registroMap.get(a.getId());
            item.put("registroId", cr != null ? cr.getId() : null);
            item.put("llego", cr != null ? cr.getLlego() : null);

            resultado.add(item);
        }

        return ResponseEntity.ok(resultado);
    }

    // Guardar registros en lote para una ruta + fecha + tipo
    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody Map<String, Object> body) {
        try {
            @SuppressWarnings("unchecked")
            List<Map<String, Object>> items = (List<Map<String, Object>>) body.get("items");
            Long rutaId = Long.valueOf(body.get("rutaId").toString());
            String fechaStr = (String) body.get("fecha");
            String tipo = (String) body.get("tipo");

            if (!tipo.equals("INGRESO") && !tipo.equals("ENTREGA")) {
                return ResponseEntity.badRequest().body("tipo debe ser INGRESO o ENTREGA");
            }

            LocalDate fecha = LocalDate.parse(fechaStr);
            Ruta ruta = rutaRepo.findById(rutaId)
                    .orElseThrow(() -> new RuntimeException("Ruta no existe"));

            int guardados = 0;

            for (Map<String, Object> item : items) {
                Long alumnoId = Long.valueOf(item.get("alumnoId").toString());
                Boolean llego = item.containsKey("llego") ? Boolean.valueOf(item.get("llego").toString()) : null;

                Alumno alumno = alumnoRepo.findById(alumnoId)
                        .orElseThrow(() -> new RuntimeException("Alumno no existe: " + alumnoId));

                ControlRuta registro = repo.findByAlumnoIdAndRutaIdAndFechaAndTipo(alumnoId, rutaId, fecha, tipo)
                        .orElse(null);

                if (registro == null) {
                    registro = new ControlRuta();
                    registro.setAlumno(alumno);
                    registro.setRuta(ruta);
                    registro.setFecha(fecha);
                    registro.setTipo(tipo);
                }

                if (llego != null) registro.setLlego(llego);

                // Solo INGRESO guarda hora de llegada
                if (tipo.equals("INGRESO")) {
                    String horaStr = item.containsKey("hora") ? (String) item.get("hora") : null;
                    if (horaStr != null && !horaStr.isEmpty()) {
                        registro.setHora(LocalTime.parse(horaStr));
                    }
                } else {
                    // ENTREGA no guarda hora
                    registro.setHora(null);
                }

                registro.setFechaRegistro(LocalDateTime.now());
                repo.save(registro);
                guardados++;
            }

            Map<String, Object> res = new HashMap<>();
            res.put("guardados", guardados);
            return ResponseEntity.ok(res);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }
}
