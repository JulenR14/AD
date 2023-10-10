package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MainTest {

    @Mock
    private Funko funkoTestUno;
    @Mock
    private Funko funkoTestDos;
    @InjectMocks
    private ArrayList<Funko> funkos;

   @Test
   @BeforeEach
   public void iniciar(){

       //instanciamos dos funkos para las pruebas, y las añadimos a una lista
       when(funkoTestUno.getPrecio()).thenReturn(55f);
       when(funkoTestDos.getPrecio()).thenReturn(80f);
   }

    @Test
    void testFunkoMasCaro() {

        when(funkoTestDos.getNombre()).thenReturn("Pepe");
       //comparamos que sea igual el funko mas caro con el que nos devuelve el metodo
        assertEquals("Pepe", Main.funkoMasCaro(funkos).get().getNombre());
    }

    @Test
    void mediaPrecioFunkos() {
       //calculamos la media redondeando los decimales a solo dos
       double media = (double)(Math.round(((funkoTestDos.getPrecio() + funkoTestUno.getPrecio())/2)*100)/100);
        //comparamos la media correcta con la media que nos tiene que devolver el metodo
       assertEquals(media, Main.mediaPrecioFunkos(funkos));
    }

    @Test
    void funkosAgrupadosPorModelos() {

        HashMap<String, List<Funko>> mapTest = new HashMap<String, List<Funko>>();
        mapTest.put(funkoTestUno.getModelo(), new ArrayList<Funko>(Arrays.asList(funkoTestUno)));
        mapTest.put(funkoTestDos.getModelo(), new ArrayList<Funko>(Arrays.asList(funkoTestDos)));

        assertEquals(mapTest, Main.funkosAgrupadosPorModelos(funkos));
    }

    @Test
    void cantidadFunkos2023() {
       assertEquals(1, Main.cantidadFunkos2023(funkos));

    }

}