package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeliculaOscarizada {

    private int anyo;
    private int edad;
    private String actor;
    private String pelicula;
    private String sexo;

    @Override
    public String toString(){
        return "anyo=" + anyo +
                ", edad=" + edad +
                ", actor='" + actor + '\'' +
                ", pelicula='" + pelicula + '\'' +
                ", sexo='" + sexo + '\'';
    }
}