package org.julen.ejercicio13relaciones.controller;

import jakarta.transaction.Transactional;

import org.julen.ejercicio13relaciones.model.Driver;
import org.julen.ejercicio13relaciones.model.DriverDTO;
import org.julen.ejercicio13relaciones.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DriverRestController {

    private final DriverService driverService;

    @Autowired
    public DriverRestController(DriverService driverService){
        this.driverService = driverService;
    }

    @GetMapping("/drivers")
    public ResponseEntity<List<DriverDTO>> getAll(){
        return ResponseEntity.ok(driverService.getAllDrivers());
    }

    @GetMapping("/drivers/{code}")
    public ResponseEntity<Driver> getByCode(@PathVariable String code){
        return this.driverService.getDriverByCode(code)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/drivers")
    public ResponseEntity<Driver> create(@RequestBody Driver driver){
        if(driver.getDriverId() != null){
            return ResponseEntity.badRequest().build();
        }
        this.driverService.saveDriver(driver);
        return ResponseEntity.ok(driver);
    }

    @PutMapping("/drivers")
    public ResponseEntity<Driver> update(@RequestBody Driver driver){
        this.driverService.saveDriver(driver);
        return ResponseEntity.ok(driver);
    }

    @Transactional
    @DeleteMapping("/drivers/{code}")
    public ResponseEntity<Driver> deleteByCode(@PathVariable String code){
        this.driverService.deleteDriverByCode(code);
        return ResponseEntity.ok().build();
    }
}