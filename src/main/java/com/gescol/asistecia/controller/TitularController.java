package com.gescol.asistecia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gescol.asistecia.model.Titular;
import com.gescol.asistecia.service.TitularService;

@RestController
@RequestMapping("/api/titulares")
@CrossOrigin(origins = "*")
public class TitularController {

    @Autowired
    private TitularService titularService;

    // LISTAR
    @GetMapping
    public ResponseEntity<List<Titular>> listar() {
        return ResponseEntity.ok(titularService.listar());
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<?> obtener(@PathVariable Long id) {
        Optional<Titular> titular = titularService.buscarPorId(id);

        if (titular.isPresent()) {
            return ResponseEntity.ok(titular.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Titular no encontrado");
        }
    }

    // BUSCAR POR CEDULA
    @GetMapping("/cedula/{cedula}")
    public ResponseEntity<?> buscarPorCedula(@PathVariable String cedula) {
        Optional<Titular> titular = titularService.buscarPorCedula(cedula);

        if (titular.isPresent()) {
            return ResponseEntity.ok(titular.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe titular con esa cédula");
        }
    }

    // CREAR
    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Titular titular) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(titularService.guardar(titular));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Titular titular) {
        try {
            return ResponseEntity.ok(titularService.actualizar(id, titular));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            titularService.eliminar(id);
            return ResponseEntity.ok("Titular eliminado");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }
}
