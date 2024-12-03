/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaz;

import dto.SalidaDTO;
import java.util.List;

/**
 *
 * @author Oley
 */
/**
 * Interfaz ISalidaSS
 *
 * Define los métodos necesarios para gestionar las operaciones relacionadas con
 * las salidas en el sistema, como la creación de salidas a partir de compras y
 * la obtención de salidas específicas o de todas las registradas.
 */
public interface ISalidaSS {

    /**
     * Crea una nueva salida en el sistema basada en una compra existente.
     *
     * @param compraId Identificador de la compra asociada a la salida.
     * @param tipoMovimiento Tipo de movimiento relacionado con la salida (por
     * ejemplo, entrega, devolución).
     * @return Una cadena que indica el resultado de la operación, como un
     * mensaje de éxito o error.
     */
    public String crearSalidaDesdeCompra(String compraId, String tipoMovimiento);

    /**
     * Obtiene una salida específica utilizando su identificador único.
     *
     * @param salidaId Identificador de la salida que se desea obtener.
     * @return Un objeto SalidaDTO que contiene los detalles de la salida
     * encontrada, o null si no existe una salida con el ID proporcionado.
     */
    public SalidaDTO obtenerSalida(String salidaId);

    /**
     * Obtiene una lista de todas las salidas registradas en el sistema.
     *
     * @return Una lista de objetos SalidaDTO que representan todas las salidas
     * registradas.
     */
    public List<SalidaDTO> obtenerTodasLasSalidas();

}
