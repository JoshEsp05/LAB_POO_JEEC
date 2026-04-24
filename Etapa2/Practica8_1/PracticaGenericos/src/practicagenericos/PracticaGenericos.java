
package practicagenericos;
import java.util.Scanner;
/**
 *
 * @author Joshua Emmanuel Esparza Chavez - 2049293
 */
public class PracticaGenericos {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ListaGenerica<Automovil> autos = new ListaGenerica<>();

        for (int i = 0; i < 3; i++) { // puedes cambiar a 10
            System.out.println("Auto #" + (i + 1));

            System.out.print("Marca: ");
            String marca = sc.nextLine();

            System.out.print("Modelo: ");
            String modelo = sc.nextLine();

            System.out.print("Precio: ");
            String precio = sc.nextLine();

            System.out.print("Gasolina: ");
            int gas = Integer.parseInt(sc.nextLine());

            Automovil auto = new Automovil(marca, modelo, precio, gas);

            autos.agregar(auto);
        }

        System.out.println("\n--- RESULTADOS ---");

        for (Automovil a : autos.obtenerLista()) {
            a.mostrar();

            System.out.print("Movimiento (Izquierda/Derecha): ");
            String mov = sc.nextLine();

            System.out.println(a.movimiento(mov));
            System.out.println(a.alto());
            System.out.println();
        }
    }
    
}
