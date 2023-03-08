/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import logica.MetodosExcel;
import logica.PruebasEstadisticas;
import static vista.JFrPrincipal.tablaMatriz;

/**
 *
 * @author Eleana Hurtado
 */
public class JFrPruebasEstadisticas extends javax.swing.JFrame {

    /**
     * Creates new form JFrPruebasEstadisticas
     */
    DefaultTableModel modelo;
    MetodosExcel metodoExcel = new MetodosExcel();
    PruebasEstadisticas prueba = new PruebasEstadisticas();

    public JFrPruebasEstadisticas() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        modelo = new DefaultTableModel();
        
        String[] titulo = new String[tablaMatriz.length];
        for(int i=0; i<tablaMatriz.length; i++){
            titulo[i]=tablaMatriz[i][0];
            System.out.println(tablaMatriz[i][0]);
        }
        System.out.println(tablaMatriz.length);
        modelo.setColumnIdentifiers(titulo);
        jTableImpresion.setModel(modelo);
        
        String[] info = new String[tablaMatriz[0].length];
        for(int i=1; i<tablaMatriz[0].length; i++)
        {
            for(int j=0; j<tablaMatriz.length; j++){
                info[j]=tablaMatriz[j][i];
            }
            modelo.addRow(info);
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
        jTableImpresion = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButtonPromedios = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonFrecuencias = new javax.swing.JButton();
        jButtonKolmogorov = new javax.swing.JButton();
        jButtonSeries = new javax.swing.JButton();
        jButtonPoker = new javax.swing.JButton();
        jButtonRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 250, 250));

        jTableImpresion.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableImpresion);

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));

        jButtonPromedios.setBackground(new java.awt.Color(204, 255, 255));
        jButtonPromedios.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonPromedios.setText("Promedios");
        jButtonPromedios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPromediosActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Pruebas");

        jButtonFrecuencias.setBackground(new java.awt.Color(204, 255, 255));
        jButtonFrecuencias.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonFrecuencias.setText("Frecuencias");
        jButtonFrecuencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFrecuenciasActionPerformed(evt);
            }
        });

        jButtonKolmogorov.setBackground(new java.awt.Color(204, 255, 255));
        jButtonKolmogorov.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonKolmogorov.setText("Kolmogorov-Smirnov");
        jButtonKolmogorov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonKolmogorovActionPerformed(evt);
            }
        });

        jButtonSeries.setBackground(new java.awt.Color(204, 255, 255));
        jButtonSeries.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonSeries.setText("Series");

        jButtonPoker.setBackground(new java.awt.Color(204, 255, 255));
        jButtonPoker.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonPoker.setText("Poker");

        jButtonRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/icons8-gira-a-la-izquierda-48.png"))); // NOI18N
        jButtonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonPromedios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonFrecuencias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonKolmogorov, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonSeries, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonPoker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jButtonRegresar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(9, 9, 9)
                .addComponent(jButtonPromedios)
                .addGap(18, 18, 18)
                .addComponent(jButtonFrecuencias)
                .addGap(16, 16, 16)
                .addComponent(jButtonKolmogorov)
                .addGap(18, 18, 18)
                .addComponent(jButtonSeries)
                .addGap(18, 18, 18)
                .addComponent(jButtonPoker)
                .addGap(18, 18, 18)
                .addComponent(jButtonRegresar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegresarActionPerformed
        // TODO add your handling code here:
        JFrPrincipal principal = new JFrPrincipal();
        principal.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_jButtonRegresarActionPerformed

    private void jButtonPromediosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPromediosActionPerformed
        // TODO add your handling code here:
        ArrayList<Float> numeros = new ArrayList();
        try {
            numeros = metodoExcel.columnaNecesaria(tablaMatriz, "r");
        } catch (IOException ex) {
            Logger.getLogger(JFrPruebasEstadisticas.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(numeros);
        prueba.pruebaPromedios(numeros);
        
    }//GEN-LAST:event_jButtonPromediosActionPerformed

    private void jButtonFrecuenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFrecuenciasActionPerformed
        // TODO add your handling code here:
        ArrayList<Float> numeros = new ArrayList();
        try {
            numeros = metodoExcel.columnaNecesaria(tablaMatriz, "r");
        } catch (IOException ex) {
            Logger.getLogger(JFrPruebasEstadisticas.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(numeros);
        prueba.pruebaFrecuencias(numeros);
    }//GEN-LAST:event_jButtonFrecuenciasActionPerformed

    private void jButtonKolmogorovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonKolmogorovActionPerformed
        // TODO add your handling code here:

        JFrResultadoTabla result = new JFrResultadoTabla();
        result.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_jButtonKolmogorovActionPerformed

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
            java.util.logging.Logger.getLogger(JFrPruebasEstadisticas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrPruebasEstadisticas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrPruebasEstadisticas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrPruebasEstadisticas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrPruebasEstadisticas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonFrecuencias;
    private javax.swing.JButton jButtonKolmogorov;
    private javax.swing.JButton jButtonPoker;
    private javax.swing.JButton jButtonPromedios;
    private javax.swing.JButton jButtonRegresar;
    private javax.swing.JButton jButtonSeries;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableImpresion;
    // End of variables declaration//GEN-END:variables
}
