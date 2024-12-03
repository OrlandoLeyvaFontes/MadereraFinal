/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Representa un usuario de ventas en el sistema.
 *
 * Atributos: - id: Identificador único del usuario de ventas (tipo ObjectId). -
 * nombre: Nombre del usuario de ventas. - apellidoPaterno: Apellido paterno del
 * usuario. - apellidoMaterno: Apellido materno del usuario. - numero: Número de
 * contacto del usuario. - correo: Correo electrónico del usuario. - contraseña:
 * Contraseña del usuario para iniciar sesión. - maderas: Lista de maderas
 * asociadas al usuario de ventas.
 *
 * Métodos: - Getters y setters para cada uno de los atributos. - Constructores
 * para crear instancias de la clase con todos los datos o con datos mínimos.
 */
public class UsuarioVentas implements Serializable {

    private ObjectId id;               // Identificador único del usuario de ventas
    private String nombre;             // Nombre del usuario de ventas
    private String apellidoPaterno;    // Apellido paterno del usuario
    private String apellidoMaterno;    // Apellido materno del usuario
    private String numero;             // Número de contacto del usuario
    private String correo;             // Correo electrónico del usuario
    private String contraseña;         // Contraseña del usuario
    private List<Madera> maderas;      // Lista de maderas asociadas a este usuario

    /**
     * Constructor con todos los atributos para crear un objeto UsuarioVentas.
     *
     * @param id El ID único del usuario de ventas.
     * @param nombre El nombre del usuario.
     * @param apellidoPaterno El apellido paterno del usuario.
     * @param apellidoMaterno El apellido materno del usuario.
     * @param numero El número de contacto del usuario.
     * @param correo El correo electrónico del usuario.
     * @param contraseña La contraseña del usuario.
     * @param maderas Lista de maderas asociadas a este usuario.
     */
    public UsuarioVentas(ObjectId id, String nombre, String apellidoPaterno, String apellidoMaterno, String numero, String correo, String contraseña, List<Madera> maderas) {
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
     * Constructor sin la lista de maderas, útil cuando no se tiene esa
     * información disponible.
     */
    public UsuarioVentas(ObjectId id, String nombre, String apellidoPaterno, String apellidoMaterno, String numero, String correo, String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.numero = numero;
        this.correo = correo;
        this.contraseña = contraseña;
    }

    /**
     * Constructor vacío para crear un objeto sin datos iniciales.
     */
    public UsuarioVentas() {
    }

    /**
     * Constructor que solo requiere el ID y el nombre del usuario.
     */
    public UsuarioVentas(ObjectId id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Métodos getter y setter para cada uno de los atributos
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
}
