/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacesDAO;

import entidades.Salida;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
/**
 * Interface que define las operaciones de acceso a datos para las salidas de
 * inventario. Proporciona métodos para gestionar los movimientos y salidas de
 * productos del sistema.
 */
public interface ISalidaDAO {

    /**
     * Crea un nuevo registro de salida basado en una compra existente. Este
     * método permite registrar diferentes tipos de movimientos de inventario
     * relacionados con una compra previa.
     *
     * @param compraId Identificador de la compra asociada
     * @param nuevoTipoMovimiento Tipo de movimiento a registrar
     * @return ObjectId Identificador de la nueva salida creada
     */
    public ObjectId crearSalidaDesdeCompra(ObjectId compraId, String nuevoTipoMovimiento);

    /**
     * Recupera la información detallada de una salida específica.
     *
     * @param salidaId Identificador único de la salida
     * @return Salida Objeto con la información completa de la salida
     */
    public Salida obtenerSalida(ObjectId salidaId);

    /**
     * Obtiene una lista de todas las salidas registradas en el sistema.
     *
     * @return List<Salida> Lista con todas las salidas de inventario
     */
    public List<Salida> obtenerTodasLasSalidas();

}
