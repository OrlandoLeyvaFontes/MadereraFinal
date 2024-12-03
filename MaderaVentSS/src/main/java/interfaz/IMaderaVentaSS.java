/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaz;

import dto.MaderaDTO;
import java.util.List;

/**
 * Interfaz que define los métodos relacionados con la gestión de la venta de
 * madera. La interfaz establece los contratos que deben ser implementados por
 * las clases que gestionan las operaciones relacionadas con la madera en el
 * sistema de ventas.
 *
 * @author aleja
 */
public interface IMaderaVentaSS {

    /**
     * Método para agregar una nueva madera al sistema de ventas.
     *
     * @param madera Objeto de tipo MaderaDTO que contiene los datos de la
     * madera a agregar.
     * @return MaderaDTO Objeto con la información de la madera agregada.
     * @throws RuntimeException Si ocurre un error al agregar la madera.
     */
    public MaderaDTO agregarMadera(MaderaDTO madera);

    /**
     * Método para obtener una madera específica a través de su nombre.
     *
     * @param nombre Nombre de la madera a buscar.
     * @return MaderaDTO Objeto con la información de la madera encontrada.
     * @throws RuntimeException Si ocurre un error al obtener la madera por
     * nombre.
     */
    public MaderaDTO obtenerMaderaPorNombre(String nombre);

    /**
     * Método para obtener todas las maderas disponibles en el sistema de
     * ventas.
     *
     * @return List<MaderaDTO> Lista de objetos MaderaDTO con la información de
     * todas las maderas.
     * @throws RuntimeException Si ocurre un error al obtener las maderas.
     */
    public List<MaderaDTO> obtenerMaderas();

    /**
     * Método para buscar una madera a través de su identificador único (ID).
     *
     * @param id Identificador de la madera a buscar.
     * @return MaderaDTO Objeto con la información de la madera encontrada.
     * @throws RuntimeException Si ocurre un error al buscar la madera por ID.
     */
    public MaderaDTO buscarMaderaPorId(String id);

    /**
     * Método para editar la información de una madera existente en el sistema.
     *
     * @param maderaDTO Objeto de tipo MaderaDTO con la información actualizada
     * de la madera.
     * @throws RuntimeException Si ocurre un error al editar la madera.
     */
    public void editarMadera(MaderaDTO maderaDTO);

    /**
     * Método para eliminar una madera del sistema a través de su identificador
     * único (ID).
     *
     * @param id Identificador de la madera a eliminar.
     * @throws RuntimeException Si ocurre un error al eliminar la madera.
     */
    public void eliminarMadera(String id);
}
