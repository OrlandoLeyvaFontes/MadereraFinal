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
public class CompraDAO implements ICompraDAO {

    private MongoCollection<Document> collection;

    private final MongoCollection<Document> coleccionCompras;
    private final MongoCollection<Document> maderaCollection;
    private final MongoCollection<Document> usuarioCollection;

    public CompraDAO() {
        this.collection = Conexion.getDatabase().getCollection("Carrito");

        this.coleccionCompras = Conexion.getDatabase().getCollection("compras");
        this.maderaCollection = Conexion.getDatabase().getCollection("Madera");
        this.usuarioCollection = Conexion.getDatabase().getCollection("usuarios");
    }

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

    private Document obtenerMadera(ObjectId maderaId) {
        return maderaCollection.find(Filters.eq("_id", maderaId)).first();
    }

    private String obtenerNombreUsuario(ObjectId usuarioId) {
        Document usuarioDoc = usuarioCollection.find(Filters.eq("_id", usuarioId)).first();
        return usuarioDoc != null ? usuarioDoc.getString("nombre") : "Desconocido";
    }

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

    @Override
    public List<Document> obtenerComprasPorUsuarioId(ObjectId usuarioId) {
        List<Document> resultados = new ArrayList<>();

        // Buscar las compras relacionadas con el usuario
        FindIterable<Document> documentosCompras = coleccionCompras.find(eq("usuarioId", usuarioId));

        for (Document doc : documentosCompras) {
            Document resultado = new Document();
            resultado.append("fechaCompra", doc.getDate("fechaCompra"));
            resultado.append("cantidad", doc.getInteger("cantidad", 0));
            resultado.append("precioTotal", doc.getDouble("precioTotal"));

            ObjectId maderaId = doc.getObjectId("maderaId");
            Document maderaDoc = maderaCollection.find(eq("_id", maderaId)).first();
            if (maderaDoc != null) {
                resultado.append("nombreMadera", maderaDoc.getString("nombre"));
            } else {
                resultado.append("nombreMadera", "Madera no encontrada");
            }

            resultados.add(resultado);
        }

        return resultados;
    }

}
