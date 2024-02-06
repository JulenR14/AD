package org.julen.ejercicio13relaciones.service;

import org.julen.ejercicio13relaciones.model.Constructor;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ConstructorService {
    List<Constructor> getAllConstructors();

    Page<Constructor> getAllConstructorsPaged(int pageNo, int pageSize, String sortBy, String sortDirection);
    Optional<Constructor> getConstructorByConstructorRef(String constructorRef);

    void saveConstructor(Constructor constructor);

    void deleteConstructorByConstructorRef(String constructorRef);
}
