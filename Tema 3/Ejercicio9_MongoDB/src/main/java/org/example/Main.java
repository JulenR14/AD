package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.Data;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.example.db.ConectarConBaseDatos;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        ConectarConBaseDatos conectar = new ConectarConBaseDatos();
        //conectar.crearPiloto(new Drivers("HAM", new Constructor("mercedes", "Mercedes", "German", "https://en.wikipedia.org/wiki/Mercedes-Benz_in_Formula_One"), LocalDate.of(1985, 1, 7), 1, "Lewis", "British", "Hamilton", "https://en.wikipedia.org/wiki/Lewis_Hamilton"));
        //conectar.buscarPilotoPorId(1);
        //conectar.todosLosPilotos();
        //conectar.actualizarPiloto(new Drivers("HAM", new Constructor("mercedes", "Mercedes", "German", "https://en.wikipedia.org/wiki/Mercedes-Benz_in_Formula_One"), LocalDate.of(1985, 1, 7), 1, "Lewis", "British", "Hamilton", "https://en.wikipedia.org/wiki/Lewis_Hamilton"));
        //conectar.borrarPiloto(new Drivers("HAM", new Constructor("mercedes", "Mercedes", "German", "https://en.wikipedia.org/wiki/Mercedes-Benz_in_Formula_One"), LocalDate.of(1985, 1, 7), 1, "Lewis", "British", "Hamilton", "https://en.wikipedia.org/wiki/Lewis_Hamilton"));
        //conectar.todosLosPilotos();
        //conectar.mostrarPilotosOrdenadosPorEdadDescendente();
        //conectar.mostrarPilotosConEdadMayorQue(30);
    }
}