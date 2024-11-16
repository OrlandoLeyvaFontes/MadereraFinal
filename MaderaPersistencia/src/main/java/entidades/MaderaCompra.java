/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
public class MaderaCompra implements Serializable {

     private ObjectId idMadera; 
    private int cantidad; 
    private double precioUnitario;

    public MaderaCompra(ObjectId idMadera, int cantidad, double precioUnitario) {
        this.idMadera = idMadera;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public ObjectId getIdMadera() {
        return idMadera;
    }

    public void setIdMadera(ObjectId idMadera) {
        this.idMadera = idMadera;
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
}
