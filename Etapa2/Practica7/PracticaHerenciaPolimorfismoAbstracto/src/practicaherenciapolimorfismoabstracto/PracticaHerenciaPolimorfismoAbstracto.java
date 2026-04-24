
package practicaherenciapolimorfismoabstracto;
import java.util.ArrayList;
/**
 *
 * @author Joshua Emmanuel Esparza Chavez - 2049293 
 */
public class PracticaHerenciaPolimorfismoAbstracto {

public static void main(String[] args) {

        ArrayList<Automovil> autos = new ArrayList<>();

        autos.add(new Automovil("Toyota", "Corolla", "Rojo", "200000"));
        autos.add(new Automovil("Nissan", "Sentra", "Azul", "180000"));
        autos.add(new Automovil("Ford", "Focus", "Negro", "210000"));
        autos.add(new Automovil("Chevrolet", "Aveo", "Blanco", "150000"));
        autos.add(new Automovil("Kia", "Rio", "Gris", "170000"));
        autos.add(new Automovil("Mazda", "3", "Rojo", "230000"));
        autos.add(new Automovil("Honda", "Civic", "Negro", "250000"));
        autos.add(new Automovil("Hyundai", "Elantra", "Azul", "190000"));
        autos.add(new Automovil("Volkswagen", "Jetta", "Blanco", "240000"));
        autos.add(new Automovil("Suzuki", "Swift", "Verde", "160000"));

        for (Automovil auto : autos) {
            auto.mostrar();
            auto.encender();
            System.out.println(auto.avanzar(50));
            auto.vuelta("Izquierda");
            System.out.println();
        }
    }
}
