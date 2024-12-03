/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacesDAO;

import entidades.Madera;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
/**
 * Interface que define las operaciones de acceso a datos para el carrito de
 * compras. Proporciona métodos para manipular los productos en el carrito de un
 * usuario.
 */
public interface ICarritoDAO {

    /**
     * Agrega un producto al carrito de compras del usuario. Si el producto ya
     * existe en el carrito, actualiza su cantidad.
     *
     * @param usuarioId Identificador único del usuario propietario del carrito
     * @param maderaId Identificador único del producto de madera a agregar
     * @param cantidad Cantidad del producto a agregar
     */
    public void agregarProducto(ObjectId usuarioId, ObjectId maderaId, int cantidad);

    /**
     * Obtiene el carrito de compras completo de un usuario.
     *
     * @param usuarioId Identificador único del usuario
     * @return Document contiendo la información del carrito y sus productos
     */
    public Document obtenerCarrito(ObjectId usuarioId);

    /**
     * Elimina un producto específico del carrito del usuario.
     *
     * @param usuarioId Identificador único del usuario propietario del carrito
     * @param maderaId Identificador único del producto de madera a eliminar
     */
    public void eliminarProducto(ObjectId usuarioId, ObjectId maderaId);

    /**
     * Elimina todos los productos del carrito del usuario.
     *
     * @param usuarioId Identificador único del usuario propietario del carrito
     */
    public void vaciarCarrito(ObjectId usuarioId);

}
