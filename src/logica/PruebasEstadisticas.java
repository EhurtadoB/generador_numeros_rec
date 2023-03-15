/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import javax.swing.JOptionPane;
import static vista.JFrPruebasEstadisticas.prueba1;
import static vista.JFrPruebasEstadisticas.prueba2;
import static vista.JFrPruebasEstadisticas.prueba3;
import static vista.JFrPruebasEstadisticas.prueba4;
import static vista.JFrPruebasEstadisticas.prueba5;

/**
 *
 * @author Eleana Hurtado
 */
public class PruebasEstadisticas {

    public static int cont;

    public void pruebaPromedios(ArrayList<Float> numeros) {
        // nivel de aceptación 95% alfa=5%
        float sum = 0, prom = 0, Zo = 0;
        int x = 0;

        for (int i = 0; i < numeros.size(); i++) {
            sum += (float) numeros.get(i);
            x++;
        }
        //Hipotesis nula
        prom = (float) sum / x;
        prom = (float) Math.round(prom * 10000) / 10000;

        //Hipotesis alternativa
        if (prom != 0.5) {
            Zo = (float) ((prom - 0.5) * Math.sqrt(x)) / (0.288675f);
            if (Math.abs(Zo) < 1.96) {

                JOptionPane.showMessageDialog(null, "Como no se cumple la hipótesis nula, promedio=" + prom + "\n"
                        + "Se utiliza la hipótesis alternativa\n"
                        + "Zo =|" + Zo + "|<1.96\n"
                        + "Paso la prueba\n");
                if (prueba1 != 1) {
                    cont++;
                }

            } else {
                JOptionPane.showMessageDialog(null, "Como no se cumple la hipótesis nula, promedio=" + prom + "\n"
                        + "Se utiliza la hipótesis alternativa\n"
                        + "Zo =|" + Zo + "|<1.96 (No cumple)\n"
                        + "No paso la prueba\n");

            }
        } else {
            JOptionPane.showMessageDialog(null, "Se cumple la hipótesis nula, promedio=" + prom + "\n"
                    + "Paso la prueba\n");
            if (prueba1 != 1) {
                cont++;
            }
        }
        System.out.println(prom);
        System.out.println(Zo);
    }

