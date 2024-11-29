/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaz;

import dto.CompraDTO;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author rober
 */
public interface IGenerarHistorialComprasSS {

    public List<Document> obtenerHistorialCompras(ObjectId usuarioId);
}
