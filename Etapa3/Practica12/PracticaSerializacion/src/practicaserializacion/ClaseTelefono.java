
package practicaserializacion;

/**
 *
 * @author Joshua Emmanuel Esparza Chavez - 2049293
 */
public class ClaseTelefono {
    private String marca;
    private String modelo;

    public ClaseTelefono(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public void encender() {
        System.out.println(marca + " " + modelo + " encendido.");
    }

    public void conectarWifi() {
        System.out.println(marca + " conectado a WiFi.");
    }

    public void iniciarLlamadaNumero(String numero) {
        System.out.println("Llamando al numero: " + numero);
    }

    public void iniciarLlamadaNombre(String nombre) {
        System.out.println("Llamando a: " + nombre);
    }

    public void finalizarLlamada() {
        System.out.println("Llamada finalizada.");
    }
}
