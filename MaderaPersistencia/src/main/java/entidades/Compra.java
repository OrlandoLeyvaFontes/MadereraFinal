/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Calendar;
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
/**
 * Clase que representa una compra de madera en el sistema. Esta clase es
 * serializable para permitir su almacenamiento o transmisión.
 */
public class Compra implements Serializable {

    /**
     * Identificador único de la compra
     */

    private ObjectId id;
    /**
     * Fecha en que se realizó la compra
     */

    private Calendar fechaCompra;
    /**
     * Precio total de la compra
     */

    private double precioTotal;
    /**
     * Cantidad de unidades compradas
     */

    private int cantidad;
    /**
     * Producto de madera comprado
     */

    private Madera madera;
    /**
     * Usuario que realizó la compra
     */

    private Usuario usuario;

    /**
     * Constructor por defecto. Inicializa una compra sin datos.
     */
    public Compra() {
    }

    /**
     * Constructor que inicializa una compra con sus datos básicos.
     *
     * @param fechaCompra Fecha en que se realiza la compra
     * @param precioTotal Precio total de la compra
     * @param cantidad Cantidad de unidades compradas
     */
    public Compra(Calendar fechaCompra, double precioTotal, int cantidad) {
        this.fechaCompra = fechaCompra;
        this.precioTotal = precioTotal;
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el identificador único de la compra.
     *
     * @return El identificador de la compra
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el identificador único de la compra.
     *
     * @param id El nuevo identificador de la compra
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtiene la fecha de la compra.
     *
     * @return La fecha de la compra
     */
    public Calendar getFechaCompra() {
        return fechaCompra;
    }

    /**
     * Establece la fecha de la compra.
     *
     * @param fechaCompra La nueva fecha de la compra
     */
    public void setFechaCompra(Calendar fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    /**
     * Obtiene el precio total de la compra.
     *
     * @return El precio total
     */
    public double getPrecioTotal() {
        return precioTotal;
    }

    /**
     * Establece el precio total de la compra.
     *
     * @param precioTotal El nuevo precio total
     */
    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    /**
     * Obtiene la cantidad de unidades compradas.
     *
     * @return La cantidad comprada
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad de unidades compradas.
     *
     * @param cantidad La nueva cantidad
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el producto de madera comprado.
     *
     * @return El producto de madera
     */
    public Madera getMadera() {
        return madera;
    }

    /**
     * Establece el producto de madera comprado.
     *
     * @param madera El nuevo producto de madera
     */
    public void setMadera(Madera madera) {
        this.madera = madera;
    }

    /**
     * Obtiene el usuario que realizó la compra.
     *
     * @return El usuario comprador
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Establece el usuario que realizó la compra.
     *
     * @param usuario El nuevo usuario comprador
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
