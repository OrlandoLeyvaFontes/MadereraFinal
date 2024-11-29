/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funcionalidad;

import dto.MaderaDTO;
import interfacesDTO.IMadereraNegocio;
import interfaz.IBuscarMaderaPorNombre;
import negocio.MaderaNegocio;

/**
 *
 * @author Clark
 */
public class BuscarMaderaPorNombreSS implements IBuscarMaderaPorNombre{
IMadereraNegocio iMadereraNegocio;

    public BuscarMaderaPorNombreSS() {
        this.iMadereraNegocio=new MaderaNegocio();
    }
    
    
    
    
    @Override
    public MaderaDTO buscarMaderaPorNombre(String nombre) {
 return iMadereraNegocio.buscarMaderaPorNombre(nombre);
    }
    
}
