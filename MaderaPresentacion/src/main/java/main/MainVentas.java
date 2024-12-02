/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import Funcionamiento.EntradaSS;
import Funcionamiento.UsuarioVentaSS;
import PantallasVenta.IniciarSesionVendedor;
import funcionamiento.MaderaVentaSS;
import interfaz.IEntradaSS;
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
        IEntradaSS iEntradaSS = new EntradaSS();
        IniciarSesionVendedor inicioVendedor = new IniciarSesionVendedor(iUsuarioVentaSS, maderaVentaSS, iEntradaSS);
        inicioVendedor.setVisible(true);
    }
    
}
