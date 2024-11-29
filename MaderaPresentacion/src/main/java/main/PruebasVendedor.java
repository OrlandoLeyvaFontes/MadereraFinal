/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import Interfaz.IMaderaVentaSS;
import PantallasVenta.IniciarSesionVendedor;
import funcionamiento.MaderaVentaSS;
import funcionamiento.UsuarioVentaSS;
import interfacesDTO.IUsuarioVentasNegocio;
import interfaz.IUsuarioVentaSS;
import negocio.UsuarioVentasNegocio;

/**
 *
 * @author aleja
 */
public class PruebasVendedor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IUsuarioVentaSS iUsuarioVentaSS =  new UsuarioVentaSS();
        IMaderaVentaSS maderaVentaSS = new MaderaVentaSS();
        IniciarSesionVendedor inicioVendedor = new IniciarSesionVendedor(iUsuarioVentaSS,maderaVentaSS);
        
        
        
        inicioVendedor.setVisible(true);
    }

}
