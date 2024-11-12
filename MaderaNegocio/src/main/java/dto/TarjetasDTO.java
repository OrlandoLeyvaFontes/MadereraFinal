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
public class TarjetasDTO {
    
 
    private ObjectId id;
    private String nombre;
    private String numero;
    private Calendar fehcaVencimiento;
    private String CVV;

    public TarjetasDTO() {
    }

    public TarjetasDTO(String nombre, String numero, Calendar fehcaVencimiento, String CVV) {
        this.nombre = nombre;
        this.numero = numero;
        this.fehcaVencimiento = fehcaVencimiento;
        this.CVV = CVV;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Calendar getFehcaVencimiento() {
        return fehcaVencimiento;
    }

    public void setFehcaVencimiento(Calendar fehcaVencimiento) {
        this.fehcaVencimiento = fehcaVencimiento;
    }

    public String getCVV() {
        return CVV;
    }

    public void setCVV(String CVV) {
        this.CVV = CVV;
    }

  
}
