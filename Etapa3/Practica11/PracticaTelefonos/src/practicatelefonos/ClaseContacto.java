
package practicatelefonos;

/**
 *
 * @author Joshua Emmanuel Esparza Chavez 
 */
public class ClaseContacto {
    private String nombre;
    private String numero;

    public ClaseContacto(String nombre, String numero) {
        this.nombre = nombre;
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return nombre + "," + numero;
    }

    public static ClaseContacto fromString(String linea) {
        String[] partes = linea.split(",");
        return new ClaseContacto(partes[0], partes[1]);
    }
}
