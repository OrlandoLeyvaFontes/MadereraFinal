/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funcionalidad;

import dto.UsuarioDTO;
import interfacesDTO.IUsuarioNegocio;
import interfazSS.IInicioSesionSS;
import negocio.UsuarioNegocio;

/**
 *
 * @author Oley
 */
public class InicioDeSesionSS implements  IInicioSesionSS{
        IUsuarioNegocio iUsuarioNegocio;

    public InicioDeSesionSS() {
        this.iUsuarioNegocio = new  UsuarioNegocio();
    }

    @Override
    public UsuarioDTO iniciarSesion(String correo, String contrasena) {
UsuarioDTO usuarioDTO=iUsuarioNegocio.iniciarSesion(correo, contrasena);
  if (usuarioDTO != null) {
            return usuarioDTO; 
        } else {
            System.out.println("Credenciales incorrectas");
            return null; 
        }
    }

}
