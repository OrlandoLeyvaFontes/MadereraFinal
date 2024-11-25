/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funcionalidad;

import interfacesDTO.ICarritoNegocio;
import interfaz.IEliminarProductoCarritoSS;
import negocio.CarritoNegocio;

/**
 *
 * @author Oley
 */
public class EliminarProductoCarritoSS implements IEliminarProductoCarritoSS {

    ICarritoNegocio iCarritoNegocio;
    
    public EliminarProductoCarritoSS() {
        this.iCarritoNegocio = new CarritoNegocio();
    }
    
    @Override
    public void eliminarProducto(String usuarioId, String maderaId) {
        iCarritoNegocio.eliminarProducto(usuarioId, maderaId);
    }
    
}
