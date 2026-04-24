
package practicaherenciapolimorfismoabstracto;

/**
 *
 * @author Joshua Emmanuel Esparza Chavez - 2049293
 */
public class Automovil extends Transporte implements Avanzar, Frenar {

    private String marca;
    private String modelo;
    private String color;
    private String precio;

    public Automovil(String marca, String modelo, String color, String precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.precio = precio;
    }

    @Override
    public void encender() {
        System.out.println("Enciende");
    }

    @Override
    public String avanzar(int gasolina) {
        return "Avanza";
    }

    @Override
    public void frenar() {
        System.out.println("Frena");
    }

    public void vuelta(String direccion) {
        System.out.println("Vuelta " + direccion);
    }

    public void mostrar() {
        System.out.println("*****Automovil " + marca + " *****");
        System.out.println("Modelo: " + modelo);
        System.out.println("Color: " + color);
        System.out.println("Precio: " + precio);
    }
}
