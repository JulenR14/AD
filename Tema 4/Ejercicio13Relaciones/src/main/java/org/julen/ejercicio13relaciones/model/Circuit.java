package org.julen.ejercicio13relaciones.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "circuits")
public class Circuit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "circuitid")
    private Long circuitId;

    @Column(unique = true, name = "circuitref", nullable = false)
    private String circuitRef;

    @Column(unique = true, nullable = false)
    private String name;

    private String location;
    private String country;
    private double lat;
    private double lng;
    private int alt;
    private String url;

    @OneToOne(mappedBy = "circuit")
    @JsonIgnoreProperties("circuit")
    private Race race;
}
