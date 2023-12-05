package org.example.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Data
@NoArgsConstructor
public class Cliente {

    private ObjectId id;
    private int clientid;
    private String dni;
    private String nombre;
    private String apellidos;
    private String nacionalidad;
    private String telefono;
    private String usuario;
    private String email;
    private String contrasenya;

    public Cliente(int clientid, String dni, String nombre, String apellidos, String nacionalidad, String telefono, String usuario, String email, String contrasenya) {
        this.clientid = clientid;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
        this.usuario = usuario;
        this.email = email;
        this.contrasenya = contrasenya;
    }
}
