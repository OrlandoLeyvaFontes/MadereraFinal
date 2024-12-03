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
/**
 * Implementación de la interfaz ICarritoDAO para MongoDB. Maneja las
 * operaciones del carrito de compras en la base de datos.
 */
public class CarritoDAO implements ICarritoDAO {

    /**
     * Colección de carritos en MongoDB
     */
    private MongoCollection<Document> collection;
    /**
     * Colección de usuarios en MongoDB
     */

    private MongoCollection<Document> usuarioCollection;
    /**
     * Colección de productos de madera en MongoDB
     */

    private MongoCollection<Document> maderaCollection;

    /**
     * Constructor que inicializa las conexiones a las colecciones necesarias.
     */
    public CarritoDAO() {
        this.collection = Conexion.getDatabase().getCollection("Carrito");
        this.usuarioCollection = Conexion.getDatabase().getCollection("usuarios");
        this.maderaCollection = Conexion.getDatabase().getCollection("Madera");
    }

    /**
     * Agrega un producto al carrito o actualiza su cantidad si ya existe.
     *
     * @param usuarioId ID del usuario dueño del carrito
     * @param maderaId ID del producto a agregar
     * @param cantidad Cantidad a agregar
     * @throws IllegalArgumentException si la cantidad es menor o igual a 0
     */
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

    /**
     * Método privado que agrega o actualiza un producto en un carrito
     * existente.
     *
     * @param carrito Documento del carrito existente
     * @param maderaId ID del producto
     * @param cantidad Cantidad a agregar
     */
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

    /**
     * Método privado que crea un nuevo carrito con un producto inicial.
     *
     * @param usuarioId ID del usuario
     * @param maderaId ID del producto
     * @param cantidad Cantidad inicial
     */
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

    /**
     * Obtiene el carrito de un usuario específico.
     *
     * @param usuarioId ID del usuario
     * @return Document con la información del carrito o null si no existe
     */
    public Document obtenerCarrito(ObjectId usuarioId) {
        return collection.find(Filters.eq("usuarioId", usuarioId)).first();
    }

    /**
     * Elimina un producto específico del carrito de un usuario.
     *
     * @param usuarioId ID del usuario
     * @param maderaId ID del producto a eliminar
     */
    public void eliminarProducto(ObjectId usuarioId, ObjectId maderaId) {
        collection.updateOne(
                Filters.eq("usuarioId", usuarioId),
                Updates.pull("maderas", Filters.eq("id", maderaId))
        );
    }

    /**
     * Método privado que obtiene el nombre de un usuario por su ID.
     *
     * @param usuarioId ID del usuario
     * @return Nombre del usuario o "Desconocido" si no se encuentra
     */
    private String obtenerNombreUsuario(ObjectId usuarioId) {
        Document usuario = usuarioCollection.find(Filters.eq("_id", usuarioId)).first();
        return usuario != null ? usuario.getString("nombre") : "Desconocido";
    }

    /**
     * Método privado que obtiene el nombre de un producto por su ID.
     *
     * @param maderaId ID del producto
     * @return Nombre del producto o "Desconocida" si no se encuentra
     */
    private String obtenerNombreMadera(ObjectId maderaId) {
        Document madera = maderaCollection.find(Filters.eq("_id", maderaId)).first();
        return madera != null ? madera.getString("nombre") : "Desconocida";
    }

    /**
     * Elimina completamente el carrito de un usuario.
     *
     * @param usuarioId ID del usuario
     */
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
