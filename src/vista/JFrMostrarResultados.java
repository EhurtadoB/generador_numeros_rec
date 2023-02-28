/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.Generador;
import static vista.JFrPrincipal.metodo;

/**
 *
 * @author Eleana Hurtado
 */
public class JFrMostrarResultados extends javax.swing.JFrame {

    /**
     * Creates new form JFrMostrarResultados
     */
    DefaultTableModel modelo;

    public JFrMostrarResultados() {
        initComponents();
        this.setLocationRelativeTo(null);
        modelo = new DefaultTableModel();
        Generador generador = new Generador();
        ArrayList<Integer> numerosEnteros = new ArrayList<>();
        ArrayList<ArrayList> datos = new ArrayList<>();

        if (metodo.equalsIgnoreCase("mixto")) {
            String[] titulo = new String[]{"n", "Xo", "a", "c", "m", "r"};
            modelo.setColumnIdentifiers(titulo);
            jTableResultados.setModel(modelo);

            int x = -1, a = -1, c = -1, m = -1;
            do {

                x = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la semilla x"));
                a = Integer.parseInt(JOptionPane.showInputDialog("El multiplicador a"));
                c = Integer.parseInt(JOptionPane.showInputDialog("Constante aditiva c"));
                m = Integer.parseInt(JOptionPane.showInputDialog("El módulo m"));

            } while (x < 0 && a < 0 && c < 0 && m < 0);

            datos = generador.genCongruencialMixto(x, a, c, m);

            String[] info = new String[datos.get(0).size()];
            info[2] = Integer.toString(a);
            info[3] = Integer.toString(c);
            info[4] = Integer.toString(m);
            for (int i = 0; i < datos.get(0).size(); i++) {
                info[0] = Integer.toString(i);
                info[1] = datos.get(0).get(i).toString();
                if (i == 0) {
                    info[5] = "";
                } else {
                    info[5] = datos.get(1).get(i).toString();
                }

                if (i > 0) {
                    info[2] = "";
                    info[3] = "";
                    info[4] = "";
                }
                modelo.addRow(info);
            }
        }
        if (metodo.equalsIgnoreCase("multiplicativo")) {
            String[] titulo = new String[]{"n", "Xo", "a", "m", "r"};
            modelo.setColumnIdentifiers(titulo);
            jTableResultados.setModel(modelo);

            int x = -1, a = -1, m = -1;
            do {

                x = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la semilla de la función: "));
                a = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la constante multiplicativa de la función: "));
                m = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el módulo de la función: "));

            } while (x < 0 && a < 0 && m < 0);

            datos = generador.genConMultiplicativo(x, a, m);

            String[] info = new String[datos.get(0).size()];
            info[2] = Integer.toString(a);
            info[3] = Integer.toString(m);
            for (int i = 0; i < datos.get(0).size(); i++) {
                info[0] = Integer.toString(i);
                info[1] = datos.get(0).get(i).toString();
                if (i == 0) {
                    info[4] = "";
                } else {
                    info[4] = datos.get(1).get(i).toString();
                }
                if (i > 0) {
                    info[2] = "";
                    info[3] = "";
                }
                modelo.addRow(info);
            }
        }
        if (metodo.equalsIgnoreCase("fibonacci")) {
            String[] titulo = new String[]{"n", "X", "m", "r"};
            modelo.setColumnIdentifiers(titulo);
            jTableResultados.setModel(modelo);

            int x1 = -1, x2 = -1, m = -1;
            do {

                x1 = Integer.parseInt(JOptionPane.showInputDialog("Valor para x1: "));
                if (x1 <= 0) {
                    JOptionPane.showMessageDialog(null, "X1 debe ser mayor a 0");
                }
            } while (x1 <= 0);
            do {
                x2 = Integer.parseInt(JOptionPane.showInputDialog("Valor para x2: "));
                if (x2 <= 0) {
                    JOptionPane.showMessageDialog(null, "X2 debe ser mayor a 0");
                }

                if (x2 < x1) {
                    // Recomendación! x2 debe ser mayor a x1
                }
            } while (x2 <= 0);
            do {
                m = Integer.parseInt(JOptionPane.showInputDialog("Valor para el modulo m:"));
                if (m <= 0) {
                    JOptionPane.showMessageDialog(null, "m debe ser mayor a 0");
                }
            } while (m <= 0);

            datos = generador.fibonacci(x1, x2, m);

            String[] info = new String[datos.get(0).size()];
            info[2] = Integer.toString(m);
            for (int i = 0; i < datos.get(0).size(); i++) {
                info[0] = Integer.toString(i);
                info[1] = datos.get(0).get(i).toString();
                if (i > 0) {
                    info[2] = "";
                }
                if (i < 2) {
                    info[3] = "";
                } else {
                    info[3] = datos.get(1).get(i).toString();
                }
                modelo.addRow(info);
            }
        }
        if (metodo.equalsIgnoreCase("cuadradosMedios")) {
            String[] titulo = new String[]{"n", "Xn", "Xn*Xn", "Xn+1", "Rango"};
            modelo.setColumnIdentifiers(titulo);
            jTableResultados.setModel(modelo);

            int x = -1, n = -1;
            int tamCadena;
            do {

                x = Integer.parseInt(JOptionPane.showInputDialog("Valor para la semilla X0: "));
                String cadena = String.valueOf(x);
                tamCadena = cadena.length();
                if (tamCadena <= 3) {
                    //La semilla debe ser mayor a 3 digitos
                }
                if (tamCadena <= 0) {
                    JOptionPane.showMessageDialog(null, "La semilla debe ser mayor a 0");
                }

            } while (x <= 0);
            do {
                n = Integer.parseInt(JOptionPane.showInputDialog("Cuantos valores desea ver: "));
                if (n <= 0) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese n mayor a 0");
                }
            } while (n <= 0);

            datos = generador.cuadradosMedios(x, n);

            String[] info = new String[datos.get(0).size()];
            for (int i = 0; i < n; i++) {
                info[0] = Integer.toString(i);
                info[1] = datos.get(0).get(i).toString();
                info[2] = datos.get(1).get(i).toString();
                info[3] = datos.get(0).get(i + 1).toString();
                info[4] = datos.get(2).get(i).toString();
                modelo.addRow(info);
            }
        }
        if (metodo.equalsIgnoreCase("productosMedios")) {
            String[] titulo = new String[]{"n", "Xn", "Xn-1*Xn", "Xn+1", "Rango"};
            modelo.setColumnIdentifiers(titulo);
            jTableResultados.setModel(modelo);

            int x1 = -1, n = -1, x2 = -1;
            int tamCadena1;
            int tamCadena2;
            do {
                do {

                    x1 = Integer.parseInt(JOptionPane.showInputDialog("Valor para la semilla X0: "));
                    String cadena = String.valueOf(x1);
                    tamCadena1 = cadena.length();
                    if (tamCadena1 <= 3) {
                        //La semilla debe ser mayor a 3 digitos
                    }
                    if (x1 <= 0) {
                        JOptionPane.showMessageDialog(null, "La semilla debe ser mayor a 0");
                    }
                } while (x1 <= 0);
                do {
                    x2 = Integer.parseInt(JOptionPane.showInputDialog("Valor para la semilla X1: "));
                    String cadena = String.valueOf(x2);
                    tamCadena2 = cadena.length();
                    if (tamCadena2 <= 3) {
                        //La semilla debe ser mayor a 3 digitos
                    }
                    if (x2 <= 0) {
                        JOptionPane.showMessageDialog(null, "La semilla debe ser mayor a 0");
                    }
                } while (x2 <= 0);
                if(tamCadena1 != tamCadena2){
                    JOptionPane.showMessageDialog(null, "El número de digitos de Xo y X1 deben ser iguales");
                }
            } while (tamCadena1 != tamCadena2);
            do {

                n = Integer.parseInt(JOptionPane.showInputDialog("Cuantos valores desea ver: "));
                if (n <= 0) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese n mayor a 0");
                }
            } while (n <= 0);

