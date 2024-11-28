/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import PantallasVenta.IniciarSesionVendedor;
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
        IniciarSesionVendedor inicioVendedor = new IniciarSesionVendedor(iUsuarioVentaSS);
        inicioVendedor.setVisible(true);
    }

}
