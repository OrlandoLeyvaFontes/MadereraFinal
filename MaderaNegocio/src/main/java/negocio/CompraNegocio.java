/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dao.CarritoDAO;
import dao.CompraDAO;
import dao.MaderaDAO;
import dao.UsuarioDAO;
import dto.CompraDTO;
import dto.MaderaDTO;
import dto.UsuarioDTO;
import entidades.Compra;
import entidades.Madera;
import entidades.Usuario;
import interfacesDAO.ICarritoDAO;
import interfacesDAO.ICompraDAO;
import interfacesDAO.IMaderaDAO;
import interfacesDAO.IUsuarioDAO;
import interfacesDTO.ICompraNegocio;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
/**
 * Implementación de la lógica de negocio para las compras.
 * Esta clase coordina las operaciones entre la capa de presentación y la capa de datos,
 * manejando las transacciones de compra y el historial de las mismas.
 */
public class CompraNegocio implements ICompraNegocio {
    /** DAO para operaciones de compra */

    private ICompraDAO iCompraDAO;
        /** DAO para operaciones con productos de madera */

    private IMaderaDAO maderaDAO;
        /** DAO para operaciones con usuarios */

    private IUsuarioDAO usuarioDAO;
        /** DAO para operaciones con el carrito */

    private ICarritoDAO iCarritoDAO;
/**
     * Constructor que inicializa todas las referencias a los DAOs necesarios.
     */
    public CompraNegocio() {
        this.iCompraDAO = new CompraDAO();
        this.maderaDAO = new MaderaDAO();
        this.usuarioDAO = new UsuarioDAO();
        this.iCarritoDAO = new CarritoDAO();
    }
 /**
     * Guarda una nueva compra en el sistema.
     * Valida la existencia del producto y usuario antes de procesar la compra.
     * 
     * @param compraDTO DTO con la información de la compra
     * @return String ID de la compra generada, o null si ocurre un error
     */
    @Override
    public String guardarCompra(CompraDTO compraDTO) {
         try {
        Madera madera = maderaDAO.obtenerMaderaPorId(new ObjectId(compraDTO.getMadera().getId()));
        Usuario usuario = usuarioDAO.obtenerUsuarioPorId(new ObjectId(compraDTO.getUsuario().getId()));
        if (madera == null) {
            System.out.println("Madera no encontrada.");
            return null;
        }
        if (usuario == null) {
            System.out.println("Usuario no encontrado.");
            return null;
        }
        Compra compra = new Compra();
        compra.setId(new ObjectId());
        compra.setFechaCompra(compraDTO.getFechaCompra());
        compra.setCantidad(compraDTO.getCantidad());
        compra.setMadera(madera);
        compra.setUsuario(usuario);
        iCompraDAO.guardarCompra(compra);
        System.out.println("Compra procesada correctamente.");
        
        // Devolver el ID que generaste
        return compra.getId().toString();
        
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error al procesar la compra.");
        return null;
    }
    }
 /**
     * Procesa la compra de todos los productos en el carrito de un usuario.
     * Convierte cada item del carrito en una compra individual.
     * 
     * @param usuarioId ID del usuario en formato String
     * @return List<String> Lista de IDs de las compras generadas
     * @throws IllegalStateException si el carrito está vacío o hay productos no disponibles
     */
    public List<String> comprarCarrito(String usuarioId) {
    ObjectId usuarioObjectId = new ObjectId(usuarioId);
    Document carritoDoc = iCarritoDAO.obtenerCarrito(usuarioObjectId);
    if (carritoDoc == null || carritoDoc.getList("maderas", Document.class).isEmpty()) {
        throw new IllegalStateException("El carrito está vacío o no existe.");
    }
    List<Document> maderasCarrito = carritoDoc.getList("maderas", Document.class);
    List<CompraDTO> compras = new ArrayList<>();
    Usuario usuario = usuarioDAO.obtenerUsuarioPorId(usuarioObjectId);
    if (usuario == null) {
        throw new IllegalStateException("Usuario con ID " + usuarioId + " no encontrado.");
    }
    
    UsuarioDTO usuarioDTO = new UsuarioDTO();
    usuarioDTO.setId(usuarioId);
    usuarioDTO.setNombre(usuario.getNombre());
    
    List<String> idsCompras = new ArrayList<>(); // Lista para guardar todos los IDs
    
    for (Document maderaDoc : maderasCarrito) {
        ObjectId maderaId = maderaDoc.getObjectId("id");
        int cantidad = maderaDoc.getInteger("cantidad", 0);
        Madera madera = maderaDAO.obtenerMaderaPorId(maderaId);
        if (madera == null) {
            throw new IllegalStateException("Madera con ID " + maderaId + " no encontrada.");
        }
        
        MaderaDTO maderaDTO = new MaderaDTO();
        maderaDTO.setId(maderaId.toHexString());
        maderaDTO.setNombre(madera.getNombre());
        maderaDTO.setPrecioUnitario(madera.getPrecioUnitario());
        
        CompraDTO compra = new CompraDTO();
        compra.setCantidad(cantidad);
        compra.setUsuario(usuarioDTO);
        compra.setFechaCompra(Calendar.getInstance());
        compra.setMadera(maderaDTO);
        compras.add(compra);
        
        // Guardar la compra y añadir su ID a la lista
        String idCompra = guardarCompra(compra);
        idsCompras.add(idCompra);
    }
    
    iCarritoDAO.eliminarProducto(usuarioObjectId, null);
    
    // Devolver todos los IDs de las compras realizadas
    return idsCompras;
}
    
/**
     * Obtiene el historial de compras de un usuario.
     * Convierte los documentos de la base de datos a DTOs para la presentación.
     * 
     * @param usuarioId ID del usuario en formato String
     * @return List<CompraDTO> Lista de compras del usuario
     * @throws RuntimeException si ocurre un error durante la obtención
     */

    @Override
    public List<CompraDTO> obtenerHistorialCompras(String usuarioId) {
        try {
            ObjectId usuarioObjectId = new ObjectId(usuarioId);
            Usuario usuario = usuarioDAO.obtenerUsuarioPorId(usuarioObjectId);
            if (usuario == null) {
                throw new IllegalStateException("Usuario con ID " + usuarioId + " no encontrado.");
            }

            List<Document> compras = iCompraDAO.obtenerHistorialCompras(usuarioObjectId);
            List<CompraDTO> historialCompras = new ArrayList<>();

            for (Document compraDoc : compras) {
                CompraDTO compraDTO = new CompraDTO();
                compraDTO.setId(compraDoc.getObjectId("_id").toHexString());

                Date fechaCompra = compraDoc.getDate("fechaCompra");
                if (fechaCompra != null) {
                    Calendar fechaCompraCalendar = Calendar.getInstance();
                    fechaCompraCalendar.setTime(fechaCompra);
                    compraDTO.setFechaCompra(fechaCompraCalendar);
                }

                compraDTO.setCantidad(compraDoc.getInteger("cantidad", 0));
                compraDTO.setPrecioTotal(compraDoc.getDouble("precioTotal"));

                MaderaDTO maderaDTO = new MaderaDTO();
                maderaDTO.setNombre(compraDoc.getString("maderaNombre"));
                compraDTO.setMadera(maderaDTO);

                UsuarioDTO usuarioDTO = new UsuarioDTO();
                usuarioDTO.setNombre(compraDoc.getString("usuarioNombre"));
                compraDTO.setUsuario(usuarioDTO);

                historialCompras.add(compraDTO);
            }

            return historialCompras;
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener el historial de compras para el usuario con ID " + usuarioId, e);
        }
    }

}
