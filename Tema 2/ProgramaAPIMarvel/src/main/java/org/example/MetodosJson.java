package org.example;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Path;
import java.util.*;

public class MetodosJson {

    public static ObjetoAPI leerArrayObjetoJSONApi(){
        try{
            URL url  =  new URL("https://rickandmortyapi.com/api/location");

            HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();

            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(url, new TypeReference<>(){});
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


}
