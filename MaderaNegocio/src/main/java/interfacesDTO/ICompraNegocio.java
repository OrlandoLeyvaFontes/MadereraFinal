/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacesDTO;

import dto.CompraDTO;
import entidades.Compra;
import java.util.List;

/**
 *
 * @author Oley
 */
public interface ICompraNegocio {
                void guardarCompra(CompraDTO compraDTO);
public void comprarCarrito(String usuarioId);
public List<CompraDTO> obtenerHistorialCompras(String usuarioId);
}
