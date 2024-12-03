/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
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
    public List<Entradas> obtenerEntradas() {
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

    public List<Entradas> obtenerEntradasPorTipo(String tipoEntrada) {
        List<Entradas> listaEntradas = new ArrayList<>();
        try {
            // Filtro para buscar por tipo de entrada
            FindIterable<Document> documentos = collection.find(Filters.eq("Entradas", tipoEntrada));
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
                listaEntradas.add(entrada);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaEntradas;
    }

    public List<String> obtenerTiposEntrada() {
        List<String> tiposEntrada = new ArrayList<>();
        try {
            // Obtener todos los documentos de la colección
            FindIterable<Document> documentos = collection.find();

            // Recorrer todos los documentos y obtener los tipos de entrada
            for (Document documento : documentos) {
                String tipoEntrada = documento.getString("Entradas");
                // Verificar si el tipo de entrada no está ya en la lista
                if (tipoEntrada != null && !tiposEntrada.contains(tipoEntrada)) {
                    tiposEntrada.add(tipoEntrada);  // Añadir el tipo de entrada a la lista
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener los tipos de entrada", e);
        }
        return tiposEntrada;
    }
}
