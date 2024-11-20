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

/**
 *
 * @author Oley
 */
public class UsuarioNegocio implements IUsuarioNegocio {

    private IUsuarioDAO iusuarioDAO;

    public UsuarioNegocio() {
        this.iusuarioDAO = new UsuarioDAO();
    }

    @Override
    public UsuarioDTO agregarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setApellidoPaterno(usuarioDTO.getApellidoPaterno());
        usuario.setApellidoMaterno(usuarioDTO.getApellidoMaterno());
        usuario.setNumero(usuarioDTO.getNumero());
        usuario.setCorreo(usuarioDTO.getCorreo());
        usuario.setContraseña(usuarioDTO.getContraseña());

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

    @Override
    public UsuarioDTO iniciarSesion(String correo, String contrasena) {
        Usuario usuario = iusuarioDAO.iniciarSesion(correo, contrasena);

        if (usuario != null) {
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
    }

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
    }    }

    @Override
    public boolean iniciarSesionPorCVV(String cvv) {
        return iusuarioDAO.iniciarSesionPorCVV(cvv);
    }

}
