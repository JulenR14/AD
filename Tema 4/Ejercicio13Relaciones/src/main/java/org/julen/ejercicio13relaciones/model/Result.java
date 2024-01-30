package org.julen.ejercicio13relaciones.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "results")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resultid")
    private Long resultId;

    @ManyToOne
    @JoinColumn(name = "raceid")
    @JsonManagedReference
    private Race race;

    @ManyToOne
    @JoinColumn(name = "driverid")
    @JsonIgnoreProperties("results")
    private Driver driver;

    private int grid;
    private Integer position;
    private int points;

}
