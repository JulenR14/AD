package org.example;

public class Constructor {
    private int constructorid;
    private String constructorRef;
    private String nombre;
    private String nacionalidad;
    private String url;

    public Constructor(String constructorRef, String nombre, String nacionalidad, String url){
        this.constructorRef = constructorRef;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.url = url;
    }
}
