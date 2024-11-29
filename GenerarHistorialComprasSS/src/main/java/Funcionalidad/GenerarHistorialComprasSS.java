/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funcionalidad;

import Interfaz.IGenerarHistorialComprasSS;
import java.util.List;
import negocio.CompraNegocio;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author rober
 */
public class GenerarHistorialComprasSS implements IGenerarHistorialComprasSS {

    private CompraNegocio compraNegocio;

    public GenerarHistorialComprasSS() {
        this.compraNegocio = new CompraNegocio();
    }

    @Override
    public List<Document> obtenerHistorialCompras(ObjectId usuarioId) {
        // Llamamos al método de negocio para obtener el historial de compras
        return compraNegocio.obtenerComprasPorUsuarioId(usuarioId);
    }

}
