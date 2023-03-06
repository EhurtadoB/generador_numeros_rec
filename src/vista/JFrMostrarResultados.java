/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.ExportarExcel;
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
        this.jTextAreaRecomendaciones.removeAll();

        if (metodo.equalsIgnoreCase("mixto")) {
            String[] titulo = new String[]{"n", "Xo", "a", "c", "m", "r"};
            modelo.setColumnIdentifiers(titulo);
            jTableResultados.setModel(modelo);

            int x = -1, a = -1, c = -1, m = -1;
            do {
                x = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la semilla x"));
                if (x <= 0) {
                    JOptionPane.showMessageDialog(null, "La semilla tiene que ser mayor a cero", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            } while (x <= 0);
            do {
                a = Integer.parseInt(JOptionPane.showInputDialog("El multiplicador a"));
                if (a <= 0) {
                    JOptionPane.showMessageDialog(null, "El multiplicador a debe ser mayor a cero", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            } while (a <= 0);

            do {
                c = Integer.parseInt(JOptionPane.showInputDialog("Constante aditiva c"));
                if (c <= 0) {
                    JOptionPane.showMessageDialog(null, "La constante aditiva c debe ser mayor a cero", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            } while (c <= 0);

            do {
                m = Integer.parseInt(JOptionPane.showInputDialog("El módulo m"));
                if (m <= 0 || m <= x || m <= a || m <= c) {
                    JOptionPane.showMessageDialog(null, "El modulo debe ser mayor a los valores ya ingresados", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            } while (m <= 0 || m <= x || m <= a || m <= c);

            this.jTextAreaRecomendaciones.append("Recomendaciones\n");
            this.jTextAreaRecomendaciones.append(System.getProperty("line.separator"));
            if (!generador.esPrimo(m)) {
                this.jTextAreaRecomendaciones.append("m debe ser número primo");
                this.jTextAreaRecomendaciones.append(System.getProperty("line.separator"));
            }
            if (a <= c) {
                this.jTextAreaRecomendaciones.append("a debe ser mayor a la constante aditiva");
                this.jTextAreaRecomendaciones.append(System.getProperty("line.separator"));
            }
            if (a % 2 == 0) {
                this.jTextAreaRecomendaciones.append("a debe ser impar");
                this.jTextAreaRecomendaciones.append(System.getProperty("line.separator"));
            }
            if ((a % 3) == 0 || (a % 5) == 0) {
                this.jTextAreaRecomendaciones.append("a debe ser no divisible de 3 o 5");
                this.jTextAreaRecomendaciones.append(System.getProperty("line.separator"));
            }
            if ((c % 8) != 5) {
                this.jTextAreaRecomendaciones.append("c mod 8 debe ser igual a 5 para obtener mejores resultados");
                this.jTextAreaRecomendaciones.append(System.getProperty("line.separator"));
            }
            if (!generador.esPrimo(c)) {
                this.jTextAreaRecomendaciones.append("c debe ser primo");
                this.jTextAreaRecomendaciones.append(System.getProperty("line.separator"));
            }

            datos = generador.genCongruencialMixto(x, a, c, m);
            try {
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
            } catch (ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "Escriba números validos", "Error!", JOptionPane.ERROR_MESSAGE);
            }

        }
        if (metodo.equalsIgnoreCase("multiplicativo")) {
            String[] titulo = new String[]{"n", "Xo", "a", "m", "r"};
            modelo.setColumnIdentifiers(titulo);
            jTableResultados.setModel(modelo);

            int x = -1, a = -1, m = -1;

            do {

                x = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la semilla de la función: "));
                if (x <= 0) {
                    JOptionPane.showMessageDialog(null, "La semilla tiene que ser mayor a cero", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            } while (x <= 0);
            do {

                a = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la constante multiplicativa de la función: "));
                if (a <= 0) {
                    JOptionPane.showMessageDialog(null, "La constante multiplicativa tiene que ser mayor a cero", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            } while (a <= 0);
            do {

                m = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el módulo de la función: "));
                if (m <= 0) {
                    JOptionPane.showMessageDialog(null, "La constante multiplicativa tiene que ser mayor a cero", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            } while (m <= 0);

            this.jTextAreaRecomendaciones.append("Recomendaciones\n");
            this.jTextAreaRecomendaciones.append(System.getProperty("line.separator"));
            if ((x % 2) == 0) {
                this.jTextAreaRecomendaciones.append("x debe ser impar");
                this.jTextAreaRecomendaciones.append(System.getProperty("line.separator"));
            }
            if ((x % 5) == 0) {
                this.jTextAreaRecomendaciones.append("x no debe ser divisible entre 5");
                this.jTextAreaRecomendaciones.append(System.getProperty("line.separator"));
            }
            this.jTextAreaRecomendaciones.append("El valor seleccionado de a debe ser obtenido de acuerdo a la siguiente identidad: a = 200t + - p, donde t es cualquier entero y p es cualquiera de los siguientes valores: 3, 11, 13, 19, 21, 27, 29, 37, 53, 59, 61, 67, 69, 77, 83, 91.");
            this.jTextAreaRecomendaciones.append(System.getProperty("line.separator"));

            datos = generador.genConMultiplicativo(x, a, m);
            try {
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
            } catch (ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "Escriba números validos", "Error!", JOptionPane.ERROR_MESSAGE);
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
                    JOptionPane.showMessageDialog(null, "X1 debe ser mayor a 0", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            } while (x1 <= 0);
            do {
                x2 = Integer.parseInt(JOptionPane.showInputDialog("Valor para x2: "));
                if (x2 <= 0) {
                    JOptionPane.showMessageDialog(null, "X2 debe ser mayor a 0", "Error!", JOptionPane.ERROR_MESSAGE);
                }

            } while (x2 <= 0);
            do {
                m = Integer.parseInt(JOptionPane.showInputDialog("Valor para el modulo m:"));
                if (m <= 0) {
                    JOptionPane.showMessageDialog(null, "m debe ser mayor a 0", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            } while (m <= 0);

            this.jTextAreaRecomendaciones.append("Recomendaciones\n");
            this.jTextAreaRecomendaciones.append(System.getProperty("line.separator"));
            if (x2 < x1) {
                // Recomendación! x2 debe ser mayor a x1
                this.jTextAreaRecomendaciones.append("x2 debe ser mayor a x1\n");
                this.jTextAreaRecomendaciones.append(System.getProperty("line.separator"));

            }

            datos = generador.fibonacci(x1, x2, m);
            try {
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
            } catch (ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "Escriba números validos", "Error!", JOptionPane.ERROR_MESSAGE);
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
                    JOptionPane.showMessageDialog(null, "La semilla debe ser mayor a 3 digitos", "Error!", JOptionPane.ERROR_MESSAGE);
                }
                if (tamCadena <= 0) {
                    JOptionPane.showMessageDialog(null, "La semilla debe ser mayor a 0");
                }

            } while (x <= 0 || tamCadena <= 3);
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
                        JOptionPane.showMessageDialog(null, "La semilla debe ser mayor a 3 digitos", "Error!", JOptionPane.ERROR_MESSAGE);
                    }
                    if (x1 <= 0) {

                        JOptionPane.showMessageDialog(null, "La semilla debe ser mayor a 0", "Error!", JOptionPane.ERROR_MESSAGE);

                    }
                } while (x1 <= 0 || tamCadena1 <= 3);
                do {
                    x2 = Integer.parseInt(JOptionPane.showInputDialog("Valor para la semilla X1: "));
                    String cadena = String.valueOf(x2);
                    tamCadena2 = cadena.length();
                    if (tamCadena2 <= 3) {
                        //La semilla debe ser mayor a 3 digitos
                        JOptionPane.showMessageDialog(null, "La semilla debe ser mayor a 3 digitos", "Error!", JOptionPane.ERROR_MESSAGE);
                    }
                    if (x2 <= 0) {
                        JOptionPane.showMessageDialog(null, "La semilla debe ser mayor a 0", "Error!", JOptionPane.ERROR_MESSAGE);
                    }
                } while (x2 <= 0 || tamCadena2 <= 3);
                if (tamCadena1 != tamCadena2) {
                    JOptionPane.showMessageDialog(null, "El número de digitos de Xo y X1 deben ser iguales", "Error!", JOptionPane.ERROR_MESSAGE);

                }
            } while (tamCadena1 != tamCadena2);
            do {

                n = Integer.parseInt(JOptionPane.showInputDialog("Cuantos valores desea ver: "));
                if (n <= 0) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese n mayor a 0", "Error!", JOptionPane.ERROR_MESSAGE);
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
            int tamCadena1;
            int tamCadena2;
            do {
                do {

                    x = Integer.parseInt(JOptionPane.showInputDialog("Valor para la semilla X: "));
                    if (x <= 0) {
                        JOptionPane.showMessageDialog(null, "X debe ser mayor a 0", "Error!", JOptionPane.ERROR_MESSAGE);
                    }
                    String cadena = String.valueOf(x);
                    tamCadena1 = cadena.length();
                    if (tamCadena1 <= 3) {
                        //La semilla debe ser mayor a 3 digitos
                        JOptionPane.showMessageDialog(null, "La semilla debe ser mayor a 3 digitos", "Error!", JOptionPane.ERROR_MESSAGE);
                    }
                } while (x <= 0 || tamCadena1 <= 3);
                do {

                    a = Integer.parseInt(JOptionPane.showInputDialog("Valor para la constante multiplicativa: "));
                    if (a <= 0) {
                        JOptionPane.showMessageDialog(null, "a debe ser mayor a 0", "Error!", JOptionPane.ERROR_MESSAGE);
                    }
                    String cadena = String.valueOf(a);
                    tamCadena2 = cadena.length();
                    if (tamCadena2 <= 3) {

                        JOptionPane.showMessageDialog(null, "a debe ser mayor a 3 digitos", "Error!", JOptionPane.ERROR_MESSAGE);
                    }
                } while (a <= 0 || tamCadena2 <= 3);
                if (tamCadena1 != tamCadena2) {
                    JOptionPane.showMessageDialog(null, "El número de digitos de Xo y X1 deben ser iguales", "Error!", JOptionPane.ERROR_MESSAGE);

                }
            } while (tamCadena1 != tamCadena2);

            do {

                n = Integer.parseInt(JOptionPane.showInputDialog("Cuantos valores desea ver: "));
                if (n <= 0) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese n mayor a 0", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            } while (n <= 0);

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
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaRecomendaciones = new javax.swing.JTextArea();
        jButtonDevolver = new javax.swing.JButton();
        jButtonExportar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

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

        jTextAreaRecomendaciones.setEditable(false);
        jTextAreaRecomendaciones.setColumns(20);
        jTextAreaRecomendaciones.setRows(5);
        jScrollPane2.setViewportView(jTextAreaRecomendaciones);

        jButtonDevolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/icons8-gira-a-la-izquierda-48.png"))); // NOI18N
        jButtonDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDevolverActionPerformed(evt);
            }
        });

        jButtonExportar.setText("Exportar a EXCEL");
        jButtonExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonExportar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonDevolver, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGap(71, 71, 71))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonDevolver, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonExportar)))
                .addContainerGap(28, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDevolverActionPerformed
        // TODO add your handling code here:
        JFrPrincipal principal = new JFrPrincipal();
        principal.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_jButtonDevolverActionPerformed

    private void jButtonExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExportarActionPerformed
        // TODO add your handling code here:
        ExportarExcel obj;

        try {
            obj = new ExportarExcel();
            obj.exportarExcel(jTableResultados);
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        }
    }//GEN-LAST:event_jButtonExportarActionPerformed

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
    private javax.swing.JButton jButtonDevolver;
    private javax.swing.JButton jButtonExportar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableResultados;
    private javax.swing.JTextArea jTextAreaRecomendaciones;
    // End of variables declaration//GEN-END:variables
}
