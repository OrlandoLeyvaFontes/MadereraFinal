/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funcionalidad;

import dto.UsuarioDTO;
import interfacesDTO.IUsuarioNegocio;
import interfazSS.IAgregarUsuarioSS;
import negocio.UsuarioNegocio;

/**
 *
 * @author Oley
 */
public class AgregarUsuarioSS implements IAgregarUsuarioSS {

    IUsuarioNegocio iUsuarioNegocio;

    public AgregarUsuarioSS() {
        this.iUsuarioNegocio = new UsuarioNegocio();
    }

    @Override
    public UsuarioDTO agregarUsuario(UsuarioDTO usuarioDTO) {
        try {
            UsuarioDTO usuarioGuardado = iUsuarioNegocio.agregarUsuario(usuarioDTO);

            if (usuarioGuardado != null) {
                return usuarioGuardado;
            } else {
                throw new RuntimeException("Error al agregar el usuario."); 
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Ocurrió un error al intentar agregar el usuario: " + e.getMessage());
        }
    }

}
