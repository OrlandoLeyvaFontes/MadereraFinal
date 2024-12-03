/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaz;

import dto.EntradasDTO;
import java.util.List;

/**
 * Interfaz que define los métodos relacionados con la gestión de entradas de
 * madera en el sistema. La interfaz establece los contratos que deben ser
 * implementados por las clases que gestionan las entradas, proporcionando
 * acceso a la funcionalidad de registro y consulta de entradas.
 *
 * @author aleja
 */
public interface IEntradaSS {

    /**
     * Método para registrar una nueva entrada de madera en el sistema.
     *
     * @param entradasDTO Objeto que contiene los datos de la entrada a
     * registrar.
     * @return EntradasDTO Objeto con la información de la entrada registrada.
     * @throws RuntimeException Si ocurre un error al registrar la entrada.
     */
    public EntradasDTO registrarEntrada(EntradasDTO entradasDTO);

    /**
     * Método para obtener la lista de todas las entradas de madera registradas
     * en el sistema.
     *
     * @return List<EntradasDTO> Lista de objetos EntradasDTO con la información
     * de todas las entradas.
     * @throws RuntimeException Si ocurre un error al obtener las entradas.
     */
    public List<EntradasDTO> obtenerEntradas();

    /**
     * Método para obtener las entradas de madera filtradas por un tipo
     * específico de entrada.
     *
     * @param tipoEntrada Tipo de entrada (por ejemplo, compra, transferencia,
     * etc.)
     * @return List<EntradasDTO> Lista de objetos EntradasDTO filtrada por el
     * tipo de entrada.
     * @throws RuntimeException Si ocurre un error al obtener las entradas por
     * tipo.
     */
    public List<EntradasDTO> obtenerEntradasPorTipo(String tipoEntrada);

    /**
     * Método para obtener la lista de todos los tipos de entrada disponibles en
     * el sistema.
     *
     * @return List<String> Lista de tipos de entrada disponibles.
     * @throws RuntimeException Si ocurre un error al obtener los tipos de
     * entrada.
     */
    public List<String> obtenerTiposEntrada();
}
