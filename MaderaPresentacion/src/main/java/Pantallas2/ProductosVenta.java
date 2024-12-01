/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pantallas2;

import Pantallas2.MenuPrincipal;
import dto.MaderaDTO;
import interfaz.ICarritoSS;
import interfaz.ICompraSS;

import interfaz.IMaderaSS;
import interfaz.IUsuarioSS;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Oley
 */
public class ProductosVenta extends javax.swing.JFrame {

    private MenuPrincipal menuPrincipal;
     private String usuarioId;
private  IMaderaSS  iMaderaSS;
private  ICarritoSS iCarritoSS;
private ICompraSS iCompraSS;
     private IUsuarioSS iUsuarioSS;

    /**
     * Creates new form ProductosVenta
     */
    public ProductosVenta(MenuPrincipal menuPrincipal,String usuarioId, IMaderaSS  iMaderaSS, ICarritoSS iCarritoSS,ICompraSS iCompraSS,IUsuarioSS iUsuarioSS
    ) {
        this.menuPrincipal = menuPrincipal;
        this.usuarioId=usuarioId;
        this.iMaderaSS=iMaderaSS;
        this.iCarritoSS=iCarritoSS;
        this.iCompraSS=iCompraSS;
        this.iUsuarioSS=iUsuarioSS;
        initComponents();
        CargarMetodosIniciales();
    }

    private void CargarMetodosIniciales() {
        cargarMaderasEnTablas();
    }

    private void cargarMaderasEnTablas() {
        List<MaderaDTO> maderaLista = this.iMaderaSS.obtenerMaderas();
        if (maderaLista != null && !maderaLista.isEmpty()) {
            llenarTablaMaderas(maderaLista);
        } else {
            JOptionPane.showMessageDialog(this, "No hay datos disponibles para mostrar.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }

  private void llenarTablaMaderas(List<MaderaDTO> maderaLista) {
    DefaultTableModel model = new DefaultTableModel(
        new String[]{"Nombre", "Precio", "Descripción", "Cantidad", "id"}, 0
    ) {
        boolean[] canEdit = new boolean[]{false, false, false, false, false};  // Hace que las celdas no sean editables.

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit[columnIndex];
        }
    };

    for (MaderaDTO madera : maderaLista) {
        model.addRow(new Object[]{
            madera.getNombre(), 
            madera.getPrecioUnitario(), 
            madera.getDescripcion(), 
            madera.getCantidad(), 
            madera.getId()
        });
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
        jPanel5 = new javax.swing.JPanel();
        btnDetallesProducto = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setBackground(new java.awt.Color(255, 204, 102));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Precio", "Disponible", "Cantidad"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 430, 240));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 60, -1, -1));

        btnDetallesProducto.setBackground(new java.awt.Color(0, 102, 255));
        btnDetallesProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnDetallesProducto.setText("Ver Mas");
        btnDetallesProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetallesProductoActionPerformed(evt);
            }
        });
        jPanel1.add(btnDetallesProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 340, 140, 60));

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/flecha-izquierda.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, 60));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ProductosAlaVenta.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, -10, -1, 490));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDetallesProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetallesProductoActionPerformed
       int row = jTable1.getSelectedRow();
    
    if (row >= 0) {
        String nombre = (String) jTable1.getValueAt(row, 0);
        Double precio = (Double) jTable1.getValueAt(row, 1);
        String descripcion = (String) jTable1.getValueAt(row, 2);
        int cantidad = (int) jTable1.getValueAt(row, 3);
        String idMadera = (String) jTable1.getValueAt(row, 4);

        if (cantidad == 0) {
            JOptionPane.showMessageDialog(this, "La madera no está disponible", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            this.setVisible(false);
            DetallesProducto detallesProducto = new DetallesProducto(
                this, nombre, precio, descripcion, cantidad, usuarioId, 
                menuPrincipal, idMadera, iMaderaSS, iCarritoSS, iCompraSS, iUsuarioSS
            );
            detallesProducto.setVisible(true);
        }
    } else {
        JOptionPane.showMessageDialog(this,
            "Por favor, seleccione un producto de la tabla.",
            "Error",
            JOptionPane.ERROR_MESSAGE);
    }
//         TODO add your handling code here:
    }//GEN-LAST:event_btnDetallesProductoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        menuPrincipal.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetallesProducto;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
