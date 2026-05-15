package service;

import model.Cliente;

public class PagoService {

    public boolean procesarPago(Cliente cliente, double monto) {

        System.out.println("Procesando pago de $" + monto);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        cliente.setPuntos(cliente.getPuntos() + 10);

        return true;
    }
}