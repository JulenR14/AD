package org.example.db;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.example.Drivers;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

@Data
public class ConectarConBaseDatos {

    private static String url = "mongodb://julen:1234@ec2-3-229-16-156.compute-1.amazonaws.com:27017/f1-2006?authSource=f1-2006";
    private MongoCollection<Drivers> collection;

    public ConectarConBaseDatos() {
        try{
            MongoClient mongoClient = MongoClients.create(url);
            CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
            CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

            MongoDatabase database = mongoClient.getDatabase("f1-2006").withCodecRegistry(pojoCodecRegistry);
            this.collection = database.getCollection("drivers", Drivers.class);
        }catch (Exception e){
            System.out.println("Error al conectar con la base de datos");
        }
    }
    public void crearPiloto(Drivers driver){
        this.collection.insertOne(driver);
    }

    public void buscarPilotoPorId(int id){
        System.out.println(this.collection.find(eq("driverid", id)).first());
    }

    public void todosLosPilotos(){
        collection.find().forEach(System.out::println);
    }

    public void actualizarPiloto(Drivers driver){
        collection.replaceOne(eq("driverid", driver.getDriverid()), driver);
    }

    public void borrarPiloto(Drivers driver){
        collection.deleteOne(eq("driverid", driver.getDriverid()));
    }

    public void mostrarPilotosOrdenadosPorEdadDescendente(){
        List<Drivers> drivers = collection.find().into(new ArrayList<>());
        drivers.sort((d1, d2) -> d2.getAgeIn2006() - d1.getAgeIn2006());
        drivers.forEach(System.out::println);
    }

    public void mostrarPilotosConEdadMayorQue(int edad){
        List<Drivers> drivers = collection.find().into(new ArrayList<>());
        drivers.stream().filter(d -> d.getAgeIn2006() > edad).forEach(System.out::println);
    }
}
