/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
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

    @Override
    public Madera buscarMaderaPorNombre(String nombre) {
        try {
            Document filtro = new Document("nombre", nombre);

            Document documento = collection.find(filtro).first();

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

    public void editarMadera(Madera madera) {

        try {

            // Asegúrate de que el ID no sea null y que corresponda a un documento existente
            if (madera.getId() == null) {
                throw new IllegalArgumentException("El ID de la madera no puede ser nulo.");
            }

            // Filtro para encontrar el documento con el ID especificado
            Document filtro = new Document("_id", madera.getId());

            // Documento de actualización
            Document actualizacion = new Document("$set", new Document("nombre", madera.getNombre())
                    .append("descripcion", madera.getDescripcion())
                    .append("cantidad", madera.getCantidad())
                    .append("precioUnitario", madera.getPrecioUnitario()));

            // Realiza la actualización en la base de datos
            UpdateResult result = collection.updateOne(filtro, actualizacion);

            // Verificar que se haya realizado la actualización
            if (result.getModifiedCount() == 0) {
                throw new RuntimeException("No se encontró la madera para actualizar con el ID proporcionado.");
            }

            // Opcional: Si deseas confirmar que se ha actualizado un registro, puedes imprimir el resultado
            System.out.println("Se actualizó la madera con ID: " + madera.getId());

        } catch (Exception e) {
            // Manejo de errores
            e.printStackTrace();
            throw new RuntimeException("Error al intentar editar la madera: " + e.getMessage());
        }
    }

    public boolean eliminarMadera(String id) {
        try {
            ObjectId objectId = new ObjectId(id);

            Document filter = new Document("_id", objectId);

            DeleteResult result = collection.deleteOne(filter);

            return result.getDeletedCount() > 0;
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("El ID proporcionado no es válido: " + id, e);
        } catch (Exception e) {
            throw new RuntimeException("Error al intentar eliminar la madera", e);
        }
    }
    

}
