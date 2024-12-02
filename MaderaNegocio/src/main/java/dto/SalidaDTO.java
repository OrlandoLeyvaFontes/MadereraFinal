/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.Calendar;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
public class SalidaDTO {
     private String id;
    private String tipoMovimiento;
    private String madera;
    private Calendar fecha;
    private  int cantidad;
    private String usuario;
     private String compraId;

    public SalidaDTO() {
    }

     
     
    public SalidaDTO(String tipoMovimiento, String madera, Calendar fecha, int cantidad, String usuario, String compraId) {
        this.tipoMovimiento = tipoMovimiento;
        this.madera = madera;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.usuario = usuario;
        this.compraId = compraId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public String getMadera() {
        return madera;
    }

    public void setMadera(String madera) {
        this.madera = madera;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCompraId() {
        return compraId;
    }

    public void setCompraId(String compraId) {
        this.compraId = compraId;
    }
     
     
     
}
