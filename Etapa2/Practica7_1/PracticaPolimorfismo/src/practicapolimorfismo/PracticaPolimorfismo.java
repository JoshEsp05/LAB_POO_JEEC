
package practicapolimorfismo;

/**
 *
 * @author Joshua Emmanuel Esparza Chavez - 2049293
 */
public class PracticaPolimorfismo {

    public static void main(String[] args) {

        Automovil auto = new Automovil();
        auto.setColor("Rojo");
        auto.encender();
        auto.acelera();
        auto.apagar();

        System.out.println("-----");

        Transporte tr = new Automovil();
        tr.encender();
        tr.avanzar();
        tr.listaMetodos();

        System.out.println("-----");

        Avanzar iAuto = new Automovil();
        System.out.println(iAuto.avanzar(40));
    }
    
}
