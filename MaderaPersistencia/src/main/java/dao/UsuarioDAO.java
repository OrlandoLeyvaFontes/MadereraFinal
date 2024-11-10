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

            // Asigna el ID generado al objeto Usuario
            usuario.setId(document.getObjectId("_id"));
            return usuario;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}


    


