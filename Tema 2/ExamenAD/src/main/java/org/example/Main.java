package org.example;

import org.example.entities.Actor;
import org.example.entities.Pelicula;
import org.example.entities.PeliculaOscarizada;
import org.example.utils.Utilidades;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Path oscarFemale = Path.of(".", "src", "main", "resources", "oscar_age_female.csv");
        Path oscarMale = Path.of(".", "src", "main", "resources", "oscar_age_male.csv");

        List<PeliculaOscarizada> listaPeliculas = Utilidades.leerPeliculasOscarizadasCsv(oscarFemale, oscarMale);

        //System.out.println("Lista de películas oscarizadas:");
        //listaPeliculas.forEach(pelicula -> System.out.println(pelicula.toString()));

        System.out.println("Lista de actores:");
        List<Actor> listaActores = Utilidades.convertirPeliculasOscarizadasEnActores(listaPeliculas);

        Utilidades.escribirActoresEnJson(Path.of(".", "src", "main", "resources", "salida","actores.json"), listaActores);

        Utilidades.actoresMasJovenesEnGanarUnOscar(listaPeliculas).forEach(System.out::println);

    }
}