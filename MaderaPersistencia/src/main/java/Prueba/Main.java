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
        
         // Conexión a MongoDB
        String uri = "mongodb://localhost:27017"; 
        var mongoClient = MongoClients.create(uri);
        MongoDatabase database = mongoClient.getDatabase("maderera");
  
         CompraDAO compraDAO = new CompraDAO();
        MaderaDAO maderaDAO = new MaderaDAO(); // Asegúrate de tener un DAO para Madera
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // Crear datos de ejemplo (IDs válidos de Madera y Usuario)
        ObjectId maderaId = new ObjectId("673854a7673d5472ce4f0e80"); // ID de Madera en tu colección
        ObjectId usuarioId = new ObjectId("673854b1673d5472ce4f0e84"); // ID de Usuario en tu colección

        // Obtener la Madera y Usuario de la base de datos usando sus IDs
        Madera madera = maderaDAO.obtenerMaderaPorId(maderaId);
        Usuario usuario = usuarioDAO.obtenerUsuarioPorId(usuarioId);

        // Verificar que los objetos fueron encontrados
        if (madera == null) {
            System.out.println("Madera no encontrada.");
            return;
        }
        if (usuario == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }

        // Obtener precio unitario de la madera
        Double precioUnitario = madera.getPrecioUnitario();
        if (precioUnitario == null) {
            System.out.println("Error: El precio unitario de la madera no está definido.");
            return;  // Termina el flujo si el precio unitario es nulo
        }

        // Crear la Compra
        Compra compra = new Compra();
        compra.setId(new ObjectId());  // El ID lo genera MongoDB al insertarlo
        compra.setFechaCompra(Calendar.getInstance());
        compra.setCantidad(2);  // Puedes ajustar la cantidad
        compra.setMadera(madera);  // Asignar el objeto Madera correctamente
        compra.setUsuario(usuario);

        // Calcular el precio total (sin descuentos)
        double precioTotal = precioUnitario * compra.getCantidad();
        compra.setPrecioTotal(precioTotal);  // Asignar el precio total a la compra

        // Guardar la compra en la base de datos
        compraDAO.guardarCompra(compra);

        
        
        
    }
    
    
    
    }
    
    

    


