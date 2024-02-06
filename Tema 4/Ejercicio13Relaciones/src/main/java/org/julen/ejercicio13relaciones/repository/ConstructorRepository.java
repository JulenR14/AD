package org.julen.ejercicio13relaciones.repository;

import org.julen.ejercicio13relaciones.model.Constructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConstructorRepository extends JpaRepository<Constructor, Long> {
    Optional<Constructor> findByConstructorRefIgnoreCase(String constructorRef);

    void deleteByConstructorRef(String constructorRef);
    Page<Constructor> findAllProjectedBy(Pageable pageable);
}
