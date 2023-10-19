package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class metodosListaAtletas {


    public static void escribirDeListaAxml(ListaAtletasFemeninas lista, Path ruta){
        try{
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
            xmlMapper.writeValue(ruta.toFile(), lista);
        }catch (IOException e){
            System.out.println("El fichero no existe.");
        }
    }

    public static ListaAtletasFemeninas leerDeXmlALista(Path ruta){
        try{
            return new XmlMapper().readValue(ruta.toFile(), ListaAtletasFemeninas.class);
        }catch (IOException e){
            throw new RuntimeException(e.getMessage());
        }
    }

}
