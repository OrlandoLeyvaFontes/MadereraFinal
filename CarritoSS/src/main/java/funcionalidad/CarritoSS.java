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
public class CarritoSS implements ICarritoSS {

    ICarritoNegocio iCarritoNegocio;    
    
    public CarritoSS() {
        this.iCarritoNegocio = new CarritoNegocio();
    }
    
    @Override
    public void agregarProducto(String usuarioId, String maderaId, int cantidad) {
        iCarritoNegocio.agregarProducto(usuarioId, maderaId, cantidad);;
    }
    
    @Override
    public void eliminarProducto(String usuarioId, String maderaId) {
        iCarritoNegocio.eliminarProducto(usuarioId, maderaId);
    }
    
    @Override
    public List<CarritoDTO> obtenerCarrito(String usuarioId) {
        return iCarritoNegocio.obtenerCarrito(usuarioId);
    }
    
    @Override
    public void vaciarCarrito(String usuarioId) {
        iCarritoNegocio.vaciarCarrito(usuarioId);
    }
    
}
