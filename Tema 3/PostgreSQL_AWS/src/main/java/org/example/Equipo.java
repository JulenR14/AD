package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Equipo {
    private int id;
    private String referencia;
    private String nombre;
    private String nacionalidad;
    private String url;

    public Equipo(String referencia, String nombre, String nacionalidad, String url) {
        this.referencia = referencia;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.url = url;
    }
}
