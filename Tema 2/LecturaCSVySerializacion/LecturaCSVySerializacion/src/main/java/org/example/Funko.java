package org.example;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.List;

public class Funko {

    private String codigo, nombre, modelo;
    private Double precio;
    private LocalDate fecha;

    public Funko(List<String> lista){

        this.codigo = lista.get(0);
        this.nombre = lista.get(1);
        this.modelo = lista.get(2);
        this.precio = Double.parseDouble(lista.get(3));
        this.fecha = LocalDate.parse(lista.get(4));

    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public Double getPrecio() {
        return precio;
    }

    public LocalDate getFecha() {
        return fecha;
    }
}
