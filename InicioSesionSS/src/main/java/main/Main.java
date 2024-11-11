/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import dto.UsuarioDTO;
import funcionalidad.InicioDeSesionSS;
import interfacesDTO.IUsuarioNegocio;
import interfazSS.IInicioSesionSS;
import negocio.UsuarioNegocio;

/**
 *
 * @author Oley
 */
public class Main {
    public static void main(String[] args) {
         InicioDeSesionSS inicioSesion = new InicioDeSesionSS();

        // Datos de prueba
        String correo = "usuario@ejemplo.com";
        String contrasena = "123456";

        // Intentar iniciar sesión
        UsuarioDTO usuarioDTO = inicioSesion.iniciarSesion(correo, contrasena);

        // Verificar resultado y mostrar información
        if (usuarioDTO != null) {
            System.out.println("Inicio de sesión exitoso");
            System.out.println("ID: " + usuarioDTO.getId());
            System.out.println("Nombre: " + usuarioDTO.getNombre());
            System.out.println("Apellido Paterno: " + usuarioDTO.getApellidoPaterno());
            System.out.println("Apellido Materno: " + usuarioDTO.getApellidoMaterno());
            System.out.println("Número: " + usuarioDTO.getNumero());
            System.out.println("Correo: " + usuarioDTO.getCorreo());
        } else {
            System.out.println("Credenciales incorrectas");
        }
    }
        
    
}
