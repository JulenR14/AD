package org.julen.ejercicio13relaciones.model;

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

    @Column(unique = true, name = "circuitref")
    private String circuitRef;

    @Column(unique = true, name = "name")
    private String name;

    private String location;
    private String country;
    private double lat;
    private double lng;
    private int alt;
    private String url;

    @OneToOne(mappedBy = "circuit")
    private Race race;
}
