package org.julen.ejercicio13relaciones.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@Table(name = "races")
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "raceid")
    private Long raceId;

    @Column(nullable = false)
    private int year;

    @Column(nullable = false)
    private int round;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnoreProperties("race")
    @JoinColumn(name = "circuitid")
    private Circuit circuit;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private LocalTime time;

    private String url;
}