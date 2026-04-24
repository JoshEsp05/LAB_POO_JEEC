
package practicagenericos;
import java.util.ArrayList;
/**
 *
 * @author Joshua Emmanuel Esparza Chavez - 2049293
 */
public class ListaGenerica<T> {
        private ArrayList<T> lista = new ArrayList<>();

    public void agregar(T elemento) {
        lista.add(elemento);
    }

    public ArrayList<T> obtenerLista() {
        return lista;
    }
}
