/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
/**
 * Clase que representa un producto de madera en el sistema. Esta clase es
 * serializable para permitir su almacenamiento o transmisión.
 */
public class Madera implements Serializable {

    /**
     * Identificador único del producto
     */

    private ObjectId id;
    /**
     * Nombre del producto de madera
     */

    private String nombre;
    /**
     * Descripción detallada del producto
     */

    private String descripcion;
    /**
     * Cantidad disponible en inventario
     */

    private int cantidad;
    /**
     * Precio por unidad del producto
     */

    private double precioUnitario;
 /**
     * Constructor por defecto.
     * Inicializa un producto de madera sin datos.
     */
    public Madera() {
    }
 /**
     * Constructor que inicializa un producto con todos sus atributos excepto el ID.
     * @param nombre Nombre del producto
     * @param descripcion Descripción del producto
     * @param cantidad Cantidad disponible
     * @param precioUnitario Precio por unidad
     */
    public Madera(String nombre, String descripcion, int cantidad, double precioUnitario) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }
/**
     * Constructor que inicializa un producto con su ID y nombre.
     * Útil para referencias rápidas o listados básicos.
     * @param id Identificador único del producto
     * @param nombre Nombre del producto
     */
    public Madera(ObjectId id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
 /**
     * Obtiene el identificador único del producto.
     * @return El identificador del producto
     */
    public ObjectId getId() {
        return id;
    }
 /**
     * Establece el identificador único del producto.
     * @param id El nuevo identificador del producto
     */
    public void setId(ObjectId id) {
        this.id = id;
    }
 /**
     * Obtiene el nombre del producto.
     * @return El nombre del producto
     */
    public String getNombre() {
        return nombre;
    }
/**
     * Establece el nombre del producto.
     * @param nombre El nuevo nombre del producto
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
/**
     * Obtiene la descripción del producto.
     * @return La descripción del producto
     */
    public String getDescripcion() {
        return descripcion;
    }
 /**
     * Establece la descripción del producto.
     * @param descripcion La nueva descripción del producto
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
 /**
     * Obtiene la cantidad disponible en inventario.
     * @return La cantidad disponible
     */
    public int getCantidad() {
        return cantidad;
    }
/**
     * Establece la cantidad disponible en inventario.
     * @param cantidad La nueva cantidad disponible
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
/**
     * Obtiene el precio unitario del producto.
     * @return El precio por unidad
     */
    public double getPrecioUnitario() {
        return precioUnitario;
    }
/**
     * Establece el precio unitario del producto.
     * @param precioUnitario El nuevo precio por unidad
     */
    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

}
