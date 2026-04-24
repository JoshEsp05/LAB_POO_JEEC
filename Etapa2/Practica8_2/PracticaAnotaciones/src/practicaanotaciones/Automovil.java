
package practicaanotaciones;

/**
 *
 * @author Joshua Emmanuel Esparza Chavez - 2049293
 */
public class Automovil extends TransporteTerrestre {

    private String precio;

    public Automovil(String marca, String modelo, String precio) {
        super(marca, modelo);
        this.precio = precio;
    }

    @Override
    public void encender(int gas) {
        System.out.println("Encendiendo automovil con gas: " + gas + " @Override");
    }

    @Deprecated
    public void metodoViejo() {
        System.out.println("Método obsoleto @Deprecated");
    }

    @Anotacion.MiAnotacion(valor = "Método personalizado")
    public void avanzar(int gas) {
        System.out.println("Avanzando con gas: " + gas + " @Custom");
    }

    public String getPrecio() {
        return precio;
    }
}
