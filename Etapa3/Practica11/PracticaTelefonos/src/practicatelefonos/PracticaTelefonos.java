
package practicatelefonos;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Joshua Emmanuel Esparza Chavez - 2049293
 */
public class PracticaTelefonos {

    public static void main(String[] args) {

        ArrayList<ClaseContacto> contactos = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String archivo = "contactos.txt";

        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            br = new BufferedReader(new FileReader(archivo));
            String linea;

            while ((linea = br.readLine()) != null) {
                contactos.add(ClaseContacto.fromString(linea));
            }

            System.out.println("Contactos cargados correctamente.");

        } catch (IOException e) {
            System.out.println("No se encontro archivo, se creara uno nuevo.");

        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar lectura.");
            }
        }

        System.out.print("¿Cuantos contactos quieres agregar? ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\nContacto " + (i + 1));

            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Número: ");
            String numero = sc.nextLine();

            contactos.add(new ClaseContacto(nombre, numero));
        }

        ClaseTelefono telefono = new ClaseTelefono("Samsung", "S21");

        telefono.encender();
        telefono.conectarWifi();

        for (ClaseContacto c : contactos) {
            telefono.iniciarLlamadaNombre(c.getNombre());
            telefono.iniciarLlamadaNumero(c.getNumero());
            telefono.finalizarLlamada();
        }

        try {
            bw = new BufferedWriter(new FileWriter(archivo));

            for (ClaseContacto c : contactos) {
                bw.write(c.toString());
                bw.newLine();
            }

            System.out.println("Contactos guardados correctamente.");

        } catch (IOException e) {
            System.out.println("Error al guardar el archivo.");

        } finally {
            try {
                if (bw != null) bw.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar escritura.");
            }
        }

        sc.close();
    }
    
}
