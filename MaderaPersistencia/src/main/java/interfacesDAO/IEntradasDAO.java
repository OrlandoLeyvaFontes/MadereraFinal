/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacesDAO;

import entidades.Entradas;
import java.util.List;

/**
 * Interfaz que define las operaciones de acceso a datos relacionadas con la
 * entidad Entradas.
 *
 * Métodos: - guardarEntrada(Entradas entrada): Guarda una nueva entrada en el
 * sistema. - obtenerEntradas(): Recupera todas las entradas almacenadas. -
 * obtenerEntradasPorTipo(String tipoEntrada): Recupera las entradas filtradas
 * por tipo. - obtenerTiposEntrada(): Recupera una lista de los tipos de
 * entradas disponibles.
 *
 * Esta interfaz debe ser implementada por clases que gestionen las operaciones
 * sobre las entradas en una base de datos, como por ejemplo una implementación
 * utilizando MongoDB, JPA o cualquier otro sistema.
 */
public interface IEntradasDAO {

    /**
     * Guarda una nueva entrada en el sistema.
     *
     * @param entrada La entrada que se desea guardar.
     * @return La entrada que ha sido guardada, con su ID asignado.
     */
    public Entradas guardarEntrada(Entradas entrada);

    /**
     * Obtiene todas las entradas almacenadas en el sistema.
     *
     * @return Una lista con todas las entradas registradas.
     */
    public List<Entradas> obtenerEntradas();

    /**
     * Obtiene las entradas filtradas por tipo de entrada.
     *
     * @param tipoEntrada El tipo de entrada para filtrar las entradas.
     * @return Una lista con las entradas que coinciden con el tipo dado.
     */
    public List<Entradas> obtenerEntradasPorTipo(String tipoEntrada);

    /**
     * Obtiene los tipos de entrada disponibles en el sistema.
     *
     * @return Una lista de los tipos de entrada registrados.
     */
    public List<String> obtenerTiposEntrada();
}
