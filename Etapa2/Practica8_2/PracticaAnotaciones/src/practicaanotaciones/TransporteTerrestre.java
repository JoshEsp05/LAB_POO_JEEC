
package practicaanotaciones;

/**
 *
 * @author Joshua Emmanuel Esparza Chavez - 2049293
 */
public abstract class TransporteTerrestre {
       private String marca;
    private String modelo;

    public TransporteTerrestre(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public abstract void encender(int gas);

    public String apagar() {
        return "Transporte apagado";
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }
}
