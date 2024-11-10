/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prueba;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import dao.UsuarioDAO;
import entidades.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Oley
 */
public class Main {
    public static void main(String[] args) {
        
    
    /*
    Clase que sirve para probar metodos
    */
     String uri = "mongodb://localhost:27017";
        MongoClient mongoClient = MongoClients.create(uri);
        MongoDatabase database = mongoClient.getDatabase("maderera");

        UsuarioDAO usuarioDAO = new UsuarioDAO();

        Usuario nuevoUsuario = new Usuario("Juan", "Perez", "Gomez", "123456789", "juan.perez@example.com", "12345");

        Usuario usuarioGuardado = usuarioDAO.agregarUsuario(nuevoUsuario);

        

    
    }
    
    
}
