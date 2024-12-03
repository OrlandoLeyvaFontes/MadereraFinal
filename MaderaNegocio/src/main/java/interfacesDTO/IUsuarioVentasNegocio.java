/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacesDTO;

import dto.UsuarioVentasDTO;
import entidades.Madera;
import java.util.List;
import org.bson.Document;

/**
 * Interface que define los métodos para gestionar las operaciones relacionadas
 * con los usuarios de ventas. Esta interfaz es implementada por la clase que
 * maneja la lógica de negocio de los usuarios de ventas.
 *
 * @author aleja
 */
public interface IUsuarioVentasNegocio {

    /**
     * Agrega un nuevo usuario de ventas a la base de datos.
     *
     * Este método toma un objeto UsuarioVentasDTO, encripta la contraseña del
     * usuario y guarda los datos en la base de datos. Luego, retorna un
     * UsuarioVentasDTO con los datos del usuario recién creado.
     *
     * @param usuarioVentasDTO Objeto DTO con los datos del usuario a agregar.
     * @return UsuarioVentasDTO El objeto DTO del usuario que se ha agregado.
     */
    public UsuarioVentasDTO agregarUsuario(UsuarioVentasDTO usuarioVentasDTO);

    /**
     * Inicia sesión para un usuario de ventas con las credenciales
     * proporcionadas.
     *
     * Este método recibe el correo y la contraseña del usuario, busca al
     * usuario en la base de datos, y valida si la contraseña ingresada coincide
     * con la contraseña almacenada. Si las credenciales son correctas, se
     * retorna un UsuarioVentasDTO con los datos del usuario.
     *
     * @param correo Correo electrónico del usuario.
     * @param contrasena Contraseña del usuario.
     * @return UsuarioVentasDTO El objeto DTO con los datos del usuario si las
     * credenciales son válidas.
     * @throws RuntimeException Si las credenciales no son correctas o el
     * usuario no se encuentra.
     */
    public UsuarioVentasDTO iniciarSesion(String correo, String contrasena);

    /**
     * Obtiene un usuario de ventas de la base de datos usando su identificador
     * único.
     *
     * Este método toma un ID de usuario (en formato String), lo convierte a
     * ObjectId y consulta la base de datos para obtener los detalles del
     * usuario correspondiente. Si el usuario no es encontrado, se lanza una
     * excepción.
     *
     * @param id Identificador único del usuario de ventas.
     * @return UsuarioVentasDTO El objeto DTO con los datos del usuario
     * correspondiente.
     * @throws RuntimeException Si el usuario no se encuentra en la base de
     * datos.
     */
    public UsuarioVentasDTO obtenerUsuarioPorId(String id);
}
