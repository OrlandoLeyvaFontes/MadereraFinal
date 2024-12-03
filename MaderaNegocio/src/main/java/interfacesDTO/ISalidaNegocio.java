/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacesDTO;

import dto.SalidaDTO;
import java.util.List;

/**
 *
 * @author Oley
 */
/**
 * Interfaz para manejar las operaciones relacionadas con las salidas en el sistema.
 */
public interface ISalidaNegocio {
     /**
     * Crea una salida a partir de una compra.
     *
     * @param compraId El ID de la compra desde la cual se crea la salida.
     * @param tipoMovimiento El tipo de movimiento (por ejemplo, salida de inventario).
     * @return Un mensaje que indica el estado de la operación.
     */
  public String crearSalidaDesdeCompra(String compraId, String tipoMovimiento);  
   /**
     * Obtiene una salida específica por su ID.
     *
     * @param salidaId El ID de la salida a buscar.
     * @return El objeto `SalidaDTO` correspondiente al ID proporcionado.
     */
  public SalidaDTO obtenerSalida(String salidaId) ;
   /**
     * Obtiene todas las salidas registradas en el sistema.
     *
     * @return Una lista de objetos `SalidaDTO` con todas las salidas.
     */
    public List<SalidaDTO> obtenerTodasLasSalidas();
}
