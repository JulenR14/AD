package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Stream;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    private final static String COMMA_DELIMITER = ",";

    public static void main(String[] args) throws IOException {

        try (Stream<String> coleccionFunkos = Files.lines(Path.of(".","src","main","resources","funkos.csv"))) {
            List<Funko> funkos = coleccionFunkos.map(l -> Arrays.asList(l.split(COMMA_DELIMITER))).skip(1).map(Funko::new).toList();

            //funkos.forEach(f -> System.out.println(f.getNombre()));

            //llamo al metodo que me devolvera el funko mas caro
            System.out.println(funkoMasCaro(funkos).getPrecio());

        }catch (IOException e) {
            e.getMessage();
        }

    }

    //metodo que devuelve el funko mas caro
    public static Funko funkoMasCaro(List<Funko> listaFunkos){
        //ordena de menor a mayor los funkos por precio, los convierte en una lista y devuelve el funko en la ultima posicion de la lista ordenada
        return listaFunkos.stream().sorted(Comparator.comparing(Funko::getPrecio)).toList().get(listaFunkos.size());
    }
}