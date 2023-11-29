package org.example.db;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.example.Piloto;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;


public class ConectarConBaseDatos {

    private static String url = "mongodb://Julen:1234@ec2-3-229-16-156.compute-1.amazonaws.com:27017";

    public static void pruebaConexion(){
        try(MongoClient mongoClient = MongoClients.create(url)){
            CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
            CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

            MongoDatabase database = mongoClient.getDatabase("f1-2006").withCodecRegistry(pojoCodecRegistry);
            MongoCollection<Piloto> collection = database.getCollection("drivers", Piloto.class);

            System.out.println("La cantidad de pilotos es : " + collection.countDocuments());
        }
    }

}
