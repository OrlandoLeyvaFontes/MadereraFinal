/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funcionalidad;

import dto.VentaDTO;
import interfacesDTO.IVentaNegocio;
import interfaz.IObtenerVentasSS;
import java.util.List;
import negocio.VentaNegocio;

/**
 *
 * @author Oley
 */
public class ObtenerVentasSS implements  IObtenerVentasSS{
    IVentaNegocio iVentaNegocio;

    public ObtenerVentasSS( ) {
        this.iVentaNegocio = new VentaNegocio();
    }

    @Override
    public List<VentaDTO> obtenerVentas() {
return iVentaNegocio.obtenerVentas();
    }
    
    
    
}
