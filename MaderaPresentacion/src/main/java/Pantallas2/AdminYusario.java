/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pantallas2;

import PantallasVenta.IniciarSesionVendedor;
import interfaz.ICarritoSS;
import interfaz.ICompraSS;
import interfaz.IEntradaSS;
import interfaz.IMaderaSS;
import interfaz.IMaderaVentaSS;
import interfaz.ISalidaSS;
import interfaz.IUsuarioSS;
import interfaz.IUsuarioVentaSS;

/**
 *
 * @author Oley
 */
public class AdminYusario extends javax.swing.JFrame {

    private IUsuarioSS iUsuarioSS;
    private IMaderaSS iMaderaSS;
    private ICarritoSS iCarritoSS;
    private ICompraSS iCompraSS;
    private IUsuarioVentaSS iUsuarioVentaSS;
    private IMaderaVentaSS maderaVentaSS;
    private IEntradaSS iEntradaSS;
private ISalidaSS  iSalidaSS;
    /**
     * Creates new form AdminYusario
     */
    public AdminYusario(IUsuarioSS iUsuarioSS, IMaderaSS iMaderaSS, ICarritoSS iCarritoSS, ICompraSS iCompraSS, IUsuarioVentaSS iUsuarioVentaSS, IMaderaVentaSS maderaVentaSS, IEntradaSS iEntradaSS,ISalidaSS  iSalidaSS) {
        this.iUsuarioSS = iUsuarioSS;
        this.iMaderaSS = iMaderaSS;
        this.iCarritoSS = iCarritoSS;
        this.iCompraSS = iCompraSS;
        this.iUsuarioVentaSS = iUsuarioVentaSS;
        this.maderaVentaSS = maderaVentaSS;
        this.iEntradaSS = iEntradaSS;
        this.iSalidaSS=iSalidaSS;
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
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(51, 153, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/hombre-de-negocios.png"))); // NOI18N
        jButton1.setText("Administrador");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 430, -1, -1));

        jButton2.setBackground(new java.awt.Color(0, 153, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/anadir-amigo.png"))); // NOI18N
        jButton2.setText("Usuario");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Selecion.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 730));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        this.setVisible(false);
        IniciarSesionVendedor iniciarSesionVendedor = new IniciarSesionVendedor(iUsuarioVentaSS, maderaVentaSS, iEntradaSS,this);
        iniciarSesionVendedor.setVisible(true);

// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        this.setVisible(false);
        IniciarSesion iniciarSesion = new IniciarSesion(iUsuarioSS, iMaderaSS, iCarritoSS, iCompraSS,iSalidaSS);
        iniciarSesion.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
