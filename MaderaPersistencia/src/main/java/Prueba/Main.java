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
        
        String uri = "mongodb://localhost:27017"; 
        var mongoClient = MongoClients.create(uri);
        MongoDatabase database = mongoClient.getDatabase("maderera");
  
       
     VentaDAO ventasDAO = new VentaDAO();

            // Llamar al método obtenerVentas
            List<Ventas> ventas = ventasDAO.obtenerVentas();

            // Mostrar resultados
            for (Ventas venta : ventas) {
                System.out.println("ID Venta: " + venta.getId());
                System.out.println("Cantidad: " + venta.getCantidad());
                System.out.println("Precio Total: " + venta.getPrecioTotal());
                if (venta.getFechaVenta() != null) {
                    System.out.println("Fecha Venta: " + venta.getFechaVenta().getTime());
                } else {
                    System.out.println("Fecha Venta: N/A");
                }
                System.out.println("Madera: " + (venta.getMadera() != null ? venta.getMadera().getNombre() : "N/A"));
                System.out.println("Usuario: " + (venta.getUsuario() != null ? venta.getUsuario().getNombre() : "N/A"));
                System.out.println("-----------------------------------");
            }

          }
    
    }
    
    

    


