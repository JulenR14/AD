package org.julen.ejercicio13relaciones.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "constructors")
public class Contructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "constructorid")
    private Long constructorId;

    @Column(name = "constructorref", unique = true)
    private String constructorRef;

    @Column(unique = true, name = "name")
    private String name;

    private String nationality;
    private String url;

    @OneToMany(mappedBy = "constructor" , cascade = CascadeType.ALL)
    private List<Driver> drivers;
}
