
package practicatelefono;

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
        System.out.println("Llamando al número: " + numero);
    }

    public void iniciarLlamadaNombre(String nombre) {
        System.out.println("Llamando a: " + nombre);
    }

    public void finalizarLlamada() {
        System.out.println("Llamada finalizada.");
    }

    // Getters y Setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
