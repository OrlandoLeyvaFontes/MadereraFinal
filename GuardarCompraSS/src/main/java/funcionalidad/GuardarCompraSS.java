/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funcionalidad;

import dto.CompraDTO;
import interfacesDTO.ICompraNegocio;
import interfaz.IGuardarCompraSS;
import negocio.CompraNegocio;

/**
 *
 * @author Oley
 */
public class GuardarCompraSS implements  IGuardarCompraSS{
ICompraNegocio iCompraNegocio;

    public GuardarCompraSS( ) {
        this.iCompraNegocio = new CompraNegocio();
    }


    @Override
    public void guardarCompra(CompraDTO compraDTO) {
iCompraNegocio.guardarCompra(compraDTO);
    }
    
}
