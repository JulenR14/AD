import org.example.entities.Actor;
import org.example.entities.Pelicula;
import org.example.utils.Utilidades;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class UtilidadesTest {

    //donde compruebes el funcionamiento del método actoresConMasDeUnOscar,
    //que devuelve una lista con los nombres de los actores y actrices con más de un Oscar.
    @Test
    void actoresConMasDeUnOscarTest() {
        List<Actor> listaActores = new ArrayList<>() {
            {
                add(new Actor("actor1", "M", 1990, new ArrayList<>()));
                add(new Actor("actor2", "M", 1990, new ArrayList<>()));
                add(new Actor("actor1", "M", 1990, new ArrayList<>()));
            }
        };

        List<String> listaActoresConMasDeUnOscar = Utilidades.actoresConMasDeUnOscar(listaActores);

        assertEquals(2, Utilidades.actoresConMasDeUnOscar(listaActores));
        }
    }


}
