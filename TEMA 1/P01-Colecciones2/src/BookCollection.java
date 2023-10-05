

import java.util.*;
import java.util.stream.Collectors;

public class BookCollection  {
    // ¿Qué tipo de colección es la más adecuada para almacenar los libros?
    ArrayList<Book> libros = new ArrayList<Book>();

    // Crea los métodos solicitados en el enunciado del ejercicio

    public void cantmas500() {

        long cantidad = libros.stream().filter(b -> b.pages() > 500).count();
/*
        for (Book b : libros) {
            if (b.pages() > 500) {
                cantidad++;
            }
        }
 */
        System.out.println("Pregunta 1 : Cantidad de libros con más de 500 páginas.\n" + cantidad);
    }

    public void cantmen300() {

        long cantidad = libros.stream().filter(b -> b.pages() < 300).count();

        /*
        for (Book b : libros) {
            if (b.pages() < 300) {
                cantidad++;
            }
        }
         */

        System.out.println("Pregunta 2 : Cantidad de libros con menos de 300 páginas.\n" + cantidad);
    }

    public void titulosmas500() {

        System.out.println("Pregunta 3 : Titulos de los libros con más de 500 páginas.");

        libros.stream().filter(b -> b.pages() > 500).map(Book::title).forEach(System.out::println);

        /*for (Book b : this.libros) {
            if (b.pages() > 500) {
                System.out.print(b.title() + "\n");
            }
        }
         */
    }

    public void treslibrosmayorpag() {

        /*libros.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o2.pages() - o1.pages();
            }
        });
        */
        System.out.println("Pregunta 4 : Los 3 libros con mayor numero de paginas. ");

        libros.stream().sorted((o1, o2) -> o2.pages() - o1.pages()).map(Book::title).limit(3).forEach(System.out::println);

        /*
        for (int i = 0; i < 3; i++) {
            System.out.println(libros.get(i).title());
        }
         */
    }

    public void totalpaginaslibros() {

        long totalPaginas = libros.stream().mapToInt(Book::pages).sum();
    /*
        for (Book b : libros) {
            totalPaginas += b.pages();
        }
    */
        System.out.println("Pregunta 5 : Suma total de las paginas de todos los libros : " + totalPaginas);
    }

    public void librossuperprompag() {

        System.out.println("Pregunta 6 : Libros que superan la media en cuanto a paginas se refiere");

        libros.stream().filter(b -> b.pages() > libros.stream().collect(Collectors.averagingInt(Book::pages)))
                .map(Book::title)
                .forEach(System.out::println);

        //int totalPaginas = 0;

        /*
        for (Book b : libros) {
            totalPaginas += b.pages();
        }

        System.out.println("Pregunta 6 : Libros que superan la media en cuanto a paginas se refiere");
        for (Book b : libros) {
            if (b.pages() > (totalPaginas / libros.size())) {
                System.out.println(b.title());
            }

        }
         */
    }

    public void totalAutores() {

        /*HashMap<String,String> autores = new HashMap<>();

        for (Book b : libros){
            if(!autores.containsKey(b.author())){
                autores.put(b.author(),b.title());
            }
        }

        System.out.println("Pregunta 7 : Todos los autores de todos los libros sin repetir nombres.");

        for (Map.Entry<String,String> entry : autores.entrySet()){
            System.out.println("Autor : " + entry.getKey());
        }


        HashSet<String> autores = new HashSet<>();

        for (Book b : libros) {
            autores.add(b.author());
        }

        System.out.println("Pregunta 7 : Todos los autores de todos los libros sin repetir nombres.");

        for (String a : autores) {
            System.out.println(a);
        }
*/

        System.out.println("Pregunta 7 : Todos los autores de todos los libros sin repetir nombres.");
        libros.stream().map(Book::author).distinct().forEach(System.out::println);
    }

    public void autoresMasUnLibro() {

        System.out.println("Pregunta 8 : Autores que tengan más de un libro.");

        Map<String, Long> listaLibros = libros.stream().collect(Collectors.groupingBy(Book::author, Collectors.counting()));

        listaLibros.entrySet().stream().filter(entry -> entry.getValue() > 1).forEach(entry -> System.out.println(entry.getKey()));

        /*HashMap<String, Integer> autores = new HashMap<>();
        int n = 0;

        System.out.println("Pregunta 8 : Autores que tengan más de un libro.");

        for (Book b : libros) {
            if (autores.containsKey(b.author())) {

                if (autores.get(b.author()) == 1) {
                    System.out.println(b.author());
                    n = autores.get(b.author()) + 1;
                    autores.put(b.author(), n);
                } else {
                    n = autores.get(b.author()) + 1;
                    autores.put(b.author(), n);
                }
            } else {
                autores.put(b.author(), 1);
            }
        }
         */
    }

    public void libroMayorPaginas() {

        /*
        libros.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o2.pages() - o1.pages();
            }
        });
        */

        System.out.println("Pregunta 9 : Libro con mayor numero de páginas :\n");

        libros.stream().sorted((o1, o2) -> o2.pages() - o1.pages()).limit(1).forEach(b -> System.out.println(b.title()));

    }

    public void coleccionLibros() {

        System.out.println("Pregunta 10 : Coleccion con todos los titulos de los libros.");

        for (Book b : libros){
            System.out.println("Libro : " + b.title());
        }

    }

    //metodo que ordena los libros de la A a la Z

    public void librosOrdenados(){

        libros.sort(Book::compareTo);

    }
}