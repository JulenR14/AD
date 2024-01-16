package org.example.miprimeraapirest_ad.service;

import org.example.miprimeraapirest_ad.model.Driver;
import org.example.miprimeraapirest_ad.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverServiceImpl implements DriverService {

    private final DriverRepository repository;

    @Autowired
    public DriverServiceImpl(DriverRepository driverService){
        this.repository = driverService;
    }

    @Override
    public List<Driver> getAllDrivers() {
        return repository.findAll();
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
