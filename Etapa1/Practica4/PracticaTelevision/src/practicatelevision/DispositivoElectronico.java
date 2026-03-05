/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicatelevision;

/**
 *
 * @author Joshua Esparza - 2049293
 */
public class DispositivoElectronico {
    protected String marca;
    protected String modelo;

    public DispositivoElectronico(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public void encender() {
        System.out.println("Dispositivo Enciende");
    }

    public void apagar() {
        System.out.println("Dispositivo Apagado");
    }
}
