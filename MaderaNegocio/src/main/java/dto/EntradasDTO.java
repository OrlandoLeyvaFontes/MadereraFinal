/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.time.LocalDate;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

/**
 * Clase DTO (Data Transfer Object) que representa la entrada de maderas en el
 * sistema. Esta clase es utilizada para transferir datos relacionados con las
 * entradas de madera entre diferentes capas, como la capa de presentación y la
 * capa de negocio.
 *
 * @author aleja
 */
public class EntradasDTO {

    // Atributos de la entrada
    private String id;               // Identificador único de la entrada
    private String tipoEntrada;       // Tipo de entrada (por ejemplo, compra, transferencia, etc.)
    private String tipoMadera;        // Tipo de madera que entra al inventario
    private int cantidad;             // Cantidad de madera que entra
    private LocalDate fechaEntrada;   // Fecha en la que ocurrió la entrada

    /**
     * Constructor que inicializa todos los atributos de la clase.
     *
     * @param id Identificador único de la entrada
     * @param tipoEntrada Tipo de entrada de la madera
     * @param tipoMadera Tipo de madera que entra al inventario
     * @param cantidad Cantidad de madera que entra
     * @param fechaEntrada Fecha en la que ocurrió la entrada
     */
    public EntradasDTO(String id, String tipoEntrada, String tipoMadera, int cantidad, LocalDate fechaEntrada) {
        this.id = id;
        this.tipoEntrada = tipoEntrada;
        this.tipoMadera = tipoMadera;
        this.cantidad = cantidad;
        this.fechaEntrada = fechaEntrada;
    }

    /**
     * Constructor vacío para la clase `EntradasDTO`. Este constructor es útil
     * cuando se crea una instancia de la clase sin inicializar atributos de
     * inmediato.
     */
    public EntradasDTO() {
    }

    // Métodos getter y setter para acceder y modificar los atributos
    public String getId() {
        return id;
    }

    public void setId(String id) {
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
