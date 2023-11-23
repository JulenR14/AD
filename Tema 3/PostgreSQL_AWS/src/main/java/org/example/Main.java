package org.example;

import java.util.Date;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Corredor carlosSainz = new Corredor("SAI", "Carlos", "Sainz", new Date(1994, 8, 1), "Español", new Equipo("seatF1", "Seat F1", "Inglaterra", "https://www.mclaren.com/racing/"), "https://www.mclaren.com/racing/team/carlos-sainz/");
       // Corredor fernandoAlonso = new Corredor("LUL", "Fernando", "Alonso", new Date(1981, 7, 29), "Español", new Equipo("renaultF1", "Renault F1", "Francia", "https://www.renaultsport.com/"), "https://www.renaultsport.com/-Fernando-Alonso-.html?lang=fr");
        Corredor landoNorris = new Corredor("NOR", "Lando", "Norris", new Date(1999, 11, 13), "Ingles", new Equipo("mclarenF1", "McLaren F1", "Inglaterra", "https://www.mclaren.com/racing/"), "https://www.mclaren.com/racing/team/lando-norris/");

        List<Corredor> pilotos = List.of(carlosSainz, landoNorris);

        ConectarBaseDatos.agregarPilotos(pilotos);

    }
}