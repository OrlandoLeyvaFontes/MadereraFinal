/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaz;

import dto.CarritoDTO;
import java.util.List;

/**
 *
 * @author Oley
 */
/**
 * Interfaz ICarritoSS
 *
 * Define los métodos necesarios para gestionar el carrito de compras en el
 * sistema. Cada método está relacionado con las operaciones básicas del
 * carrito, como agregar, eliminar productos, obtener el contenido del carrito y
 * vaciarlo.
 */
public interface ICarritoSS {

    /**
     * Agrega un producto al carrito de un usuario.
     *
     * @param usuarioId Identificador del usuario propietario del carrito.
     * @param maderaId Identificador del producto (madera) que se desea agregar.
     * @param cantidad Cantidad del producto que se desea agregar.
     */
    public void agregarProducto(String usuarioId, String maderaId, int cantidad);

    /**
     * Elimina un producto del carrito de un usuario.
     *
     * @param usuarioId Identificador del usuario propietario del carrito.
     * @param maderaId Identificador del producto (madera) que se desea
     * eliminar.
     */
    public void eliminarProducto(String usuarioId, String maderaId);

    /**
     * Obtiene el contenido completo del carrito de un usuario.
     *
     * @param usuarioId Identificador del usuario propietario del carrito.
     * @return Una lista de objetos CarritoDTO que representan los productos en
     * el carrito.
     */
    public List<CarritoDTO> obtenerCarrito(String usuarioId);

    /**
     * Vacía el carrito de un usuario, eliminando todos los productos.
     *
     * @param usuarioId Identificador del usuario propietario del carrito.
     */
    public void vaciarCarrito(String usuarioId);

}
