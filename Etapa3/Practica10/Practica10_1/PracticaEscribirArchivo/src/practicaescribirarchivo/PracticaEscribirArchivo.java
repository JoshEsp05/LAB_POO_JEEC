
package practicaescribirarchivo;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author Joshua Emmanuel Esparza Chavez - 2049293
 */
public class PracticaEscribirArchivo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Escribe texto: ");
        String texto = sc.nextLine();

        try {
            FileWriter writer = new FileWriter("archivo.txt");
            writer.write(texto);
            writer.close();

            System.out.println("Archivo guardado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir archivo.");
        }
    }
}
