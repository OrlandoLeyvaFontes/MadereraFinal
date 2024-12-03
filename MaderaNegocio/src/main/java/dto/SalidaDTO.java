/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.Calendar;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
/**
 * Clase que representa una salida de madera, ya sea por una compra o por otro tipo de movimiento. 
 * Esta clase contiene los detalles sobre la madera, la cantidad, el tipo de movimiento, el usuario que 
 * realiza la acción y la fecha de la salida.
 */
public class SalidaDTO {

    private String id;              
    private String tipoMovimiento;  
    private String madera;     
    private Calendar fecha;         
    private int cantidad;            
    private String usuario;         
    private String compraId;         

    /**
     * Constructor vacío para crear un objeto `SalidaDTO`.
     */
    public SalidaDTO() {
    }

    /**
     * Constructor para crear un objeto `SalidaDTO` con los detalles del movimiento.
     *
     * @param tipoMovimiento El tipo de movimiento (por ejemplo, "compra", "devolución").
     * @param madera El nombre de la madera asociada con la salida.
     * @param fecha La fecha en la que se realiza el movimiento de salida.
     * @param cantidad La cantidad de madera retirada en esta salida.
     * @param usuario El usuario que realiza el movimiento.
     * @param compraId El ID de la compra asociada a esta salida.
     */
    public SalidaDTO(String tipoMovimiento, String madera, Calendar fecha, int cantidad, String usuario, String compraId) {
        this.tipoMovimiento = tipoMovimiento;
        this.madera = madera;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.usuario = usuario;
        this.compraId = compraId;
    }

    /**
     * Obtiene el identificador de la salida.
     *
     * @return El ID de la salida.
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el identificador de la salida.
     *
     * @param id El ID de la salida.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene el tipo de movimiento de la salida.
     *
     * @return El tipo de movimiento (por ejemplo, "compra", "devolución").
     */
    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    /**
     * Establece el tipo de movimiento de la salida.
     *
     * @param tipoMovimiento El tipo de movimiento de la salida.
     */
    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    /**
     * Obtiene el nombre de la madera asociada con la salida.
     *
     * @return El nombre de la madera.
     */
    public String getMadera() {
        return madera;
    }

    /**
     * Establece el nombre de la madera asociada con la salida.
     *
     * @param madera El nombre de la madera.
     */
    public void setMadera(String madera) {
        this.madera = madera;
    }

    /**
     * Obtiene la fecha en que se realizó el movimiento de salida.
     *
     * @return La fecha de la salida.
     */
    public Calendar getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha en que se realizó el movimiento de salida.
     *
     * @param fecha La fecha de la salida.
     */
    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene la cantidad de madera retirada en la salida.
     *
     * @return La cantidad de madera retirada.
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad de madera retirada en la salida.
     *
     * @param cantidad La cantidad de madera retirada.
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el nombre del usuario que realiza la salida.
     *
     * @return El nombre del usuario.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Establece el nombre del usuario que realiza la salida.
     *
     * @param usuario El nombre del usuario.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene el ID de la compra asociada a esta salida, si aplica.
     *
     * @return El ID de la compra asociada a la salida.
     */
    public String getCompraId() {
        return compraId;
    }

    /**
     * Establece el ID de la compra asociada a esta salida.
     *
     * @param compraId El ID de la compra asociada.
     */
    public void setCompraId(String compraId) {
        this.compraId = compraId;
    }
}
