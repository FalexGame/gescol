package com.gescol.asistecia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gescol.asistecia.model.Acudiente;
import com.gescol.asistecia.service.AcudienteService;

@RestController
@RequestMapping("/api/acudientes")
@CrossOrigin(origins = "*")
public class AcudienteController {

    @Autowired
    private AcudienteService acudienteService;

    // LISTAR
    @GetMapping
    public ResponseEntity<List<Acudiente>> listar() {
        return ResponseEntity.ok(acudienteService.listar());
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<?> obtener(@PathVariable Long id) {
        Optional<Acudiente> acudiente = acudienteService.buscarPorId(id);

        if (acudiente.isPresent()) {
            return ResponseEntity.ok(acudiente.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Acudiente no encontrado");
        }
    }

    // BUSCAR POR CEDULA
    @GetMapping("/cedula/{cedula}")
    public ResponseEntity<?> buscarPorCedula(@PathVariable String cedula) {
        Optional<Acudiente> acudiente = acudienteService.buscarPorCedula(cedula);

        if (acudiente.isPresent()) {
            return ResponseEntity.ok(acudiente.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe acudiente con esa cédula");
        }
    }

    // CREAR
    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Acudiente acudiente) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(acudienteService.guardar(acudiente));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Acudiente acudiente) {
        try {
            return ResponseEntity.ok(acudienteService.actualizar(id, acudiente));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            acudienteService.eliminar(id);
            return ResponseEntity.ok("Acudiente eliminado correctamente");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }
}
