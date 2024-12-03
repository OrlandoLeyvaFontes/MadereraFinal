/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacesDAO;

import entidades.UsuarioVentas;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 * Interfaz que define las operaciones de acceso a datos relacionadas con la
 * entidad UsuarioVentas.
 *
 * Métodos: - agregarUsuario(UsuarioVentas usuarioVentas): Agrega un nuevo
 * usuario de ventas al sistema. - iniciarSesion(String correo): Permite iniciar
 * sesión de un usuario de ventas utilizando su correo electrónico. -
 * obtenerUsuarioPorId(ObjectId id): Recupera un usuario de ventas por su
 * identificador único (ID). - obtenerMaderasPorUsuarioVenta(ObjectId
 * idUsuarioVenta): Recupera las maderas asociadas a un usuario de ventas.
 *
 * Esta interfaz debe ser implementada por clases que gestionen las operaciones
 * sobre los usuarios de ventas en una base de datos, como por ejemplo una
 * implementación utilizando MongoDB, JPA o cualquier otro sistema.
 */
public interface IUsuarioVentasDAO {

    /**
     * Agrega un nuevo usuario de ventas al sistema.
     *
     * @param usuarioVentas El usuario de ventas que se desea agregar.
     * @return El usuario de ventas que ha sido agregado, con su ID asignado.
     */
    public UsuarioVentas agregarUsuario(UsuarioVentas usuarioVentas);

    /**
     * Permite iniciar sesión de un usuario de ventas utilizando su correo
     * electrónico.
     *
     * @param correo El correo electrónico del usuario que desea iniciar sesión.
     * @return El usuario de ventas correspondiente al correo dado, o null si no
     * existe.
     */
    public UsuarioVentas iniciarSesion(String correo);

    /**
     * Recupera un usuario de ventas por su identificador único (ID).
     *
     * @param id El ID único del usuario de ventas a recuperar.
     * @return El usuario de ventas correspondiente al ID dado, o null si no
     * existe.
     */
    public UsuarioVentas obtenerUsuarioPorId(ObjectId id);

    /**
     * Recupera las maderas asociadas a un usuario de ventas.
     *
     * @param idUsuarioVenta El ID del usuario de ventas para obtener las
     * maderas asociadas.
     * @return Una lista de documentos que representan las maderas asociadas al
     * usuario de ventas.
     */
    public List<Document> obtenerMaderasPorUsuarioVenta(ObjectId idUsuarioVenta);
}
