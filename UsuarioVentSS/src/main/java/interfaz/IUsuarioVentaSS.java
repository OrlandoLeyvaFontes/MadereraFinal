/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaz;

import dto.UsuarioVentasDTO;



/**
 *
 * @author aleja
 */
public interface IUsuarioVentaSS {

    public UsuarioVentasDTO agregarUsuario(UsuarioVentasDTO usuarioDTO);

    public UsuarioVentasDTO iniciarSesion(String correo, String contrasena);
}
