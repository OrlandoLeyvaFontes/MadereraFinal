/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dao.MaderaDAO;
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
        this.usuarioVentasDAO = usuarioVentasDAO;
        this.madereraNegocio = madereraNegocio;

    }

    @Override
    public UsuarioVentasDTO agregarUsuario(UsuarioVentasDTO usuarioVentasDTO) {
        UsuarioVentas usuarioVentas = new UsuarioVentas();
        usuarioVentas.setNombre(usuarioVentasDTO.getNombre());
        usuarioVentas.setApellidoMaterno(usuarioVentasDTO.getApellidoMaterno());
        usuarioVentas.setApellidoPaterno(usuarioVentasDTO.getApellidoPaterno());
        usuarioVentas.setCorreo(usuarioVentasDTO.getCorreo());
        usuarioVentas.setNumero(usuarioVentasDTO.getNumero());
        usuarioVentas.setContraseña(usuarioVentasDTO.getContraseña());

        UsuarioVentas usuarioVentaGuardado = usuarioVentasDAO.agregarUsuario(usuarioVentas);

        if (usuarioVentaGuardado != null) {
            UsuarioVentasDTO usuarioVentasGuardado = new UsuarioVentasDTO();
            usuarioVentaGuardado.getId().toString();
            usuarioVentaGuardado.getNombre();
            usuarioVentaGuardado.getApellidoMaterno();
            usuarioVentaGuardado.getApellidoPaterno();
            usuarioVentaGuardado.getCorreo();
            usuarioVentaGuardado.getContraseña();
            usuarioVentaGuardado.getNumero();
            return usuarioVentasGuardado;
        } else {
            throw new RuntimeException("Error al agregar el usuario de ventas. Intente más tarde.");
        }
    }

    @Override
    public UsuarioVentasDTO iniciarSesion(String correo, String contrasena) {
        UsuarioVentas usuarioVenta = usuarioVentasDAO.iniciarSesion(correo, contrasena);

        if (usuarioVenta == null) {
            throw new RuntimeException("Credenciales incorrectas");
        }

        if (usuarioVenta != null) {
            UsuarioVentasDTO usuarioVentaDTO = new UsuarioVentasDTO();
            usuarioVentaDTO.getId().toString();
            usuarioVentaDTO.getNombre();
            usuarioVentaDTO.getApellidoMaterno();
            usuarioVentaDTO.getApellidoPaterno();
            usuarioVentaDTO.getCorreo();
            usuarioVentaDTO.getNumero();
            usuarioVentaDTO.getContraseña();
            return usuarioVentaDTO;
        } else {
            System.out.println("Informacion Incorrectas");
            return null;
        }
    }

    @Override
    public UsuarioVentasDTO obtenerUsuarioPorId(String id) {
        try {
            ObjectId objectId = new ObjectId(id);
            UsuarioVentas usuarioVenta = usuarioVentasDAO.obtenerUsuarioPorId(objectId);

            if (usuarioVenta == null) {
                throw new RuntimeException("Usuario de ventas no encontrado");
            }

            if (usuarioVenta != null) {
                UsuarioVentasDTO usuarioVentaDTO = new UsuarioVentasDTO();
                usuarioVentaDTO.getId().toString();
                usuarioVentaDTO.getNombre();
                usuarioVentaDTO.getApellidoMaterno();
                usuarioVentaDTO.getApellidoPaterno();
                usuarioVentaDTO.getCorreo();
                usuarioVentaDTO.getNumero();
                usuarioVentaDTO.getContraseña();
                return usuarioVentaDTO;
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener el usuario de ventas: " + e.getMessage(), e);
        }
        return null;
    }

//    @Override
//    public List<Document> obtenerMaderasPorUsuarioVenta(String idUsuarioVenta) {
//        try {
//            List<MaderaDTO> maderasDTO = madereraNegocio.obtenerMaderasPorUsuarioVenta(idUsuarioVenta);
//
//            if (maderasDTO.isEmpty()) {
//                System.out.println("El usuario de ventas no tiene maderas asociadas.");
//                return new ArrayList<>();
//            }
//
//            // Convertir la lista de DTOs a Documentos
//            List<Document> maderasDocs = new ArrayList<>();
//            for (MaderaDTO madera : maderasDTO) {
//                Document maderaDoc = new Document();
//                maderaDoc.put("id", madera.getId());
//                maderaDoc.put("nombre", madera.getNombre());
//                maderaDoc.put("tipo", madera.getDescripcion());
//                maderaDoc.put("cantidad", madera.getCantidad());
//                maderaDoc.put("precio", madera.getPrecioUnitario());
//                maderasDocs.add(maderaDoc);
//            }
//
//            return maderasDocs;
//        } catch (Exception e) {
//            System.err.println("Error al obtener las maderas del usuario de ventas: " + e.getMessage());
//            e.printStackTrace();
//            return new ArrayList<>();
//        }
//    }
}
