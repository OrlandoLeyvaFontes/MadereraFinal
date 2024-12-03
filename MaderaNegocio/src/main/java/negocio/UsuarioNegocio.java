/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dao.UsuarioDAO;
import dto.TarjetasDTO;
import dto.UsuarioDTO;
import entidades.Tarjetas;
import entidades.Usuario;
import interfacesDAO.IUsuarioDAO;
import interfacesDTO.IUsuarioNegocio;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.bson.types.ObjectId;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Oley
 */
/**
 * Implementación de la lógica de negocio para usuarios.
 * Esta clase maneja la autenticación, registro de usuarios y gestión de tarjetas,
 * implementando las medidas de seguridad necesarias como el hash de contraseñas.
 */
public class UsuarioNegocio implements IUsuarioNegocio {

    /**
     * DAO para operaciones con usuarios
     */

    private IUsuarioDAO iusuarioDAO;

    /**
     * Constructor que inicializa la referencia al DAO de usuarios.
     */
    public UsuarioNegocio() {
        this.iusuarioDAO = new UsuarioDAO();
    }

    /**
     * Registra un nuevo usuario en el sistema. La contraseña se almacena de
     * forma segura utilizando BCrypt.
     *
     * @param usuarioDTO DTO con la información del nuevo usuario
     * @return UsuarioDTO con la información del usuario registrado
     * @throws RuntimeException si ocurre un error durante el registro
     */
    public UsuarioDTO agregarUsuario(UsuarioDTO usuarioDTO) {
        String hashedPassword = BCrypt.hashpw(usuarioDTO.getContraseña(), BCrypt.gensalt());

        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setApellidoPaterno(usuarioDTO.getApellidoPaterno());
        usuario.setApellidoMaterno(usuarioDTO.getApellidoMaterno());
        usuario.setNumero(usuarioDTO.getNumero());
        usuario.setCorreo(usuarioDTO.getCorreo());
        usuario.setContraseña(hashedPassword);
        Usuario usuarioGuardado = iusuarioDAO.agregarUsuario(usuario);

        if (usuarioGuardado != null) {
            UsuarioDTO usuarioDTOResponse = new UsuarioDTO();
            usuarioDTOResponse.setId(usuarioGuardado.getId().toString());
            usuarioDTOResponse.setNombre(usuarioGuardado.getNombre());
            usuarioDTOResponse.setApellidoPaterno(usuarioGuardado.getApellidoPaterno());
            usuarioDTOResponse.setApellidoMaterno(usuarioGuardado.getApellidoMaterno());
            usuarioDTOResponse.setNumero(usuarioGuardado.getNumero());
            usuarioDTOResponse.setCorreo(usuarioGuardado.getCorreo());
            usuarioDTOResponse.setContraseña(usuarioGuardado.getContraseña());
            return usuarioDTOResponse;
        } else {
            throw new RuntimeException("Error al agregar el usuario, intentelo más tarde");
        }
    }

    /**
     * Valida las credenciales de un usuario para el inicio de sesión. Utiliza
     * BCrypt para verificar la contraseña de forma segura.
     *
     * @param correo Correo electrónico del usuario
     * @param contrasena Contraseña del usuario
     * @return UsuarioDTO si las credenciales son válidas, null en caso
     * contrario
     */
    @Override
    public UsuarioDTO iniciarSesion(String correo, String contrasena) {
        Usuario usuario = iusuarioDAO.buscarPorCorreo(correo);

        if (usuario != null) {
            if (BCrypt.checkpw(contrasena, usuario.getContraseña())) {
                UsuarioDTO usuarioDTO = new UsuarioDTO();
                usuarioDTO.setId(usuario.getId().toString());
                usuarioDTO.setNombre(usuario.getNombre());
                usuarioDTO.setApellidoPaterno(usuario.getApellidoPaterno());
                usuarioDTO.setApellidoMaterno(usuario.getApellidoMaterno());
                usuarioDTO.setNumero(usuario.getNumero());
                usuarioDTO.setCorreo(usuario.getCorreo());
                return usuarioDTO;
            } else {
                System.out.println("Credenciales incorrectas");
                return null;
            }
        } else {
            System.out.println("Usuario no encontrado");
            return null;
        }
    }

    /**
     * Agrega una nueva tarjeta a un usuario existente.
     *
     * @param usuarioId ID del usuario en formato String
     * @param tarjetasDTO DTO con la información de la tarjeta
     * @return true si la tarjeta se agregó correctamente, false en caso
     * contrario
     */
    @Override
    public boolean agregarTarjeta(String usuarioId, TarjetasDTO tarjetasDTO) {
        try {
            Tarjetas tarjeta = new Tarjetas();
            tarjeta.setNombre(tarjetasDTO.getNombre());
            tarjeta.setNumero(tarjetasDTO.getNumero());

            Calendar fechaVencimiento = Calendar.getInstance();
            fechaVencimiento.setTime(tarjetasDTO.getFehcaVencimiento().getTime());
            tarjeta.setFehcaVencimiento(fechaVencimiento);

            tarjeta.setCVV(tarjetasDTO.getCVV());

            ObjectId objectId = new ObjectId(usuarioId);

            return iusuarioDAO.agregarTarjeta(objectId, tarjeta);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Obtiene los números de tarjeta asociados a un usuario.
     *
     * @param idUsuario ID del usuario en formato String
     * @return Lista de números de tarjeta, o lista vacía si no hay tarjetas
     */
    @Override
    public List<String> obtenerNumerosTarjetasPorUsuario(String idUsuario) {
        try {
            ObjectId objectId = new ObjectId(idUsuario);
            List<String> numerosTarjetas = iusuarioDAO.obtenerNumerosTarjetasPorUsuario(objectId);

            if (numerosTarjetas == null || numerosTarjetas.isEmpty()) {
                System.out.println("El usuario no tiene tarjetas asociadas.");
                return new ArrayList<>();
            }

            return numerosTarjetas;
        } catch (Exception e) {
            System.err.println("Error al obtener los números de las tarjetas: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    /**
     * Valida las credenciales de una tarjeta para el inicio de sesión
     * alternativo.
     *
     * @param numeroTarjeta Número de la tarjeta
     * @param cvv Código de seguridad de la tarjeta
     * @return true si las credenciales son válidas, false en caso contrario
     */
    @Override
    public boolean iniciarSesionPorCVV(String numeroTarjeta, String cvv) {
        try {
            return iusuarioDAO.iniciarSesionPorCVV(numeroTarjeta, cvv);
        } catch (Exception e) {
            System.err.println("Error al intentar iniciar sesión por CVV: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

}
