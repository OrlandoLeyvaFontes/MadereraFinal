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
 * Clase que implementa la interfaz IUsuarioVentasDAO para realizar operaciones
 * CRUD sobre la colección "usuariosVentas" en MongoDB.
 *
 * Métodos disponibles: - agregarUsuario: Inserta un nuevo usuario de ventas en
 * la base de datos. - iniciarSesion: Busca un usuario por su correo
 * electrónico. - obtenerUsuarioPorId: Obtiene un usuario de ventas por su ID. -
 * obtenerMaderasPorUsuarioVenta: Obtiene las maderas asociadas a un usuario de
 * ventas dado su ID.
 */
public class UsuarioVentasDAO implements IUsuarioVentasDAO {

    private final MongoCollection<Document> collection;

    /**
     * Constructor de la clase, establece la colección "usuariosVentas" de
     * MongoDB.
     */
    public UsuarioVentasDAO() {
        this.collection = Conexion.getDatabase().getCollection("usuariosVentas");
    }

    /**
     * Método que agrega un nuevo usuario de ventas a la base de datos.
     *
     * @param usuarioVentas Objeto que contiene los datos del usuario a agregar.
     * @return El objeto UsuarioVentas con su ID generado por la base de datos.
     */
    @Override
    public UsuarioVentas agregarUsuario(UsuarioVentas usuarioVentas) {
        try {
            // Crear el documento a insertar en la base de datos
            Document document = new Document("nombre", usuarioVentas.getNombre())
                    .append("apellidoPaterno", usuarioVentas.getApellidoPaterno())
                    .append("apellidoMaterno", usuarioVentas.getApellidoMaterno())
                    .append("numero", usuarioVentas.getNumero())
                    .append("correo", usuarioVentas.getCorreo())
                    .append("contraseña", usuarioVentas.getContraseña());

            // Insertar el documento en la colección "usuariosVentas"
            collection.insertOne(document);

            // Establecer el ID generado por MongoDB a la entidad UsuarioVentas
            usuarioVentas.setId(document.getObjectId("_id"));
            return usuarioVentas;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Método que busca un usuario de ventas por su correo electrónico.
     *
     * @param correo El correo electrónico del usuario a buscar.
     * @return El objeto UsuarioVentas si se encuentra, o null si no existe.
     */
    @Override
    public UsuarioVentas iniciarSesion(String correo) {
        try {
            // Crear la consulta para buscar el usuario por correo
            Document query = new Document("correo", correo);
            Document result = collection.find(query).first();

            if (result != null) {
                // Crear el objeto UsuarioVentas con los datos del documento
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

    /**
     * Método que obtiene un usuario de ventas a partir de su ID.
     *
     * @param id El ID del usuario a buscar.
     * @return El objeto UsuarioVentas correspondiente al ID, o null si no se
     * encuentra.
     */
    @Override
    public UsuarioVentas obtenerUsuarioPorId(ObjectId id) {
        MongoCollection<Document> coleccionUsuariosVentas = Conexion.getDatabase().getCollection("usuariosVenta");
        Document doc = coleccionUsuariosVentas.find(Filters.eq("_id", id)).first();
        if (doc != null) {
            return new UsuarioVentas(doc.getObjectId("_id"), doc.getString("nombre"));
        }
        return null;
    }

    /**
     * Método que obtiene las maderas asociadas a un usuario de ventas dado su
     * ID.
     *
     * @param idUsuarioVenta El ID del usuario de ventas.
     * @return Una lista de documentos que contienen la información de las
     * maderas asociadas al usuario.
     */
    @Override
    public List<Document> obtenerMaderasPorUsuarioVenta(ObjectId idUsuarioVenta) {
        try {
            MongoCollection<Document> coleccionUsuariosVenta = Conexion.getDatabase().getCollection("usuariosventa");

            // Buscar el usuario por su ID
            Document usuarioVenta = coleccionUsuariosVenta.find(Filters.eq("_id", idUsuarioVenta)).first();

            if (usuarioVenta == null) {
                System.out.println("UsuarioVenta no encontrado");
                return new ArrayList<>();
            }

            // Extraer las maderas asociadas al usuario
            List<Document> maderas = (List<Document>) usuarioVenta.get("maderas");

            if (maderas == null || maderas.isEmpty()) {
                System.out.println("El UsuarioVenta no tiene maderas registradas");
                return new ArrayList<>();
            }

            return maderas;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>(); // Devuelve lista vacía en caso de error
        }
    }
}
