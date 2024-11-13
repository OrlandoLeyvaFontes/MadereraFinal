/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funcionalidad;

import dto.MaderaDTO;
import interfacesDTO.IMadereraNegocio;
import interfazSS.IBuscarMaderaPorIDSS;
import negocio.MaderaNegocio;

/**
 *
 * @author Oley
 */
public class BuscarMaderaPorIDSS implements  IBuscarMaderaPorIDSS{
IMadereraNegocio iMadereraNegocio;

    public BuscarMaderaPorIDSS() {
        this.iMadereraNegocio = new MaderaNegocio();
    }




    @Override
    public MaderaDTO buscarMaderaPorId(String id) {
return  iMadereraNegocio.buscarMaderaPorId(id);
    }
    
}
