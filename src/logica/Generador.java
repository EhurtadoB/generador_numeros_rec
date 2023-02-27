/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Eleana Hurtado
 */
public class Generador {

    public ArrayList<Integer> genCongruencialMixto(int x, int a, int c, int m) {

        ArrayList<Integer> numerosEnteros = new ArrayList<>();
        ArrayList<Float> numerosRango = new ArrayList<>();
        ArrayList<Integer> numA = new ArrayList<>();

        numA.add(a);
        numerosEnteros.add(x);
        for (int i = 0; i < m - 1; i++) {
            numA.add((numerosEnteros.get(i) * a) + c);
            numerosEnteros.add(numA.get(i + 1) % m);
        }
        for (int i = 0; i < numerosEnteros.size(); i++) {
            System.out.println(numA.get(i) + "|" + numerosEnteros.get(i));
        }
        return numerosEnteros;

    }

    //Generador Congruencial Multiplicativo
    public ArrayList<Integer> genConMultiplicativo(int x, int a, int m) {

        //Se crean las listas de los "x" generados y "a" generados
        ArrayList<Integer> xGenerados = new ArrayList<>();
        ArrayList<Integer> aGenerados = new ArrayList<>();

        //Se añaden las primeras "x" y "a" a las listas
        xGenerados.add(x);
        aGenerados.add(a);

        //Se usa la fórmula para generar los números pseudoaleatorios
        for (int i = 0; i < m - 1; i++) {
            aGenerados.add(xGenerados.get(i) * a);
            xGenerados.add(aGenerados.get(i + 1) % m);
        }

        //Se imprimen los números "x" pseudoaleatorios generados
        for (int i = 0; i < xGenerados.size(); i++) {
            System.out.print(xGenerados.get(i) + " ");
        }

        //Se imprimen los números "a" generados
        for (int i = 0; i < aGenerados.size(); i++) {
            System.out.print(aGenerados.get(i) + " ");
        }

        //Se validan los números introducidos por el
        // usuario para dar las respectivas indicaciones
        if (m < x) {
            System.out.println("El módulo debe ser mayor que la semilla.");
        }

        if (esPrimo(m) == false) {
            System.out.println("El módulo debe ser un número primo.");
        }

        if (a % 2 == 0 || a % 3 == 0 || a % 5 == 0) {
            System.out.println("La constante multiplicativa debe ser impar y no divisible entre 3 o 5.");
        }

        if (x < 0 || a < 0 || m < 0) {
            System.out.println("Los números digitados no deben ser negativos.");
        }
        return xGenerados;
    }

    //Función para saber si un número es primo
    public boolean esPrimo(int numero) {

        // El 0, 1 y 4 no son primos
        if (numero == 0 || numero == 1 || numero == 4) {
            return false;
        }
        for (int x = 2; x < numero / 2; x++) {
            // Si es divisible por cualquiera de estos números, no
            // es primo
            if (numero % x == 0) {
                return false;
            }
        }
        // Si no se pudo dividir por ninguno de los de arriba, sí es primo
        return true;
    }

    //Metodo fibonacci
    public ArrayList<Integer> fibonacci(int x1, int x2, int m) {
        ArrayList<Integer> numerosEnteros = new ArrayList<>();
        ArrayList<Float> numerosRango = new ArrayList<>();


        /*System.out.println("Valor para el modulo m: ");
        int m = Integer.parseInt(leer.next());

        System.out.println("Valor para x1: ");
        numerosEnteros.add(Integer.parseInt(leer.next()));

        System.out.println("Valor para x2: ");
        numerosEnteros.add(Integer.parseInt(leer.next()));*/
        numerosEnteros.add(x1);
        numerosEnteros.add(x2);
        for (int i = 2; i < m; i++) {

            if (numerosEnteros.get(i - 2) + numerosEnteros.get(i - 1) < m) {
                numerosEnteros.add(numerosEnteros.get(i - 2) + numerosEnteros.get(i - 1));
            } else {
                numerosEnteros.add((numerosEnteros.get(i - 2) + numerosEnteros.get(i - 1)) % m);
            }
        }

        for (int i = 0; i < m; i++) {
            numerosRango.add(Float.parseFloat((float) numerosEnteros.get(i) / m + ""));
        }

        System.out.println("");
        System.out.println("************************Numeros Enteros gemerados********************");

        for (int i = 0; i < m;  i++) {
            System.out.println(i + "  " + numerosEnteros.get(i) + " en el rango de 0 a 1 es " + numerosRango.get(i));
        }
        return numerosEnteros;

    }
    
}
