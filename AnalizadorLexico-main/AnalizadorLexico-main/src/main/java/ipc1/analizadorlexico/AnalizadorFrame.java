
package ipc1.analizadorlexico;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;


public class AnalizadorFrame extends javax.swing.JFrame {

     Manejador analizador;
     
     public AnalizadorFrame() {
          initComponents();
          setLocationRelativeTo(null);
          
     }
  
     
     
     
     @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        limpiarBoton = new javax.swing.JButton();
        analizarBoton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoResultado = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        textoIntro = new javax.swing.JTextArea();
        btnReporte = new javax.swing.JButton();
        btnReporteOpti = new javax.swing.JButton();
        btnReporteError = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        limpiarBoton.setText("Limpiar");
        limpiarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarBotonActionPerformed(evt);
            }
        });

        analizarBoton.setText("Analizar");
        analizarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analizarBotonActionPerformed(evt);
            }
        });

        textoResultado.setEditable(false);
        textoResultado.setColumns(20);
        textoResultado.setLineWrap(true);
        textoResultado.setRows(5);
        jScrollPane1.setViewportView(textoResultado);

        textoIntro.setColumns(20);
        textoIntro.setLineWrap(true);
        textoIntro.setRows(5);
        jScrollPane2.setViewportView(textoIntro);

        btnReporte.setText("ReporteToken");
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        btnReporteOpti.setText("ReporteOpti");
        btnReporteOpti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteOptiActionPerformed(evt);
            }
        });

        btnReporteError.setText("ReporteError");
        btnReporteError.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteErrorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(analizarBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(limpiarBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnReporteOpti, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReporteError, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(analizarBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(limpiarBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReporteOpti, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(btnReporteError, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     private void analizarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analizarBotonActionPerformed
        String texto = textoIntro.getText();
        analizador = new Manejador(texto);
        
        String contenidoFinal = analizador.getHtmlOrdenado();
        textoResultado.setText(contenidoFinal);

        String rutaCarpeta = "C:\\Users\\LL829\\Desktop\\PRUEBAHTML";  
        analizador.generarArchivoHtml(rutaCarpeta, "resultado1.html"); 
    
     }//GEN-LAST:event_analizarBotonActionPerformed

    private void limpiarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarBotonActionPerformed
        
    textoIntro.setText("");
    textoResultado.setText("");

    }//GEN-LAST:event_limpiarBotonActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        String rutaCarpeta = "C:\\Users\\LL829\\Desktop\\PRUEBAHTML";  
    String nombreArchivo = "reporte_tokens.html";

    
    String textoEntrada = textoIntro.getText();  
    Manejador manejador = new Manejador(textoEntrada);

    String reporteHtml = manejador.obtenerReporteTokens();  

    try (FileWriter writer = new FileWriter(rutaCarpeta + File.separator + nombreArchivo)) {
        writer.write("<html><head><title>Reporte de Tokens</title></head><body>");
        writer.write("<h1>Reporte de Tokens</h1>");
        writer.write(reporteHtml);
        writer.write("</body></html>");
        System.out.println("Reporte generado exitosamente en: " + rutaCarpeta + File.separator + nombreArchivo);
    } catch (IOException e) {
        e.printStackTrace();
    }
    }//GEN-LAST:event_btnReporteActionPerformed

    private void btnReporteOptiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteOptiActionPerformed
     String textoEntrada = textoIntro.getText();
        Manejador manejador = new Manejador(textoEntrada);

        String rutaCarpeta = "C:\\Users\\LL829\\Desktop\\PRUEBAHTML";
        String nombreArchivo = "reporte_optimización.html";

        manejador.generarReporteOptimizacion(rutaCarpeta, nombreArchivo);
        System.out.println("Reporte de optimización generado correctamente.");
    }//GEN-LAST:event_btnReporteOptiActionPerformed

   

    
    private void btnReporteErrorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteErrorActionPerformed
  
    }//GEN-LAST:event_btnReporteErrorActionPerformed

    
    public static void main(String args[]) {
 java.awt.EventQueue.invokeLater(() -> new AnalizadorFrame().setVisible(true));
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton analizarBoton;
    private javax.swing.JButton btnReporte;
    private javax.swing.JButton btnReporteError;
    private javax.swing.JButton btnReporteOpti;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton limpiarBoton;
    private javax.swing.JTextArea textoIntro;
    private javax.swing.JTextArea textoResultado;
    // End of variables declaration//GEN-END:variables
}
