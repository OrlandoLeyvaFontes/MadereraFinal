/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dao.MaderaDAO;
import dao.UsuarioVentasDAO;
import dto.MaderaDTO;
import dto.UsuarioVentasDTO;
import entidades.Madera;
import entidades.UsuarioVentas;
import interfacesDAO.IUsuarioVentasDAO;
import interfacesDTO.IMadereraNegocio;
import interfacesDTO.IUsuarioVentasNegocio;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author aleja
 */
public class UsuarioVentasNegocio implements IUsuarioVentasNegocio {

    private IUsuarioVentasDAO usuarioVentasDAO;
    private IMadereraNegocio madereraNegocio;

    public UsuarioVentasNegocio() {
        this.usuarioVentasDAO = new UsuarioVentasDAO();
        this.madereraNegocio = new MaderaNegocio();
    }

    

    @Override
    public UsuarioVentasDTO agregarUsuario(UsuarioVentasDTO usuarioVentasDTO) {
        // Crear entidad UsuarioVentas
        UsuarioVentas usuarioVentas = new UsuarioVentas();
        usuarioVentas.setNombre(usuarioVentasDTO.getNombre());
        usuarioVentas.setApellidoMaterno(usuarioVentasDTO.getApellidoMaterno());
        usuarioVentas.setApellidoPaterno(usuarioVentasDTO.getApellidoPaterno());
        usuarioVentas.setCorreo(usuarioVentasDTO.getCorreo());
        usuarioVentas.setNumero(usuarioVentasDTO.getNumero());
        usuarioVentas.setContraseña(usuarioVentasDTO.getContraseña());

        // Guardar usuario en la base de datos
        UsuarioVentas usuarioVentaGuardado = usuarioVentasDAO.agregarUsuario(usuarioVentas);

        if (usuarioVentaGuardado != null) {
            // Convertir la entidad guardada a DTO
            UsuarioVentasDTO usuarioVentasGuardadoDTO = new UsuarioVentasDTO();
            usuarioVentasGuardadoDTO.setId(usuarioVentaGuardado.getId().toString());
            usuarioVentasGuardadoDTO.setNombre(usuarioVentaGuardado.getNombre());
            usuarioVentasGuardadoDTO.setApellidoMaterno(usuarioVentaGuardado.getApellidoMaterno());
            usuarioVentasGuardadoDTO.setApellidoPaterno(usuarioVentaGuardado.getApellidoPaterno());
            usuarioVentasGuardadoDTO.setCorreo(usuarioVentaGuardado.getCorreo());
            usuarioVentasGuardadoDTO.setNumero(usuarioVentaGuardado.getNumero());
            usuarioVentasGuardadoDTO.setContraseña(usuarioVentaGuardado.getContraseña());
            return usuarioVentasGuardadoDTO;
        } else {
            throw new RuntimeException("Error al agregar el usuario de ventas. Intente más tarde.");
        }
    }

    @Override
    public UsuarioVentasDTO iniciarSesion(String correo, String contrasena) {
        // Verificar las credenciales del usuario
        UsuarioVentas usuarioVenta = usuarioVentasDAO.iniciarSesion(correo, contrasena);

        if (usuarioVenta == null) {
            throw new RuntimeException("Credenciales incorrectas");
        }

        // Convertir la entidad de usuario en DTO
        UsuarioVentasDTO usuarioVentaDTO = new UsuarioVentasDTO();
        usuarioVentaDTO.setId(usuarioVenta.getId().toString());
        usuarioVentaDTO.setNombre(usuarioVenta.getNombre());
        usuarioVentaDTO.setApellidoMaterno(usuarioVenta.getApellidoMaterno());
        usuarioVentaDTO.setApellidoPaterno(usuarioVenta.getApellidoPaterno());
        usuarioVentaDTO.setCorreo(usuarioVenta.getCorreo());
        usuarioVentaDTO.setNumero(usuarioVenta.getNumero());
        usuarioVentaDTO.setContraseña(usuarioVenta.getContraseña());

        return usuarioVentaDTO;
    }

    @Override
    public UsuarioVentasDTO obtenerUsuarioPorId(String id) {
        try {
            ObjectId objectId = new ObjectId(id);
            // Obtener usuario por ID desde la base de datos
            UsuarioVentas usuarioVenta = usuarioVentasDAO.obtenerUsuarioPorId(objectId);

            if (usuarioVenta == null) {
                throw new RuntimeException("Usuario de ventas no encontrado");
            }

            // Convertir la entidad de usuario en DTO
            UsuarioVentasDTO usuarioVentaDTO = new UsuarioVentasDTO();
            usuarioVentaDTO.setId(usuarioVenta.getId().toString());
            usuarioVentaDTO.setNombre(usuarioVenta.getNombre());
            usuarioVentaDTO.setApellidoMaterno(usuarioVenta.getApellidoMaterno());
            usuarioVentaDTO.setApellidoPaterno(usuarioVenta.getApellidoPaterno());
            usuarioVentaDTO.setCorreo(usuarioVenta.getCorreo());
            usuarioVentaDTO.setNumero(usuarioVenta.getNumero());
            usuarioVentaDTO.setContraseña(usuarioVenta.getContraseña());

            return usuarioVentaDTO;
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener el usuario de ventas: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Document> obtenerMaderasPorUsuarioVenta(String idUsuarioVenta) {
        try {
            // Obtener las maderas asociadas al usuario de ventas
            List<MaderaDTO> maderasDTO = madereraNegocio.obtenerMaderasPorUsuarioVenta(idUsuarioVenta);

            if (maderasDTO.isEmpty()) {
                System.out.println("El usuario de ventas no tiene maderas asociadas.");
                return new ArrayList<>();
            }

            // Convertir la lista de DTOs a Documentos
            List<Document> maderasDocs = new ArrayList<>();
            for (MaderaDTO madera : maderasDTO) {
                Document maderaDoc = new Document();
                maderaDoc.put("id", madera.getId());
                maderaDoc.put("nombre", madera.getNombre());
                maderaDoc.put("tipo", madera.getDescripcion());
                maderaDoc.put("cantidad", madera.getCantidad());
                maderaDoc.put("precio", madera.getPrecioUnitario());
                maderasDocs.add(maderaDoc);
            }

            return maderasDocs;
        } catch (Exception e) {
            System.err.println("Error al obtener las maderas del usuario de ventas: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
