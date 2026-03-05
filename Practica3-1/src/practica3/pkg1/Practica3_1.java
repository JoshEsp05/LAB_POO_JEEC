/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3.pkg1;

/**
 *
 * @author Joshua Esparza - 2049293
 */
import java.util.Scanner;

public class Practica3_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculadora calc = new Calculadora();

        System.out.print("Ingresa el primer numero: ");
        double num1 = sc.nextDouble();

        System.out.print("Ingresa el segundo numero: ");
        double num2 = sc.nextDouble();

        System.out.println("Suma: " + calc.sumar(num1, num2));
        System.out.println("Resta: " + calc.restar(num1, num2));
        System.out.println("Multiplicacion: " + calc.multiplicar(num1, num2));
        System.out.println("Division: " + calc.dividir(num1, num2));

        sc.close();
    }
    
}
