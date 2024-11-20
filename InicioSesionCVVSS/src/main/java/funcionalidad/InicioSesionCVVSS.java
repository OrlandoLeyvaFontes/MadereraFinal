/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funcionalidad;

import interfacesDTO.IUsuarioNegocio;
import interfaz.IInicioSesionCVVSS;
import negocio.UsuarioNegocio;

/**
 *
 * @author Oley
 */
public class InicioSesionCVVSS implements IInicioSesionCVVSS{
    IUsuarioNegocio iUsuarioNegocio;

    public InicioSesionCVVSS( ) {
        this.iUsuarioNegocio = new UsuarioNegocio();
    }

    @Override
    public boolean iniciarSesionPorCVV(String cvv) {
return iUsuarioNegocio.iniciarSesionPorCVV(cvv);
    }
    
}
