/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacesDTO;

import dto.MaderaDTO;
import java.util.List;

/**
 *
 * @author Oley
 */
/**
 * Interfaz para manejar las operaciones de maderas en el sistema.
 */
public interface IMadereraNegocio {

    /**
     * Agrega una nueva madera al sistema.
     *
     * @param maderaDTO El objeto con los detalles de la madera a agregar.
     * @return El objeto `MaderaDTO` agregado.
     */
    public MaderaDTO agregarMadera(MaderaDTO maderaDTO);

    /**
     * Obtiene todas las maderas disponibles en el sistema.
     *
     * @return Lista de objetos `MaderaDTO`.
     */
    public List<MaderaDTO> obtenerMaderas();

    /**
     * Busca una madera por su ID.
     *
     * @param id El ID de la madera a buscar.
     * @return El objeto `MaderaDTO` encontrado o `null` si no se encuentra.
     */
    public MaderaDTO buscarMaderaPorId(String id);

    /**
     * Busca una madera por su nombre.
     *
     * @param nombre El nombre de la madera a buscar.
     * @return El objeto `MaderaDTO` encontrado o `null` si no se encuentra.
     */
    public MaderaDTO buscarMaderaPorNombre(String nombre);

    /**
     * Edita una madera existente en el sistema.
     *
     * @param maderaDTO El objeto con los nuevos detalles de la madera.
     */
    public void editarMadera(MaderaDTO maderaDTO);

    /**
     * Elimina una madera por su ID.
     *
     * @param id El ID de la madera a eliminar.
     * @return `true` si se eliminó correctamente, `false` si no se encuentra.
     */
    public boolean eliminarMadera(String id);
}
