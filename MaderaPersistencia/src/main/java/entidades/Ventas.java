/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
public class Ventas implements Serializable {

    private ObjectId id;
    private Calendar fechaVenta;
    private double precioTotal;
    private int cantidad;
    private Madera madera;
    private Usuario usuario;

    public Ventas() {
    }

    public Ventas(Compra compra) {
        this.fechaVenta = compra.getFechaCompra();
        this.precioTotal = compra.getPrecioTotal();
        this.cantidad = compra.getCantidad();
        this.madera = compra.getMadera();
        this.usuario = compra.getUsuario();
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Calendar getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Calendar fechaVenta) {
        this.fechaVenta = fechaVenta;
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

    public Madera getMadera() {
        return madera;
    }

    public void setMadera(Madera madera) {
        this.madera = madera;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
