
package practicapolimorfismo;

/**
 *
 * @author Joshua Emmanuel Esparza Chavez - 2049293
 */
public abstract class Transporte {
    public abstract void encender();

    public void avanzar() {
        System.out.println("Avanza");
    }

    public void listaMetodos() {
        System.out.println("encender, avanzar, apagar");
    }

    public void apagar() {
        System.out.println("Apagado");
    }
}
