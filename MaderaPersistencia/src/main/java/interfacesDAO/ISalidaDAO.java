/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacesDAO;

import entidades.Salida;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
public interface ISalidaDAO {
   public ObjectId crearSalidaDesdeCompra(ObjectId compraId, String nuevoTipoMovimiento);
   public Salida obtenerSalida(ObjectId salidaId) ;
//    public String crearSalida(Document salidaDoc);
//    public Document obtenerSalidaPorId(String salidaId);
//}
}
