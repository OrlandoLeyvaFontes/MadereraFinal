/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
/* Clase que representa una tarjeta  en el sistema.
 */
public class Tarjetas implements Serializable {

    /**
     * Identificador único de la tarjeta
     */

    private ObjectId id;
    /**
     * Nombre del titular de la tarjeta
     */

    private String nombre;
    /**
     * Número de la tarjeta (debe ser almacenado de forma segura)
     */

    private String numero;
    /**
     * Fecha de vencimiento de la tarjeta
     */

    private Calendar fehcaVencimiento;
    /**
     * Código de seguridad de la tarjeta (CVV)
     */

    private String CVV;

    /**
     * Constructor por defecto. Inicializa una tarjeta sin datos.
     */
    public Tarjetas() {
    }

    /**
     * Constructor que inicializa una tarjeta con todos sus datos.
     *
     * @param nombre Nombre del titular de la tarjeta
     * @param numero Número de la tarjeta
     * @param fehcaVencimiento Fecha de vencimiento de la tarjeta
     * @param CVV Código de seguridad de la tarjeta
     */
    public Tarjetas(String nombre, String numero, Calendar fehcaVencimiento, String CVV) {
        this.nombre = nombre;
        this.numero = numero;
        this.fehcaVencimiento = fehcaVencimiento;
        this.CVV = CVV;
    }

    /**
     * Obtiene el identificador único de la tarjeta.
     *
     * @return El identificador de la tarjeta
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el identificador único de la tarjeta.
     *
     * @param id El nuevo identificador de la tarjeta
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del titular de la tarjeta.
     *
     * @return El nombre del titular
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del titular de la tarjeta.
     *
     * @param nombre El nuevo nombre del titular
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el número de la tarjeta.
     *
     * @return El número de la tarjeta
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Establece el número de la tarjeta.
     *
     * @param numero El nuevo número de la tarjeta
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Obtiene la fecha de vencimiento de la tarjeta.
     *
     * @return La fecha de vencimiento
     */
    public Calendar getFehcaVencimiento() {
        return fehcaVencimiento;
    }

    /**
     * Establece la fecha de vencimiento de la tarjeta.
     *
     * @param fehcaVencimiento La nueva fecha de vencimiento
     */
    public void setFehcaVencimiento(Calendar fehcaVencimiento) {
        this.fehcaVencimiento = fehcaVencimiento;
    }

    /**
     * Obtiene el código de seguridad (CVV) de la tarjeta.
     *
     * @return El código de seguridad
     */
    public String getCVV() {
        return CVV;
    }

    /**
     * Establece el código de seguridad (CVV) de la tarjeta.
     *
     * @param CVV El nuevo código de seguridad
     */
    public void setCVV(String CVV) {
        this.CVV = CVV;
    }

}
