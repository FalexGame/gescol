package com.gescol.asistecia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gescol.asistecia.model.Grado;
import com.gescol.asistecia.service.GradoService;

@RestController
@RequestMapping("/api/grados")
@CrossOrigin(origins = "*")
public class GradoController {

    @Autowired
    private GradoService gradoService;

    @GetMapping
    public ResponseEntity<List<Grado>> listar() {
        return ResponseEntity.ok(gradoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtener(@PathVariable Long id) {
        Optional<Grado> grado = gradoService.buscarPorId(id);
        if (grado.isPresent()) {
            return ResponseEntity.ok(grado.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Grado no encontrado");
        }
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Grado grado) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(gradoService.guardar(grado));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Grado grado) {
        try {
            return ResponseEntity.ok(gradoService.actualizar(id, grado));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            gradoService.eliminar(id);
            return ResponseEntity.ok("Grado eliminado correctamente");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(e.getMessage());
        }
    }
}
