package org.julen.ejercicio13relaciones.service;

import org.julen.ejercicio13relaciones.model.Constructor;
import org.julen.ejercicio13relaciones.repository.ConstructorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConstructorServiceImpl implements ConstructorService{

    private final ConstructorRepository repository;

    public ConstructorServiceImpl(ConstructorRepository constructorRepository){this.repository = constructorRepository;}
    @Override
    public List<Constructor> getAllConstructors() {
        return repository.findAll();
    }

    @Override
    public Optional<Constructor> getConstructorByConstructorRef(String constructorRef) {
        return repository.findByConstructorRefIgnoreCase(constructorRef);
    }

    @Override
    public void saveConstructor(Constructor constructor) {
        repository.save(constructor);
    }

    @Override
    public void deleteConstructorByConstructorRef(String constructorRef) {
        repository.deleteByConstructorRef(constructorRef);
    }
}
