/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
public class MaderaDTO {

    private String id;
    private String nombre;
    private String descripcion;
    private int cantidad;
    private double precioUnitario;
    private String CorreoVendedor;

    public MaderaDTO() {
    }

    public MaderaDTO(String id, String nombre, String descripcion, int cantidad, double precioUnitario, String CorreoVendedor) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.CorreoVendedor = CorreoVendedor;
    }

    public MaderaDTO(String id, String nombre, String descripcion, int cantidad, double precioUnitario) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public MaderaDTO(String nombre, String descripcion, int cantidad, double precioUnitario) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public MaderaDTO(String nombre, double precioUnitario) {
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getCorreoVendedor() {
        return CorreoVendedor;
    }

    public void setCorreoVendedor(String CorreoVendedor) {
        this.CorreoVendedor = CorreoVendedor;
    }

    @Override
    public String toString() {
        return "MaderaDTO{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + ", CorreoVendedor=" + CorreoVendedor + '}';
    }

}
