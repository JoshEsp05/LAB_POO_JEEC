
package practicaleerarchivo;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Joshua Emmanuel Esparza Chavez - 2049293
 */
public class PracticaLeerArchivo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingresa la ruta del archivo: ");
        String ruta = sc.nextLine();

        try {
            File archivo = new File(ruta);
            Scanner lector = new Scanner(archivo);

            System.out.println("\nContenido del archivo:");

            while (lector.hasNextLine()) {
                System.out.println(lector.nextLine());
            }

            lector.close();

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");
        }
    }
    
}
