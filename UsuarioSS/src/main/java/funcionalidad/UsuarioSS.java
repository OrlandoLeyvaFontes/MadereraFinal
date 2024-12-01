/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funcionalidad;

import dto.TarjetasDTO;
import dto.UsuarioDTO;
import interfacesDTO.IUsuarioNegocio;
import interfaz.IUsuarioSS;
import java.util.List;
import negocio.UsuarioNegocio;

/**
 *
 * @author Oley
 */
public class UsuarioSS implements IUsuarioSS {

    IUsuarioNegocio iUsuarioNegocio;

    public UsuarioSS() {
        this.iUsuarioNegocio = new UsuarioNegocio();
    }

    @Override
    public UsuarioDTO iniciarSesion(String correo, String contrasena) {
        UsuarioDTO usuarioDTO = iUsuarioNegocio.iniciarSesion(correo, contrasena);
        if (usuarioDTO != null) {
            return usuarioDTO;
        } else {
            System.out.println("Credenciales incorrectas");
            return null;
        }
    }

    @Override
    public UsuarioDTO agregarUsuario(UsuarioDTO usuarioDTO) {
        try {
            UsuarioDTO usuarioGuardado = iUsuarioNegocio.agregarUsuario(usuarioDTO);

            if (usuarioGuardado != null) {
                return usuarioGuardado;
            } else {
                throw new RuntimeException("Error al agregar el usuario.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Ocurrió un error al intentar agregar el usuario: " + e.getMessage());
        }

    }

    @Override
    public boolean agregarTarjeta(String usuarioId, TarjetasDTO tarjetasDTO) {
        return iUsuarioNegocio.agregarTarjeta(usuarioId, tarjetasDTO);
    }



    @Override
    public List<String> obtenerNumerosTarjetasPorUsuario(String idUsuario) {
 return iUsuarioNegocio.obtenerNumerosTarjetasPorUsuario(idUsuario);
    }

    @Override
    public boolean iniciarSesionPorCVV(String numeroTarjeta, String cvv) {
return iUsuarioNegocio.iniciarSesionPorCVV(numeroTarjeta, cvv);    }

}
