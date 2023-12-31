
package org.example;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Path;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {


        List<Location> locations = new ArrayList<>();

        locations = MetodosJson.leerArrayObjetoJSONApi();

        System.out.println("Localizaciones que forman parte de la Dimension C-137:");
        locations.stream().filter(localizacion -> localizacion.getDimension()
                .equals("Dimension C-137"))
                .forEach(localizacion -> System.out.println("- Nombre : " + localizacion.getName() + "\n" +
                                    " - Su creacion ha sido : " + localizacion.getCreated()));
    }
}