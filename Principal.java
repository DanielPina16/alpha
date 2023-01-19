
import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dany5
 */
public class Principal extends javax.swing.JFrame {

    int XDmin,XDmax,XMmax,XMmin;
    int YDmin,YDmax,YMmax,YMmin;
    
    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
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
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 400));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 598, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );

        jButton1.setText("Graficar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        float aux[][];
        float puntos[][]={{-14,0},
                          {-5.8f,0},
                          {-5,0.5f},
                          {-5.8f,1.3f},
                          {-11.8f,1.3f},
                          {-14,2.5f}};
        
        coordenadasMundiales(-14, -0, 20, 10);
        coordenadasDispositivo(0, 0, 400, 400);
        
        for(int i=0; i<50;i++){
        aux=transformaCoordenadas(puntos);
        dibujaLineas(aux);
            try {
                Thread.sleep(50);
                } catch (InterruptedException ex) {
                  Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            //borraLineas(aux);
            //traslada(puntos,1,0.1f);
            aux = transformaCoordenadas(puntos);
            dibujaLineas(aux);
        }
    }//GEN-LAST:event_jButton1MouseClicked

    
    
    public void coordenadasMundiales(int xmin, int ymin, int xmax, int ymax){
        XMmin = xmin;
        YMmin = ymin;
        XMmax = xmax;
        YMmax = ymax;
    }
    
    public void coordenadasDispositivo(int xmin, int ymin, int xmax, int ymax){
        XDmax = xmax;
        YDmax = ymax;
        XDmin = xmin;
        YDmin = ymin;
    }
    
    public float [][] transformaCoordenadas(float p[][])
    {
        float x[][]= new float[p.length][p[0].length];
        for(int i=0;i<p.length;i++)
        {
            x[i][0]=XDmin+((XDmax-XDmin)/(XMmax-XMmin))*(p[i][0]-XMmin);
            
            x[i][1]=YDmin+((YDmax-YDmin)/(YMmax-YMmin))*(YMmax-p[i][1]);
        }
        return x;
    }
    
    public void dibujaLineas(float p[][])
    {
        Graphics g=jPanel1.getGraphics();
        g.setColor(new Color(255,0,0));
        int i;
        for(i=0;i<p.length-1;i++)
            g.drawLine((int)p[i][0], (int)p[i][1], (int)p[i+1][0], (int)p[i+1][1]);
            
            g.drawLine((int)p[i][0], (int)p[i][1], (int)p[0][0], (int)p[0][1]);
        
    }
    
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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
