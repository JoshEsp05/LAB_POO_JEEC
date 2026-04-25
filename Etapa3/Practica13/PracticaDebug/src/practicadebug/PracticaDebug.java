
package practicadebug;
import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Joshua Emmanuel Esparza Chavez - 2049293
 */
public class PracticaDebug {

public static void main(String[] args) {

        ArrayList<ClaseContacto> contactos = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String archivo = "contactos.dat";

        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;

        try {
            System.out.println("[DEBUG] Intentando leer archivo...");

            ois = new ObjectInputStream(new FileInputStream(archivo));
            contactos = (ArrayList<ClaseContacto>) ois.readObject();

            System.out.println("[DEBUG] Contactos cargados: " + contactos.size());

        } catch (FileNotFoundException e) {
            System.out.println("[DEBUG] No existe archivo, se creara uno nuevo.");

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("[ERROR] Error al leer el archivo: " + e.getMessage());

        } finally {
            try {
                if (ois != null) ois.close();
            } catch (IOException e) {
                System.out.println("[ERROR] Error al cerrar lectura.");
            }
        }

        int n = 0;

        try {
            System.out.print("¿Cuantos contactos quieres agregar? ");
            n = sc.nextInt();
            sc.nextLine();

        } catch (InputMismatchException e) {
            System.out.println("[ERROR] Debes ingresar un numero valido.");
            sc.nextLine(); // limpiar buffer
        }

        for (int i = 0; i < n; i++) {
            System.out.println("\nContacto " + (i + 1));

            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Numero: ");
            String numero = sc.nextLine();

            if (nombre.isEmpty() || numero.isEmpty()) {
                System.out.println("[DEBUG] Datos vacios, contacto ignorado.");
                i--; // repetir ese intento
                continue;
            }

            contactos.add(new ClaseContacto(nombre, numero));
            System.out.println("[DEBUG] Contacto agregado correctamente.");
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
            System.out.println("[DEBUG] Guardando contactos...");

            oos = new ObjectOutputStream(new FileOutputStream(archivo));
            oos.writeObject(contactos);

            System.out.println("[DEBUG] Contactos guardados correctamente.");

        } catch (IOException e) {
            System.out.println("[ERROR] Error al guardar el archivo: " + e.getMessage());

        } finally {
            try {
                if (oos != null) oos.close();
            } catch (IOException e) {
                System.out.println("[ERROR] Error al cerrar escritura.");
            }
        }

        sc.close();
    }
    
}
