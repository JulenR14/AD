package org.julen.ejercicio13relaciones.repository;

import org.julen.ejercicio13relaciones.model.Circuit;
import org.julen.ejercicio13relaciones.model.Constructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CircuitRepository extends JpaRepository<Circuit, Long> {

    Optional<Circuit> findByCircuitRefIgnoreCase(String circuitRef);
    void deleteByCircuitRef(String circuitRef);
}
