package org.julen.ejercicio13relaciones.service;

import org.julen.ejercicio13relaciones.model.Race;

import java.util.List;
import java.util.Optional;

public interface RaceService {
    List<Race> getAllRaces();
    Optional<Race> getRaceByCode(String code);
    void saveRace(Race race);

    void deleteRaceByCode(String code);
}
