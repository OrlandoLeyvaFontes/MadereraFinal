/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import conexion.Conexion;
import entidades.UsuarioVentas;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;
import interfacesDAO.IUsuarioVentasDAO;

/**
 *
 * @author aleja
 */
public class UsuarioVentasDAO implements IUsuarioVentasDAO {

    private final MongoCollection<Document> collection;

    public UsuarioVentasDAO() {
        this.collection = Conexion.getDatabase().getCollection("usuariosVentas");
    }

    @Override
    public UsuarioVentas agregarUsuario(UsuarioVentas usuarioVentas) {
        try {
            Document document = new Document("nombre", usuarioVentas.getNombre())
                    .append("apellidoPaterno", usuarioVentas.getApellidoPaterno())
                    .append("apellidoMaterno", usuarioVentas.getApellidoMaterno())
                    .append("numero", usuarioVentas.getNumero())
                    .append("correo", usuarioVentas.getCorreo())
                    .append("contraseña", usuarioVentas.getContraseña());

            collection.insertOne(document);

            usuarioVentas.setId(document.getObjectId("_id"));
            return usuarioVentas;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public UsuarioVentas iniciarSesion(String correo, String contrasena) {
        try {
            Document query = new Document("correo", correo).append("contraseña", contrasena);
            Document result = collection.find(query).first();

            if (result != null) {
                UsuarioVentas usuarioVentas = new UsuarioVentas();
                usuarioVentas.setId(result.getObjectId("_id"));
                usuarioVentas.setNombre(result.getString("nombre"));
                usuarioVentas.setApellidoPaterno(result.getString("apellidoPaterno"));
                usuarioVentas.setApellidoMaterno(result.getString("apellidoMaterno"));
                usuarioVentas.setNumero(result.getString("numero"));
                usuarioVentas.setCorreo(result.getString("correo"));
                usuarioVentas.setContraseña(result.getString("contraseña"));
                return usuarioVentas;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public UsuarioVentas obtenerUsuarioPorId(ObjectId id) {
        MongoCollection<Document> coleccionUsuariosVentas = Conexion.getDatabase().getCollection("usuariosVenta"); // Asegúrate de obtener la base de datos correctamente
        Document doc = coleccionUsuariosVentas.find(Filters.eq("_id", id)).first();
        if (doc != null) {
            return new UsuarioVentas(doc.getObjectId("_id"), doc.getString("nombre"));
        }
        return null;
    }

    @Override
    public List<Document> obtenerMaderasPorUsuarioVenta(ObjectId idUsuarioVenta) {
        try {
            MongoCollection<Document> coleccionUsuariosVenta = Conexion.getDatabase().getCollection("usuariosventa");

            // Busca al usuario por su ID
            Document usuarioVenta = coleccionUsuariosVenta.find(Filters.eq("_id", idUsuarioVenta)).first();

            if (usuarioVenta == null) {
                System.out.println("UsuarioVenta no encontrado");
                return new ArrayList<>();
            }

            // Extrae las maderas asociadas
            List<Document> maderas = (List<Document>) usuarioVenta.get("maderas");

            if (maderas == null || maderas.isEmpty()) {
                System.out.println("El UsuarioVenta no tiene maderas registradas");
                return new ArrayList<>();
            }

            // Imprime las maderas encontradas para depuración
            System.out.println("Maderas encontradas: " + maderas);

            return maderas;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>(); // Devuelve lista vacía en caso de error
        }
    }

}
