/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.model.Updates;
import conexion.Conexion;
import entidades.Tarjetas;
import entidades.Usuario;
import interfacesDAO.IUsuarioDAO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
/**
 * Implementación de la interfaz IUsuarioDAO para MongoDB. Maneja las
 * operaciones relacionadas con usuarios y sus métodos de pago. 
 */
public class UsuarioDAO implements IUsuarioDAO {

    /**
     * Colección de usuarios en MongoDB
     */

    private final MongoCollection<Document> collection;

    /**
     * Constructor que inicializa la conexión a la colección de usuarios.
     */
    public UsuarioDAO() {
        this.collection = Conexion.getDatabase().getCollection("usuarios");
    }

    /**
     * Registra un nuevo usuario en el sistema.
     *
     * @param usuario Objeto Usuario con la información del nuevo usuario
     * @return Usuario creado con su ID asignado, o null si ocurre un error
     */
    @Override
    public Usuario agregarUsuario(Usuario usuario) {
        try {
            Document document = new Document("nombre", usuario.getNombre())
                    .append("apellidoPaterno", usuario.getApellidoPaterno())
                    .append("apellidoMaterno", usuario.getApellidoMaterno())
                    .append("numero", usuario.getNumero())
                    .append("correo", usuario.getCorreo())
                    .append("contraseña", usuario.getContraseña())
                    .append("tarjetas", new ArrayList<>());

            collection.insertOne(document);

            usuario.setId(document.getObjectId("_id"));
            return usuario;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Agrega una tarjeta de pago a un usuario existente.
     *
     * @param usuarioId ID del usuario
     * @param tarjeta Objeto Tarjetas con la información de la nueva tarjeta
     * @return true si la tarjeta se agregó correctamente, false en caso
     * contrario
     */
    public boolean agregarTarjeta(ObjectId usuarioId, Tarjetas tarjeta) {
        try {
            Document tarjetaDoc = new Document("nombre", tarjeta.getNombre())
                    .append("numero", tarjeta.getNumero())
                    .append("fechaVencimiento", tarjeta.getFehcaVencimiento().getTime())
                    .append("CVV", tarjeta.getCVV());

            collection.updateOne(
                    Filters.eq("_id", usuarioId),
                    Updates.push("tarjetas", tarjetaDoc)
            );

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Valida las credenciales de un usuario para iniciar sesión.
     *
     * @param correo Correo electrónico del usuario
     * @param contrasena Contraseña del usuario
     * @return Usuario si las credenciales son válidas, null en caso contrario
     */
    @Override
    public Usuario iniciarSesion(String correo, String contrasena) {
        try {
            Document query = new Document("correo", correo).append("contraseña", contrasena);
            Document result = collection.find(query).first();

            if (result != null) {
                Usuario usuario = new Usuario();
                usuario.setId(result.getObjectId("_id"));
                usuario.setNombre(result.getString("nombre"));
                usuario.setApellidoPaterno(result.getString("apellidoPaterno"));
                usuario.setApellidoMaterno(result.getString("apellidoMaterno"));
                usuario.setNumero(result.getString("numero"));
                usuario.setCorreo(result.getString("correo"));
                usuario.setContraseña(result.getString("contraseña"));

                List<Document> tarjetasDocs = result.getList("tarjetas", Document.class);
                if (tarjetasDocs != null) {
                    List<Tarjetas> tarjetas = new ArrayList<>();
                    for (Document tarjetaDoc : tarjetasDocs) {
                        Tarjetas tarjeta = new Tarjetas();
                        tarjeta.setNombre(tarjetaDoc.getString("nombre"));
                        tarjeta.setNumero(tarjetaDoc.getString("numero"));

                        Date fecha = tarjetaDoc.getDate("fechaVencimiento");
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(fecha);
                        tarjeta.setFehcaVencimiento(calendar);

                        tarjeta.setCVV(tarjetaDoc.getString("CVV"));
                        tarjetas.add(tarjeta);
                    }
                    usuario.setTarjetas(tarjetas);
                }
                return usuario;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Obtiene los números de tarjeta asociados a un usuario.
     *
     * @param idUsuario ID del usuario
     * @return Lista de números de tarjeta
     */
    @Override
    public List<String> obtenerNumerosTarjetasPorUsuario(ObjectId idUsuario) {

        try {
            Document usuario = collection.find(Filters.eq("_id", idUsuario)).first();
            if (usuario == null) {
                System.out.println("Usuario no encontrado");
                return new ArrayList<>();
            }

            List<Document> tarjetas = (List<Document>) usuario.get("tarjetas");
            if (tarjetas == null || tarjetas.isEmpty()) {
                System.out.println("El usuario no tiene tarjetas asociadas");
                return new ArrayList<>();
            }

            System.out.println("Tarjetas encontradas: " + tarjetas);

            return tarjetas.stream()
                    .map(tarjeta -> tarjeta.getString("numero"))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();

        }
    }

    /**
     * Obtiene un usuario por su ID.
     *
     * @param id ID del usuario
     * @return Usuario encontrado o null si no existe
     */
    @Override
    public Usuario obtenerUsuarioPorId(ObjectId id) {
        MongoCollection<Document> coleccionUsuarios = Conexion.getDatabase().getCollection("usuarios"); // Asegúrate de obtener la base de datos correctamente
        Document doc = coleccionUsuarios.find(Filters.eq("_id", id)).first();
        if (doc != null) {
            return new Usuario(doc.getObjectId("_id"), doc.getString("nombre"));
        }
        return null;
    }

    /**
     * Valida las credenciales de una tarjeta para inicio de sesión alternativo.
     *
     * @param numero Número de la tarjeta
     * @param cvv Código de seguridad de la tarjeta
     * @return true si las credenciales son válidas, false en caso contrario
     */
    public boolean iniciarSesionPorCVV(String numero, String cvv) {
        try {
            Document query = new Document("tarjetas.numero", numero)
                    .append("tarjetas.CVV", cvv);

            Document usuarioEncontrado = collection.find(query).first();

            return usuarioEncontrado != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Busca un usuario por su correo electrónico.
     *
     * @param correo Correo electrónico del usuario
     * @return Usuario encontrado o null si no existe
     */
    @Override
    public Usuario buscarPorCorreo(String correo) {
        try {
            Document query = new Document("correo", correo);
            Document result = collection.find(query).first();

            if (result != null) {
                Usuario usuario = new Usuario();
                usuario.setId(result.getObjectId("_id"));
                usuario.setNombre(result.getString("nombre"));
                usuario.setApellidoPaterno(result.getString("apellidoPaterno"));
                usuario.setApellidoMaterno(result.getString("apellidoMaterno"));
                usuario.setNumero(result.getString("numero"));
                usuario.setCorreo(result.getString("correo"));
                usuario.setContraseña(result.getString("contraseña"));
                return usuario;
            } else {
                System.out.println("Usuario no encontrado");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
