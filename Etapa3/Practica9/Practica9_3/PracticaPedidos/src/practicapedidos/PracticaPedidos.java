
package practicapedidos;

/**
 *
 * @author Joshua Emmanuel Esparza Chavez - 2049293
 */
public class PracticaPedidos {

        public static void main(String[] args) {

        Pedido p1 = new Pedido("Joshua", EstadoPedido.PENDIENTE);
        Pedido p2 = new Pedido("Emmanuel", EstadoPedido.ENVIADO);

        p1.mostrar();
        System.out.println();
        p2.mostrar();
    }
    
}
