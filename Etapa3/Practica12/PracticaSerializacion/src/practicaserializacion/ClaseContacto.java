
package practicaserializacion;
import java.io.Serializable;

/**
 *
 * @author Joshua Emmanuel Esparza Chavez - 2049293
 */
public class ClaseContacto implements Serializable{
    private static final long serialVersionUID = 1L;

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
}
