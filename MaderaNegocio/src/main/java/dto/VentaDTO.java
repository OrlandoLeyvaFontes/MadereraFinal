/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import entidades.Compra;
import entidades.Madera;
import entidades.Usuario;
import entidades.Ventas;
import java.util.Calendar;
import java.util.Date;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
public class VentaDTO {
   private String id; 
    private int cantidad; 
    private double precioTotal;
    private Date fechaVenta; 
    private MaderaDTO madera; 
    private UsuarioDTO usuario; 

    public VentaDTO() {
    }

    public VentaDTO(String id, int cantidad, double precioTotal, Date fechaVenta, MaderaDTO madera, UsuarioDTO usuario) {
        this.id = id;
        this.cantidad = cantidad;
        this.precioTotal = precioTotal;
        this.fechaVenta = fechaVenta;
        this.madera = madera;
        this.usuario = usuario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
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
