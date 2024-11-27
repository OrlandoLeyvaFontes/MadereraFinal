/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import PantallasVenta.IniciarSesionVendedor;
import funcionalidad.InicioSesionVentaSS;
import funcionamiento.RegistroUsuarioVentaSS;
import intefazSS.IInicioSesionVentaSS;
import interfacesDTO.IUsuarioVentasNegocio;
import interfaz.IRegistroUsuarioVentaSS;
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
        IInicioSesionVentaSS iInicioSesionVentaSS = new InicioSesionVentaSS();
        IRegistroUsuarioVentaSS iRegistroUsuarioVentaSS = new RegistroUsuarioVentaSS();
        IniciarSesionVendedor inicioVendedor = new IniciarSesionVendedor(iInicioSesionVentaSS, iRegistroUsuarioVentaSS);
        inicioVendedor.setVisible(true);
    }

}
