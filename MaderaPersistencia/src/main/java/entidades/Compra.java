/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
public class Compra implements Serializable {

       private ObjectId id; 
    private ObjectId idUsuario; 
    private ObjectId idTarjeta; 
    private List<MaderaCompra> maderaComprada; 
    private double total; 
    private Date fechaCompra; 
    private String estado;

    public Compra(ObjectId idUsuario, ObjectId idTarjeta, List<MaderaCompra> maderaComprada, double total, Date fechaCompra, String estado) {
        this.idUsuario = idUsuario;
        this.idTarjeta = idTarjeta;
        this.maderaComprada = maderaComprada;
        this.total = total;
        this.fechaCompra = fechaCompra;
        this.estado = estado;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ObjectId getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(ObjectId idUsuario) {
        this.idUsuario = idUsuario;
    }

    public ObjectId getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(ObjectId idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public List<MaderaCompra> getMaderaComprada() {
        return maderaComprada;
    }

    public void setMaderaComprada(List<MaderaCompra> maderaComprada) {
        this.maderaComprada = maderaComprada;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
