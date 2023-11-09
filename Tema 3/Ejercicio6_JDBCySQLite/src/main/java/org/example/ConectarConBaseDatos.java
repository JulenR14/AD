package org.example;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;

public class ConectarConBaseDatos {

    private static Path rutaBaseDatos = Path.of("src","main", "resources" , "db", "f12006sqlite.db");

    public static boolean crearYagregarPiloto(Piloto piloto){
        boolean agregado = false;

        String agregarPiloto = "INSERT INTO drivers (code, forename, surname, dob, nationality, url) VALUES (?,?,?,?,?,?)";

        try(Connection conexion = DriverManager.getConnection("jdbc:sqlite:" + rutaBaseDatos.toString());
            PreparedStatement insercion = conexion.prepareStatement(agregarPiloto)){

            insercion.setString(1, piloto.getCode());
            insercion.setString(2, piloto.getForename());
            insercion.setString(3, piloto.getSurname());
            insercion.setString(4, piloto.getDob());
            insercion.setString(5, piloto.getNationality());
            insercion.setString(6, piloto.getUrl());

            insercion.executeUpdate();

            agregado = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return agregado;
    }

    public static Piloto leerPilotos(int id){

        String consultaSQL = "SELECT * FROM drivers WHERE driverId = ?";

        try(Connection conexion = DriverManager.getConnection("jdbc:sqlite:" + rutaBaseDatos.toString());
            PreparedStatement consulta = conexion.prepareStatement(consultaSQL);){
            consulta.setInt(1, id);
            ResultSet resultado = consulta.executeQuery();
            return new Piloto(resultado.getInt("driverId"),
                    resultado.getString("code"),
                    resultado.getString("forename"),
                    resultado.getString("surname"),
                    resultado.getString("dob"),
                    resultado.getString("nationality"),
                    resultado.getString("url"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Piloto> leerPilotos(){
        ArrayList<Piloto> pilotos = new ArrayList<>();
        String consultaSQL = "SELECT * FROM drivers";

        try (Connection conexion = DriverManager.getConnection("jdbc:sqlite:" + rutaBaseDatos.toString());
             PreparedStatement consulta = conexion.prepareStatement(consultaSQL);){

            ResultSet resultado = consulta.executeQuery();

            while (resultado.next()){
                pilotos.add(new Piloto(resultado.getInt("driverId"),
                        resultado.getString("code"),
                        resultado.getString("forename"),
                        resultado.getString("surname"),
                        resultado.getString("dob"),
                        resultado.getString("nationality"),
                        resultado.getString("url")));
            }

            return pilotos;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean actualizarPiloto(Piloto piloto){
        String consultaSQL = "UPDATE drivers SET code = ?, forename = ?, surname = ?, dob = ?, nationality = ?, url = ? WHERE driverId = ?";
        try(Connection conexion = DriverManager.getConnection("jdbc:sqlite:" + rutaBaseDatos.toString());
            PreparedStatement consulta = conexion.prepareStatement(consultaSQL);){

            consulta.setString(1, piloto.getCode());
            consulta.setString(2, piloto.getForename());
            consulta.setString(3, piloto.getSurname());
            consulta.setString(4, piloto.getDob());
            consulta.setString(5, piloto.getNationality());
            consulta.setString(6, piloto.getUrl());
            consulta.setInt(7, piloto.getDriverId());

            consulta.executeUpdate();

            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean borrarPiloto(Piloto piloto){
        String consultaSQL = "DELETE FROM drivers WHERE driverId = ?";
        try(Connection conexion = DriverManager.getConnection("jdbc:sqlite:" + rutaBaseDatos.toString());
            PreparedStatement consulta = conexion.prepareStatement(consultaSQL);){

            consulta.setInt(1, piloto.getDriverId());

            consulta.executeUpdate();

            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void mostrarClasificacionPiloto(){
        String consultaSQL = "SELECT d.code, sum(r.points) AS puntos FROM drivers d JOIN results r " +
                "ON d.driverid = r.driverid GROUP BY d.code ORDER BY puntos DESC";

        try(Connection conexion = DriverManager.getConnection("jdbc:sqlite:" + rutaBaseDatos.toString());
            PreparedStatement consulta = conexion.prepareStatement(consultaSQL);){

            ResultSet resultado = consulta.executeQuery();

            while (resultado.next()){
                System.out.println(resultado.getString("code") + " " + resultado.getInt("puntos"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void mostrarClasificacionContructores(){
        
    }
}
