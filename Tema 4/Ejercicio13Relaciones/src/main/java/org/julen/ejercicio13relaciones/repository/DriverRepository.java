package org.julen.ejercicio13relaciones.repository;

import org.julen.ejercicio13relaciones.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Long> {
    Optional<Driver> findByCodeIgnoreCase(String code);

    void deleteByCode(String code);
}
