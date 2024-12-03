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
/**
 * Clase que representa una salida o movimiento de inventario de madera en el
 * sistema. Esta clase es serializable para permitir su almacenamiento o
 * transmisión.
 */
public class Salida implements Serializable {

    /**
     * Identificador único de la salida
     */

    private ObjectId id;
    /**
     * Tipo de movimiento realizado
     */

    private String tipoMovimiento;
    /**
     * Nombre o identificador de la madera
     */

    private String madera;
    /**
     * Fecha en que se realizó el movimiento
     */

    private Calendar fecha;
    /**
     * Cantidad de unidades en el movimiento
     */

    private int cantidad;
    /**
     * Usuario que realizó el movimiento
     */

    private String usuario;
    /**
     * Identificador de la compra asociada
     */

    private ObjectId compraId;

    /**
     * Constructor por defecto. Inicializa una salida sin datos.
     */
    public Salida() {
    }

    /**
     * Constructor que inicializa una salida con todos sus datos.
     *
     * @param tipoMovimiento Tipo de movimiento a realizar
     * @param madera Nombre o identificador de la madera
     * @param fecha Fecha del movimiento
     * @param cantidad Cantidad de unidades
     * @param usuario Usuario que realiza el movimiento
     * @param compraId Identificador de la compra asociada
     */
    public Salida(String tipoMovimiento, String madera, Calendar fecha, int cantidad, String usuario, ObjectId compraId) {
        this.tipoMovimiento = tipoMovimiento;
        this.madera = madera;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.usuario = usuario;
        this.compraId = compraId;
    }

    /**
     * Obtiene el identificador de la compra asociada.
     *
     * @return El identificador de la compra
     */
    public ObjectId getCompraId() {
        return compraId;
    }

    /**
     * Establece el identificador de la compra asociada.
     *
     * @param compraId El nuevo identificador de la compra
     */
    public void setCompraId(ObjectId compraId) {
        this.compraId = compraId;
    }

    /**
     * Obtiene el identificador único de la salida.
     *
     * @return El identificador de la salida
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el identificador único de la salida.
     *
     * @param id El nuevo identificador de la salida
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtiene el tipo de movimiento realizado.
     *
     * @return El tipo de movimiento
     */
    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    /**
     * Establece el tipo de movimiento realizado.
     *
     * @param tipoMovimiento El nuevo tipo de movimiento
     */
    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    /**
     * Obtiene la fecha del movimiento.
     *
     * @return La fecha del movimiento
     */
    public Calendar getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha del movimiento.
     *
     * @param fecha La nueva fecha del movimiento
     */
    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene la cantidad de unidades en el movimiento.
     *
     * @return La cantidad de unidades
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad de unidades en el movimiento.
     *
     * @param cantidad La nueva cantidad de unidades
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el nombre o identificador de la madera.
     *
     * @return El identificador de la madera
     */
    public String getMadera() {
        return madera;
    }

    /**
     * Establece el nombre o identificador de la madera.
     *
     * @param madera El nuevo identificador de la madera
     */
    public void setMadera(String madera) {
        this.madera = madera;
    }

    /**
     * Obtiene el usuario que realizó el movimiento.
     *
     * @return El usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Establece el usuario que realizó el movimiento.
     *
     * @param usuario El nuevo usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}
