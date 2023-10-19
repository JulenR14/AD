package org.example;

import java.nio.file.Path;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Path ruta = Path.of(".", "src", "main", "resources", "atletas.xml");

        List<AtletaFeminina> lista = List.of(new AtletaFeminina("Juan", "España",20, List.of("100m", "200m")),
                                            new AtletaFeminina("Alex", "Portugal",30, List.of("100m", "200m")),
                                            new AtletaFeminina("Charles", "Irlanda",40, List.of("100m", "200m")));

        ListaAtletasFemeninas listaAtletas = new ListaAtletasFemeninas(lista);

        metodosListaAtletas.escribirDeListaAxml(listaAtletas, ruta);

        ListaAtletasFemeninas listaAtletas2 = metodosListaAtletas.leerDeXmlALista(ruta);

        System.out.println("Lista de atletas: ");
        System.out.println(listaAtletas2);


    }
}