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
import interfacesDAO.ISalidaDAO;
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
/**
 * Implementación de la interfaz ISalidaDAO para MongoDB. Maneja las operaciones
 * relacionadas con las salidas de inventario y su registro.
 */
public class SalidaDAO implements ISalidaDAO {

    /**
     * Colección de salidas en MongoDB
     */
    private final MongoCollection<Document> collection;
    /**
     * Colección de compras en MongoDB
     */

    private final MongoCollection<Document> coleccionCompras;

    /**
     * Constructor que inicializa las conexiones a las colecciones necesarias.
     */
    public SalidaDAO() {
        this.collection = Conexion.getDatabase().getCollection("Salida");
        this.coleccionCompras = Conexion.getDatabase().getCollection("compras");

    }

    /**
     * Crea un nuevo registro de salida basado en una compra existente.
     *
     * @param compraId ID de la compra asociada
     * @param nuevoTipoMovimiento Tipo de movimiento a registrar
     * @return ObjectId ID de la nueva salida creada
     * @throws IllegalArgumentException si no se encuentra la compra
     * especificada
     */
    public ObjectId crearSalidaDesdeCompra(ObjectId compraId, String nuevoTipoMovimiento) {
        Document compraDoc = coleccionCompras.find(Filters.eq("_id", compraId)).first();

        if (compraDoc == null) {
            throw new IllegalArgumentException("No se encontró la compra con el ID proporcionado");
        }

        System.out.println("Documento de compra: " + compraDoc.toJson());

        Date fechaCompra = compraDoc.getDate("fechaCompra");
        if (fechaCompra == null) {
            System.out.println("La fechaCompra es nula para la compra con ID: " + compraId);
            fechaCompra = new Date();
        }

        Document salidaDoc = new Document()
                .append("compraId", compraId)
                .append("tipoMovimiento", nuevoTipoMovimiento)
                .append("madera", compraDoc.getString("maderaNombre"))
                .append("calendar", fechaCompra)
                .append("cantidad", compraDoc.getInteger("cantidad"))
                .append("usuario", compraDoc.getString("usuarioNombre"));

        collection.insertOne(salidaDoc);

        return salidaDoc.getObjectId("_id");
    }

    /**
     * Obtiene una salida específica por su ID.
     *
     * @param salidaId ID de la salida a buscar
     * @return Salida encontrada o null si no existe
     */
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
                calendar.setTime(new Date());
            }

            int cantidad = doc.getInteger("cantidad");
            String usuario = doc.getString("usuario");

            Salida salida = new Salida(tipoMovimiento, madera, calendar, cantidad, usuario, compraId);
            salida.setId(salidaId);
            return salida;
        }
        return null;
    }

    /**
     * Obtiene todas las salidas registradas en el sistema.
     *
     * @return Lista de todas las salidas
     */
    public List<Salida> obtenerTodasLasSalidas() {
        List<Salida> salidas = new ArrayList<>();
        FindIterable<Document> documentos = collection.find();

        for (Document doc : documentos) {
            ObjectId salidaId = doc.getObjectId("_id");
            ObjectId compraId = doc.getObjectId("compraId");
            String tipoMovimiento = doc.getString("tipoMovimiento");
            String madera = doc.getString("madera");

            Calendar calendar = Calendar.getInstance();
            Date date = doc.getDate("calendar");
            if (date != null) {
                calendar.setTime(date);
            } else {
                calendar.setTime(new Date());
            }

            int cantidad = doc.getInteger("cantidad", 0); // Default 0 si cantidad es nulo
            String usuario = doc.getString("usuario");

            Salida salida = new Salida(tipoMovimiento, madera, calendar, cantidad, usuario, compraId);
            salida.setId(salidaId);
            salidas.add(salida);
        }

        return salidas;
    }

}
