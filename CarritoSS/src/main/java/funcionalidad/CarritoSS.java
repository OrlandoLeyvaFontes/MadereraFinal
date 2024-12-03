/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funcionalidad;

import dto.CarritoDTO;
import interfacesDTO.ICarritoNegocio;
import interfaz.ICarritoSS;
import java.util.List;
import negocio.CarritoNegocio;

/**
 *
 * @author Oley
 */
/**
 * Implementación del servicio de carrito de compras (CarritoSS).
 * Esta clase actúa como un intermediario entre la capa de presentación (por ejemplo, controladores o servicios web) y la capa de negocio
 * donde se gestionan las operaciones de carrito.
 * Implementa la interfaz ICarritoSS para proporcionar las funcionalidades básicas relacionadas con el carrito.
 */
public class CarritoSS implements ICarritoSS {
    // Instancia de la capa de negocio para interactuar con la lógica de carrito

    ICarritoNegocio iCarritoNegocio;    
    /**
     * Constructor de la clase CarritoSS.
     * Inicializa la instancia de la capa de negocio (CarritoNegocio) que contiene la lógica de negocio.
     */
    public CarritoSS() {
        this.iCarritoNegocio = new CarritoNegocio();
    }
    /**
     * Agrega un producto al carrito de un usuario.
     * 
     * @param usuarioId El identificador único del usuario.
     * @param maderaId El identificador único de la madera (producto).
     * @param cantidad La cantidad del producto que se desea agregar.
     */
    @Override
    public void agregarProducto(String usuarioId, String maderaId, int cantidad) {
        iCarritoNegocio.agregarProducto(usuarioId, maderaId, cantidad);;
    }
     /**
     * Elimina un producto del carrito de un usuario.
     * 
     * @param usuarioId El identificador único del usuario.
     * @param maderaId El identificador único de la madera (producto) que se desea eliminar.
     */
    @Override
    public void eliminarProducto(String usuarioId, String maderaId) {
        iCarritoNegocio.eliminarProducto(usuarioId, maderaId);
    }
    /**
     * Obtiene todos los productos en el carrito de un usuario.
     * 
     * @param usuarioId El identificador único del usuario.
     * @return Una lista de objetos CarritoDTO que representan los productos en el carrito.
     */
    @Override
    public List<CarritoDTO> obtenerCarrito(String usuarioId) {
        return iCarritoNegocio.obtenerCarrito(usuarioId);
    }
    /**
     * Vacía el carrito de un usuario, eliminando todos los productos.
     * 
     * @param usuarioId El identificador único del usuario cuyo carrito se desea vaciar.
     */
    @Override
    public void vaciarCarrito(String usuarioId) {
        iCarritoNegocio.vaciarCarrito(usuarioId);
    }
    
}
