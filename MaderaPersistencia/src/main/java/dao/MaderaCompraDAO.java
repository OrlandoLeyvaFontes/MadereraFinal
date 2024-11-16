/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mongodb.client.MongoCollection;
import conexion.Conexion;
import interfacesDAO.IMaderaCompraDAO;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
public class MaderaCompraDAO implements IMaderaCompraDAO{
  private final MongoCollection<Document> collection;
 public MaderaCompraDAO() {
        this.collection = Conexion.getDatabase().getCollection("MaderaCompra");
    }
    
    
}
