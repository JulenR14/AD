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

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Data
@NoArgsConstructor
public class ConectarConBaseDatos {

    private static String url = "mongodb://julen:1234@ec2-3-229-16-156.compute-1.amazonaws.com:27017/f1-2006?authSource=f1-2006";

    public static void crearPiloto(Drivers driver){
        Logger logger = LoggerFactory.getLogger("org.mongodb.driver");
        try(MongoClient mongoClient = MongoClients.create(url)){
            CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
            CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

            MongoDatabase database = mongoClient.getDatabase("f1-2006").withCodecRegistry(pojoCodecRegistry);
            MongoCollection<Drivers> collection = database.getCollection("drivers", Drivers.class);

            collection.insertOne(driver);
        }
    }

}
