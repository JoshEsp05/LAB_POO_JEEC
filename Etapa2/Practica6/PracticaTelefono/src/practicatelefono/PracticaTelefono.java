
package practicatelefono;

/**
 *
 * @author Joshua Emmanuel Esparza Chavez - 2049293
 */
public class PracticaTelefono {

    public static void main(String[] args) {

        ClaseTelefono[] telefonos = new ClaseTelefono[5];

        telefonos[0] = new ClaseTelefono("Samsung", "S21");
        telefonos[1] = new ClaseTelefono("Apple", "iPhone 13");
        telefonos[2] = new ClaseTelefono("Xiaomi", "Redmi Note 11");
        telefonos[3] = new ClaseTelefono("Motorola", "G60");
        telefonos[4] = new ClaseTelefono("Huawei", "P30");

        ClaseContacto[] contactos = new ClaseContacto[5];

        contactos[0] = new ClaseContacto("Juan", "8112345678");
        contactos[1] = new ClaseContacto("Maria", "8123456789");
        contactos[2] = new ClaseContacto("Luis", "8134567890");
        contactos[3] = new ClaseContacto("Ana", "8145678901");
        contactos[4] = new ClaseContacto("Pedro", "8156789012");

        for (int i = 0; i < telefonos.length; i++) {
            System.out.println("\n--- Teléfono " + (i + 1) + " ---");

            telefonos[i].encender();
            telefonos[i].conectarWifi();

            telefonos[i].iniciarLlamadaNumero(contactos[i].getNumero());
            telefonos[i].iniciarLlamadaNombre(contactos[i].getNombre());

            telefonos[i].finalizarLlamada();
        }
    }
    
}
