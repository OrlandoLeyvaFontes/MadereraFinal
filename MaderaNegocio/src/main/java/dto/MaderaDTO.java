/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
/**
 * Clase que representa una madera disponible para la venta, incluyendo su nombre, descripción,
 * cantidad disponible y precio unitario.
 */
public class MaderaDTO {

    private String id;               // Identificador único de la madera
    private String nombre;           // Nombre de la madera
    private String descripcion;      // Descripción de la madera
    private int cantidad;            // Cantidad disponible de la madera
    private double precioUnitario;   // Precio por unidad de la madera

    /**
     * Constructor vacío para crear un objeto `MaderaDTO`.
     */
    public MaderaDTO() {
    }

    /**
     * Constructor para crear un objeto `MaderaDTO` con todos los atributos.
     *
     * @param nombre El nombre de la madera.
     * @param descripcion Una descripción breve de la madera.
     * @param cantidad La cantidad disponible de la madera.
     * @param precioUnitario El precio unitario de la madera.
     */
    public MaderaDTO(String nombre, String descripcion, int cantidad, double precioUnitario) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    /**
     * Constructor para crear un objeto `MaderaDTO` con nombre y precio unitario.
     *
     * @param nombre El nombre de la madera.
     * @param precioUnitario El precio unitario de la madera.
     */
    public MaderaDTO(String nombre, double precioUnitario) {
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
    }

    /**
     * Constructor para crear un objeto `MaderaDTO` con solo el nombre.
     *
     * @param nombre El nombre de la madera.
     */
    public MaderaDTO(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el identificador de la madera.
     *
     * @return El ID de la madera.
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el identificador de la madera.
     *
     * @param id El ID de la madera.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de la madera.
     *
     * @return El nombre de la madera.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la madera.
     *
     * @param nombre El nombre de la madera.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la descripción de la madera.
     *
     * @return La descripción de la madera.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción de la madera.
     *
     * @param descripcion La descripción de la madera.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene la cantidad disponible de la madera.
     *
     * @return La cantidad disponible de la madera.
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad disponible de la madera.
     *
     * @param cantidad La cantidad de madera disponible.
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el precio unitario de la madera.
     *
     * @return El precio unitario de la madera.
     */
    public double getPrecioUnitario() {
        return precioUnitario;
    }

    /**
     * Establece el precio unitario de la madera.
     *
     * @param precioUnitario El precio por unidad de la madera.
     */
    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
}

