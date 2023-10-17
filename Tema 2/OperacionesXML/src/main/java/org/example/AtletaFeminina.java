package org.example;

import java.util.*;

public class AtletaFeminina {

    String nombre, pais;
    List<String> prueba = new ArrayList<String>();
    int edad;

    public AtletaFeminina(String nombre, String pais, List<String> prueba, int edad) {
        this.nombre = nombre;
        this.pais = pais;
        this.prueba = prueba;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }

    public List<String> getPrueba() {
        return prueba;
    }

    public int getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setPrueba(List<String> prueba) {
        this.prueba = prueba;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

}
