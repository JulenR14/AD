package org.example;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@AllArgsConstructor
@NoArgsConstructor

@JacksonXmlRootElement(localName = "atleta")
public class AtletaFeminina {
    @JacksonXmlProperty(localName = "nombre")
    private String nombre;
    @JacksonXmlProperty(localName = "pais")
    private String pais;
    @JacksonXmlProperty(localName = "edad")
    private int edad;
    @JacksonXmlElementWrapper(localName = "pruebas")
    @JacksonXmlProperty(localName = "prueba")
    private List<String> prueba ;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<String> getPrueba() {
        return prueba;
    }

    public void setPrueba(List<String> prueba) {
        this.prueba = prueba;
    }
}


