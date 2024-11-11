/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mongodb.client.MongoCollection;
import conexion.Conexion;
import entidades.Madera;
import interfacesDAO.IMaderaDAO;
import org.bson.Document;

/**
 *
 * @author Oley
 */
public class MaderaDAO implements IMaderaDAO{
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

            madera.setId(document.getObjectId("_id")); // Cambiado a "_id"
            return madera;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
}
