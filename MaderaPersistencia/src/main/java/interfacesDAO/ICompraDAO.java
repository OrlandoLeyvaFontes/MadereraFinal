/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacesDAO;

import entidades.Compra;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
public interface ICompraDAO {

    void guardarCompra(Compra compra);

    public void comprarCarrito(ObjectId usuarioId);

    public List<Document> obtenerHistorialCompras(ObjectId usuarioId);
}
