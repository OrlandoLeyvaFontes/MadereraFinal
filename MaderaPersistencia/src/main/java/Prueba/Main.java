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
import dao.SalidaDAO;
import dao.TarjetasDAO;
import dao.UsuarioDAO;
import entidades.Compra;
import entidades.Madera;
import entidades.Salida;
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

    
//    /*
//    Clase que sirve para probar metodos
//    */
//   CarritoDAO carritoDAO = new CarritoDAO();
//
//        // ObjectId del usuario cuyo carrito deseas vaciar
//        ObjectId usuarioId = new ObjectId("674bd6656dc3474361df724e"); // Reemplaza con un ID válido en tu base de datos
//
//        // Llamar al método para vaciar el carrito
//        try {
//            carritoDAO.calcularTotalCarrito(usuarioId);
//            System.out.println("El carrito del usuario ha sido eliminado exitosamente.");
//        } catch (Exception e) {
//            System.err.println("Error al vaciar el carrito: " + e.getMessage());
//        }
//    }
//
//          }
        // Crear un ejemplo de compraId (debe ser un ObjectId válido en tu base de datos)
        
          SalidaDAO salidaDAO = new SalidaDAO();

        // Crear un ObjectId de ejemplo (puedes reemplazarlo por uno real de tu base de datos)
        

            // Ejemplo: Crear una salida desde una compra existente (por ejemplo, usando un ID de compra)
            ObjectId compraId = new ObjectId("674bf60417aacc67b6e68862");  // Asegúrate de que este ID exista en la base de datos
            String nuevoTipoMovimiento = "venta"; // Tipo de movimiento que deseas asignar

            ObjectId salidaId = salidaDAO.crearSalidaDesdeCompra(compraId, nuevoTipoMovimiento);

            Salida salida= salidaDAO.obtenerSalida(salidaId);
           
        }

//        // Obtener una única salida asociada a un compraId
//        Salida salidaUnica = salidaDAO.obtenerUnaPorCompraId(compraId);
//        if (salidaUnica != null) {
//            System.out.println("Salida única asociada a compraId: " + compraId);
//            System.out.println(salidaUnica);
//        } else {
//            System.out.println("No se encontró salida para el compraId: " + compraId);
//        }
    
    }
    
           
    
    
    

    


