/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacesDAO;

import entidades.Madera;
import entidades.Usuario;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
/**
 * Interface que define las operaciones de acceso a datos para los productos de
 * madera. Proporciona métodos para gestionar el inventario y la información de
 * los productos de madera.
 */
public interface IMaderaDAO {

    /**
     * Agrega un nuevo producto de madera al sistema.
     *
     * @param madera Objeto Madera con la información del nuevo producto
     * @return Madera El producto agregado con su ID asignado
     */
    public Madera agregarMadera(Madera madera);

    /**
     * Obtiene la lista completa de productos de madera disponibles.
     *
     * @return List<Madera> Lista de todos los productos de madera
     */
    public List<Madera> obtenerMaderas();

    /**
     * Busca un producto de madera por su identificador en formato String.
     *
     * @param id Identificador del producto en formato String
     * @return Madera El producto encontrado o null si no existe
     */
    public Madera buscarMaderaPorId(String id);

    /**
     * Obtiene un producto de madera por su identificador ObjectId.
     *
     * @param id Identificador del producto como ObjectId
     * @return Madera El producto encontrado o null si no existe
     */
    public Madera obtenerMaderaPorId(ObjectId id);

    /**
     * Actualiza la información de un producto de madera existente.
     *
     * @param madera Objeto Madera con la información actualizada
     */
    public void actualizar(Madera madera);

    /**
     * Obtiene la lista de productos de madera asociados a un usuario vendedor.
     *
     * @param idUsuarioVenta Identificador del usuario vendedor
     * @return List<Madera> Lista de productos de madera del vendedor
     */
    public List<Madera> obtenerMaderasPorUsuarioVenta(ObjectId idUsuarioVenta);

    /**
     * Busca un producto de madera por su nombre.
     *
     * @param nombre Nombre del producto a buscar
     * @return Madera El producto encontrado o null si no existe
     */
    public Madera buscarMaderaPorNombre(String nombre);

    /**
     * Modifica la información de un producto de madera existente.
     *
     * @param madera Objeto Madera con la nueva información
     */
    public void editarMadera(Madera madera);

    /**
     * Elimina un producto de madera del sistema.
     *
     * @param id Identificador del producto a eliminar
     * @return boolean true si se eliminó correctamente, false en caso contrario
     */
    public boolean eliminarMadera(String id);

}
