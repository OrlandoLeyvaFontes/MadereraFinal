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
import negocio.UsuarioNegocio;
import negocio.VentaNegocio;

/**
 *
 * @author Oley
 */
public class Main {
    public static void main(String[] args) {
        VentaNegocio ventaNegocio = new VentaNegocio();

        List<VentaDTO> ventas = ventaNegocio.obtenerVentas();

        System.out.println("Lista de ventas:");
        for (VentaDTO venta : ventas) {
            System.out.println("ID Venta: " + venta.getId());
            System.out.println("Cantidad: " + venta.getCantidad());
            System.out.println("Precio Total: " + venta.getPrecioTotal());
            System.out.println("Fecha Venta: " + venta.getFechaVenta());

            if (venta.getMadera() != null) {
                System.out.println("Madera ID: " + venta.getMadera().getId());
                System.out.println("Madera Nombre: " + venta.getMadera().getNombre());
                System.out.println("Precio Unitario: " + venta.getMadera().getPrecioUnitario());
            } else {
                System.out.println("Madera: N/A");
            }

            if (venta.getUsuario() != null) {
                System.out.println("Usuario ID: " + venta.getUsuario().getId());
                System.out.println("Usuario Nombre: " + venta.getUsuario().getNombre());
            } else {
                System.out.println("Usuario: N/A");
            }

            System.out.println("-----------------------------------");
        }
    
    }
    
   
        
        
        
        
    }
        
        
        
    

