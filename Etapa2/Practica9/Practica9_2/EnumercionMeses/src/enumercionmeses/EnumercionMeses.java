
package enumercionmeses;

/**
 *
 * @author Joshua Emmanuel Esparza Chavez - 2049293
 */
public class EnumercionMeses {

    public static void main(String[] args) {

        System.out.println("Meses del año:");

        for (Meses mes : Meses.values()) {
            System.out.println(mes);
        }
    }
    
}
