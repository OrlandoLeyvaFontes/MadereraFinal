/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prueba;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import dao.MaderaCompraDAO;
import dao.MaderaDAO;
import org.bson.Document;
import org.bson.types.ObjectId;
/**
 *
 * @author Oley
 */
public class Main {
    public static void main(String[] args) {
        
    
    /*
    Clase que sirve para probar metodos
    */
        
         // Conexión a MongoDB
        String uri = "mongodb://localhost:27017"; 
        var mongoClient = MongoClients.create(uri);
        MongoDatabase database = mongoClient.getDatabase("maderera");

//        // Crear el DAO
//        MaderaDAO maderaCompraDAO = new MaderaDAO();
//
//        // Llamada al método para actualizar la cantidad y precio
//        ObjectId idMadera = new ObjectId("673844838019a752f44cd532");
//        int nuevaCantidad = 20; // Nueva cantidad de madera
//
//        // Actualizar la madera en la base de datos
//        maderaCompraDAO.actualizarCantidadYPrecio(idMadera, nuevaCantidad);
    }
    }
    
    

