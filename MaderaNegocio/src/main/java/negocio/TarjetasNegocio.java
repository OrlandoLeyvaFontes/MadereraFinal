/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dao.TarjetasDAO;
import dto.TarjetasDTO;
import entidades.Tarjetas;
import interfacesDAO.ITarjetasDAO;
import interfacesDTO.ITarjetasNegocio;

/**
 *
 * @author Oley
 */
public class TarjetasNegocio implements ITarjetasNegocio{
private ITarjetasDAO iTarjetasDAO;

    public TarjetasNegocio() {
        this.iTarjetasDAO = new TarjetasDAO();
    }

    @Override
    public TarjetasDTO agregarTarjetas(TarjetasDTO tarjetasDTO) {
Tarjetas tarjetas=new Tarjetas();
tarjetas.setNombre(tarjetasDTO.getNombre());
tarjetas.setNumero(tarjetasDTO.getNumero());
tarjetas.setFehcaVencimiento(tarjetasDTO.getFehcaVencimiento());
tarjetas.setCVV(tarjetasDTO.getCVV());
Tarjetas tarjetas1= iTarjetasDAO.agregarTarjetas(tarjetas);
if(tarjetas1!=null){
    TarjetasDTO   tarjetasDTO1=new TarjetasDTO();
    tarjetasDTO1.setNombre(tarjetas1.getNombre());
    tarjetasDTO1.setNumero(tarjetas1.getNumero());
    tarjetasDTO1.setFehcaVencimiento(tarjetas1.getFehcaVencimiento());
    tarjetasDTO1.setCVV(tarjetas1.getCVV());
    return tarjetasDTO1;
     } else {
            throw new RuntimeException("Error al agregar la tarjeta, intentelo más tarde");
        }
    
}

    
    
}
