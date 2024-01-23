package org.julen.ejercicio13relaciones.repository;

import org.julen.ejercicio13relaciones.model.Constructor;
import org.julen.ejercicio13relaciones.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConstructorRepository extends JpaRepository<Constructor, Long> {
    Optional<Constructor> findByConstructorRefIgnoreCase(String constructorRef);

    void deleteByConstructorRef(String constructorRef);
}
