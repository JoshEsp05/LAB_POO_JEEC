
package practicaescrituralecturaarchivos;
import java.io.*;
import java.util.Scanner;


/**
 *
 * @author Joshua Emmanuel Esparza Chavez - 2049293
 */
public class PracticaEscrituraLecturaArchivos {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Nombre del archivo (ej: archivo.txt): ");
        String nombre = sc.nextLine();

        System.out.print("Escribe el contenido: ");
        String texto = sc.nextLine();

        // Escritura
        try {
            FileWriter writer = new FileWriter(nombre);
            writer.write(texto);
            writer.close();
            System.out.println("Archivo guardado.");
        } catch (IOException e) {
            System.out.println("Error al escribir.");
        }

        // Lectura
        try {
            File archivo = new File(nombre);
            Scanner lector = new Scanner(archivo);

            System.out.println("\nContenido del archivo:");

            while (lector.hasNextLine()) {
                System.out.println(lector.nextLine());
            }

            lector.close();

        } catch (FileNotFoundException e) {
            System.out.println("No se pudo leer el archivo.");
        }
    }
}
