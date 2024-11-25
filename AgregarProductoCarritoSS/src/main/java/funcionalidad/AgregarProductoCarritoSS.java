/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funcionalidad;

import interfacesDTO.ICarritoNegocio;
import interfaz.IAgregarProductoCarritoSS;
import negocio.CarritoNegocio;

/**
 *
 * @author Oley
 */
public class AgregarProductoCarritoSS implements IAgregarProductoCarritoSS{
ICarritoNegocio iCarritoNegocio; 

    public AgregarProductoCarritoSS( ) {
        this.iCarritoNegocio = new CarritoNegocio();
    }

   
    @Override
    public void agregarProducto(String usuarioId, String maderaId, int cantidad) {
iCarritoNegocio.agregarProducto(usuarioId, maderaId, cantidad);;
    }
    
}
