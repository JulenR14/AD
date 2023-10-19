package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JacksonXmlRootElement(localName = "atletas")
public class ListaAtletasFemeninas {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "atleta")
    private List<AtletaFeminina> lista ;

    public List<AtletaFeminina> getLista() {
        return lista;
    }

    public void setLista(List<AtletaFeminina> lista) {
        this.lista = lista;
    }
    @Override
    public String toString() {
        String lista = "";

        for (AtletaFeminina atleta : this.lista) {
            lista += atleta.getNombre() + "\n";
        }
        return lista;
    }
}
