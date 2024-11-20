/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.Calendar;



/**
 *
 * @author Oley
 */
public class CompraDTO {
      private String id;
    private Calendar fechaCompra;
    private double precioTotal;
    private int cantidad;
    private MaderaDTO madera;
    private UsuarioDTO usuario;

    public CompraDTO() {
    }

    public CompraDTO(Calendar fechaCompra, double precioTotal, int cantidad, MaderaDTO madera, UsuarioDTO usuario) {
        this.fechaCompra = fechaCompra;
        this.precioTotal = precioTotal;
        this.cantidad = cantidad;
        this.madera = madera;
        this.usuario = usuario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Calendar getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Calendar fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public MaderaDTO getMadera() {
        return madera;
    }

    public void setMadera(MaderaDTO madera) {
        this.madera = madera;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    
   
   
   
}
