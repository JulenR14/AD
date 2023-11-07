package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Piloto piloto = new Piloto("HAM", "Lewis", "Hamilton", "1985-01-07", "British", "http://en.wikipedia.org/wiki/Lewis_Hamilton");
        if(ConectarConBaseDatos.crearYagregarPiloto(piloto)){
            System.out.println("Piloto agregado");
        } else {
            System.out.println("No se pudo agregar el piloto");
        }

    }
}