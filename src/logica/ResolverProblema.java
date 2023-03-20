/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.math.BigInteger;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author eleana
 */
public class ResolverProblema {
    
    public ArrayList<ArrayList> resolverExponencial(ArrayList<Float> numeros) {
        ArrayList<Float> variables = new ArrayList<>();
        ArrayList<Float> med = new ArrayList<>();
        ArrayList<Float> result = new ArrayList<>();
        float media;
        float limSup, limInf;
        int favorables = 0;
        ArrayList<ArrayList> datos = new ArrayList();
        
        
        String msj;

        msj = JOptionPane.showInputDialog("La probabilidad de? ");

        do {
            media = Float.parseFloat(JOptionPane.showInputDialog("Ingrese la media: "));
        } while (media < 0);

        do {
            limInf = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el limite inferior: "));
        } while (limInf < 0);

        do {
            limSup = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el limite superior: "));
        } while (limSup < 0 || limSup < limInf);

        for (int i = 0; i < numeros.size(); i++) {
            if (numeros.get(i) == 0) {
                variables.add((float) 0);
            } else {
                variables.add((-1) * media * (float) Math.log(numeros.get(i)));
            }

            System.out.println("R: " + numeros.get(i) + " variables: " + variables.get(i));
            if (variables.get(i) >= limInf && variables.get(i) <= limSup) {
                favorables++;
                System.out.println("Si esta en el rango");
            }
        }
        System.out.println("favorables: " + favorables);
        double probabilidad = ((double) favorables / numeros.size());

        System.out.println("Probabilidad de " + msj + " entre [" + limInf + " - " + limSup + "] es: " + probabilidad);
        med.add(media);
        result.add((float)favorables);
        result.add((float)probabilidad);
        
        datos.add(variables);
        datos.add(med);
        datos.add(result);
        return datos;
        
    }
    
    public BigInteger factorial(int numero) {
        BigInteger fact = BigInteger.valueOf(1);
        for (long i = 1; i <= numero; i++) {
            // fact *= i;
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        return fact;
    }

    public ArrayList<ArrayList> poisson(ArrayList<Float> numeros) {
        int lambda = 0;
        ArrayList<ArrayList> datos = new ArrayList();
        ArrayList<Integer> media = new ArrayList();
        
        lambda = Integer.parseInt(JOptionPane.showInputDialog("Digite el valor de la media (λ): "));

        ArrayList<Integer> X = new ArrayList<>();
        for (int i = 0; i <= lambda * 3; i++) {
            X.add(i);
        }

        ArrayList<Double> FdeX = new ArrayList<>();

        for (int i = 0; i < X.size(); i++) {
            FdeX.add((Math.exp(-lambda) * Math.pow(lambda, X.get(i))) / factorial(X.get(i)).doubleValue());
        }
        
        ArrayList<Double> Li = new ArrayList<>();
        ArrayList<Double> Ls = new ArrayList<>();
        
        Li.add(0.0);
        Ls.add(FdeX.get(0));
        
        for (int i = 1; i < FdeX.size(); i++) {
            Li.add(Ls.get(i - 1));
            Ls.add(Li.get(i) + FdeX.get(i));
        }
        
        ArrayList<Integer> rangos = new ArrayList<>();
        
        for (int i = 0; i < numeros.size(); i++) {
            for (int j = 0; j < FdeX.size(); j++) {
                if (numeros.get(i) < Ls.get(j)) {
                    rangos.add(X.get(j));
                    break;
                }
            }
        }
        media.add(lambda);
        
        datos.add(X);
        datos.add(FdeX);
        datos.add(media);
        datos.add(Li);
        datos.add(Ls);
        datos.add(rangos);
        
        System.out.println(X);
        System.out.println(Ls);
        System.out.println(rangos.size());
        System.out.println(numeros.size());
        return datos;
    }

    public ArrayList<ArrayList> uniforme(ArrayList<Float> numeros) {
        float a = 0, b = 0, media = 0;
        ArrayList<Float> X = new ArrayList();
        ArrayList<Float> limites=new ArrayList();
        ArrayList<Float> resultado = new ArrayList();
        ArrayList<ArrayList> datos = new ArrayList();
        int option;
        do {
            option = Integer.parseInt(JOptionPane.showInputDialog("Elija una opción: "
                    + "\n 1. Conoce lim inferior y superior"
                    + "\n 2. Conoce lim inferior y media"
                    + "\n 3. Conoce media y lim superior"));
        } while (option <= 0 || option > 3);

        if (option == 1) {
            do {
                a = Float.parseFloat(JOptionPane.showInputDialog("Digite el limite inferior: "));
            } while (a < 0);
            do {
                b = Float.parseFloat(JOptionPane.showInputDialog("Digite el limite superior: "));
            } while (b < 0 || b<a);
        }
        if (option == 2) {
            do {
                a = Float.parseFloat(JOptionPane.showInputDialog("Digite el limite inferior: "));
            } while (a < 0);
            do {
                media = Float.parseFloat(JOptionPane.showInputDialog("Digite la media: "));
            } while (media < 0 || media < a);

            b = media + (media - a);

        }
        if (option == 3) {

            do {
                b = Float.parseFloat(JOptionPane.showInputDialog("Digite el limite superior: "));
            } while (b < 0);
            do {
                media = Float.parseFloat(JOptionPane.showInputDialog("Digite la media: "));
            } while (media < 0 || media > b);

            a = media - (b - media);
        }
        //agregamos los limites
        limites.add(a);
        limites.add(b);

        for (int i = 0; i < numeros.size(); i++) {
            X.add(a + (b - a) * numeros.get(i));
        }
        System.out.println(X);

        String msj;

        msj = JOptionPane.showInputDialog("La probabilidad de? ");
        float limS = 0, limI = 0, probabilidad;
        int count=0;
       
        
        do {
            limI = Float.parseFloat(JOptionPane.showInputDialog("Digite el limite inferior: "));
        } while (limI < 0);
        do {
            limS= Float.parseFloat(JOptionPane.showInputDialog("Digite el limite superior: "));
        } while (limS < 0 || limS<limI);
        
        for(int i=0; i<X.size(); i++){
            if(X.get(i)>=limI && X.get(i)<=limS)
            {
                count++;
            }
        }
        probabilidad=(float)count/X.size();
        JOptionPane.showMessageDialog(null, "La probabilidad de "+msj+"\nEn el rango ["+ limI+" - "+limS+"] "
                +" es "+probabilidad);
        resultado.add(limI);
        resultado.add(limS);
        resultado.add((float)count);
        resultado.add(probabilidad);
        
        datos.add(limites);
        datos.add(X);
        datos.add(resultado);
        
        
        return datos;
    }

}
