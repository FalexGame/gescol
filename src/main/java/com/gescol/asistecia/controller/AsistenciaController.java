package com.gescol.asistecia.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.gescol.asistecia.model.Asistencia;
import com.gescol.asistecia.service.AsistenciaService;

@RestController
@RequestMapping("/api/asistencia")
@CrossOrigin(origins = "*")
public class AsistenciaController {

    @Autowired
    private AsistenciaService asistenciaService;

    // REGISTRAR
    @PostMapping
    public ResponseEntity<?> registrar(@RequestBody Asistencia asistencia) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(asistenciaService.registrar(asistencia));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // LISTAR
    @GetMapping
    public List<Asistencia> listar() {
        return asistenciaService.listar();
    }

    // POR ALUMNO
    @GetMapping("/alumno/{id}")
    public List<Asistencia> porAlumno(@PathVariable Long id) {
        return asistenciaService.porAlumno(id);
    }

    // POR FECHA
    @GetMapping("/fecha/{fecha}")
    public List<Asistencia> porFecha(@PathVariable String fecha) {
        return asistenciaService.porFecha(LocalDate.parse(fecha));
    }

    // ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Asistencia asistencia) {
        try {
            return ResponseEntity.ok(asistenciaService.actualizar(id, asistencia));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        asistenciaService.eliminar(id);
        return ResponseEntity.ok("Registro eliminado");
    }
}