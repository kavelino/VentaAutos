/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Entidades.Oferta;
import javax.swing.JOptionPane;

/**
 *
 * @author Katiuska Marin Suarez
 * @author Darwin Guaman Pacalla
 * @author Kleber Avelino Mosquera
 */
public class FrmVendedor extends javax.swing.JFrame {
    
    /**
     * Creates new form FrmVendedor
     */
    public FrmVendedor() {
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

        btnNuevoVehiculo = new javax.swing.JButton();
        btnVerOfertas = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btnNuevoVehiculo.setText("Nuevo Vehículo");
        btnNuevoVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoVehiculoActionPerformed(evt);
            }
        });

        btnVerOfertas.setText("   Ver Ofertas  ");
        btnVerOfertas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerOfertasActionPerformed(evt);
            }
        });

        btnRegresar.setText("     Regresar    ");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Menú Vendedor");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnNuevoVehiculo)
                    .addComponent(btnVerOfertas)
                    .addComponent(btnRegresar)
                    .addComponent(jLabel1))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(19, 19, 19)
                .addComponent(btnNuevoVehiculo)
                .addGap(18, 18, 18)
                .addComponent(btnVerOfertas)
                .addGap(18, 18, 18)
                .addComponent(btnRegresar)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        FrmLogin frm = new FrmLogin();
        frm.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        FrmLogin frm = new FrmLogin();
        frm.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void btnNuevoVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoVehiculoActionPerformed
        FrmVehiculo frm = new FrmVehiculo(true,true); //(es nuevo, es vendedor)
        frm.setVisible(true);
    }//GEN-LAST:event_btnNuevoVehiculoActionPerformed
    
    private void btnVerOfertasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerOfertasActionPerformed
        if (Oferta.LOfertas.size() > 0) {
            FrmVehiculo frm = new FrmVehiculo(false,true); //(esnuevo,esvendedor)
            frm.setVisible(true);
        }else
            JOptionPane.showMessageDialog(this,
                "No hay ofertas",
                "Ver Oferta",
                JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnVerOfertasActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmVendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNuevoVehiculo;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnVerOfertas;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
