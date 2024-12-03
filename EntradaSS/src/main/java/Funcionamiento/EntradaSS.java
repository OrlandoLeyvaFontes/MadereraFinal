/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funcionamiento;

import dto.EntradasDTO;
import interfacesDTO.IEntradasNegocio;
import interfaz.IEntradaSS;
import java.util.List;
import negocio.EntradasNegocio;

/**
 * Clase que representa la capa de servicio de entrada en el sistema. Esta clase
 * interactúa con la capa de negocio para registrar y obtener entradas de
 * madera, y proporciona métodos para acceder a la información relacionada con
 * las entradas de manera segura y controlada.
 *
 * Implementa la interfaz `IEntradaSS`, proporcionando una implementación de los
 * métodos para gestionar entradas de madera en el sistema.
 *
 * @author aleja
 */
public class EntradaSS implements IEntradaSS {

    // Atributo que representa la capa de negocio para las entradas
    private IEntradasNegocio iEntradaNegocio;

    /**
     * Constructor que inicializa la capa de negocio `EntradasNegocio`. Este
     * constructor permite crear una instancia de `EntradaSS` con acceso a la
     * lógica de negocio para las operaciones de entrada.
     */
    public EntradaSS() {
        this.iEntradaNegocio = new EntradasNegocio();
    }

    /**
     * Registra una nueva entrada de madera en el sistema.
     *
     * @param entradasDTO Objeto que contiene los datos de la entrada a
     * registrar
     * @return EntradasDTO Objeto con la información de la entrada registrada
     * @throws RuntimeException Si ocurre algún error al registrar la entrada
     */
    @Override
    public EntradasDTO registrarEntrada(EntradasDTO entradasDTO) {
        try {
            // Llamar al método de la capa de negocio para agregar la entrada
            EntradasDTO entradasDTO1 = iEntradaNegocio.agregarEntrada(entradasDTO);
            if (entradasDTO1 != null) {
                return entradasDTO1;
            } else {
                throw new RuntimeException("Error al agregar la entrada.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Ocurrió un error al intentar agregar la entrada: " + e.getMessage());
        }
    }

    /**
     * Obtiene la lista de todas las entradas de madera registradas en el
     * sistema.
     *
     * @return List<EntradasDTO> Lista de objetos EntradasDTO con la información
     * de las entradas
     * @throws RuntimeException Si ocurre algún error al obtener las entradas
     */
    public List<EntradasDTO> obtenerEntradas() {
        try {
            // Llamar al método de la capa de negocio para obtener todas las entradas
            List<EntradasDTO> entradasDTO1 = iEntradaNegocio.obtenerEntradas();
            if (entradasDTO1 != null) {
                return entradasDTO1;
            } else {
                throw new RuntimeException("Error al imprimir las entradas.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Ocurrió un error al intentar imprimir las entradas: " + e.getMessage());
        }
    }

    /**
     * Obtiene las entradas de madera filtradas por un tipo específico de
     * entrada.
     *
     * @param tipoEntrada Tipo de entrada (por ejemplo, compra, transferencia,
     * etc.)
     * @return List<EntradasDTO> Lista de objetos EntradasDTO filtrada por tipo
     * de entrada
     * @throws RuntimeException Si ocurre algún error al obtener las entradas
     * por tipo
     */
    public List<EntradasDTO> obtenerEntradasPorTipo(String tipoEntrada) {
        try {
            // Llamar al método de la capa de negocio para obtener las entradas por tipo
            List<EntradasDTO> entradasDTO1 = iEntradaNegocio.obtenerEntradasPorTipo(tipoEntrada);
            if (entradasDTO1 != null) {
                return entradasDTO1;
            } else {
                throw new RuntimeException("Error al imprimir las entradas.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Ocurrió un error al intentar imprimir las entradas: " + e.getMessage());
        }
    }

    /**
     * Obtiene la lista de todos los tipos de entrada disponibles en el sistema.
     *
     * @return List<String> Lista de tipos de entrada disponibles
     * @throws RuntimeException Si ocurre algún error al obtener los tipos de
     * entrada
     */
    public List<String> obtenerTiposEntrada() {
        try {
            // Llamar al método de la capa de negocio para obtener los tipos de entrada
            List<String> tiposEntrada = iEntradaNegocio.obtenerTiposEntrada();
            if (tiposEntrada != null) {
                return tiposEntrada;
            } else {
                throw new RuntimeException("Error al obtener los tipos de entrada.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Ocurrió un error al intentar obtener los tipos de entrada: " + e.getMessage());
        }
    }
}
