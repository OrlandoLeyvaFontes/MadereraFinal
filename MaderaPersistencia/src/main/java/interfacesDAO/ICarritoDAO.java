/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacesDAO;

import entidades.Madera;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
public interface ICarritoDAO {
    public void agregarProducto(ObjectId usuarioId, Madera madera, int cantidad);
    public Document obtenerCarrito(ObjectId usuarioId);
        public void eliminarProducto(ObjectId usuarioId, ObjectId maderaId);

}
