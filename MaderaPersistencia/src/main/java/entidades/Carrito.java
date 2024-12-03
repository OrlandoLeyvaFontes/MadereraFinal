/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.ArrayList;
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
/**
 * Clase que representa un carrito de compras para productos de madera. Esta
 * clase es serializable para permitir su almacenamiento o transmisión.
 */
public class Carrito implements Serializable {

    /**
     * Identificador único del carrito
     */
    private ObjectId id;
    /**
     * Usuario propietario del carrito
     */
    private Usuario usuario;
    /**
     * Lista de productos de madera en el carrito
     */

    private List<Madera> maderas;
    /**
     * Lista de cantidades correspondientes a cada producto de madera
     */

    private List<Integer> cantidades;
    /**
     * Monto total del carrito
     */

    private double total;

    /**
     * Constructor por defecto. Inicializa un carrito vacío con listas nuevas y
     * total en cero.
     */
    public Carrito() {
        this.maderas = new ArrayList<>();
        this.cantidades = new ArrayList<>();
        this.total = 0.0;
    }

    /**
     * Constructor que inicializa un carrito para un usuario específico.
     *
     * @param usuario El usuario propietario del carrito
     */
    public Carrito(Usuario usuario) {
        this.usuario = usuario;
        this.maderas = new ArrayList<>();
        this.cantidades = new ArrayList<>();
        this.total = 0.0;
    }

    /**
     * Obtiene el identificador único del carrito.
     *
     * @return El identificador del carrito
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el identificador único del carrito.
     *
     * @param id El nuevo identificador del carrito
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtiene el usuario propietario del carrito.
     *
     * @return El usuario del carrito
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Establece el usuario propietario del carrito.
     *
     * @param usuario El nuevo usuario del carrito
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene la lista de productos de madera en el carrito.
     *
     * @return Lista de productos de madera
     */
    public List<Madera> getMaderas() {
        return maderas;
    }

    /**
     * Establece la lista de productos de madera en el carrito.
     *
     * @param maderas Nueva lista de productos de madera
     */
    public void setMaderas(List<Madera> maderas) {
        this.maderas = maderas;
    }

    /**
     * Obtiene la lista de cantidades de cada producto.
     *
     * @return Lista de cantidades
     */
    public List<Integer> getCantidades() {
        return cantidades;
    }

    /**
     * Establece la lista de cantidades de cada producto.
     *
     * @param cantidades Nueva lista de cantidades
     */
    public void setCantidades(List<Integer> cantidades) {
        this.cantidades = cantidades;
    }

    /**
     * Obtiene el monto total del carrito.
     *
     * @return El total del carrito
     */
    public double getTotal() {
        return total;
    }

}
