package org.julen.ejercicio13relaciones.service;

import org.julen.ejercicio13relaciones.model.Constructor;

import java.util.List;
import java.util.Optional;

public interface ConstructorService {
    List<Constructor> getAllConstructors();

    Optional<Constructor> getConstructorByConstructorRef(String constructorRef);

    void saveConstructor(Constructor constructor);

    void deleteConstructorByConstructorRef(String constructorRef);
}
