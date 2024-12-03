/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mongodb.client.MongoCollection;
import conexion.Conexion;
import entidades.Tarjetas;
import entidades.Usuario;
import interfacesDAO.ITarjetasDAO;
import org.bson.Document;

/**
 *
 * @author Oley
 */
/**
 * Implementación de la interfaz ITarjetasDAO para MongoDB. No se uso la verdad
 */
public class TarjetasDAO implements ITarjetasDAO {
    /** Colección de tarjetas en MongoDB */

    private final MongoCollection<Document> collection;
/**
     * Constructor que inicializa la conexión a la colección de tarjetas.
     */
    public TarjetasDAO() {
        this.collection = Conexion.getDatabase().getCollection("tarjetas");
    }

}
