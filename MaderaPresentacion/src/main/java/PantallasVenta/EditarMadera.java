/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package PantallasVenta;

import dao.MaderaDAO;
import dto.EntradasDTO;
import dto.MaderaDTO;
import interfaz.IEntradaSS;
import interfaz.IMaderaVentaSS;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author aleja
 */
public class EditarMadera extends javax.swing.JFrame {

    MaderaDTO maderaDTO;
    MaderaDAO maderaDAO;
    MisProductos misProductos;
    private IMaderaVentaSS maderaVentaSS;
    private IEntradaSS iEntradaSS;

    /**
     * Creates new form EditarMadera
     */
    public EditarMadera(MaderaDTO maderaDTO, IMaderaVentaSS maderaVentaSS, IEntradaSS iEntradaSS) {
        initComponents();
        this.maderaDTO = maderaDTO;
        this.maderaVentaSS = maderaVentaSS;
        this.iEntradaSS = iEntradaSS;
        fillFields();
    }

    private void fillFields() {
        txtNombre.setText(maderaDTO.getNombre());
        txtPrecio.setText(String.valueOf(maderaDTO.getPrecioUnitario()));
        txtCantidad.setText(String.valueOf(maderaDTO.getCantidad()));
        txtDescripcion.setText(maderaDTO.getDescripcion());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lblIniciarSesion = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        lblPrecio = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        lblDescripcion = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        lblIniciarSesion.setBackground(new java.awt.Color(255, 255, 255));
        lblIniciarSesion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblIniciarSesion.setForeground(new java.awt.Color(255, 255, 255));
        lblIniciarSesion.setText("Editar Producto");

        lblTitulo.setBackground(new java.awt.Color(255, 255, 255));
        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Maderera en Linea");

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegresar)
                .addGap(54, 54, 54)
                .addComponent(lblTitulo)
                .addContainerGap(130, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblIniciarSesion)
                .addGap(170, 170, 170))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo)
                    .addComponent(btnRegresar))
                .addGap(18, 18, 18)
                .addComponent(lblIniciarSesion)
                .addGap(33, 33, 33))
        );

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setPreferredSize(new java.awt.Dimension(462, 357));

        lblNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("Nombre:");

        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(0, 0, 0));

        txtPrecio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPrecio.setForeground(new java.awt.Color(0, 0, 0));

        lblPrecio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPrecio.setForeground(new java.awt.Color(255, 255, 255));
        lblPrecio.setText("Precio:");

        lblCantidad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCantidad.setForeground(new java.awt.Color(255, 255, 255));
        lblCantidad.setText("Cantidad:");

        txtCantidad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCantidad.setForeground(new java.awt.Color(0, 0, 0));

        txtDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDescripcion.setForeground(new java.awt.Color(0, 0, 0));

        lblDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDescripcion.setForeground(new java.awt.Color(255, 255, 255));
        lblDescripcion.setText("Descripción:");

        btnEditar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(0, 0, 0));
        btnEditar.setText("Continuar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEditar)
                .addGap(168, 168, 168))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(80, 80, 80)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblPrecio, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblCantidad, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblDescripcion, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGap(98, 98, 98)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                        .addComponent(txtPrecio)
                        .addComponent(txtCantidad)
                        .addComponent(txtDescripcion))
                    .addContainerGap(75, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(202, Short.MAX_VALUE)
                .addComponent(btnEditar)
                .addGap(20, 20, 20))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNombre)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblPrecio)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCantidad)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDescripcion)
                        .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(67, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // Obtener la cantidad actual antes de la edición
        int entrada = this.maderaDTO.getCantidad();

        // Capturar los datos del formulario
        String nombre = txtNombre.getText().trim();
        String precio = txtPrecio.getText().trim();
        String descripcion = txtDescripcion.getText().trim();
        String cantidad = txtCantidad.getText().trim();

        // Validar campos vacíos
        if (nombre.isEmpty() || descripcion.isEmpty() || precio.isEmpty() || cantidad.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Validar formato de nombre
        if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
            JOptionPane.showMessageDialog(this, "El nombre solo puede contener letras y espacios.", "Formato inválido", JOptionPane.WARNING_MESSAGE);
            return;
        }

        double precioUnitario;
        int cantidadInt;

        // Validar y convertir precio
        try {
            precioUnitario = Double.parseDouble(precio);
            if (precioUnitario <= 0) {
                JOptionPane.showMessageDialog(this, "El precio debe ser mayor a 0.", "Valor inválido", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El precio debe ser un número válido.", "Formato incorrecto", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validar y convertir cantidad
        try {
            cantidadInt = Integer.parseInt(cantidad);
            if (cantidadInt <= 0) {
                JOptionPane.showMessageDialog(this, "La cantidad debe ser mayor a 0.", "Valor inválido", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La cantidad debe ser un número entero válido.", "Formato incorrecto", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Crear un nuevo objeto MaderaDTO con los valores editados
        MaderaDTO maderaDTO = new MaderaDTO();
        maderaDTO.setId(this.maderaDTO.getId());
        maderaDTO.setNombre(nombre);
        maderaDTO.setPrecioUnitario(precioUnitario);
        maderaDTO.setCantidad(cantidadInt);
        maderaDTO.setDescripcion(descripcion);

        // Verificar si la cantidad ha cambiado
        if (entrada != cantidadInt) {
            int diferencia = cantidadInt - entrada;

            try {
                if (diferencia > 0) {
                    // Es una entrada
                    JOptionPane.showMessageDialog(this, "Se ha registrado una ENTRADA de " + diferencia + " unidades.", "Entrada", JOptionPane.INFORMATION_MESSAGE);

                    EntradasDTO entradaDTO = new EntradasDTO();
                    entradaDTO.setTipoEntrada("Devolución");
                    entradaDTO.setTipoMadera(nombre);
                    entradaDTO.setCantidad(diferencia);
                    entradaDTO.setFechaEntrada(LocalDate.now());

                    // Registrar la entrada
                    iEntradaSS.registrarEntrada(entradaDTO);
                } else {
                    // Es una salida
                    JOptionPane.showMessageDialog(this, "Se ha registrado una SALIDA de " + Math.abs(diferencia) + " unidades.", "Salida", JOptionPane.INFORMATION_MESSAGE);

                    EntradasDTO salidaDTO = new EntradasDTO();
                    salidaDTO.setTipoEntrada("Salida");
                    salidaDTO.setTipoMadera(nombre);
                    salidaDTO.setCantidad(Math.abs(diferencia));
                    salidaDTO.setFechaEntrada(LocalDate.now());

                    // Registrar la salida
                    iEntradaSS.registrarEntrada(salidaDTO);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Ocurrió un error al registrar la entrada/salida: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        // Actualizar la madera en la base de datos
        try {
            maderaVentaSS.editarMadera(maderaDTO);
            JOptionPane.showMessageDialog(this, "La madera ha sido editada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al guardar la madera: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Volver a la vista de productos
        dispose();
        MisProductos misProductos = new MisProductos(maderaVentaSS, maderaDAO, maderaDTO, iEntradaSS);
        misProductos.setVisible(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.setVisible(false);
        dispose();
        MisProductos misProductos = new MisProductos(maderaVentaSS, maderaDAO, maderaDTO, iEntradaSS);
        misProductos.setVisible(true);    }//GEN-LAST:event_btnRegresarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblIniciarSesion;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
