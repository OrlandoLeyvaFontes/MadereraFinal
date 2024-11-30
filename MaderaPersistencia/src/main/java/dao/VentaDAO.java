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
import entidades.Usuario;
import entidades.Ventas;
import interfacesDAO.IVentaDAO;
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
public class VentaDAO implements IVentaDAO {

    private final MongoCollection<Document> coleccionCompras;
    private final MongoCollection<Document> maderaCollection;
    private final MongoCollection<Document> usuarioCollection;

    public VentaDAO() {
        this.coleccionCompras = Conexion.getDatabase().getCollection("compras");
        this.maderaCollection = Conexion.getDatabase().getCollection("Madera");
        this.usuarioCollection = Conexion.getDatabase().getCollection("usuarios");
    }

    public List<Ventas> obtenerVentas() {
        List<Ventas> ventas = new ArrayList<>();

        try {
            FindIterable<Document> documentos = coleccionCompras.find();

            for (Document doc : documentos) {
                Ventas venta = new Ventas();

                venta.setId(doc.getObjectId("_id"));
                venta.setCantidad(doc.getInteger("cantidad"));
                venta.setPrecioTotal(doc.getDouble("precioTotal"));

                // Cambio clave aquí: manejar diferentes tipos de fecha
                Object fechaObj = doc.get("fechaCompra");
                Calendar fechaVenta = Calendar.getInstance();
                if (fechaObj instanceof Date) {
                    fechaVenta.setTime((Date) fechaObj);
                } else if (fechaObj instanceof Long) {
                    fechaVenta.setTimeInMillis((Long) fechaObj);
                }
                venta.setFechaVenta(fechaVenta);

                String maderaNombre = doc.getString("maderaNombre");
                Document maderaDoc = maderaCollection.find(Filters.eq("nombre", maderaNombre)).first();
                if (maderaDoc != null) {
                    Madera madera = new Madera();
                    madera.setId(maderaDoc.getObjectId("_id"));
                    madera.setNombre(maderaNombre);
                    madera.setPrecioUnitario(maderaDoc.getDouble("precioUnitario"));
                    venta.setMadera(madera);
                }

                String usuarioNombre = doc.getString("usuarioNombre");
                Document usuarioDoc = usuarioCollection.find(Filters.eq("nombre", usuarioNombre)).first();
                if (usuarioDoc != null) {
                    Usuario usuario = new Usuario();
                    usuario.setId(usuarioDoc.getObjectId("_id"));
                    usuario.setNombre(usuarioNombre);
                    venta.setUsuario(usuario);
                }

                ventas.add(venta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ventas;
    }
}
