import org.example.entities.Actor;
import org.example.entities.Pelicula;
import org.example.utils.Utilidades;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class UtilidadesTest {

    //donde compruebes el funcionamiento del método actoresConMasDeUnOscar,
    //que devuelve una lista con los nombres de los actores y actrices con más de un Oscar.
    @Test
    public void actoresConMasDeUnOscarTest() {
        List<Actor> listaActores = new ArrayList<>() {
            {
                add(new Actor("actor1", "M", 1990, new ArrayList<>(){{add(new Pelicula("pelicula1", 1990));
                    add(new Pelicula("pelicula2", 1990));}}));
                add(new Actor("actor2", "M", 1990, new ArrayList<>(){{add(new Pelicula("pelicula1", 1990));}}));
                add(new Actor("actor3", "M", 1990, new ArrayList<>(){{add(new Pelicula("pelicula1", 1990));
                    add(new Pelicula("pelicula2", 1990));}}));
            }
        };

        List<Actor> listaEsperada = new ArrayList<>(){{ add(new Actor("actor1", "M", 1990, new ArrayList<>(){{add(new Pelicula("pelicula1", 1990));
            add(new Pelicula("pelicula2", 1990));}}));
            add(new Actor("actor3", "M", 1990, new ArrayList<>(){{add(new Pelicula("pelicula1", 1990));
                add(new Pelicula("pelicula2", 1990));}}));
        }};

        assertEquals(listaEsperada, Utilidades.actoresConMasDeUnOscar(listaActores));
        }
    }
