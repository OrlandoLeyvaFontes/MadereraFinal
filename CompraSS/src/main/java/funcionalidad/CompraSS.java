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
    public String guardarCompra(CompraDTO compraDTO) {
return iCompraNegocio.guardarCompra(compraDTO);
    }

    @Override
    public List<CompraDTO> obtenerHistorialCompras(String usuarioId) {
     return iCompraNegocio.obtenerHistorialCompras(usuarioId);   
    
    }
  
}
