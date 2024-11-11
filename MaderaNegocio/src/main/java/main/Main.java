/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import dto.UsuarioDTO;
import interfacesDTO.IUsuarioNegocio;
import negocio.UsuarioNegocio;

/**
 *
 * @author Oley
 */
public class Main {
    public static void main(String[] args) {
         IUsuarioNegocio usuarioNegocio = new UsuarioNegocio();

//        // Crear un objeto UsuarioDTO con los datos que deseas agregar
//        UsuarioDTO usuarioDTO = new UsuarioDTO();
//        usuarioDTO.setNombre("orlando");
//        usuarioDTO.setApellidoPaterno("Pérez");
//        usuarioDTO.setApellidoMaterno("Gómez");
//        usuarioDTO.setNumero("1234567890");
//        usuarioDTO.setCorreo("juan.perez@example.com");
//        usuarioDTO.setContraseña("password123");
//
//        try {
//            // Llamar al método agregarUsuario
//            UsuarioDTO usuarioDTOResponse = usuarioNegocio.agregarUsuario(usuarioDTO);
//
//            // Imprimir la respuesta
//            System.out.println("Usuario agregado exitosamente!");
//            System.out.println("ID: " + usuarioDTOResponse.getId());
//            System.out.println("Nombre: " + usuarioDTOResponse.getNombre());
//            System.out.println("Correo: " + usuarioDTOResponse.getCorreo());
//        } catch (RuntimeException e) {
//            // En caso de error, capturar la excepción y mostrar el mensaje
//            System.out.println("Error al agregar el usuario: " + e.getMessage());
//        }
        
          // Datos de prueba
        String correo = "ejemplo@dominio.com"; // Correo de prueba
        String contrasena = "contrasena123";   // Contraseña de prueba

        // Probar el método iniciarSesion
        UsuarioDTO usuarioDTO = usuarioNegocio.iniciarSesion(correo, contrasena);

        // Mostrar el resultado
        if (usuarioDTO != null) {
            System.out.println("Inicio de sesión exitoso:");
            System.out.println("ID: " + usuarioDTO.getId());
            System.out.println("Nombre: " + usuarioDTO.getNombre());
            System.out.println("Apellido Paterno: " + usuarioDTO.getApellidoPaterno());
            System.out.println("Apellido Materno: " + usuarioDTO.getApellidoMaterno());
            System.out.println("Número: " + usuarioDTO.getNumero());
            System.out.println("Correo: " + usuarioDTO.getCorreo());
        } else {
            System.out.println("Credenciales incorrectas.");
        }
        
        
        
        
        
    }
        
        
        
    }

