package org.example.miprimeraapirest_ad.repository;

import org.example.miprimeraapirest_ad.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long>{
}
