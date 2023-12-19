package org.example.miprimeraapirest_ad;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "drivers")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driverid")
    private Long driverId;

    @Column(unique = true)
    private String forename;
    private String surname;
    private String code;
    @JsonProperty("dateOfBirth")
    private LocalDate dob;
    private String nationality;
    private String url;
}
