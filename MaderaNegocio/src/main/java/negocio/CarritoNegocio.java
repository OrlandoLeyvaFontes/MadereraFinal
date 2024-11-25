/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dao.CarritoDAO;
import interfacesDAO.ICarritoDAO;
import interfacesDTO.ICarritoNegocio;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
public class CarritoNegocio implements  ICarritoNegocio{
private ICarritoDAO  iCarritoDAO;

    public CarritoNegocio( ) {
        this.iCarritoDAO = new CarritoDAO();
    }

    @Override
    public void agregarProducto(String usuarioId, String maderaId, int cantidad) {
 if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0.");
        }
        
        ObjectId usuarioObjectId = new ObjectId(usuarioId);
        ObjectId maderaObjectId = new ObjectId(maderaId);
        iCarritoDAO.agregarProducto(usuarioObjectId, maderaObjectId, cantidad);    }

    @Override
    public Document obtenerCarrito(String usuarioId) {
ObjectId usuarioObjectId = new ObjectId(usuarioId);
        return iCarritoDAO.obtenerCarrito(usuarioObjectId);
    }

    @Override
    public void eliminarProducto(String usuarioId, String maderaId) {
 ObjectId usuarioObjectId = new ObjectId(usuarioId);
        ObjectId maderaObjectId = new ObjectId(maderaId);
        iCarritoDAO.eliminarProducto(usuarioObjectId, maderaObjectId);    }

  
    
    
}
