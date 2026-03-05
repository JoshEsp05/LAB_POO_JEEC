/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicastrings;

/**
 *
 * @author Joshua Esparza - 2049293
 */

import java.util.Scanner;

public class PracticaStrings {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Funciones f = new Funciones();

        // 1. Longitud
        System.out.print("Ingresa un texto: ");
        String texto = sc.nextLine();
        System.out.println("Longitud: " + f.longitud(texto));

        // 2. Comparar cadenas
        System.out.print("Ingresa primera cadena: ");
        String a = sc.nextLine();
        System.out.print("Ingresa segunda cadena: ");
        String b = sc.nextLine();
        System.out.println("Son iguales? " + f.sonIguales(a, b));

        // 3. Ordenar arreglo
        String[] nombres = {"Carlos", "Ana", "Luis", "Pedro"};
        String[] ordenado = f.ordenar(nombres);
        System.out.println("Arreglo ordenado:");
        for (String n : ordenado) {
            System.out.println(n);
        }

        // 4. Mayor de 2
        System.out.println("Mayor de 10 y 20: " + f.mayorDos(10, 20));

        // 5. Mayor de 3
        System.out.println("Mayor de 5, 8 y 3: " + f.mayorTres(5, 8, 3));

        // 6. IVA
        System.out.println("IVA (5 productos a $100): " + f.calcularIVA(5, 100));

        // 7. Split
        String frase = "Java-Python-C++-C#";
        String[] partes = f.dividir(frase, "-");
        System.out.println("División:");
        for (String p : partes) {
            System.out.println(p);
        }

        // 8. Contiene
        System.out.println("¿Contiene 'Java'? " + f.contiene(frase, "Java"));

        sc.close();
    }
    
}
