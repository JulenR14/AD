package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    private final static String COMMA_DELIMITER = ",";

    public static void main(String[] args) throws IOException {

        try (Stream<String> coleccionFunkos = Files.lines(Path.of(".","src","main","resources","funkos.csv"))) {
            List<List<String>> funkos = coleccionFunkos.map(f -> Arrays.asList(f.split(COMMA_DELIMITER))).toList();

            funkos.stream().forEach(f -> System.out.println(f));
        }catch (IOException e) {
            e.getMessage();
        }

    }
}