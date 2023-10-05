package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    private final static String COMMA_DELIMITER = ",";
    private final static ArrayList<Funko> objsFunkos = new ArrayList<Funko>();

    public static void main(String[] args) throws IOException {

        try (Stream<String> coleccionFunkos = Files.lines(Path.of(".","src","main","resources","funkos.csv"))) {
            List<Funko> funkos = coleccionFunkos.map(l -> Arrays.asList(l.split(COMMA_DELIMITER))).skip(1).map(Funko::new).toList();

            objsFunkos.forEach(f -> System.out.println(f.getPrecio()));

        }catch (IOException e) {
            e.getMessage();
        }

    }
}