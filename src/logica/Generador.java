/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;

/**
 *
 * @author Eleana Hurtado
 */
public class Generador {
   
    public ArrayList<Integer> genCongruencialMixto(int x, int a, int c, int m, int n){
        
        ArrayList<Integer> numerosEnteros = new ArrayList<>();
        ArrayList<Float> numerosRango = new ArrayList<>();
        ArrayList<Integer>numA= new ArrayList<>();
        
        numA.add(a);
        numerosEnteros.add(x);
        for(int i=0; i<n; i++){
            numA.add((numerosEnteros.get(i)*a)+c);
            numerosEnteros.add(numA.get(i+1)%m);
        }
        for (int i = 0; i < numerosEnteros.size(); i++) {
            System.out.println(numA.get(i)+"|"+numerosEnteros.get(i));
        }
        return numerosEnteros;
       
    }
}
