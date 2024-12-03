/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import entidades.Madera;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Clase DTO (Data Transfer Object) que representa la información de un usuario
 * de ventas. Esta clase es utilizada para transferir datos de un usuario de
 * ventas entre capas, como la capa de presentación y la capa de negocio.
 *
 * @author aleja
 */
public class UsuarioVentasDTO {

    // Atributos del usuario de ventas
    private ObjectId id;               // Identificador único del usuario
    private String nombre;              // Nombre del usuario
    private String apellidoPaterno;     // Apellido paterno del usuario
    private String apellidoMaterno;     // Apellido materno del usuario
    private String numero;              // Número de contacto del usuario
    private String correo;              // Correo electrónico del usuario
    private String contraseña;          // Contraseña del usuario (debe ser encriptada)
    private List<Madera> maderas;       // Lista de maderas asociadas al usuario

    /**
     * Constructor que inicializa todos los atributos de la clase.
     *
     * @param id Identificador único del usuario
     * @param nombre Nombre del usuario
     * @param apellidoPaterno Apellido paterno del usuario
     * @param apellidoMaterno Apellido materno del usuario
     * @param numero Número de contacto del usuario
     * @param correo Correo electrónico del usuario
     * @param contraseña Contraseña encriptada del usuario
     * @param maderas Lista de maderas asociadas al usuario
     */
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

    /**
     * Constructor que inicializa los atributos del usuario sin la lista de
     * maderas.
     *
     * @param id Identificador único del usuario
     * @param nombre Nombre del usuario
     * @param apellidoPaterno Apellido paterno del usuario
     * @param apellidoMaterno Apellido materno del usuario
     * @param numero Número de contacto del usuario
     * @param correo Correo electrónico del usuario
     * @param contraseña Contraseña encriptada del usuario
     */
    public UsuarioVentasDTO(ObjectId id, String nombre, String apellidoPaterno, String apellidoMaterno, String numero, String correo, String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.numero = numero;
        this.correo = correo;
        this.contraseña = contraseña;
    }

    /**
     * Constructor vacío para la clase `UsuarioVentasDTO`. Este constructor es
     * útil cuando se crea una instancia de la clase sin inicializar atributos
     * de inmediato.
     */
    public UsuarioVentasDTO() {
    }

    // Métodos getter y setter para acceder y modificar los atributos
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

    /**
     * Sobrescribe el método `toString` para representar el objeto
     * `UsuarioVentasDTO` como una cadena.
     *
     * @return Representación en cadena del objeto `UsuarioVentasDTO`,
     * incluyendo solo el nombre del usuario.
     */
    @Override
    public String toString() {
        return "UsuarioVentasDTO{" + "nombre=" + nombre + '}';
    }
}
