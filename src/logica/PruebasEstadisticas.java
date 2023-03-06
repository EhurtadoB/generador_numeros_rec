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
public class PruebasEstadisticas {
    public void pruebaPromedios(){
        // nivel de aceptación 95% alfa=5%
        Generador generador = new Generador();
        ArrayList<ArrayList> datos = new ArrayList<>();
        datos = generador.genCongruencialMixto(4, 5, 7, 8);
       
        float sum=0, prom=0, Zo = 0;
        int x=0;
        
        for(int i=1; i<datos.get(1).size(); i++){
            sum+=(float)datos.get(1).get(i);
            x++;
        }
        prom=(float)sum/x;
        
        //Hipotesis alternativa
        if(prom!=0.5){
            Zo=(float) ((prom-0.5)*Math.sqrt(x))/(0.288675f);
            if(Math.abs(Zo)<1.96){
              System.out.println("No se puede rechazar que los numeros cumplen una distribución uniforme");  
            }
            else{
                System.out.println("No paso la prueba");
            }
        }else{
            System.out.println("No se puede rechazar que los numeros cumplen una distribución uniforme");
        }
        System.out.println(prom);
        System.out.println(Zo);
    }
}
