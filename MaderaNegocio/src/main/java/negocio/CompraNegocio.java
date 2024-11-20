/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dao.CompraDAO;
import dao.MaderaDAO;
import dao.UsuarioDAO;
import dto.CompraDTO;
import entidades.Compra;
import entidades.Madera;
import entidades.Usuario;
import interfacesDAO.ICompraDAO;
import interfacesDAO.IMaderaDAO;
import interfacesDAO.IUsuarioDAO;
import interfacesDTO.ICompraNegocio;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
public class CompraNegocio implements ICompraNegocio{
  private ICompraDAO iCompraDAO;
    private IMaderaDAO maderaDAO;
    private IUsuarioDAO usuarioDAO;

    public CompraNegocio() {
        this.iCompraDAO = new CompraDAO();
        this.maderaDAO = new MaderaDAO();
        this.usuarioDAO = new UsuarioDAO();
    }

    @Override
    public void guardarCompra(CompraDTO compraDTO) {
    try {
        Madera madera = maderaDAO.obtenerMaderaPorId(new ObjectId(compraDTO.getMadera().getId()));
        Usuario usuario = usuarioDAO.obtenerUsuarioPorId(new ObjectId(compraDTO.getUsuario().getId()));

        if (madera == null) {
            System.out.println("Madera no encontrada.");
            return;
        }
        if (usuario == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }

        Compra compra = new Compra();
        compra.setId(new ObjectId());  
        compra.setFechaCompra(compraDTO.getFechaCompra());
        compra.setCantidad(compraDTO.getCantidad());
        compra.setMadera(madera);
        compra.setUsuario(usuario);

        iCompraDAO.guardarCompra(compra);

        System.out.println("Compra procesada correctamente.");

    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error al procesar la compra.");
    }
    
    }
}