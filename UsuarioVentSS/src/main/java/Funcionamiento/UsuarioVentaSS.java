/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funcionamiento;

import dto.UsuarioVentasDTO;
import interfacesDTO.IUsuarioVentasNegocio;
import interfaz.IUsuarioVentaSS;
import negocio.UsuarioVentasNegocio;

/**
 * Clase que implementa la interfaz IUsuarioVentaSS y define la lógica de
 * negocio relacionada con la gestión de usuarios en el sistema de ventas. Esta
 * clase se encarga de interactuar con la capa de negocio para registrar
 * usuarios y gestionar el inicio de sesión.
 *
 * @author aleja
 */
public class UsuarioVentaSS implements IUsuarioVentaSS {

    private IUsuarioVentasNegocio iUsuarioVentasNegocio;

    /**
     * Constructor que inicializa la capa de negocio (IUsuarioVentasNegocio).
     */
    public UsuarioVentaSS() {
        this.iUsuarioVentasNegocio = new UsuarioVentasNegocio();
    }

    /**
     * Método para agregar un nuevo usuario al sistema de ventas. Este método
     * recibe un objeto UsuarioVentasDTO con la información del usuario a
     * registrar y lo pasa a la capa de negocio para su procesamiento.
     *
     * @param usuarioVentasDTO Objeto que contiene los datos del usuario a
     * registrar.
     * @return UsuarioVentasDTO Objeto con los datos del usuario registrado si
     * la operación es exitosa.
     * @throws RuntimeException Si ocurre un error al intentar agregar el
     * usuario.
     */
    @Override
    public UsuarioVentasDTO agregarUsuario(UsuarioVentasDTO usuarioVentasDTO) {
        try {
            // Llamada al negocio para agregar el usuario
            UsuarioVentasDTO usuarioVentasGuardado = iUsuarioVentasNegocio.agregarUsuario(usuarioVentasDTO);

            // Verificación de la respuesta
            if (usuarioVentasGuardado != null) {
                return usuarioVentasGuardado;
            } else {
                throw new RuntimeException("Error al agregar el usuario.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Ocurrió un error al intentar agregar el usuario: " + e.getMessage());
        }
    }

    /**
     * Método para gestionar el inicio de sesión de un usuario en el sistema de
     * ventas. Este método valida las credenciales del usuario y devuelve el
     * objeto UsuarioVentasDTO con la información del usuario si las
     * credenciales son correctas.
     *
     * @param correo Correo electrónico del usuario.
     * @param contrasena Contraseña del usuario.
     * @return UsuarioVentasDTO Objeto con los datos del usuario si las
     * credenciales son correctas.
     * @throws RuntimeException Si las credenciales no son válidas o ocurre un
     * error durante el proceso.
     */
    @Override
    public UsuarioVentasDTO iniciarSesion(String correo, String contrasena) {
        // Llamada al negocio para validar las credenciales
        UsuarioVentasDTO usuarioVentasDTO = iUsuarioVentasNegocio.iniciarSesion(correo, contrasena);

        // Verificación de las credenciales
        if (usuarioVentasDTO != null) {
            return usuarioVentasDTO;
        } else {
            // En caso de credenciales incorrectas, se imprime el mensaje
            System.out.println("Credenciales incorrectas");
            return null;
        }
    }
}
