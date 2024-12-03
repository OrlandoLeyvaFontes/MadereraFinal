/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacesDTO;

import dto.SalidaDTO;
import java.util.List;

/**
 *
 * @author Oley
 */
public interface ISalidaNegocio {
  public String crearSalidaDesdeCompra(String compraId, String tipoMovimiento);  
   public SalidaDTO obtenerSalida(String salidaId) ;
    public List<SalidaDTO> obtenerTodasLasSalidas();
}