            datos = generador.productosMedios(x1, x2, n);

            String[] info = new String[datos.get(0).size()];
            for (int i = 0; i < n; i++) {
                info[0] = Integer.toString(i);
                if (i == 0) {
                    info[1] = datos.get(0).get(i).toString();
                    info[2] = "";
                    info[3] = datos.get(0).get(i + 1).toString();
                    info[4] = "";
                } else {
                    info[1] = datos.get(0).get(i).toString();
                    info[2] = datos.get(1).get(i - 1).toString();
                    info[3] = datos.get(0).get(i + 1).toString();
                    info[4] = datos.get(2).get(i).toString();
                }
                modelo.addRow(info);
            }
        }
        if (metodo.equalsIgnoreCase("multiplicarConstante")) {
            String[] titulo = new String[]{"n", "Xn", "a", "Xn*a", "Xn+1", "Rango"};
            modelo.setColumnIdentifiers(titulo);
            jTableResultados.setModel(modelo);

            int x = -1, n = -1, a = -1;
            do {

                x = Integer.parseInt(JOptionPane.showInputDialog("Valor para la semilla X: "));
                a = Integer.parseInt(JOptionPane.showInputDialog("Valor para la constante multiplicativa: "));
                n = Integer.parseInt(JOptionPane.showInputDialog("Cuantos valores desea ver: "));

            } while (x < 0 && n < 0 && a < 0);

            datos = generador.genMultiplicadorConstante(x, a, n);

            String[] info = new String[datos.get(0).size()];
            for (int i = 0; i < n; i++) {
                info[0] = Integer.toString(i);
                info[1] = datos.get(0).get(i).toString();
                info[3] = datos.get(1).get(i).toString();
                info[4] = datos.get(0).get(i + 1).toString();
                info[5] = datos.get(2).get(i).toString();
                if (i != 0) {
                    info[2] = "";
                } else {
                    info[2] = Integer.toString(a);
                }

                modelo.addRow(info);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableResultados = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));

        jTableResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableResultados);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrMostrarResultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrMostrarResultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrMostrarResultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrMostrarResultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrMostrarResultados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableResultados;
    // End of variables declaration//GEN-END:variables
}
