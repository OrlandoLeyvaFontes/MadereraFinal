/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import dto.UsuarioDTO;
import funcionalidad.AgregarUsuarioSS;
import interfazSS.IAgregarUsuarioSS;

/**
 *
 * @author Oley
 */
public class Main {
    public static void main(String[] args) {
         IAgregarUsuarioSS agregarUsuarioSS = new AgregarUsuarioSS();

        // Crear un UsuarioDTO con los datos del usuario a agregar
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setNombre("Grecia");
        usuarioDTO.setApellidoPaterno("Pérez");
        usuarioDTO.setApellidoMaterno("Gómez");
        usuarioDTO.setNumero("1234567890");
        usuarioDTO.setCorreo("juan.perez@example.com");
        usuarioDTO.setContraseña("contraseña123");

        // Llamar al método agregarUsuario y capturar el resultado
        try {
            UsuarioDTO usuarioGuardado = agregarUsuarioSS.agregarUsuario(usuarioDTO);
            System.out.println("Usuario agregado con éxito: " + usuarioGuardado.getId());
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
     
        
        
    }
}
