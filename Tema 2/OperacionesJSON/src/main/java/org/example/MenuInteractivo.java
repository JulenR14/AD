package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MenuInteractivo {

    //atributos
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String busqueda = "";

    /*
    * Metodo que muestra un menu interactivo con las opciones.
     */
    public static void menu(ArrayList<Book> lista) throws IOException {

        String menu = "";

        do{
            //menu interactivo
            System.out.println("MENU\n" +
                    "-Opcion 1 : Añadir nuevo libro.\n" +
                    "-Opcion 2 : Buscar libro.\n" +
                    "-Opcion 3 : Ver lista de todos los libros.\n" +
                    "-Opcion 4 : Salir del menu.");

            menu = bf.readLine();

            //switch para las opciones del menu
            switch (menu){
                case "1":
                    agregarLibro(lista);
                    break;

                case "2":
                    buscarLibro(lista);
                    break;

                case "3":
                    System.out.println("La lista de libros es : ");
                    verLista(lista);
                    break;
            }
        }while(!menu.equals("4"));
    }

    private static void agregarLibro(ArrayList<Book> lista) throws IOException {
        //atributos
        String isbn, titulo, autor;
        int numeroPaginas, anyPublicacion;
        boolean repetido = false;

        //pedimos los datos del libro
        System.out.println("Introduce el ISBN del libro : ");
        isbn = bf.readLine();
        System.out.println("Introduce el titulo del libro : ");
        titulo = bf.readLine();
        System.out.println("Introduce el autor del libro : ");
        autor = bf.readLine();
        System.out.println("Introduce el numero de paginas del libro : ");
        numeroPaginas = Integer.parseInt(bf.readLine());
        System.out.println("Introduce el año de publicacion del libro : ");
        anyPublicacion = Integer.parseInt(bf.readLine());

        //comprobamos si el libro ya existe en la lista
        for(Book libro: lista){
            if(titulo.equalsIgnoreCase(libro.getTitulo()) || autor.equalsIgnoreCase(libro.getAutor())){
                repetido = true;
            }
        }
        //si no existe lo añadimos a la lista
        if(!repetido){
            lista.add(new Book(isbn, titulo, autor, numeroPaginas, anyPublicacion));
        }else{
            System.out.println("El libro ya existe en la lista.");
        }
    }

    private static void buscarLibro(ArrayList<Book> lista) throws IOException {
        String busqueda = "";

        System.out.println("Escribe el autor o titulo del libro que quieres buscar : ");
        busqueda = bf.readLine();
        //buscamos el libro con el filtro
        System.out.println(MetodosJSON.buscarLibrosConFilto(busqueda, lista));
    }

    private static void verLista(ArrayList<Book> lista){
        lista.forEach(b -> System.out.println(b.toString()));
    }
}
