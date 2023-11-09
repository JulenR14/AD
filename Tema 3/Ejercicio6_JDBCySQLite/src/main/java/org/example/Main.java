package org.example;

import java.util.ArrayList;

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


        Piloto pilotoLeido = ConectarConBaseDatos.leerPilotos(3);
        //System.out.println(pilotoLeido);

        ArrayList<Piloto> pilotos = ConectarConBaseDatos.leerPilotos();
        for (Piloto piloto1 : pilotos) {
            System.out.println(piloto1);
        }

        if (ConectarConBaseDatos.actualizarPiloto(
                new Piloto(9, "AAA", "AAA", "AAA", "1985-01-07", "British", "http://en.wikipedia.org/wiki/Lewis_Hamilton"))) {
            System.out.println("Piloto actualizado");
        } else {
            System.out.println("No se pudo actualizar el piloto");
        }

        if (ConectarConBaseDatos.borrarPiloto(
                new Piloto(9, "AAA", "AAA", "AAA", "1985-01-07", "British", "http://en.wikipedia.org/wiki/Lewis_Hamilton"))) {
            System.out.println("Piloto eliminado");
        }

        ConectarConBaseDatos.mostrarClasificacionPiloto();
    }
}