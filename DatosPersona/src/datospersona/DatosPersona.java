/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datospersona;

/**
 *
 * @author Joshua Esparza - 2049293
 */

import java.util.Scanner;

public class DatosPersona {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa tu nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingresa tu edad: ");
        int edad = scanner.nextInt();

        scanner.nextLine(); // limpiar buffer

        System.out.print("Ingresa tu telefono: ");
        String telefono = scanner.nextLine();

        System.out.println("Hola " + nombre + 
                           ", tu edad es " + edad + 
                           " y telefono es: " + telefono);

        scanner.close();
    }
    
}
