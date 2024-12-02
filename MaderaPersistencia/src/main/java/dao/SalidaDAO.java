/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import conexion.Conexion;
import entidades.Madera;
import entidades.Salida;
import entidades.Usuario;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
public class SalidaDAO {
       private final MongoCollection<Document> collection;
    private final MongoCollection<Document> coleccionCompras;

    public SalidaDAO() {
        this.collection = Conexion.getDatabase().getCollection("Salida");
                this.coleccionCompras = Conexion.getDatabase().getCollection("compras");

    }
public ObjectId crearSalidaDesdeCompra(ObjectId compraId, String nuevoTipoMovimiento) {
    Document compraDoc = coleccionCompras.find(Filters.eq("_id", compraId)).first();
    
    if (compraDoc == null) {
        throw new IllegalArgumentException("No se encontró la compra con el ID proporcionado");
    }

    // Imprimir el documento para ver su estructura
    System.out.println("Documento de compra: " + compraDoc.toJson());

    // Obtener la fecha de compra
    Date fechaCompra = compraDoc.getDate("fechaCompra");
    if (fechaCompra == null) {
        System.out.println("La fechaCompra es nula para la compra con ID: " + compraId);
        fechaCompra = new Date(); // Usar la fecha actual si la fechaCompra es nula
    }

    // Creamos el documento de salida con la información de la compra
    Document salidaDoc = new Document()
        .append("compraId", compraId)
        .append("tipoMovimiento", nuevoTipoMovimiento)
        .append("madera", compraDoc.getString("maderaNombre"))  // Ajustado el nombre del campo
        .append("calendar", fechaCompra)        // Ajustado el nombre del campo
        .append("cantidad", compraDoc.getInteger("cantidad"))
        .append("usuario", compraDoc.getString("usuarioNombre")); // Ajustado el nombre del campo

    // Insertamos la nueva salida
    collection.insertOne(salidaDoc);
    
    // Retornamos el ID de la nueva salida
    return salidaDoc.getObjectId("_id");
}


    // Método para obtener la salida creada
  public Salida obtenerSalida(ObjectId salidaId) {
    Document doc = collection.find(Filters.eq("_id", salidaId)).first();
    
    if (doc != null) {
        ObjectId compraId = doc.getObjectId("compraId");
        String tipoMovimiento = doc.getString("tipoMovimiento");
        String madera = doc.getString("madera");
        
        Calendar calendar = Calendar.getInstance();
        Date date = doc.getDate("calendar");
        if (date != null) {
            calendar.setTime(date);
        } else {
            System.out.println("La fecha es nula para la salida con ID: " + salidaId);
            calendar.setTime(new Date()); // Set default current date
        }
        
        int cantidad = doc.getInteger("cantidad");
        String usuario = doc.getString("usuario");
        
        Salida salida = new Salida(tipoMovimiento, madera, calendar, cantidad, usuario, compraId);
        salida.setId(salidaId);
        return salida;
    }
    return null;
}
}
