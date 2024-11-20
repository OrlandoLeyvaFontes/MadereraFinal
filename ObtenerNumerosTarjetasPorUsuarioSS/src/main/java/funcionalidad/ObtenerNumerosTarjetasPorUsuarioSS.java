/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funcionalidad;

import interfacesDTO.IUsuarioNegocio;
import interfaz.IObtenerNumerosTarjetasPorUsuarioSS;
import java.util.List;
import negocio.UsuarioNegocio;

/**
 *
 * @author Oley
 */
public class ObtenerNumerosTarjetasPorUsuarioSS implements  IObtenerNumerosTarjetasPorUsuarioSS{
        IUsuarioNegocio iUsuarioNegocio;

    public ObtenerNumerosTarjetasPorUsuarioSS( ) {
        this.iUsuarioNegocio = new UsuarioNegocio();
    }

    @Override
    public List<String> obtenerNumerosTarjetasPorUsuario(String idUsuario) {
 return iUsuarioNegocio.obtenerNumerosTarjetasPorUsuario(idUsuario);

    }
    
}
