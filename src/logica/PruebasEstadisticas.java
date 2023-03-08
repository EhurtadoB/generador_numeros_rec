/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

/**
 *
 * @author Eleana Hurtado
 */
public class PruebasEstadisticas {
    public void pruebaPromedios(ArrayList<Float> numeros){
        // nivel de aceptación 95% alfa=5%
        float sum=0, prom=0, Zo = 0;
        int x=0;
        
        for(int i=0; i<numeros.size(); i++){
            sum+=(float)numeros.get(i);
            x++;
        }
        //Hipotesis nula
        prom=(float)sum/x;
        prom=(float)Math.round(prom*10000)/10000;
        
        //Hipotesis alternativa
        if(prom!=0.5){
            Zo=(float) ((prom-0.5)*Math.sqrt(x))/(0.288675f);
            if(Math.abs(Zo)<1.96){
              
              JOptionPane.showMessageDialog(null, "Como no se cumple la hipótesis nula, promedio="+prom+"\n"
                      +"Se utiliza la hipótesis alternativa\n"+
                      "Zo =|"+Zo+"|<1.96\n"+
                      "Paso la prueba\n");
            }
            else{
                JOptionPane.showMessageDialog(null, "Como no se cumple la hipótesis nula, promedio="+prom+"\n"
                      +"Se utiliza la hipótesis alternativa\n"+
                      "Zo =|"+Zo+"|<1.96 (No cumple)\n"+
                      "No paso la prueba\n");
             
            }
        }else{
            JOptionPane.showMessageDialog(null, "Se cumple la hipótesis nula, promedio="+prom+"\n"+
                      "Paso la prueba\n");
        }
        System.out.println(prom);
        System.out.println(Zo);
    }
    public void pruebaFrecuencias(ArrayList<Float> datos){
        int intervalos;
        do{
            intervalos = Integer.parseInt(JOptionPane.showInputDialog("Número de intervalos que desea: "));   
        }while(intervalos<0);
        
     
        ArrayList<Float> numIntervalos = new ArrayList<>();
        ArrayList<String> cadIntervalos = new ArrayList<>();
        
        for (int i = 0; i < intervalos; i++) {
            
            numIntervalos.add((float)(i+1)/intervalos);
            if (i==0) {
                cadIntervalos.add("[0 , " + numIntervalos.get(i) + " ]");
            }
            else{
                cadIntervalos.add("[" + numIntervalos.get(i-1) + " , " + numIntervalos.get(i) + " ]");
            }
        }
        
        //iniciando los contadores de los intervalos en 0
        int[] vaIntervalos = new int[intervalos];
        float fEsperada = (float) datos.size()/intervalos;
        float[] X0 = new float[intervalos];
        float X0Acum = 0;
        double ZReferencia = chiCuadrado(intervalos-1);
        
        for (int i = 0; i < vaIntervalos.length; i++) {
            vaIntervalos[i] = 0;
        }

        //Imprimiendo intervalos
        for (int i = 0; i < numIntervalos.size(); i++) {
            System.out.println(numIntervalos.get(i));
            System.out.println(cadIntervalos.get(i));
        }
        
        for (int i = 0; i < datos.size(); i++) {
            for (int j = 0; j < intervalos; j++) {
                if(datos.get(i) < numIntervalos.get(j)){
                    vaIntervalos[j]++;
                    break;
                }
            }
        }
        
        for (int i = 0; i < intervalos; i++) {
            X0[i] = (float) (Math.pow(vaIntervalos[i] - fEsperada, 2)) / fEsperada;
            X0Acum = X0Acum + X0[i];
        }
        
        String mensaje1= "";
        System.out.println("");
        System.out.println("Datos de los datos en los intervalos");
        for (int i = 0; i < intervalos; i++) {
            System.out.println(cadIntervalos.get(i) + " : " + vaIntervalos[i] + " X0: " + X0[i] + " Esperada: " + fEsperada);
            mensaje1 = mensaje1 + cadIntervalos.get(i) + " : " + String.valueOf(vaIntervalos[i]) + " X0: " + String.valueOf(X0[i]) + " Esperada: " + String.valueOf(fEsperada) + "\n";
        }
        System.out.println("X0 acumulada: " + X0Acum);
        
        System.out.println("Chi cuadrado: " + ZReferencia);
        if(X0Acum< ZReferencia){
            System.out.println("Pasó la prueba");
            JOptionPane.showMessageDialog(null, "Datos de los intervalos \n"+mensaje1+"\n"
                      +"Xo acumulada = "+X0Acum+"\n"+
                      "Chi cuadrado "+ZReferencia+"\n"+
                      "Paso la prueba");
        }
        else{
            System.out.println("No pasó la prueba");
            JOptionPane.showMessageDialog(null, "Datos de los intervalos \n"+mensaje1+"\n"
                      +"Xo acumulada = "+X0Acum+"\n"+
                      "Chi cuadrado "+ZReferencia+"\n"+
                      "No Paso la prueba");
        }
        
    }
    
