package org.example.db;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.example.entities.Cliente;
import org.example.entities.Cuenta;

import java.sql.*;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class Conectardb {

    static String urlConexionPostgres = "jdbc:postgresql://examenad.ci66saah1axn.us-east-1.rds.amazonaws.com:5432/redper";
    static String usuarioPostgrres = "postgres";
    static String passwordPostgres = "qwerty1234";

    private static String urlMongodb = "mongodb://redper:qwerty1234@ec2-54-146-188-92.compute-1.amazonaws.com:27017/";
    private static MongoCollection<Cliente> collection;
//    public static void probar(){
//        String connectionString = "mongodb://localhost:27017"; // Reemplaza con la URL de tu servidor MongoDB
//
//        // Configuración del cliente
//        ConnectionString connString = new ConnectionString(connectionString);
//        MongoClientSettings settings = MongoClientSettings.builder()
//                .applyConnectionString(connString)
//                .build();
//
//        // Crear el cliente MongoDB
//        try (MongoClient mongoClient = MongoClients.create(settings)) {
//            System.out.println("Conexión exitosa a MongoDB.");
//
//            // Realizar otras operaciones aquí si es necesario
//
//        } catch (Exception e) {
//            System.err.println("Error al conectar a MongoDB: " + e.getMessage());
//        }
//
//        System.out.println("Conectando a la base de datos...");
//        try (Connection conexion = DriverManager.getConnection(urlConexionPostgres, usuarioPostgrres, passwordPostgres)) {
//            System.out.println("Conectado a la base de datos");
//
//            String sql = "SELECT * FROM accounts";
//            PreparedStatement sentencia = conexion.prepareStatement(sql);
//            ResultSet resultado = sentencia.executeQuery();
//
//            while (resultado.next()) {
//                System.out.println(resultado.getString("iban"));
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }

//    public static void buscarCliente(){
//        try(MongoClient mongoClient = MongoClients.create(urlMongodb)){
//            CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
//            CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));
//
//            MongoDatabase database = mongoClient.getDatabase("redper").withCodecRegistry(pojoCodecRegistry);
//            collection = database.getCollection("clients", Cliente.class);
//
//            System.out.println(collection.find(eq("dni", "66459472Y")).first());
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }

    public static void crearCliente(Cliente cliente){
        try(MongoClient mongoClient = MongoClients.create(urlMongodb)){
            CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
            CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

            MongoDatabase database = mongoClient.getDatabase("redper").withCodecRegistry(pojoCodecRegistry);
            collection = database.getCollection("clients", Cliente.class);

            collection.insertOne(cliente);

            //System.out.println(collection.find(eq("dni", cliente.getDni())).first());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void crearCuenta(Cuenta cuenta){
        try(Connection conexion = DriverManager.getConnection(urlConexionPostgres, usuarioPostgrres, passwordPostgres)){
            String sql = "INSERT INTO accounts (iban, balance, clientid) VALUES (?, ?, ?)";
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, cuenta.getIban());
            sentencia.setDouble(2, cuenta.getBalance());
            sentencia.setInt(3, cuenta.getClientid());

            sentencia.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void borrarCliente(int id){
        try(MongoClient mongoClient = MongoClients.create(urlMongodb)){
            CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
            CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

            MongoDatabase database = mongoClient.getDatabase("redper").withCodecRegistry(pojoCodecRegistry);
            collection = database.getCollection("clients", Cliente.class);

            collection.deleteOne(eq("clientid", id));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void borrarCuenta(int id){
        try(Connection conexion = DriverManager.getConnection(urlConexionPostgres, usuarioPostgrres, passwordPostgres)){
            String sql = "DELETE FROM accounts WHERE accountid = ?";
            PreparedStatement sentencia = conexion.prepareStatement(sql);

            sentencia.setInt(1, id);

            sentencia.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void modificarCliente(Cliente cliente){
        try(MongoClient mongoClient = MongoClients.create(urlMongodb)){
            CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
            CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

            MongoDatabase database = mongoClient.getDatabase("redper").withCodecRegistry(pojoCodecRegistry);
            collection = database.getCollection("clients", Cliente.class);

            collection.replaceOne(eq("dni", cliente.getDni()), cliente);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void modificarCuenta(Cuenta cuenta){
        try(Connection conexion = DriverManager.getConnection(urlConexionPostgres, usuarioPostgrres, passwordPostgres)){
            String sql = "UPDATE accounts SET balance = ? WHERE iban = ?";
            PreparedStatement sentencia = conexion.prepareStatement(sql);

            sentencia.setDouble(1, cuenta.getBalance());
            sentencia.setString(2, cuenta.getIban());

            sentencia.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void mostrarClientes(){
        try(MongoClient mongoClient = MongoClients.create(urlMongodb)){
            CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
            CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

            MongoDatabase database = mongoClient.getDatabase("redper").withCodecRegistry(pojoCodecRegistry);
            collection = database.getCollection("clients", Cliente.class);

            collection.find().forEach(System.out::println);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void mostrarCuentas(){
        try(Connection conexion = DriverManager.getConnection(urlConexionPostgres, usuarioPostgrres, passwordPostgres)){
            String sql = "SELECT * FROM accounts";
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()) {
                System.out.println(resultado.getString("iban") + " -- " +
                        "Balance: " + resultado.getDouble("balance") + " -- " +
                        "Cliente: " + resultado.getInt("clientid"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void transaction(Cuenta origen, Cuenta destino, double cantidad){
        try(Connection conexion = DriverManager.getConnection(urlConexionPostgres, usuarioPostgrres, passwordPostgres)){
            try{
                conexion.setAutoCommit(false);

                String sql = "UPDATE accounts SET balance = ? WHERE iban = ?";
                PreparedStatement sentencia = conexion.prepareStatement(sql);

                double cantidadOrigen = origen.getBalance() - cantidad;
                sentencia.setDouble(1, cantidadOrigen);
                sentencia.setString(2, origen.getIban());

                sentencia.executeUpdate();

                double cantidadDestino = destino.getBalance() + cantidad;
                sentencia.setDouble(1, cantidadDestino);
                sentencia.setString(2, destino.getIban());

                sentencia.executeUpdate();

                if (cantidadOrigen < 0){
                    throw new Exception();
                }

                conexion.commit();
                conexion.setAutoCommit(true);
            }catch (Exception e){
                conexion.rollback();
                System.out.println("No se ha podido realizar la transacción");
            }
    }catch (Exception e){
        e.printStackTrace();
    }
    }
}
