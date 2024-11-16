/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funcionalidad;

import dto.TarjetasDTO;
import dto.UsuarioDTO;
import interfacesDTO.ITarjetasNegocio;
import interfacesDTO.IUsuarioNegocio;
import interfazSS.IAgregarTarjetasSS;
import negocio.TarjetasNegocio;
import negocio.UsuarioNegocio;

/**
 *
 * @author Oley
 */
public class AgregarTarjetasSS implements IAgregarTarjetasSS {

    IUsuarioNegocio iUsuarioNegocio;

    public AgregarTarjetasSS() {
        this.iUsuarioNegocio = new UsuarioNegocio();
    }

    @Override
    public boolean agregarTarjeta(String usuarioId, TarjetasDTO tarjetasDTO) {
        return iUsuarioNegocio.agregarTarjeta(usuarioId, tarjetasDTO);

    }

}
