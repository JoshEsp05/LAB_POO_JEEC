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
public class Television extends DispositivoElectronico implements Ifunciones {
    private String color;

    public Television(String marca, String modelo, String color) {
        super(marca, modelo);
        this.color = color;
    }

    public void mostrarDatos() {
        System.out.println("Television: " + marca + 
                           ", Modelo: " + modelo + 
                           ", Color: " + color);
    }

    @Override
    public void cambioCanal() {
        System.out.println("Cambia de canal");
    }

    @Override
    public void volumen() {
        System.out.println("Sube/Baja volumen");
    }

    public void confMenu() {
        System.out.println("Configuracion de Menu");
    }
}
