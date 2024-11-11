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
//
//        Usuario nuevoUsuario = new Usuario("Juan", "Perez", "Gomez", "123456789", "juan.perez@example.com", "12345");
//
//        Usuario usuarioGuardado = usuarioDAO.agregarUsuario(nuevoUsuario);


        String correo = "juan.perez@example.com"; 
        String contrasena = "12345";

        Usuario usuario = usuarioDAO.iniciarSesion(correo, contrasena);

        if (usuario != null) {
            System.out.println("Inicio de sesión exitoso:");
            System.out.println("Nombre: " + usuario.getNombre());
            System.out.println("Apellido Paterno: " + usuario.getApellidoPaterno());
            System.out.println("Apellido Materno: " + usuario.getApellidoMaterno());
            System.out.println("Número: " + usuario.getNumero());
            System.out.println("Correo: " + usuario.getCorreo());
        } else {
            System.out.println("Credenciales incorrectas o usuario no encontrado.");
        }
    }

    
    }
    
    

