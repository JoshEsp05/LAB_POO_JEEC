
package practicapolimorfismo;

/**
 *
 * @author Joshua Emmanuel Esparza Chavez - 2049293
 */
public class Automovil extends Transporte implements Avanzar, Frenar {

    private String color;

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void encender() {
        System.out.println("Enciende automovil");
    }

    @Override
    public String avanzar(int gasolina) {
        return "Avanza con gasolina";
    }

    @Override
    public void frenar() {
        System.out.println("Frena automovil");
    }

    public void acelera() {
        System.out.println("Acelerando");
    }

    @Override
    public void avanzar() {
        System.out.println("Automovil avanzando");
    }
}
