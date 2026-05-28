package com.gescol.asistecia.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gescol.asistecia.model.Titular;

@Repository
public interface TitularRepository extends JpaRepository<Titular, Long> {

    Optional<Titular> findByNumeroCedula(String numeroCedula);
}