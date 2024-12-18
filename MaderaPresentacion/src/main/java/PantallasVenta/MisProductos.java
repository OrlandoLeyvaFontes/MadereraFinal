/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package PantallasVenta;

import dto.MaderaDTO;
import interfacesDAO.IMaderaDAO;
import interfaz.IEntradaSS;
import interfaz.IMaderaVentaSS;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aleja
 */
public class MisProductos extends javax.swing.JFrame {

    private MenuVendedor menuVendedor;
    private IMaderaVentaSS maderaVentaSS;
    private IMaderaDAO maderaDAO;
    private MaderaDTO maderaDTO1;
    private IEntradaSS iEntradaSS;

    public MisProductos(IMaderaVentaSS maderaVentaSS, IMaderaDAO maderaDAO, MaderaDTO maderaDTO1, IEntradaSS iEntradaSS) {
        this.maderaVentaSS = maderaVentaSS;
        this.maderaDAO = maderaDAO;
        this.maderaDTO1 = maderaDTO1;
        this.iEntradaSS = iEntradaSS;
        initComponents();
        CargarMetodosIniciales();

    }

    private void CargarMetodosIniciales() {
        cargarMaderasEnTablas();
        getSelectedIdTableMaderas();
    }

    private void cargarMaderasEnTablas() {
        List<MaderaDTO> maderaLista = this.maderaVentaSS.obtenerMaderas();
        if (maderaLista != null && !maderaLista.isEmpty()) {
            llenarTablaMaderas(maderaLista);
        } else {
            JOptionPane.showMessageDialog(this, "No hay datos disponibles para mostrar.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private String getSelectedIdTableMaderas() {
        int selectedIndex = this.tblMaderas.getSelectedRow();
        if (selectedIndex != -1) {
            DefaultTableModel model = (DefaultTableModel) this.tblMaderas.getModel();
            int idIndexRow = 0;
            String idMadera = (String) model.getValueAt(selectedIndex, idIndexRow);
            return idMadera;
        } else {
            return null;
        }
    }

    private void llenarTablaMaderas(List<MaderaDTO> maderaLista) {
        DefaultTableModel model = new DefaultTableModel(
                new String[]{"Id", "Nombre", "Precio", "Descripción", "Cantidad"}, 0
        ) {
            boolean[] canEdit = new boolean[]{false, false, false, false, false};  // Hace que las celdas no sean editables.

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };

        for (MaderaDTO madera : maderaLista) {
            model.addRow(new Object[]{
                madera.getId(),
                madera.getNombre(),
                madera.getPrecioUnitario(),
                madera.getDescripcion(),
                madera.getCantidad(),});
        }

        tblMaderas.setModel(model);
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
        lblIniciarSesion = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        btnMenu = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMaderas = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        lblIniciarSesion.setBackground(new java.awt.Color(255, 255, 255));
        lblIniciarSesion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblIniciarSesion.setForeground(new java.awt.Color(255, 255, 255));
        lblIniciarSesion.setText("Mis Productos");

        lblTitulo.setBackground(new java.awt.Color(255, 255, 255));
        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Maderera en Linea");

        btnMenu.setText("Menu");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblIniciarSesion)
                .addGap(237, 237, 237))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnMenu)
                .addGap(108, 108, 108)
                .addComponent(lblTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo)
                    .addComponent(btnMenu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblIniciarSesion)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        tblMaderas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Nombre", "Precio Unitario", "Cantidad", "Descripción"
            }
        ));
        jScrollPane1.setViewportView(tblMaderas);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(btnAgregar)
                .addGap(96, 96, 96)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEditar)
                .addGap(81, 81, 81))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnEditar)
                    .addComponent(btnAgregar))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        this.setVisible(false);
        dispose();
        AgregarMadera agregarMadera = new AgregarMadera(maderaVentaSS, iEntradaSS);
        agregarMadera.setVisible(true);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (this.getSelectedIdTableMaderas() == null) {
            JOptionPane.showMessageDialog(this, "Por favor selecciona una madera", "Información", JOptionPane.ERROR_MESSAGE);
            return;
        }
        MaderaDTO maderaDTO = maderaVentaSS.buscarMaderaPorId(this.getSelectedIdTableMaderas());
        
        this.setVisible(false);
        dispose();
        EditarMadera editarMadera = new EditarMadera(maderaDTO, maderaVentaSS, iEntradaSS);
        editarMadera.setVisible(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (this.getSelectedIdTableMaderas() == null) {
            JOptionPane.showMessageDialog(this, "Por favor selecciona una madera", "Información", JOptionPane.ERROR_MESSAGE);
            return;
        }
        maderaVentaSS.eliminarMadera(this.getSelectedIdTableMaderas());
        cargarMaderasEnTablas();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        this.setVisible(false);
        dispose();
        MenuVendedor menuVendedor = new MenuVendedor(maderaVentaSS, iEntradaSS);
        menuVendedor.setVisible(true);
    }//GEN-LAST:event_btnMenuActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnMenu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIniciarSesion;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblMaderas;
    // End of variables declaration//GEN-END:variables
}
