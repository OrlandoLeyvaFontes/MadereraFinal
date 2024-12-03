/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaz;

import dto.CompraDTO;
import java.util.List;

/**
 *
 * @author Oley
 */
/**
 * Interfaz ICompraSS
 *
 * Proporciona los métodos necesarios para gestionar las compras en el sistema,
 * incluyendo la compra de productos del carrito, el registro de nuevas compras
 * y la obtención del historial de compras de un usuario.
 */
public interface ICompraSS {

    /**
     * Realiza la compra de todos los productos que se encuentran en el carrito
     * de un usuario.
     *
     * @param usuarioId Identificador del usuario que desea realizar la compra.
     * @return Una lista de cadenas que contienen mensajes o detalles del
     * resultado de la transacción.
     */
    public List<String> comprarCarrito(String usuarioId);

    /**
     * Guarda los detalles de una compra en el sistema.
     *
     * @param compraDTO Objeto CompraDTO que contiene la información de la
     * compra a registrar.
     * @return Una cadena que indica el resultado de la operación, como éxito o
     * error.
     */
    String guardarCompra(CompraDTO compraDTO);

    /**
     * Obtiene el historial de compras realizadas por un usuario específico.
     *
     * @param usuarioId Identificador del usuario cuyo historial de compras se
     * desea consultar.
     * @return Una lista de objetos CompraDTO que representan las compras
     * realizadas por el usuario.
     */
    public List<CompraDTO> obtenerHistorialCompras(String usuarioId);

}
