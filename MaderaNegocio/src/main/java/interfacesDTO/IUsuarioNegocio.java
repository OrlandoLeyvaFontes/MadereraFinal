/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfacesDTO;

import dto.UsuarioDTO;
import entidades.Usuario;

/**
 *
 * @author Oley
 */
public interface IUsuarioNegocio {

    public UsuarioDTO agregarUsuario(UsuarioDTO usuarioDTO);

    public UsuarioDTO iniciarSesion(String correo, String contrasena);
}
