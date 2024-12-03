/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfacesDTO;

import dto.TarjetasDTO;
import dto.UsuarioDTO;
import entidades.Usuario;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
/**
 * Interfaz para manejar las operaciones relacionadas con los usuarios y sus
 * tarjetas en el sistema.
 */
public interface IUsuarioNegocio {

    /**
     * Agrega un nuevo usuario al sistema.
     *
     * @param usuarioDTO El objeto que contiene los detalles del usuario a
     * agregar.
     * @return El objeto `UsuarioDTO` que ha sido agregado.
     */
    public UsuarioDTO agregarUsuario(UsuarioDTO usuarioDTO);

    /**
     * Agrega una tarjeta a un usuario específico.
     *
     * @param usuarioId El ID del usuario al que se le agregará la tarjeta.
     * @param tarjetasDTO El objeto que contiene los detalles de la tarjeta a
     * agregar.
     * @return `true` si la tarjeta se agrega correctamente, `false` en caso
     * contrario.
     */
    public boolean agregarTarjeta(String usuarioId, TarjetasDTO tarjetasDTO);

    /**
     * Inicia sesión de un usuario utilizando su correo y contraseña.
     *
     * @param correo El correo del usuario.
     * @param contrasena La contraseña del usuario.
     * @return El objeto `UsuarioDTO` si las credenciales son correctas, `null`
     * en caso contrario.
     */
    public UsuarioDTO iniciarSesion(String correo, String contrasena);

    /**
     * Obtiene los números de tarjeta asociados a un usuario.
     *
     * @param idUsuario El ID del usuario para obtener las tarjetas.
     * @return Una lista de números de tarjeta asociadas al usuario.
     */
    public List<String> obtenerNumerosTarjetasPorUsuario(String idUsuario);

    /**
     * Inicia sesión utilizando el número de tarjeta y el CVV.
     *
     * @param numeroTarjeta El número de tarjeta para iniciar sesión.
     * @param cvv El CVV de la tarjeta.
     * @return `true` si las credenciales son correctas, `false` en caso
     * contrario.
     */

    boolean iniciarSesionPorCVV(String numeroTarjeta, String cvv);

}
