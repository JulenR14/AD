package org.example.miprimeraapirest_ad.service;

import org.example.miprimeraapirest_ad.Driver;
import org.example.miprimeraapirest_ad.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
