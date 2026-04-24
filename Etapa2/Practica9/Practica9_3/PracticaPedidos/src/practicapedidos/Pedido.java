
package practicapedidos;

/**
 *
 * @author Joshua Emmanuel Esparza Chavez - 2049293
 */
public class Pedido {
    private String cliente;
    private EstadoPedido estado;

    public Pedido(String cliente, EstadoPedido estado) {
        this.cliente = cliente;
        this.estado = estado;
    }

    public void mostrar() {
        System.out.println("Cliente: " + cliente);
        System.out.println("Estado: " + estado);
    }
}
