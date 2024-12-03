/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pantallas2;

import Pantallas2.MenuPrincipal;
import dto.TarjetasDTO;
import interfaz.IUsuarioSS;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Oley
 */
public class AgregarTarjeta extends javax.swing.JFrame {

    private MenuPrincipal menuPrincipal;
    private IUsuarioSS iUsuarioSS;
    private String usuarioId;

    /**
     * Creates new form AgregarTarjeta
     */
    public AgregarTarjeta(MenuPrincipal menuPrincipal, IUsuarioSS iUsuarioSS, String usuarioId) {
        this.menuPrincipal = menuPrincipal;
        this.iUsuarioSS = iUsuarioSS;
        this.usuarioId = usuarioId;
        initComponents();
    datePickerBloqueo.getComponentDateTextField().setEditable(false);

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
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        datePickerBloqueo = new com.github.lgooddatepicker.components.DatePicker();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setForeground(new java.awt.Color(153, 153, 153));
        jTextField1.setSelectedTextColor(new java.awt.Color(153, 153, 153));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 213, 50));

        jTextField2.setForeground(new java.awt.Color(153, 153, 153));
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, 210, 40));

        jTextField4.setForeground(new java.awt.Color(153, 153, 153));
        jPanel1.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 382, 210, 40));

        jButton2.setText("Guardar Tarjeta");
        jButton2.setBackground(new java.awt.Color(51, 153, 0));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 460, 200, 70));
        jPanel1.add(datePickerBloqueo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, 210, 40));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/flecha-izquierda.png"))); // NOI18N
        jButton1.setBackground(new java.awt.Color(204, 0, 0));
        jButton1.setForeground(new java.awt.Color(204, 0, 0));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/AñadirTarjetas.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 550));

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
        menuPrincipal.setVisible(true);

// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

     String nombre = jTextField1.getText();
    String numero = jTextField2.getText();
    LocalDate fechaVencimiento = datePickerBloqueo.getDate();
    String ccv = jTextField4.getText();

    if (nombre.isEmpty() || numero.isEmpty() || fechaVencimiento == null || ccv.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
        return;
    }

    if (!nombre.matches("[a-zA-Z]+")) {
        JOptionPane.showMessageDialog(this, "El nombre debe contener solo letras.", "Error en el nombre", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Validar que el número solo contenga dígitos
    if (!numero.matches("[0-9]+")) {
        JOptionPane.showMessageDialog(this, "El número debe contener solo dígitos.", "Error en el número", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Validar que la fecha no sea editable
    if (fechaVencimiento == null) {
        JOptionPane.showMessageDialog(this, "La fecha de vencimiento es obligatoria.", "Error en la fecha", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Validar que el CVV contenga solo 3 dígitos
    if (!ccv.matches("[0-9]{3}")) {
        JOptionPane.showMessageDialog(this, "El CVV debe contener solo 3 dígitos.", "Error en el CVV", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Crear y guardar la tarjeta
    TarjetasDTO tarjetasDTO = new TarjetasDTO();
    tarjetasDTO.setNombre(nombre);
    tarjetasDTO.setNumero(numero);

    Calendar fechaVencimientoCalendar = Calendar.getInstance();
    fechaVencimientoCalendar.set(fechaVencimiento.getYear(), fechaVencimiento.getMonthValue() - 1, fechaVencimiento.getDayOfMonth());
    tarjetasDTO.setFehcaVencimiento(fechaVencimientoCalendar);  // Asegúrate de que el nombre sea correcto

    tarjetasDTO.setCVV(ccv);

    try {
        iUsuarioSS.agregarTarjeta(usuarioId, tarjetasDTO);  // Pasamos el usuarioId aquí
        JOptionPane.showMessageDialog(this, "La tarjeta ha sido guardada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Ocurrió un error al guardar la tarjeta.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    this.setVisible(false);
    menuPrincipal.setVisible(true);



    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.github.lgooddatepicker.components.DatePicker datePickerBloqueo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
