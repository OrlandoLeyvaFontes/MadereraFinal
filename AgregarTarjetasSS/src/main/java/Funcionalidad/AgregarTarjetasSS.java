/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funcionalidad;

import dto.TarjetasDTO;
import dto.UsuarioDTO;
import interfacesDTO.ITarjetasNegocio;
import interfazSS.IAgregarTarjetasSS;
import negocio.TarjetasNegocio;

/**
 *
 * @author Oley
 */
public class AgregarTarjetasSS implements IAgregarTarjetasSS{
ITarjetasNegocio iTarjetasNegocio;

    public AgregarTarjetasSS() {
        this.iTarjetasNegocio = new TarjetasNegocio();
    }

    @Override
    public TarjetasDTO agregarTarjetas(TarjetasDTO tarjetasDTO) {
       try {
            TarjetasDTO tarjetasDTO1 = iTarjetasNegocio.agregarTarjetas(tarjetasDTO);

            if (tarjetasDTO1 != null) {
                return tarjetasDTO1;
            } else {
                throw new RuntimeException("Error al agregar la tarjeta."); 
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Ocurrió un error al intentar agregar la tarjeta: " + e.getMessage());
        }
    }

   
   
    
}
