

import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class App {

    public static void main(String[] args) {

        BookCollection coleccion = new BookCollection();

        coleccion.libros.add(new Book("9788422616337", "El Señor de los Anillos", "J.R.R. Tolkien", 800));
        coleccion.libros.add(new Book("9788445077528", "El Hobbit", "J.R.R. Tolkien", 350));
        coleccion.libros.add(new Book("9788466316781", "Cabo Trafalgar", "Arturo Pérez Reverte", 320));
        coleccion.libros.add(new Book("9788493975074", "El corazón de la piedra", "José María García López", 560));
        coleccion.libros.add(new Book("97884932ad488", "Salmos de vísperas", "Esteban Hernández Castelló", 95));
        coleccion.libros.add(new Book("9788420685625", "La música en las catedrales españolas del Siglo de Oro", "Robert Stevenson", 600));
        coleccion.libros.add(new Book("9788423913077", "Luces de bohemia", "Ramón del Valle-Inclán", 296));
        coleccion.libros.add(new Book("9788448031121", "Contando atardeceres", "La vecina rubia", 528));
        coleccion.libros.add(new Book("9781529342079", "The Master: The Brilliant Career of Roger Federer", "Christopher Clarey", 456));
        coleccion.libros.add(new Book("9788408264385", "La teoría de los archipiélagos", "Alice Kellen", 300));
        coleccion.libros.add(new Book("9788423362479", "Esperando al diluvio", "Dolores Redondo", 576));
        coleccion.libros.add(new Book("9788466367349", "El italiano", "Arturo Pérez Reverte", 400));
        coleccion.libros.add(new Book("9788466359290", "Línea de fuego", "Arturo Pérez Reverte", 688));

        coleccion.cantmas500();

        System.out.println("--------------------------------");

        coleccion.cantmen300();

        System.out.println("--------------------------------");

        coleccion.titulosmas500();

        System.out.println("--------------------------------");

        coleccion.treslibrosmayorpag();

        System.out.println("--------------------------------");

        coleccion.totalpaginaslibros();

        System.out.println("--------------------------------");

        coleccion.librossuperprompag();

        System.out.println("--------------------------------");

        coleccion.totalAutores();

        System.out.println("--------------------------------");

        coleccion.autoresMasUnLibro();

        System.out.println("--------------------------------");

        coleccion.libroMayorPaginas();

        System.out.println("--------------------------------");

        coleccion.coleccionLibros();
        System.out.println("--------------------------------");

        coleccion.librosOrdenados();
    }
}