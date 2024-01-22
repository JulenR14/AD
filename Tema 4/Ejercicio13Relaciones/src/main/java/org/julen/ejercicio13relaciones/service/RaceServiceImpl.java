package org.julen.ejercicio13relaciones.service;

import org.julen.ejercicio13relaciones.model.Race;
import org.julen.ejercicio13relaciones.repository.DriverRepository;
import org.julen.ejercicio13relaciones.repository.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RaceServiceImpl implements RaceService{
    private final RaceRepository repository;

    @Autowired
    public RaceServiceImpl(RaceRepository raceService){
        this.repository = raceService;
    }
    @Override
    public List<Race> getAllRaces() {
        return repository.findAll();
    }

    @Override
    public Optional<Race> getRaceByCode(String code) {
        return repository.findByCodeIgnoreCase(code);
    }

    @Override
    public void saveRace(Race race) {
        repository.save(race);
    }

    @Override
    public void deleteRaceByCode(String code) {
        repository.deleteByCode(code);
    }
}
