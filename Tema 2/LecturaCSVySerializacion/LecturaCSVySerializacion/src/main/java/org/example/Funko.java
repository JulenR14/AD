package org.example;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.List;

public class Funko {

    //Atributos
    private String codigo, nombre, modelo;
    private float precio;
    private LocalDate fecha;

    //contructores
    public Funko(){}

    public Funko(List<String> lista){

        this.codigo = lista.get(0);
        this.nombre = lista.get(1);
        this.modelo = lista.get(2);
        this.precio = Float.parseFloat(lista.get(3));
        this.fecha = LocalDate.parse(lista.get(4));

    }

    @Override
    public String toString() {
        return "Funko{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", modelo='" + modelo + '\'' +
                ", precio=" + precio +
                ", fecha=" + fecha +
                "}\n";
    }

    //geters y seters
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public float getPrecio() {
        return precio;
    }

    public LocalDate getFecha() {
        return fecha;
    }
}
