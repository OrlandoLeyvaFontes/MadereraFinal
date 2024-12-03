/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacesDAO;

import entidades.Tarjetas;
import entidades.Usuario;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
/**
 * Interface que define las operaciones de acceso a datos para los usuarios.
 * Proporciona métodos para gestionar usuarios, autenticación y métodos de pago.
 * medidas de seguridad apropiadas.
 */
public interface IUsuarioDAO {
 /**
     * Registra un nuevo usuario en el sistema.
     * 
     * @param usuario Objeto Usuario con la información del nuevo usuario
     * @return Usuario El usuario creado con su ID asignado
     */
    public Usuario agregarUsuario(Usuario usuario);
 /**
     * Valida las credenciales de un usuario para el inicio de sesión.
     * 
     * @param correo Correo electrónico del usuario
     * @param contrasena Contraseña del usuario
     * @return Usuario Objeto con la información del usuario si las credenciales son válidas, null en caso contrario
     */
    public Usuario iniciarSesion(String correo, String contrasena);
 /**
     * Asocia una nueva tarjeta de pago a un usuario existente.
     * 
     * @param usuarioId Identificador del usuario
     * @param tarjeta Objeto Tarjetas con la información de la nueva tarjeta
     * @return boolean true si la tarjeta se agregó correctamente, false en caso contrario
     */
    public boolean agregarTarjeta(ObjectId usuarioId, Tarjetas tarjeta);
 /**
     * Obtiene los números de tarjeta asociados a un usuario.
     * Por seguridad, se recomienda retornar solo los últimos dígitos o versiones enmascaradas.
     * 
     * @param idUsuario Identificador del usuario
     * @return List<String> Lista de números de tarjeta del usuario
     */
    public List<String> obtenerNumerosTarjetasPorUsuario(ObjectId idUsuario);
/**
     * Recupera la información de un usuario por su identificador.
     * 
     * @param id Identificador del usuario
     * @return Usuario Objeto con la información del usuario
     */
    public Usuario obtenerUsuarioPorId(ObjectId id);
 /**
     * Valida las credenciales de una tarjeta para el inicio de sesión alternativo.
     * 
     * @param numero Número de la tarjeta
     * @param cvv Código de seguridad de la tarjeta
     * @return boolean true si las credenciales son válidas, false en caso contrario
     */
 public boolean iniciarSesionPorCVV(String numero, String cvv);
 /**
     * Busca un usuario por su correo electrónico.
     * 
     * @param correo Correo electrónico del usuario
     * @return Usuario Objeto con la información del usuario si existe, null en caso contrario
     */
 public Usuario buscarPorCorreo(String correo);
}
