/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.Calendar;



/**
 *
 * @author Oley
 */
/**
 * Clase que representa una compra realizada por un usuario, incluyendo los detalles de la madera,
 * la cantidad comprada, el precio total y la fecha de la compra.
 */
public class CompraDTO {
    
    private String id;             
    private Calendar fechaCompra;   
    private double precioTotal;     
    private int cantidad;          
    private MaderaDTO madera;      
    private UsuarioDTO usuario;    

    /**
     * Constructor vacío para crear un objeto `CompraDTO`.
     */
    public CompraDTO() {
    }

    /**
     * Constructor para crear un objeto `CompraDTO` con los detalles de la compra.
     *
     * @param fechaCompra La fecha en que se realizó la compra.
     * @param precioTotal El precio total de la compra.
     * @param cantidad La cantidad de madera comprada.
     * @param madera El objeto `MaderaDTO` que representa la madera comprada.
     * @param usuario El objeto `UsuarioDTO` que representa al usuario que realizó la compra.
     */
    public CompraDTO(Calendar fechaCompra, double precioTotal, int cantidad, MaderaDTO madera, UsuarioDTO usuario) {
        this.fechaCompra = fechaCompra;
        this.precioTotal = precioTotal;
        this.cantidad = cantidad;
        this.madera = madera;
        this.usuario = usuario;
    }

    /**
     * Obtiene el identificador de la compra.
     *
     * @return El ID de la compra.
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el identificador de la compra.
     *
     * @param id El ID de la compra.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene la fecha en la que se realizó la compra.
     *
     * @return El objeto `Calendar` que representa la fecha de la compra.
     */
    public Calendar getFechaCompra() {
        return fechaCompra;
    }

    /**
     * Establece la fecha en la que se realizó la compra.
     *
     * @param fechaCompra La fecha de la compra.
     */
    public void setFechaCompra(Calendar fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    /**
     * Obtiene el precio total de la compra.
     *
     * @return El precio total de la compra.
     */
    public double getPrecioTotal() {
        return precioTotal;
    }

    /**
     * Establece el precio total de la compra.
     *
     * @param precioTotal El precio total de la compra.
     */
    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    /**
     * Obtiene la cantidad de madera comprada.
     *
     * @return La cantidad de madera comprada.
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad de madera comprada.
     *
     * @param cantidad La cantidad de madera comprada.
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el objeto `MaderaDTO` que representa la madera comprada.
     *
     * @return El objeto `MaderaDTO` que representa la madera comprada.
     */
    public MaderaDTO getMadera() {
        return madera;
    }

    /**
     * Establece el objeto `MaderaDTO` que representa la madera comprada.
     *
     * @param madera El objeto `MaderaDTO` que representa la madera comprada.
     */
    public void setMadera(MaderaDTO madera) {
        this.madera = madera;
    }

    /**
     * Obtiene el objeto `UsuarioDTO` que representa al usuario que realizó la compra.
     *
     * @return El objeto `UsuarioDTO` que representa al usuario.
     */
    public UsuarioDTO getUsuario() {
        return usuario;
    }

    /**
     * Establece el objeto `UsuarioDTO` que representa al usuario que realizó la compra.
     *
     * @param usuario El objeto `UsuarioDTO` que representa al usuario.
     */
    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }
}

