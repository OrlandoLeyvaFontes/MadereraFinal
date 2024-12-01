/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pantallas2;

import Pantallas2.MenuPrincipal;
import interfaz.ICarritoSS;
import interfaz.ICompraSS;
import interfaz.IUsuarioSS;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Oley
 */
public class TarjetasDisponibles2 extends javax.swing.JFrame {

    private String usuarioId;
    private MenuPrincipal menuPrincipal;
    private IUsuarioSS iUsuarioSS;
    private ICompraSS iCompraSS;
        private ICarritoSS iCarritoSS;


    /**
     * Creates new form TarjetasDisponibles2
     */
    public TarjetasDisponibles2(String usuarioId, MenuPrincipal menuPrincipal, IUsuarioSS iUsuarioSS, ICompraSS iCompraSS,ICarritoSS iCarritoSS
    ) {

        this.usuarioId = usuarioId;
        this.menuPrincipal = menuPrincipal;
        this.iUsuarioSS = iUsuarioSS;
        this.iCompraSS = iCompraSS;
        this.iCarritoSS=iCarritoSS;
        initComponents();
        cargarTarjetasEnTablas();

    }

    private void cargarTarjetasEnTablas() {
        List<String> numerosTarjetas = this.iUsuarioSS.obtenerNumerosTarjetasPorUsuario(usuarioId);

        if (numerosTarjetas != null && !numerosTarjetas.isEmpty()) {
            llenarTablaTarjetas(numerosTarjetas);
        } else {
            JOptionPane.showMessageDialog(this, "No hay tarjetas disponibles para mostrar.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void llenarTablaTarjetas(List<String> numerosTarjetas) {
        DefaultTableModel model = new DefaultTableModel(
                new String[]{"Número de Tarjeta"}, 0
        ) {
            boolean[] canEdit = new boolean[]{false};

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };

        for (String numeroTarjeta : numerosTarjetas) {
            model.addRow(new Object[]{numeroTarjeta});
        }

        jTable1.setModel(model);
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
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setBackground(new java.awt.Color(255, 255, 102));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Numero"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 420, 260));

        jButton1.setBackground(new java.awt.Color(51, 153, 0));
        jButton1.setText("Selecione");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 540, 210, 80));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/TarjetasDisponibles.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 650));

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
        ConfirmarTarjeta2 confirmarTarjeta2 = new ConfirmarTarjeta2(iUsuarioSS, iCompraSS, usuarioId, menuPrincipal,iCarritoSS);
        confirmarTarjeta2.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
