/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import Funcionamiento.UsuarioVentaSS;
import Pantallas2.AdminYusario;
import funcionalidad.CarritoSS;
import funcionalidad.CompraSS;
import funcionalidad.MaderaSS;
import funcionalidad.UsuarioSS;
import funcionamiento.MaderaVentaSS;
import interfaz.ICarritoSS;
import interfaz.ICompraSS;
import interfaz.IMaderaSS;
import interfaz.IMaderaVentaSS;
import interfaz.IUsuarioSS;
import interfaz.IUsuarioVentaSS;

/**
 *
 * @author Oley
 */
public class MainPrincipal {
        
        public static void main(String[] args) {
          IUsuarioVentaSS iUsuarioVentaSS = new UsuarioVentaSS();
        IMaderaVentaSS maderaVentaSS = new MaderaVentaSS();
         IUsuarioSS iUsuarioSS=new UsuarioSS();
        IMaderaSS  iMaderaSS=new MaderaSS();
        ICarritoSS iCarritoSS=new CarritoSS();
        ICompraSS iCompraSS=new CompraSS();
        
        AdminYusario adminYusario=new AdminYusario(iUsuarioSS, iMaderaSS, iCarritoSS, iCompraSS, iUsuarioVentaSS, maderaVentaSS);
        adminYusario.setVisible(true);
    }
}
