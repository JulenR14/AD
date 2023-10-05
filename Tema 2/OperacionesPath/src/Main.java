
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Stream;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {

        //Esta es la ruta con la que trabaja el proyecto
        Path dir = Path.of(".\\tmp\\niats");

            //Comprobamos si la ruta existe
            if (Files.exists(dir)) {
                //en el caso de que sea correcta cinstanciamos una variable de tipo Stream, en el cual se almacenara
                //una secuencia de Paths ordenados a la inversa, es decir de los ficheros más extenos a los mas internos
                try (Stream<Path> ficheros = Files.walk(dir).sorted(Collections.reverseOrder())){

                    //recorremos un bucle forEach sobre Stream anterior
                    ficheros.forEach(p -> {
                        try {
                            //comporbamos que la ruta en la que esta el cursor no sea igual a la ruta raiz
                            //de esta forma nos aseguramos de que no intente borrar la capeta principal
                            if (!Files.isSameFile(dir, p)) {
                                //llamamos al metodo que se ocupara de arrastrar los direcctorios o borrar la carpeta
                                //siempre que esta este sin ficheros ni carpetas dentro de ella
                                eliminarOmover(p, dir);
                            }
                            //capturamos posible excepcion
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                    //capturamos posible excepcion
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

    }
    //este metodo mueve los ficheros de carpetas y borra las carpetas vacias
    public static void eliminarOmover(Path r, Path d) throws IOException{

        //comprobamos si es un directorio, en el caso contrario querra decir que es un fichero, con lo cual hay que moverlo
        if (Files.isDirectory(r)) {
            //si es un directorio quiere decir que no hay nada detras de el, asi que lo eliminamos
            Files.delete(r);
        }else {
            //movemos el fichero a la raiz, y con el REPLACE_EXISTING decimos que reemplace un archivo existente si ya existe
            Files.move(r.toAbsolutePath(), d.resolve(r.getFileName()), StandardCopyOption.REPLACE_EXISTING);
        }
    }
}