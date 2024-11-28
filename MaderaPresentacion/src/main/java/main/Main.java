/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import Funcionalidad.AgregarTarjetasSS;
import dto.MaderaDTO;
import funcionalidad.AgregarMaderaSS;
import funcionalidad.AgregarProductoCarritoSS;
import funcionalidad.AgregarUsuarioSS;
import funcionalidad.BuscarMaderaPorIDSS;
import funcionalidad.ComprarCarritoSS;
import funcionalidad.EliminarProductoCarritoSS;
import funcionalidad.GuardarCompraSS;
import funcionalidad.InicioDeSesionSS;
import funcionalidad.InicioSesionCVVSS;
import funcionalidad.ObtenerCarritoSS;
import funcionalidad.ObtenerMaderasSS;
import funcionalidad.ObtenerNumerosTarjetasPorUsuarioSS;
import funcionalidad.ObtenerVentasSS;
import interfacesDTO.IUsuarioNegocio;
import interfaz.IAgregarProductoCarritoSS;
import interfaz.IComprarCarritoSS;
import interfaz.IEliminarProductoCarritoSS;
import interfaz.IGuardarCompraSS;
import interfaz.IInicioSesionCVVSS;
import interfaz.IObtenerCarritoSS;
import interfaz.IObtenerNumerosTarjetasPorUsuarioSS;
import interfaz.IObtenerVentasSS;
import interfazSS.IAgregarMaderaSS;
import interfazSS.IAgregarTarjetasSS;
import interfazSS.IAgregarUsuarioSS;
import interfazSS.IBuscarMaderaPorIDSS;
import interfazSS.IInicioSesionSS;
import interfazSS.IObtenerMaderas;
import negocio.UsuarioNegocio;
import pantallas.IniciarSesion;

/**
 *
 * @author Oley
 */
public class Main {

    public static void main(String[] args) {
        IObtenerNumerosTarjetasPorUsuarioSS iObtenerNumerosTarjetasPorUsuarioSS=new ObtenerNumerosTarjetasPorUsuarioSS();
        IInicioSesionSS iInicioSesionSS = new InicioDeSesionSS();
        IAgregarUsuarioSS agregarUsuarioSS = new AgregarUsuarioSS();
        IAgregarMaderaSS agregarMaderaSS = new AgregarMaderaSS();
        IAgregarTarjetasSS agregarTarjetasSS=new AgregarTarjetasSS();
        IObtenerMaderas iObtenerMaderas=new ObtenerMaderasSS();
        IBuscarMaderaPorIDSS buscarMaderaPorIDSS=new BuscarMaderaPorIDSS();
        IInicioSesionCVVSS  iInicioSesionCVVSS=new InicioSesionCVVSS();
        IAgregarProductoCarritoSS iAgregarProductoCarritoSS=new AgregarProductoCarritoSS();
        IObtenerCarritoSS iObtenerCarritoSS=new ObtenerCarritoSS();
        IEliminarProductoCarritoSS iEliminarProductoCarritoSS=new EliminarProductoCarritoSS();
        IComprarCarritoSS iComprarCarritoSS=new ComprarCarritoSS();
        IObtenerVentasSS iObtenerVentasSS=new ObtenerVentasSS();
        
        MaderaDTO maderaDTO1 = new MaderaDTO("Pino", "Madera de pino para construcción", 50, 120.5);
        agregarMaderaSS.agregarMadera(maderaDTO1);
IGuardarCompraSS iGuardarCompraSS=new GuardarCompraSS();
        MaderaDTO maderaDTO2 = new MaderaDTO("Roble", "Madera de roble para muebles", 30, 250.75);
        agregarMaderaSS.agregarMadera(maderaDTO2);
        MaderaDTO maderaDTO3 = new MaderaDTO("Cedro", "Madera de cedro para decoración", 100, 350.0);
        agregarMaderaSS.agregarMadera(maderaDTO3);
        MaderaDTO maderaDTO4 = new MaderaDTO("Abeto", "Madera de abeto para estructuras", 75, 150.25);
        agregarMaderaSS.agregarMadera(maderaDTO4);
        MaderaDTO maderaDTO5 = new MaderaDTO("Nogal", "Madera de nogal para ebanistería", 20, 500.0);
        agregarMaderaSS.agregarMadera(maderaDTO5);
        MaderaDTO maderaDTO6 = new MaderaDTO("Cerezo", "Madera de cerezo para acabados finos", 40, 420.0);
        agregarMaderaSS.agregarMadera(maderaDTO6);

        IniciarSesion inicio = new IniciarSesion(agregarUsuarioSS, iInicioSesionSS,agregarTarjetasSS,iObtenerMaderas,buscarMaderaPorIDSS,iObtenerNumerosTarjetasPorUsuarioSS
        ,iInicioSesionCVVSS,iGuardarCompraSS,iAgregarProductoCarritoSS,iObtenerCarritoSS,iEliminarProductoCarritoSS,iComprarCarritoSS,iObtenerVentasSS
);
        inicio.setVisible(true);

    }
}
