/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaz;

import dto.CompraDTO;

/**
 *
 * @author Oley
 */
public interface ICompraSS {
        public void comprarCarrito(String usuarioId);
                    void guardarCompra(CompraDTO compraDTO);

}
