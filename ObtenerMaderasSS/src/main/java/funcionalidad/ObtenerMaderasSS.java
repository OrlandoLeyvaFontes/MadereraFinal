/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funcionalidad;

import dto.MaderaDTO;
import interfacesDTO.IMadereraNegocio;
import interfazSS.IObtenerMaderas;
import java.util.List;
import negocio.MaderaNegocio;

/**
 *
 * @author Oley
 */
public class ObtenerMaderasSS implements  IObtenerMaderas{
    IMadereraNegocio iMadereraNegocio;

    public ObtenerMaderasSS( ) {
        this.iMadereraNegocio = new MaderaNegocio();
    }

    @Override
    public List<MaderaDTO> obtenerMaderas() {
   return iMadereraNegocio.obtenerMaderas();


    
    
}
}