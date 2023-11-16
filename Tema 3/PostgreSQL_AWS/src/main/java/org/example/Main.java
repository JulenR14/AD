package org.example;

import java.util.Date;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Corredor carlosSainz = new Corredor("SAI", "Carlos", "Sainz", new Date(1994, 8, 1), "Español", new Equipo("seatF1", "Seat F1", "Inglaterra", "https://www.mclaren.com/racing/"), "https://www.mclaren.com/racing/team/carlos-sainz/");

        ConectarBaseDatos.agregarPiloto(carlosSainz);

    }
}