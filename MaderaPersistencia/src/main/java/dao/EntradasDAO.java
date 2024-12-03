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
 * Clase que implementa la interfaz IEntradasDAO para gestionar las entradas de
 * madera en la base de datos MongoDB. Permite realizar operaciones CRUD sobre
 * las entradas en la colección 'Entradas'.
 *
 * @author aleja
 */
public class EntradasDAO implements IEntradasDAO {

    // Colección de "Entradas" en la base de datos MongoDB
    private final MongoCollection<Document> collection;

    /**
     * Constructor que inicializa la conexión a la colección 'Entradas' en
     * MongoDB.
     */
    public EntradasDAO() {
        this.collection = Conexion.getDatabase().getCollection("Entradas");
    }

    /**
     * Guarda una nueva entrada de madera en la base de datos.
     *
     * @param entrada Objeto de tipo Entradas que contiene la información a
     * guardar.
     * @return El objeto de entrada con su ID asignado por MongoDB, o null si
     * ocurre un error.
     */
    public Entradas guardarEntrada(Entradas entrada) {
        try {
            // Crear un documento de MongoDB a partir de la entidad Entradas
            Document document = new Document("Entradas", entrada.getTipoEntrada())
                    .append("tipoMadera", entrada.getTipoMadera())
                    .append("cantidad", entrada.getCantidad())
                    .append("fechaEntrada", entrada.getFechaEntrada());

            // Insertar el documento en la colección 'Entradas'
            collection.insertOne(document);

            // Asignar el ID generado por MongoDB al objeto entrada
            entrada.setId(document.getObjectId("_id"));
            return entrada;
        } catch (Exception e) {
            // Imprimir el error en caso de una excepción
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Obtiene todas las entradas almacenadas en la base de datos.
     *
     * @return Una lista de objetos Entradas que contienen la información de las
     * entradas almacenadas.
     */
    @Override
    public List<Entradas> obtenerEntradas() {
        List<Entradas> listaMaderas = new ArrayList<>();
        try {
            // Obtener todos los documentos de la colección
            FindIterable<Document> documentos = collection.find();
            for (Document documento : documentos) {
                // Convertir cada documento en un objeto Entradas
                Entradas entrada = new Entradas();
                entrada.setId(documento.getObjectId("_id"));
                entrada.setTipoEntrada(documento.getString("Entradas"));
                entrada.setTipoMadera(documento.getString("tipoMadera"));
                entrada.setCantidad(documento.getInteger("cantidad"));

                // Convertir la fecha almacenada en MongoDB a LocalDate
                Date fechaMongo = documento.getDate("fechaEntrada");
                if (fechaMongo != null) {
                    entrada.setFechaEntrada(fechaMongo.toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate());
                }

                // Añadir la entrada a la lista
                listaMaderas.add(entrada);
            }
        } catch (Exception e) {
            // Imprimir el error en caso de una excepción
            e.printStackTrace();
        }
        return listaMaderas;
    }

    /**
     * Obtiene las entradas almacenadas en la base de datos filtradas por tipo
     * de entrada.
     *
     * @param tipoEntrada El tipo de entrada que se desea filtrar.
     * @return Una lista de objetos Entradas que contienen la información
     * filtrada.
     */
    public List<Entradas> obtenerEntradasPorTipo(String tipoEntrada) {
        List<Entradas> listaEntradas = new ArrayList<>();
        try {
            // Filtro para buscar las entradas por tipo de entrada
            FindIterable<Document> documentos = collection.find(Filters.eq("Entradas", tipoEntrada));
            for (Document documento : documentos) {
                // Convertir cada documento en un objeto Entradas
                Entradas entrada = new Entradas();
                entrada.setId(documento.getObjectId("_id"));
                entrada.setTipoEntrada(documento.getString("Entradas"));
                entrada.setTipoMadera(documento.getString("tipoMadera"));
                entrada.setCantidad(documento.getInteger("cantidad"));

                // Convertir la fecha almacenada en MongoDB a LocalDate
                Date fechaMongo = documento.getDate("fechaEntrada");
                if (fechaMongo != null) {
                    entrada.setFechaEntrada(fechaMongo.toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate());
                }
                listaEntradas.add(entrada);
            }
        } catch (Exception e) {
            // Imprimir el error en caso de una excepción
            e.printStackTrace();
        }
        return listaEntradas;
    }

    /**
     * Obtiene una lista de todos los tipos de entrada almacenados en la base de
     * datos.
     *
     * @return Una lista de cadenas con los tipos de entrada disponibles.
     */
    public List<String> obtenerTiposEntrada() {
        List<String> tiposEntrada = new ArrayList<>();
        try {
            // Obtener todos los documentos de la colección
            FindIterable<Document> documentos = collection.find();

            // Recorrer los documentos y agregar los tipos de entrada únicos a la lista
            for (Document documento : documentos) {
                String tipoEntrada = documento.getString("Entradas");
                // Añadir el tipo de entrada a la lista solo si no está repetido
                if (tipoEntrada != null && !tiposEntrada.contains(tipoEntrada)) {
                    tiposEntrada.add(tipoEntrada);
                }
            }
        } catch (Exception e) {
            // Imprimir el error en caso de una excepción
            e.printStackTrace();
            throw new RuntimeException("Error al obtener los tipos de entrada", e);
        }
        return tiposEntrada;
    }
}
