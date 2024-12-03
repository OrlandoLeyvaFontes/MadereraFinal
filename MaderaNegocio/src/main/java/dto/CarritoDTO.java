/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import entidades.Madera;
import entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
/**
 * Clase que representa un carrito de compras de un usuario, incluyendo los
 * productos (maderas), las cantidades de cada producto, y el total de la
 * compra.
 */
public class CarritoDTO {

    private String id;                   
    private UsuarioDTO usuarioDTO;        
    private List<MaderaDTO> maderasDTO;   
    private List<Integer> cantidades;     
    private double total;                 

    /**
     * Constructor vacío para crear un carrito vacío.
     */
    public CarritoDTO() {
        this.maderasDTO = new ArrayList<>();
        this.cantidades = new ArrayList<>();
        this.total = 0.0;
    }

    /**
     * Constructor que inicializa el carrito con un usuario.
     *
     * @param usuarioDTO El usuario propietario del carrito.
     */
    public CarritoDTO(UsuarioDTO usuarioDTO) {
        this.usuarioDTO = usuarioDTO;
        this.maderasDTO = new ArrayList<>();
        this.cantidades = new ArrayList<>();
        this.total = 0.0;
    }

    /**
     * Obtiene el identificador del carrito.
     *
     * @return El ID del carrito.
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el identificador del carrito.
     *
     * @param id El ID del carrito.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene el usuario que posee el carrito.
     *
     * @return El objeto `UsuarioDTO` asociado al carrito.
     */
    public UsuarioDTO getUsuarioDTO() {
        return usuarioDTO;
    }

    /**
     * Establece el usuario que posee el carrito.
     *
     * @param usuarioDTO El objeto `UsuarioDTO` que representa al usuario.
     */
    public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
        this.usuarioDTO = usuarioDTO;
    }

    /**
     * Obtiene la lista de maderas en el carrito.
     *
     * @return Una lista de objetos `MaderaDTO` que representan las maderas en
     * el carrito.
     */
    public List<MaderaDTO> getMaderasDTO() {
        return maderasDTO;
    }

    /**
     * Establece la lista de maderas en el carrito.
     *
     * @param maderasDTO La lista de objetos `MaderaDTO` a establecer.
     */
    public void setMaderasDTO(List<MaderaDTO> maderasDTO) {
        this.maderasDTO = maderasDTO;
    }

    /**
     * Obtiene la lista de cantidades de cada madera en el carrito.
     *
     * @return Una lista de enteros que representa las cantidades de cada
     * madera.
     */
    public List<Integer> getCantidades() {
        return cantidades;
    }

    /**
     * Establece la lista de cantidades de las maderas en el carrito.
     *
     * @param cantidades La lista de enteros de cantidades de cada madera.
     */
    public void setCantidades(List<Integer> cantidades) {
        this.cantidades = cantidades;
    }

    /**
     * Obtiene el total de la compra.
     *
     * @return El total calculado de la compra.
     */
    public double getTotal() {
        return total;
    }

    /**
     * Establece el total de la compra.
     *
     * @param total El total de la compra.
     */
    public void setTotal(double total) {
        this.total = total;
    }
}
