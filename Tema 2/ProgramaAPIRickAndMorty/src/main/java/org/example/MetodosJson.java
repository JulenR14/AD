package org.example;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Path;
import java.util.*;

public class MetodosJson {

    public static List<Location> leerArrayObjetoJSONApi(){
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        try{
            //URL url  =  new URL("https://rickandmortyapi.com/api/location");

            //HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
            JsonNode rootNode = objectMapper.readTree(new URL("https://rickandmortyapi.com/api/location"));
            return objectMapper.readValue(rootNode.get("results").traverse(), new TypeReference<>(){});
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


}
