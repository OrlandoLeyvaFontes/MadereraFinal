/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import Pantallas2.IniciarSesion;
import dto.MaderaDTO;
import funcionalidad.CarritoSS;
import funcionalidad.CompraSS;
import funcionalidad.MaderaSS;
import funcionalidad.UsuarioSS;
import interfaz.ICarritoSS;
import interfaz.ICompraSS;
import interfaz.IMaderaSS;
import interfaz.IUsuarioSS;

/**
 *
 * @author Oley
 */
public class Main2 {
    public static void main(String[] args) {
        IUsuarioSS iUsuarioSS=new UsuarioSS();
        IMaderaSS  iMaderaSS=new MaderaSS();
        ICarritoSS iCarritoSS=new CarritoSS();
        ICompraSS iCompraSS=new CompraSS();
        
        
//        
//           MaderaDTO maderaDTO2 = new MaderaDTO("Roble", "Madera de roble para muebles", 30, 250.75);
//        iMaderaSS.agregarMadera(maderaDTO2);
//        MaderaDTO maderaDTO3 = new MaderaDTO("Cedro", "Madera de cedro para decoración", 100, 350.0);
//        iMaderaSS.agregarMadera(maderaDTO3);
        
        
        IniciarSesion iniciarSesion=new IniciarSesion(iUsuarioSS, iMaderaSS,iCarritoSS,iCompraSS);
        iniciarSesion.setVisible(true);
    }
}
