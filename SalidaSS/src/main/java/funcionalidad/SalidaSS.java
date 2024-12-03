/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funcionalidad;

import dto.SalidaDTO;
import interfacesDTO.ISalidaNegocio;
import interfaz.ISalidaSS;
import java.util.List;
import negocio.SalidaNegocio;

/**
 *
 * @author Oley
 */
/**
 * Clase SalidaSS
 *
 * Implementa la interfaz ISalidaSS y actúa como la capa de servicio para
 * gestionar las operaciones relacionadas con las salidas en el sistema. Esta
 * clase se encarga de interactuar con la capa de negocio (ISalidaNegocio) para
 * realizar las operaciones.
 */
public class SalidaSS implements ISalidaSS {

    ISalidaNegocio iSalidaNegocio;

    /**
     * Constructor por defecto. Inicializa la instancia de ISalidaNegocio con
     * una nueva instancia de SalidaNegocio.
     */
    public SalidaSS() {
        this.iSalidaNegocio = new SalidaNegocio();
    }

    /**
     * Crea una nueva salida en el sistema a partir de una compra existente.
     *
     * @param compraId Identificador de la compra asociada a la salida.
     * @param tipoMovimiento Tipo de movimiento relacionado con la salida (por
     * ejemplo, entrega o devolución).
     * @return Una cadena que indica el resultado de la operación, como un
     * mensaje de éxito o error.
     */
    @Override
    public String crearSalidaDesdeCompra(String compraId, String tipoMovimiento) {
        return iSalidaNegocio.crearSalidaDesdeCompra(compraId, tipoMovimiento);
    }

    /**
     * Obtiene una salida específica basada en su identificador único.
     *
     * @param salidaId Identificador de la salida que se desea obtener.
     * @return Un objeto SalidaDTO con los detalles de la salida encontrada, o
     * null si no existe.
     */
    @Override
    public SalidaDTO obtenerSalida(String salidaId) {
        return iSalidaNegocio.obtenerSalida(salidaId);

    }

    /**
     * Obtiene una lista de todas las salidas registradas en el sistema.
     *
     * @return Una lista de objetos SalidaDTO que representan todas las salidas
     * registradas.
     */
    @Override
    public List<SalidaDTO> obtenerTodasLasSalidas() {
        return iSalidaNegocio.obtenerTodasLasSalidas();
    }

}
