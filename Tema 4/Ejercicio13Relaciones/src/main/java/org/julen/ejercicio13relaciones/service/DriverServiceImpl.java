package org.julen.ejercicio13relaciones.service;

import org.julen.ejercicio13relaciones.mapper.FormulaMapper;
import org.julen.ejercicio13relaciones.model.Driver;
import org.julen.ejercicio13relaciones.model.DriverDTO;
import org.julen.ejercicio13relaciones.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DriverServiceImpl implements DriverService {

    private final DriverRepository repository;

    private final FormulaMapper mapper;

    @Autowired
    public DriverServiceImpl(DriverRepository driverService, FormulaMapper mapper){
        this.mapper = mapper;
        this.repository = driverService;
    }

    @Override
    public List<DriverDTO> getAllDrivers() {
        List<DriverDTO> response = new ArrayList<>();

        repository.findAll().forEach(driver -> response.add(mapper.toDriverDTO(driver)));

        return response;
    }

    @Override
    public Optional<Driver> getDriverByCode(String code) {
        return repository.findByCodeIgnoreCase(code);
    }

    @Override
    public void saveDriver(Driver driver) {
        repository.save(driver);
    }



    @Override
    public void deleteDriverByCode(String code) {
        repository.deleteByCode(code);
    }
}
