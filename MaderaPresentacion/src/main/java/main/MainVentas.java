/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import Funcionamiento.UsuarioVentaSS;
import PantallasVenta.IniciarSesionVendedor;
import funcionamiento.MaderaVentaSS;
import interfaz.IMaderaVentaSS;
import interfaz.IUsuarioVentaSS;

/**
 *
 * @author aleja
 */
public class MainVentas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IUsuarioVentaSS iUsuarioVentaSS = new UsuarioVentaSS();
        IMaderaVentaSS maderaVentaSS = new MaderaVentaSS();
        IniciarSesionVendedor inicioVendedor = new IniciarSesionVendedor(iUsuarioVentaSS, maderaVentaSS);
        inicioVendedor.setVisible(true);
    }
    
}
