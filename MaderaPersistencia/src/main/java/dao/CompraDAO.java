/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import conexion.Conexion;
import entidades.Compra;
import entidades.Madera;
import entidades.Usuario;
import interfacesDAO.ICompraDAO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
/**
 * Implementación de la interfaz ICompraDAO para MongoDB. Maneja las operaciones
 * de compras y su procesamiento en la base de datos.
 */
public class CompraDAO implements ICompraDAO {

    /**
     * Colección de carritos en MongoDB
     */

    private MongoCollection<Document> collection;
    /**
     * Colección de compras en MongoDB
     */

    private final MongoCollection<Document> coleccionCompras;
    /**
     * Colección de productos de madera en MongoDB
     */

    private final MongoCollection<Document> maderaCollection;
    /**
     * Colección de usuarios en MongoDB
     */

    private final MongoCollection<Document> usuarioCollection;

    /**
     * Constructor que inicializa las conexiones a las colecciones necesarias.
     */
    public CompraDAO() {
        this.collection = Conexion.getDatabase().getCollection("Carrito");

        this.coleccionCompras = Conexion.getDatabase().getCollection("compras");
        this.maderaCollection = Conexion.getDatabase().getCollection("Madera");
        this.usuarioCollection = Conexion.getDatabase().getCollection("usuarios");
    }
/**
     * Guarda una nueva compra en la base de datos y actualiza el inventario.
     * Verifica disponibilidad de stock y actualiza las cantidades correspondientes.
     * 
     * @param compra Objeto Compra a guardar
     */
    @Override
    public void guardarCompra(Compra compra) {
        ObjectId maderaId = compra.getMadera().getId();
        String maderaNombre = null;
        double precioTotal = 0;

        if (maderaId != null) {
            Document maderaDoc = maderaCollection.find(Filters.eq("_id", maderaId)).first();
            if (maderaDoc != null) {
                maderaNombre = maderaDoc.getString("nombre");
                Integer cantidadActual = maderaDoc.getInteger("cantidad", 0);
                Integer cantidadSolicitada = compra.getCantidad();
                Integer nuevaCantidad = cantidadActual - cantidadSolicitada;

                if (nuevaCantidad < 0) {
                    System.out.println("Error: No hay suficiente madera en stock.");
                    return;
                }

                maderaCollection.updateOne(Filters.eq("_id", maderaId),
                        new Document("$set", new Document("cantidad", nuevaCantidad)));

                Double precioUnitario = maderaDoc.getDouble("precioUnitario");
                if (precioUnitario != null) {
                    precioTotal = precioUnitario * cantidadSolicitada;
                } else {
                    System.out.println("Error: Precio de madera no disponible.");
                    return;
                }
            }
        }

        ObjectId usuarioId = compra.getUsuario().getId();
        String usuarioNombre = null;
        if (usuarioId != null) {
            Document usuarioDoc = usuarioCollection.find(Filters.eq("_id", usuarioId)).first();
            if (usuarioDoc != null) {
                usuarioNombre = usuarioDoc.getString("nombre");
            }
        }

        Document doc = new Document("fechaCompra", compra.getFechaCompra().getTime())
                .append("precioTotal", precioTotal)
                .append("cantidad", compra.getCantidad())
                .append("maderaNombre", maderaNombre)
                .append("usuarioNombre", usuarioNombre);

        coleccionCompras.insertOne(doc);
        compra.setId(doc.getObjectId("_id"));

        System.out.println("Compra guardada correctamente:");
        System.out.println("Madera: " + maderaNombre);
        System.out.println("Cantidad: " + compra.getCantidad());
        System.out.println("Precio total: " + precioTotal);
        System.out.println("Comprador: " + usuarioNombre);
    }
  /**
     * Obtiene un documento de madera por su ID.
     * 
     * @param maderaId ID de la madera
     * @return Document con la información de la madera
     */
    private Document obtenerMadera(ObjectId maderaId) {
        return maderaCollection.find(Filters.eq("_id", maderaId)).first();
    }
 /**
     * Obtiene el nombre de un usuario por su ID.
     * 
     * @param usuarioId ID del usuario
     * @return Nombre del usuario o "Desconocido" si no se encuentra
     */
    private String obtenerNombreUsuario(ObjectId usuarioId) {
        Document usuarioDoc = usuarioCollection.find(Filters.eq("_id", usuarioId)).first();
        return usuarioDoc != null ? usuarioDoc.getString("nombre") : "Desconocido";
    }
 /**
     * Procesa la compra de todos los productos en el carrito de un usuario.
     * Verifica stock, actualiza inventario y genera registros de compra individuales.
     * 
     * @param usuarioId ID del usuario que realiza la compra
     */
    public void comprarCarrito(ObjectId usuarioId) {
        Document carritoDoc = collection.find(Filters.eq("usuarioId", usuarioId)).first();

        if (carritoDoc == null) {
            System.out.println("Error: No se encontró el carrito para el usuario.");
            return;
        }

        List<Document> maderasCarrito = carritoDoc.getList("maderas", Document.class);

        if (maderasCarrito == null || maderasCarrito.isEmpty()) {
            System.out.println("Error: El carrito está vacío.");
            return;
        }

        String usuarioNombre = obtenerNombreUsuario(usuarioId);
        boolean compraExitosa = true;
        List<Compra> compras = new ArrayList<>();

        // Procesar cada madera individualmente
        for (Document maderaDoc : maderasCarrito) {
            ObjectId maderaId = maderaDoc.getObjectId("id");
            int cantidad = maderaDoc.getInteger("cantidad", 0);

            Document madera = maderaCollection.find(Filters.eq("_id", maderaId)).first();

            if (madera == null) {
                System.out.println("Error: Madera no encontrada.");
                compraExitosa = false;
                continue;
            }

            String maderaNombre = madera.getString("nombre");
            Double precioUnitario = madera.getDouble("precioUnitario");

            if (precioUnitario == null) {
                System.out.println("Error: Precio de la madera no disponible para '" + maderaNombre + "'.");
                compraExitosa = false;
                continue;
            }

            int cantidadDisponible = madera.getInteger("cantidad", 0);

            if (cantidadDisponible < cantidad) {
                System.out.println("Error: No hay suficiente stock de la madera '" + maderaNombre + "'. Stock disponible: " + cantidadDisponible);
                compraExitosa = false;
                continue;
            }

            // Actualizar stock
            int nuevaCantidad = cantidadDisponible - cantidad;
            maderaCollection.updateOne(Filters.eq("_id", maderaId),
                    new Document("$set", new Document("cantidad", nuevaCantidad)));

            // Crear una compra individual para cada madera
            Calendar fechaCompra = Calendar.getInstance();
            Compra compra = new Compra(fechaCompra, precioUnitario * cantidad, cantidad);
            compra.setUsuario(new Usuario(usuarioId, usuarioNombre));

            // Crear y establecer la madera
            Madera maderaObj = new Madera();
            maderaObj.setId(maderaId);
            maderaObj.setNombre(maderaNombre);
            maderaObj.setPrecioUnitario(precioUnitario);
            compra.setMadera(maderaObj);

            compras.add(compra);
        }

        if (!compraExitosa) {
            System.out.println("Error: No se pudieron procesar todas las compras. Revisa los productos.");
            return;
        }

        // Guardar todas las compras
        double precioTotalCarrito = 0;
        int cantidadTotalCarrito = 0;

        for (Compra compra : compras) {
            guardarCompra(compra);
            precioTotalCarrito += compra.getPrecioTotal();
            cantidadTotalCarrito += compra.getCantidad();
        }

        // Limpiar el carrito
        collection.updateOne(Filters.eq("usuarioId", usuarioId),
                new Document("$set", new Document("maderas", new ArrayList<>()))
        );

        System.out.println("Compra realizada con éxito para el usuario " + usuarioNombre);
        System.out.println("Precio total del carrito: " + precioTotalCarrito);
        System.out.println("Cantidad total de productos: " + cantidadTotalCarrito);
    }
/**
     * Obtiene el historial de compras de un usuario.
     * 
     * @param usuarioId ID del usuario
     * @return Lista de Documents con las compras del usuario
     */
    public List<Document> obtenerHistorialCompras(ObjectId usuarioId) {
        List<Document> historialCompras = new ArrayList<>();

        FindIterable<Document> compras = coleccionCompras.find(Filters.eq("usuarioNombre", obtenerNombreUsuario(usuarioId)));

        for (Document compraDoc : compras) {
            historialCompras.add(compraDoc);
        }

        if (historialCompras.isEmpty()) {
            System.out.println("No se encontraron compras para el usuario con ID: " + usuarioId);
        } else {
            System.out.println("Historial de compras obtenido correctamente para el usuario.");
        }

        return historialCompras;
    }
/**
     * Obtiene una compra específica por su ID.
     * 
     * @param compraId ID de la compra en formato String
     * @return Document con la información de la compra
     */
    public Document obtenerCompraPorId(String compraId) {
        return collection.find(Filters.eq("_id", new ObjectId(compraId))).first();
    }
}
