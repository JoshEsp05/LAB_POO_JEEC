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
import java.util.Scanner;

public class PracticaTelevision {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingresa la marca: ");
        String marca = sc.nextLine();

        System.out.print("Ingresa el modelo: ");
        String modelo = sc.nextLine();

        System.out.print("Ingresa el color: ");
        String color = sc.nextLine();

        Television tv = new Television(marca, modelo, color);

        System.out.println();
        tv.mostrarDatos();
        tv.encender();
        tv.cambioCanal();
        tv.confMenu();
        tv.apagar();

        sc.close();
    }
    
}
