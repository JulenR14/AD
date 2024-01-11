package org.example.miprimeraapirest_ad.repository;

import org.example.miprimeraapirest_ad.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long>{
    Optional<Driver> findByCodeIgnoreCase(String code);

    void deleteByCode(String code);
}
