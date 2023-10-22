package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.util.List;

import java.io.IOException;
import java.nio.file.Path;

public class MetodosJSON {

    public static void escribirListaEnJSON(List<Book> lista, Path rutaFichero){
        try{
            ObjectMapper objetMapper = new ObjectMapper();
            objetMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objetMapper.writeValue(rutaFichero.toFile(), lista);

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static List<Book> leerArrayObjetoJSON(Path rutaFicheroLeer) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(rutaFicheroLeer.toFile(), new TypeReference<>() { });
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public static String buscarLibrosConFilto(String filtro, List<Book> lista){
        String resultado = "";
        for(Book libro: lista){
            if (libro.getTitulo().equalsIgnoreCase(filtro) || libro.getAutor().equalsIgnoreCase(filtro)){
                resultado = libro.toString();
            }
        }
        return resultado;
    }
}
