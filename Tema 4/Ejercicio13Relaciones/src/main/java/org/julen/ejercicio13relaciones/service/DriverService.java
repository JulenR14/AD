package org.julen.ejercicio13relaciones.service;

import org.julen.ejercicio13relaciones.model.Driver;
import org.julen.ejercicio13relaciones.model.DriverDTO;

import java.util.List;
import java.util.Optional;

public interface DriverService {
    List<DriverDTO> getAllDrivers();

    Optional<Driver> getDriverByCode(String code);

    void saveDriver(Driver driver);
    void deleteDriverByCode(String code);
}