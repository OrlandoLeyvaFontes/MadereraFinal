/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import conexion.Conexion;
import entidades.Madera;
import interfacesDAO.ICarritoDAO;
import java.util.Arrays;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
public class CarritoDAO implements ICarritoDAO {

    private MongoCollection<Document> collection;
    private MongoCollection<Document> usuarioCollection;
    private MongoCollection<Document> maderaCollection;

    public CarritoDAO() {
        this.collection = Conexion.getDatabase().getCollection("Carrito");
        this.usuarioCollection = Conexion.getDatabase().getCollection("usuarios");
        this.maderaCollection = Conexion.getDatabase().getCollection("Madera");
    }

    public void agregarProducto(ObjectId usuarioId, ObjectId maderaId, int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0.");
        }

        Document carrito = collection.find(Filters.eq("usuarioId", usuarioId)).first();

        if (carrito != null) {
            agregarOActualizarProductoEnCarrito(carrito, maderaId, cantidad);
        } else {
            crearCarrito(usuarioId, maderaId, cantidad);
        }
    }


    private void agregarOActualizarProductoEnCarrito(Document carrito, ObjectId maderaId, int cantidad) {
        List<Document> maderas = carrito.getList("maderas", Document.class);
        if (maderas != null) {
            boolean productoEncontrado = false;
            for (int i = 0; i < maderas.size(); i++) {
                Document maderaEnCarrito = maderas.get(i);
                if (maderaEnCarrito.getObjectId("id").equals(maderaId)) {
                    int nuevaCantidad = maderaEnCarrito.getInteger("cantidad") + cantidad;
                    collection.updateOne(
                            Filters.eq("_id", carrito.getObjectId("_id")),
                            Updates.set("maderas." + i + ".cantidad", nuevaCantidad)
                    );
                    productoEncontrado = true;
                    break;
                }
            }

            if (!productoEncontrado) {
                collection.updateOne(
                        Filters.eq("_id", carrito.getObjectId("_id")),
                        Updates.push("maderas", new Document("id", maderaId)
                                .append("cantidad", cantidad)
                                .append("nombre", obtenerNombreMadera(maderaId))
                                .append("usuarioNombre", obtenerNombreUsuario(carrito.getObjectId("usuarioId"))))
                );
            }
        } else {
            System.out.println("El campo 'maderas' es nulo o no existe.");
        }
    }

    private void crearCarrito(ObjectId usuarioId, ObjectId maderaId, int cantidad) {
        Document nuevoCarrito = new Document("usuarioId", usuarioId)
                .append("maderas", Arrays.asList(
                        new Document("id", maderaId)
                                .append("cantidad", cantidad)
                                .append("nombre", obtenerNombreMadera(maderaId))
                                .append("usuarioNombre", obtenerNombreUsuario(usuarioId))
                ));

        collection.insertOne(nuevoCarrito);
    }

    public Document obtenerCarrito(ObjectId usuarioId) {
        return collection.find(Filters.eq("usuarioId", usuarioId)).first();
    }

    public void eliminarProducto(ObjectId usuarioId, ObjectId maderaId) {
        collection.updateOne(
                Filters.eq("usuarioId", usuarioId),
                Updates.pull("maderas", Filters.eq("id", maderaId))
        );
    }

    private String obtenerNombreUsuario(ObjectId usuarioId) {
        Document usuario = usuarioCollection.find(Filters.eq("_id", usuarioId)).first();
        return usuario != null ? usuario.getString("nombre") : "Desconocido";
    }

    private String obtenerNombreMadera(ObjectId maderaId) {
        Document madera = maderaCollection.find(Filters.eq("_id", maderaId)).first();
        return madera != null ? madera.getString("nombre") : "Desconocida";
    }
public void vaciarCarrito(ObjectId usuarioId) {
    Document carrito = collection.find(Filters.eq("usuarioId", usuarioId)).first();
    if (carrito != null) {
        collection.deleteOne(Filters.eq("_id", carrito.getObjectId("_id")));
        System.out.println("Carrito eliminado: " + carrito.toJson());
    } else {
        System.out.println("No se encontró el carrito para el usuario: " + usuarioId);
    }
}


}
