/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dao.MaderaDAO;
import dao.UsuarioDAO;
import dto.MaderaDTO;
import entidades.Madera;
import interfacesDAO.IMaderaDAO;
import interfacesDAO.IUsuarioDAO;
import interfacesDTO.IMadereraNegocio;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
/**
 * Implementación de la lógica de negocio para los productos de madera.
 * Esta clase maneja la transformación entre DTOs y entidades del dominio,
 * y coordina las operaciones con la capa de datos.
 */
public class MaderaNegocio implements IMadereraNegocio {
    /** DAO para operaciones con productos de madera */

    private IMaderaDAO iMaderaDAO;
/**
     * Constructor que inicializa la referencia al DAO de madera.
     */
    public MaderaNegocio() {
        this.iMaderaDAO = new MaderaDAO();
    }
 /**
     * Agrega un nuevo producto de madera al sistema.
     * Convierte el DTO a entidad para su almacenamiento y viceversa para la respuesta.
     * 
     * @param maderaDTO DTO con la información del nuevo producto
     * @return MaderaDTO con la información del producto guardado
     * @throws RuntimeException si ocurre un error durante el proceso
     */
    @Override
    public MaderaDTO agregarMadera(MaderaDTO maderaDTO) {
        Madera madera = new Madera();
        madera.setNombre(maderaDTO.getNombre());
        madera.setDescripcion(maderaDTO.getDescripcion());
        madera.setCantidad(maderaDTO.getCantidad());
        madera.setPrecioUnitario(maderaDTO.getPrecioUnitario());
        Madera maderaGuardada = iMaderaDAO.agregarMadera(madera);

        if (maderaGuardada != null) {
            MaderaDTO maderaDTO1 = new MaderaDTO();
            maderaDTO1.setNombre(maderaGuardada.getNombre());
            maderaDTO1.setDescripcion(maderaGuardada.getDescripcion());
            maderaDTO1.setCantidad(maderaGuardada.getCantidad());
            maderaDTO1.setPrecioUnitario(maderaGuardada.getPrecioUnitario());
            return maderaDTO1;
        } else {
            throw new RuntimeException("Error al agregar la madera");

        }

    }
 /**
     * Obtiene la lista completa de productos de madera.
     * Convierte las entidades a DTOs para la capa de presentación.
     * 
     * @return Lista de MaderaDTO con todos los productos
     * @throws RuntimeException si ocurre un error durante la obtención
     */
    @Override
    public List<MaderaDTO> obtenerMaderas() {
        List<MaderaDTO> listaMaderasDTO = new ArrayList<>();
        try {
            List<Madera> listaMaderas = iMaderaDAO.obtenerMaderas();
            for (Madera madera : listaMaderas) {
                MaderaDTO maderaDTO = new MaderaDTO();
                maderaDTO.setId(madera.getId().toString());
                maderaDTO.setNombre(madera.getNombre());
                maderaDTO.setDescripcion(madera.getDescripcion());
                maderaDTO.setPrecioUnitario(madera.getPrecioUnitario());
                maderaDTO.setCantidad(madera.getCantidad());
                listaMaderasDTO.add(maderaDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener las maderas", e);
        }
        return listaMaderasDTO;
    }
  /**
     * Busca un producto de madera por su ID.
     * 
     * @param id ID del producto en formato String
     * @return MaderaDTO con la información del producto encontrado
     * @throws RuntimeException si no se encuentra el producto o ocurre un error
     */
    @Override
    public MaderaDTO buscarMaderaPorId(String id) {
        try {
            Madera madera = iMaderaDAO.buscarMaderaPorId(id);

            if (madera != null) {

                MaderaDTO maderaDTO = new MaderaDTO();
                maderaDTO.setId(madera.getId().toString());
                maderaDTO.setNombre(madera.getNombre());
                maderaDTO.setDescripcion(madera.getDescripcion());
                maderaDTO.setCantidad(madera.getCantidad());
                maderaDTO.setPrecioUnitario(madera.getPrecioUnitario());
                return maderaDTO;
            } else {
                throw new RuntimeException("Madera no encontrada con el ID proporcionado");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al buscar la madera por ID", e);
        }
    }

    /**
     * Busca un producto de madera por su nombre.
     *
     * @param nombre Nombre del producto a buscar
     * @return MaderaDTO con la información del producto o null si no se
     * encuentra
     */
    public MaderaDTO buscarMaderaPorNombre(String nombre) {
        try {
            Madera madera = iMaderaDAO.buscarMaderaPorNombre(nombre);

            if (madera != null) {
                MaderaDTO maderaDTO = new MaderaDTO();
                maderaDTO.setId(madera.getId().toString());
                maderaDTO.setNombre(madera.getNombre());
                maderaDTO.setDescripcion(madera.getDescripcion());
                maderaDTO.setCantidad(madera.getCantidad());
                maderaDTO.setPrecioUnitario(madera.getPrecioUnitario());
                return maderaDTO;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // Retorna null si no se encuentra la madera
    }

    /**
     * Actualiza la información de un producto de madera.
     *
     * @param maderaDTO DTO con la información actualizada
     * @throws RuntimeException si ocurre un error durante la actualización
     */
    @Override
    public void editarMadera(MaderaDTO maderaDTO) {
        // Crear una entidad Madera a partir del DTO
        Madera madera = new Madera();
        madera.setId(new ObjectId(maderaDTO.getId()));
        madera.setNombre(maderaDTO.getNombre());
        madera.setDescripcion(maderaDTO.getDescripcion());
        madera.setCantidad(maderaDTO.getCantidad());
        madera.setPrecioUnitario(maderaDTO.getPrecioUnitario());
        System.out.println(maderaDTO.getId());
        try {
            // Llama al método del DAO para editar/actualizar la madera
            iMaderaDAO.editarMadera(madera);
        } catch (Exception e) {
            // Manejo de excepciones si ocurre algún error en la actualización
            throw new RuntimeException("Error al editar la madera en la base de datos", e);
        }
    }

    /**
     * Elimina un producto de madera del sistema.
     *
     * @param id ID del producto a eliminar
     * @return true si se eliminó correctamente, false en caso contrario
     */
    @Override
    public boolean eliminarMadera(String id) {
        return iMaderaDAO.eliminarMadera(id);
    }

}
