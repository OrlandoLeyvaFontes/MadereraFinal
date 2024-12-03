/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.time.LocalDate;
import org.bson.types.ObjectId;

/**
 * Representa una entrada de madera en el sistema.
 *
 * Atributos: - id: Identificador único de la entrada (tipo ObjectId). -
 * tipoEntrada: Tipo de entrada de madera (por ejemplo, compra, donación, etc.).
 * - tipoMadera: Tipo de madera que se está ingresando (por ejemplo, pino,
 * roble, etc.). - cantidad: Cantidad de madera ingresada. - fechaEntrada: Fecha
 * en la que se realizó la entrada de madera.
 *
 * Métodos: - Getters y setters para cada uno de los atributos de la clase. -
 * Constructor con parámetros para crear una entrada con todos los atributos
 * especificados. - Constructor vacío para crear un objeto sin parámetros
 * iniciales.
 */
public class Entradas implements Serializable {

    private ObjectId id;           // Identificador único de la entrada
    private String tipoEntrada;    // Tipo de entrada de madera (ej. compra, donación)
    private String tipoMadera;     // Tipo de madera que se está ingresando
    private int cantidad;          // Cantidad de madera ingresada
    private LocalDate fechaEntrada; // Fecha de la entrada de madera

    /**
     * Constructor con parámetros para inicializar la entrada de madera.
     *
     * @param id El ID único de la entrada.
     * @param tipoEntrada El tipo de entrada (compra, donación, etc.).
     * @param tipoMadera El tipo de madera que se ingresa.
     * @param cantidad La cantidad de madera ingresada.
     * @param fechaEntrada La fecha de la entrada de madera.
     */
    public Entradas(ObjectId id, String tipoEntrada, String tipoMadera, int cantidad, LocalDate fechaEntrada) {
        this.id = id;
        this.tipoEntrada = tipoEntrada;
        this.tipoMadera = tipoMadera;
        this.cantidad = cantidad;
        this.fechaEntrada = fechaEntrada;
    }

    /**
     * Constructor vacío para crear una entrada sin datos iniciales.
     */
    public Entradas() {
    }

    // Métodos getter y setter para cada uno de los atributos
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTipoEntrada() {
        return tipoEntrada;
    }

    public void setTipoEntrada(String tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }

    public String getTipoMadera() {
        return tipoMadera;
    }

    public void setTipoMadera(String tipoMadera) {
        this.tipoMadera = tipoMadera;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }
}
