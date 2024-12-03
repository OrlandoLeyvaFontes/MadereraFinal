/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
/**
 * Clase que representa un usuario del sistema. Esta clase es serializable para
 * permitir su almacenamiento o transmisión. Contiene información personal y de
 * contacto del usuario, así como sus métodos de pago.
 */
public class Usuario implements Serializable {

    /**
     * Identificador único del usuario
     */

    private ObjectId id;
    /**
     * Nombre(s) del usuario
     */

    private String nombre;
    /**
     * Apellido paterno del usuario
     */

    private String apellidoPaterno;
    /**
     * Apellido materno del usuario
     */

    private String apellidoMaterno;
    /**
     * Número telefónico del usuario
     */

    private String numero;
    /**
     * Correo electrónico del usuario
     */

    private String correo;
    /**
     * Contraseña del usuario (debe ser almacenada de forma segura)
     */

    private String contraseña;
    /**
     * Lista de tarjetas de pago asociadas al usuario
     */

    private List<Tarjetas> tarjetas;

    /**
     * Constructor por defecto. Inicializa un usuario sin datos.
     */
    public Usuario() {
    }

    /**
     * Constructor que inicializa un usuario con sus datos personales básicos.
     *
     * @param nombre Nombre(s) del usuario
     * @param apellidoPaterno Apellido paterno
     * @param apellidoMaterno Apellido materno
     * @param numero Número telefónico
     * @param correo Correo electrónico
     * @param contraseña Contraseña del usuario
     */
    public Usuario(String nombre, String apellidoPaterno, String apellidoMaterno, String numero, String correo, String contraseña) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.numero = numero;
        this.correo = correo;
        this.contraseña = contraseña;
    }

    /**
     * Constructor completo que inicializa un usuario con todos sus datos.
     *
     * @param id Identificador único
     * @param nombre Nombre del usuario
     * @param apellidoPaterno Apellido paterno
     * @param apellidoMaterno Apellido materno
     * @param numero Número telefónico
     * @param correo Correo electrónico
     * @param contraseña Contraseña del usuario
     * @param tarjetas Lista de tarjetas de pago
     */
    public Usuario(ObjectId id, String nombre, String apellidoPaterno, String apellidoMaterno, String numero, String correo, String contraseña, List<Tarjetas> tarjetas) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.numero = numero;
        this.correo = correo;
        this.contraseña = contraseña;
        this.tarjetas = tarjetas;
    }

    /**
     * Constructor simplificado para referencias rápidas.
     *
     * @param id Identificador único
     * @param nombre Nombre del usuario
     */
    public Usuario(ObjectId id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    /**
     * Obtiene el identificador único del usuario.
     *
     * @return El identificador del usuario
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el identificador único del usuario.
     *
     * @param id El nuevo identificador del usuario
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return El nombre del usuario
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     *
     * @param nombre El nuevo nombre del usuario
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido paterno del usuario.
     *
     * @return El apellido paterno
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Establece el apellido paterno del usuario.
     *
     * @param apellidoPaterno El nuevo apellido paterno
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Obtiene el apellido materno del usuario.
     *
     * @return El apellido materno
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Establece el apellido materno del usuario.
     *
     * @param apellidoMaterno El nuevo apellido materno
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Obtiene el número telefónico del usuario.
     *
     * @return El número telefónico
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Establece el número telefónico del usuario.
     *
     * @param numero El nuevo número telefónico
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     *
     * @return El correo electrónico
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico del usuario.
     *
     * @param correo El nuevo correo electrónico
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return La contraseña del usuario
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param contraseña La nueva contraseña
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * Obtiene la lista de tarjetas de pago del usuario.
     *
     * @return La lista de tarjetas
     */
    public List<Tarjetas> getTarjetas() {
        return tarjetas;
    }

    /**
     * Establece la lista de tarjetas de pago del usuario.
     *
     * @param tarjetas La nueva lista de tarjetas
     */
    public void setTarjetas(List<Tarjetas> tarjetas) {
        this.tarjetas = tarjetas;
    }

}
