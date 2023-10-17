package org.example;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.nio.file.Path;
import java.util.ArrayList;

public class ListaAtletasFemeninas {

    XmlMapper xmlMapper = new XmlMapper();
    ArrayList<AtletaFeminina> lista;

    public ListaAtletasFemeninas() {
        lista = new ArrayList<AtletaFeminina>();
    }

    public ArrayList<AtletaFeminina> leerObjetoXml(Path ruta){

    }
}
