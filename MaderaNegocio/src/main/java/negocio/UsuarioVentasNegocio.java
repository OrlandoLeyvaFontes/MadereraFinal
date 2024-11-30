/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dao.UsuarioVentasDAO;
import dto.UsuarioVentasDTO;
import entidades.UsuarioVentas;
import interfacesDAO.IUsuarioVentasDAO;
import interfacesDTO.IMadereraNegocio;
import interfacesDTO.IUsuarioVentasNegocio;
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
        UsuarioVentas usuarioVentas = new UsuarioVentas();
        usuarioVentas.setNombre(usuarioVentasDTO.getNombre());
        usuarioVentas.setApellidoMaterno(usuarioVentasDTO.getApellidoMaterno());
        usuarioVentas.setApellidoPaterno(usuarioVentasDTO.getApellidoPaterno());
        usuarioVentas.setCorreo(usuarioVentasDTO.getCorreo());
        usuarioVentas.setNumero(usuarioVentasDTO.getNumero());
        usuarioVentas.setContraseña(usuarioVentasDTO.getContraseña());
        System.out.println(usuarioVentas);

        // Guardar usuario en la base de datos
        UsuarioVentas usuarioVentaGuardado = usuarioVentasDAO.agregarUsuario(usuarioVentas);

        if (usuarioVentaGuardado != null) {
            // Convertir la entidad guardada a DTO
            UsuarioVentasDTO usuarioVentasGuardadoDTO = new UsuarioVentasDTO();
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
        UsuarioVentas usuarioVenta = usuarioVentasDAO.iniciarSesion(correo, contrasena);

        if (usuarioVenta == null) {
            throw new RuntimeException("Credenciales incorrectas");
        }

        if (usuarioVenta != null) {
            UsuarioVentasDTO usuarioVentaDTO = new UsuarioVentasDTO();
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
}
