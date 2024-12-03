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
import org.mindrot.jbcrypt.BCrypt;

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
        // Encriptar la contraseña
        String hashedPassword = BCrypt.hashpw(usuarioVentasDTO.getContraseña(), BCrypt.gensalt());

        UsuarioVentas usuarioVentas = new UsuarioVentas();
        usuarioVentas.setNombre(usuarioVentasDTO.getNombre());
        usuarioVentas.setApellidoMaterno(usuarioVentasDTO.getApellidoMaterno());
        usuarioVentas.setApellidoPaterno(usuarioVentasDTO.getApellidoPaterno());
        usuarioVentas.setCorreo(usuarioVentasDTO.getCorreo());
        usuarioVentas.setNumero(usuarioVentasDTO.getNumero());
        usuarioVentas.setContraseña(hashedPassword); // Almacenar la contraseña encriptada
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
        // Obtener el usuario de la base de datos por correo
        UsuarioVentas usuarioVenta = usuarioVentasDAO.iniciarSesion(correo);

        // Verificar si el usuario existe
        if (usuarioVenta == null) {
            throw new RuntimeException("Credenciales incorrectas");
        }

        // Imprimir contraseñas para depuración
        System.out.println("Contraseña ingresada: " + contrasena);
        System.out.println("Contraseña almacenada (hash): " + usuarioVenta.getContraseña());

        // Validar la contraseña usando BCrypt
        boolean contraseñaValida = BCrypt.checkpw(contrasena, usuarioVenta.getContraseña());
        if (contraseñaValida) {
            System.out.println("Inicio de sesión exitoso");
        } else {
            System.out.println("Contraseña incorrecta");
            throw new RuntimeException("Credenciales incorrectas");
        }

        // Crear el DTO y asignar los valores
        UsuarioVentasDTO usuarioVentaDTO = new UsuarioVentasDTO();
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
