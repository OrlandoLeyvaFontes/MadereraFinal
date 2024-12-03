/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaz;

import dto.MaderaDTO;
import java.util.List;

/**
 *
 * @author Oley
 */
/**
 * Interfaz IMaderaSS
 *
 * Define los métodos necesarios para gestionar las operaciones relacionadas con
 * las maderas en el sistema, incluyendo su obtención, registro y búsqueda.
 */
public interface IMaderaSS {

    /**
     * Obtiene la lista completa de maderas disponibles en el sistema.
     *
     * @return Una lista de objetos MaderaDTO que representan las maderas
     * registradas.
     */
    public List<MaderaDTO> obtenerMaderas();

    /**
     * Agrega una nueva madera al sistema.
     *
     * @param maderaDTO Objeto MaderaDTO que contiene los datos de la madera a
     * registrar.
     * @return El objeto MaderaDTO de la madera registrada.
     */
    public MaderaDTO agregarMadera(MaderaDTO maderaDTO);

    /**
     * Busca una madera en el sistema utilizando su identificador único.
     *
     * @param id Identificador de la madera a buscar.
     * @return El objeto MaderaDTO correspondiente a la madera encontrada, o
     * null si no existe.
     */
    public MaderaDTO buscarMaderaPorId(String id);

    /**
     * Busca una madera en el sistema utilizando su nombre.
     *
     * @param nombre Nombre de la madera a buscar.
     * @return El objeto MaderaDTO correspondiente a la madera encontrada, o
     * null si no existe.
     */
    public MaderaDTO buscarMaderaPorNombre(String nombre);

}
