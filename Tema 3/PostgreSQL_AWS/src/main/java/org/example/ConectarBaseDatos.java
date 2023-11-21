package org.example;

import java.sql.*;

public class ConectarBaseDatos {

    static String urlConexion = "jdbc:postgresql://database-1.cjr33uc9tdri.us-east-1.rds.amazonaws.com:5432/f12006";
    static String usuario = "postgres";
    static String password = "12345678";

    public static void agregarPiloto(Corredor piloto) {
        System.out.println(piloto.getEquipo().getId());
        try(Connection conexion = DriverManager.getConnection(urlConexion, usuario, password)){
            try{
            //desactivamos la confirmacion automatica
            conexion.setAutoCommit(false);

            //comprobamos si existe el equipo del piloto y si no existe lo creamos
            Equipo equipoPiloto = piloto.getEquipo();
            String insertarEquipo = "INSERT INTO constructors (constructorref, name, nationality, url) VALUES (?, ?, ?, ?)" +
                                    "ON CONFLICT (constructorid) DO NOTHING";

            PreparedStatement sentenciaEquipo = conexion.prepareStatement(insertarEquipo, PreparedStatement.RETURN_GENERATED_KEYS);

            sentenciaEquipo.setString(1, equipoPiloto.getReferencia());
            sentenciaEquipo.setString(2, equipoPiloto.getNombre());
            sentenciaEquipo.setString(3, equipoPiloto.getNacionalidad());
            sentenciaEquipo.setString(4, equipoPiloto.getUrl());

            sentenciaEquipo.executeUpdate();
            //obtenemos el id del equipo
            ResultSet resultSet = sentenciaEquipo.getGeneratedKeys();
            resultSet.next();
            int idEquipo = resultSet.getInt(1);

                System.out.println("El id del equipo es: " + idEquipo);

            //insertamos el piloto
            String insertarPiloto = "INSERT INTO drivers (code, forename, surname, dob, nationality, constructorid, url) VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement sentenciaPiloto = conexion.prepareStatement(insertarPiloto);
            sentenciaPiloto.setString(1, piloto.getCode());
            sentenciaPiloto.setString(2, piloto.getNombre());
            sentenciaPiloto.setString(3, piloto.getApodo());
            sentenciaPiloto.setDate(4, new Date(piloto.getFechaNacimiento().getTime()));
            sentenciaPiloto.setString(5, piloto.getNacionalidad());
            sentenciaPiloto.setInt(6, idEquipo);
            sentenciaPiloto.setString(7, piloto.getUrl());

            sentenciaPiloto.executeUpdate();

            conexion.commit();
            conexion.setAutoCommit(true);

            }catch (SQLException e){
                conexion.rollback();
                System.out.println("Se hizo rollback" + "\n" +e.getMessage());
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        System.out.println(piloto.getEquipo().getId());
    }
}
