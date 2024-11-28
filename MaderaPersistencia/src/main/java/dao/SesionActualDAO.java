/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mongodb.client.MongoCollection;
import conexion.Conexion;
import entidades.SesionActual;
import org.bson.Document;

/**
 *
 * @author aleja
 */
public class SesionActualDAO {

    private final MongoCollection<Document> collection;

    public SesionActualDAO() {
        this.collection = Conexion.getDatabase().getCollection("sesionActual");
    }

    public SesionActual guardarSesion(SesionActual sesion) {
        MongoCollection<Document> collection = Conexion.getDatabase().getCollection("sesionActual");
        Document doc = new Document("correoVendedor", sesion.getCorreo());
        collection.insertOne(doc);
        try {
            Document query = new Document("correoVendedor", sesion.getCorreo());
            Document result = collection.find(query).first();
            if (result != null) {
                SesionActual sesionActual = new SesionActual();
                sesionActual.setCorreo(result.getString("correoVendedor"));
                return sesionActual;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
