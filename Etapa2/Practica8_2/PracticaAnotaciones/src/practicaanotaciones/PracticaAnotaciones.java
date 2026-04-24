
package practicaanotaciones;

/**
 *
 * @author Joshua Emmanuel Esparza Chavez - 2049293
 */
public class PracticaAnotaciones {

    public static void main(String[] args) {

        Automovil auto = new Automovil("Toyota", "Corolla", "200000");

        System.out.println("Marca: " + auto.getMarca());
        System.out.println("Modelo: " + auto.getModelo());
        System.out.println("Precio: " + auto.getPrecio());

        auto.encender(10);
        auto.avanzar(5);
        auto.metodoViejo();

        System.out.println(auto.apagar());
    }
    
}
