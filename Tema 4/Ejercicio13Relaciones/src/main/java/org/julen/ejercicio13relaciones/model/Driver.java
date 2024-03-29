package org.julen.ejercicio13relaciones.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "drivers")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driverid")
    private Long driverId;

    @Column(unique = true, name = "code")
    private String code;
    private String forename;
    private String surname;
    @JsonProperty("dateOfBirth")
    private LocalDate dob;
    private String nationality;

    @ManyToOne
    @JoinColumn(name = "constructorid")
    @JsonIgnoreProperties("drivers")
    private Constructor constructor;

    private String url;

    @OneToMany(mappedBy = "driver")
    private List<Result> results;
}
