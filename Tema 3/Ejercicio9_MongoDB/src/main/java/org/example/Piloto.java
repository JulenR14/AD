package org.example;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Piloto {

    private int driverId;
    private String code;
    private String forename;
    private String surname;
    private String dob;
    private String nationality;
    private String url;

    public Piloto(String code, String forename, String surname, String dob, String nacionality, String url){
        this.code = code;
        this.forename = forename;
        this.surname = surname;
        this.dob = dob;
        this.nationality = nacionality;
        this.url = url;
    }
}