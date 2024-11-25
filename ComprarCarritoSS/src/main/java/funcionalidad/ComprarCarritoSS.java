/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funcionalidad;

import interfacesDTO.ICompraNegocio;
import interfaz.IComprarCarritoSS;
import negocio.CompraNegocio;

/**
 *
 * @author Oley
 */
public class ComprarCarritoSS implements  IComprarCarritoSS{
ICompraNegocio iCompraNegocio;

    public ComprarCarritoSS( ) {
        this.iCompraNegocio = new CompraNegocio();
    }



    @Override
    public void comprarCarrito(String usuarioId) {
iCompraNegocio.comprarCarrito(usuarioId);
    }
    
}
