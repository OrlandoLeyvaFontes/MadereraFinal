/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaz;

import dto.SalidaDTO;

/**
 *
 * @author Oley
 */
public interface ISalidaSS {
     public String crearSalidaDesdeCompra(String compraId, String tipoMovimiento);  
   public SalidaDTO obtenerSalida(String salidaId) ;
}
