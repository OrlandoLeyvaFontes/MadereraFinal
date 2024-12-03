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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
/**
 * Implementación de la lógica de negocio para las salidas de inventario. Esta
 * clase coordina las operaciones entre la capa de presentación y la capa de
 * datos, manejando el registro y consulta de salidas de productos.
 */
public class SalidaNegocio implements ISalidaNegocio {

    /**
     * DAO para operaciones de salidas
     */

    private final ISalidaDAO salidaDAO;
    /**
     * DAO para operaciones de compras
     */

    private final ICompraDAO compraDAO;

    /**
     * Constructor que inicializa las referencias a los DAOs necesarios.
     */
    public SalidaNegocio() {
        this.salidaDAO = new SalidaDAO();
        this.compraDAO = new CompraDAO();
    }

    /**
     * Crea un registro de salida basado en una compra existente.
     *
     * @param compraId ID de la compra en formato String
     * @param tipoMovimiento Tipo de movimiento a registrar
     * @return String ID de la salida creada, o null si ocurre un error
     */
    public String crearSalidaDesdeCompra(String compraId, String tipoMovimiento) {
        try {
            ObjectId objectIdCompra = new ObjectId(compraId);
            ObjectId salidaId = salidaDAO.crearSalidaDesdeCompra(objectIdCompra, tipoMovimiento);
            return salidaId.toString();
        } catch (Exception e) {
            System.err.println("Error creando salida: " + e.getMessage());
            return null;
        }
    }

    /**
     * Obtiene la información de una salida específica. Convierte la entidad
     * Salida a DTO para la capa de presentación.
     *
     * @param salidaId ID de la salida en formato String
     * @return SalidaDTO con la información de la salida, o null si no se
     * encuentra
     */
    public SalidaDTO obtenerSalida(String salidaId) {
        try {
            ObjectId objectIdSalida = new ObjectId(salidaId);
            Salida salida = salidaDAO.obtenerSalida(objectIdSalida);

            if (salida != null) {
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

    /**
     * Obtiene todas las salidas registradas en el sistema. Convierte las
     * entidades a DTOs para la capa de presentación.
     *
     * @return List<SalidaDTO> Lista de todas las salidas convertidas a DTO
     */
    public List<SalidaDTO> obtenerTodasLasSalidas() {
        List<SalidaDTO> salidaDTOs = new ArrayList<>();
        try {
            List<Salida> salidas = salidaDAO.obtenerTodasLasSalidas();

            for (Salida salida : salidas) {
                SalidaDTO salidaDTO = new SalidaDTO();
                salidaDTO.setId(salida.getId().toString());
                salidaDTO.setCompraId(salida.getCompraId().toString());
                salidaDTO.setTipoMovimiento(salida.getTipoMovimiento());
                salidaDTO.setMadera(salida.getMadera());
                salidaDTO.setFecha(salida.getFecha());
                salidaDTO.setCantidad(salida.getCantidad());
                salidaDTO.setUsuario(salida.getUsuario());

                salidaDTOs.add(salidaDTO);
            }
        } catch (Exception e) {
            System.err.println("Error obteniendo todas las salidas: " + e.getMessage());
        }
        return salidaDTOs;
    }
}
