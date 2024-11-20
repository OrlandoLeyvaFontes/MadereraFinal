/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import dto.CompraDTO;
import dto.MaderaDTO;
import dto.UsuarioDTO;
import interfacesDTO.ICompraNegocio;
import interfacesDTO.IUsuarioNegocio;
import java.util.Calendar;
import negocio.CompraNegocio;
import negocio.UsuarioNegocio;

/**
 *
 * @author Oley
 */
public class Main {
    public static void main(String[] args) {
        ICompraNegocio compraNegocio = new CompraNegocio();

        CompraDTO compraDTO = new CompraDTO();
        compraDTO.setFechaCompra(Calendar.getInstance());  
        compraDTO.setCantidad(5);  

        MaderaDTO maderaDTO = new MaderaDTO();
        maderaDTO.setId("673854a7673d5472ce4f0e80");  
        compraDTO.setMadera(maderaDTO);

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId("673854b1673d5472ce4f0e84");  
        compraDTO.setUsuario(usuarioDTO);

        compraNegocio.guardarCompra(compraDTO);
    
    }
    
   
        
        
        
        
    }
        
        
        
    

