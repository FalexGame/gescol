package com.gescol.asistecia.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gescol.asistecia.model.Ruta;
import com.gescol.asistecia.repository.RutaRepository;
import com.gescol.asistecia.service.RutaService;

@Service
public class RutaServiceImpl implements RutaService {

    @Autowired
    private RutaRepository rutaRepository;

    @Override
    public List<Ruta> listar() {
        return rutaRepository.findAll();
    }

    @Override
    public Optional<Ruta> buscarPorId(Long id) {
        return rutaRepository.findById(id);
    }

    @Override
    public Ruta guardar(Ruta ruta) {

        // Validar duplicados
        if (rutaRepository.findByNumeroRuta(ruta.getNumeroRuta()).isPresent()) {
            throw new RuntimeException("Ya existe una ruta con ese número");
        }

        if (rutaRepository.findByPlacaVehiculo(ruta.getPlacaVehiculo()).isPresent()) {
            throw new RuntimeException("Ya existe una ruta con esa placa");
        }

        return rutaRepository.save(ruta);
    }

    @Override
    public Ruta actualizar(Long id, Ruta ruta) {

        Optional<Ruta> existente = rutaRepository.findById(id);

        if (existente.isPresent()) {

            Ruta r = existente.get();

            r.setNumeroRuta(ruta.getNumeroRuta());
            r.setPlacaVehiculo(ruta.getPlacaVehiculo());
            r.setNombreConductor(ruta.getNombreConductor());
            r.setTelefonoConductor(ruta.getTelefonoConductor());
            r.setNombreMonitor(ruta.getNombreMonitor());
            r.setTelefonoMonitor(ruta.getTelefonoMonitor());

            return rutaRepository.save(r);

        } else {
            throw new RuntimeException("Ruta no encontrada");
        }
    }

    @Override
    public void eliminar(Long id) {

        if (!rutaRepository.existsById(id)) {
            throw new RuntimeException("Ruta no existe");
        }

        rutaRepository.deleteById(id);
    }
}
