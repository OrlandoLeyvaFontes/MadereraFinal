/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import conexion.Conexion;
import entidades.Compra;
import entidades.Madera;
import entidades.Usuario;
import interfacesDAO.ICompraDAO;
import java.util.Calendar;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
public class CompraDAO implements  ICompraDAO{

    private final MongoCollection<Document> coleccionCompras;
    private final MongoCollection<Document> coleccionMaderas;
    private final MongoCollection<Document> coleccionUsuarios;

    public CompraDAO( ) {
        this.coleccionCompras = Conexion.getDatabase().getCollection("compras");
        this.coleccionMaderas = Conexion.getDatabase().getCollection("Madera");
        this.coleccionUsuarios = Conexion.getDatabase().getCollection("usuarios");
    }

   

    @Override
    public void guardarCompra(Compra compra) {
   ObjectId maderaId = compra.getMadera().getId();
    String maderaNombre = null;
    double precioTotal = 0;

    if (maderaId != null) {
        Document maderaDoc = coleccionMaderas.find(Filters.eq("_id", maderaId)).first();
        if (maderaDoc != null) {
            maderaNombre = maderaDoc.getString("nombre");
            Integer cantidadActual = maderaDoc.getInteger("cantidad", 0);
            Integer cantidadSolicitada = compra.getCantidad();
            Integer nuevaCantidad = cantidadActual - cantidadSolicitada;

            if (nuevaCantidad < 0) {
                System.out.println("Error: No hay suficiente madera en stock.");
                return;
            }

            coleccionMaderas.updateOne(Filters.eq("_id", maderaId), 
                new Document("$set", new Document("cantidad", nuevaCantidad)));

            Double precioUnitario = maderaDoc.getDouble("precioUnitario");
            if (precioUnitario != null) {
                precioTotal = precioUnitario * cantidadSolicitada;
            } else {
                System.out.println("Error: Precio de madera no disponible.");
                return;
            }
        }
    }

    ObjectId usuarioId = compra.getUsuario().getId();
    String usuarioNombre = null;
    if (usuarioId != null) {
        Document usuarioDoc = coleccionUsuarios.find(Filters.eq("_id", usuarioId)).first();
        if (usuarioDoc != null) {
            usuarioNombre = usuarioDoc.getString("nombre");
        }
    }

    Document doc = new Document("fechaCompra", compra.getFechaCompra().getTime())
            .append("precioTotal", precioTotal)
            .append("cantidad", compra.getCantidad())
            .append("maderaNombre", maderaNombre)
            .append("usuarioNombre", usuarioNombre);

    coleccionCompras.insertOne(doc);
    compra.setId(doc.getObjectId("_id"));

    System.out.println("Compra guardada correctamente:");
    System.out.println("Madera: " + maderaNombre);
    System.out.println("Cantidad: " + compra.getCantidad());
    System.out.println("Precio total: " + precioTotal);
    System.out.println("Comprador: " + usuarioNombre); }
}
