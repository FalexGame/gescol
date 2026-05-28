package com.gescol.asistecia.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gescol.asistecia.model.Acudiente;

@Repository
public interface AcudienteRepository extends JpaRepository<Acudiente, Long> {

    Optional<Acudiente> findByNumeroCedula(String numeroCedula);
}    

