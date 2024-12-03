/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funcionalidad;

import dto.CompraDTO;
import interfacesDTO.ICompraNegocio;
import interfaz.ICompraSS;
import java.util.List;
import negocio.CompraNegocio;

/**
 *
 * @author Oley
 */
/**
 * Clase CompraSS
 *
 * Implementa la interfaz ICompraSS y actúa como la capa de servicio encargada
 * de interactuar con la capa de negocio (CompraNegocio) para gestionar las
 * compras de los usuarios.
 */
public class CompraSS implements ICompraSS {

    ICompraNegocio iCompraNegocio;

    /**
     * Constructor por defecto. Inicializa la instancia de ICompraNegocio como
     * una nueva instancia de CompraNegocio.
     */
    public CompraSS() {
        this.iCompraNegocio = new CompraNegocio();
    }
/**
     * Guarda una compra en el sistema.
     *
     * @param compraDTO Objeto CompraDTO que contiene los detalles de la compra a guardar.
     * @return Un mensaje indicando el resultado de la operación (por ejemplo, éxito o error).
     */
    @Override
    public String guardarCompra(CompraDTO compraDTO) {
        return iCompraNegocio.guardarCompra(compraDTO);
    }
 /**
     * Obtiene el historial de compras de un usuario específico.
     *
     * @param usuarioId Identificador del usuario cuyo historial de compras se desea obtener.
     * @return Una lista de objetos CompraDTO que representan las compras realizadas por el usuario.
     */
    @Override
    public List<CompraDTO> obtenerHistorialCompras(String usuarioId) {
        return iCompraNegocio.obtenerHistorialCompras(usuarioId);

    }
/**
     * Realiza la compra de todos los productos en el carrito de un usuario.
     *
     * @param usuarioId Identificador del usuario que desea comprar los productos de su carrito.
     * @return Una lista de cadenas con mensajes o detalles de la transacción realizada.
     */
    @Override
    public List<String> comprarCarrito(String usuarioId) {
        return iCompraNegocio.comprarCarrito(usuarioId);
    }

}
