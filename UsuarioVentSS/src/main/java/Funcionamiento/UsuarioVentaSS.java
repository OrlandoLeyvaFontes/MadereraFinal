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
 *
 * @author aleja
 */
public class UsuarioVentaSS implements IUsuarioVentaSS {
    IUsuarioVentasNegocio iUsuarioVentasNegocio;

    public UsuarioVentaSS() {
        this.iUsuarioVentasNegocio = new UsuarioVentasNegocio();
    }


    @Override
    public UsuarioVentasDTO agregarUsuario(UsuarioVentasDTO usuarioVentasDTO) {
        try {
            UsuarioVentasDTO usuarioVentasGuardado = iUsuarioVentasNegocio.agregarUsuario(usuarioVentasDTO);

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

    @Override
    public UsuarioVentasDTO iniciarSesion(String correo, String contrasena) {
        UsuarioVentasDTO usuarioVentasDTO = iUsuarioVentasNegocio.iniciarSesion(correo, contrasena);
        if (usuarioVentasDTO != null) {
            return usuarioVentasDTO;
        } else {
            System.out.println("Credenciales incorrectas");
            return null;
        }
    }
}
