/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
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
public class UsuarioDAO implements  IUsuarioDAO{
  private final MongoCollection<Document> collection;

    public UsuarioDAO() {
        this.collection = Conexion.getDatabase().getCollection("usuarios");
    }

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

    @Override
    public Usuario obtenerUsuarioPorId(ObjectId id) {
  MongoCollection<Document> coleccionUsuarios = Conexion.getDatabase().getCollection("usuarios"); // Asegúrate de obtener la base de datos correctamente
    Document doc = coleccionUsuarios.find(Filters.eq("_id", id)).first();
    if (doc != null) {
        return new Usuario(doc.getObjectId("_id"), doc.getString("nombre"));
    }
    return null;
        }
}
    


