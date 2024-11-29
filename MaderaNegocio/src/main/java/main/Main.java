/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import dto.CompraDTO;
import dto.MaderaDTO;
import dto.UsuarioDTO;
import dto.VentaDTO;
import interfacesDTO.ICompraNegocio;
import interfacesDTO.IUsuarioNegocio;
import java.util.Calendar;
import java.util.List;
import negocio.CompraNegocio;
import negocio.MaderaNegocio;
import negocio.UsuarioNegocio;
import negocio.VentaNegocio;

/**
 *
 * @author Oley
 */
public class Main {
    public static void main(String[] args) {
         // Crear una instancia del servicio o controlador que contiene el método buscarMaderaPorNombre
        MaderaNegocio maderaService = new MaderaNegocio(); // O la clase donde tengas el método
        
        // Nombre de la madera a buscar
        String nombreMadera = "Pino";
        
        // Llamar al método de búsqueda
        MaderaDTO maderaEncontrada = maderaService.buscarMaderaPorNombre(nombreMadera);
        
        // Verificar y mostrar resultados
        if (maderaEncontrada != null) {
            System.out.println("Madera encontrada:");
            System.out.println("ID: " + maderaEncontrada.getId());
            System.out.println("Nombre: " + maderaEncontrada.getNombre());
            System.out.println("Descripción: " + maderaEncontrada.getDescripcion());
            System.out.println("Cantidad: " + maderaEncontrada.getCantidad());
            System.out.println("Precio Unitario: " + maderaEncontrada.getPrecioUnitario());
        } else {
            System.out.println("No se encontró la madera con nombre: " + nombreMadera);
        }
    }
    
    }
    
   
        
        
        
        
    
        
        
        
    

