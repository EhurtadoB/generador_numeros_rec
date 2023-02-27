/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.awt.List;
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

        for (int i = 0; i < m; i++) {
            System.out.println(i + "  " + numerosEnteros.get(i) + " en el rango de 0 a 1 es " + numerosRango.get(i));
        }
        return numerosEnteros;
    }

    public ArrayList<ArrayList> cuadradosMedios(int x1, int n) {
        ArrayList<Integer> numerosEnteros = new ArrayList<>();
        ArrayList<Float> numerosRango = new ArrayList<>();
        ArrayList<Long> valoresCuadrados = new ArrayList<>();
        ArrayList<ArrayList> datos = new ArrayList();
        int tamDigitos;

 
        numerosEnteros.add(x1);

        int tam = String.valueOf(numerosEnteros.get(0)).length();
        for (int i = 0; i < n; i++) {
            valoresCuadrados.add((long) numerosEnteros.get(i) * numerosEnteros.get(i));
            tamDigitos = valoresCuadrados.get(0).toString().length();
            String cadenaAux = valoresCuadrados.get(i).toString();
            if (cadenaAux.length() < tamDigitos) {
                for (int j = 0; j < (tamDigitos - cadenaAux.length()); j++) {
                    cadenaAux = "0" + cadenaAux;
                }
            }
            long centro = Long.parseLong(cadenaAux.substring(tam / 2, tam + (tam / 2)));
            numerosEnteros.add((int) centro);
            numerosRango.add((float) numerosEnteros.get(i + 1) / (float) (Math.pow(10, tam)));
        }

        System.out.println("");
        System.out.println("n         X            X*X            Xn+1             Ri");
        for (int i = 0; i < n; i++) {
            System.out.println(i + "   " + numerosEnteros.get(i) + "   " + valoresCuadrados.get(i) + "   " + numerosEnteros.get(i + 1) + "   " + numerosRango.get(i));
        }
        
        datos.add(numerosEnteros);
        datos.add(valoresCuadrados);
        datos.add(numerosRango);
        return datos;
    }
    
    public ArrayList<ArrayList> productosMedios(int x1, int x2, int n){
        ArrayList<Integer> numerosEnteros = new ArrayList<>();
        ArrayList<Float> numerosRango = new ArrayList<>();
        ArrayList<Long> valoresProductos = new ArrayList<>();
        ArrayList<ArrayList> datos = new ArrayList();
        int tamDigitos;

        numerosEnteros.add(x1);
        numerosEnteros.add(x2);

        int tam = String.valueOf(numerosEnteros.get(0)).length();
        for (int i = 0; i < n; i++) {
            valoresProductos.add((long) numerosEnteros.get(i) * numerosEnteros.get(i + 1));
            tamDigitos = valoresProductos.get(0).toString().length();
            String cadenaAux = valoresProductos.get(i).toString();
            int tamAux = cadenaAux.length();
            if (tamAux < tamDigitos) {
                for (int j = 0; j < (tamDigitos - tamAux); j++) {
                    cadenaAux = "0" + cadenaAux;
                }
            }
            long centro = Long.parseLong(cadenaAux.substring(tam / 2, tam + (tam / 2)));
            numerosEnteros.add((int) centro);
            numerosRango.add((float) numerosEnteros.get(i + 1) / (float) (Math.pow(10, tam)));
        }

        System.out.println("");
        System.out.println("n         Xn            Xn-1*Xn            Xn+1             Ri");
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                System.out.println(i + "   " + numerosEnteros.get(i) + "       NA          " + numerosEnteros.get(i + 1) + "      " + "         NA          ");
            } else {
                System.out.println(i + "   " + numerosEnteros.get(i) + "     " + valoresProductos.get(i - 1) + "  " + numerosEnteros.get(i + 1) + "      " + numerosRango.get(i));
            }
        }
        datos.add(numerosEnteros);
        datos.add(valoresProductos);
        datos.add(numerosRango);
        return datos;     
    } 
    
    public ArrayList<ArrayList> genMultiplicadorConstante(int x, int constanteMultiplicativa, int n) {
        ArrayList<Integer> numerosEnteros = new ArrayList<>();
        ArrayList<Float> numerosRango = new ArrayList<>();
        ArrayList<Long> valoresProductos = new ArrayList<>();
        ArrayList<ArrayList> datos = new ArrayList();
        int tamDigitos;
        /*Scanner leer = new Scanner(System.in);

        System.out.println("Cuantos numeros pseudoaleatorios desea ver? ");
        int n = Integer.parseInt(leer.next());

        int semillaX = 0;
        int tam = 0;

        do {
            System.out.println("Valor de la semilla x: ");
            semillaX = Integer.parseInt(leer.next());
            tam = String.valueOf(semillaX).length();
            if (tam <= 3) {
                System.out.println("ERROR: El número de dígitos de la semilla debe ser mayor a 3.");
            }
        } while (tam <= 3);

        
        

        int tamConst = 0;

        do {
            System.out.println("Valor del multiplicador constante: ");
            constanteMultiplicativa = Integer.parseInt(leer.next());
            tamConst = String.valueOf(constanteMultiplicativa).length();
            if (tamConst != tam) {
                System.out.println("ERROR: El número de dígitos de la constante debe ser igual al número de dígitos de la semilla (" + tam + ").");
            }
        } while (tamConst != tam);*/
        
        numerosEnteros.add(x);
        
        int tam = String.valueOf(numerosEnteros.get(0)).length();

        for (int i = 0; i < n; i++) {
            valoresProductos.add((long) numerosEnteros.get(i) * constanteMultiplicativa);
            tamDigitos = valoresProductos.get(0).toString().length();
            String cadenaAux = valoresProductos.get(i).toString();
            int tamAux = cadenaAux.length();
            if (tamAux < tamDigitos) {
                for (int j = 0; j < (tamDigitos - tamAux); j++) {
                    cadenaAux = "0" + cadenaAux;
                }
            }
            long centro = Long.parseLong(cadenaAux.substring(tam / 2, tam + (tam / 2)));
            numerosEnteros.add((int) centro);
            numerosRango.add((float) numerosEnteros.get(i + 1) / (float) (Math.pow(10, tam)));
        }

        System.out.println("");
        System.out.println("n         Xn            Xn*a          a             Ri");
        for (int i = 1; i <= n; i++) {
            System.out.println(i + "   " + numerosEnteros.get(i) + "     " + valoresProductos.get(i - 1) + "  " + numerosEnteros.get(i) + "      " + numerosRango.get(i - 1));
        }
        datos.add(numerosEnteros);
        datos.add(valoresProductos);
        datos.add(numerosRango);
        return datos;
    }
}
