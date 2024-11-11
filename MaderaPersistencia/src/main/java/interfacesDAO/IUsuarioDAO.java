/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacesDAO;

import entidades.Usuario;

/**
 *
 * @author Oley
 */
public interface IUsuarioDAO {
    public Usuario agregarUsuario(Usuario usuario);
     public Usuario iniciarSesion(String correo, String contrasena);
}
