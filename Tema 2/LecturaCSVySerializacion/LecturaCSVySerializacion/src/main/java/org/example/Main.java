package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

public class Main {

    private final static String COMMA_DELIMITER = ",";

    public static void main(String[] args) throws IOException {

        try (Stream<String> coleccionFunkos = Files.lines(Path.of(".", "src", "main", "resources", "funkos.csv"))) {

            //Creamos una lista de objetos funko segun la informacion del anterior Stream, del que hemos sacado la informacion de funkos.csv
            List<Funko> funkos = coleccionFunkos.map(l -> Arrays.asList(l.split(COMMA_DELIMITER))).skip(1).map(Funko::new).toList();

            //llamo al metodo que me devolvera el funko mas caro
            System.out.println("PUNTO 1 -- El funko mas caro es : " + funkoMasCaro(funkos).getNombre());
            //llamo al metodo que devuelve la media de los precios de Funkos, y lo redondeamos a dos decimales con Math.random()
            System.out.println("PUNTO 2 -- La media de los precios de los Funkos es : " + (double)Math.round(mediaPrecioFunkos(funkos)*100)/100);
            //llamo al metodo que devuelve los Funkos agrupados por modelos
            System.out.println("PUNTO 3 -- Funkos agrupados por modelos\n" + funkosAgrupadosPorModelos(funkos));
            //llamo al metodo que muestra la cantidad de funkos para cada modelo
            System.out.println("PUNTO 4 -- Cantidad de funkos por modelos :");
            numeroFunkosPorModelos(funkos);
            //llamo al metodo que devuelve la cantidad de funkos lanzados en 2023
            System.out.println("PUNTO 5 -- Funkos lanzados en 2023 : " + cantidadFunkos2023(funkos));

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    //metodo que devuelve el funko mas caro
    public static Funko funkoMasCaro(List<Funko> listaFunkos){
        //ordena de menor a mayor los funkos por precio, los convierte en una lista y devuelve el funko en la ultima posicion de la lista ordenada
        return listaFunkos.stream().sorted(Comparator.comparing(Funko::getPrecio))
                .toList()
                .get(listaFunkos.size()-1);
    }

    //metodo que devuelve la media de los precios de Funkos
    public static double mediaPrecioFunkos(List<Funko> listaFunkos){
        double total = 0;

        //almacenamos en total la suma de todos los precios de los objetos Funko de la lista
        total = listaFunkos.stream().mapToDouble(Funko::getPrecio).sum();

        //devolvemos la division entre el total y la cantidad de funkos de la lista
        return (double)(Math.round(total/listaFunkos.size()*100)/100);
    }

    //metodo que agrupa todos los Funkos por modelos
    public static Map funkosAgrupadosPorModelos(List<Funko> listaFunkos){

        //HashMap donde almacenamremos los Funkos
        HashMap<String, List<Funko>> agrupadosPorModelos = new HashMap<String, List<Funko>>();
        //agrupamos por el modelo la lista que nos pasan por parametro, y los recorremos para ir añadiendolos a el HashMap
        listaFunkos.stream().collect(Collectors.groupingBy(Funko::getModelo))
                .forEach((k,v)->agrupadosPorModelos.put(k, v.stream().toList()));
        //imprimimos el HashMap
        return agrupadosPorModelos;
    }

    //metodo que muestra el numero de funkos que tiene cada modelo de funko
    public static void numeroFunkosPorModelos(List<Funko> listaFunkos){
        //agrupamos la lista por el modelo de cada funko, y realizamos un bucle para mostrar por cada modelo su cantidad de funkos
        listaFunkos.stream().collect(Collectors.groupingBy(Funko::getModelo))
                .forEach((k,v) -> System.out.println(k + " : " + v.size()));
    }

    //metodo que devuelve la cantidad de funkos lanzados en 2023
    public static long cantidadFunkos2023(List<Funko> listaFunkos){
        //filtramos la lista por los funkos que hayan sido lanzados en el año 2023, y luego utilizamos count() para que nos de la cantidad
        return listaFunkos.stream().filter(f -> f.getFecha().getYear() == 2023).count();
    }

}