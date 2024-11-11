/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import conexion.Conexion;
import entidades.Usuario;
import interfacesDAO.IUsuarioDAO;
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
                .append("contraseña", usuario.getContraseña());

            collection.insertOne(document);

            usuario.setId(document.getObjectId("_id"));
            return usuario;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
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
                return usuario; 
            } else {
                return null; 
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}


    


