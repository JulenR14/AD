package org.julen.ejercicio13relaciones.service;

import org.julen.ejercicio13relaciones.model.Race;

import java.util.List;
import java.util.Optional;

public interface RaceService {

    Optional<Race> findByRound(int round);
    List<Race> getAllRaces();
    void saveRace(Race race);

    void deleteRaceByRound(int round);

}
