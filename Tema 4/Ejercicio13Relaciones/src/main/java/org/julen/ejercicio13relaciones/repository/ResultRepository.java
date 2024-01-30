package org.julen.ejercicio13relaciones.repository;

import org.julen.ejercicio13relaciones.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResultRepository extends JpaRepository<Result, Long> {

}
