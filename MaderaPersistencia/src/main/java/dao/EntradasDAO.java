/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import conexion.Conexion;
import entidades.Entradas;
import interfacesDAO.IEntradasDAO;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author aleja
 */
public class EntradasDAO implements IEntradasDAO {

    private final MongoCollection<Document> collection;

    public EntradasDAO() {
        this.collection = Conexion.getDatabase().getCollection("Entradas");
    }

    public Entradas guardarEntrada(Entradas entrada) {
        try {

            Document document = new Document("Entradas", entrada.getTipoEntrada())
                    .append("tipoMadera", entrada.getTipoMadera())
                    .append("cantidad", entrada.getCantidad())
                    .append("fechaEntrada", entrada.getFechaEntrada());

            // Insertar el documento en la colección
            collection.insertOne(document);

            // Establecer el ID generado por MongoDB a la entidad
            entrada.setId(document.getObjectId("_id"));
            return entrada;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Entradas> obtenerMaderas() {
        List<Entradas> listaMaderas = new ArrayList<>();
        try {
            FindIterable<Document> documentos = collection.find();
            for (Document documento : documentos) {
                Entradas entrada = new Entradas();
                entrada.setId(documento.getObjectId("_id"));
                entrada.setTipoEntrada(documento.getString("Entradas"));
                entrada.setTipoMadera(documento.getString("tipoMadera"));
                entrada.setCantidad(documento.getInteger("cantidad"));
                Date fechaMongo = documento.getDate("fechaEntrada");
                if (fechaMongo != null) {
                    entrada.setFechaEntrada(fechaMongo.toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate());
                }

                listaMaderas.add(entrada);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaMaderas;
    }
}
