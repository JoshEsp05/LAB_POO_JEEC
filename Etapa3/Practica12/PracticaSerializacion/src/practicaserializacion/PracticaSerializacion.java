
package practicaserializacion;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Joshua Emmanuel Esparza Chavez - 2049293
 */
public class PracticaSerializacion {

    public static void main(String[] args) {

        ArrayList<ClaseContacto> contactos = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String archivo = "contactos.dat";

        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;

        try {
            ois = new ObjectInputStream(new FileInputStream(archivo));
            contactos = (ArrayList<ClaseContacto>) ois.readObject();

            System.out.println("Contactos cargados correctamente.");

        } catch (FileNotFoundException e) {
            System.out.println("No existe archivo, se creara uno nuevo.");

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer el archivo.");

        } finally {
            try {
                if (ois != null) ois.close();
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

            System.out.print("Numero: ");
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
            oos = new ObjectOutputStream(new FileOutputStream(archivo));
            oos.writeObject(contactos);

            System.out.println("Contactos guardados correctamente.");

        } catch (IOException e) {
            System.out.println("Error al guardar el archivo.");

        } finally {
            try {
                if (oos != null) oos.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar escritura.");
            }
        }

        sc.close();
    }
    
}
