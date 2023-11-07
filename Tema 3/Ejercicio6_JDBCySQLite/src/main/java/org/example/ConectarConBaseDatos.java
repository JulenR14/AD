package org.example;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConectarConBaseDatos {

    private static Path rutaBaseDatos = Path.of("src","main", "resources" , "db", "f12006sqlite.db");

    public static boolean crearYagregarPiloto(Piloto piloto){

        System.out.println(Files.exists(rutaBaseDatos));

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

            agregado = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return agregado;
    }

}
