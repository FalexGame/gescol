package com.gescol.asistecia.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gescol.asistecia.model.AlumnoAcudiente;
import com.gescol.asistecia.service.AlumnoAcudienteService;

@RestController
@RequestMapping("/api/alumno-acudiente")
@CrossOrigin(origins = "*")
public class AlumnoAcudienteController {

    @Autowired
    private AlumnoAcudienteService service;

    @SuppressWarnings("unchecked")
    @PostMapping
    public ResponseEntity<?> asignar(@RequestBody Map<String, Object> body) {
        Long alumnoId, acudienteId;
        String parentesco;

        if (body.containsKey("alumnoId")) {
            alumnoId = Long.valueOf(body.get("alumnoId").toString());
            acudienteId = Long.valueOf(body.get("acudienteId").toString());
            parentesco = (String) body.get("parentesco");
        } else {
            Map<String, Object> alumno = (Map<String, Object>) body.get("alumno");
            Map<String, Object> acudiente = (Map<String, Object>) body.get("acudiente");
            alumnoId = Long.valueOf(alumno.get("id").toString());
            acudienteId = Long.valueOf(acudiente.get("id").toString());
            parentesco = (String) body.get("parentesco");
        }

        return ResponseEntity.ok(
                service.asignar(alumnoId, acudienteId, parentesco)
        );
    }

    //  VER ACUDIENTES DE UN ALUMNO
    @GetMapping("/alumno/{id}")
    public List<AlumnoAcudiente> porAlumno(@PathVariable Long id) {
        return service.obtenerPorAlumno(id);
    }

    // VER ALUMNOS DE UN ACUDIENTE
    @GetMapping("/acudiente/{id}")
    public List<AlumnoAcudiente> porAcudiente(@PathVariable Long id) {
        return service.obtenerPorAcudiente(id);
    }

    //  ELIMINAR RELACIÓN
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.ok("Relación eliminada");
    }
}
