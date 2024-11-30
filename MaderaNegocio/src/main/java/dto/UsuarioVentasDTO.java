/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import entidades.Madera;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author aleja
 */
public class UsuarioVentasDTO {

    private ObjectId id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String numero;
    private String correo;
    private String contraseña;
    private List<Madera> maderas;

    
    public UsuarioVentasDTO(ObjectId id, String nombre, String apellidoPaterno, String apellidoMaterno, String numero, String correo, String contraseña, List<Madera> maderas) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.numero = numero;
        this.correo = correo;
        this.contraseña = contraseña;
        this.maderas = maderas;
    }

    public UsuarioVentasDTO(ObjectId id, String nombre, String apellidoPaterno, String apellidoMaterno, String numero, String correo, String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.numero = numero;
        this.correo = correo;
        this.contraseña = contraseña;
    }

    public UsuarioVentasDTO() {
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

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public List<Madera> getMaderas() {
        return maderas;
    }

    public void setMaderas(List<Madera> maderas) {
        this.maderas = maderas;
    }

    @Override
    public String toString() {
        return "UsuarioVentasDTO{" + "nombre=" + nombre + '}';
    }

    
}
