/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dao.CompraDAO;
import dao.SalidaDAO;
import dto.CompraDTO;
import dto.MaderaDTO;
import dto.SalidaDTO;
import dto.UsuarioDTO;
import entidades.Salida;
import interfacesDAO.ICompraDAO;
import interfacesDAO.ISalidaDAO;
import interfacesDTO.ISalidaNegocio;
import java.util.Calendar;
import java.util.Date;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
public class SalidaNegocio implements ISalidaNegocio {

      private final ISalidaDAO salidaDAO;
    private final ICompraDAO compraDAO;

    public SalidaNegocio() {
        this.salidaDAO = new SalidaDAO();
        this.compraDAO = new CompraDAO();
    }
  // Método para crear una salida desde una compra
    public String crearSalidaDesdeCompra(String compraId, String tipoMovimiento) {
        try {
            // Convertir compraId a ObjectId (suponiendo que compraId es un String que representa el ObjectId)
            ObjectId objectIdCompra = new ObjectId(compraId);
            ObjectId salidaId = salidaDAO.crearSalidaDesdeCompra(objectIdCompra, tipoMovimiento);
            return salidaId.toString();
        } catch (Exception e) {
            System.err.println("Error creando salida: " + e.getMessage());
            return null;
        }
    }

    // Método para obtener una salida por su ID
    public SalidaDTO obtenerSalida(String salidaId) {
        try {
            // Convertir salidaId a ObjectId
            ObjectId objectIdSalida = new ObjectId(salidaId);
            Salida salida = salidaDAO.obtenerSalida(objectIdSalida);

            if (salida != null) {
                // Convertir a DTO
                SalidaDTO salidaDTO = new SalidaDTO();
                salidaDTO.setId(salida.getId().toString());
                salidaDTO.setCompraId(salida.getCompraId().toString());
                salidaDTO.setTipoMovimiento(salida.getTipoMovimiento());
                salidaDTO.setMadera(salida.getMadera());
                salidaDTO.setFecha(salida.getFecha());
                salidaDTO.setCantidad(salida.getCantidad());
                salidaDTO.setUsuario(salida.getUsuario());

                return salidaDTO;
            }
        } catch (Exception e) {
            System.err.println("Error obteniendo salida: " + e.getMessage());
        }
        return null;
    }
}

