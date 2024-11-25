/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacesDTO;

import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
public interface ICarritoNegocio {
        public void agregarProducto(String usuarioId, String maderaId, int cantidad);
 public Document obtenerCarrito(String usuarioId);
public void eliminarProducto(String usuarioId, String maderaId);
}
