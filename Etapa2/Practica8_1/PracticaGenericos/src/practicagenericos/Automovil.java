
package practicagenericos;

/**
 *
 * @author Joshua Emmanuel Esparza Chavez - 2049293 
 */
public class Automovil {
    private String marca;
    private String modelo;
    private String precio;

    public Automovil(String marca, String modelo, String precio, int gas) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        encender(gas);
    }

    public void encender(int gas) {
        if (gas > 1) {
            System.out.println("Encendido con gasolina: " + gas);
        } else {
            System.out.println("No hay suficiente gasolina");
        }
    }

    public String alto() {
        return "El automovil está en alto";
    }

    public String movimiento(String mov) {
        return "Movimiento: " + mov;
    }

    public void mostrar() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Precio: " + precio);
    }

}
