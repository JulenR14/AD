package org.example.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.example.entities.Actor;
import org.example.entities.Pelicula;
import org.example.entities.PeliculaOscarizada;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Utilidades {

    // Métodos a implementar:

    // 1. leerPeliculasOscarizadasCsv: lee un fichero CSV y devuelve una lista de objetos PeliculaOscarizada.
    //                                 Debe tener en cuenta también el parámetro sexo para filtrar por sexo.

    public static List<PeliculaOscarizada> leerPeliculasOscarizadasCsv(Path rutacsvFemale, Path rutacsvMale){
        List<PeliculaOscarizada> peliculasOscarizadas = new ArrayList<>();

        try(Stream<String> contenidoFicheroFemale = Files.lines(rutacsvFemale);
            Stream<String> contenidoFicheroMale = Files.lines(rutacsvMale)){

            List<List<String>> contenidoFicheroListaFemale = contenidoFicheroFemale.map(linea -> Arrays.asList(linea.split(";"))).skip(1).toList();
            List<List<String>> contenidoFicheroListaMale = contenidoFicheroMale.map(linea -> Arrays.asList(linea.split(";"))).skip(1).toList();

            contenidoFicheroListaFemale.forEach(linea -> {
                peliculasOscarizadas.add(new PeliculaOscarizada(Integer.parseInt(linea.get(1)), Integer.parseInt(linea.get(2)), linea.get(3), linea.get(4), "M"));
            });
            contenidoFicheroListaMale.forEach(linea -> {
                peliculasOscarizadas.add(new PeliculaOscarizada(Integer.parseInt(linea.get(1)), Integer.parseInt(linea.get(2)), linea.get(3), linea.get(4), "H"));
            });

            return peliculasOscarizadas;
        }catch(IOException e){
            e.printStackTrace(System.out);
        }
        return peliculasOscarizadas;
    }
    // 2. convertirPeliculasOscarizadasEnActores: dada una lista de PeliculasOscarizadas, devuelve una lista de objetos Actor
    //                                 en la que estarán incluidos todos los actores y actrices.
    public static List<Actor> convertirPeliculasOscarizadasEnActores(List<PeliculaOscarizada> peliculasOscarizadas){
        List<Actor> actores = new ArrayList<>();

        peliculasOscarizadas.forEach(pelicula -> {
            if(!actores.contains(pelicula.getActor())){
                actores.add(new Actor(pelicula.getActor(), pelicula.getSexo(), (pelicula.getAnyo()-pelicula.getEdad()),
                        peliculasOscarizadas.stream().filter(p -> p.getActor().equals(pelicula.getActor())).map(p -> new Pelicula(p.getPelicula(), p.getAnyo())).toList()));
            }
        });

        return actores;
    }

    // 3. escribirActoresenJson: escribe en un fichero JSON la lista de actores/actrices en el formato solicitado.
    public static void escribirActoresEnJson(Path rutaJson, List<Actor> actores) {
        try {
            ObjectMapper objetMapper = new ObjectMapper();
            objetMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objetMapper.writeValue(rutaJson.toFile(), actores);

        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

    // 4. actoresConMasdeUnOscar: devuelve una lista de Strings con los nombres de los actores/actrices que hayan ganado más de un Oscar.
    public static List<Actor> actoresConMasDeUnOscar(List<Actor> actores){
        List<Actor> actoresConMasDeUnOscar = new ArrayList<>();

        actores.forEach(actor -> {
            if(actor.getPeliculas().size() > 1){
                actoresConMasDeUnOscar.add(actor);
            }
        });

        return actoresConMasDeUnOscar;
    }

    // 5. actoresMasJovenesEnGanarUnOscar: devuelve una lista de Strings con el actor y la actriz más jóvenes en ganar un Oscar.
    public static List<String> actoresMasJovenesEnGanarUnOscar(List<PeliculaOscarizada> peliculas){
        List<String> actoresMasJovenesEnGanarUnOscar = new ArrayList<>();

        String actorMasJoven = peliculas.get(0).getActor();
        String actrizMasJoven = peliculas.get(0).getActor();

        int edadActorJoven = Integer.MAX_VALUE;
        int edadActrizJoven = Integer.MAX_VALUE;

        for(int i = 0; i < peliculas.size(); i++){
            if(peliculas.get(i).getSexo().equals("M")){
                if(peliculas.get(i).getEdad() < edadActorJoven){
                    actorMasJoven = peliculas.get(i).getActor();
                    edadActorJoven = peliculas.get(i).getEdad();
                }
            }else{
                if (peliculas.get(i).getEdad() < edadActrizJoven){
                    actrizMasJoven = peliculas.get(i).getActor();
                    edadActrizJoven = peliculas.get(i).getEdad();
                }
            }
        }

        actoresMasJovenesEnGanarUnOscar.add(actorMasJoven);
        actoresMasJovenesEnGanarUnOscar.add(actrizMasJoven);

        return actoresMasJovenesEnGanarUnOscar;
    }
}
