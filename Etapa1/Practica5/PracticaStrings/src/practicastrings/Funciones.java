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
import java.util.Arrays;

public class Funciones {
    
    // 1. Retorna longitud de un String
    public int longitud(String texto) {
        return texto.length();
    }

    // 2. Determina si dos cadenas son iguales
    public boolean sonIguales(String a, String b) {
        return a.equals(b);
    }

    // 3. Ordena un arreglo de Strings
    public String[] ordenar(String[] arreglo) {
        Arrays.sort(arreglo);
        return arreglo;
    }

    // 4. Mayor de 2 números
    public int mayorDos(int a, int b) {
        return (a > b) ? a : b;
    }

    // 5. Mayor de 3 números
    public int mayorTres(int a, int b, int c) {
        return mayorDos(mayorDos(a, b), c);
    }

    // 6. Calcular IVA (16%)
    public double calcularIVA(int cantidad, double precio) {
        double subtotal = cantidad * precio;
        return subtotal * 0.16;
    }

    // 7. Split usando carácter
    public String[] dividir(String texto, String caracter) {
        return texto.split(caracter);
    }

    // 8. Verifica si existe un String dentro de otro
    public boolean contiene(String texto, String palabra) {
        return texto.contains(palabra);
    }
}
