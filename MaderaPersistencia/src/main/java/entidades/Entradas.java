/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.time.LocalDate;
import org.bson.types.ObjectId;

/**
 *
 * @author aleja
 */
public class Entradas implements Serializable {
    private ObjectId id;
    private String tipoEntrada;
    private String tipoMadera;
    private int cantidad;
    private LocalDate fechaEntrada;

    public Entradas(ObjectId id, String tipoEntrada, String tipoMadera, int cantidad, LocalDate fechaEntrada) {
        this.id = id;
        this.tipoEntrada = tipoEntrada;
        this.tipoMadera = tipoMadera;
        this.cantidad = cantidad;
        this.fechaEntrada = fechaEntrada;
    }

    

    

    public Entradas() {
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }
    
    

    public String getTipoEntrada() {
        return tipoEntrada;
    }

    public void setTipoEntrada(String tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }

    public String getTipoMadera() {
        return tipoMadera;
    }

    public void setTipoMadera(String tipoMadera) {
        this.tipoMadera = tipoMadera;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    

    

    
}
