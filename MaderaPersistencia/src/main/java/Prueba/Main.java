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
import dao.VentaDAO;
import entidades.Compra;
import entidades.Madera;
import entidades.Usuario;
import entidades.Ventas;
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
   CarritoDAO carritoDAO = new CarritoDAO();

        // ObjectId del usuario cuyo carrito deseas vaciar
        ObjectId usuarioId = new ObjectId("674a562c0367d20b3710d9b6"); // Reemplaza con un ID válido en tu base de datos

        // Llamar al método para vaciar el carrito
        try {
            carritoDAO.vaciarCarrito(usuarioId);
            System.out.println("El carrito del usuario ha sido eliminado exitosamente.");
        } catch (Exception e) {
            System.err.println("Error al vaciar el carrito: " + e.getMessage());
        }
    }

          }
    
    }
    
    

    