    public double chiCuadrado(int n){
        double chicuadra;
        
        switch(n){
            case 1:
                chicuadra = 3.8415;
                break;
            case 2:
                chicuadra = 5.9915;
                break;
            case 3:
                chicuadra = 7.8147;
                break;
            case 4:
                chicuadra = 9.4877;
                break;
            case 5:
                chicuadra = 11.705;
                break;
            case 6:
                chicuadra = 12.5916;
                break;
            case 7:
                chicuadra = 14.0671;
                break;
            case 8:
                chicuadra = 15.5073;
                break;
            case 9:
                chicuadra = 16.9190;
                break;
            case 10:
                chicuadra = 18.3070;
                break;
            case 11:
                chicuadra = 19.6752;
                break;
            case 12:
                chicuadra = 21.0261;
                break;
            case 13:
                chicuadra = 22.3620;
                break;
            case 14:
                chicuadra = 23.6848;
                break;
            case 15:
                chicuadra = 24.9958;
                break;
            case 16:
                chicuadra = 26.2962;
                break;
            case 17:
                chicuadra = 27.5871;
                break;
            case 18:
                chicuadra = 28.8693;
                break;
            case 19:
                chicuadra = 30.1435;
                break;
            case 20:
                chicuadra = 31.4104;
                break;
            case 21:
                chicuadra = 32.6706;
                break;
            case 22:
                chicuadra = 33.9245;
                break;
            case 23:
                chicuadra = 35.1725;
                break;
            case 24:
                chicuadra = 36.4150;
                break;
            case 25:
                chicuadra = 37.6525;
                break;
            case 26:
                chicuadra = 38.8851;
                break;
            case 27:
                chicuadra = 40.1133;
                break;
            case 28:
                chicuadra = 41.3372;
                break;
            case 29:
                chicuadra = 42.5569;
                break;
            case 30:
                chicuadra = 43.7730;
                break;
            case 31:
                chicuadra = 44.9853;
                break;
            case 32:
                chicuadra = 46.1942;
                break;
            case 33:
                chicuadra = 47.3999;
                break;
            case 34:
                chicuadra = 48.6024;
                break;
            case 35:
                chicuadra = 49.8018;
                break;
            case 36:
                chicuadra = 50.9985;
                break;
            case 37:
                chicuadra = 52.1923;
                break;
            case 38:
                chicuadra = 53.3835;
                break;
            case 39:
                chicuadra = 54.5722;
                break;
            case 40:
                chicuadra = 55.7585;
                break;
            default:
                chicuadra = 1.36/Math.sqrt(n);
            
        }
        return chicuadra;
    }
    
    public ArrayList<ArrayList> pruebaColmogorov(ArrayList<Float> datos) {
        Collections.sort(datos);
        ArrayList<ArrayList> info = new ArrayList();
        ArrayList<Float> fObservadas = new ArrayList();
        ArrayList<Float> distancias = new ArrayList();
        float dnMax;
        ArrayList<Float> AuxDistancia= new ArrayList();
        
        double ZReferencia =  chiCuadrado(datos.size());

        for (int i = 0; i < datos.size(); i++) {
            fObservadas.add((float) (i + 1) / datos.size());
            distancias.add(Math.abs(fObservadas.get(i) - datos.get(i)));
        }
        
        AuxDistancia = distancias;
        Collections.sort(distancias);
        
        dnMax = distancias.get(distancias.size()-1);
        
        
        for (int i = 0; i < datos.size(); i++) {
            System.out.println(i + "  " + datos.get(i) + "   " + fObservadas.get(i) + "   " + distancias.get(i));
        }
        
        System.out.println("MAX = " + dnMax);
        System.out.println("Zrefencia = " + ZReferencia);
        
        if (dnMax< ZReferencia){
            System.out.println("Pasó la prueba");
            JOptionPane.showMessageDialog(null, "Distancia Max = "+dnMax+"\n"
                      +"Zreferencia = "+ZReferencia+"\n"+
                      "PASÓ LA PRUEBA");
        }
        else{
            System.out.println("No pasó la prueba");
            JOptionPane.showMessageDialog(null, "Distancia Max = "+dnMax+"\n"
                      +"Zreferencia = "+ZReferencia+"\n"+
                      "NO PASÓ LA PRUEBA");
        }
        
        info.add(datos);
        info.add(fObservadas);
        info.add(distancias);
        
        return info;
    }
    
}
