package org.example;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.sql.Date;
import java.time.LocalDate;


@Data
@NoArgsConstructor
public class Drivers {

    ObjectId id;
    String code;
    Constructor constructors;
    LocalDate dob;
    int driverid;
    String forename;
    String nationality;
    String surname;
    String url;

    public Drivers(String code, Constructor constructors, LocalDate dob, int driverid, String forename, String nationality, String surname, String url) {

        this.driverid = driverid;
        this.code = code;
        this.forename = forename;
        this.surname = surname;
        this.dob = dob;
        this.nationality = nationality;
        this.constructors = constructors;
        this.url = url;
    }
}