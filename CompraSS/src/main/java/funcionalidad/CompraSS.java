/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funcionalidad;

import dto.CompraDTO;
import interfacesDTO.ICompraNegocio;
import interfaz.ICompraSS;
import negocio.CompraNegocio;

/**
 *
 * @author Oley
 */
public class CompraSS implements ICompraSS{
  ICompraNegocio iCompraNegocio;

    public CompraSS( ) {
        this.iCompraNegocio = new CompraNegocio();
    }

    @Override
    public void comprarCarrito(String usuarioId) {
iCompraNegocio.comprarCarrito(usuarioId);
    }

    @Override
    public void guardarCompra(CompraDTO compraDTO) {
iCompraNegocio.guardarCompra(compraDTO);
    }
  
}
