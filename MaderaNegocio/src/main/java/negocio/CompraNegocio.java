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
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
public class CompraNegocio implements ICompraNegocio {

    private ICompraDAO iCompraDAO;
    private IMaderaDAO maderaDAO;
    private IUsuarioDAO usuarioDAO;
    private ICarritoDAO iCarritoDAO;

    public CompraNegocio() {
        this.iCompraDAO = new CompraDAO();
        this.maderaDAO = new MaderaDAO();
        this.usuarioDAO = new UsuarioDAO();
        this.iCarritoDAO = new CarritoDAO();
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

    @Override
    public void comprarCarrito(String usuarioId) {
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
        }

        for (CompraDTO compra : compras) {
            guardarCompra(compra);
        }

        iCarritoDAO.eliminarProducto(usuarioObjectId, null);
        System.out.println("El carrito del usuario con ID " + usuarioId + " fue comprado exitosamente.");
    }

    @Override
    public List<Document> obtenerComprasPorUsuarioId(ObjectId usuarioId) {
        try {
            // Usar el DAO para obtener las compras relacionadas con el usuario
            List<Document> compras = iCompraDAO.obtenerComprasPorUsuarioId(usuarioId);

            // Preparar una lista de documentos con la información que se desea mostrar
            List<Document> comprasFormateadas = new ArrayList<>();

            for (Document compra : compras) {
                // Crear un nuevo documento con los campos deseados
                Document compraFormateada = new Document();
                compraFormateada.append("fechaCompra", compra.getDate("fechaCompra"));
                compraFormateada.append("nombreMadera", compra.getString("nombreMadera"));
                compraFormateada.append("cantidad", compra.getInteger("cantidad"));
                compraFormateada.append("precioTotal", compra.getDouble("precioTotal"));

                // Añadir a la lista de compras formateadas
                comprasFormateadas.add(compraFormateada);
            }

            return comprasFormateadas;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al obtener las compras del usuario.");
            return new ArrayList<>();
        }
    }
}
