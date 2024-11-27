/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import conexion.Conexion;
import entidades.Madera;
import interfacesDAO.IMaderaDAO;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
public class MaderaDAO implements IMaderaDAO {

    private final MongoCollection<Document> collection;

    public MaderaDAO() {
        this.collection = Conexion.getDatabase().getCollection("Madera");
    }

    @Override
    public Madera agregarMadera(Madera madera) {
        try {
            Document document = new Document("nombre", madera.getNombre())
                    .append("descripcion", madera.getDescripcion())
                    .append("cantidad", madera.getCantidad())
                    .append("precioUnitario", madera.getPrecioUnitario());
            collection.insertOne(document);

            madera.setId(document.getObjectId("_id"));
            return madera;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Madera> obtenerMaderas() {
        List<Madera> listaMaderas = new ArrayList<>();
        try {
            FindIterable<Document> documentos = collection.find();
            for (Document documento : documentos) {
                Madera madera = new Madera();
                madera.setId(documento.getObjectId("_id"));
                madera.setNombre(documento.getString("nombre"));
                madera.setDescripcion(documento.getString("descripcion"));
                madera.setPrecioUnitario(documento.getDouble("precioUnitario"));
                madera.setCantidad(documento.getInteger("cantidad"));
                listaMaderas.add(madera);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaMaderas;
    }

    @Override
    public Madera buscarMaderaPorId(String id) {
        try {
            ObjectId objectId = new ObjectId(id);

            Document documento = collection.find(new Document("_id", objectId)).first();

            if (documento != null) {
                Madera madera = new Madera();
                madera.setId(documento.getObjectId("_id"));
                madera.setNombre(documento.getString("nombre"));
                madera.setDescripcion(documento.getString("descripcion"));
                madera.setCantidad(documento.getInteger("cantidad", 0));
                madera.setPrecioUnitario(documento.getDouble("precioUnitario"));
                return madera;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Madera obtenerMaderaPorId(ObjectId id) {
        MongoCollection<Document> coleccionMadera = Conexion.getDatabase().getCollection("Madera"); // Asegúrate de obtener la base de datos correctamente
        Document doc = coleccionMadera.find(Filters.eq("_id", id)).first();
        if (doc != null) {
            return new Madera(doc.getObjectId("_id"), doc.getString("nombre"));
        }
        return null;
    }

    @Override
    public void actualizar(Madera madera) {
        Document filtro = new Document("_id", madera.getId());
        Document actualizacion = new Document("$set", new Document("cantidad", madera.getCantidad()));

        collection.updateOne(filtro, actualizacion);
    }

    // Método para obtener maderas asociadas a un usuario de ventas
    public List<Madera> obtenerMaderasPorUsuarioVenta(ObjectId idUsuarioVenta) {
        // Simulación de consulta a la base de datos (MongoDB)
        List<Document> documentosMaderas = Conexion.getDatabase().getCollection("usuariosVenta")
                .find(new Document("_id", idUsuarioVenta))
                .projection(new Document("maderas", 1))
                .first()
                .getList("maderas", Document.class);

        List<Madera> maderas = new ArrayList<>();
        if (documentosMaderas != null) {
            for (Document doc : documentosMaderas) {
                Madera madera = new Madera();
                madera.setId(doc.getObjectId("_id"));
                madera.setNombre(doc.getString("nombre"));
                madera.setDescripcion(doc.getString("tipo"));
                madera.setCantidad(doc.getInteger("cantidad"));
                madera.setPrecioUnitario(doc.getDouble("precio"));
                maderas.add(madera);
            }
        }
        return maderas;
    }
}
