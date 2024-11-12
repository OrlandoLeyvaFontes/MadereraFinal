/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mongodb.client.MongoCollection;
import conexion.Conexion;
import entidades.Tarjetas;
import entidades.Usuario;
import interfacesDAO.ITarjetasDAO;
import org.bson.Document;

/**
 *
 * @author Oley
 */
public class TarjetasDAO implements ITarjetasDAO{
  private final MongoCollection<Document> collection;

    public TarjetasDAO() {
        this.collection = Conexion.getDatabase().getCollection("tarjetas");
    }

    @Override
    public Tarjetas agregarTarjetas(Tarjetas tarjetas) {
try {
            Document document = new Document("nombre", tarjetas.getNombre())
                .append("numero", tarjetas.getNombre())
                .append("fehcaVencimiento",tarjetas.getFehcaVencimiento().getTime())
                .append("CVV", tarjetas.getCVV())
                ;

            collection.insertOne(document);

            tarjetas.setId(document.getObjectId("_id"));
            return tarjetas;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

   
        
    
}
