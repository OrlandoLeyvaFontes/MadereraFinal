/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacesDTO;

import dto.CompraDTO;
import entidades.Compra;
import java.util.List;

/**
 *
 * @author Oley
 */
/**
 * Interfaz que define los métodos necesarios para manejar las compras dentro
 * del sistema. Esta interfaz se utiliza para realizar operaciones de compra,
 * como guardar una compra, procesar compras desde el carrito de un usuario, y
 * recuperar el historial de compras de un usuario.
 */
public interface ICompraNegocio {

    /**
     * Guarda la información de una compra en el sistema. Este método guarda los
     * detalles de una compra realizada, como los productos comprados,
     * cantidades, precios, y el comprador asociado a la compra.
     *
     * @param compraDTO El objeto que contiene los detalles de la compra a
     * guardar. Este objeto debe incluir información como la madera
     * seleccionada, cantidad, el comprador, etc.
     * @return Una cadena de texto que indica el estado de la operación, como un
     * mensaje de éxito ("Compra guardada correctamente") o un mensaje de error
     * si ocurre un problema al guardar.
     */
    String guardarCompra(CompraDTO compraDTO);

    /**
     * Realiza la compra de los artículos presentes en el carrito del usuario.
     * Este método procesa todos los productos que están en el carrito de
     * compras de un usuario, y completa la compra de dichos productos.
     *
     * @param usuarioId El ID único del usuario que está realizando la compra.
     * Este parámetro se usa para acceder al carrito de compras del usuario y
     * procesar la compra.
     * @return Una lista de cadenas que contiene el estado de la compra. Los
     * mensajes en la lista pueden incluir detalles sobre la compra realizada, o
     * cualquier error que haya ocurrido durante el proceso de compra.
     */
    public List<String> comprarCarrito(String usuarioId);

    /**
     * Recupera el historial de compras de un usuario específico. Este método
     * devuelve todas las compras realizadas por un usuario, proporcionando
     * detalles sobre cada compra, como los productos comprados, fechas de
     * compra, cantidades, etc.
     *
     * @param usuarioId El ID único del usuario cuyo historial de compras se
     * desea obtener. Este parámetro permite recuperar solo las compras
     * correspondientes a un usuario específico.
     * @return Una lista de objetos CompraDTO que representan el historial de
     * compras del usuario. Cada objeto contiene detalles sobre una compra
     * realizada, como los productos comprados, el comprador, la fecha de la
     * compra, etc.
     */
    public List<CompraDTO> obtenerHistorialCompras(String usuarioId);
}
