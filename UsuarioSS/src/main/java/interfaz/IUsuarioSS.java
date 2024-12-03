/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaz;

import dto.TarjetasDTO;
import dto.UsuarioDTO;
import java.util.List;

/**
 *
 * @author Oley
 */
/**
 * Interfaz IUsuarioSS
 *
 * Define los métodos necesarios para gestionar las operaciones relacionadas con
 * los usuarios en el sistema, incluyendo inicio de sesión, registro de
 * usuarios, y manejo de tarjetas.
 */
public interface IUsuarioSS {

    /**
     * Permite iniciar sesión utilizando el correo electrónico y la contraseña
     * del usuario.
     *
     * @param correo Correo electrónico del usuario.
     * @param contrasena Contraseña del usuario.
     * @return Un objeto UsuarioDTO con los datos del usuario si las
     * credenciales son válidas, o null si las credenciales son incorrectas.
     */
    public UsuarioDTO iniciarSesion(String correo, String contrasena);

    /**
     * Registra un nuevo usuario en el sistema.
     *
     * @param usuarioDTO Objeto UsuarioDTO con los datos del usuario a
     * registrar.
     * @return El objeto UsuarioDTO correspondiente al usuario registrado.
     */
    public UsuarioDTO agregarUsuario(UsuarioDTO usuarioDTO);

    /**
     * Agrega una tarjeta al perfil de un usuario existente.
     *
     * @param usuarioId Identificador del usuario.
     * @param tarjetasDTO Objeto TarjetasDTO con los datos de la tarjeta a
     * agregar.
     * @return true si la tarjeta se agregó correctamente, false en caso
     * contrario.
     */
    public boolean agregarTarjeta(String usuarioId, TarjetasDTO tarjetasDTO);

    /**
     * Permite iniciar sesión utilizando el número de tarjeta y el CVV.
     *
     * @param numeroTarjeta Número de la tarjeta del usuario.
     * @param cvv CVV de la tarjeta.
     * @return true si las credenciales de la tarjeta son válidas, false en caso
     * contrario.
     */
    boolean iniciarSesionPorCVV(String numeroTarjeta, String cvv);

    /**
     * Obtiene una lista de números de tarjetas asociadas a un usuario.
     *
     * @param idUsuario Identificador del usuario.
     * @return Una lista de cadenas que representan los números de las tarjetas
     * del usuario.
     */
    public List<String> obtenerNumerosTarjetasPorUsuario(String idUsuario);

}
