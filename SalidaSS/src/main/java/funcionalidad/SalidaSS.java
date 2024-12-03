/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funcionalidad;

import dto.SalidaDTO;
import interfacesDTO.ISalidaNegocio;
import interfaz.ISalidaSS;
import java.util.List;
import negocio.SalidaNegocio;

/**
 *
 * @author Oley
 */
public class SalidaSS implements  ISalidaSS{
    ISalidaNegocio  iSalidaNegocio;

    public SalidaSS( ) {
        this.iSalidaNegocio = new SalidaNegocio();
    }

    @Override
    public String crearSalidaDesdeCompra(String compraId, String tipoMovimiento) {
 return iSalidaNegocio.crearSalidaDesdeCompra(compraId, tipoMovimiento);
    }

    @Override
    public SalidaDTO obtenerSalida(String salidaId) {
return iSalidaNegocio.obtenerSalida(salidaId);

    }

    @Override
    public List<SalidaDTO> obtenerTodasLasSalidas() {
return iSalidaNegocio.obtenerTodasLasSalidas();
    }
    
    
    
    
    
    
    
    
}
