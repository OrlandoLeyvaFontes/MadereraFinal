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
public class CompraMaderaDTO {
     private String idMadera; 
    private int cantidad; 
    private double precioUnitario;

    public CompraMaderaDTO(String idMadera, int cantidad, double precioUnitario) {
        this.idMadera = idMadera;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public String getIdMadera() {
        return idMadera;
    }

    public void setIdMadera(String idMadera) {
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

