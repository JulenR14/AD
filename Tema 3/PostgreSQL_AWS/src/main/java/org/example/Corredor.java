package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Corredor {

    private int id;
    private String code;
    private String nombre;
    private String apodo;
    private Date fechaNacimiento;
    private String nacionalidad;
    private Equipo equipo;
    private String url;

    public Corredor(String code, String nombre, String apodo, Date fechaNacimiento, String nacionalidad, Equipo equipo, String url) {
        this.code = code;
        this.nombre = nombre;
        this.apodo = apodo;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.equipo = equipo;
        this.url = url;
    }
}
