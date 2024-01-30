package org.julen.ejercicio13relaciones.service;

import org.julen.ejercicio13relaciones.model.Result;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface ResultService {
    List<Result> getAllResults();

    Optional<Result> findByRaceId(Long raceId);
}
