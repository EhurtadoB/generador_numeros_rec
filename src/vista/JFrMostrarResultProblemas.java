/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import logica.ExportarExcel;
import logica.MetodosExcel;
import logica.ResolverProblema;
import static vista.JFrResolverProblemas.ResoltablaMatriz;
import static vista.JFrResolverProblemas.meto;

/**
 *
 * @author eleana
 */
public class JFrMostrarResultProblemas extends javax.swing.JFrame {

    /**
     * Creates new form JFrMostrarResultProblemas
     */
    DefaultTableModel modelo;
    ResolverProblema resolt;

    public JFrMostrarResultProblemas() {
        initComponents();
        this.setLocationRelativeTo(null);
        modelo = new DefaultTableModel();
        resolt = new ResolverProblema();

        MetodosExcel metodoExcel = new MetodosExcel();
        ArrayList<Float> numeros = new ArrayList();
        ArrayList<ArrayList> datos = new ArrayList();

        try {
            numeros = metodoExcel.columnaNecesaria(ResoltablaMatriz, "r");
        } catch (IOException ex) {
            System.out.println(ex);
        }
        System.out.println(numeros);
        if (meto == 1) {
            datos = resolt.resolverExponencial(numeros);
            String[] info = new String[datos.get(0).size() + 1];
            String[] titulo = new String[]{"r", "X", "media", "resultado"};
            modelo.setColumnIdentifiers(titulo);
            jTableResultado.setModel(modelo);

            info[2] = datos.get(1).get(0).toString();
            for (int i = 0; i < datos.get(0).size(); i++) {
                info[0] = numeros.get(i).toString();
                info[1] = datos.get(0).get(i).toString();

                if (i < 2) {
                    info[3] = datos.get(2).get(i).toString();
                }

                if (i > 0) {
                    info[2] = "";
                }
                if (i > 1) {
                    info[3] = "";
                }
                modelo.addRow(info);
            }

        }
        if (meto == 2) {
            datos = resolt.poisson(numeros);
            String[] info;
            if(numeros.size() < datos.get(0).size()){
                info = new String[datos.get(0).size()];
            }else{
                info = new String[numeros.size()];
            }
            
            String[] titulo = new String[]{"r", "X", "f(x)", "media", "Li", "Ls", "Rangos"};
            modelo.setColumnIdentifiers(titulo);
            jTableResultado.setModel(modelo);
            if (numeros.size() < datos.get(0).size()) {
                for (int i = 0; i < datos.get(0).size(); i++) {
                    if (numeros.size() > i) {
                        info[0] = numeros.get(i).toString();
                        info[6] = datos.get(5).get(i).toString();
                    } else {
                        info[0] = "";
                        info[6] = "";
                    }

                    info[1] = datos.get(0).get(i).toString();
                    info[2] = datos.get(1).get(i).toString();
                    if (i == 0) {
                        info[3] = datos.get(2).get(i).toString();
                    } else {
                        info[3] = "";
                    }
                    info[4] = datos.get(3).get(i).toString();
                    info[5] = datos.get(4).get(i).toString();

                    modelo.addRow(info);
                }

            } else {
                for (int i = 0; i < numeros.size(); i++) {
                    info[0] = numeros.get(i).toString();
                    info[6] = datos.get(5).get(i).toString();

                    if (datos.get(0).size() > i) {
                        info[1] = datos.get(0).get(i).toString();
                        info[2] = datos.get(1).get(i).toString();
                        if (i == 0) {
                            info[3] = datos.get(2).get(i).toString();
                        } else {
                            info[3] = "";
                        }
                        info[4] = datos.get(3).get(i).toString();
                        info[5] = datos.get(4).get(i).toString();

                    } else {
                        info[1] = "";
                        info[2] = "";
                        info[3] = "";
                        info[4] = "";
                        info[5] = "";
                    }

                    modelo.addRow(info);
                }
            }

        }
        if (meto == 3) {
            datos = resolt.uniforme(numeros);
            String[] info = new String[datos.get(1).size() + 1];
            String[] titulo = new String[]{"r", "a", "b", "X", "resultado"};
            modelo.setColumnIdentifiers(titulo);
            jTableResultado.setModel(modelo);
            info[1] = datos.get(0).get(0).toString();
            info[2] = datos.get(0).get(1).toString();
            for (int i = 0; i < datos.get(1).size(); i++) {
                info[0] = numeros.get(i).toString();
                info[3] = datos.get(1).get(i).toString();
                if (i < 4) {
                    info[4] = datos.get(2).get(i).toString();
                }

                if (i > 0) {
                    info[1] = "";
                    info[2] = "";
                }
                if (i > 3) {
                    info[4] = "";
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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableResultado = new javax.swing.JTable();
        jButtonRegresar = new javax.swing.JButton();
        jButtonExportar = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(153, 255, 255));

        jTableResultado.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableResultado);

        jButtonRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/icons8-gira-a-la-izquierda-48.png"))); // NOI18N
        jButtonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegresarActionPerformed(evt);
            }
        });

        jButtonExportar.setText("Exportar");
        jButtonExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonExportar))
                .addGap(17, 17, 17))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonExportar)
                .addGap(18, 18, 18)
                .addComponent(jButtonRegresar)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegresarActionPerformed
        // TODO add your handling code here:
        JFrResolverProblemas problem = new JFrResolverProblemas();
        problem.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonRegresarActionPerformed

    private void jButtonExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExportarActionPerformed
        // TODO add your handling code here:
        ExportarExcel obj;

        try {
            obj = new ExportarExcel();
            obj.exportarExcel(jTableResultado);
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
            java.util.logging.Logger.getLogger(JFrMostrarResultProblemas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrMostrarResultProblemas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrMostrarResultProblemas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrMostrarResultProblemas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrMostrarResultProblemas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonExportar;
    private javax.swing.JButton jButtonRegresar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableResultado;
    // End of variables declaration//GEN-END:variables
}
