package org.julen.ejercicio13relaciones.repository;

import org.julen.ejercicio13relaciones.model.Race;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RaceRepository extends JpaRepository<Race, Long> {
    Optional<Race> findByCodeIgnoreCase(String code);

    void deleteByCode(String code);
}
