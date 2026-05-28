package com.gescol.asistecia.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gescol.asistecia.model.Alumno;
import com.gescol.asistecia.service.AlumnoService;

@RestController
@RequestMapping("/api/alumnos")
@CrossOrigin(origins = "*")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    // =========================
    // LISTAR TODOS
    // =========================
    @GetMapping
    public ResponseEntity<List<Alumno>> listar() {
        return ResponseEntity.ok(alumnoService.listar());
    }

    // =========================
    // BUSCAR POR ID
    // =========================
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable Long id) {
        Optional<Alumno> alumno = alumnoService.buscarPorId(id);

        if (alumno.isPresent()) {
            return ResponseEntity.ok(alumno.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Alumno no encontrado con id: " + id);
        }
    }

    // =========================
    // CREAR
    // =========================
    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Alumno alumno) {
        try {
            Alumno nuevo = alumnoService.guardar(alumno);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // =========================
    // ACTUALIZAR
    // =========================
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Alumno alumno) {
        try {
            Alumno actualizado = alumnoService.actualizar(id, alumno);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    // =========================
    // ELIMINAR
    // =========================
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            alumnoService.eliminar(id);
            return ResponseEntity.ok("Alumno eliminado correctamente");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    // =========================
    // IMPORTAR CSV
    // =========================
    @PostMapping("/importar")
    public ResponseEntity<?> importar(@RequestBody List<Map<String, String>> filas) {
        try {
            Map<String, Object> resultado = alumnoService.importar(filas);
            return ResponseEntity.ok(resultado);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    // =========================
    // TEST (opcional)
    // =========================
    @GetMapping("/test")
    public String test() {
        return "API Alumno funcionando correctamente";
    }
}