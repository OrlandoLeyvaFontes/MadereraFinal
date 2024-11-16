/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebas;

import dto.TarjetasDTO;
import dto.UsuarioDTO;
import interfacesDTO.IUsuarioNegocio;
import java.util.Calendar;
import negocio.UsuarioNegocio;

/**
 *
 * @author Oley
 */
public class Main {
    public static void main(String[] args) {
          IUsuarioNegocio usuarioNegocio = new UsuarioNegocio();

            // Crear un UsuarioDTO para agregarlo
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setNombre("Juan");
            usuarioDTO.setApellidoPaterno("Perez");
            usuarioDTO.setApellidoMaterno("Lopez");
            usuarioDTO.setNumero("1234567890");
            usuarioDTO.setCorreo("juan.perez@mail.com");
            usuarioDTO.setContraseña("password123");

            UsuarioDTO usuarioResponse = usuarioNegocio.agregarUsuario(usuarioDTO);

            System.out.println("Usuario creado con ID: " + usuarioResponse.getId());

            TarjetasDTO tarjetaDTO = new TarjetasDTO();
            tarjetaDTO.setNombre("Visa");
            tarjetaDTO.setNumero("4111111111111111");
            tarjetaDTO.setFehcaVencimiento(Calendar.getInstance());
            tarjetaDTO.setCVV("123");

            boolean resultado = usuarioNegocio.agregarTarjeta(usuarioResponse.getId(), tarjetaDTO);

            if (resultado) {
                System.out.println("Tarjeta agregada correctamente.");
            } else {
                System.out.println("Error al agregar la tarjeta.");
            }

       
     
        
        
        
        
    }
}
