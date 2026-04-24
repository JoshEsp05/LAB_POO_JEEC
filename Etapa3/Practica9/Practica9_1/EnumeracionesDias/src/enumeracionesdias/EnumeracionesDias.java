
package enumeracionesdias;

/**
 *
 * @author Joshua Emmanuel Esparza Chavze - 2049293
 */
public class EnumeracionesDias {

    public static void main(String[] args) {

        System.out.println("Días de la semana:");

        for (DiasSemana dia : DiasSemana.values()) {
            System.out.println(dia);
        }
    }
    
}
