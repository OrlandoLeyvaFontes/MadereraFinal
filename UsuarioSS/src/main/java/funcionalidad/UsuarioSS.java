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
/**
 * Clase UsuarioSS
 *
 * Implementa la interfaz IUsuarioSS y actúa como la capa de servicio para
 * gestionar las operaciones relacionadas con los usuarios. Esta clase
 * interactúa con la capa de negocio (IUsuarioNegocio) para realizar las tareas
 * correspondientes.
 */
public class UsuarioSS implements IUsuarioSS {

    IUsuarioNegocio iUsuarioNegocio;

    /**
     * Constructor por defecto. Inicializa la instancia de IUsuarioNegocio con
     * una nueva instancia de UsuarioNegocio.
     */
    public UsuarioSS() {
        this.iUsuarioNegocio = new UsuarioNegocio();
    }

    /**
     * Permite iniciar sesión utilizando el correo electrónico y la contraseña
     * del usuario.
     *
     * @param correo Correo electrónico del usuario.
     * @param contrasena Contraseña del usuario.
     * @return Un objeto UsuarioDTO con los datos del usuario si las
     * credenciales son válidas, o null si las credenciales son incorrectas.
     */
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

    /**
     * Constructor por defecto. Inicializa la instancia de IUsuarioNegocio con
     * una nueva instancia de UsuarioNegocio.
     */
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

    /**
     * Constructor por defecto. Inicializa la instancia de IUsuarioNegocio con
     * una nueva instancia de UsuarioNegocio.
     */
    @Override
    public boolean agregarTarjeta(String usuarioId, TarjetasDTO tarjetasDTO) {
        return iUsuarioNegocio.agregarTarjeta(usuarioId, tarjetasDTO);
    }

    /**
     * Constructor por defecto. Inicializa la instancia de IUsuarioNegocio con
     * una nueva instancia de UsuarioNegocio.
     */
    @Override
    public List<String> obtenerNumerosTarjetasPorUsuario(String idUsuario) {
        return iUsuarioNegocio.obtenerNumerosTarjetasPorUsuario(idUsuario);
    }

    /**
     * Constructor por defecto. Inicializa la instancia de IUsuarioNegocio con
     * una nueva instancia de UsuarioNegocio.
     */
    @Override
    public boolean iniciarSesionPorCVV(String numeroTarjeta, String cvv) {
        return iUsuarioNegocio.iniciarSesionPorCVV(numeroTarjeta, cvv);
    }

}
