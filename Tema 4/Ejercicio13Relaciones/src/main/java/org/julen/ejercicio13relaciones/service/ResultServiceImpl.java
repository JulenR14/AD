package org.julen.ejercicio13relaciones.service;

import org.julen.ejercicio13relaciones.model.Result;
import org.julen.ejercicio13relaciones.repository.ResultRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResultServiceImpl implements ResultService{
    private final ResultRepository repository;

    public ResultServiceImpl(ResultRepository repository) {
        this.repository = repository;
    }

    public List<Result> getAllResults() {
        return repository.findAll();
    }

    public Optional<Result> findByRaceId(Long raceId) {
        return repository.findById(raceId);
    }
}
