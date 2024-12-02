/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import dto.CompraDTO;
import dto.MaderaDTO;
import dto.SalidaDTO;
import dto.UsuarioDTO;
import entidades.Madera;
import entidades.Usuario;
import interfacesDTO.ICompraNegocio;
import interfacesDTO.IUsuarioNegocio;
import java.util.Calendar;
import java.util.List;
import negocio.CompraNegocio;
import negocio.MaderaNegocio;
import negocio.SalidaNegocio;
import negocio.UsuarioNegocio;

/**
 *
 * @author Oley
 */
public class Main {
    public static void main(String[] args) {
  SalidaNegocio salidaNegocio = new SalidaNegocio();

        // Crear una salida
        String compraId = "674c1afbee9dc27969b9a79e"; 
        String tipoMovimiento = "venta";

        String salidaId = salidaNegocio.crearSalidaDesdeCompra(compraId, tipoMovimiento);
        System.out.println("ID de la salida creada: " + salidaId);

        SalidaDTO salidaDTO = salidaNegocio.obtenerSalida(salidaId);
        if (salidaDTO != null) {
            System.out.println("Salida encontrada:");
            System.out.println("Compra ID: " + salidaDTO.getCompraId());
            System.out.println("Tipo de movimiento: " + salidaDTO.getTipoMovimiento());
            System.out.println("Madera: " + salidaDTO.getMadera());
            System.out.println("Fecha: " + salidaDTO.getFecha());
            System.out.println("Cantidad: " + salidaDTO.getCantidad());
            System.out.println("Usuario: " + salidaDTO.getUsuario());
        } else {
            System.out.println("No se encontró la salida con ID: " + salidaId);
        }
    }
    
        
    
    
    }
    
   
        
        
        
        
    
        
        
        
    

