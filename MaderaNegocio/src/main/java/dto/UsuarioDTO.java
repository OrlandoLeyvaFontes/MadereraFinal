/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Oley
 */
/**
 * Clase que representa a un usuario en el sistema. Esta clase contiene los detalles de la información 
 * personal de un usuario, como su nombre, apellidos, número, correo electrónico y contraseña.
 */
public class UsuarioDTO {

    private String id;               
    private String nombre;         
    private String apellidoPaterno;  
    private String apellidoMaterno; 
    private String numero;          
    private String correo;          
    private String contraseña;       

    /**
     * Constructor vacío para crear un objeto `UsuarioDTO`.
     */
    public UsuarioDTO() {
    }

    /**
     * Constructor para crear un objeto `UsuarioDTO` con los detalles del usuario.
     *
     * @param id El identificador único del usuario.
     * @param nombre El nombre del usuario.
     * @param apellidoPaterno El apellido paterno del usuario.
     * @param apellidoMaterno El apellido materno del usuario.
     * @param numero El número telefónico del usuario.
     * @param correo El correo electrónico del usuario.
     * @param contraseña La contraseña del usuario.
     */
    public UsuarioDTO(String id, String nombre, String apellidoPaterno, String apellidoMaterno, String numero, String correo, String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.numero = numero;
        this.correo = correo;
        this.contraseña = contraseña;
    }

    /**
     * Constructor para crear un objeto `UsuarioDTO` con solo el nombre del usuario.
     *
     * @param nombre El nombre del usuario.
     */
    public UsuarioDTO(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el identificador único del usuario.
     *
     * @return El ID del usuario.
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el identificador único del usuario.
     *
     * @param id El ID del usuario.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return El nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     *
     * @param nombre El nombre del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido paterno del usuario.
     *
     * @return El apellido paterno del usuario.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Establece el apellido paterno del usuario.
     *
     * @param apellidoPaterno El apellido paterno del usuario.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Obtiene el apellido materno del usuario.
     *
     * @return El apellido materno del usuario.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Establece el apellido materno del usuario.
     *
     * @param apellidoMaterno El apellido materno del usuario.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Obtiene el número telefónico del usuario.
     *
     * @return El número telefónico del usuario.
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Establece el número telefónico del usuario.
     *
     * @param numero El número telefónico del usuario.
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     *
     * @return El correo electrónico del usuario.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico del usuario.
     *
     * @param correo El correo electrónico del usuario.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return La contraseña del usuario.
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param contraseña La contraseña del usuario.
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}



