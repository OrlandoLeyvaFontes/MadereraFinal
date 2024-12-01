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
public interface ICarritoSS {
                public void agregarProducto(String usuarioId, String maderaId, int cantidad);
    public void eliminarProducto(String usuarioId, String maderaId);
public List<CarritoDTO> obtenerCarrito(String usuarioId);
public void vaciarCarrito(String usuarioId);

}
