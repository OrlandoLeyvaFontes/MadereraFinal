/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prueba;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
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
  
       UsuarioDAO usuarioDAO = new UsuarioDAO();

    String cvv = "e";

    if (!usuarioDAO.iniciarSesionPorCVV(cvv)) {
        System.out.println("Inicio de sesión fallido. CVV incorrecto.");
        return; 
    }

    System.out.println("Inicio de sesión exitoso.");
    }
    
    
    
    }
    
    

    


