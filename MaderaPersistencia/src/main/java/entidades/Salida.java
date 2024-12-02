/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
public class Salida implements Serializable {

    private ObjectId id;
    private String tipoMovimiento;
    private String madera;
    private Calendar fecha;
    private  int cantidad;
    private String usuario;
     private ObjectId compraId;

    public Salida() {
    }

    public Salida(String tipoMovimiento, String madera, Calendar fecha, int cantidad, String usuario, ObjectId compraId) {
        this.tipoMovimiento = tipoMovimiento;
        this.madera = madera;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.usuario = usuario;
        this.compraId = compraId;
    }

  

   

    
    public ObjectId getCompraId() {
        return compraId;
    }

    public void setCompraId(ObjectId compraId) {
        this.compraId = compraId;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

  

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

   

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getMadera() {
        return madera;
    }

    public void setMadera(String madera) {
        this.madera = madera;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

   
    
    
    
    
    
}
