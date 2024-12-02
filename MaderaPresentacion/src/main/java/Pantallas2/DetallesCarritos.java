/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pantallas2;

import Pantallas2.ProductosVenta;
import Pantallas2.MenuPrincipal;
import dto.CarritoDTO;
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
public class DetallesCarritos extends javax.swing.JFrame {

    private ProductosVenta productosVenta;
    private String usuarioId;
    private MenuPrincipal menuPrincipal;
    private IMaderaSS iMaderaSS;
    private ICarritoSS iCarritoSS;
    private ICompraSS iCompraSS;
    private IUsuarioSS iUsuarioSS;
    private String idMadera;

    /**
     * Creates new form DetallesCarritos
     */
    public DetallesCarritos(ProductosVenta productosVenta, String usuarioId, MenuPrincipal menuPrincipal, IMaderaSS iMaderaSS,
             ICarritoSS iCarritoSS, ICompraSS iCompraSS, IUsuarioSS iUsuarioSS,String idMadera
    ) {
        this.productosVenta = productosVenta;
        this.usuarioId = usuarioId;
        this.menuPrincipal = menuPrincipal;
        this.iMaderaSS = iMaderaSS;
        this.iCarritoSS = iCarritoSS;
        this.iCompraSS = iCompraSS;
        this.iUsuarioSS = iUsuarioSS;
        this.idMadera=idMadera;
        initComponents();
        CargarMetodosIniciales();
    }

    private void CargarMetodosIniciales() {
        CargarCarritoEnTablas();
    }

    private void CargarCarritoEnTablas() {
        List<CarritoDTO> carrito = iCarritoSS.obtenerCarrito(usuarioId);

        if (carrito == null || carrito.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El carrito está vacío.");
            return;
        }

        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Producto");
        modeloTabla.addColumn("Cantidad");

        double total = 0;
        for (CarritoDTO producto : carrito) {
            String nombreMadera = producto.getMaderasDTO().get(0).getNombre();
            int cantidad = producto.getCantidades().get(0);
            double subtotal = cantidad * producto.getTotal();
            total += subtotal;

            Object[] fila = new Object[]{
                nombreMadera, // Mostrar el nombre de la madera
                cantidad,
                subtotal // Si quieres agregar el subtotal por producto
            };
            modeloTabla.addRow(fila);
        }
        

        // Asigna el modelo a la tabla
        jTable1.setModel(modeloTabla);

        // Muestra el total en la etiqueta correspondiente
//        jLabel4.setText(String.format("%.2f", total));
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
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

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
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 840, 246));

        jButton1.setBackground(new java.awt.Color(51, 153, 0));
        jButton1.setText("Comprar ahora");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 450, 260, 70));

        jButton2.setBackground(new java.awt.Color(204, 0, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/flecha-izquierda.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 140, 90));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/CarritoCompras.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 560));

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
        MenuDeTarjetas2 menuDeTarjetas2 = new MenuDeTarjetas2(usuarioId, menuPrincipal, iMaderaSS, iCarritoSS, iCompraSS, iUsuarioSS);
        menuDeTarjetas2.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
        menuPrincipal.setVisible(true);

    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
