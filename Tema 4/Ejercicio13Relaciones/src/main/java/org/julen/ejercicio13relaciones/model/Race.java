package org.julen.ejercicio13relaciones.model;

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

    private int year;
    private int round;

    @OneToOne
    @JoinColumn(name = "circuitid")
    private Circuit circuit;

    private String name;
    private LocalDate date;
    private LocalTime time;
    private String url;
}
