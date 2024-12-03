/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacesDTO;

import dto.EntradasDTO;
import entidades.Entradas;
import java.util.List;

/**
 * Interfaz que define los métodos para gestionar las operaciones relacionadas
 * con las entradas. Esta interfaz es implementada por la clase que maneja la
 * lógica de negocio de las entradas.
 *
 * @author aleja
 */
public interface IEntradasNegocio {

    /**
     * Agrega una nueva entrada a la base de datos.
     *
     * Este método recibe un objeto EntradasDTO que contiene los datos de la
     * entrada a agregar, y luego lo guarda en la base de datos.
     *
     * @param entradaDTO Objeto DTO con los datos de la entrada a agregar.
     * @return EntradasDTO El objeto DTO de la entrada recién agregada.
     */
    public EntradasDTO agregarEntrada(EntradasDTO entradaDTO);

    /**
     * Obtiene todas las entradas registradas en la base de datos.
     *
     * Este método consulta la base de datos y retorna una lista de objetos
     * EntradasDTO con todos los registros de entradas.
     *
     * @return Lista de EntradasDTO con todas las entradas disponibles.
     */
    public List<EntradasDTO> obtenerEntradas();

    /**
     * Obtiene las entradas filtradas por un tipo específico.
     *
     * Este método permite obtener las entradas que corresponden a un tipo
     * específico. El tipo de entrada se pasa como parámetro.
     *
     * @param tipoEntrada Tipo de entrada que se desea filtrar.
     * @return Lista de EntradasDTO que corresponden al tipo de entrada
     * proporcionado.
     */
    public List<EntradasDTO> obtenerEntradasPorTipo(String tipoEntrada);

    /**
     * Obtiene todos los tipos de entradas disponibles.
     *
     * Este método consulta la base de datos para obtener una lista con los
     * diferentes tipos de entradas disponibles, como una lista de cadenas.
     *
     * @return Lista de cadenas que contienen los tipos de entrada disponibles.
     */
    public List<String> obtenerTiposEntrada();
}
