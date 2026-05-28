package com.gescol.asistecia.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gescol.asistecia.model.*;
import com.gescol.asistecia.repository.*;
import com.gescol.asistecia.service.AlumnoService;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private GradoRepository gradoRepository;

    @Autowired
    private RutaRepository rutaRepository;

    @Autowired
    private AcudienteRepository acudienteRepository;

    @Autowired
    private AlumnoAcudienteRepository alumnoAcudienteRepository;

    // =========================
    // LISTAR
    // =========================
    @Override
    public List<Alumno> listar() {
        return alumnoRepository.findAll();
    }

    // =========================
    // BUSCAR POR ID
    // =========================
    @Override
    public Optional<Alumno> buscarPorId(Long id) {
        return alumnoRepository.findById(id);
    }

    // =========================
    // GUARDAR
    // =========================
    @Override
    public Alumno guardar(Alumno alumno) {
        alumno.setCodigoEstudiantil(generarCodigo());
        validarAlumno(alumno);
        return alumnoRepository.save(alumno);
    }

    private String generarCodigo() {
        Optional<Alumno> ultimo = alumnoRepository.findTopByOrderByCodigoEstudiantilDesc();
        if (ultimo.isPresent()) {
            String codigo = ultimo.get().getCodigoEstudiantil();
            int num = Integer.parseInt(codigo.replace("EST", "")) + 1;
            return String.format("EST%03d", num);
        }
        return "EST001";
    }

    // =========================
    // ACTUALIZAR
    // =========================
    @Override
    public Alumno actualizar(Long id, Alumno alumno) {

        Optional<Alumno> alumnoExistente = alumnoRepository.findById(id);

        if (alumnoExistente.isPresent()) {

            Alumno a = alumnoExistente.get();

            a.setNombre(alumno.getNombre());
            a.setApellido(alumno.getApellido());
            a.setGrado(alumno.getGrado());
            a.setRutaIngreso(alumno.getRutaIngreso());
            a.setIngresoConAcudiente(alumno.getIngresoConAcudiente());

            a.setRutaSalida(alumno.getRutaSalida());
            a.setSalidaConAcudiente(alumno.getSalidaConAcudiente());

            validarAlumno(a);

            return alumnoRepository.save(a);

        } else {
            throw new RuntimeException("Alumno no encontrado con id: " + id);
        }
    }

    // =========================
    // ELIMINAR
    // =========================
    @Override
    public void eliminar(Long id) {
        if (!alumnoRepository.existsById(id)) {
            throw new RuntimeException("Alumno no existe con id: " + id);
        }
        alumnoRepository.deleteById(id);
    }

    // =========================
    // VALIDACIONES DE NEGOCIO
    // =========================
    // =========================
    // IMPORTAR CSV
    // =========================
    @Override
    public Map<String, Object> importar(List<Map<String, String>> filas) {
        List<Map<String, Object>> resultados = new ArrayList<>();
        int procesados = 0, errores = 0;

        for (int i = 0; i < filas.size(); i++) {
            Map<String, String> fila = filas.get(i);
            Map<String, Object> resultado = new HashMap<>();
            resultado.put("fila", i + 2); // +2 por header y 0-index
            resultado.put("nombre", fila.getOrDefault("nombre", ""));
            resultado.put("apellido", fila.getOrDefault("apellido", ""));

            try {
                String gradoNombre = fila.get("grado");
                if (gradoNombre == null || gradoNombre.isBlank()) {
                    throw new RuntimeException("Grado requerido");
                }
                Grado grado = gradoRepository.findByNombre(gradoNombre.trim())
                        .orElseThrow(() -> new RuntimeException("Grado no encontrado: " + gradoNombre));

                Alumno a = new Alumno();
                a.setNombre(fila.get("nombre"));
                a.setApellido(fila.get("apellido"));
                a.setGrado(grado);

                String ingreso = fila.getOrDefault("ingreso", "acudiente");
                if ("ruta".equals(ingreso)) {
                    String rutaIngresoNum = fila.get("ruta_ingreso");
                    if (rutaIngresoNum == null || rutaIngresoNum.isBlank()) {
                        throw new RuntimeException("ruta_ingreso requerida si ingreso=ruta");
                    }
                    Ruta rutaIngreso = rutaRepository.findByNumeroRuta(rutaIngresoNum.trim())
                            .orElseThrow(() -> new RuntimeException("Ruta ingreso no encontrada: " + rutaIngresoNum));
                    a.setRutaIngreso(rutaIngreso);
                    a.setIngresoConAcudiente(false);
                } else {
                    a.setIngresoConAcudiente(true);
                }

                String salida = fila.getOrDefault("salida", "acudiente");
                if ("ruta".equals(salida)) {
                    String rutaSalidaNum = fila.get("ruta_salida");
                    if (rutaSalidaNum == null || rutaSalidaNum.isBlank()) {
                        throw new RuntimeException("ruta_salida requerida si salida=ruta");
                    }
                    Ruta rutaSalida = rutaRepository.findByNumeroRuta(rutaSalidaNum.trim())
                            .orElseThrow(() -> new RuntimeException("Ruta salida no encontrada: " + rutaSalidaNum));
                    a.setRutaSalida(rutaSalida);
                    a.setSalidaConAcudiente(false);
                } else {
                    a.setSalidaConAcudiente(true);
                }

                Alumno guardado = guardar(a);

                String acudienteDoc = fila.get("acudiente_documento");
                if (acudienteDoc != null && !acudienteDoc.isBlank()) {
                    Acudiente acudiente = acudienteRepository.findByNumeroCedula(acudienteDoc.trim())
                            .orElse(null);

                    if (acudiente == null) {
                        String acNombre = fila.get("acudiente_nombre");
                        if (acNombre == null || acNombre.isBlank()) {
                            throw new RuntimeException("Acudiente no encontrado y no hay datos para crearlo: " + acudienteDoc);
                        }
                        acudiente = new Acudiente();
                        acudiente.setNumeroCedula(acudienteDoc.trim());
                        acudiente.setNombre(acNombre.trim());
                        acudiente.setApellido(fila.getOrDefault("acudiente_apellido", "").trim());
                        acudiente.setTelefono(fila.getOrDefault("acudiente_telefono", "").trim());
                        acudiente = acudienteRepository.save(acudiente);
                    }

                    String parentesco = fila.getOrDefault("parentesco", "Acudiente");

                    AlumnoAcudiente relacion = new AlumnoAcudiente();
                    relacion.setAlumno(guardado);
                    relacion.setAcudiente(acudiente);
                    relacion.setParentesco(parentesco);
                    alumnoAcudienteRepository.save(relacion);
                }

                resultado.put("codigo", guardado.getCodigoEstudiantil());
                resultado.put("estado", "ok");
                procesados++;
            } catch (Exception e) {
                resultado.put("estado", "error");
                resultado.put("mensaje", e.getMessage());
                errores++;
            }

            resultados.add(resultado);
        }

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("procesados", procesados);
        respuesta.put("errores", errores);
        respuesta.put("total", filas.size());
        respuesta.put("detalles", resultados);
        return respuesta;
    }

    private void validarAlumno(Alumno alumno) {

        if (alumno.getGrado() == null || alumno.getGrado().getId() == null) {
            throw new RuntimeException("Debe asignar un grado al alumno");
        }

        // 🔴 VALIDACIÓN INGRESO
        if (alumno.getRutaIngreso() != null && Boolean.TRUE.equals(alumno.getIngresoConAcudiente())) {
            throw new RuntimeException("No puede tener ruta de ingreso y acudiente al mismo tiempo");
        }

        // 🔴 VALIDACIÓN SALIDA
        if (alumno.getRutaSalida() != null && Boolean.TRUE.equals(alumno.getSalidaConAcudiente())) {
            throw new RuntimeException("No puede tener ruta de salida y acudiente al mismo tiempo");
        }

        // 🔴 VALIDACIÓN: debe tener al menos una forma de ingreso
        if (alumno.getRutaIngreso() == null && !Boolean.TRUE.equals(alumno.getIngresoConAcudiente())) {
            throw new RuntimeException("Debe definir ruta de ingreso o acudiente");
        }

        // 🔴 VALIDACIÓN: debe tener al menos una forma de salida
        if (alumno.getRutaSalida() == null && !Boolean.TRUE.equals(alumno.getSalidaConAcudiente())) {
            throw new RuntimeException("Debe definir ruta de salida o acudiente");
        }
    }
}