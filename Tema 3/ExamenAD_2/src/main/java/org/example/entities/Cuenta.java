package org.example.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Cuenta {

    private int accountid;
    private String iban;
    private double balance;
    private int clientid;

    public Cuenta(String iban, double balance, int clientid) {
        this.iban = iban;
        this.balance = balance;
        this.clientid = clientid;
    }
}
