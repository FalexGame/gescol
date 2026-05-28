package com.gescol.asistecia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.gescol.asistecia.model.Ruta;
import com.gescol.asistecia.service.RutaService;

@RestController
@RequestMapping("/api/rutas")
@CrossOrigin(origins = "*")
public class RutaController {

    @Autowired
    private RutaService rutaService;

    // LISTAR
    @GetMapping
    public ResponseEntity<List<Ruta>> listar() {
        return ResponseEntity.ok(rutaService.listar());
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<?> obtener(@PathVariable Long id) {
        Optional<Ruta> ruta = rutaService.buscarPorId(id);

        if (ruta.isPresent()) {
            return ResponseEntity.ok(ruta.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ruta no encontrada");
        }
    }

    // CREAR
    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Ruta ruta) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(rutaService.guardar(ruta));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Ruta ruta) {
        try {
            return ResponseEntity.ok(rutaService.actualizar(id, ruta));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            rutaService.eliminar(id);
            return ResponseEntity.ok("Ruta eliminada");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }
}
