/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import dao.MaderaCompraDAO;
import interfacesDAO.IMaderaCompraDAO;
import interfacesDTO.ICompraMaderaNegocio;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
public class CompraMaderaNegocio implements  ICompraMaderaNegocio{
private IMaderaCompraDAO iMaderaCompraDAO ;

    public CompraMaderaNegocio(IMaderaCompraDAO iMaderaCompraDAO) {
        this.iMaderaCompraDAO = new MaderaCompraDAO();
    }



//    public void actualizarCantidadYPrecio(String idMadera, int nuevaCantidad) {
//        iMaderaCompraDAO.actualizarCantidadYPrecio(idMadera, nuevaCantidad);
//    }
    
}
