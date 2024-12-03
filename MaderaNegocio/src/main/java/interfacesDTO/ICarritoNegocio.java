/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacesDTO;

import dto.CarritoDTO;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
/**
 * Interface que define las operaciones de negocio para el carrito de compras.
 * Define los métodos necesarios para gestionar el carrito de compras desde la
 * capa de presentación.
 */
public interface ICarritoNegocio {

    /**
     * Agrega un producto al carrito de un usuario.
     *
     * @param usuarioId ID del usuario en formato String
     * @param maderaId ID del producto de madera en formato String
     * @param cantidad Cantidad del producto a agregar
     * @throws IllegalArgumentException si la cantidad no es válida
     */
    public void agregarProducto(String usuarioId, String maderaId, int cantidad);

    /**
     * Obtiene el contenido del carrito de un usuario.
     *
     * @param usuarioId ID del usuario en formato String
     * @return Lista de CarritoDTO con la información de los productos en el
     * carrito
     * @throws IllegalArgumentException si el ID de usuario no es válido
     * @throws RuntimeException si no se encuentra el carrito
     */
    public List<CarritoDTO> obtenerCarrito(String usuarioId);

    /**
     * Elimina un producto específico del carrito de un usuario.
     *
     * @param usuarioId ID del usuario en formato String
     * @param maderaId ID del producto de madera a eliminar en formato String
     */
    public void eliminarProducto(String usuarioId, String maderaId);

    /**
     * Elimina todos los productos del carrito de un usuario.
     *
     * @param usuarioId ID del usuario en formato String
     * @throws IllegalArgumentException si el ID de usuario no es válido
     */
    public void vaciarCarrito(String usuarioId);
}
