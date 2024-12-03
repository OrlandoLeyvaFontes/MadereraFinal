/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaz;

import dto.UsuarioVentasDTO;

/**
 * Interfaz que define los métodos relacionados con la gestión de usuarios en el
 * sistema de ventas. Estos métodos permiten agregar un usuario nuevo y
 * gestionar el inicio de sesión de los usuarios.
 *
 * @author aleja
 */
public interface IUsuarioVentaSS {

    /**
     * Método para agregar un nuevo usuario en el sistema de ventas. Este método
     * permite registrar un usuario con los datos proporcionados en un objeto
     * UsuarioVentasDTO.
     *
     * @param usuarioDTO Objeto de tipo UsuarioVentasDTO que contiene la
     * información del usuario a agregar.
     * @return UsuarioVentasDTO Objeto que contiene los datos del usuario
     * agregado.
     * @throws RuntimeException Si ocurre un error al agregar el usuario.
     */
    public UsuarioVentasDTO agregarUsuario(UsuarioVentasDTO usuarioDTO);

    /**
     * Método para iniciar sesión en el sistema. Este método recibe el correo
     * electrónico y la contraseña del usuario, y devuelve los detalles del
     * usuario si las credenciales son correctas.
     *
     * @param correo Correo electrónico del usuario.
     * @param contrasena Contraseña del usuario.
     * @return UsuarioVentasDTO Objeto que contiene los datos del usuario si las
     * credenciales son válidas.
     * @throws RuntimeException Si las credenciales no son válidas o ocurre un
     * error en el proceso de inicio de sesión.
     */
    public UsuarioVentasDTO iniciarSesion(String correo, String contrasena);
}
