package org.example;


import jakarta.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String password = "12374f4c3617a5ab259248791a3a144b2bf6976cb3276cd0ae7e143e6f8964fad74e7647f";

        String urlWeb = "https://gateway.marvel.com/v1/public/comics?ts=1&apikey=3276cd0ae7e143e6f8964fad74e7647f&hash=cc3bfd21077c57373627025c432be8aa";

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest(password.getBytes(StandardCharsets.UTF_8));
        String md5 = DatatypeConverter.printHexBinary(digest);

        // imprimir resumen de mensaje MD5
        System.out.println(md5.toLowerCase());
    }
}