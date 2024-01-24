package org.julen.ejercicio13relaciones.service;

import org.julen.ejercicio13relaciones.model.Circuit;
import org.julen.ejercicio13relaciones.repository.CircuitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CircuiteServiceImpl implements CircuitService{

    private final CircuitRepository repository;

    public CircuiteServiceImpl(CircuitRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Circuit> getAllCircuits() {
        return repository.findAll();
    }

    @Override
    public Optional<Circuit> getCircuitByCircuitRef(String circuitRef) {
        return repository.findByCircuitRefIgnoreCase(circuitRef);
    }

    @Override
    public void saveCircuit(Circuit circuit) {
        repository.save(circuit);
    }

    @Override
    public void deleteCircuitByCircuitRef(String circuitRef) {
        repository.deleteByCircuitRef(circuitRef);
    }
}
