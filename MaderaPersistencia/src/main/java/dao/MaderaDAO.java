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
import dto.MaderaDTO;
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

    public List<MaderaDTO> buscarMaderaPorCorreoVendedor(String correoUsuarioVenta) {
        try {
            MongoCollection<Document> coleccionMadera = Conexion.getDatabase().getCollection("Madera");

            // Buscar las maderas asociadas al correo del vendedor
            FindIterable<Document> results = collection.find(Filters.eq("correoVendedor", correoUsuarioVenta));

            List<MaderaDTO> maderas = new ArrayList<>();
            for (Document doc : results) {
                MaderaDTO madera = new MaderaDTO();
                madera.setNombre(doc.getString("nombre"));
                madera.setDescripcion(doc.getString("descripcion"));
                madera.setCantidad(doc.getInteger("cantidad"));
                madera.setPrecioUnitario(doc.getDouble("precioUnitario"));
                maderas.add(madera);
            }

            return maderas;

        } catch (Exception e) {
            System.err.println("Error al buscar las maderas por correo del vendedor: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public Madera agregarMaderaPorCorreo(String correoVendedor, Madera madera) {
        try {
            // Buscar el vendedor por correo
            MongoCollection<Document> usuariosCollection = Conexion.getDatabase().getCollection("usuarioVentas");
            Document usuario = usuariosCollection.find(eq("correo", correoVendedor)).first();

            if (usuario == null) {
                throw new RuntimeException("No se encontró un vendedor con el correo proporcionado: " + correoVendedor);
            }

            // Obtener el ID del usuario vendedor
            ObjectId idUsuarioVendedor = usuario.getObjectId("_id");

            // Asignar el ID del vendedor a la madera
            MongoCollection<Document> coleccionMadera = Conexion.getDatabase().getCollection("Madera");
            Document maderaDoc = new Document("nombre", madera.getNombre())
                    .append("descripcion", madera.getDescripcion())
                    .append("cantidad", madera.getCantidad())
                    .append("precioUnitario", madera.getPrecioUnitario())
                    .append("idUsuarioVendedor", idUsuarioVendedor);

            // Insertar la madera en la colección
            coleccionMadera.insertOne(maderaDoc);

            // Configurar el ID generado en el objeto madera y retornarlo
            madera.setId(maderaDoc.getObjectId("_id"));
            madera.setCorreoVendedor(correoVendedor);

            return madera;
        } catch (Exception e) {
            System.err.println("Error al agregar la madera: " + e.getMessage());
            throw new RuntimeException("Error al agregar la madera.", e);
        }
    }

}
