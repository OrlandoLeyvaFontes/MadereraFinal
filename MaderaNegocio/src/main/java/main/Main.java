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

        List<SalidaDTO> salidas = salidaNegocio.obtenerTodasLasSalidas();

        if (salidas != null && !salidas.isEmpty()) {
            System.out.println("Salidas obtenidas:");
            for (SalidaDTO salida : salidas) {
                System.out.println("ID: " + salida.getId());
                System.out.println("Compra ID: " + salida.getCompraId());
                System.out.println("Tipo Movimiento: " + salida.getTipoMovimiento());
                System.out.println("Madera: " + salida.getMadera());
                System.out.println("Fecha: " + salida.getFecha().getTime());
                System.out.println("Cantidad: " + salida.getCantidad());
                System.out.println("Usuario: " + salida.getUsuario());
                System.out.println("=================================");
            }
        } else {
            System.out.println("No se encontraron salidas.");
        }  
    
    }
    }
    
   
        
        
        
        
    
        
        
        
    