    public void pruebaFrecuencias(ArrayList<Float> datos) {
        int intervalos;
        do {
            intervalos = Integer.parseInt(JOptionPane.showInputDialog("Número de intervalos que desea: "));
        } while (intervalos < 0);

        ArrayList<Float> numIntervalos = new ArrayList<>();
        ArrayList<String> cadIntervalos = new ArrayList<>();

        for (int i = 0; i < intervalos; i++) {

            numIntervalos.add((float) (i + 1) / intervalos);
            if (i == 0) {
                cadIntervalos.add("[0 , " + numIntervalos.get(i) + " ]");
            } else {
                cadIntervalos.add("[" + numIntervalos.get(i - 1) + " , " + numIntervalos.get(i) + " ]");
            }
        }

        //iniciando los contadores de los intervalos en 0
        int[] vaIntervalos = new int[intervalos];
        float fEsperada = (float) datos.size() / intervalos;
        float[] X0 = new float[intervalos];
        float X0Acum = 0;
        double ZReferencia = chiCuadrado(intervalos - 1);

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
                if (datos.get(i) < numIntervalos.get(j)) {
                    vaIntervalos[j]++;
                    break;
                }
            }
        }

        for (int i = 0; i < intervalos; i++) {
            X0[i] = (float) (Math.pow(vaIntervalos[i] - fEsperada, 2)) / fEsperada;
            X0Acum = X0Acum + X0[i];
        }

        String mensaje1 = "";
        System.out.println("");
        System.out.println("Datos de los datos en los intervalos");
        for (int i = 0; i < intervalos; i++) {
            System.out.println(cadIntervalos.get(i) + " : " + vaIntervalos[i] + " X0: " + X0[i] + " Esperada: " + fEsperada);
            mensaje1 = mensaje1 + cadIntervalos.get(i) + " : " + String.valueOf(vaIntervalos[i]) + " X0: " + String.valueOf(X0[i]) + " Esperada: " + String.valueOf(fEsperada) + "\n";
        }
        System.out.println("X0 acumulada: " + X0Acum);

        System.out.println("Chi cuadrado: " + ZReferencia);
        if (X0Acum < ZReferencia) {
            System.out.println("Pasó la prueba");
            JOptionPane.showMessageDialog(null, "Datos de los intervalos \n" + mensaje1 + "\n"
                    + "Xo acumulada = " + X0Acum + "\n"
                    + "Chi cuadrado " + ZReferencia + "\n"
                    + "Paso la prueba");
            if (prueba2 != 1) {
                cont++;
            }

        } else {
            System.out.println("No pasó la prueba");
            JOptionPane.showMessageDialog(null, "Datos de los intervalos \n" + mensaje1 + "\n"
                    + "Xo acumulada = " + X0Acum + "\n"
                    + "Chi cuadrado " + ZReferencia + "\n"
                    + "No Paso la prueba");
        }

    }

    public double chiCuadrado(int n) {
        double chicuadra;

        switch (n) {
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
                chicuadra = 1.36 / Math.sqrt(n);

        }
        return chicuadra;
    }

    public double distReferencia(int n) {
        double chicuadra;

        switch (n) {
            case 1:
                chicuadra = 0.975;
                break;
            case 2:
                chicuadra = 0.842;
                break;
            case 3:
                chicuadra = 0.708;
                break;
            case 4:
                chicuadra = 0.624;
                break;
            case 5:
                chicuadra = 0.563;
                break;
            case 6:
                chicuadra = 0.521;
                break;
            case 7:
                chicuadra = 0.486;
                break;
            case 8:
                chicuadra = 0.457;
                break;
            case 9:
                chicuadra = 0.432;
                break;
            case 10:
                chicuadra = 0.409;
                break;
            case 11:
                chicuadra = 0.391;
                break;
            case 12:
                chicuadra = 0.375;
                break;
            case 13:
                chicuadra = 0.361;
                break;
            case 14:
                chicuadra = 0.349;
                break;
            case 15:
                chicuadra = 0.338;
                break;
            case 16:
                chicuadra = 0.328;
                break;
            case 17:
                chicuadra = 0.318;
                break;
            case 18:
                chicuadra = 0.309;
                break;
            case 19:
                chicuadra = 0.301;
                break;
            case 20:
                chicuadra = 0.294;
                break;
            default:
                chicuadra = 1.36 / Math.sqrt(n);
                break;
        }
        return chicuadra;
    }

    public ArrayList<ArrayList> pruebaColmogorov(ArrayList<Float> datos) {
        Collections.sort(datos);
        ArrayList<ArrayList> info = new ArrayList();
        ArrayList<Float> fObservadas = new ArrayList();
        ArrayList<Float> distancias = new ArrayList();
        float dnMax;

        double ZReferencia = distReferencia(datos.size());

        for (int i = 0; i < datos.size(); i++) {
            fObservadas.add((float) (i + 1) / datos.size());
            distancias.add(Math.abs(fObservadas.get(i) - datos.get(i)));
        }

        ArrayList<Float> AuxDistancia = new ArrayList(distancias);
        Collections.sort(distancias);

        dnMax = distancias.get(distancias.size() - 1);

        for (int i = 0; i < datos.size(); i++) {
            System.out.println(i + "  " + datos.get(i) + "   " + fObservadas.get(i) + "   " + AuxDistancia.get(i));
        }

        System.out.println("MAX = " + dnMax);
        System.out.println("Zrefencia = " + ZReferencia);

        if (dnMax < ZReferencia) {
            System.out.println("Pasó la prueba");
            JOptionPane.showMessageDialog(null, "Distancia Max = " + dnMax + "\n"
                    + "Zreferencia = " + ZReferencia + "\n"
                    + "PASÓ LA PRUEBA");
            if (prueba3 != 1) {
                cont++;
            }
        } else {
            System.out.println("No pasó la prueba");
            JOptionPane.showMessageDialog(null, "Distancia Max = " + dnMax + "\n"
                    + "Zreferencia = " + ZReferencia + "\n"
                    + "NO PASÓ LA PRUEBA");
        }

        info.add(datos);
        info.add(fObservadas);
        info.add(AuxDistancia);

        return info;
    }

    public void pruebaPoker(ArrayList<Float> datos) {
        String datoString;
        int numTercia = 0, numPar = 0, numDif = 0, numDosPares = 0, numFull = 0, numPoker = 0, numQui = 0;
        float probDif, probPar, probTercia, probDosPares, probFull, probPoker, probQui, probAcum = 0;
        float chiTercia, chiPar, chiDif, chiDosPares, chiFull, chiPoker, chiQui, chiCuadrado;

        for (int i = 0; i < datos.size(); i++) {
            datoString = datos.get(i).toString();
            System.out.println("Cadena sin cortar: " + datoString);
            System.out.println("Tamaño: " + datoString.length());
            int tam = datoString.length();
            if (tam < 7) {
                for (int j = 0; j < (7 - tam) + 4; j++) {
                    datoString = datoString + "0";
                }
            }

            datoString = datoString.substring(2, 7);
            System.out.println("Cadena = " + datoString);
            String dig1 = String.valueOf(datoString.charAt(0));
            String dig2 = String.valueOf(datoString.charAt(1));
            String dig3 = String.valueOf(datoString.charAt(2));
            String dig4 = String.valueOf(datoString.charAt(3));
            String dig5 = String.valueOf(datoString.charAt(4));

            if (isQuintilla(dig1, dig2, dig3, dig4, dig5)) {
                numQui++;
            } else if (isPoker(dig1, dig2, dig3, dig4, dig5)) {
                numPoker++;
            } else if (isFull(dig1, dig2, dig3, dig4, dig5)) {
                numFull++;
            } else if (isTercia(dig1, dig2, dig3, dig4, dig5)) {
                numTercia++;
            } else if (isDosPares(dig1, dig2, dig3, dig4, dig5)) {
                numDosPares++;
            } else if (isPar(dig1, dig2, dig3, dig4, dig5)) {
                numPar++;
            } else {
                numDif++;
            }
        }

        JOptionPane.showMessageDialog(null, "NÚMEROS CLASIFICADOS \n Diferentes = " + numDif + "\n"
                + "Par = " + numPar + "\n" + "DosPares = " + numDosPares + "\n"
                + "Tercias = " + numTercia + "\n" + "Full = " + numFull + "\n"
                + "Poker = " + numPoker + "\n" + "Quintilla = " + numQui);

        System.out.println("Diferentes = " + numDif);
        System.out.println("Par = " + numPar);
        System.out.println("Tercios = " + numTercia);
        System.out.println("DosPares = " + numDosPares);
        System.out.println("Full = " + numFull);
        System.out.println("Poker = " + numPoker);
        System.out.println("Quintilla = " + numQui);

        probDif = datos.size() * 0.30240f;
        probPar = datos.size() * 0.50400f;
        probTercia = datos.size() * 0.07200f;
        probFull = datos.size() * 0.00900f;
        probPoker = datos.size() * 0.00450f;
        probDosPares = datos.size() * 0.10800f;
        probQui = datos.size() * 0.00010f;

        JOptionPane.showMessageDialog(null, "FRECUENCIA ESPERADA DE CADA MANO \n Diferentes = " + probDif + "\n"
                + "Par = " + probPar + "\n" + "DosPares = " + probDosPares + "\n"
                + "Tercias = " + probTercia + "\n" + "Full = " + probFull + "\n"
                + "Poker = " + probPoker + "\n" + "Quintilla = " + probQui);

        System.out.println("Todos Diferentes = " + probDif);
        System.out.println("Un Par = " + probPar);
        System.out.println("DosPares = " + probDosPares);
        System.out.println("Tercios = " + probTercia);
        System.out.println("Full = " + probFull);
        System.out.println("Poker = " + probPoker);
        System.out.println("Quintilla = " + probQui);

        if (probDosPares < 5 && probTercia < 5 && probQui < 5 && probPoker < 5 && probFull < 5) {
            probAcum += (probPar + probDosPares + probTercia + probQui + probPoker + probFull);
            chiDif = (float) Math.pow((numDif - probDif), 2) / probDif;
            chiPar = (float) Math.pow((numPar - probAcum), 2) / probAcum;
            chiCuadrado = chiPar + chiDif;

            System.out.println("Diferentes = " + chiDif);
            System.out.println("Pares = " + chiPar);
            System.out.println("ChiCuadrado = " + chiCuadrado);

            if (chiCuadrado < 3.8415) {
                JOptionPane.showMessageDialog(null, "CHI CUADRADO PARA CADA MANO \n Diferentes = " + chiDif + "\n"
                        + "Par = " + chiPar + "\n" + "chi Cuadrado = " + chiCuadrado + "\n"
                        + "Cómo las frecuencias esperadas de Dos pares, Tercia, Full, Poker y Quintilla son menor a 5, \n estas se le agregan a Par "
                        + "para el calculo del chi cuadrado calculado, la nueva probabilidad es: " + probAcum + "\n"
                        + "Como " + chiCuadrado + " < 3.8415 entonces SE PASÓ LA PRUEBA");

                System.out.println("Los datos pasaron la prueba");
                if (prueba4 != 1) {
                    cont++;
                }
            } else {

                JOptionPane.showMessageDialog(null, "CHI CUADRADO PARA CADA MANO \n Diferentes = " + chiDif + "\n"
                        + "Par = " + chiPar + "\n" + "chi Cuadrado = " + chiCuadrado + "\n"
                        + "Cómo las frecuencias esperadas de Dos pares, Tercia, Full, Poker y Quintilla son menor a 5, \n estas se le agregan a Par "
                        + "para el calculo del chi cuadrado calculado, la nueva probabilidad es: " + probAcum + "\n"
                        + "Como " + chiCuadrado + " > 3.8415 entonces NO SE PASÓ LA PRUEBA");
                System.out.println("No pasaron la prueba");
            }
        } else if (probTercia < 5 & probQui < 5 && probPoker < 5 && probFull < 5) {
            probAcum += (probDosPares + probTercia + probQui + probPoker + probFull);
            chiPar = (float) Math.pow((numPar - probPar), 2) / probPar;
            chiDif = (float) Math.pow((numDif - probDif), 2) / probDif;
            chiDosPares = (float) Math.pow((numDosPares - probAcum), 2) / probAcum;
            chiCuadrado = chiPar + chiDif + chiDosPares;

            System.out.println("Diferentes = " + chiDif);
            System.out.println("Pares = " + chiPar);
            System.out.println("DosPares = " + chiDosPares);
            System.out.println("ChiCuadrado = " + chiCuadrado);

            if (chiCuadrado < 5.9915) {

                JOptionPane.showMessageDialog(null, "CHI CUADRADO PARA CADA MANO \n Diferentes = " + chiDif + "\n"
                        + "Par = " + chiPar + "\n" + "DosPares = " + chiDosPares + "\n" + "chi Cuadrado = " + chiCuadrado + "\n"
                        + "Cómo las frecuencias esperadas de Tercia, Full, Poker y Quintilla son menor a 5, \n estas se le agregan a Dos Pares "
                        + "para el calculo del chi cuadrado calculado, la nueva probabilidad es: " + probAcum + "\n"
                        + "Como " + chiCuadrado + " < 5.9915 entonces SE PASÓ LA PRUEBA");

                System.out.println("Los datos pasaron la prueba");
                if (prueba4 != 1) {
                    cont++;
                }
            } else {

                JOptionPane.showMessageDialog(null, "CHI CUADRADO PARA CADA MANO \n Diferentes = " + chiDif + "\n"
                        + "Par = " + chiPar + "\n" + "DosPares = " + chiDosPares + "\n" + "chi Cuadrado = " + chiCuadrado + "\n"
                        + "Cómo las frecuencias esperadas de Tercia, Full, Poker y Quintilla son menor a 5, \n estas se le agregan a Dos Pares "
                        + "para el calculo del chi cuadrado calculado, la nueva probabilidad es: " + probAcum + "\n"
                        + "Como " + chiCuadrado + " > 5.9915 entonces NO SE PASÓ LA PRUEBA");

                System.out.println("No pasaron la prueba");
            }

        } else if (probQui < 5 && probPoker < 5 && probFull < 5) {
            probAcum += (probTercia + probQui + probPoker + probFull);
            chiTercia = (float) Math.pow((numTercia - probAcum), 2) / probAcum;
            chiPar = (float) Math.pow((numPar - probPar), 2) / probPar;
            chiDif = (float) Math.pow((numDif - probDif), 2) / probDif;
            chiDosPares = (float) Math.pow((numDosPares - probDosPares), 2) / probDosPares;
            chiCuadrado = chiTercia + chiPar + chiDif + chiDosPares;

            System.out.println("Diferentes = " + chiDif);
            System.out.println("Pares = " + chiPar);
            System.out.println("Tercios = " + chiTercia);
            System.out.println("DosPares = " + chiDosPares);
            System.out.println("ChiCuadrado = " + chiCuadrado);

            if (chiCuadrado < 7.8147) {
                JOptionPane.showMessageDialog(null, "CHI CUADRADO PARA CADA MANO \n Diferentes = " + chiDif + "\n"
                        + "Par = " + chiPar + "\n" + "DosPares = " + chiDosPares + "\n" + "Tercia = " + chiTercia + "\n" + "chi Cuadrado = " + chiCuadrado + "\n"
                        + "Cómo las frecuencias esperadas de Full, Poker y Quintilla son menor a 5, \n estas se le agregan a Tercia "
                        + "para el calculo del chi cuadrado calculado, la nueva probabilidad es: " + probAcum + "\n"
                        + "Como " + chiCuadrado + " < 7.8147 entonces SE PASÓ LA PRUEBA");
                System.out.println("Los datos pasaron la prueba");
                if (prueba4 != 1) {
                    cont++;
                }
            } else {
                JOptionPane.showMessageDialog(null, "CHI CUADRADO PARA CADA MANO \n Diferentes = " + chiDif + "\n"
                        + "Par = " + chiPar + "\n" + "DosPares = " + chiDosPares + "\n" + "Tercia = " + chiTercia + "\n" + "chi Cuadrado = " + chiCuadrado + "\n"
                        + "Cómo las frecuencias esperadas de Full, Poker y Quintilla son menor a 5, \n estas se le agregan a Tercia "
                        + "para el calculo del chi cuadrado calculado, la nueva probabilidad es: " + probAcum + "\n"
                        + "Como " + chiCuadrado + " > 7.8147 entonces NO SE PASÓ LA PRUEBA");

                System.out.println("No pasaron la prueba");
            }

        } else if (probPoker < 5 && probQui < 5) {
            probAcum += (probQui + probPoker + probFull);
            chiTercia = (float) Math.pow((numTercia - probTercia), 2) / probTercia;
            chiPar = (float) Math.pow((numPar - probPar), 2) / probPar;
            chiDif = (float) Math.pow((numDif - probDif), 2) / probDif;
            chiDosPares = (float) Math.pow((numDosPares - probDosPares), 2) / probDosPares;
            chiFull = (float) Math.pow((numFull - probAcum), 2) / probAcum;
            chiCuadrado = chiTercia + chiPar + chiDif + chiDosPares + chiFull;

            System.out.println("Diferentes = " + chiDif);
            System.out.println("Pares = " + chiPar);
            System.out.println("Tercios = " + chiTercia);
            System.out.println("DosPares = " + chiDosPares);
            System.out.println("Full = " + chiFull);
            System.out.println("ChiCuadrado = " + chiCuadrado);

            if (chiCuadrado < 9.4877) {
                JOptionPane.showMessageDialog(null, "CHI CUADRADO PARA CADA MANO \n Diferentes = " + chiDif + "\n"
                        + "Par = " + chiPar + "\n" + "DosPares = " + chiDosPares + "\n" + "Tercia = " + chiTercia + "\n" + "Full = " + chiFull + "\n chi Cuadrado = " + chiCuadrado + "\n"
                        + "Cómo las frecuencias esperadas de Poker y Quintilla son menor a 5, \n estas se le agregan a Full "
                        + "para el calculo del chi cuadrado calculado, la nueva probabilidad es: " + probAcum + "\n"
                        + "Como " + chiCuadrado + " < 9.4877 entonces SE PASÓ LA PRUEBA");

                System.out.println("Los datos pasaron la prueba");
                if (prueba4 != 1) {
                    cont++;
                }
            } else {

                JOptionPane.showMessageDialog(null, "CHI CUADRADO PARA CADA MANO \n Diferentes = " + chiDif + "\n"
                        + "Par = " + chiPar + "\n" + "DosPares = " + chiDosPares + "\n" + "Tercia = " + chiTercia + "\n" + "Full = " + chiFull + "\n chi Cuadrado = " + chiCuadrado + "\n"
                        + "Cómo las frecuencias esperadas de Poker y Quintilla son menor a 5, \n estas se le agregan a Full "
                        + "para el calculo del chi cuadrado calculado, la nueva probabilidad es: " + probAcum + "\n"
                        + "Como " + chiCuadrado + " > 9.4877 entonces NO SE PASÓ LA PRUEBA");

                System.out.println("No pasaron la prueba");
            }

        } else if (probQui < 5) {
            probAcum += (probPoker + probQui);
            chiTercia = (float) Math.pow((numTercia - probTercia), 2) / probTercia;
            chiPar = (float) Math.pow((numPar - probPar), 2) / probPar;
            chiDif = (float) Math.pow((numDif - probDif), 2) / probDif;
            chiDosPares = (float) Math.pow((numDosPares - probDosPares), 2) / probDosPares;
            chiFull = (float) Math.pow((numFull - probFull), 2) / probFull;
            chiPoker = (float) Math.pow((numPoker - probAcum), 2) / probAcum;
            chiCuadrado = chiTercia + chiPar + chiDif + chiDosPares + chiFull + chiPoker;

            if (chiCuadrado < 11.0705) {

                JOptionPane.showMessageDialog(null, "CHI CUADRADO PARA CADA MANO \n Diferentes = " + chiDif + "\n"
                        + "Par = " + chiPar + "\n" + "DosPares = " + chiDosPares + "\n" + "Tercia = " + chiTercia + "\n" + "Full = " + chiFull + "\n Poker = " + chiPoker + "\n chi Cuadrado = " + chiCuadrado + "\n"
                        + "Cómo la frecuencias esperada de Quintilla es menor a 5, \n estas se le agregan a poker"
                        + "para el calculo del chi cuadrado calculado, la nueva probabilidad es: " + probAcum + "\n"
                        + "Como " + chiCuadrado + " < 11.0705 entonces SE PASÓ LA PRUEBA");

                System.out.println("Los datos pasaron la prueba");
                if (prueba4 != 1) {
                    cont++;
                }
            } else {

                JOptionPane.showMessageDialog(null, "CHI CUADRADO PARA CADA MANO \n Diferentes = " + chiDif + "\n"
                        + "Par = " + chiPar + "\n" + "DosPares = " + chiDosPares + "\n" + "Tercia = " + chiTercia + "\n" + "Full = " + chiFull + "\n Poker = " + chiPoker + "\n chi Cuadrado = " + chiCuadrado + "\n"
                        + "Cómo la frecuencias esperada de Quintilla es menor a 5, \n estas se le agregan a poker"
                        + "para el calculo del chi cuadrado calculado, la nueva probabilidad es: " + probAcum + "\n"
                        + "Como " + chiCuadrado + " > 11.0705 entonces NO SE PASÓ LA PRUEBA");

                System.out.println("No pasaron la prueba");
            }
        } else {
            chiTercia = (float) Math.pow((numTercia - probTercia), 2) / probTercia;
            chiPar = (float) Math.pow((numPar - probPar), 2) / probPar;
            chiDif = (float) Math.pow((numDif - probDif), 2) / probDif;
            chiDosPares = (float) Math.pow((numDosPares - probDosPares), 2) / probDosPares;
            chiFull = (float) Math.pow((numFull - probFull), 2) / probFull;
            chiPoker = (float) Math.pow((numPoker - probPoker), 2) / probPoker;
            chiQui = (float) (Math.pow((numQui - probQui), 2)) / (probQui);

            chiCuadrado = chiTercia + chiPar + chiDif + chiDosPares + chiFull + chiPoker + chiQui;

            System.out.println("Diferentes = " + chiDif);
            System.out.println("Pares = " + chiPar);
            System.out.println("Tercios = " + chiTercia);
            System.out.println("DosPares = " + chiDosPares);
            System.out.println("Full = " + chiFull);
            System.out.println("Poker = " + chiPoker);
            System.out.println("Quintilla = " + chiQui);
            System.out.println("ChiCuadrado = " + chiCuadrado);
            if (chiCuadrado < 12.5916) {
                JOptionPane.showMessageDialog(null, "CHI CUADRADO PARA CADA MANO \n Diferentes = " + chiDif + "\n"
                        + "Par = " + chiPar + "\n" + "DosPares = " + chiDosPares + "\n" + "Tercia = " + chiTercia + "\n" + "Full = " + chiFull + "\n Poker = " + chiPoker + "\n Quintilla = " + chiQui + "\n chi Cuadrado = " + chiCuadrado + "\n"
                        + "Como " + chiCuadrado + " < 12.5916 entonces SE PASÓ LA PRUEBA");

                System.out.println("Los datos pasaron la prueba");
                if (prueba4 != 1) {
                    cont++;
                }
            } else {

                JOptionPane.showMessageDialog(null, "CHI CUADRADO PARA CADA MANO \n Diferentes = " + chiDif + "\n"
                        + "Par = " + chiPar + "\n" + "DosPares = " + chiDosPares + "\n" + "Tercia = " + chiTercia + "\n" + "Full = " + chiFull + "\n Poker = " + chiPoker + "\n Quintilla = " + chiQui + "\n chi Cuadrado = " + chiCuadrado + "\n"
                        + "Como " + chiCuadrado + " > 12.5916 entonces NO SE PASÓ LA PRUEBA");
                System.out.println("No pasaron la prueba");
            }
        }
    }

    public boolean isQuintilla(String dig1, String dig2, String dig3, String dig4, String dig5) {
        return (dig1.equals(dig2) && dig1.equals(dig3) && dig1.equals(dig4) && dig1.equals(dig5));
    }

    public boolean isPoker(String dig1, String dig2, String dig3, String dig4, String dig5) {

        return ((dig1.equals(dig2) && dig1.equals(dig3) && dig1.equals(dig4) && !dig1.equals(dig5))
                || (dig1.equals(dig2) && dig1.equals(dig3) && !dig1.equals(dig4) && dig1.equals(dig5))
                || (dig1.equals(dig2) && !dig1.equals(dig3) && dig1.equals(dig4) && dig1.equals(dig5))
                || (!dig1.equals(dig2) && dig1.equals(dig3) && dig1.equals(dig4) && dig1.equals(dig5))
                || (dig2.equals(dig1) && dig2.equals(dig3) && !dig2.equals(dig4) && dig2.equals(dig5))
                || (dig2.equals(dig1) && !dig2.equals(dig3) && dig2.equals(dig4) && dig2.equals(dig5))
                || (!dig2.equals(dig1) && dig2.equals(dig3) && dig2.equals(dig4) && dig2.equals(dig5))
                || (dig3.equals(dig1) && !dig3.equals(dig2) && dig3.equals(dig4) && dig3.equals(dig5))
                || (!dig3.equals(dig1) && dig3.equals(dig2) && dig3.equals(dig4) && dig3.equals(dig5))
                || (!dig4.equals(dig1) && dig4.equals(dig2) && dig4.equals(dig3) && dig4.equals(dig5)));
    }

    public boolean isFull(String dig1, String dig2, String dig3, String dig4, String dig5) {
        return (isTercia(dig1, dig2, dig3, dig4, dig5) && isPar(dig1, dig2, dig3, dig4, dig5));
    }

    public boolean isTercia(String dig1, String dig2, String dig3, String dig4, String dig5) {
        return ((dig1.equals(dig2) && dig1.equals(dig3) && !dig1.equals(dig4) && !dig1.equals(dig5))
                || (dig1.equals(dig2) && !dig1.equals(dig3) && dig1.equals(dig4) && !dig1.equals(dig5))
                || (dig1.equals(dig2) && !dig1.equals(dig3) && !dig1.equals(dig4) && dig1.equals(dig5))
                || (!dig1.equals(dig2) && dig1.equals(dig3) && dig1.equals(dig4) && !dig1.equals(dig5))
                || (!dig1.equals(dig2) && dig1.equals(dig3) && !dig1.equals(dig4) && dig1.equals(dig5))
                || (!dig1.equals(dig2) && !dig1.equals(dig3) && dig1.equals(dig4) && dig1.equals(dig5)));
    }

    public boolean isDosPares(String dig1, String dig2, String dig3, String dig4, String dig5) {
        return ((dig1.equals(dig2) && dig3.equals(dig4))
                || (dig1.equals(dig2) && dig3.equals(dig5))
                || (dig1.equals(dig2) && dig4.equals(dig5))
                || (dig1.equals(dig3) && dig2.equals(dig4))
                || (dig1.equals(dig3) && dig2.equals(dig5))
                || (dig1.equals(dig3) && dig4.equals(dig5))
                || (dig1.equals(dig4) && dig2.equals(dig3))
                || (dig1.equals(dig4) && dig2.equals(dig5))
                || (dig1.equals(dig4) && dig3.equals(dig5)));
    }

    public boolean isPar(String dig1, String dig2, String dig3, String dig4, String dig5) {
        return ((dig1.equals(dig2) && !dig1.equals(dig3) && !dig1.equals(dig4) && !dig1.equals(dig5))
                || (!dig1.equals(dig2) && dig1.equals(dig3) && !dig1.equals(dig4) && !dig1.equals(dig5))
                || (!dig1.equals(dig2) && !dig1.equals(dig3) && dig1.equals(dig4) && !dig1.equals(dig5))
                || (!dig1.equals(dig2) && !dig1.equals(dig3) && !dig1.equals(dig4) && dig1.equals(dig5))
                || (!dig2.equals(dig1) && dig2.equals(dig3) && !dig2.equals(dig4) && !dig2.equals(dig5))
                || (!dig2.equals(dig1) && !dig2.equals(dig3) && dig2.equals(dig4) && !dig2.equals(dig5))
                || (!dig2.equals(dig1) && !dig2.equals(dig3) && !dig2.equals(dig4) && dig2.equals(dig5))
                || (!dig3.equals(dig1) && !dig3.equals(dig2) && dig3.equals(dig4) && !dig2.equals(dig5))
                || (!dig3.equals(dig1) && !dig3.equals(dig2) && !dig3.equals(dig4) && dig2.equals(dig5))
                || (!dig4.equals(dig1) && !dig4.equals(dig2) && !dig4.equals(dig3) && dig4.equals(dig5)));
    }

    public void pruebaHuecos(ArrayList<Float> listaNumR) {

        // Definimos el intervalo
        float alfa = 0.3f, beta = 0.7f;

        // Lista donde se guardan las equivalencias de número pertenecientes al intervalo
        ArrayList<Integer> UnoCero = new ArrayList<>();

        // Guardamos como 1 si se encuentra y 0 si no
        for (int i = 0; i < listaNumR.size(); i++) {
            if (listaNumR.get(i) >= alfa && listaNumR.get(i) < beta) {
                UnoCero.add(1);
            } else {
                UnoCero.add(0);
            }
        }

        // Arreglo para guardar los tamaños de cada hueco
        ArrayList<Integer> tamHuecos = new ArrayList<>();

        // Contador del número de huecos
        int numHuecos = 0;

        // Contador del número de ceros
        int contCero = 0;

        // Recorremos el arreglo de 1 y 0
        for (int i = 0; i < UnoCero.size(); i++) {

            // Si existe un número siguiente a la posición
            if (i < UnoCero.size() - 1) {

                //Si la posición es 1 hay un hueco
                if (UnoCero.get(i) == 1) {
                    numHuecos++;

                    // Se recorren los números a partir del 1 encontrado
                    for (int j = i + 1; j < UnoCero.size(); j++) {

                        // Cuando se encuentre un 0 aumenta el contador
                        if (UnoCero.get(j) == 0) {
                            contCero++;
                        } else {
                            // Cuando ya no sea 0, se guarda el tamaño
                            // final de ese hueco
                            tamHuecos.add(contCero);
                            contCero = 0;
                            i = j - 1;
                            break;
                        }
                    }
                }
            }
        }

        // Si el arreglo termina en 0 quiere decir que no se alcanzó
        // a completar un hueco, por eso se le resta 1 a nHuecos
        if (UnoCero.get(UnoCero.size() - 1) == 0) {
            numHuecos--;
        }

        ArrayList<Integer> copiaTamHuecos = new ArrayList<>(tamHuecos);
        ArrayList<Integer> cantRep = new ArrayList<>();
        ArrayList<Integer> datosEvaluados = new ArrayList<>();
        int auxCantHuecos;
        for (int i = 0; i < numHuecos; i++) {
            auxCantHuecos = 0;

            if (!datosEvaluados.contains(copiaTamHuecos.get(i))) {
                datosEvaluados.add(copiaTamHuecos.get(i));
                for (int j = i + 1; j < numHuecos; j++) {
                    if (Objects.equals(copiaTamHuecos.get(i), copiaTamHuecos.get(j))) {
                        auxCantHuecos++;
                    }
                    if (j == numHuecos - 1) {
                        cantRep.add(auxCantHuecos + 1);
                    }
                }
                if (auxCantHuecos == 0) {
                    cantRep.add(auxCantHuecos);
                }
            }
        }

        System.out.println("repetidos: " + cantRep.size());
        System.out.println("repetidos: " + datosEvaluados.size());
        int[] auxCantRep = new int[datosEvaluados.size()];
        for (int i = 0; i < datosEvaluados.size(); i++) {
            for (int j = 0; j < datosEvaluados.size() - 1; j++) {

                int actual = datosEvaluados.get(j);
                int sig = datosEvaluados.get(j + 1);

                if (actual > sig) {
                    datosEvaluados.set(j, sig);
                    datosEvaluados.set(j + 1, actual);

                    auxCantRep[j] = cantRep.get(j + 1);
                    auxCantRep[j + 1] = cantRep.get(j);
                }
            }
        }

        double F_Esperada = 0, sumF_Esperada = 0;

        ArrayList<Double> F_Esperadas = new ArrayList<>();

        for (int i = 0; i < datosEvaluados.size(); i++) {
            F_Esperada = numHuecos * (beta - alfa) * Math.pow((1 - (beta - alfa)), datosEvaluados.get(i));
            F_Esperadas.add(F_Esperada);
            sumF_Esperada = sumF_Esperada + F_Esperada;
        }

        double chiCuadrado = 0;
        ArrayList<Double> sumChiCuadrado = new ArrayList<>();
        for (int i = 0; i < datosEvaluados.size(); i++) {
            sumChiCuadrado.add((double) Math.pow((F_Esperadas.get(i) - auxCantRep[i]), 2) / F_Esperadas.get(i));
            chiCuadrado += sumChiCuadrado.get(i);
        }

        System.out.println("");
        String mensaje = "";
        for (int i = 0; i < datosEvaluados.size(); i++) {
            System.out.println("Para " + datosEvaluados.get(i) + ", O = " + auxCantRep[i] + ", E = " + F_Esperadas.get(i) + " Chi Cuadrado = " + sumChiCuadrado.get(i));
            mensaje += "Para " + datosEvaluados.get(i) + ", O = " + auxCantRep[i] + ", E = " + F_Esperadas.get(i) + " Chi Cuadrado = " + sumChiCuadrado.get(i) + "\n";
        }

        System.out.println("Acumulado: " + chiCuadrado);
        double chi = chiCuadrado(datosEvaluados.size() - 1);
        if (chiCuadrado < chi) {
            JOptionPane.showMessageDialog(null, mensaje + "\n" + "Chi cuadrado acumulado = " + chiCuadrado + "\n"
                    + "Como " + chiCuadrado + " < " + chi + " entonces PASÓ LA PRUEBA");

            if (prueba5 != 1) {
                cont++;
            }
            System.out.println("Pasó la prueba");

        } else {
            JOptionPane.showMessageDialog(null, mensaje + "\n" + "Chi cuadrado acumulado = " + chiCuadrado + "\n"
                    + "Como " + chiCuadrado + " > " + chi + " entonces NO PASÓ LA PRUEBA");
            System.out.println("No pasó la prueba");
        }
    }
}
