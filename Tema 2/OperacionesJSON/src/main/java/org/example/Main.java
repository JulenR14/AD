package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.nio.file.Path;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){

        //atributos
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String busqueda = "";

        //ruta donde se almacenara el fichero Json
        Path ruta = Path.of("src/main/resources/books.json");
        //lista de libros
        ArrayList<Book> listaBooks = new ArrayList<>() {{
            add(new Book("1234", "El Quijote", "Cervantes", 1000, 1605));
            add(new Book("5678", "El Buscón", "Quevedo", 200, 1626));
            add(new Book("9012", "La Celestina", "Fernando de Rojas", 300, 1499));
            add(new Book("3456", "La vida es sueño", "Calderón de la Barca", 400, 1635));
        }};

        //escribimos la lista de libros en el fichero Json
        MetodosJSON.escribirListaEnJSON(listaBooks, ruta);
        //leemos la lista de libros del fichero Json
        ArrayList<Book> nuevaListaBooks = (ArrayList<Book>) MetodosJSON.leerArrayObjetoJSON(ruta);

        //mostramos la lista de libros nueva
        System.out.println("La lista recogida del fichero Json : ");
        nuevaListaBooks.forEach(b -> System.out.println(b.toString()));


        try {
            //menu interactivo
            MenuInteractivo.menu(nuevaListaBooks);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("MUCHAS GRACIAS POR PARTICIPAR.");
    }
}