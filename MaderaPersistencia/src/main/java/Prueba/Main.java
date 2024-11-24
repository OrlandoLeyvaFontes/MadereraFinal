/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prueba;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import dao.CarritoDAO;
import dao.CompraDAO;
import dao.MaderaDAO;
import dao.TarjetasDAO;
import dao.UsuarioDAO;
import entidades.Compra;
import entidades.Madera;
import entidades.Usuario;
import java.util.Calendar;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;
/**
 *
 * @author Oley
 */
public class Main {
    public static void main(String[] args) {
//                try {

    
    /*
    Clase que sirve para probar metodos
    */
        
        String uri = "mongodb://localhost:27017"; 
        var mongoClient = MongoClients.create(uri);
        MongoDatabase database = mongoClient.getDatabase("maderera");
  
       
      CarritoDAO carritoDAO = new CarritoDAO();
    CompraDAO compraDAO = new CompraDAO();

    ObjectId usuarioId = new ObjectId("6741544ce0f6e93e979548da");
    ObjectId maderaId1 = new ObjectId("6742e93febc40c75ca70eb9e");
    ObjectId maderaId2 = new ObjectId("6742e93febc40c75ca70eba0");

    compraDAO.comprarCarrito(usuarioId); 


//    System.out.println("Agregando madera1 al carrito...");
//    carritoDAO.agregarProducto(usuarioId, maderaId1, 3);
//
//    System.out.println("Agregando madera2 al carrito...");
//    carritoDAO.agregarProducto(usuarioId, maderaId2, 2);

//    Document carrito = carritoDAO.obtenerCarrito(usuarioId);
//    System.out.println("Carrito del usuario: " + carrito.toJson());

//    System.out.println("Eliminando madera1 del carrito...");
//    carritoDAO.eliminarProducto(usuarioId, maderaId1);

//    carrito = carritoDAO.obtenerCarrito(usuarioId);
//    System.out.println("Carrito después de eliminar madera1: " + carrito.toJson());
    }
    
    }
    
    

    


