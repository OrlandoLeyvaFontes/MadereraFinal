/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacesDAO;

import entidades.Compra;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
/**
 * Interface que define las operaciones de acceso a datos para las compras.
 * Proporciona métodos para gestionar las compras de productos y su historial.
 */
public interface ICompraDAO {

    /**
     * Guarda una nueva compra en la base de datos.
     *
     * @param compra Objeto Compra con la información completa de la transacción
     */
    void guardarCompra(Compra compra);

    /**
     * Procesa la compra de todos los productos en el carrito de un usuario.
     * Convierte los productos del carrito en una compra finalizada.
     *
     * @param usuarioId Identificador único del usuario que realiza la compra
     */
    public void comprarCarrito(ObjectId usuarioId);

    /**
     * Obtiene el historial completo de compras realizadas por un usuario.
     *
     * @param usuarioId Identificador único del usuario
     * @return Lista de Documents conteniendo la información de cada compra
     */
    public List<Document> obtenerHistorialCompras(ObjectId usuarioId);

    /**
     * Recupera la información detallada de una compra específica.
     *
     * @param compraId Identificador único de la compra en formato String
     * @return Document conteniendo los detalles de la compra solicitada
     */
    public Document obtenerCompraPorId(String compraId);
}
